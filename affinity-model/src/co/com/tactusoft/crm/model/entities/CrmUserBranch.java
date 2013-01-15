package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmUserBranch generated by hbm2java
 */
@Entity
@Table(name = "crm_user_branch", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_user", "id_branch" }))
public class CrmUserBranch implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmUser crmUser;
	private CrmBranch crmBranch;

	public CrmUserBranch() {
	}

	public CrmUserBranch(BigDecimal id) {
		this.id = id;
	}

	public CrmUserBranch(BigDecimal id, CrmUser crmUser, CrmBranch crmBranch) {
		this.id = id;
		this.crmUser = crmUser;
		this.crmBranch = crmBranch;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	public CrmUser getCrmUser() {
		return this.crmUser;
	}

	public void setCrmUser(CrmUser crmUser) {
		this.crmUser = crmUser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_branch")
	public CrmBranch getCrmBranch() {
		return this.crmBranch;
	}

	public void setCrmBranch(CrmBranch crmBranch) {
		this.crmBranch = crmBranch;
	}

}
