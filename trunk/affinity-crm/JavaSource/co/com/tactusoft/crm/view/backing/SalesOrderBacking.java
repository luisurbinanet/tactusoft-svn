package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDomain;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.LoadXLS;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.beans.Material;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.MaterialDataModel;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.custom.MaterialesCustom;
import com.tactusoft.webservice.client.custom.ResultCreateOrder;
import com.tactusoft.webservice.client.execute.CreateSalesOrderExecute;
import com.tactusoft.webservice.client.execute.CustomerExecute;
import com.tactusoft.webservice.client.objects.Bapikna111;
import com.tactusoft.webservice.client.objects.Bapiret2;

@Named
@Scope("view")
public class SalesOrderBacking implements Serializable {

	@Inject
	private TablesBo tablesService;

	private static final long serialVersionUID = 1L;

	private List<SelectItem> listMethodPayment;
	private List<SelectItem> listConditionPayment;
	private List<SelectItem> listSalesGrp;

	private String methodPayment;
	private String conditionPayment;
	private String salesGrp;

	private List<Patient> listPatient;
	private PatientDataModel patientModel;
	private Patient selectedPatient;

	private List<SelectItem> listBranch;
	private String salesOff;
	private Map<String, CrmBranch> mapBranch;

	private List<Material> listMaterial;
	private MaterialDataModel materialModel;
	private Material selectedMaterial;

	private String codeNameMaterial;
	private String namePatient;

	private List<Material> listSelectedMaterial;
	private MaterialDataModel materialSelectedModel;
	private Material[] listDeletedMaterial;

	private boolean disabledSaveButton;

	public SalesOrderBacking() {
		newAction(null);
	}

	public List<SelectItem> getListMethodPayment() {
		if (listMethodPayment == null) {
			listMethodPayment = new LinkedList<SelectItem>();
			for (CrmDomain row : tablesService.getListDomain("FORMA_PAGO")) {
				listMethodPayment.add(new SelectItem(row.getCode(), row
						.getItemValue()));
			}
		}
		return listMethodPayment;
	}

	public void setListMethodPayment(List<SelectItem> listMethodPayment) {
		this.listMethodPayment = listMethodPayment;
	}

	public List<SelectItem> getListConditionPayment() {
		if (listConditionPayment == null) {
			listConditionPayment = new LinkedList<SelectItem>();
			for (CrmDomain row : tablesService.getListDomain("CONDICION_PAGO")) {
				listConditionPayment.add(new SelectItem(row.getCode(), row
						.getItemValue()));
			}
		}
		return listConditionPayment;
	}

	public void setListConditionPayment(List<SelectItem> listConditionPayment) {
		this.listConditionPayment = listConditionPayment;
	}

	public List<SelectItem> getListSalesGrp() {
		if (listSalesGrp == null) {
			listSalesGrp = new LinkedList<SelectItem>();
			for (CrmDomain row : tablesService.getListDomain("PAUTA")) {
				listSalesGrp.add(new SelectItem(row.getCode(), row
						.getItemValue()));
			}
		}
		return listSalesGrp;
	}

	public void setListSalesGrp(List<SelectItem> listSalesGrp) {
		this.listSalesGrp = listSalesGrp;
	}

	public String getMethodPayment() {
		return methodPayment;
	}

	public void setMethodPayment(String methodPayment) {
		this.methodPayment = methodPayment;
	}

	public String getConditionPayment() {
		return conditionPayment;
	}

	public void setConditionPayment(String conditionPayment) {
		this.conditionPayment = conditionPayment;
	}

	public String getSalesGrp() {
		return salesGrp;
	}

