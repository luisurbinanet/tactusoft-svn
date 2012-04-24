package co.com.tactusoft.kpi.model.entities;

// Generated 27/02/2012 10:57:07 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * KpiUserRole generated by hbm2java
 */
@Entity
@Table(name = "kpi_user_role", catalog = "kpi_db")
public class KpiUserRole implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private KpiUser kpiUser;
	private KpiRole kpiRole;

	public KpiUserRole() {
	}

	public KpiUserRole(BigDecimal id, KpiUser kpiUser, KpiRole kpiRole) {
		this.id = id;
		this.kpiUser = kpiUser;
		this.kpiRole = kpiRole;
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
	@JoinColumn(name = "id_user", nullable = false)
	public KpiUser getKpiUser() {
		return this.kpiUser;
	}

	public void setKpiUser(KpiUser kpiUser) {
		this.kpiUser = kpiUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role", nullable = false)
	public KpiRole getKpiRole() {
		return this.kpiRole;
	}

	public void setKpiRole(KpiRole kpiRole) {
		this.kpiRole = kpiRole;
	}

}
