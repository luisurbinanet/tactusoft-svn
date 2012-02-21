package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.json.JSONArray;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.ProcessBo;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.view.model.ColumnModel;
import co.com.tactusoft.kpi.view.model.ReportDaily;
import co.com.tactusoft.kpi.view.model.ReportDailyModel;

@Controller
@Scope("session")
public class ReportBacking implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Resource
	private ProcessBo service;

	private ReportDailyModel model = new ReportDailyModel();
	private List<ColumnModel> columns = new ArrayList<ColumnModel>();

	private List<SelectItem> listItemWeeks;
	private Map<BigDecimal, KpiWeek> mapKpiWeek = new HashMap<BigDecimal, KpiWeek>();
	private BigDecimal idKpiWeek;

	private CartesianChartModel categoryModel;
	private JSONArray graphData;

	public ReportBacking() {

	}

	public ReportDailyModel getModel() {
		return model;
	}

	public void setModel(ReportDailyModel model) {
		this.model = model;
	}

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	public List<SelectItem> getListItemWeeks() {
		if (listItemWeeks == null) {
			listItemWeeks = new ArrayList<SelectItem>();

			List<KpiWeek> list = service.getListKpiKpiWeek40();

			for (KpiWeek row : list) {
				SelectItem item = new SelectItem();
				item.setValue(row.getId());

				SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"dd/MM/yyyy");
				String startDate = sdf.format(row.getStartDate());
				String endDate = sdf.format(row.getEndDate());
				String label = row.getName() + ": " + startDate + " - "
						+ endDate;

				item.setLabel(label);

				listItemWeeks.add(item);

				mapKpiWeek.put(row.getId(), row);
			}

			if (listItemWeeks.size() > 0) {
				this.idKpiWeek = list.get(0).getId();
			}

			model = new ReportDailyModel();
		}
		return listItemWeeks;
	}

	public void setListItemWeeks(List<SelectItem> listItemWeeks) {
		this.listItemWeeks = listItemWeeks;
	}

	public BigDecimal getIdKpiWeek() {
		return idKpiWeek;
	}

	public void setIdKpiWeek(BigDecimal idKpiWeek) {
		this.idKpiWeek = idKpiWeek;
	}

	public CartesianChartModel getCategoryModel() {
		if (categoryModel == null) {
			categoryModel = new CartesianChartModel();

			ChartSeries test = new ChartSeries();
			test.setLabel("-- SIN INFORMACION -- ");

			categoryModel.addSeries(test);
			test.set("", 0);
		}
		return categoryModel;
	}

	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public JSONArray getGraphData() {
		return graphData;
	}

	public void setGraphData(JSONArray graphData) {
		this.graphData = graphData;
	}

	public void generateAction(ActionEvent actionEvent) {
		List<KpiDaily> list = service.getListKpiDailyByWeek(idKpiWeek);
		columns = new ArrayList<ColumnModel>();

		for (KpiDaily row : list) {
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MMM");
			String date = sdf.format(row.getCurrentDay());

			columns.add(new ColumnModel(date, "listPlan"));
		}

		List<ReportDaily> data = service.getReportDaily(idKpiWeek);
		model = new ReportDailyModel(data);
		graphData = service.getGraphDaily(idKpiWeek);
	}

}
