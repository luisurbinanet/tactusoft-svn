package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmCall generated by hbm2java
 */
@Entity
@Table(name = "crm_call", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "call_id"))
public class CrmCall implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private BigDecimal callId;
	private String agentNumber;
	private String callType;
	private String campaignId;
	private String phone;
	private String remoteChannel;
	private BigDecimal patientId;

	public CrmCall() {
	}

	public CrmCall(BigDecimal id, BigDecimal callId, String agentNumber,
			String callType, String campaignId, String phone,
			String remoteChannel) {
		this.id = id;
		this.callId = callId;
		this.agentNumber = agentNumber;
		this.callType = callType;
		this.campaignId = campaignId;
		this.phone = phone;
		this.remoteChannel = remoteChannel;
	}

	public CrmCall(BigDecimal id, BigDecimal callId, String agentNumber,
			String callType, String campaignId, String phone,
			String remoteChannel, BigDecimal patientId) {
		this.id = id;
		this.callId = callId;
		this.agentNumber = agentNumber;
		this.callType = callType;
		this.campaignId = campaignId;
		this.phone = phone;
		this.remoteChannel = remoteChannel;
		this.patientId = patientId;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "call_id", unique = true, nullable = false, scale = 0)
	public BigDecimal getCallId() {
		return this.callId;
	}

	public void setCallId(BigDecimal callId) {
		this.callId = callId;
	}

	@Column(name = "agent_number", nullable = false, length = 30)
	public String getAgentNumber() {
		return this.agentNumber;
	}

	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	@Column(name = "call_type", nullable = false, length = 45)
	public String getCallType() {
		return this.callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	@Column(name = "campaign_id", nullable = false, length = 45)
	public String getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	@Column(name = "phone", nullable = false, length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "remote_channel", nullable = false, length = 45)
	public String getRemoteChannel() {
		return this.remoteChannel;
	}

	public void setRemoteChannel(String remoteChannel) {
		this.remoteChannel = remoteChannel;
	}

	@Column(name = "patient_id", scale = 0)
	public BigDecimal getPatientId() {
		return this.patientId;
	}

	public void setPatientId(BigDecimal patientId) {
		this.patientId = patientId;
	}

}
