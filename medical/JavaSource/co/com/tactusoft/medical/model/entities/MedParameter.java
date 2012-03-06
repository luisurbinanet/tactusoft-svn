package co.com.tactusoft.medical.model.entities;

// Generated 6/03/2012 02:44:14 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MedParameter generated by hbm2java
 */
@Entity
@Table(name = "med_parameter", catalog = "medical_db")
public class MedParameter implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String code;
	private String valueText;
	private BigDecimal valueNumber;

	public MedParameter() {
	}

	public MedParameter(BigDecimal id, String code) {
		this.id = id;
		this.code = code;
	}

	public MedParameter(BigDecimal id, String code, String valueText,
			BigDecimal valueNumber) {
		this.id = id;
		this.code = code;
		this.valueText = valueText;
		this.valueNumber = valueNumber;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "code", nullable = false, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "value_text", length = 45)
	public String getValueText() {
		return this.valueText;
	}

	public void setValueText(String valueText) {
		this.valueText = valueText;
	}

	@Column(name = "value_number")
	public BigDecimal getValueNumber() {
		return this.valueNumber;
	}

	public void setValueNumber(BigDecimal valueNumber) {
		this.valueNumber = valueNumber;
	}

}
