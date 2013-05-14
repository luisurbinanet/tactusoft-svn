package co.com.tactusoft.crm.model.entities;

// Generated 24-abr-2013 14:52:22 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VwRipsMedicationId generated by hbm2java
 */
@Embeddable
public class VwRipsMedicationId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idBranch;
	private Date appointmentDate;
	private String idBill;
	private String clinic;
	private String docType;
	private String doc;
	private char autorization;
	private String medicationCode;
	private char medicationType;
	private String medicationName;
	private char medicationForm;
	private char medicationConcentration;
	private char medicationSize;
	private Integer unit;
	private BigDecimal amount;
	private BigDecimal total;

	public VwRipsMedicationId() {
	}

	public VwRipsMedicationId(BigDecimal idBranch, String idBill,
			char autorization, char medicationType, char medicationForm,
			char medicationConcentration, char medicationSize) {
		this.idBranch = idBranch;
		this.idBill = idBill;
		this.autorization = autorization;
		this.medicationType = medicationType;
		this.medicationForm = medicationForm;
		this.medicationConcentration = medicationConcentration;
		this.medicationSize = medicationSize;
	}

	public VwRipsMedicationId(BigDecimal idBranch, Date appointmentDate,
			String idBill, String clinic, String docType, String doc,
			char autorization, String medicationCode, char medicationType,
			String medicationName, char medicationForm,
			char medicationConcentration, char medicationSize, Integer unit,
			BigDecimal amount, BigDecimal total) {
		this.idBranch = idBranch;
		this.appointmentDate = appointmentDate;
		this.idBill = idBill;
		this.clinic = clinic;
		this.docType = docType;
		this.doc = doc;
		this.autorization = autorization;
		this.medicationCode = medicationCode;
		this.medicationType = medicationType;
		this.medicationName = medicationName;
		this.medicationForm = medicationForm;
		this.medicationConcentration = medicationConcentration;
		this.medicationSize = medicationSize;
		this.unit = unit;
		this.amount = amount;
		this.total = total;
	}

	@Column(name = "id_branch", nullable = false, scale = 0)
	public BigDecimal getIdBranch() {
		return this.idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	@Column(name = "appointment_date", length = 10)
	public Date getAppointmentDate() {
		return this.appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Column(name = "id_bill", nullable = false, length = 30)
	public String getIdBill() {
		return this.idBill;
	}

	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	@Column(name = "clinic", length = 45)
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

	@Column(name = "doc", length = 30)
	public String getDoc() {
		return this.doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	@Column(name = "autorization", nullable = false, length = 0)
	public char getAutorization() {
		return this.autorization;
	}

	public void setAutorization(char autorization) {
		this.autorization = autorization;
	}

	@Column(name = "medication_code", length = 18)
	public String getMedicationCode() {
		return this.medicationCode;
	}

	public void setMedicationCode(String medicationCode) {
		this.medicationCode = medicationCode;
	}

	@Column(name = "medication_type", nullable = false, length = 0)
	public char getMedicationType() {
		return this.medicationType;
	}

	public void setMedicationType(char medicationType) {
		this.medicationType = medicationType;
	}

	@Column(name = "medication_name")
	public String getMedicationName() {
		return this.medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	@Column(name = "medication_form", nullable = false, length = 0)
	public char getMedicationForm() {
		return this.medicationForm;
	}

	public void setMedicationForm(char medicationForm) {
		this.medicationForm = medicationForm;
	}

	@Column(name = "medication_concentration", nullable = false, length = 0)
	public char getMedicationConcentration() {
		return this.medicationConcentration;
	}

	public void setMedicationConcentration(char medicationConcentration) {
		this.medicationConcentration = medicationConcentration;
	}

	@Column(name = "medication_size", nullable = false, length = 0)
	public char getMedicationSize() {
		return this.medicationSize;
	}

	public void setMedicationSize(char medicationSize) {
		this.medicationSize = medicationSize;
	}

	@Column(name = "unit")
	public Integer getUnit() {
		return this.unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	@Column(name = "amount", precision = 10)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "total", precision = 20)
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
		if (!(other instanceof VwRipsMedicationId))
			return false;
		VwRipsMedicationId castOther = (VwRipsMedicationId) other;

		return ((this.getIdBranch() == castOther.getIdBranch()) || (this
				.getIdBranch() != null && castOther.getIdBranch() != null && this
				.getIdBranch().equals(castOther.getIdBranch())))
				&& ((this.getAppointmentDate() == castOther
						.getAppointmentDate()) || (this.getAppointmentDate() != null
						&& castOther.getAppointmentDate() != null && this
						.getAppointmentDate().equals(
								castOther.getAppointmentDate())))
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
				&& (this.getAutorization() == castOther.getAutorization())
				&& ((this.getMedicationCode() == castOther.getMedicationCode()) || (this
						.getMedicationCode() != null
						&& castOther.getMedicationCode() != null && this
						.getMedicationCode().equals(
								castOther.getMedicationCode())))
				&& (this.getMedicationType() == castOther.getMedicationType())
				&& ((this.getMedicationName() == castOther.getMedicationName()) || (this
						.getMedicationName() != null
						&& castOther.getMedicationName() != null && this
						.getMedicationName().equals(
								castOther.getMedicationName())))
				&& (this.getMedicationForm() == castOther.getMedicationForm())
				&& (this.getMedicationConcentration() == castOther
						.getMedicationConcentration())
				&& (this.getMedicationSize() == castOther.getMedicationSize())
				&& ((this.getUnit() == castOther.getUnit()) || (this.getUnit() != null
						&& castOther.getUnit() != null && this.getUnit()
						.equals(castOther.getUnit())))
				&& ((this.getAmount() == castOther.getAmount()) || (this
						.getAmount() != null && castOther.getAmount() != null && this
						.getAmount().equals(castOther.getAmount())))
				&& ((this.getTotal() == castOther.getTotal()) || (this
						.getTotal() != null && castOther.getTotal() != null && this
						.getTotal().equals(castOther.getTotal())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdBranch() == null ? 0 : this.getIdBranch().hashCode());
		result = 37
				* result
				+ (getAppointmentDate() == null ? 0 : this.getAppointmentDate()
						.hashCode());
		result = 37 * result
				+ (getIdBill() == null ? 0 : this.getIdBill().hashCode());
		result = 37 * result
				+ (getClinic() == null ? 0 : this.getClinic().hashCode());
		result = 37 * result
				+ (getDocType() == null ? 0 : this.getDocType().hashCode());
		result = 37 * result
				+ (getDoc() == null ? 0 : this.getDoc().hashCode());
		result = 37 * result + this.getAutorization();
		result = 37
				* result
				+ (getMedicationCode() == null ? 0 : this.getMedicationCode()
						.hashCode());
		result = 37 * result + this.getMedicationType();
		result = 37
				* result
				+ (getMedicationName() == null ? 0 : this.getMedicationName()
						.hashCode());
		result = 37 * result + this.getMedicationForm();
		result = 37 * result + this.getMedicationConcentration();
		result = 37 * result + this.getMedicationSize();
		result = 37 * result
				+ (getUnit() == null ? 0 : this.getUnit().hashCode());
		result = 37 * result
				+ (getAmount() == null ? 0 : this.getAmount().hashCode());
		result = 37 * result
				+ (getTotal() == null ? 0 : this.getTotal().hashCode());
		return result;
	}

}