package co.com.tactusoft.medical.model.entities;

// Generated 5/03/2012 10:17:04 AM by Hibernate Tools 3.4.0.CR1

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
 * MedRole generated by hbm2java
 */
@Entity
@Table(name = "med_role", catalog = "medical_db")
public class MedRole implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String name;
	private int state;
	private Set<MedUser> medUsers = new HashSet<MedUser>(0);

	public MedRole() {
	}

	public MedRole(BigDecimal id, String name, int state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}

	public MedRole(BigDecimal id, String name, int state, Set<MedUser> medUsers) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.medUsers = medUsers;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medRole")
	public Set<MedUser> getMedUsers() {
		return this.medUsers;
	}

	public void setMedUsers(Set<MedUser> medUsers) {
		this.medUsers = medUsers;
	}

}
