package co.com.tactusoft.crm.model.entities;

// Generated 19/04/2012 10:54:42 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmDoctor generated by hbm2java
 */
@Entity
@Table(name = "crm_doctor", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class CrmDoctor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmSpecialty crmSpecialty;
	private String code;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	private String gender;
	private Integer onSite;
	private Integer virtual;

	public CrmDoctor() {
	}

	public CrmDoctor(BigDecimal id, CrmSpecialty crmSpecialty, String code,
			String firstName, String firstSurname) {
		this.id = id;
		this.crmSpecialty = crmSpecialty;
		this.code = code;
		this.firstName = firstName;
		this.firstSurname = firstSurname;
	}

	public CrmDoctor(BigDecimal id, CrmSpecialty crmSpecialty, String code,
			String firstName, String secondName, String firstSurname,
			String secondSurname, String gender, Integer onSite, Integer virtual) {
		this.id = id;
		this.crmSpecialty = crmSpecialty;
		this.code = code;
		this.firstName = firstName;
		this.secondName = secondName;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.gender = gender;
		this.onSite = onSite;
		this.virtual = virtual;
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
	@JoinColumn(name = "id_specialty", nullable = false)
	public CrmSpecialty getCrmSpecialty() {
		return this.crmSpecialty;
	}

	public void setCrmSpecialty(CrmSpecialty crmSpecialty) {
		this.crmSpecialty = crmSpecialty;
	}

	@Column(name = "code", unique = true, nullable = false, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "first_name", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "second_name", length = 45)
	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Column(name = "first_surname", nullable = false, length = 45)
	public String getFirstSurname() {
		return this.firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	@Column(name = "second_surname", length = 45)
	public String getSecondSurname() {
		return this.secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	@Column(name = "gender", length = 1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "on_site")
	public Integer getOnSite() {
		return this.onSite;
	}

	public void setOnSite(Integer onSite) {
		this.onSite = onSite;
	}

	@Column(name = "virtual")
	public Integer getVirtual() {
		return this.virtual;
	}

	public void setVirtual(Integer virtual) {
		this.virtual = virtual;
	}

}
