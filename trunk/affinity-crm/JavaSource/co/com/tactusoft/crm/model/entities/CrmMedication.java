package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CrmMedication generated by hbm2java
 */
@Entity
@Table(name = "crm_medication", catalog = "crm_db")
public class CrmMedication implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmAppointment crmAppointment;
	private CrmCie crmCie;
	private long codMaterial;
	private String descMaterial;
	private int unit;
	private String materialType;

	public CrmMedication() {
	}

	public CrmMedication(BigDecimal id, CrmAppointment crmAppointment,
			CrmCie crmCie, long codMaterial, String descMaterial, int unit,
			String materialType) {
		this.id = id;
		this.crmAppointment = crmAppointment;
		this.crmCie = crmCie;
		this.codMaterial = codMaterial;
		this.descMaterial = descMaterial;
		this.unit = unit;
		this.materialType = materialType;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appointment", nullable = false)
	public CrmAppointment getCrmAppointment() {
		return this.crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cie", nullable = false)
	public CrmCie getCrmCie() {
		return this.crmCie;
	}

	public void setCrmCie(CrmCie crmCie) {
		this.crmCie = crmCie;
	}

	@Column(name = "cod_material", nullable = false)
	public long getCodMaterial() {
		return this.codMaterial;
	}

	public void setCodMaterial(long codMaterial) {
		this.codMaterial = codMaterial;
	}

	@Column(name = "desc_material", nullable = false, length = 1000)
	public String getDescMaterial() {
		return this.descMaterial;
	}

	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}

	@Column(name = "unit", nullable = false)
	public int getUnit() {
		return this.unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	@Column(name = "material_type", nullable = false, length = 45)
	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

}