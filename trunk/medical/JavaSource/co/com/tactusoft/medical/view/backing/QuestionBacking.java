package co.com.tactusoft.medical.view.backing;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.controller.bo.ParameterBo;
import co.com.tactusoft.medical.model.entities.MedAnswer;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;
import co.com.tactusoft.medical.view.datamodel.AnswerDataModel;
import co.com.tactusoft.medical.view.datamodel.QuestionDataModel;

@Named
@Scope("session")
public class QuestionBacking {

	@Inject
	private AdminBo service;

	@Inject
	private ParameterBo serviceParameter;

	private MedQuestion selected;
	private BigDecimal idTopic;

	private BigDecimal positiveQuestion;
	private BigDecimal negativeQuestion;

	private List<SelectItem> listQuestion;
	private Map<BigDecimal, MedQuestion> mapQuestion;

	private int orderQuestion;

	private String typeFinal;
	private UploadedFile file;
	private String urlImages;

	private List<MedAnswer> listAnswer;
	private MedAnswer[] selectedsAnswer;
	private List<MedAnswer> selectedDeletesAnswer;
	private String answerText;
	private AnswerDataModel modelAnswer;

	public QuestionBacking() {
	}

	public void init(MedQuestion selected) {
		idTopic = selected.getMedTopic().getId();

		List<MedQuestion> list = null;
		listQuestion = new LinkedList<SelectItem>();
		mapQuestion = new HashMap<BigDecimal, MedQuestion>();
		listAnswer = new LinkedList<MedAnswer>();
		modelAnswer = new AnswerDataModel(listAnswer);
		answerText = null;
		selectedDeletesAnswer = new LinkedList<MedAnswer>();

		listQuestion.add(new SelectItem(Constant.DEFAULT_VALUE,
				Constant.DEFAULT_LABEL));

		if (selected.getId() != null) {
			list = service.getListMedQuestionByNoIdQuestion(selected.getId(),
					idTopic);
		} else {
			list = service.getListMedQuestionByTopic(idTopic);
			if (list.size() > 0) {
				orderQuestion = list.get(list.size() - 1).getOrderQuestion() + 1;
			} else {
				orderQuestion = 1;
			}
			selected.setOrderQuestion(orderQuestion);
		}

		for (MedQuestion row : list) {
			String question = row.getName();
			if (question.length() > 60) {
				question = question.substring(0, 60) + "...";
			}
			listQuestion.add(new SelectItem(row.getId(), question));
			mapQuestion.put(row.getId(), row);
		}

		this.selected = selected;
		searchQuestionAction();
	}

	public MedQuestion getSelected() {
		return selected;
	}

	public void setSelected(MedQuestion selected) {
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

	public String getTypeFinal() {
		return typeFinal;
	}

	public void setTypeFinal(String typeFinal) {
		this.typeFinal = typeFinal;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getUrlImages() {
		if (urlImages == null) {
			urlImages = serviceParameter.getValueText("URL_IMAGES");
		}
		return urlImages;
	}

	public void setUrlImages(String urlImages) {
		this.urlImages = urlImages;
	}

	public List<MedAnswer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<MedAnswer> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public MedAnswer[] getSelectedsAnswer() {
		return selectedsAnswer;
	}

	public void setSelectedsAnswer(MedAnswer[] selectedsAnswer) {
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
			if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_ASSERTIVE)) {

			} else if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_UNIQUE)) {
				listAnswer = service.getListMedQuestionByQuestion(selected
						.getId());
				modelAnswer = new AnswerDataModel(listAnswer);
			} else if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_MULTIPLE)) {
			} else if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_FINAL)) {
			}
		} else {
			selected.setTypeQuestion(Constant.TYPE_QUESTION_MESSAGE);
			selected.setResourceType(Constant.RESOURCE_TYPE_IMAGEN);
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
				selected.setId(service.getId("MedQuestion"));
				newRecord = true;
			}

			if (selected.getTypeQuestion().equals(Constant.TYPE_QUESTION_FINAL)
					&& selected.getResourceType() != null) {
				if (selected.getResourceType().equals(
						Constant.RESOURCE_TYPE_IMAGEN)) {

					if (file == null && selected.getImage() == null) {
						field = FacesUtil.getMessage("que_type_final_image");
						message = FacesUtil.getMessage("msg_field_required",
								field);
					} else {
						String directory = serviceParameter
								.getValueText("DIRECTORY_IMAGES");
						String ext = "." + file.getContentType().split("/")[1];
						String fileName = "question" + selected.getId() + ext;
						FacesUtil.createFile(file.getInputstream(), directory
								+ fileName);
						selected.setImage(fileName);
					}

					selected.setUrlLink(null);
				} else {
					selected.setImage(null);
				}
			} else if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_UNIQUE)) {
				if (listAnswer.size() == 0) {
					message = FacesUtil
							.getMessage("que_msg_validate_nextquestion");
				} else {
					for (MedAnswer row : listAnswer) {
						if (row.getNextQuestion().intValue() == -1) {
							message = FacesUtil
									.getMessage("que_msg_validate_nextquestion");
							break;
						}
					}
				}
			}

			if (message == null) {
				service.save(selected);
				if (newRecord) {
					message = FacesUtil.getMessage("msg_record_ok_3");
				} else {
					message = FacesUtil.getMessage("msg_record_ok_2");
				}

				for (MedAnswer row : listAnswer) {
					if (row.getId() == null) {
						row.setId(service.getId("MedAnswer"));
					}
					service.save(row);
				}

				for (MedAnswer row : selectedDeletesAnswer) {
					service.remove(row);
				}

				FacesUtil.addInfo(message);

				TopicBacking topicBacking = FacesUtil.findBean("topicBacking");
				QuestionDataModel questionDataModel = new QuestionDataModel(
						service.getListMedQuestionByTopic(idTopic));
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

	public void handleFileUpload(FileUploadEvent event) {
		file = event.getFile();
	}

	public void addAnswerAction() {
		if (answerText.length() == 0) {
			String field = FacesUtil.getMessage("que_answer");
			String message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
		} else {
			MedAnswer selectedAnswer = new MedAnswer();
			selectedAnswer.setMedQuestion(selected);
			selectedAnswer.setName(answerText);
			selectedAnswer.setNextQuestion(Constant.DEFAULT_VALUE);
			listAnswer.add(selectedAnswer);
			modelAnswer = new AnswerDataModel(listAnswer);
			answerText = "";
		}
	}

	public void changeAnswerTypeAction() {
		if (selected.getTypeQuestion().equals(Constant.TYPE_QUESTION_ASSERTIVE)) {

		} else if (selected.getTypeQuestion().equals(
				Constant.TYPE_QUESTION_UNIQUE)) {
		} else if (selected.getTypeQuestion().equals(
				Constant.TYPE_QUESTION_MULTIPLE)) {
		} else if (selected.getTypeQuestion().equals(
				Constant.TYPE_QUESTION_FINAL)) {
		}
	}

	public void removeAnswerAction() {
		selectedDeletesAnswer = new LinkedList<MedAnswer>();
		for (MedAnswer row : selectedsAnswer) {
			listAnswer.remove(row);
			selectedDeletesAnswer.add(row);
		}
		modelAnswer = new AnswerDataModel(listAnswer);
	}

	public int getSize() {
		return listAnswer.size();
	}

}