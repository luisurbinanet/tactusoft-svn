package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * CrmCall generated by hbm2java
 */
@Entity
@Table(name = "crm_call", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_call", "id_campaign" }))
public class CrmCall implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmPatient crmPatient;
	private CrmCallTypeDetail crmCallTypeDetail;
	private String idCall;
	private String agentNumber;
	private String callType;
	private String idCampaign;
	private String phone;
	private String companyPhone;
	private String remoteChannel;
	private BigDecimal idCallFinal;
	private Date callDate;
	private String asteriskId;

	public CrmCall() {
	}

	public CrmCall(BigDecimal id, String idCall) {
		this.id = id;
		this.idCall = idCall;
	}

	public CrmCall(BigDecimal id, CrmPatient crmPatient,
			CrmCallTypeDetail crmCallTypeDetail, String idCall,
			String agentNumber, String callType, String idCampaign,
			String phone, String companyPhone, String remoteChannel,
			BigDecimal idCallFinal, Date callDate, String asteriskId) {
		this.id = id;
		this.crmPatient = crmPatient;
		this.crmCallTypeDetail = crmCallTypeDetail;
		this.idCall = idCall;
		this.agentNumber = agentNumber;
		this.callType = callType;
		this.idCampaign = idCampaign;
		this.phone = phone;
		this.companyPhone = companyPhone;
		this.remoteChannel = remoteChannel;
		this.idCallFinal = idCallFinal;
		this.callDate = callDate;
		this.asteriskId = asteriskId;
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
	@JoinColumn(name = "id_patient")
	public CrmPatient getCrmPatient() {
		return this.crmPatient;
	}

	public void setCrmPatient(CrmPatient crmPatient) {
		this.crmPatient = crmPatient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_call_type")
	public CrmCallTypeDetail getCrmCallTypeDetail() {
		return this.crmCallTypeDetail;
	}

	public void setCrmCallTypeDetail(CrmCallTypeDetail crmCallTypeDetail) {
		this.crmCallTypeDetail = crmCallTypeDetail;
	}

	@Column(name = "id_call", unique = true, nullable = false, length = 20)
	public String getIdCall() {
		return this.idCall;
	}

	public void setIdCall(String idCall) {
		this.idCall = idCall;
	}

	@Column(name = "agent_number", length = 30)
	public String getAgentNumber() {
		return this.agentNumber;
	}

	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	@Column(name = "call_type", length = 45)
	public String getCallType() {
		return this.callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	@Column(name = "id_campaign", length = 45)
	public String getIdCampaign() {
		return this.idCampaign;
	}

	public void setIdCampaign(String idCampaign) {
		this.idCampaign = idCampaign;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "company_phone", length = 45)
	public String getCompanyPhone() {
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	@Column(name = "remote_channel", length = 45)
	public String getRemoteChannel() {
		return this.remoteChannel;
	}

	public void setRemoteChannel(String remoteChannel) {
		this.remoteChannel = remoteChannel;
	}

	@Column(name = "id_call_final", scale = 0)
	public BigDecimal getIdCallFinal() {
		return this.idCallFinal;
	}

	public void setIdCallFinal(BigDecimal idCallFinal) {
		this.idCallFinal = idCallFinal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "call_date", length = 19)
	public Date getCallDate() {
		return callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

	@Column(name = "asterisk_id", length = 20)
	public String getAsteriskId() {
		return asteriskId;
	}

	public void setAsteriskId(String asteriskId) {
		this.asteriskId = asteriskId;
	}

}
