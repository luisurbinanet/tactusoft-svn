package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmParameter;
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

	@Inject
	private ParameterBo parameterService;

	private List<CrmCampaign> list;
	private CampaignDataModel model;
	private CrmCampaign selected;

	private List<CrmCampaignDetail> listDetail;
	private CampaignDetailDataModel modelDetail;

	private Map<String, String> mapText;

	public CampaignBacking() {
		newAction();
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

	public List<CrmCampaign> getList() {
		return list;
	}

	public void setList(List<CrmCampaign> list) {
		this.list = list;
	}

	public CampaignDataModel getModel() {
		if (model == null) {
			refreshList();
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

	private void refreshList() {
		List<CrmCampaign> listTemp = tableService.getListCampaign();
		list = new LinkedList<CrmCampaign>();
		if (listTemp.size() > 0) {
			list.add(listTemp.get(0));
		}
		model = new CampaignDataModel(list);

		if (list.size() > 0) {
			selected = list.get(0);
		}

		isDisabledButton();
	}

	public void newAction() {
		selected = new CrmCampaign();
		selected.setState(Constant.STATE_ACTIVE);
	}

	public void saveAction() {
		String message = null;

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

	public boolean isDisabledButton() {
		getModel();
		return (this.list == null || this.list.size() == 0) ? true : false;
	}

	public void generateDetail() {
		listDetail = tableService.getListCampaignDetail(selected.getId());
		modelDetail = new CampaignDetailDataModel(listDetail);
	}

	public String getDescCampaingType(String typeCampaign) {
		return typeCampaign.equals("NO_ATTENDET") ? "No asistió a la cita"
				: typeCampaign.equals("CONFIRMED") ? "Confirmar la cita"
						: "No ha asistido a control";
	}

	public String getText(String typeCampaign) {
		return mapText.get(typeCampaign);
	}

}
