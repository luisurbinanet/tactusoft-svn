package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.execute.CustomerExecute;
import com.tactusoft.webservice.client.objects.Bapikna111;

@Named
@Scope("view")
public class AppointmentBacking implements Serializable {

	private static final long serialVersionUID = -7936516411298237407L;

	private List<Patient> listPatient;
	private PatientDataModel patientModel;
	private Patient selectedPatient;
	private String namePatient;

	private boolean disabledSaveButton;

	public AppointmentBacking() {
		newAction(null);
	}

	public List<Patient> getListPatient() {
		return listPatient;
	}

	public void setListPatient(List<Patient> listPatient) {
		this.listPatient = listPatient;
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

	public String getNamePatient() {
		return namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	//
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

	public void newAction(ActionEvent event) {
		selectedPatient = new Patient();
		listPatient = new LinkedList<Patient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;
	}

	public void saveAction() {
	}

}
