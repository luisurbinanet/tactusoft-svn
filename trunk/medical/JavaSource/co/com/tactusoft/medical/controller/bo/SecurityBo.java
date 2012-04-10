package co.com.tactusoft.medical.controller.bo;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.medical.model.dao.CustomHibernateDao;
import co.com.tactusoft.medical.model.entities.MedRole;
import co.com.tactusoft.medical.model.entities.MedUser;

@Named
public class SecurityBo {

	@Inject
	private CustomHibernateDao dao;

	public MedUser getObject(String userName) {
		MedUser object = null;
		try {
			object = (MedUser) dao.find(
					"from MedUser o where o.username = '" + userName + "' and o.state = 1")
					.get(0);
		} catch (IndexOutOfBoundsException ex) {
			object = null;
		}
		return object;
	}

	
	
	public List<MedUser> getListMedUser() {
		return dao.find("from MedUser o");
	}
	
	public List<MedRole> getListMedRole() {
		return dao.find("from MedRole o where o.state = 1");
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
