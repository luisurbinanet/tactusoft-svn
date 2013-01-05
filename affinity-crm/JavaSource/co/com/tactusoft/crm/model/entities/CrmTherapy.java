package co.com.tactusoft.crm.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CrmTherapy generated by hbm2java
 */
@Entity
@Table(name = "crm_therapy", catalog = "crm_db")
public class CrmTherapy implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String description;
	private int state;
	private int nurse;
	private int medical;

	public CrmTherapy() {
	}

	public CrmTherapy(String name, String description, int state, int nurse,
			int medical) {
		this.name = name;
		this.description = description;
		this.state = state;
		this.nurse = nurse;
		this.medical = medical;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false, length = 65535)
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

	@Column(name = "nurse", nullable = false)
	public int getNurse() {
		return this.nurse;
	}

	public void setNurse(int nurse) {
		this.nurse = nurse;
	}

	@Column(name = "medical", nullable = false)
	public int getMedical() {
		return this.medical;
	}

	public void setMedical(int medical) {
		this.medical = medical;
	}

}
