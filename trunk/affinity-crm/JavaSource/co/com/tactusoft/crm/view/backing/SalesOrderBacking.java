package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDomain;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.LoadXLS;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.beans.Material;
import co.com.tactusoft.crm.view.datamodel.MaterialDataModel;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.custom.MaterialesCustom;
import com.tactusoft.webservice.client.custom.ResultCreateOrder;
import com.tactusoft.webservice.client.execute.CreateSalesOrderExecute;
import com.tactusoft.webservice.client.execute.CustomListsExecute;
import com.tactusoft.webservice.client.objects.Bapiret2;

@Named
@Scope("view")
public class SalesOrderBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;
	private List<SelectItem> listMethodPayment;
	private List<SelectItem> listConditionPayment;
	private List<SelectItem> listSalesGrp;

	private String methodPayment;
	private String conditionPayment;
	private String salesGrp;

	private List<SelectItem> listBranch;
	private String salesOff;
	private Map<String, CrmBranch> mapBranch;

	private List<Material> listMaterial;
	private MaterialDataModel materialModel;
	private Material[] selectedMaterial;

	private String codeNameMaterial;

	private List<Material> listSelectedMaterial;
	private MaterialDataModel materialSelectedModel;
	private Material[] listDeletedMaterial;

	private boolean disabledSaveButton;

	private SAPEnvironment sap;

	public SalesOrderBacking() {
		sap = FacesUtil.findBean("SAPEnvironment");
		newAction(null);
	}

	public List<SelectItem> getListMethodPayment() {
		if (listMethodPayment == null) {
			listMethodPayment = new LinkedList<SelectItem>();
			List<WSBean> list = CustomListsExecute.getPaymentMethod(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword(),
					"co");
			for (WSBean row : list) {
				listMethodPayment.add(new SelectItem(row.getCode(), row
						.getNames()));
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

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			mapBranch = new HashMap<String, CrmBranch>();
			listBranch = new LinkedList<SelectItem>();
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				listBranch.add(new SelectItem(row.getCode(), row.getName()
						+ " (" + row.getSociety() + ")"));
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

	public Material[] getSelectedMaterial() {
		return selectedMaterial;
	}

	public void setSelectedMaterial(Material[] selectedMaterial) {
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
		selectedMaterial = null;
		listMaterial = new LinkedList<Material>();
		materialModel = new MaterialDataModel(listMaterial);
		listSelectedMaterial = new LinkedList<Material>();
		materialSelectedModel = new MaterialDataModel(listSelectedMaterial);
		selectedPatient = new CrmPatient();
		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;

		optionSearchPatient = 1;
		codeNameMaterial = "";
		docPatient = "";
		namePatient = "";
	}

	public void saveAction() {
		String message = "";

		if (selectedPatient == null) {
			message = FacesUtil.getMessage("sal_msg_error_pat");
			FacesUtil.addError(message);
		} else if (FacesUtil.isEmptyOrBlank(selectedPatient.getCodeSap())) {
			message = FacesUtil.getMessage("sal_msg_error_pat");
			FacesUtil.addError(message);
		}
		if (listSelectedMaterial.size() == 0) {
			message = FacesUtil.getMessage("sal_msg_error_mat");
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(message)) {
			SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
			CrmProfile profile = mapProfile.get(idProfile);

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

			sap.getEnvironment();

			ResultCreateOrder result = CreateSalesOrderExecute.execute(
					sap.getUrlCustomerSalesOrderCreate(), sap.getUsername(),
					sap.getPassword(), tipoDocVenta, orgVentas,
					canalDistribucion, division, this.salesOff, fechaPedido,
					selectedPatient.getCodeSap(), this.methodPayment,
					this.conditionPayment, solicitante, listMaterialTmp,
					interlocutor, this.salesGrp, medico, profile.getFormula(),
					FacesUtil.getCurrentUser().getUsername());

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

		selectedMaterial = null;
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
		for (Material row : selectedMaterial) {
			listSelectedMaterial.add(row);
		}

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

}
