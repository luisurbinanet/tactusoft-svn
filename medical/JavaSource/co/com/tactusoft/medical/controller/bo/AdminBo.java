package co.com.tactusoft.medical.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.medical.model.dao.CustomHibernateDao;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.model.entities.MedTopic;

@Named
public class AdminBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<MedTopic> getListMedTopic() {
		return dao.find("from MedTopic o");
	}

	public List<MedQuestion> getListMedQuestionByTopic(BigDecimal idTopic) {
		return dao.find("from MedQuestion o where o.medTopic.id = " + idTopic
				+ " order by o.orderQuestion");
	}

	public MedQuestion getMedQuestionByTopic(BigDecimal idQuestion) {
		MedQuestion result = new MedQuestion();
		try {
			result = (MedQuestion) dao.find(
					"from MedQuestion o where o.id = " + idQuestion).get(0);
		} catch (IndexOutOfBoundsException ex) {

		}
		return result;
	}

	public int getOrderMedQuestion(BigDecimal idTopic) {
		return (Integer) dao.find(
				"select max(o.orderQuestion) + 1 from MedQuestion o where o.medTopic.id = "
						+ idTopic).get(0);
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
