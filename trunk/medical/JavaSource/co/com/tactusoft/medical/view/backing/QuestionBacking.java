package co.com.tactusoft.medical.view.backing;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;

@Named
@Scope("session")
public class QuestionBacking {

	@Inject
	private AdminBo service;

	private BigDecimal parentId;
	private MedQuestion selected;

	private String positiveQuestion;
	private String negativeQuestion;

	public QuestionBacking() {
		selected = new MedQuestion();
	}
	
	public void init(BigDecimal parentId, MedQuestion selected){
		int orderQuestion = service.getOrderMedQuestion(parentId);
		selected.setOrderQuestion(orderQuestion);
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

	public String getPositiveQuestion() {
		return positiveQuestion;
	}

	public void setPositiveQuestion(String positiveQuestion) {
		this.positiveQuestion = positiveQuestion;
	}

	public String getNegativeQuestion() {
		return negativeQuestion;
	}

	public void setNegativeQuestion(String negativeQuestion) {
		this.negativeQuestion = negativeQuestion;
	}

	public void searchQuestionAction() {
		if (selected.getId() != null) {
			if (selected.getTypeQuestion().equals(
					Constant.TYPE_QUESTION_ASSERTIVE)) {
				positiveQuestion = service.getMedQuestionByTopic(
						selected.getPositive()).getName();
				negativeQuestion = service.getMedQuestionByTopic(
						selected.getNegative()).getName();
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

	public String saveAction() {
		String message = null;

		if (selected.getId() == null) {
			BigDecimal parentId2 = service.getId("MedQuestion");
			selected.setId(parentId2);
			selected.setIdParent(parentId);
			service.save(selected);

			/*MedQuestion positive = new MedQuestion();
			BigDecimal positiveId = service.getId("MedQuestion");
			positive.setId(positiveId);
			positive.setName(positiveQuestion);
			positive.setMedTopic(selected.getMedTopic());
			positive.setIdParent(parentId2);
			orderQuestion = service.getOrderMedQuestion(parentId) + 1;
			positive.setOrderQuestion(orderQuestion);
			positive.setTypeQuestion(Constant.TYPE_QUESTION_FINAL);
			service.save(positive);

			MedQuestion negative = new MedQuestion();
			BigDecimal negativeId = service.getId("MedQuestion");
			negative.setId(negativeId);
			negative.setName(negativeQuestion);
			negative.setMedTopic(selected.getMedTopic());
			negative.setIdParent(parentId2);
			orderQuestion = service.getOrderMedQuestion(parentId) + 1;
			negative.setOrderQuestion(orderQuestion);
			negative.setTypeQuestion(Constant.TYPE_QUESTION_FINAL);
			service.save(negative);

			selected.setPositive(positiveId);
			selected.setNegative(negativeId);
			service.save(selected);*/

			message = FacesUtil.getMessage("msg_record_ok", selected.getName());
			FacesUtil.addInfo(message);
		} else {

		}

		return "/pages/admin/topic?faces-redirect=true";
	}
}