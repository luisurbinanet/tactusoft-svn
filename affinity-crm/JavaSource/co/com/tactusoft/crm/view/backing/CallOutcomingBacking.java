package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.CapaignBo;
import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmCall;
import co.com.tactusoft.crm.model.entities.CrmCallFinal;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

@Named
@Scope("view")
public class CallOutcomingBacking extends ContactBacking {

	private static final long serialVersionUID = 1L;

	@Inject
	private CapaignBo capaignService;

	@Inject
	private ParameterBo parameterService;

	private String names;
	private String agentNumber;
	private String phone;

	private List<SelectItem> listCallFinal;
	private BigDecimal idCallFinal;
	private Map<BigDecimal, CrmCallFinal> mapCallFinal;

	public boolean searched;
	public boolean called;
	public boolean saved;

	private String calls = "-1";
	private CrmCall call;

	public CallOutcomingBacking() {
		searched = false;
		called = false;
		saved = false;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public List<SelectItem> getListCallFinal() {
		return listCallFinal;
	}

	public void setListCallFinal(List<SelectItem> listCallFinal) {
		this.listCallFinal = listCallFinal;
	}

	public BigDecimal getIdCallFinal() {
		return idCallFinal;
	}

	public void setIdCallFinal(BigDecimal idCallFinal) {
		this.idCallFinal = idCallFinal;
	}

	public Map<BigDecimal, CrmCallFinal> getMapCallFinal() {
		return mapCallFinal;
	}

	public void setMapCallFinal(Map<BigDecimal, CrmCallFinal> mapCallFinal) {
		this.mapCallFinal = mapCallFinal;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public boolean isSearched() {
		return searched;
	}

	public void setSearched(boolean searched) {
		this.searched = searched;
	}

	public boolean isCalled() {
		return called;
	}

	public void setCalled(boolean called) {
		this.called = called;
	}

	public String getCalls() {
		CrmParameter crmParameter = parameterService.getParameter("NUM_CALLS");
		calls = crmParameter.getTextValue();
		return calls;
	}

	public void setCalls(String calls) {
		this.calls = calls;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	@PostConstruct
	public void init() {
		// try {
		generateCallFinal();

		/*
		 * call = new CrmCall(); call.setIdCall(callId);
		 * call.setAgentNumber(agentNumber); call.setCallType(callType);
		 * call.setIdCampaign(camapignId); call.setPhone(phone);
		 * call.setCompanyPhone(companyPhone);
		 * call.setRemoteChannel(remoteChannel);
		 * 
		 * try { int result = capaignService.saveCall(call); if (result == -1) {
		 * call = capaignService.getListCallById(callId);
		 * call.setAgentNumber(agentNumber); call.setCallType(callType);
		 * call.setIdCampaign(camapignId); call.setPhone(phone);
		 * call.setCompanyPhone(companyPhone);
		 * call.setRemoteChannel(remoteChannel); capaignService.saveCall(call);
		 * } } catch (Exception ex) {
		 * 
		 * }
		 * 
		 * crmGuideline = capaignService.getGuideline(companyPhone);
		 * generateProfile();
		 * 
		 * List<CrmPatient> listCrmPatient; if (phone != null) { listCrmPatient
		 * = capaignService.getListPatient(phone); } else { listCrmPatient = new
		 * LinkedList<CrmPatient>(); }
		 * 
		 * super.newAction(null);
		 * 
		 * listAllRegion = tablesService.getListRegion(); listAllCity =
		 * tablesService.getListCity();
		 * 
		 * if (listCrmPatient.size() > 0) { if (listCrmPatient.size() == 1) {
		 * patientGridType = 0; this.setSelectedPatient(listCrmPatient.get(0));
		 * generateRegion(this.getSelectedPatient().getIdCountry()); } else {
		 * patientGridType = 1; this.setListPatient(listCrmPatient);
		 * this.setPatientModel(new PatientDataModel(listCrmPatient));
		 * this.setTmpSelectedPatient(listCrmPatient.get(0));
		 * this.setIdCountry(crmGuideline.getIdCountry()); } } else {
		 * this.new2Action(null); }
		 * 
		 * crmCountry = tablesService.getCountry(this.getIdCountry());
		 * mapCountry = new HashMap<BigDecimal, CrmCountry>();
		 * mapCountry.put(crmCountry.getId(), crmCountry);
		 * generateDocType(crmCountry.getCode()); } catch (Exception ex) {
		 * super.newAction(null); patientGridType = 1; }
		 */
	}

	private void generateCallFinal() {
		listCallFinal = new ArrayList<SelectItem>();
		mapCallFinal = new HashMap<BigDecimal, CrmCallFinal>();

		String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
		listCallFinal.add(new SelectItem(null, label));
		for (CrmCallFinal row : capaignService.getListCallFinalIncoming()) {
			listCallFinal.add(new SelectItem(row.getId(), row.getCode() + " - "
					+ row.getDescription()));
			mapCallFinal.put(row.getId(), row);
		}
	}

	@Override
	public void newAction(ActionEvent event) {
		super.newAction(event);
		phone = null;
		searched = false;
		called = false;
		saved = false;
		tmpSelectedPatient = null;
	}

	public void searchAction(ActionEvent event) {
		List<CrmPatient> listCrmPatient = capaignService.getListPatient(phone);
		patientModel = new PatientDataModel(listCrmPatient);
		if (listCrmPatient.size() > 0) {
			tmpSelectedPatient = listCrmPatient.get(0);
		}
		searched = true;
	}

	public void callAction(ActionEvent event) {
		
		called = true;
	}

	@Override
	public void saveAction() {
		call = new CrmCall();
		
		String sessionId = FacesUtil.getSessionID().substring(0, 16);
		int numCalls = FacesUtil.getCurrentUserData().getNumCalls();
		numCalls = numCalls + 1;
		FacesUtil.getCurrentUserData().setNumCalls(numCalls);
		String idCall = sessionId + numCalls;
		call.setIdCall(idCall);
		
		String agentNumber = "Agent/"
				+ FacesUtil.getCurrentUser().getExtensionAgent();
		call.setAgentNumber(agentNumber);
		call.setCallType(Constant.CALLE_TYPE_OUT);
		call.setCrmCallFinal(mapCallFinal.get(idCallFinal));
		call.setPhone(phone);

		if (this.selectedPatient != null
				&& this.selectedPatient.getId() != null) {
			call.setIdPatient(this.selectedPatient.getId());
		}
		capaignService.saveCall(call);
		String message = FacesUtil.getMessage("cam_msg_update_ok",
				selectedPatient.getNames());
		FacesUtil.addInfo(message);
	}

	public String goAppointment() {
		AppointmentBacking appointmentBacking = FacesUtil
				.findBean("appointmentBacking");
		appointmentBacking.setSelectedPatient(this.getSelectedPatient());
		return "/pages/processes/appointment.jsf?faces-redirect=true";
	}

	public void handleFinalDetailChange() {
		if (call != null) {
			call.setCrmCallFinal(mapCallFinal.get(idCallFinal));
			capaignService.saveCall(call);
		}
	}
}
