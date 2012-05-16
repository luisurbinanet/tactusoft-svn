package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.VwDoctorHour;

@Named
public class ProcessBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<CrmAppointment> getListAppointment() {
		return dao.find(CrmAppointment.class);
	}

	public List<CrmAppointment> getListAppointmentByDoctor(BigDecimal idDoctor) {
		return dao.find("from CrmAppointment o where o.crmDoctor.id = "
				+ idDoctor);
	}

	public Integer saveAppointment(CrmAppointment entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmAppointment.class));
		}
		return dao.persist(entity);
	}

	public <T> void remove(Class<T> entity) {
		dao.delete(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

	public void getScheduleAppointmentForDoctor(BigDecimal idBranch) {
		VwDoctorHour vwDoctorHour = (VwDoctorHour) dao.find(
				"from VwDoctorHour o where o.id.idBranch = " + idBranch)
				.get(0);
		BigDecimal idDoctor = vwDoctorHour.getId().getIdDoctor();
	}
	
	public void getScheduleAppointmentForDate(BigDecimal idBranch) {
		VwDoctorHour vwDoctorHour = (VwDoctorHour) dao.find(
				"from VwDoctorHour o where o.id.idBranch = " + idBranch)
				.get(0);
		BigDecimal idDoctor = vwDoctorHour.getId().getIdDoctor();
	}

}
