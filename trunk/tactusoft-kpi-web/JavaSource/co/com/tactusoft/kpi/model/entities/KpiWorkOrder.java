package co.com.tactusoft.kpi.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kpi.kpi_work_order")
public class KpiWorkOrder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigDecimal id;
	private String name;
	private String description;
	private Integer scheduledHours;
	public String state;

	public KpiWorkOrder() {

	}

	@Id
	@Column(name = "ID", precision = 0)
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "SCHEDULED_HOURS", nullable = false)
	public Integer getScheduledHours() {
		return scheduledHours;
	}

	public void setScheduledHours(Integer scheduledHours) {
		this.scheduledHours = scheduledHours;
	}
	
	@Column(name = "STATE", nullable = false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
