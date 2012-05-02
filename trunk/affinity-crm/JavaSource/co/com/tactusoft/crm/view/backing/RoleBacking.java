package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

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

	public DualListModel<CrmPage> getListPages() {
		List<CrmPage> listTarget = tablesService.getListPagesByRole(selected
				.getId());

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
	}

	public void saveAction() {
		String message = null;

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
