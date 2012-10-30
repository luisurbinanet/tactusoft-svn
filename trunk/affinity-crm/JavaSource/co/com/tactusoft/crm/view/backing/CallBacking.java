package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomListsExecute;

import co.com.tactusoft.crm.controller.bo.CapaignBo;
import co.com.tactusoft.crm.model.entities.CrmCall;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmGuideline;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
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

	private ContactBacking contactBacking;
	private CrmCountry crmCountry;

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

	@PostConstruct
	public void init() {
		contactBacking = FacesUtil.findBean("contactBacking");
		try {
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
			contactBacking.newAction(null);

			listAllRegion = tablesService.getListRegion();
			listAllCity = tablesService.getListCity();

			if (listCrmPatient.size() > 0) {
				if (listCrmPatient.size() == 1) {
					patientGridType = 0;
					contactBacking.setSelectedPatient(listCrmPatient.get(0));
					generateRegion(contactBacking.getSelectedPatient()
							.getIdCountry());
				} else {
					patientGridType = 1;
					contactBacking.setListPatient(listCrmPatient);
					contactBacking.setPatientModel(new PatientDataModel(
							listCrmPatient));
					contactBacking.setTmpSelectedPatient(listCrmPatient.get(0));
					contactBacking.setIdCountry(crmGuideline.getIdCountry());
				}
			} else {
				CrmProfile profile = tablesService.getProfileById(crmGuideline
						.getIdProfile());

				contactBacking.getSelectedPatient().setPhoneNumber(
						remoteChannel);
				contactBacking.getSelectedPatient().setCrmProfile(profile);
				contactBacking.setListProfile(new ArrayList<SelectItem>());
				contactBacking.getListProfile().add(
						new SelectItem(profile.getId(), profile.getCode()));

				generateRegion(crmGuideline.getIdCountry());
				patientGridType = 2;
			}

			crmCountry = tablesService
					.getCountry(contactBacking.getIdCountry());
			generateDocType(crmCountry.getCode());
		} catch (Exception ex) {
			contactBacking.newAction(null);
			patientGridType = 1;
		}
	}

	public void addContactAction(ActionEvent event) {
		contactBacking.setSelectedPatient(contactBacking
				.getTmpSelectedPatient());
		patientGridType = 0;
		generateRegion(contactBacking.getSelectedPatient().getIdCountry());
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

		contactBacking.setIdCountry(idCountry);
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
		contactBacking.setListDocType(listDocType);
	}

	// http://localhost:8080/affinity-crm/pages/public/call.jsf?_AGENT_NUMBER_=9000&_CALL_TYPE_=1&_CAMPAIGN_ID_=2&_CALL_ID_=999&_PHONE_=6445880&_REMOTE_CHANNEL_=3004413679

}
