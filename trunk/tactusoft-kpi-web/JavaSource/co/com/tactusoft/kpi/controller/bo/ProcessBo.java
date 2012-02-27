package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiDailySumHours;
import co.com.tactusoft.kpi.model.entities.KpiLastDayWeek;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.view.model.ReportDaily;

@Service
@Scope("singleton")
public class ProcessBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Resource
	private CustomHibernateDao dao;

	public List<KpiWeek> getListKpiKpiWeek40() {
		return dao.find("from KpiWeek o where state = 40");
	}

	public List<KpiDaily> getListKpiDailyByWeek(BigDecimal kpiWeek) {
		return dao.find("from KpiDaily o where kpiWeek.id = " + kpiWeek
				+ " order by o.currentDay");
	}

	public BigDecimal getId(String clasz) {
		return dao.getId(clasz);
	}

	public void save(Object entity) {
		dao.persist(entity);
	}

	public List<ReportDaily> getReportDaily(BigDecimal idKpiWeek) {
		List<KpiDaily> list = dao.find("from KpiDaily o where o.kpiWeek.id = "
				+ idKpiWeek + " order by o.currentDay");

		int id = 0;
		int index;
		List<ReportDaily> listResult = new ArrayList<ReportDaily>();
		ReportDaily reportDaily;
		Double[] listPlan;
		String[] style;

		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		reportDaily.setMetric("Cumplimiento Programa Diario OT");
		reportDaily.setUm("%");
		reportDaily.setType("Plan");

		listPlan = new Double[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			// double scheduledOrders = row.getScheduledOrders();
			// if (scheduledOrders != 0d) {
			// double finishedOrders = row.getFinishedOrders();
			// double res = finishedOrders / scheduledOrders;
			listPlan[index] = 0.8;
			index++;
			// }
		}

		reportDaily.setListPlan(listPlan);
		listResult.add(reportDaily);
		id++;

		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		// reportDaily.setMetric("Cumplimiento Programa Semanal HH");
		reportDaily.setUm("%");
		reportDaily.setType("Actual");

		listPlan = new Double[list.size()];
		style = new String[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			double scheduledOrders = row.getScheduledOrders();
			if (scheduledOrders != 0d) {
				double finishedOrders = row.getFinishedOrders();
				double res = finishedOrders / scheduledOrders;
				listPlan[index] = res;
				if (res < 0.8) {
					style[index] = "style1";
				} else {
					style[index] = "style2";
				}

				index++;
			}
		}

		reportDaily.setListPlan(listPlan);
		reportDaily.setStyle(style);
		listResult.add(reportDaily);
		id++;

		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		reportDaily.setMetric("Imprevistos");
		reportDaily.setUm("%");
		reportDaily.setType("Plan");

		listPlan = new Double[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			listPlan[index] = 0.2;
			index++;
		}

		reportDaily.setListPlan(listPlan);
		listResult.add(reportDaily);
		id++;

		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		// reportDaily.setMetric("Imprevistos");
		reportDaily.setUm("%");
		reportDaily.setType("Actual");

		listPlan = new Double[list.size()];
		style = new String[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			double finishedOrders = row.getFinishedOrders();
			double failuresOrders = row.getFailuresOrders();
			if ((finishedOrders - failuresOrders) != 0d) {
				double res = failuresOrders / (failuresOrders + finishedOrders);
				listPlan[index] = res;
				if (res < 0.2) {
					style[index] = "style1";
				} else {
					style[index] = "style2";
				}
				index++;
			}
		}

		reportDaily.setListPlan(listPlan);
		reportDaily.setStyle(style);
		listResult.add(reportDaily);
		id++;

		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		reportDaily.setMetric("Demoras");
		reportDaily.setUm("Hr");
		reportDaily.setType("Plan");

		listPlan = new Double[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			listPlan[index] = 23d;
			index++;
		}

		reportDaily.setListPlan(listPlan);
		listResult.add(reportDaily);
		id++;

		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		// reportDaily.setMetric("Demoras");
		reportDaily.setUm("Hr");
		reportDaily.setType("Actual");

		listPlan = new Double[list.size()];
		style = new String[list.size()];
		index = 0;

		for (KpiDaily row : list) {
			BigDecimal res = (BigDecimal) dao.find(
					"select sum(o.numHours) from KpiDailyDelay o where o.kpiDaily.id = "
							+ row.getId()).get(0);

			listPlan[index] = res.doubleValue();
			if (res.doubleValue() > 23d) {
				style[index] = "style1";
			} else {
				style[index] = "style2";
			}
			index++;
		}

		reportDaily.setListPlan(listPlan);
		reportDaily.setStyle(style);
		listResult.add(reportDaily);
		id++;

		return listResult;
	}

	public JSONArray getGraphDaily(BigDecimal idKpiWeek) {
		JSONArray result = new JSONArray();

		KpiLastDayWeek lastRow = (KpiLastDayWeek) dao.find(
				"from KpiLastDayWeek o where o.idWeek = " + idKpiWeek).get(0);

		List<KpiDailySumHours> listDailyDelay = dao
				.find("from KpiDailySumHours o where o.idDaily = "
						+ lastRow.getId());

		double sum = 0;
		for (KpiDailySumHours row : listDailyDelay) {
			sum = sum + row.getNumHours().doubleValue();
		}

		double oldAvg = 0;
		for (KpiDailySumHours row : listDailyDelay) {
			JSONObject obj = new JSONObject();
			try {
				obj.put("label", row.getNameDaily());
				obj.put("value", row.getNumHours().doubleValue());
				double avg = oldAvg + (row.getNumHours().doubleValue() / sum);
				obj.put("avg", avg);
				result.put(obj);
				oldAvg = avg;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
}
