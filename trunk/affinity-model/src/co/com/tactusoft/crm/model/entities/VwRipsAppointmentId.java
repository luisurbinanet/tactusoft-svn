package co.com.tactusoft.crm.model.entities;

// Generated 24-abr-2013 14:52:22 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VwRipsAppointmentId generated by hbm2java
 */
@Embeddable
public class VwRipsAppointmentId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idBranch;
	private String idBill;
	private String clinic;
	private String docType;
	private String doc;
	private Date appointmentDate;
	private String appointmentType;
	private char autorization;
	private String appointmentCode;
	private int appointmentTarget;
	private int appointmentExternal;
	private String diagnosis1;
	private char diagnosis2;
	private char diagnosis3;
	private char diagnosis4;
	private int diagnosisType;
	private BigDecimal amount;
	private int quote;
	private BigDecimal total;

	public VwRipsAppointmentId() {
	}

	public VwRipsAppointmentId(BigDecimal idBranch, String idBill,
			String clinic, String appointmentType, char autorization,
			String appointmentCode, int appointmentTarget,
			int appointmentExternal, char diagnosis2, char diagnosis3,
			char diagnosis4, int diagnosisType, int quote) {
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

	public VwRipsAppointmentId(BigDecimal idBranch, String idBill,
			String clinic, String docType, String doc, Date appointmentDate,
			String appointmentType, char autorization, String appointmentCode,
			int appointmentTarget, int appointmentExternal, String diagnosis1,
			char diagnosis2, char diagnosis3, char diagnosis4,
			int diagnosisType, BigDecimal amount, int quote, BigDecimal total) {
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
	public char getAutorization() {
		return this.autorization;
	}

	public void setAutorization(char autorization) {
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
	public char getDiagnosis2() {
		return this.diagnosis2;
	}

	public void setDiagnosis2(char diagnosis2) {
		this.diagnosis2 = diagnosis2;
	}

	@Column(name = "diagnosis_3", nullable = false, length = 0)
	public char getDiagnosis3() {
		return this.diagnosis3;
	}

	public void setDiagnosis3(char diagnosis3) {
		this.diagnosis3 = diagnosis3;
	}

	@Column(name = "diagnosis_4", nullable = false, length = 0)
	public char getDiagnosis4() {
		return this.diagnosis4;
	}

	public void setDiagnosis4(char diagnosis4) {
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VwRipsAppointmentId))
			return false;
		VwRipsAppointmentId castOther = (VwRipsAppointmentId) other;

		return ((this.getIdBranch() == castOther.getIdBranch()) || (this
				.getIdBranch() != null && castOther.getIdBranch() != null && this
				.getIdBranch().equals(castOther.getIdBranch())))
				&& ((this.getIdBill() == castOther.getIdBill()) || (this
						.getIdBill() != null && castOther.getIdBill() != null && this
						.getIdBill().equals(castOther.getIdBill())))
				&& ((this.getClinic() == castOther.getClinic()) || (this
						.getClinic() != null && castOther.getClinic() != null && this
						.getClinic().equals(castOther.getClinic())))
				&& ((this.getDocType() == castOther.getDocType()) || (this
						.getDocType() != null && castOther.getDocType() != null && this
						.getDocType().equals(castOther.getDocType())))
				&& ((this.getDoc() == castOther.getDoc()) || (this.getDoc() != null
						&& castOther.getDoc() != null && this.getDoc().equals(
						castOther.getDoc())))
				&& ((this.getAppointmentDate() == castOther
						.getAppointmentDate()) || (this.getAppointmentDate() != null
						&& castOther.getAppointmentDate() != null && this
						.getAppointmentDate().equals(
								castOther.getAppointmentDate())))
				&& ((this.getAppointmentType() == castOther
						.getAppointmentType()) || (this.getAppointmentType() != null
						&& castOther.getAppointmentType() != null && this
						.getAppointmentType().equals(
								castOther.getAppointmentType())))
				&& (this.getAutorization() == castOther.getAutorization())
				&& ((this.getAppointmentCode() == castOther
						.getAppointmentCode()) || (this.getAppointmentCode() != null
						&& castOther.getAppointmentCode() != null && this
						.getAppointmentCode().equals(
								castOther.getAppointmentCode())))
				&& (this.getAppointmentTarget() == castOther
						.getAppointmentTarget())
				&& (this.getAppointmentExternal() == castOther
						.getAppointmentExternal())
				&& ((this.getDiagnosis1() == castOther.getDiagnosis1()) || (this
						.getDiagnosis1() != null
						&& castOther.getDiagnosis1() != null && this
						.getDiagnosis1().equals(castOther.getDiagnosis1())))
				&& (this.getDiagnosis2() == castOther.getDiagnosis2())
				&& (this.getDiagnosis3() == castOther.getDiagnosis3())
				&& (this.getDiagnosis4() == castOther.getDiagnosis4())
				&& (this.getDiagnosisType() == castOther.getDiagnosisType())
				&& ((this.getAmount() == castOther.getAmount()) || (this
						.getAmount() != null && castOther.getAmount() != null && this
						.getAmount().equals(castOther.getAmount())))
				&& (this.getQuote() == castOther.getQuote())
				&& ((this.getTotal() == castOther.getTotal()) || (this
						.getTotal() != null && castOther.getTotal() != null && this
						.getTotal().equals(castOther.getTotal())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdBranch() == null ? 0 : this.getIdBranch().hashCode());
		result = 37 * result
				+ (getIdBill() == null ? 0 : this.getIdBill().hashCode());
		result = 37 * result
				+ (getClinic() == null ? 0 : this.getClinic().hashCode());
		result = 37 * result
				+ (getDocType() == null ? 0 : this.getDocType().hashCode());
		result = 37 * result
				+ (getDoc() == null ? 0 : this.getDoc().hashCode());
		result = 37
				* result
				+ (getAppointmentDate() == null ? 0 : this.getAppointmentDate()
						.hashCode());
		result = 37
				* result
				+ (getAppointmentType() == null ? 0 : this.getAppointmentType()
						.hashCode());
		result = 37 * result + this.getAutorization();
		result = 37
				* result
				+ (getAppointmentCode() == null ? 0 : this.getAppointmentCode()
						.hashCode());
		result = 37 * result + this.getAppointmentTarget();
		result = 37 * result + this.getAppointmentExternal();
		result = 37
				* result
				+ (getDiagnosis1() == null ? 0 : this.getDiagnosis1()
						.hashCode());
		result = 37 * result + this.getDiagnosis2();
		result = 37 * result + this.getDiagnosis3();
		result = 37 * result + this.getDiagnosis4();
		result = 37 * result + this.getDiagnosisType();
		result = 37 * result
				+ (getAmount() == null ? 0 : this.getAmount().hashCode());
		result = 37 * result + this.getQuote();
		result = 37 * result
				+ (getTotal() == null ? 0 : this.getTotal().hashCode());
		return result;
	}

}
