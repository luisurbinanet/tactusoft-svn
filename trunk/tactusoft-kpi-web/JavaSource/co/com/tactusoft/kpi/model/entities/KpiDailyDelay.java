package co.com.tactusoft.kpi.model.entities;

// Generated 26/04/2012 09:35:42 AM by Hibernate Tools 3.4.0.CR1

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
 * KpiDailyDelay generated by hbm2java
 */
@Entity
@Table(name = "kpi_daily_delay", catalog = "kpi_db")
public class KpiDailyDelay implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private KpiDelay kpiDelay;
	private KpiDaily kpiDaily;
	private BigDecimal numHours;
	private Set<KpiDailyDelayWo> kpiDailyDelayWos = new HashSet<KpiDailyDelayWo>(
			0);

	public KpiDailyDelay() {
	}

	public KpiDailyDelay(BigDecimal id, KpiDelay kpiDelay, KpiDaily kpiDaily,
			BigDecimal numHours) {
		this.id = id;
		this.kpiDelay = kpiDelay;
		this.kpiDaily = kpiDaily;
		this.numHours = numHours;
	}

	public KpiDailyDelay(BigDecimal id, KpiDelay kpiDelay, KpiDaily kpiDaily,
			BigDecimal numHours, Set<KpiDailyDelayWo> kpiDailyDelayWos) {
		this.id = id;
		this.kpiDelay = kpiDelay;
		this.kpiDaily = kpiDaily;
		this.numHours = numHours;
		this.kpiDailyDelayWos = kpiDailyDelayWos;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_delay", nullable = false)
	public KpiDelay getKpiDelay() {
		return this.kpiDelay;
	}

	public void setKpiDelay(KpiDelay kpiDelay) {
		this.kpiDelay = kpiDelay;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_daily", nullable = false)
	public KpiDaily getKpiDaily() {
		return this.kpiDaily;
	}

	public void setKpiDaily(KpiDaily kpiDaily) {
		this.kpiDaily = kpiDaily;
	}

	@Column(name = "num_hours", nullable = false)
	public BigDecimal getNumHours() {
		return this.numHours;
	}

	public void setNumHours(BigDecimal numHours) {
		this.numHours = numHours;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kpiDailyDelay")
	public Set<KpiDailyDelayWo> getKpiDailyDelayWos() {
		return this.kpiDailyDelayWos;
	}

	public void setKpiDailyDelayWos(Set<KpiDailyDelayWo> kpiDailyDelayWos) {
		this.kpiDailyDelayWos = kpiDailyDelayWos;
	}

}
