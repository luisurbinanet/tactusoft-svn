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

	public SalesOrderBacking() {
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
		if (materialModel == null) {
			LoadXLS loadXLS = FacesUtil.findBean("loadXLS");
			listMaterial = loadXLS.getListMaterial();
			materialModel = new MaterialDataModel(listMaterial);
		}
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

	public void searchMaterialAction() {
		List<Material> listMaterial2 = new LinkedList<Material>();
		for (Material material : listMaterial) {
			if (material.getCode().lastIndexOf(this.codeNameMaterial) >= 0
					|| material.getDescr().lastIndexOf(this.codeNameMaterial) >= 0) {
				listMaterial2.add(material);
			}
		}
		materialModel = new MaterialDataModel(listMaterial2);
	}

}
