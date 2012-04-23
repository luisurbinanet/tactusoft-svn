package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

@Named
@Scope("view")
public class PatientBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Patient> list;
	private PatientDataModel model;
	private Patient selected;

	private List<String> selectedSendOptions;

	public PatientBacking() {
		newAction();
	}

	public List<Patient> getList() {
		return list;
	}

	public void setList(List<Patient> list) {
		this.list = list;
	}

	public PatientDataModel getModel() {
		if (model == null) {
			// list = tableService.getListSpeciality();
			model = new PatientDataModel(list);
		}
		return model;
	}

	public void setModel(PatientDataModel model) {
		this.model = model;
	}

	public Patient getSelected() {
		return selected;
	}

	public void setSelected(Patient selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new Patient();
	}

	public List<String> getSelectedSendOptions() {
		return selectedSendOptions;
	}

	public void setSelectedSendOptions(List<String> selectedSendOptions) {
		this.selectedSendOptions = selectedSendOptions;
	}

	public void saveAction() {
		String message = null;
		message = FacesUtil.getMessage("msg_record_ok");
		FacesUtil.addInfo(message);
	}

}
