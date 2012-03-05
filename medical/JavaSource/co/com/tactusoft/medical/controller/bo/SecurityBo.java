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
					"from MedUser o where o.username = '" + userName + "'")
					.get(0);
		} catch (IndexOutOfBoundsException ex) {
			object = null;
		}
		return object;
	}

	public List<MedRole> getRoles(BigDecimal idUser) {
		List<MedRole> list = dao
				.find("select MedRole from MedUserRole o where o.MedUser.id = " + idUser);
		return list;
	}

}