	public void setSalesGrp(String salesGrp) {
		this.salesGrp = salesGrp;
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

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			mapBranch = new HashMap<String, CrmBranch>();
			listBranch = new LinkedList<SelectItem>();
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				listBranch.add(new SelectItem(row.getCode(), row.getName()));
				mapBranch.put(row.getCode(), row);
			}
		}
		return listBranch;
	}

	public void setListBranch(List<SelectItem> listBranch) {
		this.listBranch = listBranch;
	}

	public String getSalesOff() {
		return salesOff;
	}

	public void setSalesOff(String salesOff) {
		this.salesOff = salesOff;
	}

	public MaterialDataModel getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(MaterialDataModel materialModel) {
		this.materialModel = materialModel;
	}

	public Material getSelectedMaterial() {
		return selectedMaterial;
	}

	public void setSelectedMaterial(Material selectedMaterial) {
		this.selectedMaterial = selectedMaterial;
	}

	public String getCodeNameMaterial() {
		return codeNameMaterial;
	}

	public void setCodeNameMaterial(String codeNameMaterial) {
		this.codeNameMaterial = codeNameMaterial;
	}

	public List<Material> getListMaterial() {
		return listMaterial;
	}

	public void setListMaterial(List<Material> listMaterial) {
		this.listMaterial = listMaterial;
	}

	public List<Material> getListSelectedMaterial() {
		return listSelectedMaterial;
	}

	public void setListSelectedMaterial(List<Material> listSelectedMaterial) {
		this.listSelectedMaterial = listSelectedMaterial;
	}

	public MaterialDataModel getMaterialSelectedModel() {
		return materialSelectedModel;
	}

	public void setMaterialSelectedModel(MaterialDataModel materialSelectedModel) {
		this.materialSelectedModel = materialSelectedModel;
	}

	public Material[] getListDeletedMaterial() {
		return listDeletedMaterial;
	}

	public void setListDeletedMaterial(Material[] listDeletedMaterial) {
		this.listDeletedMaterial = listDeletedMaterial;
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

	public void generateListMaterialAction() {
		if (listMaterial.size() == 0) {
			LoadXLS loadXLS = FacesUtil.findBean("loadXLS");
			listMaterial = loadXLS.getListMaterial();
			materialModel = new MaterialDataModel(listMaterial);
		} else {
			if (!isDisabledAddMaterial()) {
				List<Material> listMaterial2 = new LinkedList<Material>();
				for (Material row : listMaterial) {
					boolean exits = false;
					for (Material sel : listSelectedMaterial) {
						if (sel.getCode().equals(row.getCode())) {
							exits = true;
							break;
						}
					}

					if (!exits) {
						listMaterial2.add(row);
					}
				}
				listMaterial = listMaterial2;
				materialModel = new MaterialDataModel(listMaterial);
			}
		}
	}

	public void newAction(ActionEvent event) {
		selectedMaterial = new Material();
		listMaterial = new LinkedList<Material>();
		materialModel = new MaterialDataModel(listMaterial);
		listSelectedMaterial = new LinkedList<Material>();
		materialSelectedModel = new MaterialDataModel(listSelectedMaterial);
		selectedPatient = new Patient();
		listPatient = new LinkedList<Patient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;
	}

	public void saveAction() {
		selectedMaterial = new Material();
		String message = "";

		if (selectedPatient == null) {
			message = FacesUtil.getMessage("sal_msg_error_pat");
			FacesUtil.addError(message);
		} else if (FacesUtil.isEmptyOrBlank(selectedPatient.getSAPCode())) {
			message = FacesUtil.getMessage("sal_msg_error_pat");
			FacesUtil.addError(message);
		}
		if (listSelectedMaterial.size() == 0) {
			message = FacesUtil.getMessage("sal_msg_error_mat");
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(message)) {
			SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
			CrmProfile profile = FacesUtil.getCurrentUser().getCrmProfile();

			String orgVentas = profile.getSalesOrg();
			String canalDistribucion = profile.getDistrChan();
			String division = profile.getDivision();

			String tipoDocVenta = "ZOP";
			String solicitante = null;
			String interlocutor = null;
			String medico = "101";

			Date currentDate = new Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd");
			String fechaPedido = sdf.format(currentDate);
			
			String formula = mapBranch.get(this.salesOff).getFormula();

			List<MaterialesCustom> listMaterialTmp = new ArrayList<MaterialesCustom>();
			int index = 1;
			for (Material row : this.listSelectedMaterial) {
				MaterialesCustom custom = new MaterialesCustom();
				String itmNumber = FacesUtil
						.lpad(String.valueOf(index), '0', 6);
				custom.setItmNumber(itmNumber);
				custom.setMaterial(FacesUtil.lpad(row.getCode(), '0', 18));
				custom.setQuantity(new BigDecimal(row.getAmount()));
				custom.setCurrency(Double.valueOf(row.getPrice()));
				listMaterialTmp.add(custom);
				index++;
			}

			ResultCreateOrder result = CreateSalesOrderExecute.execute(
					tipoDocVenta, orgVentas, canalDistribucion, division,
					this.salesOff, fechaPedido, selectedPatient.getSAPCode(),
					this.methodPayment, this.conditionPayment, solicitante,
					listMaterialTmp, interlocutor, this.salesGrp, medico,
					formula);

			if (!FacesUtil.isEmptyOrBlank(result.getSalesdocument())) {
				message = FacesUtil.getMessage("sal_msg_ok",
						result.getSalesdocument());
				FacesUtil.addInfo(message);
				disabledSaveButton = true;
			} else {
				FacesUtil.addError(FacesUtil.getMessage("sal_msg_error"));
				Bapiret2[] messages = result.getMessages().value;
				for (Bapiret2 bap : messages) {
					if (bap.getType().equals("E")
							&& !bap.getMessage().contains("SALES_ITEM_IN")
							&& !bap.getMessage().contains("documento de venta")) {
						FacesUtil.addError(bap.getMessage());
					}
				}
			}
		}
	}

	public void searchMaterialAction() {
		List<Material> listMaterial2 = new LinkedList<Material>();
		for (Material material : listMaterial) {
			if (material.getCode().toUpperCase()
					.lastIndexOf(this.codeNameMaterial.toUpperCase()) >= 0
					|| material.getDescr().toUpperCase()
							.lastIndexOf(this.codeNameMaterial.toUpperCase()) >= 0) {
				listMaterial2.add(material);
			}
		}
		materialModel = new MaterialDataModel(listMaterial2);
	}

	public void addMaterialAction() {
		listSelectedMaterial.add(selectedMaterial);
		materialSelectedModel = new MaterialDataModel(listSelectedMaterial);
		generateListMaterialAction();
		if (!codeNameMaterial.isEmpty()) {
			searchMaterialAction();
		}
	}

	public void removeMaterialAction() {
		for (Material row : listDeletedMaterial) {
			listSelectedMaterial.remove(row);
		}
		materialModel = new MaterialDataModel(listSelectedMaterial);
	}

	public boolean isDisabledAddMaterial() {
		if (listMaterial.size() == 1) {
			if (listMaterial.get(0).getCode().equals("-1")) {
				return true;
			}
		}
		return false;
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

}
