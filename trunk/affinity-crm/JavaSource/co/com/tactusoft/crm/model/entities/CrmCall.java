package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmCall generated by hbm2java
 */
@Entity
@Table(name = "crm_call", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "id_call"))
public class CrmCall implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmCallFinal crmCallFinal;
	private String idCall;
	private String agentNumber;
	private String callType;
	private String idCampaign;
	private String phone;
	private String companyPhone;
	private String remoteChannel;
	private BigDecimal idPatient;

	public CrmCall() {
	}

	public CrmCall(BigDecimal id, String idCall, String agentNumber,
			String callType, String idCampaign, String phone,
			String companyPhone, String remoteChannel) {
		this.id = id;
		this.idCall = idCall;
		this.agentNumber = agentNumber;
		this.callType = callType;
		this.idCampaign = idCampaign;
		this.phone = phone;
		this.companyPhone = companyPhone;
		this.remoteChannel = remoteChannel;
	}

	public CrmCall(BigDecimal id, CrmCallFinal crmCallFinal, String idCall,
			String agentNumber, String callType, String idCampaign,
			String phone, String companyPhone, String remoteChannel,
			BigDecimal idPatient) {
		this.id = id;
		this.crmCallFinal = crmCallFinal;
		this.idCall = idCall;
		this.agentNumber = agentNumber;
		this.callType = callType;
		this.idCampaign = idCampaign;
		this.phone = phone;
		this.companyPhone = companyPhone;
		this.remoteChannel = remoteChannel;
		this.idPatient = idPatient;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_call_final")
	public CrmCallFinal getCrmCallFinal() {
		return this.crmCallFinal;
	}

	public void setCrmCallFinal(CrmCallFinal crmCallFinal) {
		this.crmCallFinal = crmCallFinal;
	}

	@Column(name = "id_call", unique = true, nullable = true, scale = 0)
	public String getIdCall() {
		return this.idCall;
	}

	public void setIdCall(String idCall) {
		this.idCall = idCall;
	}

	@Column(name = "agent_number", nullable = true, length = 30)
	public String getAgentNumber() {
		return this.agentNumber;
	}

	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	@Column(name = "call_type", nullable = true, length = 45)
	public String getCallType() {
		return this.callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	@Column(name = "id_campaign", nullable = true, length = 45)
	public String getIdCampaign() {
		return this.idCampaign;
	}

	public void setIdCampaign(String idCampaign) {
		this.idCampaign = idCampaign;
	}

	@Column(name = "phone", nullable = true, length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "company_phone", nullable = true, length = 45)
	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	@Column(name = "remote_channel", nullable = true, length = 45)
	public String getRemoteChannel() {
		return this.remoteChannel;
	}

	public void setRemoteChannel(String remoteChannel) {
		this.remoteChannel = remoteChannel;
	}

	@Column(name = "id_patient", scale = 0)
	public BigDecimal getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(BigDecimal idPatient) {
		this.idPatient = idPatient;
	}

}