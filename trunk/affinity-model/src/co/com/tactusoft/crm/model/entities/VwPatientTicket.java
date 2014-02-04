package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VwPatientTicket generated by hbm2java
 */
@Entity
@Table(name = "vw_patient_ticket", catalog = "crm_db")
public class VwPatientTicket implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String pacientDoc;
	private String patientNames;
	private String patientSurnames;
	private Date createDate;
	private String username;
	private String userNames;
	private String userSurnames;
	private String ticket;
	private BigDecimal branchId;
	private String branchCode;
	private String brancheName;
	private String obs;

	public VwPatientTicket() {
	}

	public VwPatientTicket(BigDecimal id, String patientNames,
			String patientSurnames, Date createDate, String username,
			String userNames, String userSurnames, BigDecimal branchId) {
		this.id = id;
		this.patientNames = patientNames;
		this.patientSurnames = patientSurnames;
		this.createDate = createDate;
		this.username = username;
		this.userNames = userNames;
		this.userSurnames = userSurnames;
		this.branchId = branchId;
	}

	public VwPatientTicket(BigDecimal id, String pacientDoc,
			String patientNames, String patientSurnames, Date createDate,
			String username, String userNames, String userSurnames,
			String ticket, BigDecimal branchId, String branchCode,
			String brancheName, String obs) {
		this.id = id;
		this.pacientDoc = pacientDoc;
		this.patientNames = patientNames;
		this.patientSurnames = patientSurnames;
		this.createDate = createDate;
		this.username = username;
		this.userNames = userNames;
		this.userSurnames = userSurnames;
		this.ticket = ticket;
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.brancheName = brancheName;
		this.obs = obs;
	}

	@Id
	@Column(name = "id", nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "pacient_doc", length = 45)
	public String getPacientDoc() {
		return this.pacientDoc;
	}

	public void setPacientDoc(String pacientDoc) {
		this.pacientDoc = pacientDoc;
	}

	@Column(name = "patient_names", nullable = false, length = 45)
	public String getPatientNames() {
		return this.patientNames;
	}

	public void setPatientNames(String patientNames) {
		this.patientNames = patientNames;
	}

	@Column(name = "patient_surnames", nullable = false, length = 45)
	public String getPatientSurnames() {
		return this.patientSurnames;
	}

	public void setPatientSurnames(String patientSurnames) {
		this.patientSurnames = patientSurnames;
	}

	@Column(name = "create_date", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "username", nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "user_names", nullable = false)
	public String getUserNames() {
		return this.userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	@Column(name = "user_surnames", nullable = false)
	public String getUserSurnames() {
		return this.userSurnames;
	}

	public void setUserSurnames(String userSurnames) {
		this.userSurnames = userSurnames;
	}

	@Column(name = "ticket", length = 45)
	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	@Column(name = "branch_id", nullable = false, scale = 0)
	public BigDecimal getBranchId() {
		return this.branchId;
	}

	public void setBranchId(BigDecimal branchId) {
		this.branchId = branchId;
	}

	@Column(name = "branch_code", length = 45)
	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	@Column(name = "branche_name", length = 1000)
	public String getBrancheName() {
		return this.brancheName;
	}

	public void setBrancheName(String brancheName) {
		this.brancheName = brancheName;
	}

	@Column(name = "obs", length = 65535)
	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
