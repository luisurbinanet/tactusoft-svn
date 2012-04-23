package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiDailySumHours;
import co.com.tactusoft.kpi.model.entities.KpiHeaderData;
import co.com.tactusoft.kpi.model.entities.KpiLastDayWeek;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.util.Constant;
import co.com.tactusoft.kpi.view.model.ReportDaily;

@Named
public class ProcessBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
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
		List<ReportDaily> listResult = new ArrayList<ReportDaily>();
		BigDecimal idCompany = new BigDecimal(1);

		List<KpiHeaderData> listKpi = dao
				.find("from KpiHeaderData o where o.kpiHeader.kpiCompany.id = "
						+ idCompany + " order by o.korder");

		List<KpiDaily> list = dao.find("from KpiDaily o where o.kpiWeek.id = "
				+ idKpiWeek + " order by o.currentDay");

		ReportDaily reportDaily;
		for (KpiHeaderData row : listKpi) {
			BigDecimal id = row.getId();
			String metric = row.getKpiData().getName();
			Double planAttainment = row.getKpiData().getPlanAttainment()
					.doubleValue();

			reportDaily = new ReportDaily();
			reportDaily.setId(id);
			reportDaily.setMetric(metric);
			reportDaily.setUm(row.getKpiData().getUnit());
			reportDaily.setType("Plan");

			Double[] listPlan = new Double[list.size()];
			int index;
			for (index = 0; index < list.size(); index++) {
				listPlan[index] = planAttainment;
			}

			reportDaily.setListPlan(listPlan);
			listResult.add(reportDaily);

			reportDaily = new ReportDaily();
			reportDaily.setId(id);
			reportDaily.setMetric("");
			reportDaily.setUm(row.getKpiData().getUnit());
			reportDaily.setType("Actual");

			index = 0;
			listPlan = new Double[list.size()];
			String[] style = new String[list.size()];
			switch (row.getKpiData().getCalculatioType()) {
			case Constant.CALCULATION_TYPE_1:
				for (KpiDaily rowDetail : list) {
					double scheduledOrders = rowDetail.getScheduledOrders();
					if (scheduledOrders != 0d) {
						double finishedOrders = rowDetail.getFinishedOrders();
						double res = finishedOrders / scheduledOrders;
						listPlan[index] = res;

						if (res < planAttainment) {
							style[index] = "style1";
						} else {
							style[index] = "style2";
						}

						index++;
					}
				}
				break;
			case Constant.CALCULATION_TYPE_2:
				for (KpiDaily rowDetail : list) {
					double finishedOrders = rowDetail.getFinishedOrders();
					double failuresOrders = rowDetail.getFailuresOrders();
					if ((finishedOrders - failuresOrders) != 0d) {
						double res = failuresOrders
								/ (failuresOrders + finishedOrders);
						listPlan[index] = res;
						if (res > planAttainment) {
							style[index] = "style1";
						} else {
							style[index] = "style2";
						}
						index++;
					}
				}
				break;
			case Constant.CALCULATION_TYPE_3:
				for (KpiDaily rowDetail : list) {
					BigDecimal res = (BigDecimal) dao.find(
							"select sum(o.numHours) from KpiDailyDelay o where o.kpiDaily.id = "
									+ rowDetail.getId()).get(0);

					listPlan[index] = res.doubleValue();
					if (res.doubleValue() > planAttainment) {
						style[index] = "style1";
					} else {
						style[index] = "style2";
					}
					index++;
				}
				break;
			}

			reportDaily.setListPlan(listPlan);
			reportDaily.setStyle(style);
			listResult.add(reportDaily);

		}

		return listResult;
	}

	public JSONArray getGraphDaily(BigDecimal idKpiWeek) {
		JSONArray result = new JSONArray();

		try {

			KpiLastDayWeek lastRow = (KpiLastDayWeek) dao.find(
					"from KpiLastDayWeek o where o.idWeek = " + idKpiWeek).get(
					0);

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
					double avg = oldAvg
							+ (row.getNumHours().doubleValue() / sum);
					obj.put("avg", avg);
					result.put(obj);
					oldAvg = avg;
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception ex) {

		}

		return result;
	}
}
