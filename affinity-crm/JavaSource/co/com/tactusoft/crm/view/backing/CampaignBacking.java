package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDataModel;
import co.com.tactusoft.crm.view.datamodel.CampaignDetailDataModel;

@Named
@Scope("view")
public class CampaignBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmCampaign> list;
	private CampaignDataModel model;
	private CrmCampaign selected;

	private List<CrmCampaignDetail> listDetail;
	private CampaignDetailDataModel modelDetail;

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

			isDisabledButton();
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

	public List<CrmCampaignDetail> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<CrmCampaignDetail> listDetail) {
		this.listDetail = listDetail;
	}

	public CampaignDetailDataModel getModelDetail() {
		return modelDetail;
	}

	public void setModelDetail(CampaignDetailDataModel modelDetail) {
		this.modelDetail = modelDetail;
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

	public boolean isDisabledButton() {
		getModel();
		return (this.list == null || this.list.size() == 0) ? true : false;
	}

	public void generateDetail() {
		listDetail = tableService.getListCampaignDetail(selected.getId());
		modelDetail = new CampaignDetailDataModel(listDetail);
	}

}
