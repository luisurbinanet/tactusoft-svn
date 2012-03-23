package co.com.tactusoft.medical.view.backing;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.model.entities.MedAnswer;
import co.com.tactusoft.medical.model.entities.MedBody;
import co.com.tactusoft.medical.model.entities.MedBodyDetail;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.model.entities.MedTopic;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;
import co.com.tactusoft.medical.view.datamodel.BodyDataModel;
import co.com.tactusoft.medical.view.datamodel.BodyDetailDataModel;

@Named
@Scope("view")
public class BodyBacking {

	@Inject
	private AdminBo service;

	private List<MedBody> list;
	private MedBody selected;
	private BodyDataModel model;

	private List<MedBodyDetail> listDetail;
	private MedBodyDetail selectedDetail;
	private BodyDetailDataModel modelDetail;
	private MedBodyDetail[] selectedDetailArray;

	private List<MedTopic> listTopic;

	private String codeBodyPart;
	private String gender;
	private String idBodyPart;

	public BodyBacking() {
		model = null;
		selected = new MedBody();
		selectedDetail = new MedBodyDetail();
	}

	public void init() {
		list = service.getListMedBodyActive();
		model = new BodyDataModel(list);
	}

	public List<MedBody> getList() {
		return list;
	}

	public void setList(List<MedBody> list) {
		this.list = list;
	}

	public MedBody getSelected() {
		return selected;
	}

	public void setSelected(MedBody selected) {
		this.selected = selected;
	}

	public BodyDataModel getModel() {
		if (model == null) {
			list = service.getListMedBody();
			model = new BodyDataModel(list);
		}
		return model;
	}

	public List<MedBodyDetail> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<MedBodyDetail> listDetail) {
		this.listDetail = listDetail;
	}

	public void setModel(BodyDataModel model) {
		this.model = model;
	}

	public MedBodyDetail getSelectedDetail() {
		return selectedDetail;
	}

	public void setSelectedDetail(MedBodyDetail selectedDetail) {
		this.selectedDetail = selectedDetail;
	}

	public BodyDetailDataModel getModelDetail() {
		return modelDetail;
	}

	public void setModelDetail(BodyDetailDataModel modelDetail) {
		this.modelDetail = modelDetail;
	}

	public MedBodyDetail[] getSelectedDetailArray() {
		return selectedDetailArray;
	}

	public void setSelectedDetailArray(MedBodyDetail[] selectedDetailArray) {
		this.selectedDetailArray = selectedDetailArray;
	}

	public List<MedTopic> getListTopic() {
		if (listTopic == null) {
			listTopic = service.getListMedTopicActive();
		}
		return listTopic;
	}

	public void setListTopic(List<MedTopic> listTopic) {
		this.listTopic = listTopic;
	}

	public String getCodeBodyPart() {
		return codeBodyPart;
	}

	public void setCodeBodyPart(String codeBodyPart) {
		this.codeBodyPart = codeBodyPart;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdBodyPart() {
		return idBodyPart;
	}

	public void setIdBodyPart(String idBodyPart) {
		this.idBodyPart = idBodyPart;
	}

	public void newAction() {
		selected = new MedBody();
	}

	public void newDetailAction() {
		selectedDetail = new MedBodyDetail();
	}

	public void refreshAction() {

	}

	public void saveAction() {
		String message = null;

		if (selected.getId() == null) {
			selected.setId(service.getId("MedBody"));
			selected.setState(Constant.STATE_ACTIVE);
			message = FacesUtil.getMessage("msg_record_ok_3");
		} else {
			message = FacesUtil.getMessage("msg_record_ok_2");
		}

		service.save(selected);
		list = service.getListMedBody();
		model = new BodyDataModel(list);

		FacesUtil.addInfo(message);
	}

	public void saveDetailAction() {
		String message = null;

		if (selectedDetail.getId() == null) {
			selectedDetail.setId(service.getId("MedBodyDetail"));
			selectedDetail.setState(Constant.STATE_ACTIVE);
			selectedDetail.setMedBody(selected);
			message = FacesUtil.getMessage("msg_record_ok_3");
		} else {
			message = FacesUtil.getMessage("msg_record_ok_2");
		}

		if (selectedDetail.getResourceType().equals(
				Constant.RESOURCE_TYPE_TOPIC)) {
			selectedDetail.setUrlLink(null);
		} else {
			selectedDetail.setIdTopic(null);
		}

		service.save(selectedDetail);
		listDetail = service.getListMedBodyDetailByBody(selected.getId());
		modelDetail = new BodyDetailDataModel(listDetail);

		FacesUtil.addInfo(message);
	}

	public void onRowSelect(SelectEvent event) {
		BigDecimal idBody = ((MedBody) event.getObject()).getId();
		listDetail = service.getListMedBodyDetailByBody(idBody);
		modelDetail = new BodyDetailDataModel(listDetail);
	}

	public void generateLinksAction() {
		listDetail = service.getListMedBodyDetailByName(codeBodyPart, gender);
	}

	public String generateQuestionsAction() {
		BigDecimal id = new BigDecimal(idBodyPart);
		String topicName = null;

		for (MedBodyDetail row : listDetail) {
			if (row.getResourceType().equals(
					Constant.RESOURCE_TYPE_TOPIC)) {
				if (id.intValue() == row.getId().intValue()) {
					id = row.getIdTopic();
					break;
				}
			}
		}

		List<MedQuestion> list = service.getListMedQuestionByTopic(id);

		ResponseQuestionBacking responseQuestionBacking = FacesUtil
				.findBean("responseQuestionBacking");

		MedQuestion medQuestion = new MedQuestion();
		List<MedAnswer> listAnswer = new LinkedList<MedAnswer>();

		if (list.size() > 0) {
			medQuestion = list.get(0);
			listAnswer = service.getListMedQuestionByQuestion(medQuestion
					.getId());
			responseQuestionBacking.setList(list);
			topicName = medQuestion.getMedTopic().getName();
		} else {
			topicName = "Sin Información";
			medQuestion.setId(new BigDecimal(-1));
			medQuestion.setName(FacesUtil.getMessage("msg_no_questions"));
			medQuestion.setTypeQuestion(Constant.QUESTION_TYPE_MESSAGE);
		}

		responseQuestionBacking.init(topicName, medQuestion, list, listAnswer);

		return "/pages/view/responseQuestion?faces-redirect=true";
	}

}
