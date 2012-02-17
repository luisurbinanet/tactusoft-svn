package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.view.model.GraphDaily;
import co.com.tactusoft.kpi.view.model.ReportDaily;

@Service
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
		reportDaily.setMetric("Cumplimiento Programa Semanal HH");
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
			double res = row.getS() + row.getEe() + row.getDr() + row.getRa()
					+ row.getFh() + row.getCa() + row.getLu() + row.getTr()
					+ row.getFp() + row.getCn() + row.getFc() + row.getRt();
			listPlan[index] = res;
			if (res < 23d) {
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

	public String getGraphDaily(BigDecimal idKpiWeek) {
		StringBuffer data = new StringBuffer();
		// ChartSeries chartSeries = new ChartSeries();

		List<KpiDaily> list = dao.find("from KpiDaily o where o.kpiWeek.id = "
				+ idKpiWeek + " order by o.currentDay");
		int lastIndex = list.size() - 1;
		List<GraphDaily> listDelay = new ArrayList<GraphDaily>();
		if (lastIndex >= 0) {
			KpiDaily lastRow = list.get(lastIndex);
			GraphDaily graphDaily;

			if (lastRow.getS() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Seguridad");
				graphDaily.setValue(lastRow.getS());
				listDelay.add(graphDaily);
			}

			if (lastRow.getEe() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Entrega Equipo");
				graphDaily.setValue(lastRow.getEe());
				listDelay.add(graphDaily);
			}

			if (lastRow.getDr() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Disp. Repuesto");
				graphDaily.setValue(lastRow.getDr());
				listDelay.add(graphDaily);
			}

			if (lastRow.getRa() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Reasig. Trabajo");
				graphDaily.setValue(lastRow.getRa());
				listDelay.add(graphDaily);
			}

			if (lastRow.getFh() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Falta Herram.");
				graphDaily.setValue(lastRow.getFh());
				listDelay.add(graphDaily);
			}

			if (lastRow.getCa() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Cambio Alcace Trab.");
				graphDaily.setValue(lastRow.getCa());
				listDelay.add(graphDaily);
			}

			if (lastRow.getLu() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Camión Lubricador");
				graphDaily.setValue(lastRow.getLu());
				listDelay.add(graphDaily);
			}

			if (lastRow.getTr() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Tronadura");
				graphDaily.setValue(lastRow.getTr());
				listDelay.add(graphDaily);
			}

			if (lastRow.getFp() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Falta de Personal");
				graphDaily.setValue(lastRow.getFp());
				listDelay.add(graphDaily);
			}

			if (lastRow.getCn() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Causas Naturales");
				graphDaily.setValue(lastRow.getCn());
				listDelay.add(graphDaily);
			}

			if (lastRow.getFc() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Falta de Conoc.");
				graphDaily.setValue(lastRow.getFc());
				listDelay.add(graphDaily);
			}

			if (lastRow.getRt() > 0d) {
				graphDaily = new GraphDaily();
				graphDaily.setLabel("Retrabajo");
				graphDaily.setValue(lastRow.getRt());
				listDelay.add(graphDaily);
			}

			Collections.sort(listDelay, new Comparator<Object>() {
				public int compare(Object o1, Object o2) {
					GraphDaily g1 = (GraphDaily) o1;
					GraphDaily g2 = (GraphDaily) o2;
					return g2.getValue().compareTo(g1.getValue());
				}
			});

			data.append("data.addRows(" + listDelay.size() + ");");
			data.append("data.addColumn('string', 'codigo');");
			data.append("data.addColumn('number', 'Demoras');");
			data.append("data.addColumn('number', 'Promedio');");

			for (int index = 0; index < listDelay.size(); index++) {
				GraphDaily object = listDelay.get(index);
				data.append("data.setValue(" + index + ", 0, '"
						+ object.getLabel() + "');");
				data.append("data.setValue(" + index + ", 1, "
						+ object.getValue() + ");");
			}

		} else {
			data.append("data.addRows(0);");
			data.append("data.addColumn('string', 'codigo');");
			data.append("data.addColumn('number', 'Demoras');");
			data.append("data.addColumn('number', 'Promedio');");
		}

		return data.toString();
	}
}
