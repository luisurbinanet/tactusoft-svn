package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.BranchDataModel;

@Named
@Scope("session")
public class BranchBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmBranch> list;
	private BranchDataModel model;
	private CrmBranch selected;

	public BranchBacking() {
		newAction();
	}

	public List<CrmBranch> getList() {
		return list;
	}

	public void setList(List<CrmBranch> list) {
		this.list = list;
	}

	public BranchDataModel getModel() {
		if (model == null) {
			list = tableService.getListBranch();
			model = new BranchDataModel(list);
			
			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(BranchDataModel model) {
		this.model = model;
	}

	public CrmBranch getSelected() {
		return selected;
	}

	public void setSelected(CrmBranch selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmBranch();
		selected.setState(Constant.STATE_ACTIVE);
	}

	public void saveAction() {
		String message = null;

		int result = tableService.saveBranch(selected);
		if (result == 0) {
			list = tableService.getListBranch();
			model = new BranchDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("bra_sales_org");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);

		}
	}

}
