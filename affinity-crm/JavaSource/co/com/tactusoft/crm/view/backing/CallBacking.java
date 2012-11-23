package co.com.tactusoft.crm.view.backing;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.CapaignBo;
import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmCall;
import co.com.tactusoft.crm.model.entities.CrmCallFinal;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmGuideline;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomListsExecute;

@Named
@Scope("view")
public class CallBacking extends ContactBacking {

	private static final long serialVersionUID = 1L;

	@Inject
	private CapaignBo capaignService;
	
	@Inject
	private ParameterBo parameterService;

	private String names;
	private String agentNumber;
	private BigDecimal callId;
	private String callType;
	private String camapignId;
	private String phone;
	private String companyPhone;
	private String remoteChannel;

	private CrmCall call;
	private CrmGuideline crmGuideline;
	private int patientGridType;

	private CrmCountry crmCountry;

	private List<SelectItem> listCallFinal;
	private BigDecimal idCallFinal;
	private Map<BigDecimal, CrmCallFinal> mapCallFinal;

	private CrmProfile profile;
	public boolean renderedError;

	private String calls = "-1";

	public CallBacking() {
		crmGuideline = new CrmGuideline();
		renderedError = false;

		try {
			HttpServletRequest req = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			agentNumber = req.getParameter("_AGENT_NUMBER_");
			callId = new BigDecimal(req.getParameter("_CALL_ID_"));
			callType = req.getParameter("_CALL_TYPE_");
			camapignId = req.getParameter("_CAMPAIGN_ID_");

			String parameter = req.getParameter("_PHONE_");
			try {
				parameter = URLDecoder.decode(parameter, "UTF-8");
			} catch (UnsupportedEncodingException e) {

			}
			String[] phones = parameter.split(":");
			companyPhone = phones[0];
			phone = phones[1];
			remoteChannel = req.getParameter("_REMOTE_CHANNEL_");
		} catch (Exception ex) {
			renderedError = true;
		}
	}

	public CrmGuideline getCrmGuideline() {
		return crmGuideline;
	}

	public void setCrmGuideline(CrmGuideline crmGuideline) {
		this.crmGuideline = crmGuideline;
	}

	public int getPatientGridType() {
		return patientGridType;
	}

