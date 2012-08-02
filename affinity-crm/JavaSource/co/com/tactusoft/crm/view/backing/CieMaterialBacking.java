package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmCie;
import co.com.tactusoft.crm.model.entities.CrmCieMaterial;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CieDataModel;

import com.tactusoft.webservice.client.beans.WSBean;

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
	private List<WSBean> listTarget;
	private DualListModel<WSBean> listMedication;

	private int optionSearchCie;
	private List<CrmCie> listCie;
	private CieDataModel cieModel;
	private CrmCie selectedCie;
	private String codeCIE;
	private String descCIE;
	private boolean disabledAddCie;

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
				isDisabled();
			}
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

	public List<WSBean> getListTarget() {
		return listTarget;
	}

	public void setListTarget(List<WSBean> listTarget) {
		this.listTarget = listTarget;
	}

	public DualListModel<WSBean> getListMedication() {
		return listMedication;
	}

	public void setListMedication(DualListModel<WSBean> listMedication) {
		this.listMedication = listMedication;
	}

	public List<WSBean> getListAllMedication() {
		return listAllMedication;
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

	public void newAction() {
		listAllMedication = FacesUtil.getCurrentUserData().getListWSMaterials();

		selected = new CrmCie();
		listTarget = new LinkedList<WSBean>();
		listMedication = new DualListModel<WSBean>(listAllMedication,
				listTarget);

		optionSearchCie = 1;
		listCie = new ArrayList<CrmCie>();
		cieModel = new CieDataModel(listCie);
		selectedCie = new CrmCie();
		codeCIE = null;
		descCIE = null;
		disabledAddCie = true;

		refreshListCie();
	}

	public void saveAction() {
		String message = null;

		int result = tableService.saveCieMaterial(selected,
				listMedication.getTarget());
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

	public void editAction(ActionEvent event) {
		if (selected == null) {
			List<CrmCieMaterial> listMaterial = tableService
					.getListMaterialbyDiagnosis(selected.getId());
			listTarget = new LinkedList<WSBean>();
			for (CrmCieMaterial row : listMaterial) {
				WSBean bean = new WSBean();
				bean.setCode(row.getMaterial());
				bean.setNames(row.getDescription());
			}
		} else {
			newAction();
		}

		List<WSBean> listSource = new LinkedList<WSBean>();

		for (WSBean row : this.listAllMedication) {
			boolean exits = false;
			for (WSBean avb : listTarget) {
				if (avb.getCode().equals(row.getCode())) {
					exits = true;
					break;
				}
			}

			if (!exits) {
				listSource.add(row);
			}
		}

		listMedication = new DualListModel<WSBean>(listSource, listTarget);
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

	public boolean isDisabled() {
		if (list != null) {
			return list.size() == 0 ? true : false;
		} else {
			return true;
		}
	}

}
