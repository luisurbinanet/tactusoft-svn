package co.com.tactusoft.kpi.model.entities;

// Generated 20/02/2012 11:10:42 AM by Hibernate Tools 3.4.0.CR1

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
 * KpiDelay generated by hbm2java
 */
@Entity
@Table(name = "kpi_delay", catalog = "kpi_db")
public class KpiDelay implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String name;
	private String description;
	private Integer korder;
	private int state;
	private Set<KpiDailyDelay> kpiDailyDelaies = new HashSet<KpiDailyDelay>(0);
	private Set<KpiHeaderDelay> kpiConfigs = new HashSet<KpiHeaderDelay>(0);

	public KpiDelay() {
	}

	public KpiDelay(BigDecimal id, String name, int state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}

	public KpiDelay(BigDecimal id, String name, String description,
			Integer korder, int state, Set<KpiDailyDelay> kpiDailyDelaies,
			Set<KpiHeaderDelay> kpiConfigs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.korder = korder;
		this.state = state;
		this.kpiDailyDelaies = kpiDailyDelaies;
		this.kpiConfigs = kpiConfigs;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "KORDER")
	public Integer getKorder() {
		return this.korder;
	}

	public void setKorder(Integer korder) {
		this.korder = korder;
	}

	@Column(name = "STATE", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kpiDelay")
	public Set<KpiDailyDelay> getKpiDailyDelaies() {
		return this.kpiDailyDelaies;
	}

	public void setKpiDailyDelaies(Set<KpiDailyDelay> kpiDailyDelaies) {
		this.kpiDailyDelaies = kpiDailyDelaies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kpiDelay")
	public Set<KpiHeaderDelay> getKpiConfigs() {
		return this.kpiConfigs;
	}

	public void setKpiConfigs(Set<KpiHeaderDelay> kpiConfigs) {
		this.kpiConfigs = kpiConfigs;
	}

}
