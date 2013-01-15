package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "crm_domain", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = {
		"code", "group" }))
public class CrmDomain implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String code;
	private String itemValue;
	private String group;

	public CrmDomain() {
	}

	public CrmDomain(BigDecimal id) {
		this.id = id;
	}

	public CrmDomain(BigDecimal id, String code, String itemValue, String group) {
		this.id = id;
		this.code = code;
		this.itemValue = itemValue;
		this.group = group;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "code", unique = true, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "item_value")
	public String getItemValue() {
		return this.itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	@Column(name = "group", length = 45)
	public String getGroup() {
		return this.group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
