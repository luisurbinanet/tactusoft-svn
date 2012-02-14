package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.util.Util;
import co.com.tactusoft.kpi.view.model.CalendarWeek;
import co.com.tactusoft.kpi.view.model.KpiWeekModel;

@Controller
@Scope("session")
public class KpiWeekBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TablesBo service;

	private KpiWeekModel model;
	private KpiWeek selected;

	private Map<Integer, CalendarWeek> listCalendarWeek = new HashMap<Integer, CalendarWeek>();

	public KpiWeekBacking() {
		selected = new KpiWeek();
	}

	public KpiWeekModel getModel() {
		if (model == null) {
			model = new KpiWeekModel(service.getListKpiKpiWeek());
		}
		return model;
	}

	public void setModel(KpiWeekModel model) {
		this.model = model;
	}

	public KpiWeek getSelected() {
		return selected;
	}

	public void setSelected(KpiWeek selected) {
		if (selected == null) {
			selected = new KpiWeek();
		}
		this.selected = selected;
	}

	public List<SelectItem> getListItemCalendarWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int numberDays = calendar.getActualMaximum(Calendar.YEAR);
		int numberWeeks = numberDays / 7;

		List<SelectItem> listItem = new ArrayList<SelectItem>();
		for (int week = 1; week <= numberWeeks; week++) {
			CalendarWeek calendarWeek = new CalendarWeek();
			calendarWeek.setWeek(week);

			listCalendarWeek.put(week, calendarWeek);

			SelectItem item = new SelectItem();
			item.setValue(calendarWeek.getWeek());
			item.setLabel(calendarWeek.getLabel());

			listItem.add(item);
		}

		return listItem;
	}

	public void newAction() {
		selected = new KpiWeek();
	}

	public void deleteAction() {
		service.remove(selected);
		model = new KpiWeekModel(service.getListKpiKpiWeek());
	}

	public void saveAction() {

		String message = null;

		/*
		 * if (selected.getName().length() == 0) { message =
		 * "El Campo Nombre es Obligatorio\n"; Util.addWarn("Advertencia",
		 * message); }
		 * 
		 * if (selected.getDescription().length() == 0) { message =
		 * "El Campo Descripción es Obligatorio"; Util.addWarn("Advertencia",
		 * message); }
		 */

		if (selected.getAssignedOrders() == 0) {
			message = "El Campo OT Asignadas es Obligatorio";
			Util.addWarn("Advertencia", message);
		}

		if (selected.getEndDate().compareTo(selected.getStartDate()) < 0) {
			message = "La Fecha Inicial debe ser menor a la Fecha Final";
			Util.addWarn("Advertencia", message);
		}

		if (message == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(selected.getStartDate());

			String name = "SC" + calendar.get(Calendar.YEAR)
					+ calendar.get(Calendar.WEEK_OF_MONTH);

			if (selected.getId() == null) {
				selected.setId(service.getId("KpiWeek"));
			}

			selected.setName(name);
			selected.setDescription(selected.getDescription().toUpperCase());
			service.save(selected);
			message = "El registro " + selected.getName()
					+ " actualizado con Exito";
			//selected = new KpiWeek();
			model = new KpiWeekModel(service.getListKpiKpiWeek());
			Util.addInfo("Información", message);

		}
	}

}
