package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.view.model.GraphDaily;
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
		/*for (KpiDaily row : list) {
			double res = row.getS() + row.getEe() + row.getDr() + row.getRa()
					+ row.getFh() + row.getCa() + row.getLu() + row.getTr()
					+ row.getFp() + row.getCn() + row.getFc() + row.getRt();
			listPlan[index] = res;
			if (res > 23d) {
				style[index] = "style1";
			} else {
				style[index] = "style2";
			}
			index++;
		}*/

		reportDaily.setListPlan(listPlan);
		reportDaily.setStyle(style);
		listResult.add(reportDaily);
		id++;

		return listResult;
	}

	public JSONArray getGraphDaily(BigDecimal idKpiWeek) {
		JSONArray result = new JSONArray();

		List<KpiDaily> list = dao.find("from KpiDaily o where o.kpiWeek.id = "
				+ idKpiWeek + " order by o.currentDay");
		int lastIndex = list.size() - 1;
		List<GraphDaily> listDelay = new ArrayList<GraphDaily>();
		if (lastIndex >= 0) {
			KpiDaily lastRow = list.get(lastIndex);
			GraphDaily graphDaily;
			double sum = 0;

			/*if (lastRow.getS() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Seguridad");
				graphDaily.setValue(lastRow.getS());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getS();
			}

			if (lastRow.getEe() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Entrega Equipo");
				graphDaily.setValue(lastRow.getEe());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getEe();
			}

			if (lastRow.getDr() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Disp. Repuesto");
				graphDaily.setValue(lastRow.getDr());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getDr();
			}

			if (lastRow.getRa() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Reasig. Trabajo");
				graphDaily.setValue(lastRow.getRa());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getRa();
			}

			if (lastRow.getFh() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Falta Herram.");
				graphDaily.setValue(lastRow.getFh());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getFh();
			}

			if (lastRow.getCa() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Cambio Alcace Trab.");
				graphDaily.setValue(lastRow.getCa());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getCa();
			}

			if (lastRow.getLu() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Camión Lubricador");
				graphDaily.setValue(lastRow.getLu());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getLu();
			}

			if (lastRow.getTr() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Tronadura");
				graphDaily.setValue(lastRow.getTr());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getTr();
			}

			if (lastRow.getFp() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Falta de Personal");
				graphDaily.setValue(lastRow.getFp());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getFp();
			}

			if (lastRow.getCn() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Causas Naturales");
				graphDaily.setValue(lastRow.getCn());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getCn();
			}

			if (lastRow.getFc() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Falta de Conoc.");
				graphDaily.setValue(lastRow.getFc());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getFc();
			}

			if (lastRow.getRt() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Retrabajo");
				graphDaily.setValue(lastRow.getRt());
				listDelay.add(graphDaily);
				sum = sum + lastRow.getRt();
			}

			Collections.sort(listDelay, new Comparator<Object>() {
				public int compare(Object o1, Object o2) {
					GraphDaily g1 = (GraphDaily) o1;
					GraphDaily g2 = (GraphDaily) o2;
					return g2.getValue().compareTo(g1.getValue());
				}
			});

			double oldAvg = 0;
			for (GraphDaily row : listDelay) {
				JSONObject obj = new JSONObject();
				try {
					obj.put("label", row.getLabel());
					obj.put("value", row.getValue());
					double avg = oldAvg + (row.getValue() / sum) ;
					obj.put("avg", avg);
					result.put(obj);
					oldAvg = avg;
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}*/

		} else {

		}

		return result;
	}
}
