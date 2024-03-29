package co.com.tactusoft.crm.model.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmRepSymptom generated by hbm2java
 */
@Entity
@Table(name = "crm_rep_symptom", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class CrmRepSymptom implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String code;
	private String description;
	private String chapter;
	private Short numMedication;
	private List<CrmRepMedication> crmRepMedications = new LinkedList<CrmRepMedication>();

	public CrmRepSymptom() {
	}

	public CrmRepSymptom(String code, String chapter) {
		this.code = code;
		this.chapter = chapter;
	}

	public CrmRepSymptom(String code, String description, String chapter,
			Short numMedication, List<CrmRepMedication> crmRepMedications) {
		this.code = code;
		this.description = description;
		this.chapter = chapter;
		this.numMedication = numMedication;
		this.crmRepMedications = crmRepMedications;
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

	@Column(name = "code", unique = true, nullable = false, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "chapter", nullable = false, length = 30)
	public String getChapter() {
		return this.chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	@Column(name = "num_medication")
	public Short getNumMedication() {
		return this.numMedication;
	}

	public void setNumMedication(Short numMedication) {
		this.numMedication = numMedication;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmRepSymptom")
	public List<CrmRepMedication> getCrmRepMedications() {
		return this.crmRepMedications;
	}

	public void setCrmRepMedications(List<CrmRepMedication> crmRepMedications) {
		this.crmRepMedications = crmRepMedications;
	}

}
