package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.ProcessBo;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.KpiDailyModel;

@Controller
@Scope("session")
public class KpiDailyBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private ProcessBo service;

	private KpiDailyModel model;
	private KpiDaily selected;

	private List<SelectItem> listCalendarWeeks;
	private BigDecimal kpiWeekSelected;
	private List<SelectItem> listDays;
	private BigDecimal kpiDailySelected;

	private Date minDate;
	private Date maxDate;

	private Map<BigDecimal, KpiWeek> mapKpiWeek = new HashMap<BigDecimal, KpiWeek>();
	private Map<BigDecimal, KpiDaily> mapKpiDaily = new HashMap<BigDecimal, KpiDaily>();

	public KpiDailyBacking() {
		selected = new KpiDaily();
	}

	public KpiDailyModel getModel() {
		return model;
	}

	public void setModel(KpiDailyModel model) {
		this.model = model;
	}

	public KpiDaily getSelected() {
		return selected;
	}

	public void setSelected(KpiDaily selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListDays() {
		return listDays;
	}

	public void setListDays(List<SelectItem> listDays) {
		this.listDays = listDays;
	}

	public BigDecimal getKpiDailySelected() {
		return kpiDailySelected;
	}

	public void setKpiDailySelected(BigDecimal kpiDailySelected) {
		this.kpiDailySelected = kpiDailySelected;
	}

	public List<SelectItem> getListCalendarWeeks() {
		if (listCalendarWeeks == null) {
			listCalendarWeeks = new ArrayList<SelectItem>();

			List<KpiWeek> list = service.getListKpiKpiWeek40();

			for (KpiWeek row : list) {
				SelectItem item = new SelectItem();
				item.setValue(row.getId());
				
				SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
				String startDate = sdf.format(row.getStartDate());
				String endDate = sdf.format(row.getEndDate());
				String label = row.getName() + ": " + startDate + " - " + endDate;
				
				item.setLabel(label);

				listCalendarWeeks.add(item);

				mapKpiWeek.put(row.getId(), row);
			}

			if (listCalendarWeeks.size() > 0) {
				this.kpiWeekSelected = list.get(0).getId();
				this.minDate = mapKpiWeek.get(kpiWeekSelected).getStartDate();
				this.maxDate = mapKpiWeek.get(kpiWeekSelected).getEndDate();
				model = new KpiDailyModel(
						service.getListKpiDailyByWeek(kpiWeekSelected));
				handleWeekChange();
			}
		}
		return listCalendarWeeks;
	}

	public void setListCalendarWeeks(List<SelectItem> listCalendarWeeks) {
		this.listCalendarWeeks = listCalendarWeeks;
	}

	public BigDecimal getKpiWeekSelected() {
		return kpiWeekSelected;
	}

	public void setKpiWeekSelected(BigDecimal kpiWeekSelected) {
		this.kpiWeekSelected = kpiWeekSelected;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public void searchAction() {

	}

	public void newAction() {
		selected = new KpiDaily();
	}

	public void deleteAction() {

	}

	public void saveAction() {
		String message = null;

		if (selected.getCurrentDay() == null) {
			message = "El Campo Día es Obligatorio";
			FacesUtil.addWarn("Advertencia", message);
		} else {
			boolean exists = false;
			Iterator<KpiDaily> it = model.iterator();
			while (it.hasNext()) {
				KpiDaily row = it.next();
				if (row.getCurrentDay().compareTo(selected.getCurrentDay()) == 0) {
					exists = true;
					break;
				}
			}

			if ((exists) && (selected.getId() == null)) {
				message = "Ya existe una programación para este día";
				FacesUtil.addWarn("Advertencia", message);
			}
		}

		RequestContext context = RequestContext.getCurrentInstance();
		if (message == null) {
			if (selected.getId() == null) {
				selected.setId(service.getId("KpiDaily"));
				selected.setFinishedOrders(0);
				selected.setFailuresOrders(0);
				selected.setState(0);
			}

			selected.setKpiWeek(mapKpiWeek.get(kpiWeekSelected));
			service.save(selected);
			message = "El registro se ha actualizado con Exito";
			model = new KpiDailyModel(
					service.getListKpiDailyByWeek(kpiWeekSelected));
			FacesUtil.addInfo("Información", message);
			context.addCallbackParam("saved", "true");
		} else {
			context.addCallbackParam("saved", "false");
		}
	}

	public void handleWeekChange() {
		this.minDate = mapKpiWeek.get(kpiWeekSelected).getStartDate();
		this.maxDate = mapKpiWeek.get(kpiWeekSelected).getEndDate();

		List<KpiDaily> list = service.getListKpiDailyByWeek(kpiWeekSelected);

		model = new KpiDailyModel(list);
		listDays = new ArrayList<SelectItem>();

		for (KpiDaily row : list) {
			SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(row.getCurrentDay());

			SelectItem item = new SelectItem();
			item.setValue(row.getId());
			item.setLabel(date);

			listDays.add(item);
			mapKpiDaily.put(row.getId(), row);
		}

		if (listDays.size() > 0) {
			this.kpiDailySelected = list.get(0).getId();
			selected = mapKpiDaily.get(kpiDailySelected);
		} else {
			selected = new KpiDaily();
		}
	}

	public void handleDayChange() {
		selected = mapKpiDaily.get(kpiDailySelected);
	}

}
