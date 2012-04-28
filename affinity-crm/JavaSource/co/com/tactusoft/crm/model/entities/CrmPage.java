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

/**
 * CrmPage generated by hbm2java
 */
@Entity
@Table(name = "crm_page", catalog = "crm_db")
public class CrmPage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String name;
	private String page;
	private BigDecimal parent;
	private int orderby;
	private Set<CrmPageRole> crmPageRoles = new HashSet<CrmPageRole>(0);

	public CrmPage() {
	}

	public CrmPage(BigDecimal id, String name, String page, int orderby) {
		this.id = id;
		this.name = name;
		this.page = page;
		this.orderby = orderby;
	}

	public CrmPage(BigDecimal id, String name, String page, BigDecimal parent,
			int orderby, Set<CrmPageRole> crmPageRoles) {
		this.id = id;
		this.name = name;
		this.page = page;
		this.parent = parent;
		this.orderby = orderby;
		this.crmPageRoles = crmPageRoles;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "page", nullable = false)
	public String getPage() {
		return this.page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Column(name = "parent", scale = 0)
	public BigDecimal getParent() {
		return this.parent;
	}

	public void setParent(BigDecimal parent) {
		this.parent = parent;
	}

	@Column(name = "orderby", nullable = false)
	public int getOrderby() {
		return this.orderby;
	}

	public void setOrderby(int orderby) {
		this.orderby = orderby;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmPage")
	public Set<CrmPageRole> getCrmPageRoles() {
		return this.crmPageRoles;
	}

	public void setCrmPageRoles(Set<CrmPageRole> crmPageRoles) {
		this.crmPageRoles = crmPageRoles;
	}

}
