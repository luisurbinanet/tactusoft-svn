package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VwTherapyMaterials generated by hbm2java
 */
@Entity
@Table(name = "vw_therapy_materials", catalog = "crm_db")
public class VwTherapyMaterials implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String descMaterial;
	private String sapMaterialType;
	private BigDecimal idPatient;

	public VwTherapyMaterials() {
	}

	public VwTherapyMaterials(Long id, 
			String descMaterial, BigDecimal idPatient) {
		this.id = id;
		this.descMaterial = descMaterial;
		this.idPatient = idPatient;
	}

	public VwTherapyMaterials(Long id, 
			String descMaterial, String sapMaterialType, BigDecimal idPatient) {
		this.id = id;
		this.descMaterial = descMaterial;
		this.sapMaterialType = sapMaterialType;
		this.idPatient = idPatient;
	}

	@Id
	@Column(name = "id", nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "desc_material", nullable = false, length = 1000)
	public String getDescMaterial() {
		return this.descMaterial;
	}

	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}

	@Column(name = "sap_material_type", length = 4)
	public String getSapMaterialType() {
		return this.sapMaterialType;
	}

	public void setSapMaterialType(String sapMaterialType) {
		this.sapMaterialType = sapMaterialType;
	}

	@Column(name = "id_patient", nullable = false, scale = 0)
	public BigDecimal getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(BigDecimal idPatient) {
		this.idPatient = idPatient;
	}

}
