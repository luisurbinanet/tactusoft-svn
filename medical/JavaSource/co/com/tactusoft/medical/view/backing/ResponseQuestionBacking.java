package co.com.tactusoft.medical.view.backing;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;

@Named
@Scope("session")
public class ResponseQuestionBacking {

	private List<MedQuestion> list;
	private MedQuestion selectedQuestion;

	public ResponseQuestionBacking() {

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

	public String actionSubmit() {
		String answer = FacesUtil.getParam("answer");
		if (answer.equals("SI")) {
			selectedQuestion = nextQuestion(selectedQuestion.getPositive());
		}

		if (answer.equals("NO")) {
			selectedQuestion = nextQuestion(selectedQuestion.getNegative());
		}

		if (selectedQuestion == null) {
			selectedQuestion = new MedQuestion();
			selectedQuestion.setId(new BigDecimal(-1));
			selectedQuestion.setName("Final de la Encuesta");
			selectedQuestion.setTypeQuestion(Constant.TYPE_QUESTION_MESSAGE);
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
