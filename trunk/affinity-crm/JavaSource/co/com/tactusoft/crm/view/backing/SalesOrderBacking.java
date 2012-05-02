package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmDomain;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.LoadXLS;
import co.com.tactusoft.crm.view.beans.Material;
import co.com.tactusoft.crm.view.datamodel.MaterialDataModel;

@Named
@Scope("view")
public class SalesOrderBacking implements Serializable {

	@Inject
	private TablesBo tablesService;

	private static final long serialVersionUID = 1L;

	private List<SelectItem> listMethodPayment;
	private List<SelectItem> listConditionPayment;

	private String methodPayment;
	private String conditionPayment;

	private List<Material> listMaterial;
	private MaterialDataModel materialModel;
	private Material selectedMaterial;

	private String codeNameMaterial;

	private List<Material> listSelectedMaterial;
	private MaterialDataModel materialSelectedModel;
	private Material[] listDeletedMaterial;

	public SalesOrderBacking() {
		newAction();
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

	public void generateListMaterialAction() {
		if (listMaterial.size() == 0) {
			LoadXLS loadXLS = FacesUtil.findBean("loadXLS");
			listMaterial = loadXLS.getListMaterial();
			materialModel = new MaterialDataModel(listMaterial);
		} else {
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

	public void newAction() {
		selectedMaterial = new Material();
		listMaterial = new LinkedList<Material>();
		materialModel = new MaterialDataModel(listMaterial);
		listSelectedMaterial = new LinkedList<Material>();
		materialSelectedModel = new MaterialDataModel(listSelectedMaterial);
	}

	public void saveAction() {
		selectedMaterial = new Material();
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

}
