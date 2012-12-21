package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VwAppointment generated by hbm2java
 */
@Entity
@Table(name = "vw_appointment", catalog = "crm_db")
public class VwAppointment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String code;
	private Date startAppointmentDate;
	private Date endAppointmentDate;
	private int state;
	private BigDecimal patId;
	private String patCode;
	private String patCodeSap;
	private String patSurnames;
	private String patFirstnames;
	private String patPhoneNumber;
	private String patCellNumber;
	private BigDecimal prcDetId;
	private String prcDetName;
	private String prcDocType;
	private String prcFormulaDocType;
	private BigDecimal branchId;
	private String branchCode;
	private String branchName;
	private String branchSociety;
	private BigDecimal doctorId;
	private String doctorCode;
	private String doctorNames;
	private BigDecimal userCreateId;
	private String userCreateCode;
	private String userCreateNames;
	private String userCreateSurnames;
	private Date dateCreate;
	private BigDecimal userModifiedId;
	private String userModifiedCode;
	private String userModifiedNames;
	private String userModifiedSurnames;
	private Date dateModified;
	private BigDecimal userCheckedId;
	private String userCheckedCode;
	private String userCheckedNames;
	private String userCheckedSurnames;
	private Date dateChecked;
	private BigDecimal userCanceledId;
	private String userCanceledCode;
	private String userCanceledNames;
	private String userCanceledSurnames;
	private Date dateCanceled;
	private int closeAppointment;
	private String publicityCode;
	private String publicityName;

	public VwAppointment() {
	}

	public VwAppointment(BigDecimal id, String code, Date startAppointmentDate,
			Date endAppointmentDate, int state, BigDecimal patId,
			String patCode, String patCodeSap, BigDecimal prcDetId,
			String prcDetName, String prcDocType, String prcFormulaDocType,
			BigDecimal branchId, BigDecimal doctorId, String doctorCode,
			String doctorNames, BigDecimal userCreateId, String userCreateCode,
			String userCreateNames, String userCreateSurnames) {
		this.id = id;
		this.code = code;
		this.startAppointmentDate = startAppointmentDate;
		this.endAppointmentDate = endAppointmentDate;
		this.state = state;
		this.patId = patId;
		this.patCode = patCode;
		this.patCodeSap = patCodeSap;
		this.prcDetId = prcDetId;
		this.prcDetName = prcDetName;
		this.prcDocType = prcDocType;
		this.prcFormulaDocType = prcFormulaDocType;
		this.branchId = branchId;
		this.doctorId = doctorId;
		this.doctorCode = doctorCode;
		this.doctorNames = doctorNames;
		this.userCreateId = userCreateId;
		this.userCreateCode = userCreateCode;
		this.userCreateNames = userCreateNames;
		this.userCreateSurnames = userCreateSurnames;
	}

	public VwAppointment(BigDecimal id, String code, Date startAppointmentDate,
			Date endAppointmentDate, int state, BigDecimal patId,
			String patCode, String patCodeSap, String patSurnames,
			String patFirstnames, String patPhoneNumber, String patCellNumber,
			BigDecimal prcDetId, String prcDetName, String prcDocType,
			String prcFormulaDocType, BigDecimal branchId, String branchCode,
			String branchName, String branchSociety, BigDecimal doctorId,
			String doctorCode, String doctorNames, BigDecimal userCreateId,
			String userCreateCode, String userCreateNames,
			String userCreateSurnames, Date dateCreate,
			BigDecimal userModifiedId, String userModifiedCode,
			String userModifiedNames, String userModifiedSurnames,
			Date dateModified, BigDecimal userCheckedId,
			String userCheckedCode, String userCheckedNames,
			String userCheckedSurnames, Date dateChecked,
			BigDecimal userCanceledId, String userCanceledCode,
			String userCanceledNames, String userCanceledSurnames,
			Date dateCanceled, int closeAppointment) {
		this.id = id;
		this.code = code;
		this.startAppointmentDate = startAppointmentDate;
		this.endAppointmentDate = endAppointmentDate;
		this.state = state;
		this.patId = patId;
		this.patCode = patCode;
		this.patCodeSap = patCodeSap;
		this.patSurnames = patSurnames;
		this.patFirstnames = patFirstnames;
		this.patPhoneNumber = patPhoneNumber;
		this.patCellNumber = patCellNumber;
		this.prcDetId = prcDetId;
		this.prcDetName = prcDetName;
		this.prcDocType = prcDocType;
		this.prcFormulaDocType = prcFormulaDocType;
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.branchSociety = branchSociety;
		this.doctorId = doctorId;
		this.doctorCode = doctorCode;
		this.doctorNames = doctorNames;
		this.userCreateId = userCreateId;
		this.userCreateCode = userCreateCode;
		this.userCreateNames = userCreateNames;
		this.userCreateSurnames = userCreateSurnames;
		this.dateCreate = dateCreate;
		this.userModifiedId = userModifiedId;
		this.userModifiedCode = userModifiedCode;
		this.userModifiedNames = userModifiedNames;
		this.userModifiedSurnames = userModifiedSurnames;
		this.dateModified = dateModified;
		this.userCheckedId = userCheckedId;
		this.userCheckedCode = userCheckedCode;
		this.userCheckedNames = userCheckedNames;
		this.userCheckedSurnames = userCheckedSurnames;
		this.dateChecked = dateChecked;
		this.userCanceledId = userCanceledId;
		this.userCanceledCode = userCanceledCode;
		this.userCanceledNames = userCanceledNames;
		this.userCanceledSurnames = userCanceledSurnames;
		this.dateCanceled = dateCanceled;
		this.closeAppointment = closeAppointment;
	}

	@Id
	@Column(name = "id", nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "code", nullable = false, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "start_appointment_date", nullable = false, length = 19)
	public Date getStartAppointmentDate() {
		return this.startAppointmentDate;
	}

	public void setStartAppointmentDate(Date startAppointmentDate) {
		this.startAppointmentDate = startAppointmentDate;
	}

	@Column(name = "end_appointment_date", nullable = false, length = 19)
	public Date getEndAppointmentDate() {
		return this.endAppointmentDate;
	}

	public void setEndAppointmentDate(Date endAppointmentDate) {
		this.endAppointmentDate = endAppointmentDate;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Column(name = "pat_id", nullable = false, scale = 0)
	public BigDecimal getPatId() {
		return this.patId;
	}

	public void setPatId(BigDecimal patId) {
		this.patId = patId;
	}

	@Column(name = "pat_code", nullable = false, length = 45)
	public String getPatCode() {
		return this.patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	@Column(name = "pat_code_sap", nullable = false, length = 45)
	public String getPatCodeSap() {
		return this.patCodeSap;
	}

	public void setPatCodeSap(String patCodeSap) {
		this.patCodeSap = patCodeSap;
	}

	@Column(name = "pat_surnames", length = 45)
	public String getPatSurnames() {
		return this.patSurnames;
	}

	public void setPatSurnames(String patSurnames) {
		this.patSurnames = patSurnames;
	}

	@Column(name = "pat_firstnames", length = 45)
	public String getPatFirstnames() {
		return this.patFirstnames;
	}

	public void setPatFirstnames(String patFirstnames) {
		this.patFirstnames = patFirstnames;
	}

	@Column(name = "pat_phone_number", length = 45)
	public String getPatPhoneNumber() {
		return this.patPhoneNumber;
	}

	public void setPatPhoneNumber(String patPhoneNumber) {
		this.patPhoneNumber = patPhoneNumber;
	}

	@Column(name = "pat_cell_number", length = 45)
	public String getPatCellNumber() {
		return this.patCellNumber;
	}

	public void setPatCellNumber(String patCellNumber) {
		this.patCellNumber = patCellNumber;
	}

	@Column(name = "prc_det_id", nullable = false, scale = 0)
	public BigDecimal getPrcDetId() {
		return this.prcDetId;
	}

	public void setPrcDetId(BigDecimal prcDetId) {
		this.prcDetId = prcDetId;
	}

	@Column(name = "prc_det_name", nullable = false)
	public String getPrcDetName() {
		return this.prcDetName;
	}

	public void setPrcDetName(String prcDetName) {
		this.prcDetName = prcDetName;
	}

	@Column(name = "prc_doc_type", nullable = false)
	public String getPrcDocType() {
		return prcDocType;
	}

	public void setPrcDocType(String prcDocType) {
		this.prcDocType = prcDocType;
	}

	@Column(name = "prc_formula_doc_type", nullable = false)
	public String getPrcFormulaDocType() {
		return prcFormulaDocType;
	}

	public void setPrcFormulaDocType(String prcFormulaDocType) {
		this.prcFormulaDocType = prcFormulaDocType;
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

	@Column(name = "branch_name", length = 1000)
	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column(name = "branch_society", length = 4)
	public String getBranchSociety() {
		return this.branchSociety;
	}

	public void setBranchSociety(String branchSociety) {
		this.branchSociety = branchSociety;
	}

	@Column(name = "doctor_id", nullable = false, scale = 0)
	public BigDecimal getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(BigDecimal doctorId) {
		this.doctorId = doctorId;
	}

	@Column(name = "doctor_code", nullable = false, length = 45)
	public String getDoctorCode() {
		return this.doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	@Column(name = "doctor_names", nullable = false, length = 45)
	public String getDoctorNames() {
		return this.doctorNames;
	}

	public void setDoctorNames(String doctorNames) {
		this.doctorNames = doctorNames;
	}

	@Column(name = "user_create_id", nullable = false, scale = 0)
	public BigDecimal getUserCreateId() {
		return this.userCreateId;
	}

	public void setUserCreateId(BigDecimal userCreateId) {
		this.userCreateId = userCreateId;
	}

	@Column(name = "user_create_code", nullable = false, length = 45)
	public String getUserCreateCode() {
		return this.userCreateCode;
	}

	public void setUserCreateCode(String userCreateCode) {
		this.userCreateCode = userCreateCode;
	}

	@Column(name = "user_create_names", nullable = false)
	public String getUserCreateNames() {
		return this.userCreateNames;
	}

	public void setUserCreateNames(String userCreateNames) {
		this.userCreateNames = userCreateNames;
	}

	@Column(name = "user_create_surnames", nullable = false)
	public String getUserCreateSurnames() {
		return this.userCreateSurnames;
	}

	public void setUserCreateSurnames(String userCreateSurnames) {
		this.userCreateSurnames = userCreateSurnames;
	}

	@Column(name = "date_create", length = 19)
	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	@Column(name = "user_modified_id", scale = 0)
	public BigDecimal getUserModifiedId() {
		return this.userModifiedId;
	}

	public void setUserModifiedId(BigDecimal userModifiedId) {
		this.userModifiedId = userModifiedId;
	}

	@Column(name = "user_modified_code", length = 45)
	public String getUserModifiedCode() {
		return this.userModifiedCode;
	}

	public void setUserModifiedCode(String userModifiedCode) {
		this.userModifiedCode = userModifiedCode;
	}

	@Column(name = "user_modified_names")
	public String getUserModifiedNames() {
		return this.userModifiedNames;
	}

	public void setUserModifiedNames(String userModifiedNames) {
		this.userModifiedNames = userModifiedNames;
	}

	@Column(name = "user_modified_surnames")
	public String getUserModifiedSurnames() {
		return this.userModifiedSurnames;
	}

	public void setUserModifiedSurnames(String userModifiedSurnames) {
		this.userModifiedSurnames = userModifiedSurnames;
	}

	@Column(name = "date_modified", length = 19)
	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@Column(name = "user_checked_id", scale = 0)
	public BigDecimal getUserCheckedId() {
		return this.userCheckedId;
	}

	public void setUserCheckedId(BigDecimal userCheckedId) {
		this.userCheckedId = userCheckedId;
	}

	@Column(name = "user_checked_code", length = 45)
	public String getUserCheckedCode() {
		return this.userCheckedCode;
	}

	public void setUserCheckedCode(String userCheckedCode) {
		this.userCheckedCode = userCheckedCode;
	}

	@Column(name = "user_checked_names")
	public String getUserCheckedNames() {
		return this.userCheckedNames;
	}

	public void setUserCheckedNames(String userCheckedNames) {
		this.userCheckedNames = userCheckedNames;
	}

	@Column(name = "user_checked_surnames")
	public String getUserCheckedSurnames() {
		return this.userCheckedSurnames;
	}

	public void setUserCheckedSurnames(String userCheckedSurnames) {
		this.userCheckedSurnames = userCheckedSurnames;
	}

	@Column(name = "date_checked", length = 19)
	public Date getDateChecked() {
		return this.dateChecked;
	}

	public void setDateChecked(Date dateChecked) {
		this.dateChecked = dateChecked;
	}

	@Column(name = "user_canceled_id", scale = 0)
	public BigDecimal getUserCanceledId() {
		return this.userCanceledId;
	}

	public void setUserCanceledId(BigDecimal userCanceledId) {
		this.userCanceledId = userCanceledId;
	}

	@Column(name = "user_canceled_code", length = 45)
	public String getUserCanceledCode() {
		return this.userCanceledCode;
	}

	public void setUserCanceledCode(String userCanceledCode) {
		this.userCanceledCode = userCanceledCode;
	}

	@Column(name = "user_canceled_names")
	public String getUserCanceledNames() {
		return this.userCanceledNames;
	}

	public void setUserCanceledNames(String userCanceledNames) {
		this.userCanceledNames = userCanceledNames;
	}

	@Column(name = "user_canceled_surnames")
	public String getUserCanceledSurnames() {
		return this.userCanceledSurnames;
	}

	public void setUserCanceledSurnames(String userCanceledSurnames) {
		this.userCanceledSurnames = userCanceledSurnames;
	}

	@Column(name = "date_canceled", length = 19)
	public Date getDateCanceled() {
		return this.dateCanceled;
	}

	public void setDateCanceled(Date dateCanceled) {
		this.dateCanceled = dateCanceled;
	}

	@Column(name = "close_appointment", nullable = false)
	public int getCloseAppointment() {
		return closeAppointment;
	}

	public void setCloseAppointment(int closeAppointment) {
		this.closeAppointment = closeAppointment;
	}

	@Column(name = "publicity_cod", nullable = false)
	public String getPublicityCode() {
		return publicityCode;
	}

	public void setPublicityCode(String publicityCode) {
		this.publicityCode = publicityCode;
	}

	@Column(name = "publicity_name", nullable = false)
	public String getPublicityName() {
		return publicityName;
	}

	public void setPublicityName(String publicityName) {
		this.publicityName = publicityName;
	}
	
	
}