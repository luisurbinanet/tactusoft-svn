package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import co.com.tactusoft.crm.util.FacesUtil;

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
		if (listCrmPatient.size() > 0) {
			if (listCrmPatient.size() > 0) {
				patientGridType = 0;
			} else {
				patientGridType = 1;
			}
		} else {
			CrmProfile profile = tablesService.getProfileById(crmGuideline
					.getIdProfile());

			ContactBacking contactBacking = FacesUtil
					.findBean("contactBacking");
			contactBacking.newAction(null);
			contactBacking.getSelectedPatient().setPhoneNumber(remoteChannel);
			contactBacking.getSelectedPatient().setCrmProfile(profile);
			contactBacking.setListProfile(new ArrayList<SelectItem>());
			contactBacking.getListProfile().add(
					new SelectItem(profile.getId(), profile.getCode()));
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
