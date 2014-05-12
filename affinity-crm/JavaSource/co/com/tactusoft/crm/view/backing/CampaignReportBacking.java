package co.com.tactusoft.crm.view.backing;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.PrcReportCampaign;
import co.com.tactusoft.crm.model.entities.PrcReportCampaignTotal;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDetailDataModel;
import co.com.tactusoft.crm.view.datamodel.PrcReportCampaignDataModel;
import co.com.tactusoft.crm.view.datamodel.PrcReportCampaignTotalDataModel;

@Named
@Scope("view")
public class CampaignReportBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<PrcReportCampaignTotal> listTotal;
	private PrcReportCampaignTotalDataModel modelTotal;
	private List<PrcReportCampaign> list;
	private PrcReportCampaignDataModel model;
	private PrcReportCampaign selected;
	private CampaignDetailDataModel modelDetail;

	private Date startDate;
	private Date endDate;

	public CampaignReportBacking() {
		newAction();
	}

	@PostConstruct
	public void init() {

	}

	public List<PrcReportCampaignTotal> getListTotal() {
		return listTotal;
	}

	public void setListTotal(List<PrcReportCampaignTotal> listTotal) {
		this.listTotal = listTotal;
	}

	public PrcReportCampaignTotalDataModel getModelTotal() {
		return modelTotal;
	}

	public void setModelTotal(PrcReportCampaignTotalDataModel modelTotal) {
		this.modelTotal = modelTotal;
	}

	public List<PrcReportCampaign> getList() {
		return list;
	}

	public void setList(List<PrcReportCampaign> list) {
		this.list = list;
	}

	public PrcReportCampaignDataModel getModel() {
		return model;
	}

	public void setModel(PrcReportCampaignDataModel model) {
		this.model = model;
	}

	public CampaignDetailDataModel getModelDetail() {
		return modelDetail;
	}

	public void setModelDetail(CampaignDetailDataModel modelDetail) {
		this.modelDetail = modelDetail;
	}

	public PrcReportCampaign getSelected() {
		return selected;
	}

	public void setSelected(PrcReportCampaign selected) {
		this.selected = selected;
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

	public void newAction() {
		selectedsBranchObject = null;
		startDate = new Date();
		endDate = new Date();
	}

	public void searchAction(ActionEvent event) {
		if (selectedsBranchObject != null && selectedsBranchObject.length > 0) {
			String startDateString = FacesUtil.formatDate(startDate,
					"yyyy-MM-dd");
			String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd");

			listTotal = tablesService.getListPrcReportCampaignTotal(
					selectedsBranchObject, startDateString, endDateString);
			modelTotal = new PrcReportCampaignTotalDataModel(listTotal);
			if (listTotal.size() > 0) {
				list = tablesService.getListPrcReportCampaign(
						selectedsBranchObject, startDateString, endDateString);
				model = new PrcReportCampaignDataModel(list);

				selected = list.get(0);
				List<CrmCampaignDetail> listDetail = tablesService
						.getListCampaignByBranchCampaignType(
								selected.getBranchId(),
								selected.getCampaignTypeId(), startDateString,
								endDateString);
				modelDetail = new CampaignDetailDataModel(listDetail);
			}
		} else {
			String message = FacesUtil.getMessage("app_no_branch");
			FacesUtil.addInfo(message);
		}
	}

	public void generateDetailAction(ActionEvent event) {
		String startDateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd");
		String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd");
		List<CrmCampaignDetail> listDetail = tablesService
				.getListCampaignByBranchCampaignType(selected.getBranchId(),
						selected.getCampaignTypeId(), startDateString,
						endDateString);
		modelDetail = new CampaignDetailDataModel(listDetail);
	}

}
