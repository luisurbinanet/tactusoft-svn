package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

@Named
@Scope("session")
public class SearchByPatientBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> listStates;

	private Date startDate;
	private Date endDate;
	private int state;

	private List<CrmAppointment> listAppointment;
	private AppointmentDataModel appointmentModel;
	private CrmAppointment selectedAppointment;

	private boolean disabledSaveButton;

	private List<SelectItem> listDoctor;
	private Map<BigDecimal, CrmDoctor> mapDoctor;
	private BigDecimal idDoctor;

	public SearchByPatientBacking() {
		newAction(null);
	}

	public List<SelectItem> getListStates() {
		return listStates;
	}

	public void setListStates(List<SelectItem> listStates) {
		this.listStates = listStates;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<CrmAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<CrmAppointment> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public AppointmentDataModel getAppointmentModel() {
		return appointmentModel;
	}

	public void setAppointmentModel(AppointmentDataModel appointmentModel) {
		this.appointmentModel = appointmentModel;
	}

	public CrmAppointment getSelectedAppointment() {
		return selectedAppointment;
	}

	public void setSelectedAppointment(CrmAppointment selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
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

	public BigDecimal getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(BigDecimal idDoctor) {
		this.idDoctor = idDoctor;
	}

	public void newAction(ActionEvent event) {
		listAppointment = new LinkedList<CrmAppointment>();
		appointmentModel = new AppointmentDataModel(listAppointment);
		selectedAppointment = new CrmAppointment();

		selectedPatient = new CrmPatient();
		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;

		optionSearchPatient = 1;
		docPatient = "";
		namePatient = "";
		startDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH, 1);
		endDate = calendar.getTime();

		listStates = new LinkedList<SelectItem>();

		String message = FacesUtil.getMessage(Constant.ALL_LABEL);
		listStates.add(new SelectItem(Constant.DEFAULT_VALUE, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_CONFIRMED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_CONFIRMED, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_CANCELED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_CANCELED, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_CHECKED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_CHECKED, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_ATTENDED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_ATTENDED, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_NOATTENDED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_NOATTENDED, message));
	}

	public void generateListDoctor(ActionEvent event) {
		listDoctor = new LinkedList<SelectItem>();
		mapDoctor = new LinkedHashMap<BigDecimal, CrmDoctor>();
		for (CrmDoctor row : tablesService
				.getListDoctorByBranch(selectedAppointment.getCrmBranch()
						.getId())) {
			mapDoctor.put(row.getId(), row);
			listDoctor.add(new SelectItem(row.getId(), row.getNames()));
		}

		idDoctor = selectedAppointment.getCrmDoctor().getId();
		if (selectedPatient.getCrmOccupation() != null) {
			idOccupation = selectedPatient.getCrmOccupation().getId();
		}
		typeHousing = selectedPatient.getTypeHousing();
		neighborhood = selectedPatient.getNeighborhood();
	}

	public void searchAppoinmentAction() {
		if (FacesUtil.isEmptyOrBlank(selectedPatient.getFirstnames())) {
			String message = FacesUtil.getMessage("sal_msg_error_pat");
			FacesUtil.addError(message);
		} else {
			listAppointment = processService.listAppointmentByPatient(
					selectedPatient.getId(), this.state, startDate, endDate);
			appointmentModel = new AppointmentDataModel(listAppointment);

			if (listAppointment.size() > 0) {
				selectedAppointment = listAppointment.get(0);
			}
		}
	}

	public boolean isDisabledAppointment() {
		if (this.listAppointment.size() == 0) {
			return true;
		}
		return false;
	}

	public String editAppoinmnetAction() {
		AppointmentBacking appointmentEditBacking = FacesUtil
				.findBean("appointmentBacking");

		appointmentEditBacking.newAction(null);
		appointmentEditBacking.setSelected(selectedAppointment);
		appointmentEditBacking.setSelectedPatient(selectedAppointment
				.getCrmPatient());
		appointmentEditBacking.setCurrentDate(new Date());

		appointmentEditBacking.setListBranch(new LinkedList<SelectItem>());
		appointmentEditBacking
				.setMapBranch(new LinkedHashMap<BigDecimal, CrmBranch>());
		for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
			appointmentEditBacking.getMapBranch().put(row.getId(), row);
			appointmentEditBacking.getListBranch().add(
					new SelectItem(row.getId(), row.getName()));
			if (row.getId().longValue() == selectedAppointment.getCrmBranch()
					.getId().longValue()) {
				appointmentEditBacking.setSaved(false);
				break;
			}
		}
		appointmentEditBacking.setIdBranch(selectedAppointment.getCrmBranch()
				.getId());
		appointmentEditBacking.handleBranchChange();
		appointmentEditBacking.setIdProcedure(selectedAppointment
				.getCrmProcedureDetail().getCrmProcedure().getId());
		appointmentEditBacking.handleProcedureChange();
		appointmentEditBacking.setIdProcedureDetail(selectedAppointment
				.getCrmProcedureDetail().getId());
		appointmentEditBacking.handleProcedureDetailChange();
		appointmentEditBacking.setSelectedWSGroupSellers(selectedAppointment
				.getCodPublicity());
		appointmentEditBacking.setEdit(true);
		appointmentEditBacking.setSaved(false);
		appointmentEditBacking.setFromPage("SEARCH");

		appointmentEditBacking.handleBranchChange();

		return "/pages/processes/appointmentEdit.jsf?faces-redirect=true";
	}

	public void cancelAppointmentAction(ActionEvent actionEvent) {
		String code = "";

		selectedAppointment.setCrmUserByIdUserCanceled(FacesUtil
				.getCurrentUser());
		selectedAppointment.setDateCanceled(new Date());
		selectedAppointment.setState(Constant.APP_STATE_CANCELED);
		processService.saveAppointment(selectedAppointment);
		code = selectedAppointment.getCode();

		searchAppoinmentAction();

		String message = FacesUtil.getMessage("app_msg_cancel", code);
		FacesUtil.addInfo(message);
	}

	public void checkAppointmentAction(ActionEvent actionEvent) {
		String message = null;
		String code = "";
		boolean saved = false;

		if (idOccupation == null || idOccupation.intValue() == 0
				|| FacesUtil.isEmptyOrBlank(neighborhood)
				|| FacesUtil.isEmptyOrBlank(typeHousing)) {
			message = FacesUtil.getMessage("glb_required_all");
			FacesUtil.addWarn(message);
		} else {

			if (selectedPatient.getCrmOccupation() == null) {
				selectedPatient.setTypeHousing(typeHousing);
				selectedPatient.setNeighborhood(neighborhood);
				selectedPatient.setCrmOccupation(mapOccupation
						.get(idOccupation));
				processService.savePatient(selectedPatient, false, false, null);
			}

			CrmDoctor doctor = mapDoctor.get(idDoctor);
			selectedAppointment.setCrmDoctor(doctor);

			selectedAppointment.setCrmUserByIdUserChecked(FacesUtil
					.getCurrentUser());
			selectedAppointment.setDateChecked(new Date());
			selectedAppointment.setState(Constant.APP_STATE_CHECKED);
			processService.saveAppointment(selectedAppointment);
			code = selectedAppointment.getCode();

			searchAppoinmentAction();

			message = FacesUtil.getMessage("app_msg_check", code);
			FacesUtil.addInfo(message);
			saved = true;
		}

		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("saved", saved);
	}

	public void openAppointmentAction(ActionEvent actionEvent) {
		String message = null;
		if (FacesUtil.isEmptyOrBlank(this.selectedAppointment.getObsOpened())) {
			String field = FacesUtil.getMessage("app_obs");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			String code = "";
			selectedAppointment.setCrmUserByIdUserOpened(FacesUtil
					.getCurrentUser());
			selectedAppointment.setDateOpened(new Date());
			selectedAppointment.setState(Constant.APP_STATE_CHECKED);
			selectedAppointment.setCloseAppointment(false);
			processService.saveAppointment(selectedAppointment);
			code = selectedAppointment.getCode();

			searchAppoinmentAction();

			message = FacesUtil.getMessage("app_msg_open", code);
			FacesUtil.addInfo(message);
		}
	}

	public String addGoContactAction() {
		ContactBacking contactBacking = FacesUtil.findBean("contactBacking");
		contactBacking.setSelectedPatient(selectedPatient);
		contactBacking.setNewRecord(false);
		return "/pages/processes/contact?faces-redirect=true";
	}

	public boolean isRenderedFields() {
		boolean result = false;
		if (selectedAppointment != null
				&& selectedAppointment.getCrmPatient() != null) {
			if (selectedAppointment.getCrmPatient().getCrmOccupation() == null) {
				result = true;
			}
		} else {
			result = false;
		}
		return result;
	}

}