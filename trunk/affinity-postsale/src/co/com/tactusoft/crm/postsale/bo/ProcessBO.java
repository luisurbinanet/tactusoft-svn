package co.com.tactusoft.crm.postsale.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmHoliday;
import co.com.tactusoft.crm.model.entities.CrmLog;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmSapMedication;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.model.entities.VwAppointmentMedication;
import co.com.tactusoft.crm.model.entities.VwMedication;
import co.com.tactusoft.crm.util.FacesUtil;

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

	public void updateCampaign(String dateString) {
		dao.executeHQL("UPDATE CrmCampaign SET state = 999 WHERE state = 1 AND Date(dateCall) <= '"
				+ dateString
				+ "' AND id IN (SELECT o.crmCampaign.id FROM CrmCampaignDetail o WHERE o.campaignType=2 "
				+ " AND Date(o.callDate) <= '"
				+ dateString
				+ "' AND o.status = 0)");

		dao.executeHQL("UPDATE CrmCampaignDetail SET status = 999 WHERE status = 0 AND Date(callDate) <= '"
				+ dateString + "' AND campaignType=2");
	}

	public List<CrmAppointment> getListAppointmentNoAttendet(String dateString) {
		return dao
				.find("FROM CrmAppointment o WHERE state = 5 AND startAppointmentDate BETWEEN '"
						+ dateString
						+ "T00:00:00.000+05:00' and '"
						+ dateString + "T23:59:59.999+05:00'");
	}

	public List<CrmAppointment> getListAppointmentConfirmed(
			String yesterdayString, String currentDateString) {
		return dao
				.find("FROM CrmAppointment o WHERE o.state = 1 AND Date(o.startAppointmentDate) = '"
						+ yesterdayString
						+ "' AND Date(o.dateCreate) <> '"
						+ currentDateString + "'");
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
				+ "and b.id not in (select e.id_appointment from crm_campaign_detail e where e.campaign_type=3)";

		return dao.findNative(sql, CrmAppointment.class);
	}

	public List<CrmAppointment> getListAppointmentClosed(String dateString) {
		return dao
				.find("FROM CrmAppointment o WHERE state = 4 AND closeAppointment = 1 AND startAppointmentDate BETWEEN  '"
						+ dateString
						+ "T00:00:00.001+05:00' AND '"
						+ dateString + "T23:59:59.999+05:00'");
	}

	public CrmUser getUser(CrmBranch crmBranch, String date) {
		CrmUser result = null;
		List<CrmUser> list = dao.findNative("SELECT b.* "
				+ "FROM crm_db.crm_campaign a  "
				+ "right outer JOIN crm_db.crm_user b  "
				+ "ON (a.id_user=b.id and date(a.date_call)='" + date + "') "
				+ "left outer JOIN crm_db.crm_user_branch_postsale c  "
				+ "ON b.id=c.id_user WHERE b.state=1 and c.id_branch="
				+ crmBranch.getId() + " GROUP BY b.id ORDER BY count(a.id)",
				CrmUser.class);
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
			CrmPatient patient, String typeBill, String initDate, String endDate) {
		return dao.find("FROM CrmSapMedication o WHERE (o.idPatient = '"
				+ patient.getCodeSap() + "' OR docPatient = '"
				+ patient.getDoc() + "') AND o.typeBill IN (" + typeBill
				+ ") AND Date(o.dateBill) BETWEEN '" + initDate + "' AND '"
				+ endDate + "' ORDER BY o.id");
	}

	public List<CrmSapMedication> getListSapAppointmentByLoadState(
			CrmPatient patient, String initDate, String endDate) {
		return dao.find("FROM CrmSapMedication o WHERE (o.idPatient = '"
				+ patient.getCodeSap() + "' OR docPatient = '"
				+ patient.getDoc() + "') AND o.dateBill >= '" + initDate
				+ "' AND o.dateBill <= '" + endDate
				+ "' AND o.status IS NULL ORDER BY o.id");
	}

	public int updateSapMedicationByLoadState(CrmPatient patient,
			String initDate, String endDate, BigDecimal idAppointment) {
		return dao
				.executeHQL("UPDATE CrmSapMedication o SET o.idAppointment = "
						+ idAppointment + " WHERE (o.idPatient = '"
						+ patient.getCodeSap() + "' OR docPatient = '"
						+ patient.getDoc() + "') AND o.dateBill >= '"
						+ initDate + "' AND o.dateBill <= '" + endDate
						+ "' AND o.status IS NULL ORDER BY o.id");
	}

	public List<VwAppointmentMedication> getListAppointmentMedicationByCode(
			String code) {
		return dao.find("FROM VwAppointmentMedication o WHERE code = '" + code
				+ "'");
	}

	public List<CrmCampaignDetail> getListCampaignDetailMedication(CrmLog log) {
		return dao
				.find("FROM CrmCampaignDetail o WHERE o.campaignType = 4 AND o.crmCampaign.crmLog.id = "
						+ log.getId());
	}

	public List<VwMedication> getListVwMedicationByAppointment(
			BigDecimal idAppointment, String formulaDocType) {
		return dao.find("FROM VwMedication o WHERE idAppointment = "
				+ idAppointment + " AND formulaDocType IN (" + formulaDocType + ")");
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

	public List<CrmHoliday> getListHoliday(Date date, BigDecimal idBranch) {
		String currenDate = FacesUtil.formatDate(date, "yyyy-MM-dd");
		return dao
				.find("select o.crmHoliday from CrmHolidayBranch o where o.crmHoliday.holiday = '"
						+ currenDate + "' and o.crmBranch.id = " + idBranch);
	}

	public List<CrmBranch> getListBranchActive() {
		return dao.find("from CrmBranch o");
	}

	public List<CrmLog> getListLog(String currentDateString) {
		return dao.find("from CrmLog o where Date(o.logDate) = '"
				+ currentDateString + "'");
	}

}
