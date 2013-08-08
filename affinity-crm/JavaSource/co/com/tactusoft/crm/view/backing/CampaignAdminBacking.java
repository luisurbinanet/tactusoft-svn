package co.com.tactusoft.crm.view.backing;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDetailDataModel;

@Named
@Scope("view")
public class CampaignAdminBacking extends CampaignBacking {

	private static final long serialVersionUID = 1L;
	private List<SelectItem> listUserItem;
	private CrmUser crmUser;
	private Integer status;
	private Integer maxResults;
	private List<String> listCrmBranchSelected;
	private Date startDate;
	private Date endDate;
	private List<String> listStatus = new LinkedList<String>();
	private String statusString;
	private List<CrmCampaignDetail> listDetail;
	private CampaignDetailDataModel modelDetail;
	private CrmCampaignDetail selectedDetail;

	public CampaignAdminBacking() {
		startDate = new Date();
		endDate = new Date();
		maxResults = 100;

		listStatus.add("1");
		listStatus.add("2");
		listStatus.add("3");

		statusString = getStringSelecteds(listStatus);
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public CrmCampaignDetail getSelectedDetail() {
		return selectedDetail;
	}

	public void setSelectedDetail(CrmCampaignDetail selectedDetail) {
		this.selectedDetail = selectedDetail;
	}

	@PostConstruct
	public void init() {
		List<CrmParameter> listParameter = parameterService
				.getListParameterByGroup("CAMPAIGN");
		mapText = new HashMap<String, String>();
		for (CrmParameter row : listParameter) {
			mapText.put(row.getCode(), row.getTextValue());
		}
	}

	public boolean isDisabled() {
		return listDetail != null && listDetail.size() > 0 ? false : true;
	}

	public List<String> getListCrmBranchSelected() {
		return listCrmBranchSelected;
	}

	public void setListCrmBranchSelected(List<String> listCrmBranchSelected) {
		this.listCrmBranchSelected = listCrmBranchSelected;
	}

	@Override
	public void generateDetail() {
		selected = selectedDetail.getCrmCampaign();
		List<CrmUser> listUser = tablesService
				.getListUserActiveByBranchAndCallCenter(selected.getCrmBranch()
						.getId());
		listUserItem = FacesUtil.entityToSelectItem(listUser, "getId",
				"getUsername");
		crmUser = new CrmUser();
	}

	public void searchAction() {
		if (listCrmBranchSelected.size() > 0) {
			String startDateString = FacesUtil.formatDate(startDate,
					"yyyy-MM-dd");
			String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd");
			String branchs = getStringSelecteds(this.listCrmBranchSelected);

			statusString = status.toString();
			if (status == 0) {
				statusString = getStringSelecteds(listStatus);
			}

			listDetail = tablesService.getListCampaignByStatus(branchs,
					startDateString, endDateString, statusString, maxResults);
			modelDetail = new CampaignDetailDataModel(listDetail);
			if (listDetail.size() > 0) {
				selectedDetail = listDetail.get(0);
				selected = selectedDetail.getCrmCampaign();
			} else {
				selectedDetail = null;
				selected = null;
			}

		} else {
			String message = FacesUtil.getMessage("app_no_branch");
			FacesUtil.addWarn(message);
		}
	}

	@Override
	public void saveAction() {
		String message = null;
		selected.setCrmUser(crmUser);
		if (selected.getState() == 4) {
			selected.setState(1);
		}
		int result = tablesService.saveCampaign(selected);
		if (result == 0) {
			searchAction();
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

	public void handleDateSelect() {
		if (startDate.compareTo(endDate) > 0) {
			endDate = startDate;
		}
	}

}
