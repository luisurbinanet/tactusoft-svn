package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmSpecialty;

@Named
public class TablesBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<CrmDoctor> getListDoctor() {
		return dao.find(CrmDoctor.class);
	}

	public List<CrmSpecialty> getListSpecialityActive() {
		return dao.find("from CrmSpecialty o where o.state = 1");
	}

	public void saveDoctor(CrmDoctor entity) {
		entity.setId(getId(CrmDoctor.class));
		dao.persist(entity);
	}

	public <T> void remove(Class<T> entity) {
		dao.delete(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

}
