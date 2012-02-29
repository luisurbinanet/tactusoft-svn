package co.com.tactusoft.kpi.controller.bo;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiRole;
import co.com.tactusoft.kpi.model.entities.KpiUser;

@Named
public class SecurityBo {

	@Inject
	private CustomHibernateDao dao;

	public KpiUser getObject(String userName) {
		KpiUser object = null;
		try {
			object = (KpiUser) dao.find(
					"from KpiUser o where o.username = '" + userName + "'")
					.get(0);
		} catch (IndexOutOfBoundsException ex) {
			object = null;
		}
		return object;
	}

	public List<KpiRole> getRoles(BigDecimal idUser) {
		List<KpiRole> list = dao
				.find("select kpiRole from KpiUserRole o where o.kpiUser.id = " + idUser);
		return list;
	}

}
