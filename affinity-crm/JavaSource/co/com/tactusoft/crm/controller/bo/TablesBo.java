package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmDepartment;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDoctorException;
import co.com.tactusoft.crm.model.entities.CrmDoctorSchedule;
import co.com.tactusoft.crm.model.entities.CrmDomain;
import co.com.tactusoft.crm.model.entities.CrmHoliday;
import co.com.tactusoft.crm.model.entities.CrmHolidayBranch;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmPageRole;
import co.com.tactusoft.crm.model.entities.CrmProcedure;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmSpeciality;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.model.entities.CrmUserBranch;
import co.com.tactusoft.crm.model.entities.CrmUserRole;

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
		return dao.find("from CrmDoctor o where o.state = 1");
	}

	public List<CrmDoctorSchedule> getListScheduleByDoctor(BigDecimal idDoctor) {
		return dao.find("from CrmDoctorSchedule o where o.crmDoctor.id = "
				+ idDoctor);
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

	public List<CrmUser> getListUserActiveByBranch(BigDecimal idBranch) {
		return dao
				.find("select o.crmUser from CrmUserBranch o where o.crmUser.state = 1 and o.crmBranch.id = "
						+ idBranch);
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

	public List<CrmCountry> getListCountry() {
		return dao.find("from CrmCountry o");
	}

	public List<CrmBranch> getListBranchByUser(BigDecimal idUser) {
		return dao
				.find("select o.crmBranch from CrmUserBranch o where o.crmUser.id = "
						+ idUser);
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

	public List<CrmProcedure> getListProcedure() {
		return dao.find("from CrmProcedure o");
	}

	public List<CrmProcedure> getListProcedureActive() {
		return dao.find("from CrmProcedure o where o.state = 1");
	}

	public List<CrmProcedureDetail> getListProcedureDetailByProcedure(
			BigDecimal idProcedure) {
		return dao.find("from CrmProcedureDetail o where o.crmProcedure.id = "
				+ idProcedure);
	}

	public List<CrmHoliday> getListHoliday() {
		return dao.find("from CrmHoliday o");
	}

	public List<CrmBranch> getListBranchByHoliday(BigDecimal idHoliday) {
		return dao
				.find("select o.crmBranch from CrmHolidayBranch o where o.crmHoliday.id = "
						+ idHoliday);
	}

	public List<CrmDoctorException> getListDoctorException() {
		return dao.find("from CrmDoctorException o order by o.startHour");
	}

	public List<CrmDoctorException> getListDoctorExceptionByDoctor(
			BigDecimal idDoctor) {
		return dao.find("from CrmDoctorException o where o.crmDoctor.id = "
				+ idDoctor + " order by o.startHour");
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

	public Integer saveDepartment(CrmDepartment entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmDepartment.class));
		}
		return dao.persist(entity);
	}

	public Integer saveProcedure(CrmProcedure entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmProcedure.class));
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

	public Integer saveUserBranch(CrmUser entity, List<CrmBranch> listBranch) {
		int i = 0;

		dao.executeHQL("delete from CrmUserBranch o where o.crmUser.id = "
				+ entity.getId());

		for (CrmBranch branch : listBranch) {
			CrmUserBranch crmUserBranch = new CrmUserBranch();
			crmUserBranch.setId(getId(CrmUserBranch.class));
			crmUserBranch.setCrmUser(entity);
			crmUserBranch.setCrmBranch(branch);
			dao.persist(crmUserBranch);
		}

		return i;
	}

	public Integer saveUserRole(CrmUser entity, List<CrmRole> listRole) {
		int i = 0;

		dao.executeHQL("delete from CrmUserRole o where o.crmUser.id = "
				+ entity.getId());

		for (CrmRole role : listRole) {
			CrmUserRole cmUserRole = new CrmUserRole();
			cmUserRole.setId(getId(CrmUserRole.class));
			cmUserRole.setCrmUser(entity);
			cmUserRole.setCrmRole(role);
			dao.persist(cmUserRole);
		}

		return i;
	}

	public Integer saveDoctorSchedule(CrmDoctor entity,
			List<CrmDoctorSchedule> listSchedule) {
		int i = 0;

		dao.executeHQL("delete from CrmDoctorSchedule o where o.crmDoctor.id = "
				+ entity.getId());

		for (CrmDoctorSchedule row : listSchedule) {
			row.setId(getId(CrmDoctorSchedule.class));
			row.setCrmDoctor(entity);
			dao.persist(row);
		}

		return i;
	}

	public Integer saveDoctorException(CrmDoctorException entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmDoctorException.class));
		}
		return dao.persist(entity);
	}

	public Integer saveProcedureDetail(CrmProcedure entity,
			List<CrmProcedureDetail> listSchedule) {
		int i = 0;

		for (CrmProcedureDetail row : listSchedule) {
			if (row.getId().intValue() == -1) {
				row.setId(getId(CrmProcedureDetail.class));
			}
			row.setCrmProcedure(entity);
			dao.persist(row);
		}

		return i;
	}

	public Integer saveHoliday(CrmHoliday entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHoliday.class));
		}
		return dao.persist(entity);
	}

	public Integer saveHolidayBranch(CrmHoliday entity,
			List<CrmBranch> listBranch) {
		int i = 0;

		dao.executeHQL("delete from CrmHolidayBranch o where o.crmHoliday.id = "
				+ entity.getId());

		for (CrmBranch branch : listBranch) {
			CrmHolidayBranch row = new CrmHolidayBranch();
			row.setId(getId(CrmHolidayBranch.class));
			row.setCrmHoliday(entity);
			row.setCrmBranch(branch);
			dao.persist(row);
		}

		return i;
	}

	public void remove(Object entity) {
		dao.delete(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

}
