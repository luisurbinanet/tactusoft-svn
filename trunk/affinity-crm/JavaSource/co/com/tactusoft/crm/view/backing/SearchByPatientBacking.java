package co.com.tactusoft.crm.view.backing;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import net.sf.jasperreports.engine.JRException;

import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.GenerateFormulaPDF;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmMedication;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;
import co.com.tactusoft.crm.view.datamodel.MedicationDataModel;
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

	private List<CrmMedication> listMedication;
	private MedicationDataModel medicationModel;

	private List<CrmMedication> listTherapy;
	private MedicationDataModel therapyModel;

	private List<CrmMedication> listExam;
	private MedicationDataModel examModel;

	private String selectedTab;

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

	public List<CrmMedication> getListMedication() {
		return listMedication;
	}

	public void setListMedication(List<CrmMedication> listMedication) {
		this.listMedication = listMedication;
	}

	public MedicationDataModel getMedicationModel() {
		return medicationModel;
	}

	public void setMedicationModel(MedicationDataModel medicationModel) {
		this.medicationModel = medicationModel;
	}

	public List<CrmMedication> getListTherapy() {
		return listTherapy;
	}

	public void setListTherapy(List<CrmMedication> listTherapy) {
		this.listTherapy = listTherapy;
	}

	public MedicationDataModel getTherapyModel() {
		return therapyModel;
	}

	public void setTherapyModel(MedicationDataModel therapyModel) {
		this.therapyModel = therapyModel;
	}

	public List<CrmMedication> getListExam() {
		return listExam;
	}

	public void setListExam(List<CrmMedication> listExam) {
		this.listExam = listExam;
	}

	public MedicationDataModel getExamModel() {
		return examModel;
	}

	public void setExamModel(MedicationDataModel examModel) {
		this.examModel = examModel;
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
		telPatient = "";
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

		selectedsBranchObject = null;

		selectedTab = Constant.MATERIAL_TYPE_MEDICINE;
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

	public void searchMedicationAction() {
		listMedication = processService.getListMedicationByAppointment(
				selectedAppointment.getId(), Constant.MATERIAL_TYPE_MEDICINE);
		medicationModel = new MedicationDataModel(listMedication);

		listTherapy = processService.getListMedicationByAppointment(
				selectedAppointment.getId(), Constant.MATERIAL_TYPE_THERAPY);
		therapyModel = new MedicationDataModel(listTherapy);

		listExam = processService.getListMedicationByAppointment(
				selectedAppointment.getId(), Constant.MATERIAL_TYPE_EXAMS);
		examModel = new MedicationDataModel(listExam);
	}

	public void onTabChange(TabChangeEvent event) {
		String id = event.getTab().getId();
		if (id.equalsIgnoreCase("tabMedication")) {
			selectedTab = Constant.MATERIAL_TYPE_MEDICINE;
		} else if (id.equalsIgnoreCase("tabTherapy")) {
			selectedTab = Constant.MATERIAL_TYPE_THERAPY;
		} else {
			selectedTab = Constant.MATERIAL_TYPE_EXAMS;
		}
	}

	public boolean isDisabledPrintFormula() {
		boolean result = false;
		if (selectedTab.equals(Constant.MATERIAL_TYPE_MEDICINE)) {
			if (this.listAppointment == null
					|| this.listAppointment.size() == 0) {
				result = true;
			}
		} else if (selectedTab.equals(Constant.MATERIAL_TYPE_THERAPY)) {
			if (this.listTherapy == null || this.listTherapy.size() == 0) {
				result = true;
			}
		} else {
			if (this.listExam == null || this.listExam.size() == 0) {
				result = true;
			}
		}
		return result;
	}

	public void printFormulaAction() {
		try {
			GenerateFormulaPDF.PDF(selectedAppointment.getId(), selectedTab);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}