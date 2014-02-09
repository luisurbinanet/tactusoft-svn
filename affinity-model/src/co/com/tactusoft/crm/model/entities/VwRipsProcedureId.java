package co.com.tactusoft.crm.model.entities;

// Generated 24-abr-2013 14:52:22 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VwRipsProcedureId generated by hbm2java
 */
@Embeddable
public class VwRipsProcedureId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idBranch;
	private Date appointmentDate;
	private String idBill;
	private String clinic;
	private String docType;
	private String doc;
	private String autorization;
	private String procedureType;
	private String procedureCode;
	private int procedureScope;
	private int procedureTarget;
	private String personal;
	private String diagnosis1;
	private String diagnosis2;
	private String complication;
	private String surgical;
	private BigDecimal amount;

	public VwRipsProcedureId() {
	}

	public VwRipsProcedureId(BigDecimal idBranch, String idBill,
			String autorization, int procedureScope, int procedureTarget,
			String personal, String diagnosis1, String diagnosis2, String complication,
			String surgical) {
		this.idBranch = idBranch;
		this.idBill = idBill;
		this.autorization = autorization;
		this.procedureScope = procedureScope;
		this.procedureTarget = procedureTarget;
		this.personal = personal;
		this.diagnosis1 = diagnosis1;
		this.diagnosis2 = diagnosis2;
		this.complication = complication;
		this.surgical = surgical;
	}

	public VwRipsProcedureId(BigDecimal idBranch, Date appointmentDate,
			String idBill, String clinic, String docType, String doc,
			String autorization, String procedureType, String procedureCode,
			int procedureScope, int procedureTarget, String personal,
			String diagnosis1, String diagnosis2, String complication, String surgical,
			BigDecimal amount) {
		this.idBranch = idBranch;
		this.appointmentDate = appointmentDate;
		this.idBill = idBill;
		this.clinic = clinic;
		this.docType = docType;
		this.doc = doc;
		this.autorization = autorization;
		this.procedureType = procedureType;
		this.procedureCode = procedureCode;
		this.procedureScope = procedureScope;
		this.procedureTarget = procedureTarget;
		this.personal = personal;
		this.diagnosis1 = diagnosis1;
		this.diagnosis2 = diagnosis2;
		this.complication = complication;
		this.surgical = surgical;
		this.amount = amount;
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
	public String getAutorization() {
		return this.autorization;
	}

	public void setAutorization(String autorization) {
		this.autorization = autorization;
	}

	@Column(name = "procedure_type")
	public String getProcedureType() {
		return this.procedureType;
	}

	public void setProcedureType(String procedureType) {
		this.procedureType = procedureType;
	}

	@Column(name = "procedure_code", length = 18)
	public String getProcedureCode() {
		return this.procedureCode;
	}

	public void setProcedureCode(String procedureCode) {
		this.procedureCode = procedureCode;
	}

	@Column(name = "procedure_scope", nullable = false)
	public int getProcedureScope() {
		return this.procedureScope;
	}

	public void setProcedureScope(int procedureScope) {
		this.procedureScope = procedureScope;
	}

	@Column(name = "procedure_target", nullable = false)
	public int getProcedureTarget() {
		return this.procedureTarget;
	}

	public void setProcedureTarget(int procedureTarget) {
		this.procedureTarget = procedureTarget;
	}

	@Column(name = "personal", nullable = false, length = 0)
	public String getPersonal() {
		return this.personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	@Column(name = "diagnosis_1", nullable = false, length = 0)
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

	@Column(name = "complication", nullable = false, length = 0)
	public String getComplication() {
		return this.complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
	}

	@Column(name = "surgical", nullable = false, length = 0)
	public String getSurgical() {
		return this.surgical;
	}

	public void setSurgical(String surgical) {
		this.surgical = surgical;
	}

	@Column(name = "amount", precision = 10)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}