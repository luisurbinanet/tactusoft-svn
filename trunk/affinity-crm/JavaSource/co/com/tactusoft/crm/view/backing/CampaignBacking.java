package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDataModel;

@Named
@Scope("view")
public class CampaignBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmCampaign> list;
	private CampaignDataModel model;
	private CrmCampaign selected;

	public CampaignBacking() {
		newAction();
	}

	public List<CrmCampaign> getList() {
		return list;
	}

	public void setList(List<CrmCampaign> list) {
		this.list = list;
	}

	public CampaignDataModel getModel() {
		if (model == null) {
			list = tableService.getListCampaign();
			model = new CampaignDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(CampaignDataModel model) {
		this.model = model;
	}

	public CrmCampaign getSelected() {
		return selected;
	}

	public void setSelected(CrmCampaign selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmCampaign();
		selected.setState(Constant.STATE_ACTIVE);
	}

	public void saveAction() {
		String message = null;

		int result = tableService.saveCampaign(selected);
		if (result == 0) {
			list = tableService.getListCampaign();
			model = new CampaignDataModel(list);
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
			model = new CampaignDataModel(list);
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
