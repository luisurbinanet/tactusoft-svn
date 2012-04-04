package co.com.tactusoft.video.view.backing;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.video.controller.bo.AdminBo;
import co.com.tactusoft.video.model.entities.VidAnswer;
import co.com.tactusoft.video.model.entities.VidQuestion;
import co.com.tactusoft.video.util.Constant;
import co.com.tactusoft.video.util.FacesUtil;

@Named
@Scope("session")
public class ResponseQuestionBacking {

	@Inject
	private AdminBo service;

	private List<VidQuestion> list;
	private VidQuestion selectedQuestion;
	private List<VidAnswer> listAnswer;
	private BigDecimal idAnswer;
	private BigDecimal[] idAnswers;

	private String urlImages;

	public ResponseQuestionBacking() {

	}

	public void init(VidQuestion selectedQuestion, List<VidQuestion> list,
			List<VidAnswer> listAnswer) {
		idAnswer = null;
		idAnswers = null;

		this.selectedQuestion = selectedQuestion;
		this.list = list;
		this.listAnswer = listAnswer;
	}

	public List<VidQuestion> getList() {
		return list;
	}

	public void setList(List<VidQuestion> list) {
		this.list = list;
	}

	public VidQuestion getSelectedQuestion() {
		return selectedQuestion;
	}

	public void setSelectedQuestion(VidQuestion selectedQuestion) {
		this.selectedQuestion = selectedQuestion;
	}

	public List<VidAnswer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<VidAnswer> listAnswer) {
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

	public String getUrlImages() {
		ParameterBacking parameterBacking = FacesUtil
				.findBean("parameterBacking");
		urlImages = parameterBacking.getUrlImages();
		return urlImages;
	}

	public void setUrlImages(String urlImages) {
		this.urlImages = urlImages;
	}

	private VidQuestion nextQuestion(BigDecimal id) {
		for (VidQuestion row : list) {
			if (row.getId().intValue() == id.intValue()) {
				return row;
			}
		}
		return null;
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

		processAnswers();

		return "";
	}

	public String actionSubmitKeyS() {
		selectedQuestion = nextQuestion(selectedQuestion.getPositive());
		processAnswers();
		
		return "";
	}
	
	public String actionSubmitKeyN() {
		selectedQuestion = nextQuestion(selectedQuestion.getNegative());
		processAnswers();
		
		return "";
	}

	public void processAnswers() {
		if (selectedQuestion == null) {
			selectedQuestion = new VidQuestion();
			selectedQuestion.setId(new BigDecimal(-1));
			String message = FacesUtil.getMessage("msg_final");
			selectedQuestion.setName(message);
			selectedQuestion.setQuestionType(Constant.QUESTION_TYPE_MESSAGE);
		} else {
			if (selectedQuestion.getQuestionType().equals(
					Constant.QUESTION_TYPE_UNIQUE)
					|| selectedQuestion.getQuestionType().equals(
							Constant.QUESTION_TYPE_MULTIPLE)) {
				listAnswer = service
						.getListVidQuestionByQuestion(selectedQuestion.getId());
				if (listAnswer.size() > 0) {
					this.idAnswer = listAnswer.get(0).getId();
				}
			}
		}
	}

	public String returnAction() {
		return "/pages/view/video?faces-redirect=true";
	}

}
