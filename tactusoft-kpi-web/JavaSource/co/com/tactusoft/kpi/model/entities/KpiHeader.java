package co.com.tactusoft.kpi.model.entities;

// Generated 20/02/2012 11:10:42 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * KpiHeader generated by hbm2java
 */
@Entity
@Table(name = "kpi_header", catalog = "kpi")
public class KpiHeader implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private KpiCompany kpiCompany;
	private String name;
	private String description;
	private int state;
	private Set<KpiConfig> kpiConfigs = new HashSet<KpiConfig>(0);

	public KpiHeader() {
	}

	public KpiHeader(BigDecimal id, KpiCompany kpiCompany, String name,
			int state) {
		this.id = id;
		this.kpiCompany = kpiCompany;
		this.name = name;
		this.state = state;
	}

	public KpiHeader(BigDecimal id, KpiCompany kpiCompany, String name,
			String description, int state, Set<KpiConfig> kpiConfigs) {
		this.id = id;
		this.kpiCompany = kpiCompany;
		this.name = name;
		this.description = description;
		this.state = state;
		this.kpiConfigs = kpiConfigs;
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
	@JoinColumn(name = "id_company", nullable = false)
	public KpiCompany getKpiCompany() {
		return this.kpiCompany;
	}

	public void setKpiCompany(KpiCompany kpiCompany) {
		this.kpiCompany = kpiCompany;
	}

	@Column(name = "name", nullable = false)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kpiHeader")
	public Set<KpiConfig> getKpiConfigs() {
		return this.kpiConfigs;
	}

	public void setKpiConfigs(Set<KpiConfig> kpiConfigs) {
		this.kpiConfigs = kpiConfigs;
	}

}
