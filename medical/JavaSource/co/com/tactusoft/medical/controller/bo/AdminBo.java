package co.com.tactusoft.medical.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.medical.model.dao.CustomHibernateDao;
import co.com.tactusoft.medical.model.entities.MedAnswer;
import co.com.tactusoft.medical.model.entities.MedBody;
import co.com.tactusoft.medical.model.entities.MedCombination;
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

	public List<MedTopic> getListMedTopic(String gender) {
		return dao.find("from MedTopic o where o.gender in ('" + gender
				+ "','A')");
	}

	public List<MedQuestion> getListMedQuestionByTopic(BigDecimal idTopic) {
		return dao.find("from MedQuestion o where o.medTopic.id = " + idTopic
				+ " order by o.orderQuestion");
	}

	public List<MedQuestion> getListMedQuestionByNoIdQuestion(
			BigDecimal idQuestion, BigDecimal idTopic) {
		return dao.find("from MedQuestion o where o.id <> " + idQuestion
				+ " and o.medTopic = " + idTopic + " order by o.orderQuestion");
	}

	public MedQuestion getMedQuestionByQuestion(BigDecimal idQuestion) {
		MedQuestion result = new MedQuestion();
		try {
			result = (MedQuestion) dao.find(
					"from MedQuestion o where o.id = " + idQuestion).get(0);
		} catch (IndexOutOfBoundsException ex) {

		}
		return result;
	}

	public int getOrderMedQuestion(BigDecimal idTopic) {
		int order = 0;
		try {
			order = (Integer) dao.find(
					"select max(o.orderQuestion) + 1 from MedQuestion o where o.medTopic.id = "
							+ idTopic).get(0);
		} catch (Exception ex) {
			order = 1;
		}
		return order;
	}

	public List<MedAnswer> getListMedQuestionByQuestion(BigDecimal idQuestion) {
		return dao.find("from MedAnswer o where o.medQuestion.id = "
				+ idQuestion);
	}

	public List<MedCombination> getListMedCombinationByQuestion(
			BigDecimal idQuestion) {
		return dao
				.find("from MedCombination o where o.medQuestionByIdQuestion.id = "
						+ idQuestion);
	}

	public List<MedCombination> getListMedCombinationByAnswers(
			BigDecimal idQuestion, String answers) {
		return dao
				.find("from MedCombination o where o.medQuestionByIdQuestion.id = "
						+ idQuestion
						+ " and answers = '"
						+ answers
						+ "' order by id");
	}

	public List<MedBody> getListMedBody() {
		return dao.find("from MedBody o");
	}
	
	public List<MedBody> getListMedBodyActive() {
		return dao.find("from MedBody o where o.state = 1");
	}

	public List<MedBody> getListMedBodyDetailByBody(BigDecimal idBody) {
		return dao.find("from MedBodyDetail o where o.medBody.id = " + idBody
				+ " o.state = 1");
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
