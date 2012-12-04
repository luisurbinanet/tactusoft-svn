package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmCall;
import co.com.tactusoft.crm.model.entities.CrmCallFinal;
import co.com.tactusoft.crm.model.entities.CrmGuideline;
import co.com.tactusoft.crm.model.entities.CrmPatient;

@Named
public class CapaignBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public CrmGuideline getGuideline(String campaignId) {
		List<CrmGuideline> list = dao
				.find("FROM CrmGuideline o WHERE o.phone = '" + campaignId
						+ "'");
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<CrmPatient> getListPatient(String phone) {
		return dao.find("FROM CrmPatient o WHERE o.phoneNumber = '" + phone
				+ "' OR o.cellNumber = '" + phone + "'");
	}

	public List<CrmCallFinal> getListCallFinal(String type) {
		return dao.find("from CrmCallFinal where typeCall = '" + type + "'");
	}

	public List<CrmCallFinal> getListCallFinalIncoming() {
		return getListCallFinal("INCOMING");
	}

	public List<CrmCallFinal> getListCallFinalOutcoming() {
		return getListCallFinal("OUTCOMING");
	}

	public CrmCall getListCallById(BigDecimal id) {
		return (CrmCall) dao.find("from CrmCall where idCall = " + id).get(0);
	}

	public int saveCall(CrmCall entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmCall.class));
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
