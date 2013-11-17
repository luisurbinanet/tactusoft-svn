package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
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
public class AppointmentPatientBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<CrmAppointment> listAppointment;
	private AppointmentDataModel appointmentModel;
	private CrmAppointment[] selectedsAppointment;
	private CrmAppointment selectedAppointment;

	private List<SelectItem> listDoctor;
	private Map<BigDecimal, CrmDoctor> mapDoctor;
	private BigDecimal idDoctor;

	private boolean disabledSaveButton;

	public AppointmentPatientBacking() {
		newAction(null);
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

	public CrmAppointment[] getSelectedsAppointment() {
		return selectedsAppointment;
	}

	public void setSelectedsAppointment(CrmAppointment[] selectedsAppointment) {
		this.selectedsAppointment = selectedsAppointment;
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
		selectedsAppointment = null;
		selectedAppointment = new CrmAppointment();

		selectedPatient = null;
		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;

		optionSearchPatient = 1;
		cleanPatientFields();
	}

	public void searchAppoinmnetConfirmedAction() {
		if (selectedPatient.getCodeSap() == null
				|| selectedPatient.getCodeSap()
						.equals(selectedPatient.getDoc())) {
			String message = FacesUtil.getMessage("sal_msg_error_con");
			FacesUtil.addWarn(message);
		} else {
			listAppointment = processService.listAppointmentByPatient(
					selectedPatient.getId(), Constant.APP_STATE_CONFIRMED);
			appointmentModel = new AppointmentDataModel(listAppointment);
			if (listAppointment.size() > 0) {
				selectedAppointment = listAppointment.get(0);
			}
		}
	}

	public void searchAppoinmnetConfirmedWithoutValidAction() {
		listAppointment = processService.listAppointmentByPatient(
				selectedPatient.getId(), Constant.APP_STATE_CONFIRMED);
		appointmentModel = new AppointmentDataModel(listAppointment);
		if (listAppointment.size() > 0) {
			selectedAppointment = listAppointment.get(0);
		}
	}

	public boolean isDisabledAppointment() {
		if (this.listAppointment.size() == 0) {
			return true;
		}
		return false;
	}

	public void cancelAppointmentAction(ActionEvent actionEvent) {
		String code = "";
		selectedAppointment.setCrmUserByIdUserCanceled(FacesUtil
				.getCurrentUser());
		selectedAppointment.setDateCanceled(new Date());
		selectedAppointment.setState(Constant.APP_STATE_CANCELED);
		processService.saveAppointment(selectedAppointment);
		code = selectedAppointment.getCode();

		searchAppoinmnetConfirmedWithoutValidAction();

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

			searchAppoinmnetConfirmedAction();

			message = FacesUtil.getMessage("app_msg_check", code);
			FacesUtil.addInfo(message);
			saved = true;
		}

		RequestContext context = RequestContext.getCurrentInstance();
		context.addCallbackParam("saved", saved);
	}

	public boolean isRenderedFields() {
		boolean result = false;
		if (selectedPatient != null) {
			if (selectedPatient.getCrmOccupation() == null) {
				result = true;
			}
		} else {
			result = false;
		}
		return result;
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

	public void addPatientAction(ActionEvent event) {
		searchAppoinmnetConfirmedAction();
	}

	public void addPatientWithoutValidAction(ActionEvent event) {
		searchAppoinmnetConfirmedWithoutValidAction();
	}

	public String addGoContactAction() {
		PatientBacking patientBacking = FacesUtil.findBean("patientBacking");
		patientBacking.setSelectedPatient(selectedPatient);
		patientBacking.getSelectedPatient().setCodeSap(null);
		patientBacking.setNewRecord(true);
		patientBacking.getListProfile();
		patientBacking.getListCountry();
		patientBacking.setIdCountry(selectedPatient.getIdCountry());
		patientBacking.handleCountryChange();
		patientBacking.setIdRegion(selectedPatient.getIdRegion());
		patientBacking.handleRegionChange();
		patientBacking.setIdCity(selectedPatient.getIdCity());
		return "/pages/processes/patient?faces-redirect=true";
	}

	public boolean compareDates() {
		Date currentDate = FacesUtil
				.getDateWithoutTime(this.selectedAppointment
						.getStartAppointmentDate());
		Date today = FacesUtil.getDateWithoutTime(new Date());
		int result = today.compareTo(currentDate);
		return result == 0 ? false : true;

	}

	public void editAppoinmnetAction() {
		AppointmentBacking appointmentEditBacking = FacesUtil
				.findBean("appointmentBacking");

		appointmentEditBacking.newAction(null);
		appointmentEditBacking.setSelected(selectedAppointment);
		appointmentEditBacking.setSelectedPatient(selectedAppointment
				.getCrmPatient());
		appointmentEditBacking.setCurrentDate(new Date());
		appointmentEditBacking.setGenerateNew(false);

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
		appointmentEditBacking.setIdProcedureDetail(selectedAppointment
				.getCrmProcedureDetail().getId());
		appointmentEditBacking.handleProcedureDetailChange();
		appointmentEditBacking.setSelectedWSGroupSellers(selectedAppointment
				.getCodPublicity());
		appointmentEditBacking.setEdit(true);
		appointmentEditBacking.setSaved(false);
		appointmentEditBacking.setFromPage("SEARCH");

		// appointmentEditBacking.handleBranchChange();

		Map<String, Object> options = new HashMap<String, Object>();
		options.put("modal", true);
		options.put("draggable", false);
		options.put("resizable", false);
		options.put("contentWidth", 1200);
		options.put("contentHeight", 800);

		RequestContext.getCurrentInstance().openDialog("appointmentEditDialog",
				options, null);
	}
}
