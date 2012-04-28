package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmRole generated by hbm2java
 */
@Entity
@Table(name = "crm_role", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CrmRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String name;
	private String description;
	private int state;
	private Set<CrmUserRole> crmUserRoles = new HashSet<CrmUserRole>(0);

	public CrmRole() {
	}

	public CrmRole(BigDecimal id, String name, int state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}

	public CrmRole(BigDecimal id, String name, String description, int state,
			Set<CrmUserRole> crmUserRoles) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.state = state;
		this.crmUserRoles = crmUserRoles;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmRole")
	public Set<CrmUserRole> getCrmUserRoles() {
		return this.crmUserRoles;
	}

	public void setCrmUserRoles(Set<CrmUserRole> crmUserRoles) {
		this.crmUserRoles = crmUserRoles;
	}

}
