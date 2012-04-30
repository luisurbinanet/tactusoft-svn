package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.execute.CustomerExecute;

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
		String names = null;

		names = selected.getFirstName();
		if (selected.getSecondName().trim().length() > 0) {
			names = names + " " + selected.getSecondName();
		}

		names = names + " " + selected.getFirstSurname();
		if (selected.getSecondSurname().trim().length() > 0) {
			names = names + " " + selected.getSecondSurname();
		}

		SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
		CrmProfile profile = FacesUtil.getCurrentUser().getCrmProfile();

		try {
			String codigoSAP = CustomerExecute.excecute(sap.getEnvironment(), "13",
					selected.getCode(), names, selected.getCountry(),
					selected.getCity(), selected.getRegion(), "D001",
					profile.getSalesOrg(), profile.getDistrChan(),
					profile.getDivision(), profile.getSalesOff(), "01", "Z001",
					selected.getAddress(), selected.getPhoneNumber(),
					selected.getCellNumber(), "");

			if (codigoSAP != null) {
				message = FacesUtil.getMessage("pat_msg_ok", codigoSAP);
				FacesUtil.addInfo(message);
			} else {
				message = FacesUtil.getMessage("Error");
				FacesUtil.addError(message);
			}
		} catch (Exception ex) {
			message = FacesUtil.getMessage("pat_msg_error_cnx");
			FacesUtil.addError(message);
		}
	}

}
