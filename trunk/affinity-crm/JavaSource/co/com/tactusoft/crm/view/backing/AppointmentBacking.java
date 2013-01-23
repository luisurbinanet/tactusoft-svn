package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProcedure;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Candidate;
import co.com.tactusoft.crm.view.beans.ResultSearchAppointment;
import co.com.tactusoft.crm.view.beans.ResultSearchDate;
import co.com.tactusoft.crm.view.datamodel.CandidateDataModel;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;

@Named
@Scope("session")
public class AppointmentBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private CrmAppointment selected;

	private List<SelectItem> listBranch;
	private Map<BigDecimal, CrmBranch> mapBranch;
	private BigDecimal idBranch;

	private List<SelectItem> listProcedure;
	private Map<BigDecimal, CrmProcedure> mapProcedure;
	private BigDecimal idProcedure;

	private List<SelectItem> listProcedureDetail;
	private Map<BigDecimal, CrmProcedureDetail> mapProcedureDetail;
	private BigDecimal idProcedureDetail;

	private List<SelectItem> listSearch;
	private BigDecimal idSearch;

	private List<SelectItem> listDoctor;
	private Map<BigDecimal, CrmDoctor> mapDoctor;

	private List<SelectItem> listTimes;

	private Date currentDate;
	private Long currentTime;
	private int appointmentsNumber;

	private List<Candidate> listAppointment;
	private CandidateDataModel modelAppointment;
	private Candidate selectedCandidate;
	private Candidate selectedCandidateTemp;

	private boolean renderedForDate;
	private boolean renderedForDoctor;
	private boolean renderedDoctorWithoutTime;
	private boolean disabledSearch;

	private String infoMessage;
	private boolean saved;
	private boolean edit;
	private boolean validate;

	private int minutes = 0;
	private String timeType = null;
	private String infoMessageDate;

	private String fromPage;

	public AppointmentBacking() {
		newAction(null);
	}

	public CrmAppointment getSelected() {
		return selected;
	}

	public void setSelected(CrmAppointment selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			mapBranch = new LinkedHashMap<BigDecimal, CrmBranch>();
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				mapBranch.put(row.getId(), row);
				listBranch.add(new SelectItem(row.getId(), row.getName()));
			}

			if (listBranch.size() > 0) {
				idBranch = (BigDecimal) listBranch.get(0).getValue();
				handleBranchChange();
			}
		}
		return listBranch;
	}

	public void setListBranch(List<SelectItem> listBranch) {
		this.listBranch = listBranch;
	}

	public Map<BigDecimal, CrmBranch> getMapBranch() {
		return mapBranch;
	}

	public void setMapBranch(Map<BigDecimal, CrmBranch> mapBranch) {
		this.mapBranch = mapBranch;
	}

	public BigDecimal getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	public List<SelectItem> getListProcedure() {
		return listProcedure;
	}

	public void setListProcedure(List<SelectItem> listProcedure) {
		this.listProcedure = listProcedure;
	}

	public Map<BigDecimal, CrmProcedure> getMapProcedure() {
		return mapProcedure;
	}

	public void setMapProcedure(Map<BigDecimal, CrmProcedure> mapProcedure) {
		this.mapProcedure = mapProcedure;
	}

	public BigDecimal getIdProcedure() {
		return idProcedure;
	}

	public void setIdProcedure(BigDecimal idProcedure) {
		this.idProcedure = idProcedure;
	}

	public List<SelectItem> getListProcedureDetail() {
		return listProcedureDetail;
	}

	public void setListProcedureDetail(List<SelectItem> listProcedureDetail) {
		this.listProcedureDetail = listProcedureDetail;
	}

	public Map<BigDecimal, CrmProcedureDetail> getMapProcedureDetail() {
		return mapProcedureDetail;
	}

	public void setMapProcedureDetail(
			Map<BigDecimal, CrmProcedureDetail> mapProcedureDetail) {
		this.mapProcedureDetail = mapProcedureDetail;
	}

	public BigDecimal getIdProcedureDetail() {
		return idProcedureDetail;
	}

	public void setIdProcedureDetail(BigDecimal idProcedureDetail) {
		this.idProcedureDetail = idProcedureDetail;
	}

	public List<SelectItem> getListSearch() {
		if (listSearch == null) {
			listSearch = new LinkedList<SelectItem>();
			listSearch.add(new SelectItem(Constant.DEFAULT_VALUE, FacesUtil
					.getMessage(Constant.DEFAULT_LABEL)));
			listSearch.add(new SelectItem(Constant.APP_TYPE_FOR_DATE_VALUE,
					FacesUtil.getMessage(Constant.APP_TYPE_FOR_DATE_DESC)));
			listSearch.add(new SelectItem(Constant.APP_TYPE_FOR_DOCTOR_VALUE,
					FacesUtil.getMessage(Constant.APP_TYPE_FOR_DOCTOR_DESC)));
		}
		return listSearch;
	}

	public void setListSearch(List<SelectItem> listSearch) {
		this.listSearch = listSearch;
	}

	public BigDecimal getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(BigDecimal idSearch) {
		this.idSearch = idSearch;
	}

	public List<SelectItem> getListDoctor() {
		return listDoctor;
	}

	public void setListDoctor(List<SelectItem> listDoctor) {
		this.listDoctor = listDoctor;
	}

	public Map<BigDecimal, CrmDoctor> getMapDoctor() {
		return mapDoctor;
	}

	public void setMapDoctor(Map<BigDecimal, CrmDoctor> mapDoctor) {
		this.mapDoctor = mapDoctor;
	}

	public List<SelectItem> getListTimes() {
		return listTimes;
	}

	public void setListTimes(List<SelectItem> listTimes) {
		this.listTimes = listTimes;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Long currentTime) {
		this.currentTime = currentTime;
	}

	public int getAppointmentsNumber() {
		return appointmentsNumber;
	}

	public void setAppointmentsNumber(int appointmentsNumber) {
		this.appointmentsNumber = appointmentsNumber;
	}

	public List<Candidate> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<Candidate> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public CandidateDataModel getModelAppointment() {
		return modelAppointment;
	}

	public void setModelAppointment(CandidateDataModel modelAppointment) {
		this.modelAppointment = modelAppointment;
	}

	public Candidate getSelectedCandidate() {
		return selectedCandidate;
	}

	public void setSelectedCandidate(Candidate selectedCandidate) {
		this.selectedCandidate = selectedCandidate;
	}

	public Candidate getSelectedCandidateTemp() {
		return selectedCandidateTemp;
	}

	public void setSelectedCandidateTemp(Candidate selectedCandidateTemp) {
		this.selectedCandidateTemp = selectedCandidateTemp;
	}

	public boolean isRenderedForDate() {
		return renderedForDate;
	}

	public void setRenderedForDate(boolean renderedForDate) {
		this.renderedForDate = renderedForDate;
	}

	public boolean isRenderedForDoctor() {
		return renderedForDoctor;
	}

	public void setRenderedForDoctor(boolean renderedForDoctor) {
		this.renderedForDoctor = renderedForDoctor;
	}

	public boolean isRenderedDoctorWithoutTime() {
		return renderedDoctorWithoutTime;
	}

	public void setRenderedDoctorWithoutTime(boolean renderedDoctorWithoutTime) {
		this.renderedDoctorWithoutTime = renderedDoctorWithoutTime;
	}

	public boolean isDisabledSearch() {
		return disabledSearch;
	}

	public void setDisabledSearch(boolean disabledSearch) {
		this.disabledSearch = disabledSearch;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getInfoMessageDate() {
		return infoMessageDate;
	}

	public void setInfoMessageDate(String infoMessageDate) {
		this.infoMessageDate = infoMessageDate;
	}

	public String getFromPage() {
		return fromPage;
	}

	public void setFromPage(String fromPage) {
		this.fromPage = fromPage;
	}

	public void newAction(ActionEvent event) {
		listBranch = null;

		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		idSearch = Constant.DEFAULT_VALUE;

		selected = new CrmAppointment();
		selected.setCrmBranch(new CrmBranch());
		selected.setCrmDoctor(new CrmDoctor());
		selected.setCrmProcedureDetail(new CrmProcedureDetail());

		selectedPatient = null;
		selectedPatientTemp = null;
		currentDate = new Date();

		renderedForDate = false;
		renderedForDoctor = false;
		disabledSearch = true;

		optionSearchPatient = 1;
		docPatient = "";
		namePatient = "";
		selectedWSGroupSellers = "-1";

		listAppointment = new LinkedList<Candidate>();
		modelAppointment = new CandidateDataModel(listAppointment);
		selectedCandidate = null;
		selectedCandidateTemp = null;

		infoMessage = null;
		saved = false;
		edit = false;
		fromPage = null;

		if (listProcedureDetail != null) {
			if (listProcedureDetail.size() > 0) {
				idProcedureDetail = (BigDecimal) listProcedureDetail.get(0)
						.getValue();
				handleProcedureDetailChange();
			}
		}
	}

	public void handleBranchChange() {
		listProcedure = new LinkedList<SelectItem>();
		mapProcedure = new LinkedHashMap<BigDecimal, CrmProcedure>();
		for (CrmProcedure row : tablesService
				.getListProcedureByBranch(idBranch)) {
			mapProcedure.put(row.getId(), row);
			listProcedure.add(new SelectItem(row.getId(), row.getName()));
		}

		if (listProcedure.size() > 0) {
			idProcedure = (BigDecimal) listProcedure.get(0).getValue();
			handleProcedureChange();
		}

		listDoctor = new LinkedList<SelectItem>();
		mapDoctor = new LinkedHashMap<BigDecimal, CrmDoctor>();
		for (CrmDoctor row : tablesService.getListDoctorByBranch(idBranch)) {
			mapDoctor.put(row.getId(), row);
			listDoctor.add(new SelectItem(row.getId(), row.getNames()));
		}
	}

	public void handleProcedureChange() {

		if (listProcedure.size() > 0) {
			String codPublicity = mapProcedure.get(idProcedure)
					.getCodPublicity();
			if (!FacesUtil.isEmptyOrBlank(codPublicity)
					&& !codPublicity.equals(Constant.DEFAULT_VALUE_STRING)) {

				String namePublicity = null;
				List<WSBean> result = FacesUtil.getCurrentUserData()
						.getListWSGroupSellers();
				for (WSBean row : result) {
					if (row.getCode().equals(codPublicity)) {
						namePublicity = row.getNames();
						break;
					}
				}

				listWSGroupSellers = new ArrayList<SelectItem>();
				mapWSGroupSellers = new TreeMap<String, String>();
				mapWSGroupSellers.put(codPublicity, namePublicity);
				listWSGroupSellers.add(new SelectItem(codPublicity,
						namePublicity));
			} else {
				String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
				try {

					String codeBranch = mapBranch.get(idBranch).getCode();

					List<WSBean> result = FacesUtil.getCurrentUserData()
							.getListWSGroupSellers();

					listWSGroupSellers = new ArrayList<SelectItem>();
					mapWSGroupSellers = new TreeMap<String, String>();
					listWSGroupSellers.add(new SelectItem(
							Constant.DEFAULT_VALUE_STRING, label));
					for (WSBean row : result) {
						if (row.getBranch().equals(codeBranch)) {
							mapWSGroupSellers
									.put(row.getCode(), row.getNames());
							listWSGroupSellers.add(new SelectItem(
									row.getCode(), row.getNames()));
						}
					}
				} catch (Exception ex) {
					listWSGroupSellers = new ArrayList<SelectItem>();
					listWSGroupSellers.add(new SelectItem(
							Constant.DEFAULT_VALUE_STRING, label));
				}

				selectedWSGroupSellers = "-1";
			}
		}

		listProcedureDetail = new LinkedList<SelectItem>();
		mapProcedureDetail = new LinkedHashMap<BigDecimal, CrmProcedureDetail>();
		for (CrmProcedureDetail row : tablesService
				.getListProcedureDetailByProcedure(idProcedure)) {
			mapProcedureDetail.put(row.getId(), row);
			listProcedureDetail.add(new SelectItem(row.getId(), row.getName()));
		}

		if (listProcedureDetail.size() > 0) {
			idProcedureDetail = (BigDecimal) listProcedureDetail.get(0)
					.getValue();
		}

		handleProcedureDetailChange();
	}

	public void handleProcedureDetailChange() {
		CrmProcedureDetail procedureDetail = mapProcedureDetail
				.get(idProcedureDetail);

		if (procedureDetail.getTimeDoctor() == 0) {
			idSearch = Constant.APP_TYPE_FOR_DATE_VALUE;
			renderedDoctorWithoutTime = false;
		} else {
			idSearch = Constant.DEFAULT_VALUE;
			renderedDoctorWithoutTime = true;
		}

		if ((procedureDetail.getTimeDoctor() > procedureDetail.getTimeNurses())
				&& (procedureDetail.getTimeDoctor() > procedureDetail
						.getTimeStretchers())) {
			minutes = procedureDetail.getTimeDoctor();
			timeType = Constant.TIME_TYPE_DOCTOR;
		} else if ((procedureDetail.getTimeNurses() > procedureDetail
				.getTimeDoctor())
				&& (procedureDetail.getTimeNurses() > procedureDetail
						.getTimeStretchers())) {
			minutes = procedureDetail.getTimeNurses();
			timeType = Constant.TIME_TYPE_NURSE;
		} else {
			minutes = procedureDetail.getTimeStretchers();
			timeType = Constant.TIME_TYPE_STRETCHERS;
		}

		handleSearchChange();
	}

	public void handleSearchChange() {
		if (this.idSearch.intValue() == Constant.APP_TYPE_FOR_DATE_VALUE
				.intValue()) {
			this.renderedForDate = true;
			this.renderedForDoctor = false;
			this.disabledSearch = false;

			currentDate = new Date();
			handleDateSelect(null);
		} else if (this.idSearch.intValue() == Constant.APP_TYPE_FOR_DOCTOR_VALUE
				.intValue()) {
			this.renderedForDate = false;
			this.renderedForDoctor = true;
			this.disabledSearch = false;

		} else {
			disabledSearch = false;
			this.renderedForDate = false;
			this.renderedForDoctor = false;
			this.disabledSearch = true;
		}
	}

	public void handleClose(CloseEvent event) {
		if (saved) {
			newAction(null);
		}
	}

	public String getDetSelectedCandidate() {
		String result = "";
		if (selectedCandidate != null) {
			String message = FacesUtil.getMessage("app_msg_selected");
			if (this.idSearch.intValue() == Constant.APP_TYPE_FOR_DATE_VALUE
					.intValue()) {
				result = message + " " + selectedCandidate.getDateDetail();
			} else {
				result = message + " " + selectedCandidate.getDoctorDetail();
			}
		}
		return result;
	}

	public void addAppointmentAction() {
		this.selectedCandidate = this.selectedCandidateTemp;
	}

	public void searchAppointMentAction() {
		CrmProcedureDetail procedureDetail = mapProcedureDetail
				.get(idProcedureDetail);
		boolean validateNoRepeat = true;
		infoMessage = null;

		if (selectedPatient == null) {
			infoMessage = FacesUtil.getMessage("app_msg_error_pat");
		} else if (selectedPatient.getId() == null) {
			infoMessage = FacesUtil.getMessage("pat_msg_exists_sap_2");
		} else {

			if (this.renderedForDate) {
				if (currentTime == 0) {
					String field = FacesUtil.getMessage("app_start_hour");
					infoMessage = FacesUtil.getMessage("glb_required", field);
				}
			}

			if (procedureDetail.getNoRepeat()
					&& procedureDetail.getNoRepeatDays() > 0
					&& infoMessage == null) {
				Date maxDate = processService.getMaxDateByProcedure(
						selectedPatient.getId(), procedureDetail.getId());
				if (maxDate != null) {
					maxDate = FacesUtil.getDateWithoutTime(maxDate);
					Date currentDate = null;
					if (this.renderedForDate) {
						currentDate = new Date(this.currentTime);
					} else {
						currentDate = new Date(this.currentDate.getTime());
					}

					currentDate = FacesUtil.getDateWithoutTime(currentDate);
					long diff = currentDate.getTime() - maxDate.getTime();
					diff = diff / (1000 * 60 * 60 * 24);
					if (diff < procedureDetail.getNoRepeatDays()) {
						validateNoRepeat = false;
					}
				}
			}
		}

		if ((validateNoRepeat || edit) && infoMessage == null) {
			if (this.renderedForDate) {
				ResultSearchAppointment resultSearchAppointment = processService
						.getScheduleAppointmentForDate(mapBranch.get(idBranch),
								new Date(this.currentTime), procedureDetail);
				listAppointment = resultSearchAppointment.getListCandidate();
				infoMessage = resultSearchAppointment.getMessage();
			} else if (this.renderedForDoctor) {
				CrmDoctor doctor = mapDoctor.get(selected.getCrmDoctor()
						.getId());
				ResultSearchAppointment resultSearchAppointment = processService
						.getScheduleAppointmentForDoctor(
								mapBranch.get(idBranch), doctor,
								this.appointmentsNumber, procedureDetail,
								this.currentDate);
				listAppointment = resultSearchAppointment.getListCandidate();
				infoMessage = resultSearchAppointment.getMessage();
			}

			modelAppointment = new CandidateDataModel(listAppointment);

			if (listAppointment.size() > 0) {
				selectedCandidateTemp = listAppointment.get(0);
			} else {
				selectedCandidate = null;
				selectedCandidateTemp = null;
			}
		} else {
			listAppointment = new ArrayList<Candidate>();
			modelAppointment = new CandidateDataModel(listAppointment);
			selectedCandidate = null;
			selectedCandidateTemp = null;
			if (!validateNoRepeat) {
				String message = procedureDetail.getNoRepeatDays().toString();
				infoMessage = FacesUtil.getMessage("app_msg_error_procedure",
						message);
			}
		}
	}

	public void valdiateAction() {
		String appType = FacesUtil.getParam("APP_TYPE");
		infoMessage = "";
		validate = true;

		// validar Selección Pauta
		if (this.selectedWSGroupSellers.equals(Constant.DEFAULT_VALUE_STRING)) {
			String field = FacesUtil.getMessage("app_seller_group");
			infoMessage = FacesUtil.getMessage("glb_required", field);
			validate = false;
		}

		// validar Selección Paciente
		if (this.selectedPatient == null) {
			infoMessage = FacesUtil.getMessage("app_msg_error_pat");
			validate = false;
		} else {
			if (this.selectedPatient.getId() == null) {
				infoMessage = FacesUtil.getMessage("app_msg_error_pat_sap");
				validate = false;
			}
		}

		// validar Selección Cita
		if ((selectedCandidate == null) && (appType.equals("ORDINARY"))) {
			infoMessage = FacesUtil.getMessage("app_msg_error_app");
			validate = false;
		}
	}

	public void saveAction() {
		String appType = FacesUtil.getParam("APP_TYPE");
		infoMessage = "";
		validate = true;

		// validar Selección Pauta
		if (this.selectedWSGroupSellers.equals(Constant.DEFAULT_VALUE_STRING)) {
			String field = FacesUtil.getMessage("app_seller_group");
			infoMessage = FacesUtil.getMessage("glb_required", field);
			validate = false;
		}

		// validar Selección Paciente
		if (this.selectedPatient == null) {
			infoMessage = FacesUtil.getMessage("app_msg_error_pat");
			validate = false;
		} else {
			if (this.selectedPatient.getId() == null) {
				infoMessage = FacesUtil.getMessage("app_msg_error_pat_sap");
				validate = false;
			}
		}

		// validar Selección Cita
		if ((selectedCandidate == null) && (appType.equals("ORDINARY"))) {
			infoMessage = FacesUtil.getMessage("app_msg_error_app");
			validate = false;
		}

		if (validate) {

			CrmProcedureDetail procedureDetail = mapProcedureDetail
					.get(idProcedureDetail);

			CrmBranch branch = mapBranch.get(idBranch);

			int validateApp = 0;
			if (appType.equals("ORDINARY")) {
				validateApp = processService.validateAppointmentForDate(
						selected.getCrmBranch().getId(),
						selectedCandidate.getStartDate(),
						selectedCandidate.getEndDate(), procedureDetail,
						selectedCandidate.getDoctor().getId(),
						selectedPatient.getId(), timeType, edit);
			} else {
				CrmDoctor doctor = mapDoctor.get(selected.getCrmDoctor()
						.getId());
				selectedCandidate = new Candidate();
				selectedCandidate.setBranch(branch.getName());
				selectedCandidate.setProcedure(procedureDetail.getName());
				selectedCandidate.setStartDate(currentDate);
				selectedCandidate.setEndDate(FacesUtil.addMinutesToDate(
						currentDate, procedureDetail.getTimeDoctor()));
				selectedCandidate.setDoctor(doctor);
			}

			if (validateApp != 0) {
				switch (validateApp) {
				case -1:
					infoMessage = FacesUtil.getMessage("app_msg_error_1");
					break;
				case -2:
					infoMessage = FacesUtil.getMessage("app_msg_error_2");
					break;
				case -3:
					infoMessage = FacesUtil.getMessage("app_msg_error_3");
					break;
				case -4:
					infoMessage = FacesUtil.getMessage("app_msg_error_4");
					break;
				}

			} else {
				selected.setCrmPatient(selectedPatient);
				selected.setPatientNames(selectedPatient.getFirstnames() + " "
						+ selectedPatient.getSurnames());
				selected.setCrmDoctor(selectedCandidate.getDoctor());
				selected.setCrmBranch(branch);
				selected.setCrmProcedureDetail(procedureDetail);

				selected.setCodPublicity(selectedWSGroupSellers);
				selected.setNamePublicity(mapWSGroupSellers
						.get(selectedWSGroupSellers));

				selected.setStartAppointmentDate(selectedCandidate
						.getStartDate());
				selected.setEndAppointmentDate(selectedCandidate.getEndDate());
				selected.setCloseAppointment(false);

				if (appType.equals("ORDINARY")) {
					selected.setUntimely(false);
					selected.setState(Constant.APP_STATE_CONFIRMED);
				} else {
					selected.setUntimely(true);
					selected.setState(Constant.APP_STATE_CHECKED);
				}

				selected.setCrmUserByIdUserCreate(FacesUtil.getCurrentUser());
				selected.setDateCreate(new Date());

				CrmAppointment crmAppointment = processService
						.saveAppointment(selected);
				infoMessage = FacesUtil.getMessage("app_msg_ok",
						crmAppointment.getCode());

				saved = true;
			}
		}
	}

	public void handleDateSelect(SelectEvent event) {
		Date date = FacesUtil.getDateWithoutTime(new Date());
		if (event != null) {
			date = (Date) event.getObject();
		}

		ResultSearchDate resultSearchDate = processService
				.getListcandidatesHours(date, mapBranch.get(idBranch), minutes,
						timeType);
		List<Date> list = resultSearchDate.getListDate();
		infoMessageDate = resultSearchDate.getMessage();

		listTimes = new ArrayList<SelectItem>();
		String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
		listTimes.add(new SelectItem(null, label));

		for (Date row : list) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(row);
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);

			SelectItem item = new SelectItem();
			item.setValue(row.getTime());
			item.setLabel(hour + ":" + (minute == 0 ? "00" : minute));
			listTimes.add(item);
		}
	}

	public void addPatient(ActionEvent event) {
		boolean validate = true;
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedPatientTemp.getId() == null) {
			validate = false;
		} else {
			selectedPatient = selectedPatientTemp;
		}
		context.addCallbackParam("validate", validate);
	}

	public String searchRedirectPatient() {
		PatientBacking patientBacking = FacesUtil.findBean("patientBacking");
		patientBacking.setSelected(new CrmPatient());
		patientBacking.setDocSearch(this.docPatient);
		patientBacking.searchAction();
		return "/pages/processes/patient?faces-redirect=true";
	}

}
