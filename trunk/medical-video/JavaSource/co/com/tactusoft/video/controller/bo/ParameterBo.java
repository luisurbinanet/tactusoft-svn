package co.com.tactusoft.video.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.video.model.dao.CustomHibernateDao;
import co.com.tactusoft.video.model.entities.MedParameter;

@Named
public class ParameterBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public String getValueText(String code) {
		return ((MedParameter) dao.find(
				"from MedParameter o where code = '" + code + "'").get(0))
				.getValueText();
	}

	public BigDecimal getValueNumber(String code) {
		return ((MedParameter) dao.find(
				"from MedParameter o where code = '" + code + "'").get(0))
				.getValueNumber();
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
