package co.com.tactusoft.medical.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.controller.bo.ParameterBo;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.model.entities.MedTopic;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;

@Named
@Scope("view")
public class CarouselBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AdminBo service;

	@Inject
	private ParameterBo parameterService;

	private List<MedTopic> list = new ArrayList<MedTopic>();
	private MedTopic selectedMenu;

	private String urlImages;

	public CarouselBacking() {
		list = new ArrayList<MedTopic>();
	}

	public List<MedTopic> getList() {
		if (list.size() == 0) {
			list = service.getListMedTopic();
		}
		return list;
	}

	public void setList(List<MedTopic> list) {
		this.list = list;
	}

	public MedTopic getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(MedTopic selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	public String getUrlImages() {
		if (urlImages == null) {
			urlImages = parameterService.getValueText("URL_IMAGES");
		}
		return urlImages;
	}

	public String generateQuestions() {
		List<MedQuestion> list = service.getListMedQuestionByTopic(selectedMenu
				.getId());

		ResponseQuestionBacking responseQuestionBacking = FacesUtil
				.findBean("responseQuestionBacking");

		if (list.size() > 0) {
			responseQuestionBacking.setList(list);
			responseQuestionBacking.setSelectedQuestion(list.get(0));
			responseQuestionBacking.setListAnswer(service
					.getListMedQuestionByQuestion(list.get(0).getId()));
		} else {
			MedQuestion defaultQuestion = new MedQuestion();
			defaultQuestion.setId(new BigDecimal(-1));
			defaultQuestion.setName("No existen preguntas!");
			defaultQuestion.setTypeQuestion(Constant.QUESTION_TYPE_MESSAGE);
			responseQuestionBacking.setSelectedQuestion(defaultQuestion);
		}

		return "/pages/view/responseQuestion?faces-redirect=true";
	}

}
