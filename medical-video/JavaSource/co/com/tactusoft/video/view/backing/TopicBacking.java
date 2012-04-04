package co.com.tactusoft.video.view.backing;

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

import co.com.tactusoft.video.controller.bo.AdminBo;
import co.com.tactusoft.video.controller.bo.ParameterBo;
import co.com.tactusoft.video.model.entities.VidQuestion;
import co.com.tactusoft.video.model.entities.VidTopic;
import co.com.tactusoft.video.util.Constant;
import co.com.tactusoft.video.util.FacesUtil;
import co.com.tactusoft.video.view.datamodel.QuestionDataModel;
import co.com.tactusoft.video.view.datamodel.TopicDataModel;

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
	private VidTopic selected;

	private QuestionDataModel modelQuestion;
	private VidQuestion selectedQuestion;
	private List<VidQuestion> listQuestion;
	private VidQuestion[] selectedQuestionArray;

	private UploadedFile file;
	private String urlImages;
	private boolean newFile;

	public TopicBacking() {
		selected = new VidTopic();
		selectedQuestion = new VidQuestion();
		model = null;
		urlImages = null;
		newFile = false;
	}

	public TopicDataModel getModel() {
		if (model == null) {
			model = new TopicDataModel(service.getListVidTopic());
		}
		return model;
	}

	public void setModel(TopicDataModel model) {
		this.model = model;
	}

	public VidTopic getSelected() {
		return selected;
	}

	public void setSelected(VidTopic selected) {
		if (selected == null) {
			selected = new VidTopic();
		}
		this.selected = selected;
	}

	public QuestionDataModel getModelQuestion() {
		return modelQuestion;
	}

	public void setModelQuestion(QuestionDataModel modelQuestion) {
		this.modelQuestion = modelQuestion;
	}

	public VidQuestion getSelectedQuestion() {
		return selectedQuestion;
	}

	public void setSelectedQuestion(VidQuestion selectedQuestion) {
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

	public VidQuestion[] getSelectedQuestionArray() {
		return selectedQuestionArray;
	}

	public void setSelectedQuestionArray(VidQuestion[] selectedQuestionArray) {
		this.selectedQuestionArray = selectedQuestionArray;
	}

	public String newAction() {
		selected = new VidTopic();
		return goTopicAction();
	}

	public void refreshAction() {
		model = new TopicDataModel(service.getListVidTopic());
	}

	public void deleteAction() {
		service.remove(selected);
		model = new TopicDataModel(service.getListVidTopic());
	}

	public void saveAction() throws IOException {
		String message = null;
		try {
			String field = null;
			boolean newRecord = false;
			RequestContext context = RequestContext.getCurrentInstance();

			if (selected.getId() == null) {
				selected.setId(service.getId("VidTopic"));
				selected.setState(Constant.STATE_ACTIVE);
				selected.setGender("A");
				newRecord = true;
			}

			if (file == null && selected.getImage() == null) {
				field = FacesUtil.getMessage("top_image");
				message = FacesUtil.getMessage("msg_field_required", field);
			} else {
				if (newFile) {
					String directory = serviceParameter
							.getValueText("DIRECTORY_IMAGES");
					String ext = FacesUtil.getExtensionFile(file.getFileName());
					String fileName = "topic_vid" + selected.getId() + ext;

					FacesUtil.createFile(file.getInputstream(), directory
							+ fileName);

					selected.setImage(fileName);
				}
			}

			if (message == null) {
				service.save(selected);
				if (newRecord) {
					message = FacesUtil.getMessage("msg_record_ok_3");
				} else {
					message = FacesUtil.getMessage("msg_record_ok_2");
				}
				model = new TopicDataModel(service.getListVidTopic());
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
		BigDecimal idTopic = ((VidTopic) event.getObject()).getId();
		listQuestion = service.getListVidQuestionByTopic(idTopic);
		modelQuestion = new QuestionDataModel(listQuestion);
		selectedQuestion = new VidQuestion();
	}

	public String goTopicAction() {
		newFile = false;
		return "/pages/admin/edit_topic?faces-redirect=true";
	}

	public String goQuestionAction() {
		QuestionBacking questionBacking = FacesUtil.findBean("questionBacking");
		String action = FacesUtil.getParam("action");
		if (action.equals("NEW")) {
			selectedQuestion = new VidQuestion();
		}
		selectedQuestion.setVidTopic(selected);
		questionBacking.init(selectedQuestion);
		return "/pages/admin/edit_video?faces-redirect=true";
	}

	public void removeDetailAction() {
		for (VidQuestion row : selectedQuestionArray) {
			service.remove(row);
			listQuestion = service.getListVidQuestionByTopic(selected.getId());
			modelQuestion = new QuestionDataModel(listQuestion);
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		newFile = true;
		file = event.getFile();
	}

}
