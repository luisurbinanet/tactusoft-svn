package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCie;
import co.com.tactusoft.crm.model.entities.CrmCieMaterial;
import co.com.tactusoft.crm.model.entities.CrmCity;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmDepartment;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDoctorException;
import co.com.tactusoft.crm.model.entities.CrmDoctorSchedule;
import co.com.tactusoft.crm.model.entities.CrmDomain;
import co.com.tactusoft.crm.model.entities.CrmHoliday;
import co.com.tactusoft.crm.model.entities.CrmHolidayBranch;
import co.com.tactusoft.crm.model.entities.CrmNurse;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmPageRole;
import co.com.tactusoft.crm.model.entities.CrmProcedure;
import co.com.tactusoft.crm.model.entities.CrmProcedureBranch;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmSpeciality;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.model.entities.CrmUserBranch;
import co.com.tactusoft.crm.model.entities.CrmUserProfile;
import co.com.tactusoft.crm.model.entities.CrmUserRole;
import co.com.tactusoft.crm.model.entities.VwProcedure;

import com.tactusoft.webservice.client.beans.WSBean;

@Named
public class TablesBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<CrmDoctor> getListDoctor() {
		return dao.find("from CrmDoctor o");
	}

	public List<CrmDoctor> getListDoctorActive() {
		return dao.find("from CrmDoctor o where o.state = 1 and o.id <> 0");
	}

	public List<CrmNurse> getListNurse() {
		return dao.find("from CrmNurse");
	}

	public List<CrmNurse> getListNurseActive() {
		return dao.find("from CrmNurse o where o.state = 1");
	}

	public List<CrmDoctor> getListDoctorByBranch(BigDecimal idBranch) {
		return dao
				.find("select distinct o.crmDoctor from CrmDoctorSchedule o where o.crmBranch.id = "
						+ idBranch
						+ " and o.crmDoctor.id <> 0 and o.crmDoctor.state = 1");
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

	public List<CrmProfile> getListProfileByUser(BigDecimal idUser) {
		return dao
				.find("select o.crmProfile from CrmUserProfile o where o.crmUser.id = "
						+ idUser);
	}

	public CrmProfile getProfileById(BigDecimal idProfile) {
		List<CrmProfile> list = dao.find("from CrmProfile o where o.id = "
				+ idProfile);
		if (list == null || list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
	}

	public List<CrmUser> getListUser() {
		return dao.find("from CrmUser o where o.id <> 0");
	}

	public List<CrmUser> getListUserActive() {
		return dao.find("from CrmUser o where o.id <> 0 and o.state = 1");
	}

	public List<CrmUser> getListUserActiveByBranch(BigDecimal idBranch) {
		return dao
				.find("select o.crmUser from CrmUserBranch o where o.crmUser.state = 1 and o.crmBranch.id = "
						+ idBranch);
	}

	public List<CrmDoctor> getDoctorByUser(BigDecimal idUser) {
		return dao.find("from CrmDoctor o where o.crmUser.id = " + idUser);
	}

	public List<CrmNurse> getNurseByUser(BigDecimal idUser) {
		return dao.find("from CrmNurse o where o.crmUser.id = " + idUser);
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

	public List<CrmOccupation> getListOccupation() {
		return dao.find("from CrmOccupation o");
	}

	public List<CrmOccupation> getListOccupationActive() {
		return dao.find("from CrmOccupation o where o.state = 1");
	}

	public List<CrmCountry> getListCountry() {
		return dao.find("from CrmCountry o");
	}

	public List<CrmRegion> getListRegion() {
		return dao.find("from CrmRegion o");
	}

	public List<CrmCity> getListCity() {
		return dao.find("from CrmCity o");
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

	public List<CrmProcedure> getListProcedureByBranch(BigDecimal idBranch) {
		return dao
				.find("select o.crmProcedure from CrmProcedureBranch o where o.crmProcedure.state = 1 and o.crmBranch.id = "
						+ idBranch);
	}

	public List<CrmProcedureDetail> getListProcedureDetailByBranch(
			BigDecimal idBranch) {
		String complementary = "(";
		List<CrmProcedure> list = getListProcedureByBranch(idBranch);
		for (CrmProcedure item : list) {
			complementary = complementary + item.getId() + ",";
		}
		complementary = complementary.substring(0, complementary.length() - 1)
				+ ")";
		return dao.find("from CrmProcedureDetail o where o.crmProcedure.id in "
				+ complementary + " order by o.name");
	}

	public List<VwProcedure> getListVwProcedureByBranch(BigDecimal idBranch) {
		return dao.find("from VwProcedure o where o.idBranch = " + idBranch);
	}

	public List<CrmProcedureDetail> getListProcedureDetailByProcedure(
			BigDecimal idProcedure) {
		return dao.find("from CrmProcedureDetail o where o.crmProcedure.id = "
				+ idProcedure);
	}

	public List<CrmBranch> getListBranchByProcedure(BigDecimal idProcedure) {
		return dao
				.find("select o.crmBranch from CrmProcedureBranch o where o.crmProcedure.id = "
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

	public CrmDoctor getCrmDoctor(BigDecimal idUser) {
		List<CrmDoctor> list = dao
				.find("from CrmDoctor o where o.state = 1 and o.crmUser.id = "
						+ idUser);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public CrmNurse getCrmNurse(BigDecimal idUser) {
		List<CrmNurse> list = dao
				.find("from CrmNurse o where o.state = 1 and o.crmUser.id = "
						+ idUser);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<CrmCie> getListCieMaterial() {
		return dao.find("select distinct o.crmCie from CrmCieMaterial o");
	}

	public List<CrmCieMaterial> getListMaterialbyDiagnosis(
			BigDecimal idDiagnosis) {
		return dao.find("from CrmCieMaterial o where o.crmCie.id = "
				+ idDiagnosis + " and state = 1");
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

	public Integer saveNurse(CrmNurse entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmNurse.class));
		}
		return dao.persist(entity);
	}

	public Integer saveProfile(CrmProfile entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmProfile.class));
		}
		return dao.persist(entity);
	}

	public Integer saveUser(CrmUser entity, CrmDoctor doctor, CrmNurse nurse) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmUser.class));
		}

		int result = dao.persist(entity);

		if (doctor != null) {
			doctor.setCrmUser(entity);
			saveDoctor(doctor);
		}

		if (nurse != null) {
			nurse.setCrmUser(entity);
			saveNurse(nurse);
		}

		return result;
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

	public Integer saveOccupation(CrmOccupation entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmOccupation.class));
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

	public Integer saveUserProfile(CrmUser entity, List<CrmProfile> listProfile) {
		int i = 0;

		dao.executeHQL("delete from CrmUserProfile o where o.crmUser.id = "
				+ entity.getId());

		for (CrmProfile profile : listProfile) {
			CrmUserProfile row = new CrmUserProfile();
			row.setId(getId(CrmUserProfile.class));
			row.setCrmUser(entity);
			row.setCrmProfile(profile);
			dao.persist(row);
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

	public Integer saveProcedureBranch(CrmProcedure entity, List<CrmBranch> list) {
		int i = 0;

		dao.executeHQL("delete from CrmProcedureBranch o where o.crmProcedure.id = "
				+ entity.getId());

		for (CrmBranch row : list) {
			CrmProcedureBranch newRow = new CrmProcedureBranch();
			newRow.setId(getId(CrmProcedureBranch.class));
			newRow.setCrmProcedure(entity);
			newRow.setCrmBranch(row);
			dao.persist(newRow);
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

	public Integer saveCieMaterial(CrmCie entity, List<WSBean> listMaterial) {
		dao.executeHQL("delete from CrmCieMaterial o where o.crmCie.id = "
				+ entity.getId());

		for (WSBean data : listMaterial) {
			CrmCieMaterial row = new CrmCieMaterial();
			row.setId(getId(CrmCieMaterial.class));
			row.setCrmCie(entity);
			row.setMaterial(data.getCode());
			row.setDescription(data.getNames());
			dao.persist(row);
		}

		if (entity.getId() == null) {
			entity.setId(getId(CrmCieMaterial.class));
		}
		return dao.persist(entity);
	}

	public void udpateBranch(String code, String society) {
		dao.executeHQL("update CrmBranch set society = '" + society
				+ "' where code = '" + code + "'");
	}

	public int remove(Object entity) {
		return dao.delete(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

}
