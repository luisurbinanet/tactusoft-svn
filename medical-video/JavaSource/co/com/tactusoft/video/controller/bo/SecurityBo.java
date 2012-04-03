package co.com.tactusoft.video.controller.bo;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.video.model.dao.CustomHibernateDao;
import co.com.tactusoft.video.model.entities.Role;
import co.com.tactusoft.video.model.entities.User;

@Named
public class SecurityBo {

	@Inject
	private CustomHibernateDao dao;

	public User getObject(String userName) {
		User object = null;
		try {
			object = (User) dao.find(
					"from User o where o.username = '" + userName + "' and o.state = 1")
					.get(0);
		} catch (IndexOutOfBoundsException ex) {
			object = null;
		}
		return object;
	}
	
	public List<User> getListMedUser() {
		return dao.find("from User o");
	}
	
	public List<Role> getListMedRole() {
		return dao.find("from Role o where o.state = 1");
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
