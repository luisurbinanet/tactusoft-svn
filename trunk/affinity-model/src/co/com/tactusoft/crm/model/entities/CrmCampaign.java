package co.com.tactusoft.crm.model.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CrmCampaign generated by hbm2java
 */
@Entity
@Table(name = "crm_campaign", catalog = "crm_db")
public class CrmCampaign implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmPatient crmPatient;
	private CrmUser crmUser;
	private CrmBranch crmBranch;
	private Date dateCall;
	private String observation;
	private int state;
	private Set<CrmCampaignDetail> crmCampaignDetails = new HashSet<CrmCampaignDetail>(
			0);

	public CrmCampaign() {
	}

	public CrmCampaign(BigDecimal id, CrmPatient crmPatient, CrmUser crmUser,
			CrmBranch crmBranch, int state) {
		this.id = id;
		this.crmPatient = crmPatient;
		this.crmUser = crmUser;
		this.crmBranch = crmBranch;
		this.state = state;
	}

	public CrmCampaign(BigDecimal id, CrmPatient crmPatient, CrmUser crmUser,
			CrmBranch crmBranch, Date dateCall, String observation, int state,
			Set<CrmCampaignDetail> crmCampaignDetails) {
		this.id = id;
		this.crmPatient = crmPatient;
		this.crmUser = crmUser;
		this.crmBranch = crmBranch;
		this.dateCall = dateCall;
		this.observation = observation;
		this.state = state;
		this.crmCampaignDetails = crmCampaignDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_patient", nullable = false)
	public CrmPatient getCrmPatient() {
		return this.crmPatient;
	}

	public void setCrmPatient(CrmPatient crmPatient) {
		this.crmPatient = crmPatient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	public CrmUser getCrmUser() {
		return this.crmUser;
	}

	public void setCrmUser(CrmUser crmUser) {
		this.crmUser = crmUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_branch", nullable = false)
	public CrmBranch getCrmBranch() {
		return this.crmBranch;
	}

	public void setCrmBranch(CrmBranch crmBranch) {
		this.crmBranch = crmBranch;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_call", length = 19)
	public Date getDateCall() {
		return this.dateCall;
	}

	public void setDateCall(Date dateCall) {
		this.dateCall = dateCall;
	}

	@Column(name = "observation", length = 65535)
	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmCampaign")
	public Set<CrmCampaignDetail> getCrmCampaignDetails() {
		return this.crmCampaignDetails;
	}

	public void setCrmCampaignDetails(Set<CrmCampaignDetail> crmCampaignDetails) {
		this.crmCampaignDetails = crmCampaignDetails;
	}

}
