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

	public CampaignAdminBacking() {

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

	@Override
	protected void refreshList() {
		list = tableService.getListCampaign();
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

}
