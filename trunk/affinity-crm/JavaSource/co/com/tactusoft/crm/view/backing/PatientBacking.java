package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.execute.CustomerExecute;

@Named
@Scope("view")
public class PatientBacking implements Serializable {

	@Inject
	private ParameterBo parameterService;

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
		String env = null;

		List<CrmParameter> lisParameter = parameterService.getListParameter();
		for (CrmParameter par : lisParameter) {
			if (par.getCode().equals("SAP_ENVIRONMENT")) {
				env = par.getTextValue();
			}
		}

		CrmProfile profile = FacesUtil.getCurrentUser().getCrmProfile();

		String codigoSAP = CustomerExecute.excecute(env, "13",
				selected.getCode(), selected.getFirstName() + " " + selected.getFirstSurname(), "CO", "BOGOTA", "11",
				"D001", profile.getSalesOrg(), profile.getDistrChan(),
				profile.getDivision(), profile.getSalesOff(), "01", "Z001",
				selected.getAddress(), selected.getPhoneNumber(),
				selected.getCellNumber(), "");
		
		if (codigoSAP!=null){
			message = FacesUtil.getMessage("msg_record_ok");
		} else {
			message = FacesUtil.getMessage("Error");
		}
		
		FacesUtil.addInfo(message);
	}

}
