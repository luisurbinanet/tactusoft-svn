package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.execute.CustomerExecute;
import com.tactusoft.webservice.client.objects.Bapikna111;

@Named
@Scope("view")
public class AppointmentPatientBacking implements Serializable {

	@Inject
	private TablesBo tablesService;

	@Inject
	private ProcessBo processService;

	private static final long serialVersionUID = 1L;

	private List<Patient> listPatient;
	private PatientDataModel patientModel;
	private Patient selectedPatient;
	private String namePatient;

	private List<CrmAppointment> listAppointment;
	private AppointmentDataModel appointmentModel;
	private CrmAppointment[] selectedsAppointment;
	private CrmAppointment selectedAppointment;

	private boolean disabledSaveButton;

	public AppointmentPatientBacking() {
		newAction(null);
	}

	public TablesBo getTablesService() {
		return tablesService;
	}

	public void setTablesService(TablesBo tablesService) {
		this.tablesService = tablesService;
	}

	public List<Patient> getListPatient() {
		return listPatient;
	}

	public void setListPatient(List<Patient> listPatient) {
		this.listPatient = listPatient;
	}

	public String getNamePatient() {
		return namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public PatientDataModel getPatientModel() {
		return patientModel;
	}

	public void setPatientModel(PatientDataModel patientModel) {
		this.patientModel = patientModel;
	}

	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
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

		selectedPatient = new Patient();
		listPatient = new LinkedList<Patient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;

		namePatient = "";
	}

	public void searchAppoinmnetConfirmedAction() {
		if (selectedPatient.getSAPCode() == null) {
			String message = FacesUtil.getMessage("sal_msg_error_pat");
			FacesUtil.addError(message);
		} else {
			listAppointment = processService.listAppointmentByPatient(
					selectedPatient.getSAPCode(), Constant.APP_STATE_CONFIRMED);
			appointmentModel = new AppointmentDataModel(listAppointment);
		}
	}

	public void searchPatientAction() {
		if (this.namePatient.isEmpty()) {
		} else {
			Bapikna111[] result = CustomerExecute.find(this.namePatient, 0);
			listPatient = new ArrayList<Patient>();
			if (result != null) {
				for (Bapikna111 row : result) {
					Patient patient = new Patient();
					patient.setSAPCode(row.getCustomer());
					patient.setNames(row.getFieldvalue());
					listPatient.add(patient);
				}
				patientModel = new PatientDataModel(listPatient);
			}
		}
	}

	public boolean isDisabledAddPatient() {
		if (listPatient.size() == 0) {
			return true;
		} else if (listPatient.size() == 1) {
			if (listPatient.get(0).getSAPCode().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public boolean isDisabledSelectedPatient() {
		if (selectedPatient.getSAPCode() == null) {
			return true;
		}
		return false;
	}

	public boolean isDisabledAppointment() {
		if (this.listAppointment.size() == 0) {
			return true;
		}
		return false;
	}

	public void cancelAppointmentAction(ActionEvent actionEvent) {
		String codes = "";
		for (CrmAppointment row : selectedsAppointment) {
			row.setState(Constant.APP_STATE_CANCELED);
			processService.saveAppointment(row);
			codes = codes + row.getCode() + ",";
		}

		codes = codes.substring(0, codes.length() - 1);
		searchAppoinmnetConfirmedAction();

		String message = FacesUtil.getMessage("app_msg_cancel", codes);
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
