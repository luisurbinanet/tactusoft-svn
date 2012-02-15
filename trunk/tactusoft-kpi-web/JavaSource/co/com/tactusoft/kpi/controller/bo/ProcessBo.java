package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.primefaces.model.chart.ChartSeries;
import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
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
		ReportDaily reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		reportDaily.setMetric("Cumplimiento Programa Semanal HH");
		reportDaily.setUm("%");
		reportDaily.setType("Actual");

		Double[] listPlan = new Double[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			double scheduledOrders = row.getScheduledOrders();
			if (scheduledOrders != 0d) {
				double finishedOrders = row.getFinishedOrders();
				double res = finishedOrders / scheduledOrders;
				listPlan[index] = res;
				index++;
			}
		}
		
		reportDaily.setListPlan(listPlan);
		listResult.add(reportDaily);
		id++;
		
		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		//reportDaily.setMetric("Cumplimiento Programa Semanal HH");
		reportDaily.setUm("%");
		reportDaily.setType("Plan");

		listPlan = new Double[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			//double scheduledOrders = row.getScheduledOrders();
			//if (scheduledOrders != 0d) {
				//double finishedOrders = row.getFinishedOrders();
				//double res = finishedOrders / scheduledOrders;
				listPlan[index] = 0.8;
				index++;
			//}
		}

		reportDaily.setListPlan(listPlan);
		listResult.add(reportDaily);
		id++;

		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		reportDaily.setMetric("Imprevistos");
		reportDaily.setUm("%");
		reportDaily.setType("Actual");

		listPlan = new Double[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			double finishedOrders = row.getFinishedOrders();
			double failuresOrders = row.getFailuresOrders();
			if ((finishedOrders - failuresOrders) != 0d) {
				double res = failuresOrders / (failuresOrders + finishedOrders);
				listPlan[index] = res;
				index++;
			}
		}

		reportDaily.setListPlan(listPlan);
		listResult.add(reportDaily);
		id++;

		reportDaily = new ReportDaily();
		reportDaily.setId(new BigDecimal(id));
		reportDaily.setMetric("Demoras");
		reportDaily.setUm("Hr");
		reportDaily.setType("Actual");

		listPlan = new Double[list.size()];
		index = 0;
		for (KpiDaily row : list) {
			double res = row.getS() + row.getEe() + row.getDr() + row.getRa()
					+ row.getFh() + row.getCa() + row.getLu() + row.getTr()
					+ row.getFp() + row.getCn() + row.getFc() + row.getRt();
			listPlan[index] = res;
			index++;
		}

		reportDaily.setListPlan(listPlan);
		listResult.add(reportDaily);
		id++;

		return listResult;
	}
	
	public ChartSeries getGraphDaily(BigDecimal idKpiWeek) {
		ChartSeries chartSeries  = new ChartSeries();
		
		List<KpiDaily> list = dao.find("from KpiDaily o where o.kpiWeek.id = "
				+ idKpiWeek + " order by o.currentDay");
		int lastIndex  = list.size() - 1;
		
		KpiDaily lastRow = list.get(lastIndex);
		chartSeries.setLabel("Códigos de Demora");
		chartSeries.set("Seguridad", lastRow.getS());
		chartSeries.set("Entrega Equipo", lastRow.getEe());
		chartSeries.set("Disp. Repuesto", lastRow.getDr());
		chartSeries.set("Reasig. Trabajo", lastRow.getRa());
		
		chartSeries.set("Falta Herram.", lastRow.getFh());
		chartSeries.set("Cambio Alcace Trab.", lastRow.getCa());
		chartSeries.set("Camión Lubricador", lastRow.getLu());
		chartSeries.set("Tronadura", lastRow.getTr());
		
		chartSeries.set("Falta de Personal", lastRow.getFp());
		chartSeries.set("Causas Naturales", lastRow.getCn());
		chartSeries.set("Falta de Conoc.", lastRow.getFc());
		chartSeries.set("Retrabajo", lastRow.getRt());
		
		return chartSeries;
	}
}
