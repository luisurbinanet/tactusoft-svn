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
import co.com.tactusoft.video.model.entities.VidAnswer;
import co.com.tactusoft.video.model.entities.VidQuestion;
import co.com.tactusoft.video.model.entities.VidTopic;
import co.com.tactusoft.video.util.Constant;
import co.com.tactusoft.video.util.FacesUtil;

@Named
@Scope("view")
public class VideoBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AdminBo service;

	private List<VidTopic> list = new LinkedList<VidTopic>();
	private VidTopic selectedMenu;

	private String urlImages;

	public VideoBacking() {
		list = new ArrayList<VidTopic>();
	}

	public List<VidTopic> getList() {
		if (list.size() == 0) {
			list = service.getListVidTopic();
		}
		return list;
	}

	public void setList(List<VidTopic> list) {
		this.list = list;
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
		List<VidQuestion> list = service.getListVidQuestionByTopic(selectedMenu
				.getId());

		ResponseQuestionBacking responseQuestionBacking = FacesUtil
				.findBean("responseQuestionBacking");

		VidQuestion medQuestion = new VidQuestion();
		List<VidAnswer> listAnswer = new LinkedList<VidAnswer>();

		if (list.size() > 0) {
			medQuestion = list.get(0);
			listAnswer = service.getListVidQuestionByQuestion(medQuestion
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
