package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmNurse;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.NurseDataModel;

@Named
@Scope("view")
public class NurseBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmNurse> list;
	private NurseDataModel model;
	private CrmNurse selected;

	public NurseBacking() {
		newAction();
	}

	public List<CrmNurse> getList() {
		return list;
	}

	public void setList(List<CrmNurse> list) {
		this.list = list;
	}

	public NurseDataModel getModel() {
		if (model == null) {
			list = tableService.getListNurse();
			model = new NurseDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(NurseDataModel model) {
		this.model = model;
	}

	public CrmNurse getSelected() {
		return selected;
	}

	public void setSelected(CrmNurse selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmNurse();
		selected.setState(Constant.STATE_ACTIVE);
	}

	public void saveAction() {
		String message = null;

		int result = tableService.saveNurse(selected);
		if (result == 0) {
			list = tableService.getListNurse();
			model = new NurseDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("doc_code");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);

		}
	}

	public void removeAction(ActionEvent event) {
		String message = null;
		int result = tableService.remove(selected);
		if (result == 0) {
			list.remove(selected);
			model = new NurseDataModel(list);
			if (list.size() > 0) {
				selected = list.get(0);
			}
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else {
			message = FacesUtil.getMessage("doc_msg_error_fk");
			FacesUtil.addError(message);
		}
	}

}
