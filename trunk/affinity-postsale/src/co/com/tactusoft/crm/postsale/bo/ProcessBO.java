package co.com.tactusoft.crm.postsale.bo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmUser;

@Service
public class ProcessBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomHibernateDao dao;

	public void updateAppointment(String dateString) {
		dao.executeHQL("UPDATE CrmAppointment SET state = 4, closeAppointment = 1, dateModified = current_date()"
				+ " WHERE state IN (3,4) AND startAppointmentDate < '"
				+ dateString + " 23:59:59' AND closeAppointment = 0");

		dao.executeHQL("UPDATE CrmAppointment SET state = 5, closeAppointment = 1, dateModified = current_date()"
				+ " WHERE state = 1 AND startAppointmentDate < '"
				+ dateString
				+ " 23:59:59'");
	}

	public List<CrmAppointment> getListAppointmentNoAttendet(String dateString) {
		return dao
				.find("FROM CrmAppointment WHERE state = 5 AND startAppointmentDate BETWEEN '"
						+ dateString
						+ "T00:00:00.000+05:00' and '"
						+ dateString + "T23:59:59.999+05:00'");
	}

	public List<CrmAppointment> getListAppointmentConfirmed(String dateString) {
		return dao
				.find("FROM CrmAppointment WHERE state = 1 AND startAppointmentDate BETWEEN '"
						+ dateString
						+ "T00:00:00.000+05:00' and '"
						+ dateString + "T23:59:59.999+05:00'");
	}

	public List<CrmPatient> getListAppointmentControl(String dateString) {
		return dao
				.find("SELECT DISTINCT o.crmPatient FROM CrmAppointment o WHERE o.crmProcedureDetail.id IN (2,6,8) "
						+ " AND o.state IN (1,3,4) AND o.startAppointmentDate < '"
						+ dateString + "T23:59:59.999+05:00'");
	}

	public CrmUser getUser(CrmBranch crmBranch) {
		CrmUser result = new CrmUser();
		List<CrmUser> list = dao
				.find("SELECT usr FROM CrmCampaign as cpg "
						+ "RIGHT JOIN cpg.crmUser as usr "
						+ "LEFT JOIN usr.crmUserBranchs as brc WITH brc.crmBranch.id = "
						+ crmBranch.getId()
						+ " GROUP BY usr ORDER BY COUNT(cpg)");
		result = list.get(0);
		return result;
	}

	public CrmBranch getBranch(CrmPatient crmPatient) {
		CrmBranch result = new CrmBranch();
		List<CrmBranch> list = dao
				.find("SELECT o.crmBranch FROM CrmAppointment o WHERE o.crmPatient.id = "
						+ crmPatient.getId()
						+ " ORDER BY o.startAppointmentDate DESC");
		if (list != null && list.size() > 0) {
			result = list.get(0);
		}
		return result;
	}

	public int save(Object entity) {
		int result = 0;
		try {
			result = dao.persist(entity);
		} catch (RuntimeException ex) {
			if (ex.getCause() instanceof ConstraintViolationException) {
				result = -1;
			} else if (ex.getCause() instanceof DataIntegrityViolationException) {
				result = -2;
			} else {
				result = -3;
			}
		}
		return result;
	}

}
