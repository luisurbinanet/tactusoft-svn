package co.com.tactusoft.video.view.backing;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.video.controller.bo.AdminBo;
import co.com.tactusoft.video.model.entities.VidAnswer;
import co.com.tactusoft.video.model.entities.VidQuestion;
import co.com.tactusoft.video.util.Constant;
import co.com.tactusoft.video.util.FacesUtil;
import co.com.tactusoft.video.view.datamodel.AnswerDataModel;
import co.com.tactusoft.video.view.datamodel.QuestionDataModel;

@Named
@Scope("session")
public class QuestionBacking {

	@Inject
	private AdminBo service;

	private VidQuestion selected;
	private BigDecimal idTopic;

	private BigDecimal positiveQuestion;
	private BigDecimal negativeQuestion;

	private List<SelectItem> listQuestion;
	private Map<BigDecimal, VidQuestion> mapQuestion;

	private int orderQuestion;
	private Boolean newFileVideo;
	private Boolean newFileAudio;
	private UploadedFile fileVideo;
	private UploadedFile fileAudio;
	private String urlImages;

	private List<VidAnswer> listAnswer;
	private VidAnswer[] selectedsAnswer;
	private List<VidAnswer> selectedDeletesAnswer;
	private String answerText;
	private AnswerDataModel modelAnswer;

	public QuestionBacking() {
	}

	public void init(VidQuestion selected) {
		idTopic = selected.getVidTopic().getId();

		List<VidQuestion> list = null;
		listQuestion = new LinkedList<SelectItem>();
		mapQuestion = new HashMap<BigDecimal, VidQuestion>();
		listAnswer = new LinkedList<VidAnswer>();
		modelAnswer = new AnswerDataModel(listAnswer);
		answerText = null;
		selectedDeletesAnswer = new LinkedList<VidAnswer>();

		listQuestion.add(new SelectItem(Constant.DEFAULT_VALUE,
				Constant.DEFAULT_LABEL));

		if (selected.getId() != null) {
			list = service.getListVidQuestionByNoIdQuestion(selected.getId(),
					idTopic);
		} else {
			list = service.getListVidQuestionByTopic(idTopic);
			if (list.size() > 0) {
				orderQuestion = list.get(list.size() - 1).getOrderQuestion() + 1;
			} else {
				orderQuestion = 1;
			}
			selected.setOrderQuestion(orderQuestion);
		}

		for (VidQuestion row : list) {
			String question = row.getName();
			if (question.length() > 60) {
				question = question.substring(0, 60) + "...";
			}
			listQuestion.add(new SelectItem(row.getId(), question));
			mapQuestion.put(row.getId(), row);
		}

		this.selected = selected;
		this.newFileVideo = false;
		this.newFileAudio = false;
		searchQuestionAction();
	}

	public VidQuestion getSelected() {
		return selected;
	}

	public void setSelected(VidQuestion selected) {
		this.selected = selected;
	}

	public BigDecimal getPositiveQuestion() {
		return positiveQuestion;
	}

	public void setPositiveQuestion(BigDecimal positiveQuestion) {
		this.positiveQuestion = positiveQuestion;
	}

	public BigDecimal getNegativeQuestion() {
		return negativeQuestion;
	}

	public void setNegativeQuestion(BigDecimal negativeQuestion) {
		this.negativeQuestion = negativeQuestion;
	}

	public List<SelectItem> getListQuestion() {
		return listQuestion;
	}

	public void setListQuestion(List<SelectItem> listQuestion) {
		this.listQuestion = listQuestion;
	}

	public UploadedFile getFileVideo() {
		return fileVideo;
	}

	public void setFileVideo(UploadedFile fileVideo) {
		this.fileVideo = fileVideo;
	}

	public UploadedFile getFileAudio() {
		return fileAudio;
	}

