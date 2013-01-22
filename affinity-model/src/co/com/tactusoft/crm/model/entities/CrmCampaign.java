package co.com.tactusoft.crm.model.entities;

import static javax.persistence.GenerationType.IDENTITY;

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
	private Integer id;
	private CrmPatient crmPatient;
	private CrmUser crmUser;
	private CrmLog crmLog;
	private CrmBranch crmBranch;
	private Date dateCall;
	private String observation;
	private Integer days;
	private int state;
	private Set<CrmCampaignDetail> crmCampaignDetails = new HashSet<CrmCampaignDetail>(
			0);

	public CrmCampaign() {
	}

	public CrmCampaign(CrmPatient crmPatient, CrmUser crmUser, CrmLog crmLog,
			CrmBranch crmBranch, Date dateCall, int state) {
		this.crmPatient = crmPatient;
		this.crmUser = crmUser;
		this.crmLog = crmLog;
		this.crmBranch = crmBranch;
		this.dateCall = dateCall;
		this.state = state;
	}

	public CrmCampaign(CrmPatient crmPatient, CrmUser crmUser, CrmLog crmLog,
			CrmBranch crmBranch, Date dateCall, String observation,
			Integer days, int state, Set<CrmCampaignDetail> crmCampaignDetails) {
		this.crmPatient = crmPatient;
		this.crmUser = crmUser;
		this.crmLog = crmLog;
		this.crmBranch = crmBranch;
		this.dateCall = dateCall;
		this.observation = observation;
		this.days = days;
		this.state = state;
		this.crmCampaignDetails = crmCampaignDetails;
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
	@JoinColumn(name = "id_log", nullable = false)
	public CrmLog getCrmLog() {
		return this.crmLog;
	}

	public void setCrmLog(CrmLog crmLog) {
		this.crmLog = crmLog;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_branch", nullable = false)
	public CrmBranch getCrmBranch() {
		return this.crmBranch;
	}

	public void setCrmBranch(CrmBranch crmBranch) {
		this.crmBranch = crmBranch;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_call", nullable = false, length = 19)
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

	@Column(name = "days")
	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
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
