package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CrmSapMedication generated by hbm2java
 */
@Entity
@Table(name = "crm_sap_medication", catalog = "crm_db")
public class CrmSapMedication implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private CrmSapMedicationId id;
	private Date dateBill;
	private String typeBill;
	private String idPatient;
	private String docPatient;
	private String idMaterial;
	private String grpMaterial;
	private String positionType;
	private String nameMaterial;
	private Integer unit;
	private BigDecimal amount;
	private String idCanal;
	private BigDecimal idSalesOff;
	private String idInterlocutor;
	private String userSap;
	private BigDecimal idAppointment;
	private Integer idLog;
	private String status;

	public CrmSapMedication() {
	}

	public CrmSapMedication(CrmSapMedicationId id) {
		this.id = id;
	}

	public CrmSapMedication(CrmSapMedicationId id, Date dateBill,
			String typeBill, String idPatient, String docPatient,
			String idMaterial, String grpMaterial, String positionType,
			String nameMaterial, Integer unit, BigDecimal amount,
			String idCanal, BigDecimal idSalesOff, String idInterlocutor,
			String userSap, Integer idLog, String status) {
		this.id = id;
		this.dateBill = dateBill;
		this.typeBill = typeBill;
		this.idPatient = idPatient;
		this.docPatient = docPatient;
		this.idMaterial = idMaterial;
		this.grpMaterial = grpMaterial;
		this.positionType = positionType;
		this.nameMaterial = nameMaterial;
		this.unit = unit;
		this.amount = amount;
		this.idCanal = idCanal;
		this.idSalesOff = idSalesOff;
		this.idInterlocutor = idInterlocutor;
		this.userSap = userSap;
		this.idLog = idLog;
		this.status = status;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idBill", column = @Column(name = "id_bill", nullable = false, length = 30)),
			@AttributeOverride(name = "posBill", column = @Column(name = "pos_bill", nullable = false, length = 10)) })
	public CrmSapMedicationId getId() {
		return this.id;
	}

	public void setId(CrmSapMedicationId id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_bill", length = 19)
	public Date getDateBill() {
		return this.dateBill;
	}

	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}

	@Column(name = "type_bill", length = 4)
	public String getTypeBill() {
		return this.typeBill;
	}

	public void setTypeBill(String typeBill) {
		this.typeBill = typeBill;
	}

	@Column(name = "id_patient", length = 10)
	public String getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}

	@Column(name = "doc_patient", length = 30)
	public String getDocPatient() {
		return this.docPatient;
	}

	public void setDocPatient(String docPatient) {
		this.docPatient = docPatient;
	}

	@Column(name = "id_material", length = 18)
	public String getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(String idMaterial) {
		this.idMaterial = idMaterial;
	}

	@Column(name = "grp_material")
	public String getGrpMaterial() {
		return grpMaterial;
	}

	public void setGrpMaterial(String grpMaterial) {
		this.grpMaterial = grpMaterial;
	}

	@Column(name = "position_type")
	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	@Column(name = "name_material")
	public String getNameMaterial() {
		return this.nameMaterial;
	}

	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
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

	@Column(name = "id_canal", length = 2)
	public String getIdCanal() {
		return this.idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	@Column(name = "id_sales_off", scale = 0)
	public BigDecimal getIdSalesOff() {
		return this.idSalesOff;
	}

	public void setIdSalesOff(BigDecimal idSalesOff) {
		this.idSalesOff = idSalesOff;
	}

	@Column(name = "id_interlocutor", length = 8)
	public String getIdInterlocutor() {
		return this.idInterlocutor;
	}

	public void setIdInterlocutor(String idInterlocutor) {
		this.idInterlocutor = idInterlocutor;
	}

	@Column(name = "user_sap", length = 30)
	public String getUserSap() {
		return this.userSap;
	}

	public void setUserSap(String userSap) {
		this.userSap = userSap;
	}

	@Column(name = "id_appointment", scale = 0)
	public BigDecimal getIdAppointment() {
		return idAppointment;
	}

	public void setIdAppointment(BigDecimal idAppointment) {
		this.idAppointment = idAppointment;
	}

	@Column(name = "id_log", scale = 0)
	public Integer getIdLog() {
		return idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	@Column(name = "status", length = 30)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
