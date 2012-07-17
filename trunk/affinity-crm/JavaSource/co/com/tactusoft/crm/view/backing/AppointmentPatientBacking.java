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
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

@Named
@Scope("view")
public class AppointmentPatientBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<CrmAppointment> listAppointment;
	private AppointmentDataModel appointmentModel;
	private CrmAppointment[] selectedsAppointment;
	private CrmAppointment selectedAppointment;

	private List<SelectItem> listOccupation;
	private Map<BigDecimal, CrmOccupation> mapOccupation;
	private BigDecimal idOccupation;

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

	public List<SelectItem> getListOccupation() {
		if (listOccupation == null) {
			listOccupation = new LinkedList<SelectItem>();
			mapOccupation = new HashMap<BigDecimal, CrmOccupation>();
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listOccupation.add(new SelectItem(null, label));
			for (CrmOccupation row : tablesService.getListOccupationActive()) {
				mapOccupation.put(row.getId(), row);
				listOccupation.add(new SelectItem(row.getId(), row.getName()));
			}
		}
		return listOccupation;
	}

	public void setListOccupation(List<SelectItem> listOccupation) {
		this.listOccupation = listOccupation;
	}

	public Map<BigDecimal, CrmOccupation> getMapOccupation() {
		return mapOccupation;
	}

	public void setMapOccupation(Map<BigDecimal, CrmOccupation> mapOccupation) {
		this.mapOccupation = mapOccupation;
	}

	public BigDecimal getIdOccupation() {
		return idOccupation;
	}

	public void setIdOccupation(BigDecimal idOccupation) {
		this.idOccupation = idOccupation;
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
		namePatient = "";
	}

	public void searchAppoinmnetConfirmedAction() {
		if (selectedPatient.getCodeSap() == null) {
			String message = FacesUtil.getMessage("sal_msg_error_pat");
			FacesUtil.addError(message);
		} else {
			listAppointment = processService.listAppointmentByPatient(
					selectedPatient.getCodeSap(), Constant.APP_STATE_CONFIRMED);
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

	public void cancelAppointmentAction(ActionEvent actionEvent) {
		String code = "";
		selectedAppointment.setIdUserCanceled(FacesUtil.getCurrentIdUsuario());
		selectedAppointment.setDateCanceled(new Date());
		selectedAppointment.setState(Constant.APP_STATE_CANCELED);
		processService.saveAppointment(selectedAppointment);
		code = selectedAppointment.getCode();

		searchAppoinmnetConfirmedAction();

		String message = FacesUtil.getMessage("app_msg_cancel", code);
		FacesUtil.addInfo(message);

	}

	public void checkAppointmentAction(ActionEvent actionEvent) {
		String message = null;
		String code = "";
		boolean saved = false;

		if (idOccupation == null || idOccupation.intValue() == 0
				|| FacesUtil.isEmptyOrBlank(selectedPatient.getNeighborhood())
				|| FacesUtil.isEmptyOrBlank(selectedPatient.getTypeHousing())) {
			message = FacesUtil.getMessage("glb_required_all");
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setCrmOccupation(mapOccupation.get(idOccupation));
			processService.savePatient(selectedPatient);

			selectedAppointment.setIdUserChecked(FacesUtil
					.getCurrentIdUsuario());
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
	}
}
