package co.com.tactusoft.crm.model.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CrmCampaignDetail generated by hbm2java
 */
@Entity
@Table(name = "crm_campaign_detail", catalog = "crm_db")
public class CrmCampaignDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private CrmCampaign crmCampaign;
	private CrmAppointment crmAppointment;
	private int campaignType;
	private int status;
	private Date callDate;

	public CrmCampaignDetail() {
	}

	public CrmCampaignDetail(CrmCampaign crmCampaign, int campaignType,
			int status, Date callDate) {
		this.crmCampaign = crmCampaign;
		this.campaignType = campaignType;
		this.status = status;
		this.callDate = callDate;
	}

	public CrmCampaignDetail(CrmCampaign crmCampaign,
			CrmAppointment crmAppointment, int campaignType, int status,
			Date callDate) {
		this.crmCampaign = crmCampaign;
		this.crmAppointment = crmAppointment;
		this.campaignType = campaignType;
		this.status = status;
		this.callDate = callDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_campaign", nullable = false)
	public CrmCampaign getCrmCampaign() {
		return this.crmCampaign;
	}

	public void setCrmCampaign(CrmCampaign crmCampaign) {
		this.crmCampaign = crmCampaign;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appointment")
	public CrmAppointment getCrmAppointment() {
		return this.crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	@Column(name = "campaign_type", nullable = false)
	public int getCampaignType() {
		return this.campaignType;
	}

	public void setCampaignType(int campaignType) {
		this.campaignType = campaignType;
	}

	@Column(name = "status", nullable = false)
	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "call_date", nullable = false, length = 19)
	public Date getCallDate() {
		return this.callDate;
	}

	public void setCallDate(Date callDate) {
		this.callDate = callDate;
	}

}
