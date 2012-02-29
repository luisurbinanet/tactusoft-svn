package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.CalendarWeek;
import co.com.tactusoft.kpi.view.model.KpiWeekModel;

@Named
@Scope("view")
public class KpiWeekBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo service;

	private KpiWeekModel model;
	private KpiWeek selected;

	private Map<Integer, CalendarWeek> listCalendarWeek = new HashMap<Integer, CalendarWeek>();

	public KpiWeekBacking() {
		selected = new KpiWeek();
		model =null;
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
		String field = null;
		int validate = 0;

		if (selected.getStartDate() == null) {
			field = FacesUtil.getMessage("wek_star_date");
			message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
		} else {
			validate++;
		}

		if (selected.getEndDate() == null) {
			field = FacesUtil.getMessage("wek_end_date");
			message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
		} else {
			validate++;
		}

		if (validate == 2) {
			if (selected.getEndDate().compareTo(selected.getStartDate()) < 0) {
				message = FacesUtil.getMessage("msg_wek_validate_dates");
				FacesUtil.addWarn(message);
			}
		}

		RequestContext context = RequestContext.getCurrentInstance();
		if (message == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(selected.getStartDate());

			String seq = FacesUtil.getMessage("wek_seq");

			String name = seq + calendar.get(Calendar.YEAR)
					+ calendar.get(Calendar.WEEK_OF_MONTH);

			if (selected.getId() == null) {
				selected.setId(service.getId("KpiWeek"));
			}

			selected.setName(name);
			// selected.setDescription(selected.getDescription().toUpperCase());
			service.save(selected);

			message = FacesUtil.getMessage("msg_record_ok", selected.getName());
			FacesUtil.addInfo(message);

			model = new KpiWeekModel(service.getListKpiKpiWeek());
			context.addCallbackParam("saved", "true");
		} else {
			context.addCallbackParam("saved", "false");
		}
	}

}
