package co.com.tactusoft.kpi.controller.bo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiUser;

@Service
public class SecurityBo {

	@Resource
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

}
