package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmSpeciality;

@Named
public class ParameterBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public String getTextValue(String param) {
		return ((CrmParameter) dao.find(
				"CrmDoctor o where o.code = '" + param + "'").get(0))
				.getTextValue();
	}

	public BigDecimal getNumberValue(String param) {
		return ((CrmParameter) dao.find(
				"CrmDoctor o where o.code = '" + param + "'").get(0))
				.getNumberValue();
	}
	
	public List<CrmSpeciality> getListSpeciality() {
		return dao.find("from CrmSpeciality o");
	}

	public Integer saveParameter(CrmParameter entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmParameter.class));
		}
		return dao.persist(entity);
	}
	
	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

}
