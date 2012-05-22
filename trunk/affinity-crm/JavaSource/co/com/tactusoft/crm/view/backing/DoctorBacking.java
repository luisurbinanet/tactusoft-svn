package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDoctorSchedule;
import co.com.tactusoft.crm.model.entities.CrmSpeciality;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.DoctorDataModel;
import co.com.tactusoft.crm.view.datamodel.DoctorScheduleDataModel;

@Named
@Scope("view")
public class DoctorBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmDoctor> list;
	private DoctorDataModel model;
	private CrmDoctor selected;

	private List<SelectItem> listCrmSpeciality;
	private Map<BigDecimal, CrmSpeciality> mapCrmSpeciality;

	private List<SelectItem> listCrmBranch;
	private Map<BigDecimal, CrmBranch> mapCrmBranch;

	private DoctorScheduleDataModel modelDoctorSchedule;
	private CrmDoctorSchedule[] selectedDoctorSchedule;
	private List<CrmDoctorSchedule> listDoctorSchedule;

	private List<SelectItem> listDays;
	private Integer idDay;
	private String startHour;
	private String endHour;

	public DoctorBacking() {
		newAction();

		listDays = new LinkedList<SelectItem>();
		listDays.add(new SelectItem(Calendar.SUNDAY, "Domingo"));
		listDays.add(new SelectItem(Calendar.MONDAY, "Lunes"));
		listDays.add(new SelectItem(Calendar.TUESDAY, "Martes"));
		listDays.add(new SelectItem(Calendar.WEDNESDAY, "Miercoles"));
		listDays.add(new SelectItem(Calendar.THURSDAY, "Jueves"));
		listDays.add(new SelectItem(Calendar.FRIDAY, "Viernes"));
		listDays.add(new SelectItem(Calendar.SATURDAY, "Sábado"));
	}

	public List<CrmDoctor> getList() {
		return list;
	}

	public void setList(List<CrmDoctor> list) {
		this.list = list;
	}

	public DoctorDataModel getModel() {
		if (model == null) {
			list = tableService.getListDoctor();
			model = new DoctorDataModel(list);
		}
		return model;
	}

	public void setModel(DoctorDataModel model) {
		this.model = model;
	}

	public CrmDoctor getSelected() {
		return selected;
	}

	public void setSelected(CrmDoctor selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListCrmSpeciality() {
		if (listCrmSpeciality == null) {
			listCrmSpeciality = new LinkedList<SelectItem>();
			mapCrmSpeciality = new HashMap<BigDecimal, CrmSpeciality>();
			for (CrmSpeciality row : tableService.getListSpecialityActive()) {
				mapCrmSpeciality.put(row.getId(), row);
				listCrmSpeciality.add(new SelectItem(row.getId(), row
						.getDescription()));
			}
		}
		return listCrmSpeciality;
	}

	public void setListCrmSpeciality(List<SelectItem> listCrmSpeciality) {
		this.listCrmSpeciality = listCrmSpeciality;
	}

	public List<SelectItem> getListCrmBranch() {
		if (listCrmBranch == null) {
			listCrmBranch = new LinkedList<SelectItem>();
			mapCrmBranch = new HashMap<BigDecimal, CrmBranch>();
			for (CrmBranch row : tableService.getListBranchActive()) {
				mapCrmBranch.put(row.getId(), row);
				listCrmBranch.add(new SelectItem(row.getId(), row.getName()));
			}
		}
		return listCrmBranch;
	}

	public void setListCrmBranch(List<SelectItem> listCrmBranch) {
		this.listCrmBranch = listCrmBranch;
	}

	public DoctorScheduleDataModel getModelDoctorSchedule() {
		return modelDoctorSchedule;
	}

	public void setModelDoctorSchedule(
			DoctorScheduleDataModel modelDoctorSchedule) {
		this.modelDoctorSchedule = modelDoctorSchedule;
	}

	public CrmDoctorSchedule[] getSelectedDoctorSchedule() {
		return selectedDoctorSchedule;
	}

	public void setSelectedDoctorSchedule(
			CrmDoctorSchedule selectedDoctorSchedule[]) {
		this.selectedDoctorSchedule = selectedDoctorSchedule;
	}

	public List<CrmDoctorSchedule> getListDoctorSchedule() {
		return listDoctorSchedule;
	}

	public void setListDoctorSchedule(List<CrmDoctorSchedule> listDoctorSchedule) {
		this.listDoctorSchedule = listDoctorSchedule;
	}

	public List<SelectItem> getListDays() {
		return listDays;
	}

	public void setListDays(List<SelectItem> listDays) {
		this.listDays = listDays;
	}

	public Integer getIdDay() {
		return idDay;
	}

	public void setIdDay(Integer idDay) {
		this.idDay = idDay;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public void newAction() {
		selected = new CrmDoctor();
		selected.setOnSite(false);
		selected.setVirtual(false);
		selected.setState(Constant.STATE_ACTIVE);
		selected.setCrmSpeciality(new CrmSpeciality());
		selected.setCrmBranch(new CrmBranch());

		listDoctorSchedule = new LinkedList<CrmDoctorSchedule>();
		modelDoctorSchedule = new DoctorScheduleDataModel(listDoctorSchedule);

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
	}

	public void saveAction() {
		String message = null;

		if (listDoctorSchedule.size() == 0) {
			message = FacesUtil.getMessage("sal_msg_error_schedule");
			FacesUtil.addError(message);
		} else {
			selected.setCrmSpeciality(mapCrmSpeciality.get(selected
					.getCrmSpeciality().getId()));

			selected.setCrmBranch(mapCrmBranch.get(selected.getCrmBranch()
					.getId()));

			int result = tableService.saveDoctor(selected);
			if (result == 0) {
				tableService.saveDoctorSchedule(selected, listDoctorSchedule);
				list = tableService.getListDoctor();
				model = new DoctorDataModel(list);
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			} else if (result == -1) {
				String paramValue = FacesUtil.getMessage("doc_code");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						paramValue);
				FacesUtil.addError(message);
			}
		}
	}

	public void addScheduleAction() {
		String message = null;
		Date date = null;
		Date startHourDate = null;
		Date endHourDate = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		try {
			Calendar gc = new GregorianCalendar();
			date = df.parse("1900-01-01 " + startHour);
			gc.setTime(date);
			startHourDate = gc.getTime();

			gc = new GregorianCalendar();
			date = df.parse("1900-01-01 " + endHour);
			gc.setTime(date);
			endHourDate = gc.getTime();

			if (startHourDate.getTime() >= endHourDate.getTime()) {
				message = FacesUtil.getMessage("sal_msg_error_dates_1");
				FacesUtil.addError(message);
			} else {
				listDoctorSchedule.add(new CrmDoctorSchedule(
						new BigDecimal(-1), selected, idDay, startHourDate,
						endHourDate));
				modelDoctorSchedule = new DoctorScheduleDataModel(
						listDoctorSchedule);
			}

		} catch (ParseException e) {
			message = FacesUtil.getMessage("sal_msg_error_dates_2");
			FacesUtil.addError(message);
		}
	}

	public void deleteScheduleAction() {
		for (CrmDoctorSchedule row : selectedDoctorSchedule) {
			listDoctorSchedule.remove(row);
		}
		modelDoctorSchedule = new DoctorScheduleDataModel(listDoctorSchedule);
	}

	public void generateListAction(ActionEvent event) {
		listDoctorSchedule = tableService.getListScheduleByDoctor(selected
				.getId());
		modelDoctorSchedule = new DoctorScheduleDataModel(listDoctorSchedule);
	}

}