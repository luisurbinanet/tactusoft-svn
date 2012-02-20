package co.com.tactusoft.kpi.model.entities;

// Generated 19/02/2012 08:20:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * KpiWeek generated by hbm2java
 */
@Entity
@Table(name = "kpi_week", catalog = "kpi")
public class KpiWeek implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private int assignedOrders;
	private int state;
	private Set<KpiDaily> kpiDailies = new HashSet<KpiDaily>(0);

	public KpiWeek() {
	}

	public KpiWeek(BigDecimal id, Date startDate, Date endDate,
			int assignedOrders, int state) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assignedOrders = assignedOrders;
		this.state = state;
	}

	public KpiWeek(BigDecimal id, String name, String description,
			Date startDate, Date endDate, int assignedOrders, int state,
			Set<KpiDaily> kpiDailies) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assignedOrders = assignedOrders;
		this.state = state;
		this.kpiDailies = kpiDailies;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "name")
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", nullable = false, length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "assigned_orders", nullable = false)
	public int getAssignedOrders() {
		return this.assignedOrders;
	}

	public void setAssignedOrders(int assignedOrders) {
		this.assignedOrders = assignedOrders;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kpiWeek")
	public Set<KpiDaily> getKpiDailies() {
		return this.kpiDailies;
	}

	public void setKpiDailies(Set<KpiDaily> kpiDailies) {
		this.kpiDailies = kpiDailies;
	}

}