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
	private ParameterBo parameterService;

	@Inject
	private ParameterBo serviceParameter;

	private BigDecimal parentId;
	private MedQuestion selected;

	private BigDecimal positiveQuestion;
	private BigDecimal negativeQuestion;

	private List<SelectItem> listQuestion;
	private Map<BigDecimal, MedQuestion> mapQuestion;

	private int orderQuestion;

	private String typeFinal;
	private UploadedFile file;
	private String urlImages;
	
	private List<MedAnswer> listAnswer;
	private MedAnswer selectdAnswer;
	private String answerText;
	private AnswerDataModel modelAnswer;

	public QuestionBacking() {
		selected = new MedQuestion();
	}

	public void init(BigDecimal parentId, MedQuestion selected) {

		List<MedQuestion> list = null;
		listQuestion = new LinkedList<SelectItem>();
		mapQuestion = new HashMap<BigDecimal, MedQuestion>();
		listAnswer = new LinkedList<MedAnswer>();
		answerText = null;
		
		listQuestion.add(new SelectItem(Constant.DEFAULT_VALUE,
				Constant.DEFAULT_LABEL));

		if (selected.getId() != null) {
			list = service.getListMedQuestionByNoIdQuestion(selected.getId(),
					parentId);
		} else {
			list = service.getListMedQuestionByTopic(parentId);
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
		this.parentId = parentId;
		searchQuestionAction();
	}

	public BigDecimal getParentId() {
		return parentId;
	}

	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
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
			urlImages = parameterService.getValueText("URL_IMAGES");
		}
		return urlImages;
	}

	public void setUrlImages(String urlImages) {
		this.urlImages = urlImages;
	}

	public void searchQuestionAction() {
		if (selected.getId() != null) {
			if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_ASSERTIVE)) {

			} else if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_UNIQUE)) {

			} else if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_MULTIPLE)) {

			} else if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_FINAL)) {
			}
		} else {
			selected.setTypeQuestion(Constant.TYPE_QUESTION_MESSAGE);
			selected.setResourceType("IMAGE");
			selected.setPositive(Constant.DEFAULT_VALUE);
			selected.setNegative(Constant.DEFAULT_VALUE);
		}
	}
	

	public List<MedAnswer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<MedAnswer> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public MedAnswer getSelectdAnswer() {
		return selectdAnswer;
	}

	public void setSelectdAnswer(MedAnswer selectdAnswer) {
		this.selectdAnswer = selectdAnswer;
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

	public void saveAction() throws IOException {
		String field = null;
		String message = null;
		boolean newRecord = false;

		if (selected.getId() == null) {
			selected.setId(service.getId("MedQuestion"));
			newRecord = true;
		}

		if (selected.getTypeQuestion().equals(Constant.TYPE_QUESTION_FINAL)
				&& selected.getResourceType() != null) {
			if (selected.getResourceType()
					.equals(Constant.RESOURCE_TYPE_IMAGEN)) {

				if (file == null && selected.getImage() == null) {
					field = FacesUtil.getMessage("que_type_final_image");
					message = FacesUtil.getMessage("msg_field_required", field);
				} else {
					String directory = serviceParameter
							.getValueText("DIRECTORY_IMAGES");
					String ext = "." + file.getContentType().split("/")[1];
					String fileName = "question" + selected.getId() + ext;
					int result = FacesUtil.createFile(file.getInputstream(),
							directory + fileName);

					if (result == -1) {
						field = FacesUtil.getMessage("que_type_final_image");
						message = FacesUtil.getMessage("msg_field_required",
								field);
					} else {
						selected.setImage(fileName);
					}
				}

				selected.setUrlLink(null);
				selected.setUrlVideo(null);
			} else {
				selected.setImage(null);
			}
		}

		if (message == null) {
			service.save(selected);
			if (newRecord) {
				message = FacesUtil.getMessage("msg_record_ok_3");
			} else {
				message = FacesUtil.getMessage("msg_record_ok_2");
			}
			FacesUtil.addInfo(message);

			TopicBacking topicBacking = FacesUtil.findBean("topicBacking");
			QuestionDataModel questionDataModel = new QuestionDataModel(
					service.getListMedQuestionByTopic(parentId));
			topicBacking.setModelQuestion(questionDataModel);
		} else {
			FacesUtil.addWarn(message);
		}
	}

	public String goTopicAction() {
		return "/pages/admin/topic?faces-redirect=true";
	}

	public void handleFileUpload(FileUploadEvent event) {
		file = event.getFile();
	}

}