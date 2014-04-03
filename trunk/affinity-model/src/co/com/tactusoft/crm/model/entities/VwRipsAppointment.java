package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VwRipsAppointment generated by hbm2java
 */
@Entity
@Table(name = "vw_rips_appointment", catalog = "crm_db")
public class VwRipsAppointment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idAppointment;
	private BigDecimal idBranch;
	private String idBill;
	private String clinic;
	private String docType;
	private String doc;
	private Date appointmentDate;
	private String appointmentType;
	private String autorization;
	private String appointmentCode;
	private int appointmentTarget;
	private int appointmentExternal;
	private String diagnosis1;
	private String diagnosis2;
	private String diagnosis3;
	private String diagnosis4;
	private int diagnosisType;
	private BigDecimal amount;
	private int quote;
	private BigDecimal total;
	private String typeHistory;

	public VwRipsAppointment() {
	}

	public VwRipsAppointment(BigDecimal idAppointment) {
		this.idAppointment = idAppointment;
	}

	public VwRipsAppointment(BigDecimal idBranch, String idBill, String clinic,
			String appointmentType, String autorization,
			String appointmentCode, int appointmentTarget,
			int appointmentExternal, String diagnosis2, String diagnosis3,
			String diagnosis4, int diagnosisType, int quote) {
		this.idBranch = idBranch;
		this.idBill = idBill;
		this.clinic = clinic;
		this.appointmentType = appointmentType;
		this.autorization = autorization;
		this.appointmentCode = appointmentCode;
		this.appointmentTarget = appointmentTarget;
		this.appointmentExternal = appointmentExternal;
		this.diagnosis2 = diagnosis2;
		this.diagnosis3 = diagnosis3;
		this.diagnosis4 = diagnosis4;
		this.diagnosisType = diagnosisType;
		this.quote = quote;
	}

	public VwRipsAppointment(BigDecimal idBranch, String idBill, String clinic,
			String docType, String doc, Date appointmentDate,
			String appointmentType, String autorization,
			String appointmentCode, int appointmentTarget,
			int appointmentExternal, String diagnosis1, String diagnosis2,
			String diagnosis3, String diagnosis4, int diagnosisType,
			BigDecimal amount, int quote, BigDecimal total, String typeHistory) {
		this.idBranch = idBranch;
		this.idBill = idBill;
		this.clinic = clinic;
		this.docType = docType;
		this.doc = doc;
		this.appointmentDate = appointmentDate;
		this.appointmentType = appointmentType;
		this.autorization = autorization;
		this.appointmentCode = appointmentCode;
		this.appointmentTarget = appointmentTarget;
		this.appointmentExternal = appointmentExternal;
		this.diagnosis1 = diagnosis1;
		this.diagnosis2 = diagnosis2;
		this.diagnosis3 = diagnosis3;
		this.diagnosis4 = diagnosis4;
		this.diagnosisType = diagnosisType;
		this.amount = amount;
		this.quote = quote;
		this.total = total;
		this.typeHistory = typeHistory;
	}

	@Id
	@Column(name = "id_appointment", nullable = false, scale = 0)
	public BigDecimal getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(BigDecimal idAppointment) {
		this.idAppointment = idAppointment;
	}

	@Column(name = "id_branch", nullable = false, scale = 0)
	public BigDecimal getIdBranch() {
		return this.idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	@Column(name = "id_bill", nullable = false, length = 30)
	public String getIdBill() {
		return this.idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	@Column(name = "clinic", nullable = false, length = 12)
	public String getClinic() {
		return this.clinic;
	}

	public void setClinic(String clinic) {
		this.clinic = clinic;
	}

	@Column(name = "doc_type", length = 2)
	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	@Column(name = "doc", length = 45)
	public String getDoc() {
		return this.doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	@Column(name = "appointment_date", length = 10)
	public Date getAppointmentDate() {
		return this.appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Column(name = "appointment_type", nullable = false)
	public String getAppointmentType() {
		return this.appointmentType;
	}

	public void setAppointmentType(String appointmentType) {
		this.appointmentType = appointmentType;
	}

	@Column(name = "autorization", nullable = false, length = 0)
	public String getAutorization() {
		return this.autorization;
	}

	public void setAutorization(String autorization) {
		this.autorization = autorization;
	}

	@Column(name = "appointment_code", nullable = false, length = 6)
	public String getAppointmentCode() {
		return this.appointmentCode;
	}

	public void setAppointmentCode(String appointmentCode) {
		this.appointmentCode = appointmentCode;
	}

	@Column(name = "appointment_target", nullable = false)
	public int getAppointmentTarget() {
		return this.appointmentTarget;
	}

	public void setAppointmentTarget(int appointmentTarget) {
		this.appointmentTarget = appointmentTarget;
	}

	@Column(name = "appointment_external", nullable = false)
	public int getAppointmentExternal() {
		return this.appointmentExternal;
	}

	public void setAppointmentExternal(int appointmentExternal) {
		this.appointmentExternal = appointmentExternal;
	}

	@Column(name = "diagnosis_1", length = 4)
	public String getDiagnosis1() {
		return this.diagnosis1;
	}

	public void setDiagnosis1(String diagnosis1) {
		this.diagnosis1 = diagnosis1;
	}

	@Column(name = "diagnosis_2", nullable = false, length = 0)
	public String getDiagnosis2() {
		return this.diagnosis2;
	}

	public void setDiagnosis2(String diagnosis2) {
		this.diagnosis2 = diagnosis2;
	}

	@Column(name = "diagnosis_3", nullable = false, length = 0)
	public String getDiagnosis3() {
		return this.diagnosis3;
	}

	public void setDiagnosis3(String diagnosis3) {
		this.diagnosis3 = diagnosis3;
	}

	@Column(name = "diagnosis_4", nullable = false, length = 0)
	public String getDiagnosis4() {
		return this.diagnosis4;
	}

	public void setDiagnosis4(String diagnosis4) {
		this.diagnosis4 = diagnosis4;
	}

	@Column(name = "diagnosis_type", nullable = false)
	public int getDiagnosisType() {
		return this.diagnosisType;
	}

	public void setDiagnosisType(int diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

	@Column(name = "amount", precision = 10)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "quote", nullable = false)
	public int getQuote() {
		return this.quote;
	}

	public void setQuote(int quote) {
		this.quote = quote;
	}

	@Column(name = "total", precision = 10)
	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Column(name = "type_history")
	public String getTypeHistory() {
		return typeHistory;
	}

	public void setTypeHistory(String typeHistory) {
		this.typeHistory = typeHistory;
	}
}
