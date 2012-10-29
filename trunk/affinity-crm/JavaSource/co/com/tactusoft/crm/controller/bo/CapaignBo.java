package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmCall;
import co.com.tactusoft.crm.model.entities.CrmGuideline;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmUser;

@Named
public class CapaignBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public CrmGuideline getGuideline(String phone) {
		List<CrmGuideline> list = dao
				.find("FROM CrmGuideline o WHERE o.phone = '" + phone + "'");
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

	public void saveCall(CrmCall entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmUser.class));
		}
		dao.persist(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

}
