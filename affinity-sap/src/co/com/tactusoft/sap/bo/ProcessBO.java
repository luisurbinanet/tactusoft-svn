package co.com.tactusoft.sap.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.sap.dao.CustomHibernateDao;
import co.com.tactusoft.sap.entities.CrmSapMedication;
import co.com.tactusoft.sap.entities.VwAppointment;
import co.com.tactusoft.sap.entities.VwAppointmentMedication;

@Named
public class ProcessBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<CrmSapMedication> getListSapMedicationByLoadState(
			String patient, String typeBill, String date) {
		return dao.find("FROM CrmSapMedication WHERE idPatient = '" + patient
				+ "' AND typeBill = '" + typeBill + "' AND dateBill >= '"
				+ date + "' ORDER BY id");
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

}
