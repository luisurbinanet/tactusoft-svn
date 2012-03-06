package co.com.tactusoft.medical.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.StreamedContent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.model.entities.MedTopic;
import co.com.tactusoft.medical.util.FacesUtil;

@Named
@Scope("session")
public class CarouselBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AdminBo service;

	private List<MedTopic> list = new ArrayList<MedTopic>();
	private MedTopic selectedMenu;

	private Map<BigDecimal, StreamedContent> images;

	public CarouselBacking() {
		list = new ArrayList<MedTopic>();
	}

	public List<MedTopic> getList() {
		if (list.size() == 0) {
			list = service.getListMedTopic();
			images = new HashMap<BigDecimal, StreamedContent>();
			for (MedTopic row : list) {
				images.put(row.getId(), row.getCurrentImage());
			}
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

	public Map<BigDecimal, StreamedContent> getImages() {
		return images;
	}

	public void setImages(Map<BigDecimal, StreamedContent> images) {
		this.images = images;
	}

	public String generateQuestions() {
		List<MedQuestion> list = service.getListMedQuestionByTopic(selectedMenu
				.getId());
		
		ResponseQuestionBacking responseQuestionBacking = FacesUtil
				.findBean("responseQuestionBacking");

		responseQuestionBacking.setList(list);
		responseQuestionBacking.setSelectedQuestion(list.get(0));

		return "/pages/view/responseQuestion?faces-redirect=true";
	}

}
