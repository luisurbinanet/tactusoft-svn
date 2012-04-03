package co.com.tactusoft.video.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.video.controller.bo.AdminBo;
import co.com.tactusoft.video.model.entities.MedAnswer;
import co.com.tactusoft.video.model.entities.MedQuestion;
import co.com.tactusoft.video.model.entities.VidTopic;
import co.com.tactusoft.video.util.Constant;
import co.com.tactusoft.video.util.FacesUtil;

@Named
@Scope("view")
public class CarouselBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AdminBo service;

	private List<VidTopic> listWoman = new LinkedList<VidTopic>();
	private List<VidTopic> listMan = new LinkedList<VidTopic>();
	private VidTopic selectedMenu;

	private String urlImages;

	public CarouselBacking() {
		listWoman = new ArrayList<VidTopic>();
	}

	public List<VidTopic> getListWoman() {
		if (listWoman.size() == 0) {
			listWoman = service.getListVidTopic("W");
		}
		return listWoman;
	}

	public void setListWoman(List<VidTopic> listWoman) {
		this.listWoman = listWoman;
	}

	public List<VidTopic> getListMan() {
		if (listMan.size() == 0) {
			listMan = service.getListVidTopic("M");
		}
		return listMan;
	}

	public void setListMan(List<VidTopic> listMan) {
		this.listMan = listMan;
	}

	public VidTopic getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(VidTopic selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	public String getUrlImages() {
		ParameterBacking parameterBacking = FacesUtil
				.findBean("parameterBacking");
		urlImages = parameterBacking.getUrlImages();
		return urlImages;
	}

	public String generateQuestions() {
		List<MedQuestion> list = service.getListMedQuestionByTopic(selectedMenu
				.getId());

		ResponseQuestionBacking responseQuestionBacking = FacesUtil
				.findBean("responseQuestionBacking");

		MedQuestion medQuestion = new MedQuestion();
		List<MedAnswer> listAnswer = new LinkedList<MedAnswer>();

		if (list.size() > 0) {
			medQuestion = list.get(0);
			listAnswer = service.getListMedQuestionByQuestion(medQuestion
					.getId());
			responseQuestionBacking.setList(list);
		} else {
			medQuestion.setId(new BigDecimal(-1));
			medQuestion.setName("No existen preguntas!");
			medQuestion.setTypeQuestion(Constant.QUESTION_TYPE_MESSAGE);
		}

		responseQuestionBacking.init(medQuestion, list, listAnswer);

		return "/pages/view/responseQuestion?faces-redirect=true";
	}

}
