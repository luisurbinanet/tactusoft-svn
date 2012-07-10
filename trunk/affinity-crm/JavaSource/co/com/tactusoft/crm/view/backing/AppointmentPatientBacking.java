package co.com.tactusoft.crm.view.backing;

import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
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

	public void newAction(ActionEvent event) {
		listAppointment = new LinkedList<CrmAppointment>();
		appointmentModel = new AppointmentDataModel(listAppointment);
		selectedsAppointment = null;
		selectedAppointment = new CrmAppointment();

		selectedPatient = new CrmPatient();
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
		selectedAppointment.setState(Constant.APP_STATE_CANCELED);
		processService.saveAppointment(selectedAppointment);
		code = selectedAppointment.getCode();

		searchAppoinmnetConfirmedAction();

		String message = FacesUtil.getMessage("app_msg_cancel", code);
		FacesUtil.addInfo(message);

	}

	public void checkAppointmentAction(ActionEvent actionEvent) {
		String code = "";
		selectedAppointment.setState(Constant.APP_STATE_CHECKED);
		processService.saveAppointment(selectedAppointment);
		code = selectedAppointment.getCode();

		searchAppoinmnetConfirmedAction();

		String message = FacesUtil.getMessage("app_msg_check", code);
		FacesUtil.addInfo(message);
	}

}
