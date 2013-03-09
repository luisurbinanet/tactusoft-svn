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
import co.com.tactusoft.crm.model.entities.CrmCallType;
import co.com.tactusoft.crm.model.entities.CrmCallTypeDetail;
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

	private List<SelectItem> listCallType;
	private List<SelectItem> listCallTypeDetail;
	private Integer idCallType;
	private Integer idCallTypeDetail;
	private Map<Integer, CrmCallTypeDetail> mapCallTypeDetail;

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
			if (phones.length > 1) {
				phone = phones[1];
			} else {
				phone = null;
			}
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

	public List<SelectItem> getListCallType() {
		return listCallType;
	}

	public void setListCallType(List<SelectItem> listCallType) {
		this.listCallType = listCallType;
	}

	public List<SelectItem> getListCallTypeDetail() {
		return listCallTypeDetail;
	}

	public void setListCallTypeDetail(List<SelectItem> listCallTypeDetail) {
		this.listCallTypeDetail = listCallTypeDetail;
	}

	public Integer getIdCallType() {
		return idCallType;
	}

	public void setIdCallType(Integer idCallType) {
		this.idCallType = idCallType;
	}

	public Integer getIdCallTypeDetail() {
		return idCallTypeDetail;
	}

	public void setIdCallTypeDetail(Integer idCallTypeDetail) {
		this.idCallTypeDetail = idCallTypeDetail;
	}

	public Map<Integer, CrmCallTypeDetail> getMapCallTypeDetail() {
		return mapCallTypeDetail;
	}

	public void setMapCallTypeDetail(
			Map<Integer, CrmCallTypeDetail> mapCallTypeDetail) {
		this.mapCallTypeDetail = mapCallTypeDetail;
	}

	public boolean isRenderedError() {
		return renderedError;
	}

	public void setRenderedError(boolean renderedError) {
		this.renderedError = renderedError;
	}

	public String getCalls() {
		CrmParameter crmParameter = parameterService.getParameter("NUM_CALLS");
		calls = crmParameter.getTextValue();
		return calls;
	}

	public void setCalls(String calls) {
		this.calls = calls;
	}

	@PostConstruct
	public void init() {
		try {
			generateCallType();

			call = new CrmCall();
			call.setIdCall(callId.toString());
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
					call.setAgentNumber(agentNumber);
					call.setCallType(callType);
					call.setIdCampaign(camapignId);
					call.setPhone(phone);
					call.setCompanyPhone(companyPhone);
					call.setRemoteChannel(remoteChannel);
					call.setCallType(Constant.CALLED_TYPE_IN);
					capaignService.saveCall(call);
				}
			} catch (Exception ex) {

			}

			crmGuideline = capaignService.getGuideline(companyPhone);
			generateProfile();

			List<CrmPatient> listCrmPatient;
			if (phone != null) {
				listCrmPatient = capaignService.getListPatient(phone);
			} else {
				listCrmPatient = new LinkedList<CrmPatient>();
			}

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

	private void generateCallType() {
		listCallType = new ArrayList<SelectItem>();
		String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
		listCallType.add(new SelectItem(null, label));

		for (CrmCallType row : capaignService.getListCallTypeIncoming()) {
			listCallType.add(new SelectItem(row.getId(), row.getDescription()));
		}

		listCallTypeDetail = new ArrayList<SelectItem>();
		mapCallTypeDetail = new HashMap<Integer, CrmCallTypeDetail>();
		listCallTypeDetail.add(new SelectItem(null, label));
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
			call.setCrmCallTypeDetail(mapCallTypeDetail.get(idCallTypeDetail));
			call.setCrmPatient(this.selectedPatient);
			call.setCallType(Constant.CALLED_TYPE_IN);
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

	public void handleCallTypeChange() {
		listCallTypeDetail = new ArrayList<SelectItem>();
		mapCallTypeDetail = new HashMap<Integer, CrmCallTypeDetail>();
		String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
		listCallTypeDetail.add(new SelectItem(null, label));
		if (idCallType != null && idCallType != 0) {
			for (CrmCallTypeDetail row : capaignService
					.getListCallTypeDetail(idCallType)) {
				listCallTypeDetail.add(new SelectItem(row.getId(), row
						.getDescription()));
				mapCallTypeDetail.put(row.getId(), row);
			}
		}
	}

	public void handleCallTypeDetailChange() {
		if (idCallTypeDetail != null && idCallTypeDetail != 0) {
			call.setCrmCallTypeDetail(mapCallTypeDetail.get(idCallTypeDetail));
			call.setCallType(Constant.CALLED_TYPE_IN);
			capaignService.saveCall(call);
		}
	}

	// http://localhost:8080/affinity-crm/pages/public/call.jsf?_AGENT_NUMBER_=9000&_CALL_TYPE_=1&_CAMPAIGN_ID_=6445880&_CALL_ID_=999&_PHONE_=6445880:3004413679&_REMOTE_CHANNEL_=3004413679
	// http://localhost:8080/affinity-crm/pages/public/call.jsf?_AGENT_NUMBER_=9000&_CALL_TYPE_=1&_CAMPAIGN_ID_=6445880&_CALL_ID_=578&_PHONE_=6445880:300441&_REMOTE_CHANNEL_=3004413679

}