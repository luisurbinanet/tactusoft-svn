package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmGuideline;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.GuidelineDataModel;

@Named
@Scope("view")
public class GuidelineBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmGuideline> list;
	private GuidelineDataModel model;
	private CrmGuideline selected;

	public GuidelineBacking() {
		newAction();
	}

	public List<CrmGuideline> getList() {
		return list;
	}

	public void setList(List<CrmGuideline> list) {
		this.list = list;
	}

	public GuidelineDataModel getModel() {
		if (model == null) {
			list = tableService.getListGuideline();
			model = new GuidelineDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(GuidelineDataModel model) {
		this.model = model;
	}

	public CrmGuideline getSelected() {
		return selected;
	}

	public void setSelected(CrmGuideline selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmGuideline();
	}

	public void saveAction() {
		String message = null;

		int result = tableService.saveGuideline(selected);
		if (result == 0) {
			list = tableService.getListGuideline();
			model = new GuidelineDataModel(list);
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
			model = new GuidelineDataModel(list);
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
