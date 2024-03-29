package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmMaterialGroup generated by hbm2java
 */
@Entity
@Table(name = "crm_material_group", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id", "material_type" }))
public class CrmMaterialGroup implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String materialType;
	private String group;
	private BigDecimal idProcedureDetail;

	public CrmMaterialGroup() {
	}

	public CrmMaterialGroup(BigDecimal id, String materialType) {
		this.id = id;
		this.materialType = materialType;
	}

	public CrmMaterialGroup(BigDecimal id, String materialType, String group,
			BigDecimal idProcedureDetail) {
		this.id = id;
		this.materialType = materialType;
		this.group = group;
		this.idProcedureDetail = idProcedureDetail;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "material_type", nullable = false, length = 45)
	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	@Column(name = "group", length = 3)
	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Column(name = "id_procedure_detail", scale = 0)
	public BigDecimal getIdProcedureDetail() {
		return idProcedureDetail;
	}

	public void setIdProcedureDetail(BigDecimal idProcedureDetail) {
		this.idProcedureDetail = idProcedureDetail;
	}
}
