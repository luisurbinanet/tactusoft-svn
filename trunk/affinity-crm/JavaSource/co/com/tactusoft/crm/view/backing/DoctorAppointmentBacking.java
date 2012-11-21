package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.DatesBean;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;

@Named
@Scope("view")
public class DoctorAppointmentBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> listDoctor;
	private CrmDoctor doctor;
	private List<VwAppointment> listAppointment;

	private List<CrmAppointment> listAppointmentByDoctor;
	private CrmAppointment selectedAppointment;

	private List<CrmAppointment> listAppointmentByDoctorUntimely;
	private AppointmentDataModel appointmentModel;
	private boolean untimely;

	private List<SelectItem> listBranch;
	private BigDecimal idBranch;

	private List<CrmAppointment> listAppointmentByBranch;

	private ScheduleModel eventModel;
	private ScheduleModel branchEventModel;
	private DefaultScheduleEvent event;

	private String startTime;
	private String endTime;

	private String labelPatient;
	private String labelProcedure;
	private String labelBranch;
	private String labelState;

	private int minHour;
	private int maxHour;

	private Date startDate;
	private Date endDate;

	public DoctorAppointmentBacking() {
		idBranch = Constant.DEFAULT_VALUE;
		doctor = new CrmDoctor();

		labelPatient = FacesUtil.getMessage("pat");
		labelProcedure = FacesUtil.getMessage("app_procedure");
		labelBranch = FacesUtil.getMessage("app_branch");
		labelState = FacesUtil.getMessage("app_state");

		untimely = false;
		minHour = 7;
		maxHour = 19;

		startDate = new Date();
		endDate = new Date();
	}

	public CrmDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(CrmDoctor doctor) {
		this.doctor = doctor;
	}

	public List<VwAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<VwAppointment> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public List<CrmAppointment> getListAppointmentByDoctor() {
		if (listAppointmentByDoctor == null) {
			doctor = processService.getCrmDoctor();
			if (doctor != null) {
				listAppointmentByDoctor = processService
						.getListAppointmentByDoctorWithOutUntimely(doctor
								.getId());
			}
		}
		return listAppointmentByDoctor;
	}

	public void setListAppointmentByDoctor(
			List<CrmAppointment> listAppointmentByDoctor) {
		this.listAppointmentByDoctor = listAppointmentByDoctor;
	}

	public List<CrmAppointment> getListAppointmentByDoctorUntimely() {
		return listAppointmentByDoctorUntimely;
	}

	public void setListAppointmentByDoctorUntimely(
			List<CrmAppointment> listAppointmentByDoctorUntimely) {
		this.listAppointmentByDoctorUntimely = listAppointmentByDoctorUntimely;
	}

	public AppointmentDataModel getAppointmentModel() {
		return appointmentModel;
	}

	public void setAppointmentModel(AppointmentDataModel appointmentModel) {
		this.appointmentModel = appointmentModel;
	}

	public boolean isUntimely() {
		if (listAppointmentByDoctorUntimely == null) {
			doctor = processService.getCrmDoctor();
			if (doctor != null) {
				listAppointmentByDoctorUntimely = processService
						.getListAppointmentByDoctorWithUntimely(doctor.getId());
				appointmentModel = new AppointmentDataModel(
						listAppointmentByDoctorUntimely);
				if (listAppointmentByDoctorUntimely.size() > 0) {
					selectedAppointment = listAppointmentByDoctorUntimely
							.get(0);
					untimely = true;
				}
			}
		}
		return untimely;
	}

	public void setUntimely(boolean untimely) {
		this.untimely = untimely;
	}

	public CrmAppointment getSelectedAppointment() {
		return selectedAppointment;
	}

	public void setSelectedAppointment(CrmAppointment selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listBranch.add(new SelectItem(Constant.DEFAULT_VALUE, label));
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				listBranch.add(new SelectItem(row.getId(), row.getName()));
			}
		}
		return listBranch;
	}

	public void setListBranch(List<SelectItem> listBranch) {
		this.listBranch = listBranch;
	}

	public List<SelectItem> getListDoctor() {
		return listDoctor;
	}

	public void setListDoctor(List<SelectItem> listDoctor) {
		this.listDoctor = listDoctor;
	}

	public BigDecimal getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	public List<CrmAppointment> getListAppointmentByBranch() {
		return listAppointmentByBranch;
	}

	public void setListAppointmentByBranch(
			List<CrmAppointment> listAppointmentByBranch) {
		this.listAppointmentByBranch = listAppointmentByBranch;
	}

	public int getMinHour() {
		return minHour;
	}

	public void setMinHour(int minHour) {
		this.minHour = minHour;
	}

	public int getMaxHour() {
		return maxHour;
	}

	public void setMaxHour(int maxHour) {
		this.maxHour = maxHour;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public DefaultScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(DefaultScheduleEvent event) {
		this.event = event;
	}

	public ScheduleModel getEventModel() {
		if (eventModel == null) {
			eventModel = new DefaultScheduleModel();
			if (doctor != null) {
				listAppointment = processService
						.getListVwAppointmentByDoctor(doctor.getId());
				for (VwAppointment row : listAppointment) {
					String title = labelPatient + ": " + row.getPatFirstnames()
							+ " " + row.getPatSurnames() + " - "
							+ labelProcedure + ":" + row.getPrcDetName()
							+ " - " + labelBranch + ": " + row.getBranchName()
							+ " - " + labelState + ": "
							+ FacesUtil.getAppState(row.getState());

					event = new DefaultScheduleEvent(title,
							row.getStartAppointmentDate(),
							row.getEndAppointmentDate(), row);

					eventModel.addEvent(event);
				}
			}
		}
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public ScheduleModel getBranchEventModel() {
		return branchEventModel;
	}

	public void setBranchEventModel(ScheduleModel branchEventModel) {
		this.branchEventModel = branchEventModel;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void handleBranchChange() {
		listDoctor = new LinkedList<SelectItem>();
		String label = FacesUtil.getMessage(Constant.ALL_LABEL);
		listDoctor.add(new SelectItem(Constant.DEFAULT_VALUE, label));
		for (CrmDoctor row : tablesService.getListDoctorByBranch(idBranch)) {
			listDoctor.add(new SelectItem(row.getId(), row.getNames()));
		}
	}

	public void searchAction() {
		if (idBranch.intValue() != -1) {
			branchEventModel = new DefaultScheduleModel();

			DatesBean datesBean = tablesService
					.getMinMaxHourScheduleByBranch(idBranch);

			minHour = FacesUtil.getHour(datesBean.getId().getMinDate());
			maxHour = FacesUtil.getHour(datesBean.getId().getMaxDate()) + 1;

			List<DatesBean> listScheduleBranch = null;
			if (doctor.getId().intValue() == -1) {
				listAppointment = processService.getListVwAppointmentByBranch(
						idBranch, startDate, endDate);
				listScheduleBranch = tablesService
						.getDistinctHoursScheduleByBranch(idBranch);
			} else {
				listAppointment = processService
						.getListAppointmentByBranchDoctor(idBranch,
								doctor.getId(), startDate, endDate);
				listScheduleBranch = tablesService
						.getDistinctHoursScheduleByDoctor(idBranch,
								doctor.getId());
			}

			for (VwAppointment row : listAppointment) {
				String title = "Nro. Cita:" + row.getCode() + ". Paciente: "
						+ row.getPatFirstnames() + " " + row.getPatSurnames()
						+ ". Doctor: " + row.getDoctorNames();
				branchEventModel
						.addEvent(new DefaultScheduleEvent(title, row
								.getStartAppointmentDate(), row
								.getEndAppointmentDate()));
			}

			Date ini = startDate;
			do {
				generateNoAlvailable(listScheduleBranch,
						FacesUtil.getDateWithoutTime(ini));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(ini);
				calendar.add(Calendar.DAY_OF_WEEK, 1);
				ini = calendar.getTime();
			} while (ini.compareTo(endDate) < 0);

		} else {
			branchEventModel = null;
		}
	}

	public void cancelAppointmentAction(ActionEvent actionEvent) {
		selectedAppointment.setState(Constant.APP_STATE_NOATTENDED);
		processService.saveAppointment(selectedAppointment);

		String title = labelPatient + ": "
				+ selectedAppointment.getPatientNames() + " - "
				+ labelProcedure + ":"
				+ selectedAppointment.getCrmProcedureDetail().getName() + " - "
				+ labelBranch + ": "
				+ selectedAppointment.getCrmBranch().getName() + " - "
				+ labelState + ": "
				+ FacesUtil.getAppState(selectedAppointment.getState());

		event.setTitle(title);
		event.setData(selectedAppointment);
		eventModel.updateEvent(event);

		String message = FacesUtil.getMessage("app_msg_cancel",
				selectedAppointment.getCode());
		FacesUtil.addInfo(message);
	}

	public String attendedAppointmentAction() {
		selectedAppointment.setState(Constant.APP_STATE_ATTENDED);
		processService.saveAppointment(selectedAppointment);

		HistoryBacking historyBacking = FacesUtil.findBean("historyBacking");
		historyBacking.newAction(null);
		historyBacking.setSelectedPatient(selectedAppointment.getCrmPatient());
		historyBacking.searchAction(null);

		return "/pages/processes/history?faces-redirect=true";
	}

	public String attendedUntimelyAppointmentAction() {
		String result = null;
		Date date = null;
		Date startHourDate = null;
		Date endHourDate = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String message = null;
		boolean saved = false;

		Calendar gc = new GregorianCalendar();
		try {
			String dateString = FacesUtil
					.formatDate(selectedAppointment.getStartAppointmentDate(),
							"yyyy-MM-dd");

			date = df.parse(dateString + " " + startTime);
			gc.setTime(date);
			startHourDate = gc.getTime();
			int startHour = gc.get(Calendar.HOUR);
			int startMinute = gc.get(Calendar.MINUTE);

			gc = new GregorianCalendar();
			date = df.parse(dateString + " " + endTime);
			gc.setTime(date);
			endHourDate = gc.getTime();
			int endhour = gc.get(Calendar.HOUR);
			int endMinute = gc.get(Calendar.MINUTE);

			if (startHourDate.getTime() >= endHourDate.getTime()) {
				message = FacesUtil.getMessage("sal_msg_error_dates_1");
				FacesUtil.addError(message);
			} else if (startHour > 23 || endhour > 23 || startMinute > 59
					|| endMinute > 59) {
				message = FacesUtil.getMessage("sal_msg_error_dates_3");
				FacesUtil.addError(message);
			} else {
				selectedAppointment.setStartAppointmentDate(startHourDate);
				selectedAppointment.setEndAppointmentDate(endHourDate);
				selectedAppointment.setState(Constant.APP_STATE_ATTENDED);
				processService.saveAppointment(selectedAppointment);
				saved = true;

				HistoryBacking historyBacking = FacesUtil
						.findBean("historyBacking");
				historyBacking.newAction(null);
				historyBacking.setSelectedPatient(selectedAppointment
						.getCrmPatient());
				historyBacking.searchAction(null);

				result = "/pages/processes/history?faces-redirect=true";
			}

			RequestContext context = RequestContext.getCurrentInstance();
			context.addCallbackParam("saved", saved);
		} catch (ParseException e) {
			message = FacesUtil.getMessage("sal_msg_error_dates_2");
			FacesUtil.addError(message);
		}

		return result;
	}

	public void onEventSelect(ScheduleEntrySelectEvent selectEvent) {
		event = (DefaultScheduleEvent) selectEvent.getScheduleEvent();
		selectedAppointment = (CrmAppointment) event.getData();
	}

	private void generateNoAlvailable(List<DatesBean> listScheduleBranch,
			Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		int day = calendar.get(Calendar.DAY_OF_WEEK);

		int hour = minHour;
		Date hourDate = FacesUtil.stringTOSDate("01-01-1900 " + minHour
				+ ":00:00");
		for (DatesBean row : listScheduleBranch) {
			if (row.getId().getDay() == day) {
				int startHour = FacesUtil.getHour(row.getId().getMinDate());

				int dif = startHour - hour;
				if (dif > 0) {
					Date initDate = FacesUtil.addHourToDate(currentDate,
							hourDate);
					Date hourAdd = FacesUtil.stringTOSDate("01-01-1900 " + dif
							+ ":00:00");
					branchEventModel.addEvent(new DefaultScheduleEvent(
							"NO DISPONIBLE", initDate, FacesUtil.addHourToDate(
									initDate, hourAdd), "style_no_available"));
				}

				hourDate = row.getId().getMaxDate();
				hour = FacesUtil.getHour(row.getId().getMaxDate());
			}
		}
	}
}
