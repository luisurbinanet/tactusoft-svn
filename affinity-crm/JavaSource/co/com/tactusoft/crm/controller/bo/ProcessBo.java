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
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCie;
import co.com.tactusoft.crm.model.entities.CrmDiagnosis;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmDoctorException;
import co.com.tactusoft.crm.model.entities.CrmDoctorSchedule;
import co.com.tactusoft.crm.model.entities.CrmHistoryHistory;
import co.com.tactusoft.crm.model.entities.CrmHistoryHomeopathic;
import co.com.tactusoft.crm.model.entities.CrmHistoryOrganometry;
import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmHistoryRecord;
import co.com.tactusoft.crm.model.entities.CrmHoliday;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.model.entities.VwDoctorHour;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Candidate;

@Named
public class ProcessBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<CrmAppointment> getListAppointment() {
		return dao.find(CrmAppointment.class);
	}

	public List<CrmAppointment> getListAppointmentByDoctor(BigDecimal idDoctor) {
		return dao.find("from CrmAppointment o where o.crmDoctor.id = "
				+ idDoctor + "order by o.startAppointmentDate");
	}

	public List<CrmAppointment> getListAppointmentByDoctorWithOutUntimely(
			BigDecimal idDoctor) {
		return dao.find("from CrmAppointment o where o.crmDoctor.id = "
				+ idDoctor
				+ "and o.untimely = 0 order by o.startAppointmentDate");
	}

	public List<CrmAppointment> getListAppointmentByDoctorWithUntimely(
			BigDecimal idDoctor) {
		return dao
				.find("from CrmAppointment o where o.crmDoctor.id = "
						+ idDoctor
						+ " and o.untimely = 1 and o.state = 3 order by o.startAppointmentDate");
	}

	public List<CrmAppointment> getListAppointmentByDoctorConfirmed(
			BigDecimal idDoctor) {
		return dao.find("from CrmAppointment o where o.crmDoctor.id = "
				+ idDoctor + "and o.state = 1 order by o.startAppointmentDate");
	}

	public List<CrmAppointment> getListAppointmentByBranch(BigDecimal idBranch) {
		return dao.find("from CrmAppointment o where o.crmBranch.id = "
				+ idBranch + "order by o.startAppointmentDate");
	}

	public List<CrmAppointment> getListAppointmentByBranchDoctor(
			BigDecimal idBranch, BigDecimal idDoctor) {
		return dao.find("from CrmAppointment o where o.crmBranch.id = "
				+ idBranch + " and o.crmDoctor.id = " + idDoctor
				+ "order by o.startAppointmentDate");
	}

	public List<CrmAppointment> getListAppointmentByDoctor(CrmDoctor doctor,
			Date startDate) {

		String startDateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd");

		List<CrmAppointment> list = dao
				.find("from CrmAppointment o where o.startAppointmentDate >= '"
						+ startDateString
						+ "T00:00:00.000+05:00' and o.crmDoctor.id = '"
						+ doctor.getId() + "' and o.state in (1,3,4,5) "
						+ " order by o.startAppointmentDate desc");

		return list;
	}

	public List<CrmCie> getListCieByCode(String code) {
		return dao.find("from CrmCie o where o.code like '%" + code
				+ "%' order by o.description");
	}

	public List<CrmCie> getListCieByName(String name) {
		return dao.find("from CrmCie o where o.description like '%" + name
				+ "%' order by o.description");
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

	private List<CrmHoliday> getListHoliday(BigDecimal idBranch) {
		String currenDate = FacesUtil.formatDate(new Date(), "yyyy-MM-dd");
		return dao
				.find("select o.crmHoliday from CrmHolidayBranch o where o.crmHoliday.holiday >= '"
						+ currenDate
						+ "T00:00:00.000+05:00' and o.crmBranch.id = "
						+ idBranch);
	}

	private List<CrmHoliday> getListHoliday(Date date, BigDecimal idBranch) {
		String currenDate = FacesUtil.formatDate(date, "yyyy-MM-dd");
		return dao
				.find("select o.crmHoliday from CrmHolidayBranch o where o.crmHoliday.holiday >= '"
						+ currenDate
						+ "T00:00:00.000+05:00' and o.crmBranch.id = "
						+ idBranch);
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

	private boolean validateAvailabilitySchedule(List<Date> candidatesHours,
			Date startTime, Date endTime) {

		boolean result = true;

		// Iterar Horas No Disponibles
		int count = 0;
		List<Date> ocupatedHours = new ArrayList<Date>();

		long diff = endTime.getTime() - startTime.getTime();
		double diffInMin = diff / ((double) 1000 * 60);
		int size = (int) (diffInMin / Constant.INTERVAL_TIME_APPOINTMENT) + 1;
		ocupatedHours.add(new Date(startTime.getTime()));
		count++;
		for (int k = 1; k < size; k++) {
			Calendar calendar2 = Calendar.getInstance();
			calendar2 = Calendar.getInstance();
			calendar2.setTime(ocupatedHours.get(count - 1));
			calendar2.add(Calendar.MINUTE, Constant.INTERVAL_TIME_APPOINTMENT);
			ocupatedHours.add(calendar2.getTime());
			count++;
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
		}

		return result;
	}

	public List<Date> getListcandidatesHours(Date currentDate,
			CrmBranch branch, int minutes) {
		List<Date> result = new ArrayList<Date>();
		BigDecimal idBranch = branch.getId();

		String dateString = FacesUtil.formatDate(currentDate, "yyyy-MM-dd");
		// Buscar Citas
		List<CrmAppointment> listApp = dao
				.find("from CrmAppointment o where (o.startAppointmentDate between '"
						+ dateString
						+ "T00:00:00.000+05:00' and '"
						+ dateString
						+ "T23:59:59.999+05:00') and o.state in (1,3,4,5) "
						+ "order by o.startAppointmentDate");

		// Validar Festivo
		List<CrmHoliday> listHoliday = getListHoliday(currentDate, idBranch);
		if (listHoliday.size() == 0) {

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			int currentDay = calendar.get(Calendar.DAY_OF_WEEK);

			if (currentDay != 1) {// Si no es domingo
				// Buscar citas x doctor y sucursal
				List<CrmDoctorSchedule> listCrmDoctorSchedule = dao
						.find("from CrmDoctorSchedule o where o.crmBranch.id = "
								+ idBranch + " and o.day = " + currentDay);

				if (listCrmDoctorSchedule.size() > 0) {

					Date minHour = null;
					Date maxHour = null;

					for (CrmDoctorSchedule row : listCrmDoctorSchedule) {
						if (minHour != null) {
							if (row.getStartHour().compareTo(minHour) < 0) {
								minHour = row.getStartHour();
							}
						} else {
							minHour = row.getStartHour();
						}

						if (maxHour != null) {
							if (row.getEndHour().compareTo(maxHour) > 0) {
								maxHour = row.getEndHour();
							}
						} else {
							maxHour = row.getEndHour();
						}
					}

					Date scheduleInitHour = minHour;

					boolean end = false;
					do {
						// Validar Hora
						int numInteractions = 0;
						int numapp = 0;

						for (CrmDoctorSchedule row : listCrmDoctorSchedule) {
							if ((scheduleInitHour.compareTo(row.getStartHour()) >= 0)
									&& (scheduleInitHour.compareTo(row
											.getEndHour()) < 0)) {
								numInteractions++;
							}
						}

						if (numInteractions > 0) {
							calendar = Calendar.getInstance();
							calendar.setTime(scheduleInitHour);
							calendar.add(Calendar.MINUTE, minutes);
							Date scheduleEndHour = calendar.getTime();
							scheduleEndHour = FacesUtil.addHourToDate(
									currentDate, scheduleEndHour);

							List<Date> candidatesHours = getListcandidatesHours(
									FacesUtil.addHourToDate(currentDate,
											scheduleInitHour), scheduleEndHour);

							for (CrmAppointment row : listApp) {
								boolean validate = validateAvailabilitySchedule(
										candidatesHours,
										row.getStartAppointmentDate(),
										row.getEndAppointmentDate());
								if (!validate) {
									numapp++;
								}

							}

							if (numapp < numInteractions) {
								Date time = FacesUtil.addHourToDate(
										currentDate, scheduleInitHour);
								if (time.compareTo(new Date()) > 0) {
									result.add(time);
								}
							}
						}

						calendar = Calendar.getInstance();
						calendar.setTime(scheduleInitHour);
						calendar.add(Calendar.MINUTE, minutes);
						scheduleInitHour = calendar.getTime();

						if (scheduleInitHour.compareTo(maxHour) >= 0) {
							end = true;
						}
					} while (!end);
				}
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

	public List<Candidate> getScheduleAppointmentForDoctor(CrmBranch branch,
			CrmDoctor doctor, int numApp, CrmProcedureDetail procedureDetail,
			Date selectedDate) {

		List<Candidate> result = new ArrayList<Candidate>();
		int id = 1;

		BigDecimal idBranch = branch.getId();
		String initDate = FacesUtil.formatDate(selectedDate, "yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selectedDate);
		calendar.add(Calendar.DATE, 60); // 60 Días
		String endDate = FacesUtil.formatDate(calendar.getTime(), "yyyy-MM-dd");

		List<CrmDoctorSchedule> listDoctorSchedule = dao
				.find("from CrmDoctorSchedule o where o.crmDoctor.id = "
						+ doctor.getId() + " and o.crmBranch.id = " + idBranch
						+ " order by o.day, o.startHour");

		// Validar si Doctor tiene Horario
		if (listDoctorSchedule.size() > 0) {

			// Buscar citas x doctor y sucursal
			List<CrmAppointment> listApp = dao
					.find("from CrmAppointment o where (o.startAppointmentDate between '"
							+ initDate
							+ "T00:00:00.000+05:00' and '"
							+ endDate
							+ "T23:59:59.999+05:00') and o.crmDoctor.id = "
							+ doctor.getId()
							+ " and o.state in (1,3,4,5) "
							+ "order by o.startAppointmentDate");

			// Buscar los festivos
			List<CrmHoliday> listHoliday = this.getListHoliday(idBranch);

			// Revisar Día a Día disponibilidad de Citas
			Date currentDate = selectedDate;
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

				String dateString = FacesUtil.formatDate(currentDate,
						"yyyy-MM-dd");

				List<CrmDoctorException> listDoctorException = dao
						.find("from CrmDoctorException o where o.crmDoctor.id = "
								+ doctor.getId()
								+ " and startHour >= '"
								+ dateString
								+ "T00:00:00.000+05:00' and startHour <= '"
								+ currentDate + "T23:59:59.999+05:00'");

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
								// de atencion del doctor salir
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
									validate = validateException(
											listDoctorException, currentDate,
											candidatesHours);

									if (FacesUtil
											.getDateWithoutTime(new Date())
											.compareTo(currentDate) == 0) {
										if (new Date().compareTo(initHour) > 0) {
											validate = false;
										}
									}
								}

								if (validate) {
									result.add(new Candidate(id, doctor,
											initHour, endHour,
											branch.getName(), procedureDetail
													.getName()));
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

	public List<Candidate> getScheduleAppointmentForDate(CrmBranch branch,
			Date selectedDate, CrmProcedureDetail procedureDetail) {
		List<Candidate> result = new ArrayList<Candidate>();

		String dateString = FacesUtil.formatDate(selectedDate, "yyyy-MM-dd");
		String timeString = FacesUtil.formatDate(selectedDate, "HH:mm:ss");
		String dateTimeString = FacesUtil.formatDate(selectedDate,
				"yyyy-MM-dd HH:mm:ss");
		BigDecimal idBranch = branch.getId();

		List<VwDoctorHour> listDoctorHour = dao
				.find("from VwDoctorHour o where o.id.idBranch = " + idBranch
						+ " and o.id.onlyDate = '" + dateString + "'");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selectedDate);
		int currentDay = calendar.get(Calendar.DAY_OF_WEEK);

		calendar.add(Calendar.MINUTE, procedureDetail.getTimeDoctor());
		Date endTime = calendar.getTime();

		List<CrmDoctor> listCrmDoctorWithoutApp = dao
				.find("select distinct c from CrmDoctorSchedule a inner join a.crmDoctor as c where a.day = "
						+ currentDay
						+ " and ('"
						+ timeString
						+ "' between a.startHour and a.endHour) "
						+ " and a.crmBranch.id = "
						+ idBranch
						+ " and a.crmDoctor.id not in (select b.crmDoctor.id from CrmAppointment b where cast(b.startAppointmentDate as date) = '"
						+ dateString + "')");

		if (listCrmDoctorWithoutApp.size() > 0) {
			CrmDoctor doctor = listCrmDoctorWithoutApp.get(0);
			result.add(new Candidate(1, doctor, selectedDate, endTime, branch
					.getName(), procedureDetail.getName()));
		} else {
			for (VwDoctorHour row : listDoctorHour) {

				List<CrmDoctorSchedule> listDoctorSchedule = dao
						.find("from CrmDoctorSchedule o where o.day = "
								+ currentDay + " and o.crmBranch.id = "
								+ idBranch + " and o.crmDoctor.id = "
								+ row.getId().getIdDoctor() + " and ('"
								+ timeString
								+ "' between o.startHour and o.endHour)");

				if (listDoctorSchedule.size() > 0) {
					List<CrmAppointment> listApp = dao
							.find("from CrmAppointment o where cast(o.startAppointmentDate as date) = '"
									+ dateString
									+ "' and ('"
									+ dateTimeString
									+ "' between o.startAppointmentDate and o.endAppointmentDate) and o.crmDoctor.id = "
									+ row.getId().getIdDoctor()
									+ " and o.crmBranch.id = "
									+ idBranch
									+ " and o.state in (1,3,4,5) "
									+ "order by o.startAppointmentDate");

					if (listApp.size() == 0) {
						CrmDoctor doctor = (CrmDoctor) dao.find(
								"from CrmDoctor o where o.id = "
										+ row.getId().getIdDoctor()).get(0);
						result.add(new Candidate(1, doctor, selectedDate,
								endTime, branch.getName(), procedureDetail
										.getName()));
						break;
					} else {
						// Iterar Horas Candidatas
						List<Date> candidatesHours = getListcandidatesHours(
								selectedDate, endTime);

						boolean validate = validateAvailabilitySchedule(
								candidatesHours, listApp, selectedDate);

						if (validate) {
							CrmDoctor doctor = (CrmDoctor) dao.find(
									"from CrmDoctor o where o.id = "
											+ row.getId().getIdDoctor()).get(0);
							result.add(new Candidate(1, doctor, selectedDate,
									endTime, branch.getName(), procedureDetail
											.getName()));
							break;
						}
					}

				}
			}
		}

		return result;
	}

	private int validateDuplicated(String patient, Date startDate, Date endDate) {
		String dateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd");
		String startHourString = FacesUtil.formatDate(startDate, "HH:mm:ss");
		String endHourString = FacesUtil.formatDate(endDate, "HH:mm:ss");

		List<CrmAppointment> listApp = dao
				.find("from CrmAppointment o where o.startAppointmentDate >= '"
						+ dateString + "T" + startHourString
						+ ".000+05:00' and o.startAppointmentDate <= '"
						+ dateString + "T" + endHourString
						+ ".000+05:00' and o.patientSap = '" + patient
						+ "' and o.state in (1,3,4,5)"
						+ "order by o.startAppointmentDate");

		return listApp.size();
	}

	private boolean validateException(
			List<CrmDoctorException> listDoctorException, Date currentDate,
			List<Date> candidatesHours) {

		boolean result = true;

		int count = 0;
		List<Date> ocupatedHours = new ArrayList<Date>();
		for (CrmDoctorException row : listDoctorException) {
			Date dateRow = FacesUtil.getDateWithoutTime(row.getStartHour());
			if (currentDate.getTime() == dateRow.getTime()) {
				long diff = row.getEndHour().getTime()
						- row.getStartHour().getTime();
				double diffInMin = diff / ((double) 1000 * 60);
				int size = (int) (diffInMin / Constant.INTERVAL_TIME_APPOINTMENT) + 1;
				ocupatedHours.add(new Date(row.getStartHour().getTime()));
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

		}

		return result;
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
		List<CrmHoliday> listHoliday = this.getListHoliday(idBranch);

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
									+ " and o. state in (1,3,4,5) "
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
		list = dao.find("from CrmAppointment o where o.patientSap = '"
				+ patient + "' and o.state = " + state
				+ " order by o.startAppointmentDate desc");
		return list;
	}

	public List<CrmAppointment> listAppointmentByPatient(String patient,
			int state, Date startDate, Date endDate) {

		String startDateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd");
		String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd");
		String stateString;

		if (state == -1) {
			stateString = "o.state";
		} else {
			stateString = String.valueOf(state);
		}

		List<CrmAppointment> list = dao
				.find("from CrmAppointment o where (o.startAppointmentDate between '"
						+ startDateString
						+ "T00:00:00.000+05:00' and '"
						+ endDateString
						+ "T23:59:59.999+05:00') and o.patientSap = '"
						+ patient
						+ "' and o.state = "
						+ stateString
						+ " order by o.startAppointmentDate desc");

		return list;
	}

	public List<CrmAppointment> getListAppointmentByCriteria(String where) {
		List<CrmAppointment> list = dao.find(where
				+ " order by o.startAppointmentDate asc");

		return list;
	}

	public CrmDoctor getCrmDoctor() {
		BigDecimal idUser = FacesUtil.getCurrentUser().getId();
		List<CrmDoctor> list = dao
				.find("from CrmDoctor o where o.crmUser.id = " + idUser);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public int savePatient(CrmPatient entity) {
		if (entity.getId() == null) {
			BigDecimal id = getId(CrmPatient.class);
			entity.setId(id);
		}
		return dao.persist(entity);
	}

	public List<CrmPatient> getListPatientByNameOrDoc(String field, String value) {
		List<CrmPatient> list = null;

		if (field.equals("DOC")) {
			list = dao.find("from CrmPatient o where doc = '" + value + "'");
		} else {
			list = dao.find("from CrmPatient o where o.firstnames like '%"
					+ value + "%' or o.surnames like '%" + value + "%'");
		}

		return list;
	}

	public CrmPatient getPatientByDoc(String doc) {
		List<CrmPatient> list = null;
		list = dao.find("from CrmPatient o where o.doc = '" + doc + "'");
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmPatient();
		}
	}

	public CrmPatient getPatientByCodeSap(String codeSap) {
		List<CrmPatient> list = null;
		list = dao
				.find("from CrmPatient o where o.codeSap = '" + codeSap + "'");
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmPatient();
		}
	}

	public CrmHistoryHistory getHistoryHistory(BigDecimal idPatient) {
		List<CrmHistoryHistory> list = null;
		list = dao.find("from CrmHistoryHistory o where o.crmPatient.id = "
				+ idPatient);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryHistory();
		}
	}

	public CrmHistoryRecord getHistoryRecord(BigDecimal idPatient) {
		List<CrmHistoryRecord> list = null;
		list = dao.find("from CrmHistoryRecord o where o.crmPatient.id = "
				+ idPatient);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryRecord();
		}
	}

	public CrmHistoryHomeopathic getHistoryHomeopathic(BigDecimal idPatient) {
		List<CrmHistoryHomeopathic> list = null;
		list = dao.find("from CrmHistoryHomeopathic o where o.crmPatient.id = "
				+ idPatient);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryHomeopathic();
		}
	}

	public CrmHistoryPhysique getHistoryPhysique(BigDecimal idPatient) {
		List<CrmHistoryPhysique> list = null;
		list = dao.find("from CrmHistoryPhysique o where o.crmPatient.id = "
				+ idPatient);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryPhysique();
		}
	}

	public CrmHistoryOrganometry getHistoryOrganometry(BigDecimal idPatient) {
		List<CrmHistoryOrganometry> list = null;
		list = dao.find("from CrmHistoryOrganometry o where o.crmPatient.id = "
				+ idPatient);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryOrganometry();
		}
	}

	public Long getDocAutomatic(String country) {
		List<Long> list = null;
		list = dao.find("select count(*) from CrmPatient o where o.country = '"
				+ country + "'");
		if (list.size() > 0) {
			return list.get(0) + 1;
		} else {
			return 1L;
		}
	}

	public int saveHistoryRecord(CrmHistoryRecord entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryRecord.class));
		}
		return dao.persist(entity);
	}

	public int saveHistoryHistory(CrmHistoryHistory entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryHistory.class));
		}
		return dao.persist(entity);
	}

	public int saveHistoryHomeopathic(CrmHistoryHomeopathic entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryHomeopathic.class));
		}
		return dao.persist(entity);
	}

	public int saveHistoryPhysique(CrmHistoryPhysique entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryPhysique.class));
		}
		return dao.persist(entity);
	}

	public int saveHistoryOrganometry(CrmHistoryOrganometry entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryOrganometry.class));
		}
		return dao.persist(entity);
	}

	public Integer saveDiagnosis(CrmAppointment entity, List<CrmDiagnosis> list) {
		int i = 0;

		dao.executeHQL("delete from CrmDiagnosis o where o.crmAppointment.id = "
				+ entity.getId());

		for (CrmDiagnosis row : list) {
			row.setId(getId(CrmDiagnosis.class));
			dao.persist(row);
		}

		return i;
	}

}