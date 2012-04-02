package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import co.com.tactusoft.video.model.entities.MedAnswer;
import co.com.tactusoft.video.model.entities.MedQuestion;

public class Combination implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private MedQuestion nextQuestion;
	private List<MedAnswer> listAnswers;

	public Combination() {

	}

	public Combination(BigDecimal id, MedQuestion nextQuestion,
			List<MedAnswer> listAnswers) {
		this.id = id;
		this.nextQuestion = nextQuestion;
		this.listAnswers = listAnswers;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public MedQuestion getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(MedQuestion nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public List<MedAnswer> getListAnswers() {
		return listAnswers;
	}

	public void setListAnswers(List<MedAnswer> listAnswers) {
		this.listAnswers = listAnswers;
	}

}
