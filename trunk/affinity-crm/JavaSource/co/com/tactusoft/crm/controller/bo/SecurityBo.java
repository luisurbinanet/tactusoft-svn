package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmUser;

@Named
public class SecurityBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public CrmUser getObject(String userName) {
		CrmUser object = null;
		try {
			object = (CrmUser) dao.find(
					"from CrmUser o where o.username = '" + userName + "'").get(0);
		} catch (IndexOutOfBoundsException ex) {
			object = null;
		}
		return object;
	}

	public List<CrmRole> getListCrmRoleByUser(BigDecimal idUser) {
		return dao
				.find("select o.crmRole from CrmUserRole o where o.crmUser.id = "
						+ idUser);
	}
	
	public List<CrmRole> getListCrmRoleByUser(String username) {
		return dao
				.find("select o.crmRole from CrmUserRole o where o.crmUser.username = '"
						+ username + "'");
	}

	public List<CrmPage> getListCrmPageByRole(String idRoles) {
		return dao
				.find("select distinct o.crmPage from CrmPageRole o where o.crmRole.id in ("
						+ idRoles + ") order by o.crmPage.orderby");
	}

	public List<CrmUser> getListCrmUser() {
		return dao.find("from CrmUser o");
	}

	public List<CrmBranch> getListBranchByUser(BigDecimal idUser) {
		return dao
				.find("select o.crmBranch from CrmUserBranch o where o.crmUser.id = "
						+ idUser + " and o.crmBranch.society IN ('1000','3000')");
	}

	public List<CrmRole> getListCrmRole() {
		return dao.find("from CrmRole o where o.state = 1");
	}

	public void remove(Object entity) {
		dao.delete(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

}
