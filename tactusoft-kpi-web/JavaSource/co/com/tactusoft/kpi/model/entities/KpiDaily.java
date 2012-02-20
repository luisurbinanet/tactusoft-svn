package co.com.tactusoft.kpi.model.entities;

// Generated 19/02/2012 08:20:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * KpiDaily generated by hbm2java
 */
@Entity
@Table(name = "kpi_daily", catalog = "kpi")
public class KpiDaily implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private KpiWeek kpiWeek;
	private Date currentDay;
	private String description;
	private Integer scheduledOrders;
	private Integer finishedOrders;
	private Integer failuresOrders;
	private BigDecimal s;
	private BigDecimal ee;
	private BigDecimal dr;
	private BigDecimal ra;
	private BigDecimal fh;
	private BigDecimal ca;
	private BigDecimal lu;
	private BigDecimal tr;
	private BigDecimal fp;
	private BigDecimal cn;
	private BigDecimal fc;
	private BigDecimal rt;
	private int state;

	public KpiDaily() {
	}

	public KpiDaily(BigDecimal id, KpiWeek kpiWeek, Date currentDay, int state) {
		this.id = id;
		this.kpiWeek = kpiWeek;
		this.currentDay = currentDay;
		this.state = state;
	}

	public KpiDaily(BigDecimal id, KpiWeek kpiWeek, Date currentDay,
			String description, Integer scheduledOrders,
			Integer finishedOrders, Integer failuresOrders, BigDecimal s,
			BigDecimal ee, BigDecimal dr, BigDecimal ra, BigDecimal fh,
			BigDecimal ca, BigDecimal lu, BigDecimal tr, BigDecimal fp,
			BigDecimal cn, BigDecimal fc, BigDecimal rt, int state) {
		this.id = id;
		this.kpiWeek = kpiWeek;
		this.currentDay = currentDay;
		this.description = description;
		this.scheduledOrders = scheduledOrders;
		this.finishedOrders = finishedOrders;
		this.failuresOrders = failuresOrders;
		this.s = s;
		this.ee = ee;
		this.dr = dr;
		this.ra = ra;
		this.fh = fh;
		this.ca = ca;
		this.lu = lu;
		this.tr = tr;
		this.fp = fp;
		this.cn = cn;
		this.fc = fc;
		this.rt = rt;
		this.state = state;
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
	@JoinColumn(name = "id_week", nullable = false)
	public KpiWeek getKpiWeek() {
		return this.kpiWeek;
	}

	public void setKpiWeek(KpiWeek kpiWeek) {
		this.kpiWeek = kpiWeek;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "current_day", nullable = false, length = 19)
	public Date getCurrentDay() {
		return this.currentDay;
	}

	public void setCurrentDay(Date currentDay) {
		this.currentDay = currentDay;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "scheduled_orders")
	public Integer getScheduledOrders() {
		return this.scheduledOrders;
	}

	public void setScheduledOrders(Integer scheduledOrders) {
		this.scheduledOrders = scheduledOrders;
	}

	@Column(name = "finished_orders")
	public Integer getFinishedOrders() {
		return this.finishedOrders;
	}

	public void setFinishedOrders(Integer finishedOrders) {
		this.finishedOrders = finishedOrders;
	}

	@Column(name = "failures_orders")
	public Integer getFailuresOrders() {
		return this.failuresOrders;
	}

	public void setFailuresOrders(Integer failuresOrders) {
		this.failuresOrders = failuresOrders;
	}

	@Column(name = "s", precision = 5)
	public BigDecimal getS() {
		return this.s;
	}

	public void setS(BigDecimal s) {
		this.s = s;
	}

	@Column(name = "ee", precision = 5)
	public BigDecimal getEe() {
		return this.ee;
	}

	public void setEe(BigDecimal ee) {
		this.ee = ee;
	}

	@Column(name = "dr", precision = 5)
	public BigDecimal getDr() {
		return this.dr;
	}

	public void setDr(BigDecimal dr) {
		this.dr = dr;
	}

	@Column(name = "ra", precision = 5)
	public BigDecimal getRa() {
		return this.ra;
	}

	public void setRa(BigDecimal ra) {
		this.ra = ra;
	}

	@Column(name = "fh", precision = 5)
	public BigDecimal getFh() {
		return this.fh;
	}

	public void setFh(BigDecimal fh) {
		this.fh = fh;
	}

	@Column(name = "ca", precision = 5)
	public BigDecimal getCa() {
		return this.ca;
	}

	public void setCa(BigDecimal ca) {
		this.ca = ca;
	}

	@Column(name = "lu", precision = 5)
	public BigDecimal getLu() {
		return this.lu;
	}

	public void setLu(BigDecimal lu) {
		this.lu = lu;
	}

	@Column(name = "tr", precision = 5)
	public BigDecimal getTr() {
		return this.tr;
	}

	public void setTr(BigDecimal tr) {
		this.tr = tr;
	}

	@Column(name = "fp", precision = 5)
	public BigDecimal getFp() {
		return this.fp;
	}

	public void setFp(BigDecimal fp) {
		this.fp = fp;
	}

	@Column(name = "cn", precision = 5)
	public BigDecimal getCn() {
		return this.cn;
	}

	public void setCn(BigDecimal cn) {
		this.cn = cn;
	}

	@Column(name = "fc", precision = 5)
	public BigDecimal getFc() {
		return this.fc;
	}

	public void setFc(BigDecimal fc) {
		this.fc = fc;
	}

	@Column(name = "rt", precision = 5)
	public BigDecimal getRt() {
		return this.rt;
	}

	public void setRt(BigDecimal rt) {
		this.rt = rt;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
