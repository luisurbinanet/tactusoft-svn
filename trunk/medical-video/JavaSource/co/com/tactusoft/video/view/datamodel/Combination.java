package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import co.com.tactusoft.video.model.entities.VidAnswer;
import co.com.tactusoft.video.model.entities.VidQuestion;

public class Combination implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private VidQuestion nextQuestion;
	private List<VidAnswer> listAnswers;

	public Combination() {

	}

	public Combination(BigDecimal id, VidQuestion nextQuestion,
			List<VidAnswer> listAnswers) {
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

	public VidQuestion getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(VidQuestion nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public List<VidAnswer> getListAnswers() {
		return listAnswers;
	}

	public void setListAnswers(List<VidAnswer> listAnswers) {
		this.listAnswers = listAnswers;
	}

}
