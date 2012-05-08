package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDepartment;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDomain;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmPageRole;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmSpeciality;
import co.com.tactusoft.crm.model.entities.CrmUser;

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

	public List<CrmDoctor> getListDoctorActive() {
		return dao.find("CrmDoctor o where o.state = 1");
	}

	public List<CrmSpeciality> getListSpeciality() {
		return dao.find("from CrmSpeciality o");
	}

	public List<CrmSpeciality> getListSpecialityActive() {
		return dao.find("from CrmSpeciality o where o.state = 1");
	}

	public List<CrmProfile> getListProfile() {
		return dao.find("from CrmProfile o");
	}

	public List<CrmProfile> getListProfileActive() {
		return dao.find("from CrmProfile o where o.state = 1");
	}

	public List<CrmUser> getListUser() {
		return dao.find("from CrmUser o");
	}

	public List<CrmUser> getListUserActive() {
		return dao.find("from CrmUser o where o.state = 1");
	}

	public List<CrmRole> getListRole() {
		return dao.find("from CrmRole o");
	}

	public List<CrmRole> getListRoleActive() {
		return dao.find("from CrmRole o where o.state = 1");
	}

	public List<CrmBranch> getListBranch() {
		return dao.find("from CrmBranch o");
	}
	
	public List<CrmBranch> getListBranchActive() {
		return dao.find("from CrmBranch o where o.state = 1");
	}
	
	public List<CrmDepartment> getListDepartment() {
		return dao.find("from CrmDepartment o");
	}
	
	public List<CrmDepartment> getListDepartmentActive() {
		return dao.find("from CrmDepartment o where o.state = 1");
	}

	public List<CrmPage> getListPages() {
		return dao
				.find("from CrmPage o where o.parent is not null order by o.parent");
	}

	public List<CrmPage> getListPagesByRole(BigDecimal idRole) {
		return dao
				.find("select o.crmPage from CrmPageRole o where o.crmPage.parent is not null and o.crmRole.id = "
						+ idRole + " order by o.crmPage.parent");
	}

	public List<CrmDomain> getListDomain(String group) {
		return dao.find("from CrmDomain o where o.group = '" + group + "'");
	}

	public Integer saveDoctor(CrmDoctor entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmDoctor.class));
		}
		return dao.persist(entity);
	}

	public Integer saveSpeciality(CrmSpeciality entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmSpeciality.class));
		}
		return dao.persist(entity);
	}

	public Integer saveProfile(CrmProfile entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmProfile.class));
		}
		return dao.persist(entity);
	}
	
	public Integer saveUser(CrmUser entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmUser.class));
		}
		return dao.persist(entity);
	}

	public Integer saveRole(CrmRole entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmRole.class));
		}
		return dao.persist(entity);
	}

	public Integer saveBranch(CrmBranch entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmBranch.class));
		}
		return dao.persist(entity);
	}

	public Integer savePageRole(CrmRole entity, List<CrmPage> listPages) {
		String ids = "";
		int i = 0;

		dao.executeHQL("delete from CrmPageRole o where o.crmRole.id = "
				+ entity.getId());

		for (CrmPage page : listPages) {
			CrmPageRole crmPageRole = new CrmPageRole();
			crmPageRole.setId(getId(CrmPageRole.class));
			crmPageRole.setCrmRole(entity);
			crmPageRole.setCrmPage(page);
			dao.persist(crmPageRole);

			ids = ids + page.getParent() + ",";
		}

		ids = ids.substring(0, ids.length() - 1);
		List<CrmPage> listParent = dao.find("from CrmPage o where o.id in ("
				+ ids + ")");
		for (CrmPage page : listParent) {
			CrmPageRole crmPageRole = new CrmPageRole();
			crmPageRole.setId(getId(CrmPageRole.class));
			crmPageRole.setCrmRole(entity);
			crmPageRole.setCrmPage(page);
			dao.persist(crmPageRole);
		}

		return i;
	}

	public <T> void remove(Class<T> entity) {
		dao.delete(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

}
