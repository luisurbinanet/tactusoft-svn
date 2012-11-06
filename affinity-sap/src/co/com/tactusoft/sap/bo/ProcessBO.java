package co.com.tactusoft.sap.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.sap.dao.CustomHibernateDao;
import co.com.tactusoft.sap.entities.CrmCampaign;
import co.com.tactusoft.sap.entities.CrmCampaignDetail;
import co.com.tactusoft.sap.entities.CrmSapMedication;
import co.com.tactusoft.sap.entities.CrmUserCampaign;
import co.com.tactusoft.sap.entities.VwAppointment;
import co.com.tactusoft.sap.entities.VwAppointmentMedication;

@Named
public class ProcessBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<CrmSapMedication> getListSapMedicationByLoadState(
			String patient, String typeBill, String date) {
		return dao.find("FROM CrmSapMedication o WHERE o.idPatient = '"
				+ patient + "' AND o.typeBill = '" + typeBill
				+ "' AND o.dateBill >= '" + date
				+ "' AND o.status IS NULL ORDER BY o.id");
	}

	public Date getMinDateByLoadState() {
		return (Date) dao
				.find("SELECT MIN(dateBill) FROM CrmSapMedication o WHERE o.status IS NULL")
				.get(0);
	}

	public Date getMaxDateByLoadState() {
		return (Date) dao
				.find("SELECT MAX(dateBill) FROM CrmSapMedication o WHERE o.status IS NULL")
				.get(0);
	}

	public List<VwAppointment> getListAppointmentByDates(String minDate,
			String maxDate) {
		return dao
				.find("FROM VwAppointment o WHERE (o.startAppointmentDate BETWEEN '"
						+ minDate
						+ "T00:00:00.000+05:00' AND '"
						+ maxDate
						+ "T23:59:59.999+05:00') AND o.state in (3, 4) "
						+ " ORDER BY id");
	}

	public List<VwAppointmentMedication> getListAppointmentMedicationByCode(
			String code) {
		return dao.find("FROM VwAppointmentMedication o WHERE code = '" + code
				+ "'");
	}

	public List<CrmUserCampaign> getListUserCampaignByBranchs(String branchs) {
		String sql = "SELECT a.id id_user, a.id_branch, count(b.id_user) num_records "
				+ "FROM (SELECT DISTINCT c.id id_branch, c.code code_branch, a.* "
				+ "FROM crm_user a JOIN crm_user_branch b "
				+ "JOIN crm_branch c "
				+ "ON a.id = b.id_user AND c.id = b.id_branch "
				+ "WHERE c.code = "
				+ branchs
				+ " AND a.id_departament = 2) a "
				+ "LEFT JOIN crm_campaign b "
				+ "ON a.id = b.id_user AND a.id_branch = b.id_branch "
				+ "GROUP BY a.id, a.code_branch " + "ORDER BY num_records ASC";
		return dao.findNative(sql, CrmUserCampaign.class);
	}

	public int saveCrmSapMedication(CrmSapMedication entity) {
		return dao.persist(entity);
	}

	public int saveCrmCampaign(CrmCampaign entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmCampaign.class));
		}
		return dao.persist(entity);
	}

	public int saveCrmCampaignDetail(CrmCampaignDetail entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmCampaignDetail.class));
		}
		return dao.persist(entity);
	}

	private <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

}
