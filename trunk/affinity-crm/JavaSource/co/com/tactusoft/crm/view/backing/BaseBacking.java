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
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
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

	protected List<CrmPatient> listPatient;
	protected PatientDataModel patientModel;
	protected CrmPatient selectedPatient;
	protected String docPatient;
	protected String namePatient;
	protected int optionSearchPatient;

	protected List<SelectItem> listWSDoctor;
	protected Map<String, String> mapWSDoctor;
	protected String selectedWSDoctor;

	public List<CrmPatient> getListPatient() {
		return listPatient;
	}

	public void setListPatient(List<CrmPatient> listPatient) {
		this.listPatient = listPatient;
	}

	public PatientDataModel getPatientModel() {
		return patientModel;
	}

	public void setPatientModel(PatientDataModel patientModel) {
		this.patientModel = patientModel;
	}

	public CrmPatient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(CrmPatient selectedPatient) {
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

			this.listPatient = new ArrayList<CrmPatient>();
			this.patientModel = new PatientDataModel(listPatient);

		} else {
			listPatient = new ArrayList<CrmPatient>();
			List<WSBean> result = null;

			if (optionSearchPatient == 1) {
				listPatient = processService.getListPatientByNameOrDoc("DOC",
						this.docPatient);

				if (listPatient.size() == 0) {
					result = CustomerExecute.findByDoc(this.docPatient, 0);

					for (WSBean row : result) {
						CrmPatient patient = new CrmPatient();
						patient.setCodeSap(row.getCode());
						patient.setNames(row.getNames());
						listPatient.add(patient);
					}
				}
			} else {
				listPatient = processService.getListPatientByNameOrDoc("NAMES",
						this.namePatient.toUpperCase());

				result = CustomerExecute.findByName(this.namePatient, 0);

				for (WSBean row : result) {
					boolean validate = true;

					for (CrmPatient pat : listPatient) {
						if (row.getCode().equals(pat.getCodeSap())) {
							validate = false;
							break;
						}
					}

					if (validate) {
						CrmPatient patient = new CrmPatient();
						patient.setCodeSap(row.getCode());
						patient.setNames(row.getNames());
						listPatient.add(patient);
					}
				}
			}

			patientModel = new PatientDataModel(listPatient);

			if (listPatient.size() > 0) {
				selectedPatient = listPatient.get(0);
			}
		}
	}

	public List<SelectItem> getListWSDoctor() {
		if (listWSDoctor == null) {
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			try {
				String url = FacesUtil
						.getParameterTextValue("SAP_URL_ZWEBLIST");
				String username = FacesUtil
						.getParameterTextValue("SAP_USERNAME");
				String password = FacesUtil
						.getParameterTextValue("SAP_PASSWORD");

				List<WSBean> result = CustomLists.getDoctors(url, username,
						password);

				listWSDoctor = new ArrayList<SelectItem>();
				mapWSDoctor = new HashMap<String, String>();
				listWSDoctor.add(new SelectItem(Constant.DEFAULT_VALUE_STRING,
						label));
				for (WSBean row : result) {
					mapWSDoctor.put(row.getCode(), row.getNames());
					listWSDoctor.add(new SelectItem(row.getCode(), row
							.getNames()));
				}
			} catch (Exception ex) {
				listWSDoctor = new ArrayList<SelectItem>();
				listWSDoctor.add(new SelectItem(Constant.DEFAULT_VALUE_STRING,
						label));
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

	public TablesBo getTablesService() {
		return tablesService;
	}

	public void setTablesService(TablesBo tablesService) {
		this.tablesService = tablesService;
	}

	public ProcessBo getProcessService() {
		return processService;
	}

	public void setProcessService(ProcessBo processService) {
		this.processService = processService;
	}

	public boolean isDisabledAddPatient() {
		if ((listPatient == null) || (listPatient.size() == 0)) {
			return true;
		} else if (listPatient.size() == 1) {
			if (listPatient.get(0).getCodeSap().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public boolean isDisabledSelectedPatient() {
		if ((selectedPatient == null) || (selectedPatient.getCodeSap() == null)) {
			return true;
		}
		return false;
	}
}