	public void setPatientGridType(int patientGridType) {
		this.patientGridType = patientGridType;
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

	public boolean isRenderedError() {
		return renderedError;
	}

	public void setRenderedError(boolean renderedError) {
		this.renderedError = renderedError;
	}

	public String getCalls() {
		CrmParameter crmParameter = parameterService
				.getParameter("NUM_CALLS");
		calls = crmParameter.getTextValue();
		return calls;
	}

	public void setCalls(String calls) {
		this.calls = calls;
	}

	@PostConstruct
	public void init() {
		try {
			generateCallFinal();

			call = new CrmCall();
			call.setIdCall(callId);
			call.setAgentNumber(agentNumber);
			call.setCallType(callType);
			call.setIdCampaign(camapignId);
			call.setPhone(phone);
			call.setCompanyPhone(companyPhone);
			call.setRemoteChannel(remoteChannel);

			try {
				int result = capaignService.saveCall(call);
				if (result == -1) {
					call = capaignService.getListCallById(callId);
				}
			} catch (Exception ex) {

			}

			crmGuideline = capaignService.getGuideline(companyPhone);
			generateProfile();

			List<CrmPatient> listCrmPatient = capaignService
					.getListPatient(phone);
			super.newAction(null);

			listAllRegion = tablesService.getListRegion();
			listAllCity = tablesService.getListCity();

			if (listCrmPatient.size() > 0) {
				if (listCrmPatient.size() == 1) {
					patientGridType = 0;
					this.setSelectedPatient(listCrmPatient.get(0));
					generateRegion(this.getSelectedPatient().getIdCountry());
				} else {
					patientGridType = 1;
					this.setListPatient(listCrmPatient);
					this.setPatientModel(new PatientDataModel(listCrmPatient));
					this.setTmpSelectedPatient(listCrmPatient.get(0));
					this.setIdCountry(crmGuideline.getIdCountry());
				}
			} else {
				this.new2Action(null);
			}

			crmCountry = tablesService.getCountry(this.getIdCountry());
			mapCountry = new HashMap<BigDecimal, CrmCountry>();
			mapCountry.put(crmCountry.getId(), crmCountry);
			generateDocType(crmCountry.getCode());
		} catch (Exception ex) {
			super.newAction(null);
			patientGridType = 1;
		}
	}

	@Override
	public void addContactAction(ActionEvent event) {
		this.setSelectedPatient(this.getTmpSelectedPatient());
		patientGridType = 0;
		generateRegion(this.getSelectedPatient().getIdCountry());
	}

	private void generateCallFinal() {
		listCallFinal = new ArrayList<SelectItem>();
		mapCallFinal = new HashMap<BigDecimal, CrmCallFinal>();

		String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
		listCallFinal.add(new SelectItem(null, label));
		for (CrmCallFinal row : capaignService.getListCallFinal()) {
			listCallFinal.add(new SelectItem(row.getId(), row.getCode() + " - "
					+ row.getDescription()));
			mapCallFinal.put(row.getId(), row);
		}
	}

	private void generateProfile() {
		profile = tablesService.getProfileById(crmGuideline.getIdProfile());

		this.setListProfile(new ArrayList<SelectItem>());
		this.getListProfile().add(
				new SelectItem(profile.getId(), profile.getCode()));

		mapProfile = new HashMap<BigDecimal, CrmProfile>();
		mapProfile.put(profile.getId(), profile);
	}

	private void generateRegion(BigDecimal idCountry) {
		listRegion = new ArrayList<SelectItem>();
		mapRegion = new HashMap<BigDecimal, CrmRegion>();

		for (CrmRegion row : this.listAllRegion) {
			if (row.getCrmCountry().getId().intValue() == idCountry.intValue()) {
				listRegion.add(new SelectItem(row.getId(), row.getName()));
				mapRegion.put(row.getId(), row);
			}
		}

		this.setIdCountry(idCountry);
		this.setListRegion(listRegion);
		this.setMapRegion(mapRegion);
		this.setListAllCity(listAllCity);

		if (listRegion.size() > 0) {
			idRegion = (BigDecimal) listRegion.get(0).getValue();
			this.setIdRegion(idRegion);
			this.handleRegionChange();
		} else {
			this.setIdRegion(null);
			this.setIdCity(null);
			listRegion = new LinkedList<SelectItem>();
			listCity = new LinkedList<SelectItem>();
		}
	}

	private void generateDocType(String codCountry) {
		List<WSBean> listWSDocType = null;
		try {
			SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
			sap.getLisParameter();
			listWSDocType = CustomListsExecute.getDocTypes(sap.getUrlWebList(),
					sap.getUsername(), sap.getPassword());
		} catch (Exception ex) {
			listWSDocType = new ArrayList<WSBean>();
		}

		List<SelectItem> listDocType = new LinkedList<SelectItem>();
		String message = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
		listDocType.add(new SelectItem(null, message));
		for (WSBean row : listWSDocType) {
			if (row.getNames().contains(codCountry)) {
				listDocType.add(new SelectItem(row.getCode(), row.getNames()));
			}
		}
		this.setListDocType(listDocType);
	}

	public void new2Action(ActionEvent event) {
		super.newAction(event);
		this.getSelectedPatient().setPhoneNumber(phone);
		this.getSelectedPatient().setCrmProfile(profile);

		generateRegion(crmGuideline.getIdCountry());
		patientGridType = 2;
	}

	@Override
	public void saveAction() {
		if (patientGridType == 2) {
			this.getSelectedPatient().setCrmUserByIdUserCreate(
					securityService.getObject("usuario"));
			this.getSelectedPatient().setIdCountry(idCountry);
			this.getSelectedPatient().setIdRegion(idRegion);
			this.getSelectedPatient().setIdCity(callId);
			super.saveAction();
		}

		if (this.selectedPatient.getId() != null) {
			call.setCrmCallFinal(mapCallFinal.get(idCallFinal));
			call.setIdPatient(this.selectedPatient.getId());
			capaignService.saveCall(call);
			String message = FacesUtil.getMessage("cam_msg_update_ok",
					selectedPatient.getNames());
			FacesUtil.addInfo(message);
		}

		patientGridType = 3;
	}

	public String goAppointment() {
		AppointmentBacking appointmentBacking = FacesUtil
				.findBean("appointmentBacking");
		appointmentBacking.setSelectedPatient(this.getSelectedPatient());
		return "/pages/processes/appointment.jsf?faces-redirect=true";
	}

	public void handleFinalDetailChange() {
		call.setCrmCallFinal(mapCallFinal.get(idCallFinal));
		capaignService.saveCall(call);
	}

	// http://localhost:8080/affinity-crm/pages/public/call.jsf?_AGENT_NUMBER_=9000&_CALL_TYPE_=1&_CAMPAIGN_ID_=6445880&_CALL_ID_=999&_PHONE_=6445880:3004413679&_REMOTE_CHANNEL_=3004413679
	// http://localhost:8080/affinity-crm/pages/public/call.jsf?_AGENT_NUMBER_=9000&_CALL_TYPE_=1&_CAMPAIGN_ID_=6445880&_CALL_ID_=578&_PHONE_=6445880:300441&_REMOTE_CHANNEL_=3004413679

}
