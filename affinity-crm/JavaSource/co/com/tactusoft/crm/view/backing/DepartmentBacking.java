package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmDepartment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.DepartmentDataModel;

@Named
@Scope("view")
public class DepartmentBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmDepartment> list;
	private DepartmentDataModel model;
	private CrmDepartment selected;

	public DepartmentBacking() {
		newAction();
	}

	public List<CrmDepartment> getList() {
		return list;
	}

	public void setList(List<CrmDepartment> list) {
		this.list = list;
	}

	public DepartmentDataModel getModel() {
		if (model == null) {
			list = tableService.getListDepartment();
			model = new DepartmentDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(DepartmentDataModel model) {
		this.model = model;
	}

	public CrmDepartment getSelected() {
		return selected;
	}

	public void setSelected(CrmDepartment selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmDepartment();
		selected.setState(Constant.STATE_ACTIVE);
	}

	public void saveAction() {
		String message = null;

		int result = tableService.saveDepartment(selected);
		if (result == 0) {
			list = tableService.getListDepartment();
			model = new DepartmentDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("doc_code");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);

		}
	}

}
