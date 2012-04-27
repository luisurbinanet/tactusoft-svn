package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.kpi.controller.bo.AdminBo;
import co.com.tactusoft.kpi.controller.bo.ProcessBo;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiDailyDelay;
import co.com.tactusoft.kpi.model.entities.KpiDailyDelayWo;
import co.com.tactusoft.kpi.model.entities.KpiDelay;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.util.Constant;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.KpiDailyDelayModel;
import co.com.tactusoft.kpi.view.model.KpiDailyDelayWOModel;
import co.com.tactusoft.kpi.view.model.KpiDailyModel;

@Named
@Scope("view")
public class KpiDailyBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ProcessBo service;

	@Inject
	private AdminBo adminService;

	private KpiDailyModel model;
	private KpiDaily selected;

	private List<SelectItem> listCalendarWeeks;
	private BigDecimal kpiWeekSelected;
	private KpiWeek selectedWeek;
	private List<SelectItem> listDays;
	private BigDecimal kpiDailySelected;
	private KpiDailyDelayModel modelDailyDelay;
	private List<KpiDailyDelay> listDailyDelay;
	private KpiDailyDelay selectedDetail;

	private Date minDate;
	private Date maxDate;

	private Map<BigDecimal, KpiWeek> mapKpiWeek = new HashMap<BigDecimal, KpiWeek>();
	private Map<BigDecimal, KpiDaily> mapKpiDaily = new HashMap<BigDecimal, KpiDaily>();

	private String pageType;

	private String wo;
	private BigDecimal numHours;
	private List<KpiDailyDelayWo> listHours;
	private KpiDailyDelayWOModel modelHours;

	public KpiDailyBacking() {
		selected = new KpiDaily();
		selectedDetail = new KpiDailyDelay();
		listCalendarWeeks = null;
		this.kpiWeekSelected = Constant.defaultValue;
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

			SelectItem item = new SelectItem();
			item.setValue(Constant.defaultValue);
			item.setLabel(Constant.defaultLabel);
			listCalendarWeeks.add(item);

			for (KpiWeek row : list) {
				item = new SelectItem();
				item.setValue(row.getId());

				SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"dd/MM/yyyy");
				String startDate = sdf.format(row.getStartDate());
				String endDate = sdf.format(row.getEndDate());
				String label = row.getName() + ": " + startDate + " - "
						+ endDate;

				item.setLabel(label);

				listCalendarWeeks.add(item);

				mapKpiWeek.put(row.getId(), row);
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

	public List<KpiDailyDelay> getListDailyDelay() {
		return listDailyDelay;
	}

	public void setListDailyDelay(List<KpiDailyDelay> listDailyDelay) {
		this.listDailyDelay = listDailyDelay;
	}

	public KpiDailyDelay getSelectedDetail() {
		return selectedDetail;
	}

	public void setSelectedDetail(KpiDailyDelay selectedDetail) {
		this.selectedDetail = selectedDetail;
	}

	public KpiDailyDelayModel getModelDailyDelay() {
		return modelDailyDelay;
	}

	public void setModelDailyDelay(KpiDailyDelayModel modelDailyDelay) {
		this.modelDailyDelay = modelDailyDelay;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	public KpiWeek getSelectedWeek() {
		return selectedWeek;
	}

	public void setSelectedWeek(KpiWeek selectedWeek) {
		this.selectedWeek = selectedWeek;
	}

	public String getWo() {
		return wo;
	}

	public void setWo(String wo) {
		this.wo = wo;
	}

	public BigDecimal getNumHours() {
		return numHours;
	}

	public void setNumHours(BigDecimal numHours) {
		this.numHours = numHours;
	}

	public KpiDailyDelayWOModel getModelHours() {
		return modelHours;
	}

	public void setModelHours(KpiDailyDelayWOModel modelHours) {
		this.modelHours = modelHours;
	}

	public void newAction() {
		selected = new KpiDaily();
	}

	public void saveAction() {
		String message = null;
		String field = null;

		if (selected.getCurrentDay() == null) {
			field = FacesUtil.getMessage("day_day");
			message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
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
				message = FacesUtil.getMessage("msg_day_validate_day");
				FacesUtil.addWarn(message);
			}
		}

		RequestContext context = RequestContext.getCurrentInstance();
		if (message == null) {
			boolean newRecord = false;
			if (selected.getId() == null) {
				selected.setId(service.getId("KpiDaily"));
				selected.setFinishedOrders(0);
				selected.setFailuresOrders(0);
				selected.setState(Constant.STATE_ACTIVE);
				newRecord = true;
			}

			selected.setKpiWeek(mapKpiWeek.get(kpiWeekSelected));
			service.save(selected);

			if (newRecord) {
				BigDecimal idHeader = new BigDecimal(1);
				List<KpiDelay> list = adminService
						.getListKpiDelayByHeader(idHeader);
				for (KpiDelay row : list) {
					KpiDailyDelay object = new KpiDailyDelay();
					object.setId(service.getId("KpiDailyDelay"));
					object.setKpiDelay(row);
					object.setKpiDaily(selected);
					object.setNumHours(new BigDecimal(0));
					adminService.save(object);
				}
			}

			if (pageType.equals("registryDay")) {
				for (KpiDailyDelay row : listDailyDelay) {
					adminService.save(row);
				}
			}

			SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(selected.getCurrentDay());
			message = FacesUtil.getMessage("msg_record_ok", date);
			FacesUtil.addInfo(message);
			context.addCallbackParam("saved", "true");

			model = new KpiDailyModel(
					service.getListKpiDailyByWeek(kpiWeekSelected));

		} else {
			context.addCallbackParam("saved", "false");
		}
	}

	public void handleWeekChange() {
		if (this.kpiWeekSelected.intValue() != -1) {
			this.minDate = mapKpiWeek.get(kpiWeekSelected).getStartDate();
			this.maxDate = mapKpiWeek.get(kpiWeekSelected).getEndDate();

			selectedWeek = mapKpiWeek.get(kpiWeekSelected);

			List<KpiDaily> list = service
					.getListKpiDailyByWeek(kpiWeekSelected);

			model = new KpiDailyModel(list);
			listDays = new ArrayList<SelectItem>();

			for (KpiDaily row : list) {
				SimpleDateFormat sdf = new java.text.SimpleDateFormat(
						"dd/MM/yyyy");
				String date = sdf.format(row.getCurrentDay());

				SelectItem item = new SelectItem();
				item.setValue(row.getId());
				item.setLabel(date);

				listDays.add(item);
				mapKpiDaily.put(row.getId(), row);
			}

			if (listDays.size() > 0) {
				this.kpiDailySelected = list.get(0).getId();
				handleDayChange();
			} else {
				selected = new KpiDaily();
				listDailyDelay = new LinkedList<KpiDailyDelay>();
				modelDailyDelay = new KpiDailyDelayModel(listDailyDelay);
			}
		} else {
			selected = new KpiDaily();
			model = new KpiDailyModel();
			listDailyDelay = new LinkedList<KpiDailyDelay>();
			modelDailyDelay = new KpiDailyDelayModel(listDailyDelay);
			listDays = new ArrayList<SelectItem>();
			selectedDetail = new KpiDailyDelay();
		}
	}

	public void handleDayChange() {
		selected = mapKpiDaily.get(kpiDailySelected);
		listDailyDelay = adminService.getListKpiDailyDelayByDay(selected
				.getId());
		modelDailyDelay = new KpiDailyDelayModel(listDailyDelay);
		selectedDetail = new KpiDailyDelay();
	}

	public void newDetailAction() {
		this.wo = "";
		this.numHours = new BigDecimal(0);
	}

	public void saveDetailAction() {
		RequestContext context = RequestContext.getCurrentInstance();
		service.saveKpiDailyDelayWo(selectedDetail.getId(), this.wo,
				this.numHours);
		listDailyDelay = adminService.getListKpiDailyDelayByDay(selected
				.getId());
		modelDailyDelay = new KpiDailyDelayModel(listDailyDelay);
		context.addCallbackParam("validate", true); 
	}

	public void searchDetailAction() {
		listHours = service.getListKpiDailyDelayWoByDelay(selectedDetail.getId());
		modelHours = new KpiDailyDelayWOModel(listHours);
	}

}
