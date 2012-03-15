package co.com.tactusoft.medical.model.entities;

// Generated 7/03/2012 10:49:44 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MedAnswer generated by hbm2java
 */
@Entity
@Table(name = "med_answer", catalog = "medical_db")
public class MedAnswer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private MedQuestion medQuestion;
	private String name;
	private BigDecimal nextQuestion;
	private Set<MedCombination> medCombinations = new HashSet<MedCombination>(0);

	public MedAnswer() {
	}

	public MedAnswer(BigDecimal id, MedQuestion medQuestion, String name) {
		this.id = id;
		this.medQuestion = medQuestion;
		this.name = name;
	}

	public MedAnswer(BigDecimal id, MedQuestion medQuestion, String name,
			BigDecimal nextQuestion, Set<MedCombination> medCombinations) {
		this.id = id;
		this.medQuestion = medQuestion;
		this.name = name;
		this.nextQuestion = nextQuestion;
		this.medCombinations = medCombinations;
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
	@JoinColumn(name = "id_question", nullable = false)
	public MedQuestion getMedQuestion() {
		return this.medQuestion;
	}

	public void setMedQuestion(MedQuestion medQuestion) {
		this.medQuestion = medQuestion;
	}

	@Column(name = "name", nullable = false, length = 65535)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "next_question", scale = 0)
	public BigDecimal getNextQuestion() {
		return this.nextQuestion;
	}

	public void setNextQuestion(BigDecimal nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medAnswer", cascade = { CascadeType.REMOVE })
	public Set<MedCombination> getMedCombinations() {
		return this.medCombinations;
	}

	public void setMedCombinations(Set<MedCombination> medCombinations) {
		this.medCombinations = medCombinations;
	}

}
