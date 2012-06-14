package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomLists;
import com.tactusoft.webservice.client.execute.CustomerExecute;

public class BaseBacking implements Serializable {

	@Inject
	protected TablesBo tablesService;

	@Inject
	protected ProcessBo processService;

	private static final long serialVersionUID = 1L;

	protected List<Patient> listPatient;
	protected PatientDataModel patientModel;
	protected Patient selectedPatient;
	protected String docPatient;
	protected String namePatient;
	protected int optionSearchPatient;

	protected List<SelectItem> listWSDoctor;
	protected Map<String, String> mapWSDoctor;
	protected String selectedWSDoctor;

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

	public String getDocPatient() {
		return docPatient;
	}

	public void setDocPatient(String docPatient) {
		this.docPatient = docPatient;
	}

	public String getNamePatient() {
		return namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public int getOptionSearchPatient() {
		return optionSearchPatient;
	}

	public void setOptionSearchPatient(int optionSearchPatient) {
		this.optionSearchPatient = optionSearchPatient;
	}

	public void searchPatientAction() {
		if ((optionSearchPatient == 1 && this.docPatient.isEmpty())
				|| (optionSearchPatient == 2 && this.namePatient.isEmpty())) {

			this.listPatient = new ArrayList<Patient>();
			this.patientModel = new PatientDataModel(listPatient);

		} else {
			List<WSBean> result = null;
			if (optionSearchPatient == 1) {
				result = CustomerExecute.findByDoc(this.docPatient, 0);
			} else {
				result = CustomerExecute.findByName(this.namePatient, 0);
			}
			listPatient = new ArrayList<Patient>();
			if (result != null) {
				for (WSBean row : result) {
					Patient patient = new Patient();
					patient.setSAPCode(row.getCode());
					patient.setNames(row.getNames());
					listPatient.add(patient);
				}
				patientModel = new PatientDataModel(listPatient);
			}
		}
	}

	public List<SelectItem> getListWSDoctor() {
		if (listWSDoctor == null) {
			List<WSBean> result = CustomLists
					.getDoctors(
							"http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zweblist/300/zweblist/zweblist",
							"TACTUSOFT", "AFFINITY");
			listWSDoctor = new ArrayList<SelectItem>();
			mapWSDoctor = new HashMap<String, String>();
			for (WSBean row : result) {
				mapWSDoctor.put(row.getCode(), row.getNames());
				listWSDoctor.add(new SelectItem(row.getCode(), row.getNames()));
			}
		}
		return listWSDoctor;
	}

	public void setListWSDoctor(List<SelectItem> listWSDoctor) {
		this.listWSDoctor = listWSDoctor;
	}

	public Map<String, String> getMapWSDoctor() {
		return mapWSDoctor;
	}

	public void setMapWSDoctor(Map<String, String> mapWSDoctor) {
		this.mapWSDoctor = mapWSDoctor;
	}

	public String getSelectedWSDoctor() {
		return selectedWSDoctor;
	}

	public void setSelectedWSDoctor(String selectedWSDoctor) {
		this.selectedWSDoctor = selectedWSDoctor;
	}

}
