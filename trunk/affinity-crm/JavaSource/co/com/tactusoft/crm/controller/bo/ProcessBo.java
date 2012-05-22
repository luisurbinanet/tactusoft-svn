package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDoctorSchedule;
import co.com.tactusoft.crm.model.entities.CrmHoliday;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.model.entities.VwDoctorHour;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Candidate;

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

	private List<CrmHoliday> getListHoliday() {
		String currenDate = FacesUtil.formatDate(new Date(), "yyyy-MM-dd");
		return dao.find("from CrmHoliday o where o.holiday >= '" + currenDate
				+ "T00:00:00.000+05:00'");
	}

	public boolean validateHoliday(List<CrmHoliday> list, Date date) {
		for (CrmHoliday row : list) {
			if (row.getHoliday().compareTo(date) == 0) {
				return false;
			}
		}
		return true;
	}

	public List<Candidate> getScheduleAppointmentForDoctor(BigDecimal idBranch,
			CrmDoctor doctor, int numApp, CrmProcedureDetail procedureDetail) {

		List<Candidate> result = new ArrayList<Candidate>();
		int id = 1;

		String initDate = FacesUtil.formatDate(new Date(), "yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 60); // 60 Días
		String endDate = FacesUtil.formatDate(calendar.getTime(), "yyyy-MM-dd");

		List<CrmAppointment> listApp = dao
				.find("from CrmAppointment o where o.startAppointmentDate >= '"
						+ initDate
						+ "T00:00:00.000+05:00' and o.startAppointmentDate <= '"
						+ endDate
						+ "T00:23:59.999+05:00'  and o.crmBranch.id = "
						+ idBranch + " and o.crmDoctor.id = " + doctor.getId()
						+ "o. state = 1 "
						+ "order by o.startAppointmentDate");

		List<CrmDoctorSchedule> listDoctorSchedule = dao
				.find("from CrmDoctorSchedule o where o.crmDoctor.id = "
						+ doctor.getId() + " order by o.startHour");

		// Buscar los festivos
		List<CrmHoliday> listHoliday = this.getListHoliday();

		// Revisar Día a Día disponibilidad de Citas
		Date currentDate = new Date();
		boolean iterate = true;
		outer: while (iterate) {
			calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			calendar.add(Calendar.DATE, 1);
			currentDate = FacesUtil.getDateWithoutTime(calendar.getTime());

			if ((calendar.get(Calendar.DAY_OF_WEEK) != 1)
					&& (this.validateHoliday(listHoliday, currentDate))) {
				for (CrmDoctorSchedule schedule : listDoctorSchedule) {
					if (calendar.get(Calendar.DAY_OF_WEEK) == schedule.getDay()) {
						// Sumo el dia + hora de disponibilidad del Doctor
						Date scheduleInitHour = FacesUtil.addHourToDate(
								currentDate, schedule.getStartHour());

						Date scheduleEndHour = FacesUtil.addHourToDate(
								currentDate, schedule.getEndHour());

						Date initHour = new Date(scheduleInitHour.getTime());

						boolean endIterate = true;
						while (endIterate) {
							Calendar calendar2 = Calendar.getInstance();
							calendar2.setTime(initHour);
							calendar2.add(Calendar.MINUTE,
									procedureDetail.getTimeDoctor());
							Date endHour = calendar2.getTime();

							// Si la hora final candidata es mayor al tiempo de
							// atencion
							// del doctor salir
							if (endHour.getTime() > scheduleEndHour.getTime()) {
								endIterate = false;
								break;
							}

							// Iterar Horas Candidatas
							long diff = endHour.getTime() - initHour.getTime();
							double diffInMin = diff / ((double) 1000 * 60);
							int size = (int) (diffInMin / Constant.INTERVAL_TIME_APPOINTMENT) + 1;
							List<Date> candidatesHours = new ArrayList<Date>();
							candidatesHours.add(initHour);
							for (int k = 1; k < size; k++) {
								calendar2 = Calendar.getInstance();
								calendar2.setTime(candidatesHours.get(k - 1));
								calendar2.add(Calendar.MINUTE,
										Constant.INTERVAL_TIME_APPOINTMENT);
								candidatesHours.add(calendar2.getTime());
							}

							boolean validate = validateAvailabilitySchedule(
									candidatesHours, listApp, currentDate);
							if (validate) {
								result.add(new Candidate(id, doctor, initHour,
										endHour));
								id++;

								// Numero Citas completadas
								if (result.size() == numApp) {
									iterate = false;
									break outer;
								}
							}

							initHour = new Date(endHour.getTime());
						}
					}
				}
			}
		}

		return result;
	}

	private boolean validateAvailabilitySchedule(List<Date> candidatesHours,
			List<CrmAppointment> listApp, Date currentDate) {

		boolean result = true;

		// Iterar Horas No Disponibles
		int count = 0;
		List<Date> ocupatedHours = new ArrayList<Date>();
		for (CrmAppointment app : listApp) {
			Date dateRow = FacesUtil.getDateWithoutTime(app
					.getStartAppointmentDate());
			if (currentDate.getTime() == dateRow.getTime()) {
				long diff = app.getEndAppointmentDate().getTime()
						- app.getStartAppointmentDate().getTime();
				double diffInMin = diff / ((double) 1000 * 60);
				int size = (int) (diffInMin / Constant.INTERVAL_TIME_APPOINTMENT) + 1;
				ocupatedHours.add(new Date(app.getStartAppointmentDate()
						.getTime()));
				count++;
				for (int k = 1; k < size; k++) {
					Calendar calendar2 = Calendar.getInstance();
					calendar2 = Calendar.getInstance();
					calendar2.setTime(ocupatedHours.get(count - 1));
					calendar2.add(Calendar.MINUTE,
							Constant.INTERVAL_TIME_APPOINTMENT);
					ocupatedHours.add(calendar2.getTime());
					count++;
				}
			}

			// validar
			int contValidate = 0;
			for (Date ocup : ocupatedHours) {
				for (Date cand : candidatesHours) {
					if (cand.compareTo(ocup) == 0) {
						contValidate++;
						break;
					}
				}
			}

			if (contValidate > 1) {
				result = false;
				break;
			}

			// Si la fecha
			if (dateRow.getTime() > currentDate.getTime()) {
				break;
			}
		}

		return result;
	}

	public void getScheduleAppointmentForDate(BigDecimal idBranch) {
		VwDoctorHour vwDoctorHour = (VwDoctorHour) dao.find(
				"from VwDoctorHour o where o.id.idBranch = " + idBranch).get(0);
		BigDecimal idDoctor = vwDoctorHour.getId().getIdDoctor();
	}

}
