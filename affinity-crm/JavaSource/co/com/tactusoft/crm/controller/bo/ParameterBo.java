package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmParameter;

@Named
public class ParameterBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public String getTextValue(String param) {
		return ((CrmParameter) dao.find(
				"from CrmParameter o where o.code = '" + param + "'").get(0))
				.getTextValue();
	}

	public BigDecimal getNumberValue(String param) {
		return ((CrmParameter) dao.find(
				"from CrmParameter o where o.code = '" + param + "'").get(0))
				.getNumberValue();
	}

	public List<CrmParameter> getListParameter() {
		return dao.find("from CrmParameter o");
	}

	public List<CrmParameter> getListParameterByGroup(String byGroup) {
		return dao
				.find("from CrmParameter o where byGroup = '" + byGroup + "'");
	}

	public Integer saveParameter(CrmParameter entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmParameter.class));
		}
		return this.persist(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

	public int persist(Object entity) {
		int result = 0;
		try {
			result = dao.persist(entity);
		} catch (RuntimeException ex) {
			if (ex.getCause() instanceof ConstraintViolationException) {
				result = -1;
			} else if (ex.getCause() instanceof DataIntegrityViolationException) {
				result = -2;
			}
		}
		return result;
	}

}
