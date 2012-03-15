package co.com.tactusoft.medical.view.backing;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.model.entities.MedAnswer;
import co.com.tactusoft.medical.model.entities.MedCombination;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;

@Named
@Scope("session")
public class ResponseQuestionBacking {

	@Inject
	private AdminBo service;

	private List<MedQuestion> list;
	private MedQuestion selectedQuestion;
	private List<MedAnswer> listAnswer;
	private BigDecimal idAnswer;
	private BigDecimal[] idAnswers;

	public ResponseQuestionBacking() {

	}
	
	public void init(MedQuestion selectedQuestion, List<MedQuestion> list, List<MedAnswer> listAnswer){
		idAnswer = null;
		idAnswers = null;
		
		this.selectedQuestion = selectedQuestion;
		this.list = list;
		this.listAnswer =  listAnswer;
	}

	public List<MedQuestion> getList() {
		return list;
	}

	public void setList(List<MedQuestion> list) {
		this.list = list;
	}

	public MedQuestion getSelectedQuestion() {
		return selectedQuestion;
	}

	public void setSelectedQuestion(MedQuestion selectedQuestion) {
		this.selectedQuestion = selectedQuestion;
	}

	public List<MedAnswer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<MedAnswer> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public BigDecimal getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(BigDecimal idAnswer) {
		this.idAnswer = idAnswer;
	}

	public BigDecimal[] getIdAnswers() {
		return idAnswers;
	}

	public void setIdAnswers(BigDecimal[] idAnswers) {
		this.idAnswers = idAnswers;
	}

	public String actionSubmit() {
		String answer = FacesUtil.getParam("answer");
		if (answer.equals("SI")) {
			selectedQuestion = nextQuestion(selectedQuestion.getPositive());
		}

		if (answer.equals("NO")) {
			selectedQuestion = nextQuestion(selectedQuestion.getNegative());
		}

		if (answer.equals("UNIQUE")) {
			selectedQuestion = nextQuestion(this.idAnswer);
		}

		if (selectedQuestion.getTypeQuestion().equals(
				Constant.QUESTION_TYPE_MULTIPLE)) {
			String answers = "";
			for (BigDecimal id : idAnswers) {
				answers = answers + "+" + id;
			}

			List<MedCombination> listAnswers = service
					.getListMedCombinationByAnswers(selectedQuestion.getId(),
							answers);
			if (listAnswers.size() > 0) {
				selectedQuestion = listAnswers.get(0).getMedQuestionByNextQuestion();
			}
		}

		if (selectedQuestion.getTypeQuestion().equals(
				Constant.QUESTION_TYPE_UNIQUE)
				|| selectedQuestion.getTypeQuestion().equals(
						Constant.QUESTION_TYPE_MULTIPLE)) {
			listAnswer = service.getListMedQuestionByQuestion(selectedQuestion
					.getId());
			if (listAnswer.size() > 0) {
				this.idAnswer = listAnswer.get(0).getId();
			}
		}

		if (selectedQuestion == null) {
			selectedQuestion = new MedQuestion();
			selectedQuestion.setId(new BigDecimal(-1));
			String message = FacesUtil.getMessage("msg_final");
			selectedQuestion.setName(message);
			selectedQuestion.setTypeQuestion(Constant.QUESTION_TYPE_MESSAGE);
		}

		return "";
	}

	public String returnAction() {
		return "/pages/view/carousel?faces-redirect=true";
	}

	private MedQuestion nextQuestion(BigDecimal id) {
		for (MedQuestion row : list) {
			if (row.getId().intValue() == id.intValue()) {
				return row;
			}
		}
		return null;
	}

}
