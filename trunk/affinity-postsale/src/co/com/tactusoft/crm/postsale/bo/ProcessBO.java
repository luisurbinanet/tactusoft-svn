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
import co.com.tactusoft.crm.model.entities.CrmSapMedication;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.model.entities.VwAppointmentMedication;

@Service
public class ProcessBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomHibernateDao dao;

	public void updateAppointment(String dateString) {
		dao.executeHQL("UPDATE CrmAppointment SET state = 4, closeAppointment = 1, dateModified = current_date()"
				+ " WHERE state IN (3,4) AND startAppointmentDate <= '"
				+ dateString + " 23:59:59' AND closeAppointment = 0");

		dao.executeHQL("UPDATE CrmAppointment SET state = 5, closeAppointment = 1, dateModified = current_date()"
				+ " WHERE state = 1 AND startAppointmentDate <= '"
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

	public List<CrmAppointment> getListAppointmentControl(String dateString) {
		String sql = "select distinct b.* "
				+ "from crm_db.crm_appointment b inner join crm_db.crm_patient a on b.id_patient=a.id  "
				+ "where (b.id_procedure_detail in (2 , 6 , 8))  "
				+ "and (b.state in (1 , 3 , 4))  "
				+ "and b.start_appointment_date<'"
				+ dateString
				+ "' and b.id  = (select max(d.id) "
				+ "from crm_db.crm_appointment d inner join crm_db.crm_patient c on d.id_patient=c.id  "
				+ "where (d.id_procedure_detail in (2 , 6 , 8))  "
				+ "and (d.state in (1 , 3 , 4))  "
				+ "and d.start_appointment_date<'"
				+ dateString
				+ "' and c.id = a.id) "
				+ "and b.id not in (select e.id_appointment from crm_campaign_detail e where e.campaing_type='CONTROL')";

		return dao.findNative(sql, CrmAppointment.class);
	}

	public List<CrmAppointment> getListAppointmentClosed(String dateString) {
		return dao
				.find("FROM CrmAppointment o WHERE state = 4 AND closeAppointment = 1 AND startAppointmentDate <= '"
						+ dateString + "T23:59:59.999+05:00'");
	}

	public CrmUser getUser(CrmBranch crmBranch) {
		CrmUser result = null;
		List<CrmUser> list = dao.find("SELECT usr FROM CrmCampaign as cpg"
				+ " RIGHT JOIN cpg.crmUser as usr"
				+ " LEFT JOIN usr.crmUserBranchs as brc "
				+ " JOIN usr.crmUserRoles as rol WITH rol.crmRole.id = 2"
				+ " WHERE usr.state = 1 AND brc.crmBranch.id = "
				+ crmBranch.getId() + " GROUP BY usr ORDER BY COUNT(cpg)");
		if (list.size() > 0) {
			result = list.get(0);
		}
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

	public void updateCrmSapMedication() {
		dao.executeHQL("UPDATE CrmSapMedication SET status = 'PROCESADO'");
	}

	public List<CrmSapMedication> getListSapMedicationByLoadState(
			String patient, String typeBill, String initDate, String endDate) {
		return dao.find("FROM CrmSapMedication o WHERE o.idPatient = '"
				+ patient + "' AND o.typeBill = '" + typeBill
				+ "' AND o.dateBill >= '" + initDate + "' AND o.dateBill <= '"
				+ endDate + "' AND o.status IS NULL ORDER BY o.id");
	}

	public List<VwAppointmentMedication> getListAppointmentMedicationByCode(
			String code) {
		return dao.find("FROM VwAppointmentMedication o WHERE code = '" + code
				+ "'");
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
