package co.com.tactusoft.sap.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VwAppointmentMedication generated by hbm2java
 */
@Entity
@Table(name = "vw_appointment_medication", catalog = "crm_db")
public class VwAppointmentMedication implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private VwAppointmentMedicationId id;
	private String code;
	private Date startAppointmentDate;
	private int state;
	private BigDecimal patId;
	private String patCode;
	private String patCodeSap;
	private String patSurnames;
	private String patFirstnames;
	private String patPhoneNumber;
	private String patCellNumber;
	private String email;
	private BigDecimal branchId;
	private String branchCode;
	private String branchName;
	private String branchSociety;
	private BigDecimal doctorId;
	private String doctorCode;
	private String doctorNames;

	public VwAppointmentMedication() {
	}

	public VwAppointmentMedication(VwAppointmentMedicationId id, String code,
			Date startAppointmentDate, int state, BigDecimal patId,
			String patCode, String patCodeSap, String patSurnames,
			String patFirstnames, String patPhoneNumber, String patCellNumber,
			String email, BigDecimal branchId, String branchCode,
			String branchName, String branchSociety, BigDecimal doctorId,
			String doctorCode, String doctorNames, String descMaterial) {
		this.id = id;
		this.code = code;
		this.startAppointmentDate = startAppointmentDate;
		this.state = state;
		this.patId = patId;
		this.patCode = patCode;
		this.patCodeSap = patCodeSap;
		this.patSurnames = patSurnames;
		this.patFirstnames = patFirstnames;
		this.patPhoneNumber = patPhoneNumber;
		this.patCellNumber = patCellNumber;
		this.email = email;
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.branchSociety = branchSociety;
		this.doctorId = doctorId;
		this.doctorCode = doctorCode;
		this.doctorNames = doctorNames;
	}

	public VwAppointmentMedication(VwAppointmentMedicationId id) {
		this.id = id;
	}

	@EmbeddedId
	public VwAppointmentMedicationId getId() {
		return this.id;
	}

	public void setId(VwAppointmentMedicationId id) {
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

	@Column(name = "pat_code", length = 45)
	public String getPatCode() {
		return this.patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	@Column(name = "pat_code_sap", length = 45)
	public String getPatCodeSap() {
		return this.patCodeSap;
	}

	public void setPatCodeSap(String patCodeSap) {
		this.patCodeSap = patCodeSap;
	}

	@Column(name = "pat_surnames", nullable = false, length = 45)
	public String getPatSurnames() {
		return this.patSurnames;
	}

	public void setPatSurnames(String patSurnames) {
		this.patSurnames = patSurnames;
	}

	@Column(name = "pat_firstnames", nullable = false, length = 45)
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

	@Column(name = "email", length = 1000)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
