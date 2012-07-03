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
import javax.persistence.UniqueConstraint;

/**
 * CrmOccupation generated by hbm2java
 */
@Entity
@Table(name = "crm_occupation", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CrmOccupation implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String name;
	private int state;
	private Set<CrmPatient> crmPatients = new HashSet<CrmPatient>(0);

	public CrmOccupation() {
	}

	public CrmOccupation(BigDecimal id, String name, int state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}

	public CrmOccupation(BigDecimal id, String name, int state,
			Set<CrmPatient> crmPatients) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.crmPatients = crmPatients;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmOccupation")
	public Set<CrmPatient> getCrmPatients() {
		return this.crmPatients;
	}

	public void setCrmPatients(Set<CrmPatient> crmPatients) {
		this.crmPatients = crmPatients;
	}

}
