package co.com.tactusoft.video.model.entities;

// Generated 5/04/2012 10:45:54 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VidAnswer generated by hbm2java
 */
@Entity
@Table(name = "vid_answer", catalog = "medical_video_db")
public class VidAnswer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private VidQuestion vidQuestion;
	private String name;
	private BigDecimal nextQuestion;
	private String enterKey;
	private BigDecimal byTime;

	public VidAnswer() {
	}

	public VidAnswer(BigDecimal id, VidQuestion vidQuestion, String name) {
		this.id = id;
		this.vidQuestion = vidQuestion;
		this.name = name;
	}

	public VidAnswer(BigDecimal id, VidQuestion vidQuestion, String name,
			BigDecimal nextQuestion, String enterKey, BigDecimal byTime) {
		this.id = id;
		this.vidQuestion = vidQuestion;
		this.name = name;
		this.nextQuestion = nextQuestion;
		this.enterKey = enterKey;
		this.byTime = byTime;
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
	@JoinColumn(name = "id_question", nullable = false)
	public VidQuestion getVidQuestion() {
		return this.vidQuestion;
	}

	public void setVidQuestion(VidQuestion vidQuestion) {
		this.vidQuestion = vidQuestion;
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

	@Column(name = "enter_key", length = 15)
	public String getEnterKey() {
		return this.enterKey;
	}

	public void setEnterKey(String enterKey) {
		this.enterKey = enterKey;
	}

	@Column(name = "by_time", precision = 6, scale = 3)
	public BigDecimal getByTime() {
		return this.byTime;
	}

	public void setByTime(BigDecimal byTime) {
		this.byTime = byTime;
	}

}