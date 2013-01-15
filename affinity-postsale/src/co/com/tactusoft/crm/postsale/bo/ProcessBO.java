package co.com.tactusoft.crm.postsale.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmAppointment;

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

}
