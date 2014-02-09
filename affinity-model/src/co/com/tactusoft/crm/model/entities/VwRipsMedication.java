package co.com.tactusoft.crm.model.entities;

// Generated 24-abr-2013 14:52:22 by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VwRipsMedication generated by hbm2java
 */
@Entity
@Table(name = "vw_rips_medication", catalog = "crm_db")
public class VwRipsMedication implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private VwRipsMedicationId id;

	public VwRipsMedication() {
	}

	public VwRipsMedication(VwRipsMedicationId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idBranch", column = @Column(name = "id_branch", nullable = false, scale = 0)),
			@AttributeOverride(name = "appointmentDate", column = @Column(name = "appointment_date", length = 10)),
			@AttributeOverride(name = "idBill", column = @Column(name = "id_bill", nullable = false, length = 30)),
			@AttributeOverride(name = "clinic", column = @Column(name = "clinic", length = 45)),
			@AttributeOverride(name = "docType", column = @Column(name = "doc_type", length = 2)),
			@AttributeOverride(name = "doc", column = @Column(name = "doc", length = 30)),
			@AttributeOverride(name = "autorization", column = @Column(name = "autorization", nullable = false, length = 0)),
			@AttributeOverride(name = "medicationCode", column = @Column(name = "medication_code", length = 18)),
			@AttributeOverride(name = "medicationType", column = @Column(name = "medication_type", nullable = false, length = 0)),
			@AttributeOverride(name = "medicationName", column = @Column(name = "medication_name")),
			@AttributeOverride(name = "medicationForm", column = @Column(name = "medication_form", nullable = false, length = 0)),
			@AttributeOverride(name = "medicationConcentration", column = @Column(name = "medication_concentration", nullable = false, length = 0)),
			@AttributeOverride(name = "medicationSize", column = @Column(name = "medication_size", nullable = false, length = 0)),
			@AttributeOverride(name = "unit", column = @Column(name = "unit")),
			@AttributeOverride(name = "amount", column = @Column(name = "amount", precision = 10)),
			@AttributeOverride(name = "total", column = @Column(name = "total", precision = 20)) })
	public VwRipsMedicationId getId() {
		return this.id;
	}

	public void setId(VwRipsMedicationId id) {
		this.id = id;
	}

}