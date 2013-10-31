package co.com.tactusoft.crm.view.backing;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.asteriskjava.live.CallerId;
import org.asteriskjava.live.ManagerCommunicationException;
import org.asteriskjava.live.NoSuchChannelException;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.CapaignBo;
import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.AstTrunkDialpatterns;
import co.com.tactusoft.crm.model.entities.CrmCall;
import co.com.tactusoft.crm.model.entities.CrmCallType;
import co.com.tactusoft.crm.model.entities.CrmCallTypeDetail;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.VwCallRange;
import co.com.tactusoft.crm.util.Asterisk;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

@Named
@Scope("view")
public class CallOutcomingBacking extends ContactBacking {

	private static final long serialVersionUID = 1L;

	@Inject
	private ParameterBo parameterService;

	private String names;
	private String phone;
	private String indicative;

	private List<SelectItem> listCallType;
	private List<SelectItem> listCallTypeDetail;
	private Integer idCallType;
	private Integer idCallTypeDetail;
	private Map<Integer, CrmCallTypeDetail> mapCallTypeDetail;

	public boolean searched;
	public boolean called;
	public boolean saved;

	private String calls = "-1";
	private CrmCall call;

	private List<VwCallRange> listCallRange;
	private List<AstTrunkDialpatterns> listDialpatterns;
	private String remoteChannel;
	private String idCall;
	private String agentNumber;

	private String asteriskHost;
	private int asteriskPort;
	private String asteriskUser;
	private String asteriskPassword;
	private Date callDate;
	private String asteriskId;

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

	public String getIndicative() {
		return indicative;
	}

