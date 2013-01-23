package co.com.tactusoft.crm.view.backing;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDataModel;
import co.com.tactusoft.crm.view.datamodel.CampaignDetailDataModel;

@Named
@Scope("view")
public class CampaignAdminBacking extends CampaignBacking {

	private static final long serialVersionUID = 1L;
	private List<SelectItem> listUserItem;
	private CrmUser crmUser;
	private Integer status;
	private Integer maxResults;

	public CampaignAdminBacking() {
		maxResults = 100;
	}

	public List<SelectItem> getListUserItem() {
		return listUserItem;
	}

	public void setListUserItem(List<SelectItem> listUserItem) {
		this.listUserItem = listUserItem;
	}

	public CrmUser getCrmUser() {
		return crmUser;
	}

	public void setCrmUser(CrmUser crmUser) {
		this.crmUser = crmUser;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	@PostConstruct
	public void init() {
		List<CrmParameter> listParameter = parameterService
				.getListParameterByGroup("CAMPAIGN");
		mapText = new HashMap<String, String>();
		for (CrmParameter row : listParameter) {
			mapText.put(row.getCode(), row.getTextValue());
		}
		refreshList();
	}

	public boolean isDisabled() {
		return list.size() > 0 ? false : true;
	}

	@Override
	protected void refreshList() {
		list = tableService.getListCampaign(maxResults);
		model = new CampaignDataModel(list);
		if (list.size() > 0) {
			selected = list.get(0);
		}
	}

	@Override
	public void generateDetail() {
		listDetail = tableService.getListCampaignDetail(selected.getId());
		modelDetail = new CampaignDetailDataModel(listDetail);

		List<CrmUser> listUser = tableService
				.getListUserActiveByBranchAndCallCenter(selected.getCrmBranch()
						.getId());
		listUserItem = FacesUtil.entityToSelectItem(listUser, "getId",
				"getUsername");

		crmUser = new CrmUser();
	}

	public void searchAction() {
		if (status == 0) {
			refreshList();
		} else {
			list = tableService.getListCampaignByStatus(status.toString(),
					maxResults);
			model = new CampaignDataModel(list);
			if (list.size() > 0) {
				selected = list.get(0);
			} else {
				selected = null;
			}
		}
	}

	@Override
	public void saveAction() {
		String message = null;
		selected.setCrmUser(crmUser);
		if (selected.getState() == 4) {
			selected.setState(1);
		}
		int result = tableService.saveCampaign(selected);
		if (result == 0) {
			refreshList();
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("doc_code");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);
		}
	}

	public String getStatus(int status) {
		return status == 1 ? FacesUtil.getMessage("crm_state_open")
				: status == 2 ? FacesUtil.getMessage("crm_state_close")
						: status == 3 ? FacesUtil
								.getMessage("cam_state_new_call") : FacesUtil
								.getMessage("cam_state_reallocate");
	}

}
