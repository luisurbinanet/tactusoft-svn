package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.RoleDataModel;

@Named
@Scope("view")
public class RoleBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tablesService;

	private List<CrmRole> list;
	private RoleDataModel model;
	private CrmRole selected;

	private List<SelectItem> listPagesDefault;
	private Map<BigDecimal, CrmPage> mapCrmPage;

	private List<CrmPage> listTarget;
	private DualListModel<CrmPage> listPages;

	public RoleBacking() {
		newAction();
	}

	public List<CrmRole> getList() {
		return list;
	}

	public void setList(List<CrmRole> list) {
		this.list = list;
	}

	public RoleDataModel getModel() {
		if (model == null) {
			list = tablesService.getListRole();
			model = new RoleDataModel(list);
		}
		return model;
	}

	public void setModel(RoleDataModel model) {
		this.model = model;
	}

	public CrmRole getSelected() {
		return selected;
	}

	public void setSelected(CrmRole selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListPagesDefault() {
		mapCrmPage = new HashMap<BigDecimal, CrmPage>();
		listPagesDefault = new LinkedList<SelectItem>();
		for (CrmPage row : listTarget) {
			if (row.getParent() != null) {
				listPagesDefault
						.add(new SelectItem(row.getId(), row.getName()));
				mapCrmPage.put(row.getId(), row);
			}
		}

		return listPagesDefault;
	}

	public void setListPagesDefault(List<SelectItem> listPagesDefault) {
		this.listPagesDefault = listPagesDefault;
	}

	public DualListModel<CrmPage> getListPages() {
		List<CrmPage> listSource = new LinkedList<CrmPage>();

		for (CrmPage row : FacesUtil.getCurrentUserData().getListPageAll()) {
			boolean exits = false;
			for (CrmPage avb : listTarget) {
				if (avb.getId().intValue() == row.getId().intValue()) {
					exits = true;
					break;
				}
			}

			if (!exits) {
				listSource.add(row);
			}
		}

		listPages = new DualListModel<CrmPage>(listSource, listTarget);
		return listPages;
	}

	public void setListPages(DualListModel<CrmPage> listPages) {
		this.listPages = listPages;
	}

	public void newAction() {
		selected = new CrmRole();
		selected.setState(Constant.STATE_ACTIVE);
		selected.setCrmPage(new CrmPage());

		listTarget = new LinkedList<CrmPage>();
	}

	public void saveAction() {
		String message = null;

		if (listPages.getTarget().size() == 0) {
			message = FacesUtil.getMessage("rol_msg_error_pag");
			FacesUtil.addError(message);
		} else {

			if (selected.getId() == null) {
				selected.setCrmPage(listPages.getTarget().get(0));
			} else {
				selected.setCrmPage(mapCrmPage.get(selected.getCrmPage()
						.getId()));
			}

			int result = tablesService.saveRole(selected);

			if (result == 0) {
				tablesService.savePageRole(selected, listPages.getTarget());
				list = tablesService.getListRole();
				model = new RoleDataModel(list);
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			} else if (result == -1) {
				String paramValue = FacesUtil.getMessage("rol_name");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						paramValue);
				FacesUtil.addError(message);
			}
		}
	}

	public void generateListAction(ActionEvent event) {
		listTarget = tablesService.getListPagesByRole(selected.getId());
	}

}
