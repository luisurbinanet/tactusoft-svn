package co.com.tactusoft.medical.view.backing;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.controller.bo.ParameterBo;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.model.entities.MedTopic;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;
import co.com.tactusoft.medical.view.datamodel.QuestionDataModel;
import co.com.tactusoft.medical.view.datamodel.TopicDataModel;

@Named
@Scope("session")
public class TopicBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AdminBo service;

	@Inject
	private ParameterBo serviceParameter;

	@Inject
	private ParameterBo parameterService;

	private TopicDataModel model;
	private MedTopic selected;

	private QuestionDataModel modelQuestion;
	private MedQuestion selectedQuestion;
	private List<MedQuestion> listQuestion;
	private MedQuestion[] selectedQuestionArray;

	private UploadedFile file;
	private String urlImages;

	public TopicBacking() {
		selected = new MedTopic();
		selectedQuestion = new MedQuestion();
		model = null;
		urlImages = null;
	}

	public TopicDataModel getModel() {
		if (model == null) {
			model = new TopicDataModel(service.getListMedTopic());
		}
		return model;
	}

	public void setModel(TopicDataModel model) {
		this.model = model;
	}

	public MedTopic getSelected() {
		return selected;
	}

	public void setSelected(MedTopic selected) {
		if (selected == null) {
			selected = new MedTopic();
		}
		this.selected = selected;
	}

	public QuestionDataModel getModelQuestion() {
		return modelQuestion;
	}

	public void setModelQuestion(QuestionDataModel modelQuestion) {
		this.modelQuestion = modelQuestion;
	}

	public MedQuestion getSelectedQuestion() {
		return selectedQuestion;
	}

	public void setSelectedQuestion(MedQuestion selectedQuestion) {
		this.selectedQuestion = selectedQuestion;
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

	public MedQuestion[] getSelectedQuestionArray() {
		return selectedQuestionArray;
	}

	public void setSelectedQuestionArray(MedQuestion[] selectedQuestionArray) {
		this.selectedQuestionArray = selectedQuestionArray;
	}

	public String newAction() {
		selected = new MedTopic();
		return goTopicAction();
	}

	public void refreshAction() {
		model = new TopicDataModel(service.getListMedTopic());
	}

	public void deleteAction() {
		service.remove(selected);
		model = new TopicDataModel(service.getListMedTopic());
	}

	public void saveAction() throws IOException {
		String message = null;
		try {
			String field = null;
			boolean newRecord = false;
			RequestContext context = RequestContext.getCurrentInstance();

			if (selected.getId() == null) {
				selected.setId(service.getId("MedTopic"));
				selected.setState(Constant.STATE_ACTIVE);
				selected.setNumVersion(1);
				newRecord = true;
			}

			if (file == null && selected.getImage() == null) {
				field = FacesUtil.getMessage("top_image");
				message = FacesUtil.getMessage("msg_field_required", field);
			} else {
				String directory = serviceParameter
						.getValueText("DIRECTORY_IMAGES");
				String ext = "." + file.getContentType().split("/")[1];
				String fileName = "topic" + selected.getId() + ext;

				FacesUtil.createFile(file.getInputstream(), directory
						+ fileName);

				selected.setImage(fileName);
			}

			if (message == null) {
				service.save(selected);
				if (newRecord) {
					message = FacesUtil.getMessage("msg_record_ok_3");
				} else {
					message = FacesUtil.getMessage("msg_record_ok_2");
				}
				model = new TopicDataModel(service.getListMedTopic());
				FacesUtil.addInfo(message);
				context.addCallbackParam("saved", "true");
			} else {
				FacesUtil.addWarn(message);
				context.addCallbackParam("saved", "false");
			}
		} catch (IOException EX) {
			message = FacesUtil.getMessage("msg_file_error");
			FacesUtil.addError(message);
		}

	}

	public void onRowSelect(SelectEvent event) {
		BigDecimal idTopic = ((MedTopic) event.getObject()).getId();
		listQuestion = service.getListMedQuestionByTopic(idTopic);
		modelQuestion = new QuestionDataModel(listQuestion);
		selectedQuestion = new MedQuestion();
	}

	public String goTopicAction() {
		return "/pages/admin/edit_topic?faces-redirect=true";
	}

	public String goQuestionAction() {
		QuestionBacking questionBacking = FacesUtil.findBean("questionBacking");
		String action = FacesUtil.getParam("action");
		if (action.equals("NEW")) {
			selectedQuestion = new MedQuestion();
		}
		selectedQuestion.setMedTopic(selected);
		questionBacking.init(selectedQuestion);
		return "/pages/admin/question?faces-redirect=true";
	}

	public void removeDetailAction() {
		for (MedQuestion row : selectedQuestionArray) {
			service.remove(row);
			listQuestion = service.getListMedQuestionByTopic(selected.getId());
			modelQuestion = new QuestionDataModel(listQuestion);
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		file = event.getFile();
	}

}
