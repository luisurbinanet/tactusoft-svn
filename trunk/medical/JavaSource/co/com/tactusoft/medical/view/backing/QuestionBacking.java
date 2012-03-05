package co.com.tactusoft.medical.view.backing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
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

	private BigDecimal positiveQuestion;
	private BigDecimal negativeQuestion;

	private List<SelectItem> listQuestion;
	private Map<BigDecimal, MedQuestion> mapQuestion;

	public QuestionBacking() {
		selected = new MedQuestion();
	}

	public void init(BigDecimal parentId, MedQuestion selected) {
		int orderQuestion = service.getOrderMedQuestion(parentId);
		selected.setOrderQuestion(orderQuestion);
		this.selected = selected;
		this.parentId = parentId;
		searchQuestionAction();

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
		}
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

	public void saveAction() {
		String message = null;

		if (selected.getId() == null) {
			BigDecimal parentId2 = service.getId("MedQuestion");
			selected.setId(parentId2);
			selected.setIdParent(parentId);
			selected.setPositive(Constant.DEFAULT_VALUE);
			selected.setNegative(Constant.DEFAULT_VALUE);
		}

		service.save(selected);
		message = FacesUtil.getMessage("msg_record_ok", selected.getName());
		FacesUtil.addInfo(message);
	}

	public String goTopicAction() {
		return "/pages/admin/topic?faces-redirect=true";
	}

}