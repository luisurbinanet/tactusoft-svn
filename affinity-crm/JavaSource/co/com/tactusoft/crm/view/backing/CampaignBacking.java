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

import com.tactusoft.webservice.client.beans.WSBean;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmCampaignMedication;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDataModel;
import co.com.tactusoft.crm.view.datamodel.CampaignMedicationlDataModel;

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
	protected CrmCampaign selectedNoAttendet;
	protected CrmCampaign selectedConfirmed;
	protected CrmCampaign selectedControl;
	protected CrmCampaign selectedMediaction;

	protected CrmCampaignDetail selectedDetailNoAttendet;
	protected CrmCampaignDetail selectedDetailConfirmed;
	protected CrmCampaignDetail selectedDetailControl;
	protected CrmCampaignDetail selectedDetailMediaction;

	protected List<CrmCampaignMedication> listDetailMedication;
	protected CampaignMedicationlDataModel modelDetailMedication;

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

	public CrmCampaign getSelectedNoAttendet() {
		return selectedNoAttendet;
	}

	public void setSelectedNoAttendet(CrmCampaign selectedNoAttendet) {
		this.selectedNoAttendet = selectedNoAttendet;
	}

	public CrmCampaign getSelectedConfirmed() {
		return selectedConfirmed;
	}

	public void setSelectedConfirmed(CrmCampaign selectedConfirmed) {
		this.selectedConfirmed = selectedConfirmed;
	}

	public CrmCampaign getSelectedControl() {
		return selectedControl;
	}

	public void setSelectedControl(CrmCampaign selectedControl) {
		this.selectedControl = selectedControl;
	}

	public CrmCampaign getSelectedMediaction() {
		return selectedMediaction;
	}

	public void setSelectedMediaction(CrmCampaign selectedMediaction) {
		this.selectedMediaction = selectedMediaction;
	}

	public CrmCampaignDetail getSelectedDetailNoAttendet() {
		return selectedDetailNoAttendet;
	}

	public void setSelectedDetailNoAttendet(
			CrmCampaignDetail selectedDetailNoAttendet) {
		this.selectedDetailNoAttendet = selectedDetailNoAttendet;
	}

	public CrmCampaignDetail getSelectedDetailConfirmed() {
		return selectedDetailConfirmed;
	}

	public void setSelectedDetailConfirmed(
			CrmCampaignDetail selectedDetailConfirmed) {
		this.selectedDetailConfirmed = selectedDetailConfirmed;
	}

	public CrmCampaignDetail getSelectedDetailControl() {
		return selectedDetailControl;
	}

	public void setSelectedDetailControl(CrmCampaignDetail selectedDetailControl) {
		this.selectedDetailControl = selectedDetailControl;
	}

	public CrmCampaignDetail getSelectedDetailMediaction() {
		return selectedDetailMediaction;
	}

	public void setSelectedDetailMediaction(
			CrmCampaignDetail selectedDetailMediaction) {
		this.selectedDetailMediaction = selectedDetailMediaction;
	}

	public List<CrmCampaignMedication> getListDetailMedication() {
		return listDetailMedication;
	}

	public void setListDetailMedication(
			List<CrmCampaignMedication> listDetailMedication) {
		this.listDetailMedication = listDetailMedication;
	}

	public CampaignMedicationlDataModel getModelDetailMedication() {
		return modelDetailMedication;
	}

	public void setModelDetailMedication(
			CampaignMedicationlDataModel modelDetailMedication) {
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

	public CrmCampaign getSelected() {
		return selected;
	}

	public void setSelected(CrmCampaign selected) {
		this.selected = selected;
	}

	protected void refreshList() {
		List<CrmCampaign> listTemp = tableService.getListCampaignNoAttendet();
		if (listTemp.size() > 0) {
			selectedNoAttendet = listTemp.get(0);
		} else {
			selectedNoAttendet = null;
		}

		listTemp = tableService.getListCampaignConfirmed();
		if (listTemp.size() > 0) {
			selectedConfirmed = listTemp.get(0);
		} else {
			selectedConfirmed = null;
		}

		listTemp = tableService.getListCampaignControl();
		if (listTemp.size() > 0) {
			selectedControl = listTemp.get(0);
		} else {
			selectedControl = null;
		}

		listTemp = tableService.getListCampaignMedication();
		if (listTemp.size() > 0) {
			selectedMediaction = listTemp.get(0);
		} else {
			selectedMediaction = null;
		}
	}

	public void newAction() {
		selectedConfirmed = null;
		selectedControl = null;
		selectedMediaction = null;
		selectedNoAttendet = null;
	}

	public void generateDetailNoAttendet() {
		selected = selectedNoAttendet;
		generateDetail();
	}

	public void generateDetailConfirmed() {
		selected = selectedConfirmed;
		generateDetail();
	}

	public void generateDetailMedication() {
		selected = selectedMediaction;
		generateDetail();
	}

	public void generateDetailControl() {
		selected = selectedControl;
		generateDetail();
	}

	public void generateDetail() {
		selectedDetailNoAttendet = null;
		selectedDetailConfirmed = null;
		selectedDetailControl = null;
		selectedDetailMediaction = null;

		List<CrmCampaignDetail> listDetail = selected.getCrmCampaignDetails();
		for (CrmCampaignDetail row : listDetail) {
			if (row.getCampaignType() == Constant.NO_ATTENDET) {
				selectedDetailNoAttendet = row;
			} else if (row.getCampaignType() == Constant.CONFIRMED) {
				selectedDetailConfirmed = row;
			} else if (row.getCampaignType() == Constant.CONTROL) {
				selectedDetailControl = row;
			} else if (row.getCampaignType() == Constant.MEDICATION) {
				selectedDetailMediaction = row;
			}
		}

		if (selectedDetailMediaction != null) {
			listDetailMedication = tablesService
					.getListCampaignMedication(selected.getId());
		} else {
			listDetailMedication = new ArrayList<CrmCampaignMedication>();
		}

		modelDetailMedication = new CampaignMedicationlDataModel(
				listDetailMedication);
	}

	public boolean isRenderedMedication() {
		return listDetailMedication != null && listDetailMedication.size() > 0;
	}

	public String getDescCampaignType(int typeCampaign) {
		return typeCampaign == Constant.NO_ATTENDET ? "No asistió a la cita"
				: typeCampaign == Constant.CONFIRMED ? "Confirmar la cita"
						: typeCampaign == Constant.CONTROL ? "No ha asistido a control"
								: "Medicamentos NO adquiridos";
	}

	public String getText(String typeCampaign) {
		return mapText.get(typeCampaign);
	}

	public String getDocType(String country, String code) {
		for (WSBean row : FacesUtil.getCurrentUserData().getListWSDocType()) {
			if (row.getNames().contains(country) && row.getCode().equals(code)) {
				return row.getNames();
			}
		}
		return "Tipo de Identificación Desconocida";
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

	public void saveAction() {
		String message = null;
		selected.setState(1);
		int result = tableService.saveCampaign(selected);
		if (selectedDetailConfirmed != null) {
			tableService.saveCampaignDetail(selectedDetailConfirmed);
		}
		if (selectedDetailControl != null) {
			tableService.saveCampaignDetail(selectedDetailControl);
		}
		if (selectedDetailMediaction != null) {
			tableService.saveCampaignDetail(selectedDetailMediaction);
		}
		if (selectedDetailNoAttendet != null) {
			tableService.saveCampaignDetail(selectedDetailNoAttendet);
		}
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
