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
import co.com.tactusoft.crm.model.entities.VwDoctorSchedule;
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

	public CrmAppointment saveAppointment(CrmAppointment entity) {
		if (entity.getId() == null) {
			BigDecimal id = getId(CrmAppointment.class);
			entity.setId(id);
			String code = "C" + FacesUtil.lpad(id.toString(), '0', 5);
			entity.setCode(code);
		}

		dao.persist(entity);
		return entity;
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

	private List<Date> getListcandidatesHours(Date initHour, Date endHour) {
		long diff = endHour.getTime() - initHour.getTime();
		double diffInMin = diff / ((double) 1000 * 60);
		int size = (int) (diffInMin / Constant.INTERVAL_TIME_APPOINTMENT) + 1;
		List<Date> candidatesHours = new ArrayList<Date>();
		candidatesHours.add(initHour);
		for (int k = 1; k < size; k++) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(candidatesHours.get(k - 1));
			calendar.add(Calendar.MINUTE, Constant.INTERVAL_TIME_APPOINTMENT);
			candidatesHours.add(calendar.getTime());
		}

		return candidatesHours;
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

		List<CrmDoctorSchedule> listDoctorSchedule = dao
				.find("from CrmDoctorSchedule o where o.crmDoctor.id = "
						+ doctor.getId() + " order by o.day, o.startHour");

		// Validar si Doctor tiene Horario
		if (listDoctorSchedule.size() > 0) {

			// Buscar citas x doctor y sucursal
			List<CrmAppointment> listApp = dao
					.find("from CrmAppointment o where o.startAppointmentDate >= '"
							+ initDate
							+ "T00:00:00.000+05:00' and o.startAppointmentDate <= '"
							+ endDate
							+ "T23:59:59.999+05:00'  and o.crmBranch.id = "
							+ idBranch
							+ " and o.crmDoctor.id = "
							+ doctor.getId()
							+ " and o. state = 1 "
							+ "order by o.startAppointmentDate");

			// Buscar los festivos
			List<CrmHoliday> listHoliday = this.getListHoliday();

			// Revisar Día a Día disponibilidad de Citas
			Date currentDate = new Date();
			calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			calendar.add(Calendar.DATE, -1);
			currentDate = calendar.getTime();

			boolean iterate = true;
			outer: while (iterate) {
				calendar = Calendar.getInstance();
				calendar.setTime(currentDate);
				calendar.add(Calendar.DATE, 1);
				currentDate = FacesUtil.getDateWithoutTime(calendar.getTime());

				if ((calendar.get(Calendar.DAY_OF_WEEK) != 1)
						&& (this.validateHoliday(listHoliday, currentDate))) {
					for (CrmDoctorSchedule schedule : listDoctorSchedule) {
						if (calendar.get(Calendar.DAY_OF_WEEK) == schedule
								.getDay()) {
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

								// Si la hora final candidata es mayor al tiempo
								// de
								// atencion
								// del doctor salir
								if (endHour.getTime() > scheduleEndHour
										.getTime()) {
									endIterate = false;
									break;
								}

								// Iterar Horas Candidatas
								List<Date> candidatesHours = getListcandidatesHours(
										initHour, endHour);

								// Validar Disponibilidad
								boolean validate = validateAvailabilitySchedule(
										candidatesHours, listApp, currentDate);
								if (validate) {
									result.add(new Candidate(id, doctor,
											initHour, endHour));
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
		}

		return result;
	}

	public List<Candidate> getScheduleAppointmentForDate(BigDecimal idBranch,
			Date date, CrmProcedureDetail procedureDetail) {
		List<Candidate> result = new ArrayList<Candidate>();
		int id = 1;

		// Buscar los festivos
		List<CrmHoliday> listHoliday = this.getListHoliday();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int currentDay = calendar.get(Calendar.DAY_OF_WEEK);

		if ((currentDay != 1) && (this.validateHoliday(listHoliday, date))) {

			String dateString = FacesUtil.formatDate(date, "yyyy-MM-dd");

			// Buscar citas x doctor y sucursal
			List<VwDoctorSchedule> listVwDoctorSchedule = dao
					.find("from VwDoctorSchedule o where o.id.idBranch = "
							+ idBranch + " and o.id.day = " + currentDay);

			for (VwDoctorSchedule vwDoctorSchedule : listVwDoctorSchedule) {
				BigDecimal idDoctor = vwDoctorSchedule.getId().getIdDoctor();

				// Buscar horarios Doctor
				List<CrmDoctorSchedule> listDoctorSchedule = dao
						.find("from CrmDoctorSchedule o where o.crmDoctor.id = "
								+ idDoctor + " order by o.day, o.startHour");

				// Validar si Doctor tiene Horario
				if (listDoctorSchedule.size() > 0) {

					List<CrmAppointment> listApp = dao
							.find("from CrmAppointment o where o.startAppointmentDate >= '"
									+ dateString
									+ "T00:00:00.000+05:00' and o.startAppointmentDate <= '"
									+ dateString
									+ "T23:59:59.999+05:00'  and o.crmBranch.id = "
									+ idBranch
									+ " and o.crmDoctor.id = "
									+ idDoctor
									+ " and o. state = 1 "
									+ "order by o.startAppointmentDate");

					for (CrmDoctorSchedule schedule : listDoctorSchedule) {
						if (currentDay == schedule.getDay()) {

							Date scheduleInitHour = FacesUtil.addHourToDate(
									date, schedule.getStartHour());

							Date scheduleEndHour = FacesUtil.addHourToDate(
									date, schedule.getEndHour());

							Date initHour = new Date(scheduleInitHour.getTime());

							boolean endIterate = true;
							while (endIterate) {

								Calendar calendar2 = Calendar.getInstance();
								calendar2.setTime(initHour);
								calendar2.add(Calendar.MINUTE,
										procedureDetail.getTimeDoctor());
								Date endHour = calendar2.getTime();

								// Si la hora final candidata es mayor al tiempo
								// de
								// atencion
								// del doctor salir
								if (endHour.getTime() > scheduleEndHour
										.getTime()) {
									endIterate = false;
									break;
								}

								// Iterar Horas Candidatas
								List<Date> candidatesHours = getListcandidatesHours(
										initHour, endHour);

								// Validar Disponibilidad
								boolean validate = validateAvailabilitySchedule(
										candidatesHours, listApp, date);

								if (validate) {
									CrmDoctor crmDoctor = new CrmDoctor();
									crmDoctor.setId(idDoctor);
									crmDoctor.setFirstName(vwDoctorSchedule
											.getId().getFirstName());
									crmDoctor.setFirstSurname(vwDoctorSchedule
											.getId().getFirstSurname());

									result.add(new Candidate(id, crmDoctor,
											initHour, endHour));
									id++;
								}

								initHour = new Date(endHour.getTime());
							}

						}
					}
				}
			}
		}

		return result;
	}

	private int validateDuplicated(String patient, Date starDate, Date endDate) {
		String dateString = FacesUtil.formatDate(starDate, "yyyy-MM-dd");
		String startHourString = FacesUtil.formatDate(starDate, "HH:mm:ss");
		String endHourString = FacesUtil.formatDate(endDate, "HH:mm:ss");

		List<CrmAppointment> listApp = dao
				.find("from CrmAppointment o where o.startAppointmentDate >= '"
						+ dateString + "T" + startHourString
						+ ".000+05:00' and o.startAppointmentDate <= '"
						+ dateString + "T" + endHourString
						+ ".000+05:00' and o.patient = '" + patient
						+ "' and o.state = 1 "
						+ "order by o.startAppointmentDate");

		return listApp.size();
	}

	public int validateAppointmentForDate(BigDecimal idBranch, Date starDate,
			Date endDate, CrmProcedureDetail procedureDetail,
			BigDecimal idDoctor, String patient) {

		int result = 0;

		// Validar si Paciente tiene otra cita
		result = validateDuplicated(patient, starDate, endDate);
		if (result > 0) {
			return -4;
		}

		// Buscar los festivos
		List<CrmHoliday> listHoliday = this.getListHoliday();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(starDate);
		int day = calendar.get(Calendar.DAY_OF_WEEK);

		if ((day != 1) && (this.validateHoliday(listHoliday, starDate))) {

			String dateString = FacesUtil.formatDate(starDate, "yyyy-MM-dd");
			String hourString = FacesUtil.formatDate(endDate, "HH:mm:ss");

			// Buscar horarios Doctor
			List<CrmDoctorSchedule> listDoctorSchedule = dao
					.find("from CrmDoctorSchedule o where o.day = " + day
							+ " and o.crmDoctor.id = " + idDoctor
							+ " and o.endHour <= '1900-01-01T" + hourString
							+ ".000+05:00'" + " order by o.day, o.startHour");

			// Validar si Doctor tiene Horario
			if (listDoctorSchedule.size() > 0) {

				boolean validateScheduleDoctor = false;

				// Dia Actual sin Hora
				Date currentDate = FacesUtil.getDateWithoutTime(starDate);

				// Iterar Horas Candidatas
				List<Date> candidatesHours = getListcandidatesHours(starDate,
						endDate);

				// Validar Disponibilidad del Doctor
				for (CrmDoctorSchedule schedule : listDoctorSchedule) {

					Date scheduleInitHour = FacesUtil.addHourToDate(
							currentDate, schedule.getStartHour());

					Date scheduleEndHour = FacesUtil.addHourToDate(currentDate,
							schedule.getEndHour());

					List<Date> scheduleHours = getListcandidatesHours(
							scheduleInitHour, scheduleEndHour);

					// validar
					int contValidate = 0;
					for (Date ocup : scheduleHours) {
						for (Date cand : candidatesHours) {
							if (cand.compareTo(ocup) == 0) {
								contValidate++;
							}
						}
					}

					if (contValidate == candidatesHours.size()) {
						validateScheduleDoctor = true;
						break;
					}

				}

				if (validateScheduleDoctor) {
					List<CrmAppointment> listApp = dao
							.find("from CrmAppointment o where o.startAppointmentDate >= '"
									+ dateString
									+ "T00:00:00.000+05:00' and o.startAppointmentDate <= '"
									+ dateString
									+ "T23:59:59.999+05:00'  and o.crmBranch.id = "
									+ idBranch
									+ " and o.crmDoctor.id = "
									+ idDoctor
									+ " and o. state = 1 "
									+ "order by o.startAppointmentDate");

					// Validar Disponibilidad
					boolean validate = validateAvailabilitySchedule(
							candidatesHours, listApp, currentDate);

					if (!validate) {
						// Cita no disponible
						result = -3;
					}
				} else {
					// Doctor no antiende
					result = -2;
				}
			} else {
				// Doctor no antiende
				result = -2;
			}
		} else {
			// Dia Festivo no habil
			result = -1;
		}

		return result;
	}

	public List<CrmAppointment> listAppointmentByPatient(String patient,
			int state) {
		List<CrmAppointment> list = new ArrayList<CrmAppointment>();
		list = dao.find("from CrmAppointment o where o.patient = '" + patient
				+ "' and o.state = " + state);
		return list;
	}

}
