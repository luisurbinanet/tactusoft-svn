package co.com.tactusoft.kpi.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kpi.kpi_group")
public class KpiGroup implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String name;
	private String description;
	public Boolean state;

	public KpiGroup() {

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

	@Column(name = "STATE", nullable = false)
	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (!(obj instanceof KpiGroup))
			return false;

		KpiGroup compare = (KpiGroup) obj;

		return compare.id.equals(this.id);
	}

	@Override
	public int hashCode() {
		int hash = 1;
		return hash * 31 + id.hashCode();
	}

}
