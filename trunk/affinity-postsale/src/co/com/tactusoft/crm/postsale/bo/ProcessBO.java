package co.com.tactusoft.crm.postsale.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmPatient;

@Service
public class ProcessBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomHibernateDao dao;

	public List<CrmAppointment> getListAppointmentNoAttendet(String dateString) {
		return dao
				.find("FROM CrmAppointment WHERE state = 4 AND startAppointmentDate BETWEEN '"
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
				.find("SELECT DISTINCT o.crmPatient FROM CrmAppointment o WHERE o.crmProcedureDetail.id IN (2,5) "
						+ " AND o.state IN (1,3,4) AND o.startAppointmentDate < '"
						+ dateString + "T23:59:59.999+05:00'");
	}

	public void updateAppointment(String dateString) {
		dao.executeHQL("UPDATE CrmAppointment SET state = 4, closeAppointment = 1 "
				+ "WHERE state IN (3,4) AND startAppointmentDate BETWEEN '"
				+ dateString + " 00:00:00' AND '" + dateString + " 23:59:59'");

		dao.executeHQL("UPDATE CrmAppointment SET state = 5, closeAppointment = 1 "
				+ "WHERE state = 1 AND startAppointmentDate BETWEEN '"
				+ dateString + " 00:00:00' AND '" + dateString + " 23:59:59'");
	}

}
