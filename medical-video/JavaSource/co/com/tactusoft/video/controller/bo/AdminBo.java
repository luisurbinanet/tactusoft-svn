package co.com.tactusoft.video.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.video.model.dao.CustomHibernateDao;
import co.com.tactusoft.video.model.entities.VidAnswer;
import co.com.tactusoft.video.model.entities.VidPackage;
import co.com.tactusoft.video.model.entities.VidPackageTopic;
import co.com.tactusoft.video.model.entities.VidQuestion;
import co.com.tactusoft.video.model.entities.VidTopic;
import co.com.tactusoft.video.model.entities.VidUserPackage;
import co.com.tactusoft.video.model.entities.VidUserTopic;

@Named
public class AdminBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<VidTopic> getListVidTopic() {
		return dao.find("from VidTopic o");
	}
	
	public List<VidTopic> getListVidTopicActive() {
		return dao.find("from VidTopic o where o.state = 1");
	}


	public List<VidQuestion> getListVidQuestionByTopic(BigDecimal idTopic) {
		return dao.find("from VidQuestion o where o.vidTopic.id = " + idTopic
				+ " order by o.orderQuestion");
	}

	public List<VidQuestion> getListVidQuestionByNoIdQuestion(
			BigDecimal idQuestion, BigDecimal idTopic) {
		return dao.find("from VidQuestion o where o.id <> " + idQuestion
				+ " and o.vidTopic = " + idTopic + " order by o.orderQuestion");
	}

	public VidQuestion getVidQuestionByQuestion(BigDecimal idQuestion) {
		VidQuestion result = new VidQuestion();
		try {
			result = (VidQuestion) dao.find(
					"from VidQuestion o where o.id = " + idQuestion).get(0);
		} catch (IndexOutOfBoundsException ex) {

		}
		return result;
	}

	public int getOrderVidQuestion(BigDecimal idTopic) {
		int order = 0;
		try {
			order = (Integer) dao.find(
					"select max(o.orderQuestion) + 1 from VidQuestion o where o.vidTopic.id = "
							+ idTopic).get(0);
		} catch (Exception ex) {
			order = 1;
		}
		return order;
	}

	public List<VidAnswer> getListVidQuestionByQuestion(BigDecimal idQuestion) {
		return dao.find("from VidAnswer o where o.vidQuestion.id = "
				+ idQuestion);
	}
	
	public List<VidPackage> getListVidPackage() {
		return dao.find("from VidPackage o");
	}
	
	public List<VidPackage> getListVidPackageActive() {
		return dao.find("from VidPackage o where o.state = 1");
	}
	
	public List<VidPackageTopic> getListVidPackageTopicByPackage(BigDecimal id) {
		return dao.find("from VidPackageTopic o where o.vidPackage.id = " + id);
	}
	
	public List<VidUserPackage> getListVidUserPackageByUser(BigDecimal id) {
		return dao.find("from VidUserPackage o where o.user.id = " + id);
	}
	
	public List<VidUserTopic> getListVidUserTopicByUser(BigDecimal id) {
		return dao.find("from VidUserTopic o where o.user.id = " + id);
	}
	
	public void save(Object entity) {
		dao.persist(entity);
	}

	public void remove(Object entity) {
		dao.delete(entity);
	}

	public BigDecimal getId(String clasz) {
		return dao.getId(clasz);
	}

}