	public void setIndicative(String indicative) {
		this.indicative = indicative;
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

	public CapaignBo getCapaignService() {
		return capaignService;
	}

	public void setCapaignService(CapaignBo capaignService) {
		this.capaignService = capaignService;
	}

	public ParameterBo getParameterService() {
		return parameterService;
	}

	public void setParameterService(ParameterBo parameterService) {
		this.parameterService = parameterService;
	}

	public CrmCall getCall() {
		return call;
	}

	public void setCall(CrmCall call) {
		this.call = call;
	}

	public List<VwCallRange> getListCallRange() {
		return listCallRange;
	}

	public void setListCallRange(List<VwCallRange> listCallRange) {
		this.listCallRange = listCallRange;
	}

	public List<AstTrunkDialpatterns> getListDialpatterns() {
		return listDialpatterns;
	}

	public void setListDialpatterns(List<AstTrunkDialpatterns> listDialpatterns) {
		this.listDialpatterns = listDialpatterns;
	}

	public String getRemoteChannel() {
		return remoteChannel;
	}

	public void setRemoteChannel(String remoteChannel) {
		this.remoteChannel = remoteChannel;
	}

	public String getIdCall() {
		return idCall;
	}

	public void setIdCall(String idCall) {
		this.idCall = idCall;
	}

	public String getAsteriskHost() {
		return asteriskHost;
	}

	public void setAsteriskHost(String asteriskHost) {
		this.asteriskHost = asteriskHost;
	}

	public int getAsteriskPort() {
		return asteriskPort;
	}

	public void setAsteriskPort(int asteriskPort) {
		this.asteriskPort = asteriskPort;
	}

	public String getAsteriskUser() {
		return asteriskUser;
	}

	public void setAsteriskUser(String asteriskUser) {
		this.asteriskUser = asteriskUser;
	}

	public String getAsteriskPassword() {
		return asteriskPassword;
	}

	public void setAsteriskPassword(String asteriskPassword) {
		this.asteriskPassword = asteriskPassword;
	}

	public Date getCallDate() {
		return callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	@PostConstruct
	public void init() {
		generateCallType();
		listCallRange = tablesService.getVwCallRange();
		listDialpatterns = tablesService.getListDialpatterns();

		List<CrmParameter> listParameter = parameterService
				.getListParameterByGroup("ASTERISK");
		for (CrmParameter crmParameter : listParameter) {
			if (crmParameter.getCode().equals("ASTERISK_HOST")) {
				asteriskHost = crmParameter.getTextValue();
			} else if (crmParameter.getCode().equals("ASTERISK_PORT")) {
				asteriskPort = Integer.parseInt(crmParameter.getTextValue());
			} else if (crmParameter.getCode().equals("ASTERISK_USER")) {
				asteriskUser = crmParameter.getTextValue();
			} else if (crmParameter.getCode().equals("ASTERISK_PASSWORD")) {
				asteriskPassword = crmParameter.getTextValue();
			}
		}

		agentNumber = FacesUtil.getCurrentUser().getExtensionAgent();
	}

	private void generateCallType() {
		listCallType = new ArrayList<SelectItem>();
		String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
		listCallType.add(new SelectItem(null, label));

		for (CrmCallType row : capaignService.getListCallTypeOutcoming()) {
			listCallType.add(new SelectItem(row.getId(), row.getDescription()));
		}

		listCallTypeDetail = new ArrayList<SelectItem>();
		mapCallTypeDetail = new HashMap<Integer, CrmCallTypeDetail>();
		listCallTypeDetail.add(new SelectItem(null, label));
	}

	@Override
	public void newAction(ActionEvent event) {
		super.newAction(event);
		phone = null;
		indicative = null;
		searched = false;
		called = false;
		saved = false;
		selectedPatientTemp = null;
		idCallType = null;
		idCallTypeDetail = null;
	}

	public void searchAction(ActionEvent event) {
		List<CrmPatient> listCrmPatient = capaignService.getListPatient(phone);
		patientModel = new PatientDataModel(listCrmPatient);
		if (listCrmPatient.size() > 0) {
			selectedPatient = listCrmPatient.get(0);
		}
		searched = true;
		called = false;
	}

	public void callAction(ActionEvent event) {
		remoteChannel = null;
		call = null;
		asteriskId = null;

		String phoneWithIndicative = phone;
		if (!FacesUtil.isEmptyOrBlank(indicative)) {
			phoneWithIndicative = indicative + phoneWithIndicative;
		}
		for (VwCallRange row : listCallRange) {
			if (FacesUtil.getRegularExpression(row.getExpressionRegular(),
					phoneWithIndicative)) {
				for (AstTrunkDialpatterns dial : listDialpatterns) {
					String pattern = dial.getMatchPatternPass().replace("X",
							"\\d");
					if (FacesUtil.getRegularExpression(pattern, phone)) {
						phoneWithIndicative = phone;
						if (!FacesUtil.isEmptyOrBlank(dial.getPrependDigits())) {
							phoneWithIndicative = dial.getPrependDigits()
									+ phone;
						}

						if (row.getPrefix() == 0
								&& !FacesUtil.isEmptyOrBlank(indicative)) {
							phoneWithIndicative = phone;
						}

						remoteChannel = row.getCallNumber().replace(
								"numero_a_marcar", phoneWithIndicative);
						break;
					}
				}
				break;
			}
		}

		if (remoteChannel != null) {
			String sessionId = FacesUtil.getSessionID().substring(0, 16);
			int numCalls = FacesUtil.getCurrentUserData().getNumCalls();
			numCalls = numCalls + 1;
			FacesUtil.getCurrentUserData().setNumCalls(numCalls);
			idCall = sessionId + numCalls;

			Asterisk asterisk = new Asterisk(asteriskHost, asteriskPort,
					asteriskUser, asteriskPassword);

			try {
				CallerId callerId = new CallerId(Constant.CALLED_TYPE_OUT + ":"
						+ phone, Constant.CALLED_TYPE_OUT + ":" + phone);
				asteriskId = asterisk.callActionAplication(remoteChannel,
						agentNumber, idCall, callerId);
				called = true;
				call = new CrmCall();
				idCallType = null;
				idCallTypeDetail = null;
				callDate = new Date();
			} catch (ManagerCommunicationException e) {
				called = false;
			} catch (NoSuchChannelException e) {
				called = false;
			}

		} else {
			called = false;
			searched = false;
			String message = FacesUtil.getMessage("cam_msg_call_error");
			FacesUtil.addError(message);
		}
	}

	@Override
	public void saveAction() {
		call.setIdCall(idCall);
		call.setAgentNumber("Agent/" + agentNumber);
		call.setCallType(Constant.CALLED_TYPE_OUT);
		call.setCrmCallTypeDetail(mapCallTypeDetail.get(idCallTypeDetail));
		call.setPhone(phone);
		call.setRemoteChannel(remoteChannel);
		call.setCallDate(callDate);
		call.setAsteriskId(asteriskId);

		if (this.selectedPatient != null
				&& this.selectedPatient.getId() != null) {
			call.setCrmPatient(this.selectedPatient);
		}
		capaignService.saveCall(call);
		String message = FacesUtil.getMessage("cam_msg_update_ok",
				selectedPatient.getNames());
		FacesUtil.addInfo(message);

		saved = true;
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
		listCallTypeDetail.add(new SelectItem(-1, label));
		if (idCallType != null && idCallType != 0) {
			for (CrmCallTypeDetail row : capaignService
					.getListCallTypeDetail(idCallType)) {
				listCallTypeDetail.add(new SelectItem(row.getId(), row
						.getCode() + " - " + row.getDescription()));
				mapCallTypeDetail.put(row.getId(), row);
			}
		}
	}

	public void handleCallTypeDetailChange() {
		if (call != null) {
			this.saveAction();
		}
	}
}
