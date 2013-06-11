package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDataModel;
import co.com.tactusoft.crm.view.datamodel.CampaignDetailDataModel;

@Named
@Scope("view")
public class CampaignBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	@Inject
	protected TablesBo tableService;

	@Inject
	protected ParameterBo parameterService;

	protected List<CrmCampaign> list;
	protected CampaignDataModel model;
	protected CrmCampaign selected;

	protected List<CrmCampaignDetail> listDetail;
	protected CampaignDetailDataModel modelDetail;

	protected List<CrmCampaignDetail> listDetailMedication;
	protected CampaignDetailDataModel modelDetailMedication;

	protected Map<String, String> mapText;
	protected CrmAppointment selectedAppointment;

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
		refreshList();
	}

	public List<CrmCampaign> getList() {
		return list;
	}

	public void setList(List<CrmCampaign> list) {
		this.list = list;
	}

	public CampaignDataModel getModel() {
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

	public List<CrmCampaignDetail> getListDetailMedication() {
		return listDetailMedication;
	}

	public void setListDetailMedication(
			List<CrmCampaignDetail> listDetailMedication) {
		this.listDetailMedication = listDetailMedication;
	}

	public CampaignDetailDataModel getModelDetailMedication() {
		return modelDetailMedication;
	}

	public void setModelDetailMedication(
			CampaignDetailDataModel modelDetailMedication) {
		this.modelDetailMedication = modelDetailMedication;
	}

	public Map<String, String> getMapText() {
		return mapText;
	}

	public void setMapText(Map<String, String> mapText) {
		this.mapText = mapText;
	}

	public CrmAppointment getSelectedAppointment() {
		return selectedAppointment;
	}

	public void setSelectedAppointment(CrmAppointment selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	protected void refreshList() {
		List<CrmCampaign> listTemp = tableService.getListCampaignActive();
		if (listTemp.size() > 0) {
			selected = listTemp.get(0);
		} else {
			selected = null;
		}
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

	public void generateDetail() {
		List<CrmCampaignDetail> listDetailAll = selected
				.getCrmCampaignDetails();

		listDetail = new ArrayList<CrmCampaignDetail>();
		for (CrmCampaignDetail row : listDetailAll) {
			if (!row.getCampaingType().equals("MEDICATION")) {
				listDetail.add(row);
			}
		}

		listDetailMedication = new ArrayList<CrmCampaignDetail>();
		for (CrmCampaignDetail row : listDetailAll) {
			if (row.getCampaingType().equals("MEDICATION")) {
				listDetailMedication.add(row);
			}
		}

		modelDetail = new CampaignDetailDataModel(listDetail);
		modelDetailMedication = new CampaignDetailDataModel(
				listDetailMedication);

		if (listDetailMedication.size() > 0) {
			listDetail.add(listDetailMedication.get(0));
		}
	}

	public boolean isRenderedMedication() {
		return listDetailMedication != null && listDetailMedication.size() > 0;
	}

	public String getDescCampaingType(String typeCampaign) {
		return typeCampaign.equals("NO_ATTENDET") ? "No asistió a la cita"
				: typeCampaign.equals("CONFIRMED") ? "Confirmar la cita"
						: typeCampaign.equals("CONTROL") ? "No ha asistido a control"
								: "Medicamentos NO adquiridos";
	}

	public String getText(String typeCampaign) {
		return mapText.get(typeCampaign);
	}

	public String editAppoinmnetAction() {
		AppointmentBacking appointmentEditBacking = FacesUtil
				.findBean("appointmentBacking");

		appointmentEditBacking.newAction(null);
		appointmentEditBacking.setSelected(selectedAppointment);
		appointmentEditBacking.setSelectedPatient(selectedAppointment
				.getCrmPatient());
		appointmentEditBacking.setCurrentDate(selectedAppointment
				.getStartAppointmentDate());
		appointmentEditBacking.setIdBranch(selectedAppointment.getCrmBranch()
				.getId());
		appointmentEditBacking.handleBranchChange();
		appointmentEditBacking.setIdProcedureDetail(selectedAppointment
				.getCrmProcedureDetail().getId());
		appointmentEditBacking.handleProcedureDetailChange();
		appointmentEditBacking.setSelectedWSGroupSellers(selectedAppointment
				.getCodPublicity());
		appointmentEditBacking.setEdit(true);
		appointmentEditBacking.setSaved(false);
		appointmentEditBacking.setFromPage("CAMPAIGN");
		for (SelectItem item : appointmentEditBacking.getListBranch()) {
			long value = ((BigDecimal) item.getValue()).longValue();
			if (value == selectedAppointment.getCrmBranch().getId().longValue()) {
				appointmentEditBacking.setSaved(false);
				break;
			}
		}
		appointmentEditBacking.setIdBranch(selectedAppointment.getCrmBranch()
				.getId());

		return "/pages/processes/appointmentEdit.jsf?faces-redirect=true";
	}
}
