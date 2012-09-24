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
import co.com.tactusoft.crm.model.entities.CrmMedication;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.datamodel.MedicationDataModel;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;
import co.com.tactusoft.crm.view.datamodel.WSBeanDataModel;

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

	private int optionSearchMaterial;
	private boolean disabledAddMaterial;
	private String codeMaterial;
	private String descMaterial;
	private int unit;
	private double price;

	private List<WSBean> listAllMaterial;
	private List<WSBean> listMaterial;
	private WSBeanDataModel materialModel;
	private WSBean selectedMaterial;

	private List<CrmMedication> listMedication;
	private MedicationDataModel medicationModel;
	private CrmMedication[] selectedMedication;

	private boolean disabledSaveButton;

	private SAPEnvironment sap;

	public SalesOrderBacking() {
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
						.getCode() + " - " + row.getNames()));
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
			List<WSBean> list = CustomListsExecute.getPaymentMethod(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword(),
					"co");
			for (WSBean row : list) {
				listConditionPayment.add(new SelectItem(row.getCode(), row
						.getCode() + " - " + row.getNames()));
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
			for (WSBean row : FacesUtil.getCurrentUserData()
					.getListWSGroupSellers()) {
				listSalesGrp.add(new SelectItem(row.getCode(), row.getCode()
						+ " - " + row.getNames()));
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

	public List<WSBean> getListAllMaterial() {
		return listAllMaterial;
	}

	public void setListAllMaterial(List<WSBean> listAllMaterial) {
		this.listAllMaterial = listAllMaterial;
	}

	public WSBeanDataModel getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(WSBeanDataModel materialModel) {
		this.materialModel = materialModel;
	}

	public WSBean getSelectedMaterial() {
		return selectedMaterial;
	}

	public void setSelectedMaterial(WSBean selectedMaterial) {
		this.selectedMaterial = selectedMaterial;
	}

	public List<CrmMedication> getListMedication() {
		return listMedication;
	}

	public void setListMedication(List<CrmMedication> listMedication) {
		this.listMedication = listMedication;
	}

	public MedicationDataModel getMedicationModel() {
		return medicationModel;
	}

	public void setMedicationModel(MedicationDataModel medicationModel) {
		this.medicationModel = medicationModel;
	}

	public CrmMedication[] getSelectedMedication() {
		return selectedMedication;
	}

	public void setSelectedMedication(CrmMedication[] selectedMedication) {
		this.selectedMedication = selectedMedication;
	}

	public int getOptionSearchMaterial() {
		return optionSearchMaterial;
	}

	public void setOptionSearchMaterial(int optionSearchMaterial) {
		this.optionSearchMaterial = optionSearchMaterial;
	}

	public String getCodeMaterial() {
		return codeMaterial;
	}

	public void setCodeMaterial(String codeMaterial) {
		this.codeMaterial = codeMaterial;
	}

	public String getDescMaterial() {
		return descMaterial;
	}

	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDisabledAddMaterial(boolean disabledAddMaterial) {
		this.disabledAddMaterial = disabledAddMaterial;
	}

	public boolean isDisabledAddMaterial() {
		return disabledAddMaterial;
	}

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public void newAction(ActionEvent event) {
		sap = FacesUtil.findBean("SAPEnvironment");
		selectedMaterial = null;
		listAllMaterial = new LinkedList<WSBean>();
		materialModel = new WSBeanDataModel(listAllMaterial);
		listMedication = new LinkedList<CrmMedication>();
		medicationModel = new MedicationDataModel(listMedication);
		selectedPatient = null;
		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;

		optionSearchPatient = 1;
		docPatient = null;
		namePatient = null;

		codeMaterial = null;
		descMaterial = null;
		optionSearchMaterial = 1;
		disabledAddMaterial = true;

		try {
			listAllMaterial = CustomListsExecute.getMaterials(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword());
		} catch (Exception ex) {
			listAllMaterial = new ArrayList<WSBean>();
		}
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
		if (listMedication.size() == 0) {
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
			for (CrmMedication row : this.listMedication) {
				MaterialesCustom custom = new MaterialesCustom();
				String itmNumber = FacesUtil
						.lpad(String.valueOf(index), '0', 6);
				custom.setItmNumber(itmNumber);
				custom.setMaterial(FacesUtil.lpad(
						String.valueOf(row.getCodMaterial()), '0', 18));
				custom.setQuantity(new BigDecimal(row.getUnit()));
				custom.setCurrency(row.getPrice().doubleValue());
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

	public void generateListMaterialAction() {

	}

	public void searchMaterialAction(ActionEvent event) {
		if ((optionSearchMaterial == 1 && this.codeMaterial.isEmpty())
				|| (optionSearchMaterial == 2 && this.descMaterial.isEmpty())) {
			this.listMaterial = new ArrayList<WSBean>();
			disabledAddMaterial = true;
		} else {
			this.listMaterial = new ArrayList<WSBean>();
			for (WSBean material : listAllMaterial) {
				if (optionSearchMaterial == 1) {
					if (material.getCode().toUpperCase()
							.contains(codeMaterial.toUpperCase())) {
						this.listMaterial.add(material);
					}
				} else {
					if (material.getNames().toUpperCase()
							.contains(descMaterial.toUpperCase())) {
						this.listMaterial.add(material);
					}
				}
			}

			if (listMaterial.size() > 0) {
				selectedMaterial = listMaterial.get(0);
				disabledAddMaterial = false;
			} else {
				disabledAddMaterial = true;
			}
		}
		refreshListMedication();
	}

	private void refreshListMedication() {
		List<WSBean> listFilter = new ArrayList<WSBean>();
		for (WSBean row : listMaterial) {
			boolean filter = true;

			for (CrmMedication med : listMedication) {
				if (row.getCode() == String.valueOf(med.getCodMaterial())) {
					filter = false;
					break;
				}
			}

			if (filter) {
				listFilter.add(row);
			}
		}

		this.materialModel = new WSBeanDataModel(listFilter);
		if (listFilter.size() > 0) {
			selectedMaterial = listFilter.get(0);
			disabledAddMaterial = false;
		} else {
			disabledAddMaterial = true;
		}
	}

	public void addMaterialAction() {
		BigDecimal id = new BigDecimal(listMedication.size() + 1);
		CrmMedication medication = new CrmMedication();
		medication.setId(id);
		medication.setCodMaterial(Integer.parseInt(selectedMaterial.getCode()));
		medication.setDescMaterial(selectedMaterial.getNames());
		medication.setUnit(unit);
		medication.setPrice(new BigDecimal(price));
		listMedication.add(medication);
		medicationModel = new MedicationDataModel(listMedication);

		refreshListMedication();
	}

	public void removeMaterialAction() {
		for (CrmMedication row : selectedMedication) {
			listMedication.remove(row);
		}
		medicationModel = new MedicationDataModel(listMedication);
	}

}
