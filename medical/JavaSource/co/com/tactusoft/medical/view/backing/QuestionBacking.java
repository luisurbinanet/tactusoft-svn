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
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;
import co.com.tactusoft.medical.view.datamodel.TopicDataModel;

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

	public QuestionBacking() {
		selected = new MedQuestion();
	}

	public void init(BigDecimal parentId, MedQuestion selected) {

		listQuestion = new LinkedList<SelectItem>();
		mapQuestion = new HashMap<BigDecimal, MedQuestion>();
		listQuestion.add(new SelectItem(Constant.DEFAULT_VALUE,
				Constant.DEFAULT_LABEL));

		if (selected.getId() != null) {
			for (MedQuestion row : service
					.getListMedQuestionByNoIdQuestion(selected.getId())) {
				String question = row.getName();
				if (question.length() > 60) {
					question = question.substring(0, 60) + "...";
				}
				listQuestion.add(new SelectItem(row.getId(), question));
				mapQuestion.put(row.getId(), row);
			}
		} else {
			orderQuestion = service.getOrderMedQuestion(parentId);
			selected.setOrderQuestion(orderQuestion);
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
			selected.setTypeQuestion(Constant.TYPE_QUESTION_ASSERTIVE);
		}
	}

	public void saveAction() throws IOException {
		String field = null;
		String message = null;

		if (selected.getId() == null) {
			BigDecimal parentId2 = service.getId("MedQuestion");
			selected.setId(parentId2);
			selected.setIdParent(parentId);
			selected.setPositive(Constant.DEFAULT_VALUE);
			selected.setNegative(Constant.DEFAULT_VALUE);
		}

		if (selected.getResourceType() != null) {
			if (selected.getResourceType()
					.equals(Constant.RESOURCE_TYPE_IMAGEN)) {

				if (file == null && selected.getImage() == null) {
					field = FacesUtil.getMessage("que_type_final_image");
					message = FacesUtil.getMessage("msg_field_required", field);
				} else {
					String directory = serviceParameter.getValueText("DIRECTORY_IMAGES");
					String ext = "." + file.getContentType().split("/")[1];
					String fileName = "question" + selected.getId() + ext;
					int result = FacesUtil.createFile(file.getInputstream(), directory + fileName);

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
			message = FacesUtil.getMessage("msg_record_ok_2");
			FacesUtil.addInfo(message);

			TopicBacking topicBacking = FacesUtil.findBean("topicBacking");
			TopicDataModel model = new TopicDataModel(service.getListMedTopic());
			topicBacking.setModel(model);
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