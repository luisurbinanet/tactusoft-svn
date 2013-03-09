package co.com.tactusoft.sap.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VwAppointmentMedicationId generated by hbm2java
 */
@Embeddable
public class VwAppointmentMedicationId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String codMaterial;
	private String descMaterial;

	public VwAppointmentMedicationId() {
	}

	public VwAppointmentMedicationId(BigDecimal id, String codMaterial) {
		this.id = id;
		this.codMaterial = codMaterial;
	}

	@Column(name = "id", nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "cod_material", nullable = false)
	public String getCodMaterial() {
		return this.codMaterial;
	}

	public void setCodMaterial(String codMaterial) {
		this.codMaterial = codMaterial;
	}
	
	@Column(name = "desc_material", nullable = false, length = 1000)
	public String getDescMaterial() {
		return this.descMaterial;
	}

	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}
}