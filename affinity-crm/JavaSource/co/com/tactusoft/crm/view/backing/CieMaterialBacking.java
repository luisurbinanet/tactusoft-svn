package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmCie;
import co.com.tactusoft.crm.model.entities.CrmCieMaterial;
import co.com.tactusoft.crm.model.entities.CrmMaterialGroup;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.datamodel.CieDataModel;
import co.com.tactusoft.crm.view.datamodel.WSBeanDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomListsExecute;

@Named
@Scope("view")
public class CieMaterialBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	@Inject
	protected ProcessBo processService;

	private List<CrmCie> list;
	private CieDataModel model;
	private CrmCie selected;

	private List<WSBean> listAllMedication;

	private List<WSBean> listMedication;
	private WSBeanDataModel modelMedication;
	private WSBean[] selectedsMedication;

	private int optionSearchCie;
	private List<CrmCie> listCie;
	private CieDataModel cieModel;
	private CrmCie selectedCie;
	private String codeCIE;
	private String descCIE;
	private boolean disabledAddCie;

	private int optionSearchMaterial;
	private List<WSBean> listMaterial;
	private WSBeanDataModel materialModel;
	private WSBean selectedMaterial;
	private String codeMaterial;
	private String descMaterial;
	private boolean disabledAddMaterial;

	private List<CrmMaterialGroup> listMaterialGroup;
	private boolean newRecord;

	public CieMaterialBacking() {
		newAction();
	}

	public List<CrmCie> getList() {
		return list;
	}

	public void setList(List<CrmCie> list) {
		this.list = list;
	}

	public CieDataModel getModel() {
		if (model == null) {
			list = tableService.getListCieMaterial();
			model = new CieDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}

			listMaterialGroup = processService.getListMaterialGroup();
		}
		return model;
	}

	public void setModel(CieDataModel model) {
		this.model = model;
	}

	public CrmCie getSelected() {
		return selected;
	}

	public void setSelected(CrmCie selected) {
		this.selected = selected;
	}

	public List<WSBean> getListMedication() {
		return listMedication;
	}

	public void setListMedication(List<WSBean> listMedication) {
		this.listMedication = listMedication;
	}

	public List<WSBean> getListAllMedication() {
		return listAllMedication;
	}

	public WSBeanDataModel getModelMedication() {
		return modelMedication;
	}

	public void setModelMedication(WSBeanDataModel modelMedication) {
		this.modelMedication = modelMedication;
	}

	public WSBean[] getSelectedsMedication() {
		return selectedsMedication;
	}

	public void setSelectedsMedication(WSBean[] selectedsMedication) {
		this.selectedsMedication = selectedsMedication;
	}

	public void setListAllMedication(List<WSBean> listAllMedication) {
		this.listAllMedication = listAllMedication;
	}

	public int getOptionSearchCie() {
		return optionSearchCie;
	}

	public void setOptionSearchCie(int optionSearchCie) {
		this.optionSearchCie = optionSearchCie;
	}

	public List<CrmCie> getListCie() {
		return listCie;
	}

	public void setListCie(List<CrmCie> listCie) {
		this.listCie = listCie;
	}

	public CieDataModel getCieModel() {
		return cieModel;
	}

	public void setCieModel(CieDataModel cieModel) {
		this.cieModel = cieModel;
	}

	public CrmCie getSelectedCie() {
		return selectedCie;
	}

	public void setSelectedCie(CrmCie selectedCie) {
		this.selectedCie = selectedCie;
	}

	public String getCodeCIE() {
		return codeCIE;
	}

	public void setCodeCIE(String codeCIE) {
		this.codeCIE = codeCIE;
	}

	public String getDescCIE() {
		return descCIE;
	}

	public void setDescCIE(String descCIE) {
		this.descCIE = descCIE;
	}

	public boolean isDisabledAddCie() {
		return disabledAddCie;
	}

	public void setDisabledAddCie(boolean disabledAddCie) {
		this.disabledAddCie = disabledAddCie;
	}

	public int getOptionSearchMaterial() {
		return optionSearchMaterial;
	}

	public void setOptionSearchMaterial(int optionSearchMaterial) {
		this.optionSearchMaterial = optionSearchMaterial;
	}

	public List<WSBean> getListMaterial() {
		return listMaterial;
	}

	public void setListMaterial(List<WSBean> listMaterial) {
		this.listMaterial = listMaterial;
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

	public boolean isDisabledAddMaterial() {
		return disabledAddMaterial;
	}

	public void setDisabledAddMaterial(boolean disabledAddMaterial) {
		this.disabledAddMaterial = disabledAddMaterial;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}

	public void newAction() {
		SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
		try {
			listAllMedication = CustomListsExecute.getMaterials(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword());
		} catch (Exception ex) {
			listAllMedication = new ArrayList<WSBean>();
		}

		selected = new CrmCie();

		listMedication = new LinkedList<WSBean>();
		modelMedication = new WSBeanDataModel(listMedication);

		optionSearchCie = 1;
		listCie = new ArrayList<CrmCie>();
		cieModel = new CieDataModel(listCie);
		selectedCie = new CrmCie();
		codeCIE = null;
		descCIE = null;
		disabledAddCie = true;

		optionSearchMaterial = 1;
		listMaterial = new ArrayList<WSBean>();
		materialModel = new WSBeanDataModel(listMaterial);
		selectedMaterial = new WSBean();
		codeMaterial = null;
		descMaterial = null;
		disabledAddMaterial = true;
		newRecord = true;

		if (list != null) {
			if (list.size() > 0) {
				selected = list.get(0);
			}
		}

		refreshListCie();
	}

	public void saveAction() {
		String message = null;

		if (selected.getId() == null) {
			message = FacesUtil.getMessage("cie_grp_message_dig_1");
			FacesUtil.addWarn(message);
		}

		if (listMedication.size() == 0) {
			message = FacesUtil.getMessage("his_msg_message_med_1");
			FacesUtil.addWarn(message);
		}

		if (message == null) {
			int result = tableService.saveCieMaterial(selected, listMedication);
			if (result == 0) {
				list = tableService.getListCieMaterial();
				model = new CieDataModel(list);
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			} else if (result == -1) {
				String paramValue = FacesUtil.getMessage("doc_code");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						paramValue);
				FacesUtil.addError(message);

			}
		}

		if (list.size() > 0) {
			selected = list.get(0);
		}
	}

	public void editAction(ActionEvent event) {
		if (selected != null) {
			List<CrmCieMaterial> listMaterial = tableService
					.getListMaterialbyDiagnosis(selected.getId());
			listMedication = new LinkedList<WSBean>();
			for (CrmCieMaterial row : listMaterial) {
				WSBean bean = new WSBean();
				bean.setCode(row.getMaterial());
				bean.setNames(row.getDescription());
				listMedication.add(bean);
			}
			modelMedication = new WSBeanDataModel(listMedication);
			newRecord = false;
		} else {
			newAction();
		}
	}

	private void refreshListCie() {
		if (list != null) {
			List<CrmCie> listCieFilter = new ArrayList<CrmCie>();
			for (CrmCie row : listCie) {
				boolean filter = true;
				for (CrmCie dig : list) {
					if (row.getId().intValue() == dig.getId().intValue()) {
						filter = false;
						break;
					}
				}

				if (filter) {
					listCieFilter.add(row);
				}
			}

			this.cieModel = new CieDataModel(listCieFilter);
			if (listCieFilter.size() > 0) {
				selectedCie = listCieFilter.get(0);
				disabledAddCie = false;
			} else {
				disabledAddCie = true;
			}
		}
	}

	public void searchCIEAction(ActionEvent event) {
		if ((optionSearchCie == 1 && this.codeCIE.isEmpty())
				|| (optionSearchCie == 2 && this.descCIE.isEmpty())) {
			this.listCie = new ArrayList<CrmCie>();
			disabledAddCie = true;
		} else {
			if (optionSearchCie == 1) {
				this.listCie = processService.getListCieByCode(codeCIE);
			} else {
				this.listCie = processService.getListCieByName(descCIE);
			}

			if (listCie.size() > 0) {
				selectedCie = listCie.get(0);
				disabledAddCie = false;
			} else {
				disabledAddCie = true;
			}
		}
		refreshListCie();
	}

	public void addCieAction(ActionEvent event) {
		selected = new CrmCie();
		selected = selectedCie;
	}

	public boolean isDisabledMedication() {
		if (list != null) {
			return listMedication.size() == 0 ? true : false;
		} else {
			return true;
		}
	}

	public void addMaterialAction(ActionEvent event) {
		listMedication.add(selectedMaterial);
		modelMedication = new WSBeanDataModel(listMedication);

		refreshListMedication();
	}

	public void searchMaterialAction(ActionEvent event) {
		if ((optionSearchMaterial == 1 && this.codeMaterial.isEmpty())
				|| (optionSearchMaterial == 2 && this.descMaterial.isEmpty())) {
			this.listMaterial = new ArrayList<WSBean>();
			disabledAddMaterial = true;
		} else {
			this.listMaterial = new ArrayList<WSBean>();
			for (WSBean material : listAllMedication) {

				boolean validateGroup = false;
				for (CrmMaterialGroup row : listMaterialGroup) {
					if (row.getMaterialType().equals(
							Constant.MATERIAL_TYPE_MEDICINE)
							&& material.getType().equals(row.getGroup())) {
						validateGroup = true;
						break;
					}
				}

				if (validateGroup) {
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
			for (WSBean med : listMedication) {
				if (row.getCode().equals(med.getCode())) {
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

	public void removeMedicationAction(ActionEvent event) {
		for (WSBean row : selectedsMedication) {
			listMedication.remove(row);
		}
		modelMedication = new WSBeanDataModel(listMedication);
	}
}
