package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmCallFinal generated by hbm2java
 */
@Entity
@Table(name = "crm_call_final", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class CrmCallFinal implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String code;
	private String description;
	private String typeCall;

	public CrmCallFinal() {
	}

	public CrmCallFinal(BigDecimal id) {
		this.id = id;
	}

	public CrmCallFinal(BigDecimal id, String code, String description,
			String typeCall) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.typeCall = typeCall;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "code", unique = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "type_call")
	public String getTypeCall() {
		return typeCall;
	}

	public void setTypeCall(String typeCall) {
		this.typeCall = typeCall;
	}

}