	public void setFileAudio(UploadedFile fileAudio) {
		this.fileAudio = fileAudio;
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

	public List<VidAnswer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<VidAnswer> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public VidAnswer[] getSelectedsAnswer() {
		return selectedsAnswer;
	}

	public void setSelectedsAnswer(VidAnswer[] selectedsAnswer) {
		this.selectedsAnswer = selectedsAnswer;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public AnswerDataModel getModelAnswer() {
		return modelAnswer;
	}

	public void setModelAnswer(AnswerDataModel modelAnswer) {
		this.modelAnswer = modelAnswer;
	}

	public void searchQuestionAction() {
		if (selected.getId() != null) {
			if (selected.getQuestionType().equals(
					Constant.QUESTION_TYPE_ASSERTIVE)) {

			} else if (selected.getQuestionType().equals(
					Constant.QUESTION_TYPE_UNIQUE)) {
				listAnswer = service.getListVidQuestionByQuestion(selected
						.getId());
				modelAnswer = new AnswerDataModel(listAnswer);
			}
		} else {
			selected.setQuestionType(Constant.QUESTION_TYPE_ASSERTIVE);
			selected.setPositive(Constant.DEFAULT_VALUE);
			selected.setNegative(Constant.DEFAULT_VALUE);
		}
	}

	public void saveAction() {
		String message = null;
		try {
			String field = null;
			boolean newRecord = false;

			if (selected.getId() == null) {
				selected.setId(service.getId("VidQuestion"));
				newRecord = true;
			}

			if (selected.getQuestionType().equals(
					Constant.QUESTION_TYPE_ASSERTIVE)
					|| selected.getQuestionType().equals(
							Constant.QUESTION_TYPE_UNIQUE)) {

				if (selected.getQuestionType().equals(
						Constant.QUESTION_TYPE_UNIQUE)) {
					if (listAnswer.size() == 0) {
						message = FacesUtil
								.getMessage("que_msg_validate_nextquestion");
					} /*
					 * else { if (selected.getQuestionType().equals(
					 * Constant.QUESTION_TYPE_UNIQUE)) { for (VidAnswer row :
					 * listAnswer) { if (row.getNextQuestion().intValue() == -1)
					 * { message = FacesUtil
					 * .getMessage("que_msg_validate_nextquestion"); break; } }
					 * } }
					 */
				}

				try {

					if (newFileVideo) {
						ParameterBacking parameterBacking = FacesUtil
								.findBean("parameterBacking");
						String directory = parameterBacking.getDirectory();
						String ext = FacesUtil.getExtensionFile(fileVideo
								.getFileName());
						String fileName = "video" + selected.getId() + ext;
						FacesUtil.createFile(fileVideo.getInputstream(),
								directory + fileName);

						this.newFileVideo = false;

						Pattern patternWindows = Pattern
								.compile("([^\\s]+(\\.(?i)(asx|asf|avi|wma|wmv))$)");
						Pattern patternQuicktime = Pattern
								.compile("([^\\s]+(\\.(?i)(aif|aiff|aac|au|bmp|gsm|mov|mid|midi|mpg|mpeg|mp4|m4a|psd|qt|qtif|qif|qti|snd|tif|tiff|wav|3g2|3pg))$)");
						Pattern patternFlash = Pattern
								.compile("([^\\s]+(\\.(?i)(flv|mp3|swf))$)");
						Pattern patternReal = Pattern
								.compile("([^\\s]+(\\.(?i)(ra|ram|rm|rpm|rv|smi|smil))$)");

						this.selected.setVideo(fileName);

						if (patternWindows.matcher(fileName).matches()) {
							this.selected
									.setVideoType(Constant.VIDEO_TYPE_WINDOWS);
						} else if (patternQuicktime.matcher(fileName).matches()) {
							this.selected
									.setVideoType(Constant.VIDEO_TYPE_QUICKTIME);
						} else if (patternFlash.matcher(fileName).matches()) {
							this.selected
									.setVideoType(Constant.VIDEO_TYPE_FLASH);
						} else if (patternReal.matcher(fileName).matches()) {
							this.selected
									.setVideoType(Constant.VIDEO_TYPE_REAL);
						}
					}

					if (newFileAudio) {
						ParameterBacking parameterBacking = FacesUtil
								.findBean("parameterBacking");
						String directory = parameterBacking.getDirectory();
						String ext = FacesUtil.getExtensionFile(fileAudio
								.getFileName());
						String fileName = "audio" + selected.getId() + ext;
						FacesUtil.createFile(fileAudio.getInputstream(),
								directory + fileName);

						this.newFileAudio = false;

						Pattern patternWindows = Pattern
								.compile("([^\\s]+(\\.(?i)(asx|asf|avi|wma|wmv))$)");
						Pattern patternQuicktime = Pattern
								.compile("([^\\s]+(\\.(?i)(aif|aiff|aac|au|bmp|gsm|mov|mid|midi|mpg|mpeg|mp4|m4a|psd|qt|qtif|qif|qti|snd|tif|tiff|wav|3g2|3pg))$)");
						Pattern patternFlash = Pattern
								.compile("([^\\s]+(\\.(?i)(flv|mp3|swf))$)");
						Pattern patternReal = Pattern
								.compile("([^\\s]+(\\.(?i)(ra|ram|rm|rpm|rv|smi|smil))$)");

						this.selected.setAudio(fileName);

						if (patternWindows.matcher(fileName).matches()) {
							this.selected
									.setAudioType(Constant.VIDEO_TYPE_WINDOWS);
						} else if (patternQuicktime.matcher(fileName).matches()) {
							this.selected
									.setAudioType(Constant.VIDEO_TYPE_QUICKTIME);
						} else if (patternFlash.matcher(fileName).matches()) {
							this.selected
									.setAudioType(Constant.VIDEO_TYPE_FLASH);
						} else if (patternReal.matcher(fileName).matches()) {
							this.selected
									.setAudioType(Constant.VIDEO_TYPE_REAL);
						}
					}

				} catch (NullPointerException ex) {
					field = FacesUtil.getMessage("que_type_final_file");
					message = FacesUtil.getMessage("msg_field_required", field);
				}
			}

			if (message == null) {

				service.save(selected);

				if (newRecord) {
					message = FacesUtil.getMessage("msg_record_ok_3");
				} else {
					message = FacesUtil.getMessage("msg_record_ok_2");
				}

				if (!selected.getQuestionType().equals(
						Constant.QUESTION_TYPE_UNIQUE)
						&& !selected.getQuestionType().equals(
								Constant.QUESTION_TYPE_MULTIPLE)) {

					for (VidAnswer row : listAnswer) {
						service.remove(row);
					}

					listAnswer = new LinkedList<VidAnswer>();
					modelAnswer = new AnswerDataModel(listAnswer);
				} else {
					for (VidAnswer row : listAnswer) {
						if (row.getId() == null) {
							row.setId(service.getId("VidAnswer"));
						}
						service.save(row);
					}

					for (VidAnswer row : selectedDeletesAnswer) {
						service.remove(row);
					}
				}

				FacesUtil.addInfo(message);

				TopicBacking topicBacking = FacesUtil.findBean("topicBacking");
				QuestionDataModel questionDataModel = new QuestionDataModel(
						service.getListVidQuestionByTopic(idTopic));
				topicBacking.setModelQuestion(questionDataModel);
			} else {
				FacesUtil.addWarn(message);
			}
		} catch (IOException EX) {
			message = FacesUtil.getMessage("msg_file_error");
			FacesUtil.addError(message);
		}
	}

	public String goTopicAction() {
		return "/pages/admin/topic?faces-redirect=true";
	}

	public void addAnswerAction() {
		if (answerText.length() == 0) {
			String field = FacesUtil.getMessage("que_answer");
			String message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
		} else {
			VidAnswer selectedAnswer = new VidAnswer();
			selectedAnswer.setVidQuestion(selected);
			selectedAnswer.setName(answerText);
			selectedAnswer.setNextQuestion(Constant.DEFAULT_VALUE);
			listAnswer.add(selectedAnswer);
			modelAnswer = new AnswerDataModel(listAnswer);
			answerText = "";
		}
	}

	public void removeAnswerAction() {
		selectedDeletesAnswer = new LinkedList<VidAnswer>();
		for (VidAnswer row : selectedsAnswer) {
			listAnswer.remove(row);
			selectedDeletesAnswer.add(row);
		}
		modelAnswer = new AnswerDataModel(listAnswer);
	}

	public int getSize() {
		return listAnswer.size();
	}

	public void handleFileUploadVideo(FileUploadEvent event) {
		newFileVideo = true;
		fileVideo = event.getFile();
	}

	public void handleFileUploadAudio(FileUploadEvent event) {
		newFileAudio = true;
		fileAudio = event.getFile();
	}

}