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

	private String cuePoints;
	private String urlVideo;

	private String enterKey;

	public ResponseQuestionBacking() {

	}

	public void init(VidQuestion selectedQuestion, List<VidQuestion> list,
			List<VidAnswer> listAnswer) {
		idAnswer = null;
		idAnswers = null;

		this.selectedQuestion = selectedQuestion;
		this.list = list;
		this.listAnswer = listAnswer;
		this.urlVideo = selectedQuestion.getUrlVideo();

		this.generateCuetimes();
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

	public void setCuePoints(String cuePoints) {
		this.cuePoints = cuePoints;
	}

	public String getCuePoints() {
		return this.cuePoints;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getEnterKey() {
		return enterKey;
	}

	public void setEnterKey(String enterKey) {
		this.enterKey = enterKey;
	}

	private VidQuestion nextQuestion(BigDecimal id) {
		for (VidQuestion row : list) {
			if (row.getId().intValue() == id.intValue()) {
				return row;
			}
		}
		return null;
	}

	public void generateCuetimes() {
		if (selectedQuestion.getQuestionType().equals(
				Constant.QUESTION_TYPE_TIME)) {
			cuePoints = String.valueOf(selectedQuestion.getByTime()
					.doubleValue() * 1000);
		} else {
			cuePoints = "9999999999";
		}
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

	public String actionSubmitKeyAssertive() {

		if (this.enterKey.toUpperCase().equals("S")) {
			selectedQuestion = nextQuestion(selectedQuestion.getPositive());
		} else {
			selectedQuestion = nextQuestion(selectedQuestion.getNegative());
		}
		processAnswers();

		return "";
	}

	public String actionSubmitKeyUnique() {

		for (VidAnswer row : listAnswer) {
			if (row.getEnterKey().toUpperCase()
					.equals(this.enterKey.toUpperCase())) {
				selectedQuestion = nextQuestion(row.getNextQuestion());
				break;
			}
		}

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
			this.generateCuetimes();
			if (selectedQuestion.getQuestionType().equals(
					Constant.QUESTION_TYPE_UNIQUE)) {
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

	public void onCuepoint() {
		selectedQuestion = nextQuestion(selectedQuestion.getNextQuestion());
	}

}
