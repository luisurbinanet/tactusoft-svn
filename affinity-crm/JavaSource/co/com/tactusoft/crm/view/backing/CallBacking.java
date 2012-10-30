package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.CapaignBo;
import co.com.tactusoft.crm.model.entities.CrmCall;
import co.com.tactusoft.crm.model.entities.CrmGuideline;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

@Named
@Scope("view")
public class CallBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	@Inject
	private CapaignBo capaignService;

	private String names;
	private String agentNumber;
	private BigDecimal callId;
	private String callType;
	private BigDecimal camapignId;
	private String phone;
	private String remoteChannel;

	private CrmGuideline crmGuideline;
	private int patientGridType;

	public CallBacking() {
		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		agentNumber = req.getParameter("_AGENT_NUMBER_");
		callId = new BigDecimal(req.getParameter("_CALL_ID_"));
		callType = req.getParameter("_CALL_TYPE_");
		camapignId = new BigDecimal(req.getParameter("_CAMPAIGN_ID_"));
		phone = req.getParameter("_PHONE_");
		remoteChannel = req.getParameter("_REMOTE_CHANNEL_");

		crmGuideline = new CrmGuideline();
	}

	@PostConstruct
	public void init() {
		CrmCall call = new CrmCall();
		call.setCallId(callId);
		call.setAgentNumber(agentNumber);
		call.setCallType(callType);
		call.setCampaignId(camapignId);
		call.setPhone(phone);
		call.setRemoteChannel(remoteChannel);
		capaignService.saveCall(call);

		crmGuideline = capaignService.getGuideline(phone);

		List<CrmPatient> listCrmPatient = capaignService
				.getListPatient(remoteChannel);
		ContactBacking contactBacking = FacesUtil.findBean("contactBacking");
		contactBacking.newAction(null);

		if (listCrmPatient.size() > 0) {
			if (listCrmPatient.size() == 1) {
				patientGridType = 0;
			} else {
				patientGridType = 1;
				contactBacking.setListPatient(listCrmPatient);
				contactBacking.setPatientModel(new PatientDataModel(
						listCrmPatient));
			}
		} else {
			CrmProfile profile = tablesService.getProfileById(crmGuideline
					.getIdProfile());

			contactBacking.getSelectedPatient().setPhoneNumber(remoteChannel);
			contactBacking.getSelectedPatient().setCrmProfile(profile);
			contactBacking.setListProfile(new ArrayList<SelectItem>());
			contactBacking.getListProfile().add(
					new SelectItem(profile.getId(), profile.getCode()));

			listAllRegion = tablesService.getListRegion();
			listAllCity = tablesService.getListCity();
			listRegion = new ArrayList<SelectItem>();
			mapRegion = new HashMap<BigDecimal, CrmRegion>();

			for (CrmRegion row : this.listAllRegion) {
				if (row.getCrmCountry().getId().intValue() == crmGuideline
						.getIdCountry().intValue()) {
					listRegion.add(new SelectItem(row.getId(), row.getName()));
					mapRegion.put(row.getId(), row);
				}
			}

			contactBacking.setListRegion(listRegion);
			contactBacking.setMapRegion(mapRegion);
			contactBacking.setListAllCity(listAllCity);

			if (listRegion.size() > 0) {
				idRegion = (BigDecimal) listRegion.get(0).getValue();
				contactBacking.setIdRegion(idRegion);
				contactBacking.handleRegionChange();
			} else {
				contactBacking.setIdRegion(null);
				contactBacking.setIdCity(null);
				listRegion = new LinkedList<SelectItem>();
				listCity = new LinkedList<SelectItem>();
			}

			patientGridType = 2;
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

	// http://localhost:8080/affinity-crm/pages/public/call.jsf?_AGENT_NUMBER_=9000&_CALL_TYPE_=1&_CAMPAIGN_ID_=2&_CALL_ID_=999&_PHONE_=6445880&_REMOTE_CHANNEL_=3004413679

}
