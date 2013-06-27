package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCaseStudy;
import co.com.tactusoft.crm.model.entities.CrmCie;
import co.com.tactusoft.crm.model.entities.CrmCieMaterial;
import co.com.tactusoft.crm.model.entities.CrmConsent;
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
import co.com.tactusoft.crm.model.entities.CrmMaterialGroup;
import co.com.tactusoft.crm.model.entities.CrmMedication;
import co.com.tactusoft.crm.model.entities.CrmNote;
import co.com.tactusoft.crm.model.entities.CrmNurse;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.model.entities.VwTherapyMaterials;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Candidate;
import co.com.tactusoft.crm.view.beans.ResultSearchAppointment;

@Named
public class ProcessBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public List<CrmAppointment> getListAppointment() {
		return dao.find("from CrmAppointment");
	}

	public CrmAppointment getAppointment(BigDecimal id) {
		return (CrmAppointment) dao
				.find("from CrmAppointment where id = " + id).get(0);
	}

	public List<VwAppointment> getListVwAppointmentByHistory(BigDecimal idDoctor) {
		String startDateString = FacesUtil.formatDate(new Date(), "yyyy-MM-dd")
				+ " 00:00:00";
		String endDateString = FacesUtil.formatDate(new Date(), "yyyy-MM-dd")
				+ " 23:59:59";
		return dao.find("from VwAppointment o where o.doctorId = " + idDoctor
				+ " and ((o.startAppointmentDate >= '" + startDateString
				+ "' and o.endAppointmentDate <= '" + endDateString
				+ "') and closeAppointment = 0 or (o.startAppointmentDate < '"
				+ startDateString
				+ "' and closeAppointment = 0)) and o.state in (3,4) "
				+ "order by o.startAppointmentDate");
	}

	public List<VwAppointment> getListVwAppointmentByBranch(BigDecimal branchId) {
		String startDateString = FacesUtil.formatDate(new Date(), "yyyy-MM-dd")
				+ " 00:00:00";
		String endDateString = FacesUtil.formatDate(new Date(), "yyyy-MM-dd")
				+ " 23:59:59";
		return dao.find("from VwAppointment o where o.branchId = " + branchId
				+ " and ((o.startAppointmentDate >= '" + startDateString
				+ "' and o.endAppointmentDate <= '" + endDateString
				+ "') and closeAppointment = 0 or (o.startAppointmentDate < '"
				+ startDateString
				+ "' and closeAppointment = 0)) and o.state in (3,4) "
				+ "order by o.startAppointmentDate");
	}

	public List<VwAppointment> getListVwAppointmentByDoctor(BigDecimal idDoctor) {
		Date startDate = FacesUtil.addDaysToDate(new Date(), -30);
		Date endDate = FacesUtil.addDaysToDate(new Date(), 30);

		String startDateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd")
				+ " 00:00:00";
		String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd")
				+ " 23:59:59";
		return dao.find("from VwAppointment o where o.doctorId = " + idDoctor
				+ " and o.startAppointmentDate >= '" + startDateString
				+ "' and o.endAppointmentDate <= '" + endDateString
				+ "' order by o.startAppointmentDate");
	}

	public List<VwAppointment> getListVwAppointmentByDoctorToday(
			BigDecimal idDoctor) {
		return dao.find("from VwAppointment o where o.doctorId = " + idDoctor
				+ " order by o.startAppointmentDate");
	}

	public List<CrmAppointment> getListAppointmentByDoctorWithOutUntimely(
			BigDecimal idDoctor) {
		return dao.find("from CrmAppointment o where o.crmDoctor.id = "
				+ idDoctor
				+ " and o.untimely = 0 order by o.startAppointmentDate");
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
		return dao
				.find("from CrmAppointment o where o.crmDoctor.id = "
						+ idDoctor
						+ " and o.state = 1 order by o.startAppointmentDate");
	}

	public List<VwAppointment> getListVwAppointmentByBranch(
			BigDecimal idBranch, Date startDate, Date endDate) {

		String startDateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd")
				+ " 00:00:00";
		String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd")
				+ " 23:59:59";

		return dao.find("from VwAppointment o where o.branchId = " + idBranch
				+ " and o.startAppointmentDate >= '" + startDateString
				+ "' and o.endAppointmentDate <= '" + endDateString
				+ "' order by o.startAppointmentDate");
	}

	public List<VwAppointment> getListAppointmentByBranchDoctor(
			BigDecimal idBranch, BigDecimal idDoctor, Date startDate,
			Date endDate) {
		String startDateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd")
				+ " 00:00:00";
		String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd")
				+ " 23:59:59";
		return dao.find("from VwAppointment o where o.branchId = " + idBranch
				+ " and o.doctorId = " + idDoctor
				+ " and o.startAppointmentDate >= '" + startDateString
				+ "' and o.endAppointmentDate <= '" + endDateString
				+ "' order by o.startAppointmentDate");
	}

	public List<VwAppointment> getListVwAppointmentByDoctor(CrmDoctor doctor,
			Date startDate) {

		String startDateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd");

		List<VwAppointment> list = dao
				.find("from VwAppointment o where o.startAppointmentDate >= '"
						+ startDateString
						+ "T00:00:00.000+05:00' and o.doctorId = '"
						+ doctor.getId() + "' and o.state in (1,3,4,5) "
						+ " order by o.startAppointmentDate desc");

		return list;
	}

	public List<VwAppointment> getListByAppointmentByPatient(
			BigDecimal idPatient) {
		return dao
				.find("from VwAppointment o where o.patId = "
						+ idPatient
						+ " and o.state in (3,4,5) order by o.startAppointmentDate DESC");
	}

	public List<CrmCie> getListCieByCode(String code) {
		return dao.find("from CrmCie o where o.code like '%" + code
				+ "%' order by o.description");
	}

	public List<CrmCie> getListCieByName(String name) {
		return dao.find("from CrmCie o where o.description like '%" + name
				+ "%' order by o.description");
	}

	public List<CrmMaterialGroup> getListMaterialGroup() {
		return dao.find("from CrmMaterialGroup");
	}

	public List<CrmCieMaterial> getListCieMaterial() {
		return dao.find("from CrmCieMaterial");
	}

	public CrmAppointment saveAppointment(CrmAppointment entity) {
		if (entity.getId() == null) {
			BigDecimal id = getId(CrmAppointment.class);
			entity.setId(id);
			String code = "C" + FacesUtil.lpad(id.toString(), '0', 5);
			entity.setCode(code);
		}

		this.persist(entity);
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

	public List<CrmHoliday> getListHoliday(Date date, BigDecimal idBranch) {
		String currenDate = FacesUtil.formatDate(date, "yyyy-MM-dd");
		return dao
				.find("select o.crmHoliday from CrmHolidayBranch o where o.crmHoliday.holiday = '"
						+ currenDate + "' and o.crmBranch.id = " + idBranch);
	}

	private boolean validateHoliday(List<CrmHoliday> list, Date date) {
		for (CrmHoliday row : list) {
			if (row.getHoliday().compareTo(date) == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean validateException(
			List<CrmDoctorException> listDoctorException, Date date) {
		for (CrmDoctorException row : listDoctorException) {
			if (date.compareTo(row.getStartHour()) >= 0
					&& date.compareTo(row.getEndHour()) <= 0) {
				return false;
			}
		}

		return true;
	}

	private boolean validateException(
			List<CrmDoctorException> listDoctorException, Date date,
			CrmDoctor crmDoctor) {
		for (CrmDoctorException row : listDoctorException) {
			if (date.compareTo(row.getStartHour()) >= 0
					&& date.compareTo(row.getEndHour()) <= 0
					&& row.getCrmDoctor().getId().intValue() == crmDoctor
							.getId().intValue()) {
				return false;
			}
		}

		return true;
	}

	private boolean validateAvailabilitySchedule(List<Date> candidatesHours,
			List<CrmAppointment> listApp, Date currentDate, String timeType) {

		boolean result = true;
		int numApp = 0;

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
					ocupatedHours.add(FacesUtil.addMinutesToDate(
							ocupatedHours.get(count - 1),
							Constant.INTERVAL_TIME_APPOINTMENT));
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

			if (contValidate > 2) {
				if (timeType.equals(Constant.TIME_TYPE_DOCTOR)) {
					result = false;
					break;
				} else {
					numApp++;
					if (numApp == app.getCrmBranch().getStretchers()) {
						result = false;
						break;
					}
				}
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
			ocupatedHours.add(FacesUtil.addMinutesToDate(
					ocupatedHours.get(count - 1),
					Constant.INTERVAL_TIME_APPOINTMENT));
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

		if (contValidate > 2) {
			result = false;
		}

		return result;
	}

	public List<Candidate> getListOccupatedHours(Date currentDate,
			BigDecimal idBranch) {
		List<Candidate> result = new ArrayList<Candidate>();

		// Validar Festivo
		List<CrmHoliday> listHoliday = getListHoliday(currentDate, idBranch);
		if (listHoliday.size() == 0) {

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(currentDate);
			int currentDay = calendar.get(Calendar.DAY_OF_WEEK);

			if (currentDay != 1) {// Si no es domingo

				List<CrmDoctorSchedule> listCrmDoctorSchedule = dao
						.find("from CrmDoctorSchedule o where o.crmBranch.id = "
								+ idBranch
								+ " and o.day = "
								+ currentDay
								+ " and o.crmDoctor.id <> 0 and o.crmDoctor.state = 1");

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

					String dateString = FacesUtil.formatDate(currentDate,
							"yyyy-MM-dd");
					// Buscar Citas
					List<CrmAppointment> listApp = dao
							.find("from CrmAppointment o where (o.startAppointmentDate between '"
									+ dateString
									+ "T00:00:00.000+05:00' and '"
									+ dateString
									+ "T23:59:59.999+05:00') and o.state in (1,3,4,5) and o.crmBranch.id = "
									+ idBranch
									+ " and o.crmProcedureDetail.availability = TRUE order by o.startAppointmentDate");

					boolean end = false;
					Date scheduleInitHour = minHour;

					do {
						int numInteractions = 0;
						int numApp = 0;

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
							calendar.add(Calendar.MINUTE, 15);
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
									numApp++;
								}
							}

							if (numApp >= numInteractions) {
								Date time = FacesUtil.addHourToDate(
										currentDate, scheduleInitHour);
								Candidate candidate = new Candidate();
								candidate.setStartDate(time);
								candidate.setEndDate(scheduleEndHour);
								result.add(candidate);
							}
						}
						calendar = Calendar.getInstance();
						calendar.setTime(scheduleInitHour);
						calendar.add(Calendar.MINUTE, 15);
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

	public ResultSearchAppointment getScheduleAppointmentForDoctor(
			CrmBranch branch, CrmDoctor doctor, int numApp,
			CrmProcedureDetail procedureDetail, Date selectedDate) {

		List<Candidate> result = new ArrayList<Candidate>();
		String message = null;
		int id = 1;
		int maxDates = 60;
		int countDates = 0;

		int minutes = 0;
		if ((procedureDetail.getTimeDoctor() > procedureDetail.getTimeNurses())
				&& (procedureDetail.getTimeDoctor() > procedureDetail
						.getTimeStretchers())) {
			minutes = procedureDetail.getTimeDoctor();
		} else if ((procedureDetail.getTimeNurses() > procedureDetail
				.getTimeDoctor())
				&& (procedureDetail.getTimeNurses() > procedureDetail
						.getTimeStretchers())) {
			minutes = procedureDetail.getTimeNurses();
		} else {
			minutes = procedureDetail.getTimeStretchers();
		}

		BigDecimal idBranch = branch.getId();
		String initDate = FacesUtil.formatDate(selectedDate, "yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(selectedDate);
		calendar.add(Calendar.DATE, 60); // 60 Días
		String endDate = FacesUtil.formatDate(calendar.getTime(), "yyyy-MM-dd");

		List<CrmDoctorSchedule> listDoctorSchedule = dao
				.find("from CrmDoctorSchedule o where o.crmDoctor.id = "
						+ doctor.getId()
						+ " and o.crmBranch.id = "
						+ idBranch
						+ "  and o.crmDoctor.state = 1 and o.day !=1 order by o.day, o.startHour");

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
							+ " and o.state in (1,3,4,5) and o.crmProcedureDetail.availability = TRUE "
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
				countDates++;

				String dateString = FacesUtil.formatDate(currentDate,
						"yyyy-MM-dd");

				List<CrmDoctorException> listDoctorException = dao
						.find("from CrmDoctorException o where o.crmDoctor.id = "
								+ doctor.getId()
								+ " and '"
								+ dateString
								+ "' between Date(startHour) and Date(endHour)"
								+ " and (o.crmBranch.id is null OR o.crmBranch.id = "
								+ idBranch + ")");

				if ((calendar.get(Calendar.DAY_OF_WEEK) != 1)
						&& (this.validateHoliday(listHoliday, currentDate))
						&& (this.validateException(listDoctorException,
								currentDate))) {
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
								calendar2.add(Calendar.MINUTE, minutes);
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
										candidatesHours, listApp, currentDate,
										Constant.TIME_TYPE_DOCTOR);

								if (validate) {
									validate = validateException(
											listDoctorException, initHour);

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
								initHour = FacesUtil.addMinutesToDate(initHour,
										Constant.INCREASE_MIN);
							}
						}
					}
				} else {
					message = FacesUtil.getMessage("app_msg_error_1");
				}

				// Máximo días de busqueda
				if (countDates == maxDates) {
					break outer;
				}
			}
		}

		ResultSearchAppointment resultSearchAppointment = new ResultSearchAppointment();
		resultSearchAppointment.setListCandidate(result);
		resultSearchAppointment.setMessage(message);

		return resultSearchAppointment;
	}

	public ResultSearchAppointment getScheduleAppointmentForDate(
			CrmBranch branch, Date date, CrmProcedureDetail procedureDetail,
			int minutes, String timeType, int appointmentsNumber) {
		List<Candidate> result = new ArrayList<Candidate>();
		String message = null;

		BigDecimal idBranch = branch.getId();
		Date currentDate = FacesUtil.getDateWithoutTime(date);

		int id = 0;
		out: do {
			String dateString = FacesUtil.formatDate(currentDate, "yyyy-MM-dd");

			// Validar Festivo
			List<CrmHoliday> listHoliday = getListHoliday(currentDate, idBranch);
			if (listHoliday.size() == 0) {
				int currentDay = FacesUtil.getDayOfWeek(currentDate);
				if (currentDay != 1) {// Si no es domingo
					// Buscar horarios
					List<CrmDoctorSchedule> listCrmDoctorSchedule = dao
							.find("FROM CrmDoctorSchedule o WHERE o.crmBranch.id = "
									+ idBranch
									+ " AND o.day = "
									+ currentDay
									+ " AND o.crmDoctor.state = 1 ORDER BY o.startHour");

					if (listCrmDoctorSchedule.size() > 0) {
						List<CrmDoctorException> listDoctorException = dao
								.find("FROM CrmDoctorException o WHERE o.crmDoctor.state = 1 AND '"
										+ dateString
										+ "' between Date(startHour) AND Date(endHour)"
										+ " AND (o.crmBranch.id is null OR o.crmBranch.id = "
										+ idBranch + ")");

						for (CrmDoctorSchedule schedule : listCrmDoctorSchedule) {
							String startDateScheduleString = FacesUtil
									.formatDate(FacesUtil.addHourToDate(
											currentDate,
											schedule.getStartHour()),
											"yyyy-MM-dd HH:mm:ss");

							String endDateScheduleString = FacesUtil
									.formatDate(
											FacesUtil.addHourToDate(
													currentDate,
													schedule.getEndHour()),
											"yyyy-MM-dd HH:mm:ss");

							// Buscar Citas
							List<CrmAppointment> listApp = new ArrayList<CrmAppointment>();
							if (procedureDetail.isAvailability()) {
								listApp = dao
										.find("FROM CrmAppointment o WHERE (o.startAppointmentDate between '"
												+ startDateScheduleString
												+ "' AND '"
												+ endDateScheduleString
												+ "') AND o.state in (1,3,4,5) AND "
												+ " o.crmProcedureDetail.availability = TRUE and o.crmBranch.id = "
												+ idBranch
												+ "AND o.crmDoctor.id = "
												+ schedule.getCrmDoctor()
														.getId()
												+ " ORDER BY o.startAppointmentDate");
							}

							Date scheduleInitHour = FacesUtil.addHourToDate(
									currentDate, schedule.getStartHour());

							Date maxHour = FacesUtil.addHourToDate(currentDate,
									schedule.getEndHour());

							boolean exit = false;
							do {
								Date scheduleEndHour = FacesUtil
										.addMinutesToDate(scheduleInitHour,
												minutes);

								if (scheduleEndHour.compareTo(maxHour) > 0) {
									break;
								}

								List<Date> candidatesHours = getListcandidatesHours(
										scheduleInitHour, scheduleEndHour);

								boolean validateException = validateException(
										listDoctorException, scheduleInitHour,
										schedule.getCrmDoctor());

								if (validateException) {
									boolean validate = true;
									for (CrmAppointment row : listApp) {
										validate = validateAvailabilitySchedule(
												candidatesHours,
												row.getStartAppointmentDate(),
												row.getEndAppointmentDate());

										if (!validate) {
											validate = false;
											break;
										}
									}

									if (validate
											&& new Date()
													.compareTo(scheduleInitHour) <= 0) {
										result.add(new Candidate(id, schedule
												.getCrmDoctor(),
												scheduleInitHour,
												scheduleEndHour, branch
														.getName(),
												procedureDetail.getName()));
										id++;
									}
								}

								scheduleInitHour = FacesUtil
										.addMinutesToDate(scheduleInitHour,
												Constant.INCREASE_MIN);

								if (id == appointmentsNumber) {
									break out;
								}

							} while (!exit);

							if (id == appointmentsNumber) {
								break out;
							}
						}
					}
				}
			}
			currentDate = FacesUtil.addDaysToDate(currentDate, 1);
		} while (id < appointmentsNumber);

		ResultSearchAppointment resultSearchAppointment = new ResultSearchAppointment();
		resultSearchAppointment.setListCandidate(result);
		resultSearchAppointment.setMessage(message);

		return resultSearchAppointment;
	}

	private int validateDuplicated(BigDecimal idPatient, Date startDate,
			Date endDate) {
		String dateString = FacesUtil.formatDate(startDate, "yyyy-MM-dd");
		String startHourString = FacesUtil.formatDate(startDate, "HH:mm:ss");
		String endHourString = FacesUtil.formatDate(endDate, "HH:mm:ss");

		List<CrmAppointment> listApp = dao
				.find("from CrmAppointment o where o.startAppointmentDate >= '"
						+ dateString
						+ "T"
						+ startHourString
						+ ".000+05:00' and o.startAppointmentDate <= '"
						+ dateString
						+ "T"
						+ endHourString
						+ ".000+05:00' and o.crmPatient.id = "
						+ idPatient
						+ " and o.state in (1,3,4,5) and o.crmProcedureDetail.availability = TRUE "
						+ "order by o.startAppointmentDate");

		return listApp.size();
	}

	public int validateAppointmentForDate(BigDecimal idBranch, Date starDate,
			Date endDate, CrmProcedureDetail procedureDetail,
			BigDecimal idDoctor, BigDecimal idPatient, String timeType,
			Boolean edit) {

		int result = 0;

		if (!edit) {
			// Validar si Paciente tiene otra cita
			result = validateDuplicated(idPatient, starDate, endDate);
			if (result > 0) {
				return -4;
			}
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
					.find("from CrmDoctorSchedule o where o.day = "
							+ day
							+ " and o.crmDoctor.id = "
							+ idDoctor
							+ " AND o.crmBranch.id = "
							+ idBranch
							+ " AND '"
							+ hourString
							+ "' BETWEEN o.startHour AND o.endHour order by o.day, o.startHour");

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
									+ " and o. state in (1,3,4,5) and o.crmProcedureDetail.availability = TRUE "
									+ "order by o.startAppointmentDate");

					// Validar Disponibilidad
					boolean validate = validateAvailabilitySchedule(
							candidatesHours, listApp, currentDate, timeType);

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

	public List<CrmAppointment> listAppointmentByPatient(BigDecimal idPatient,
			int state) {
		List<CrmAppointment> list = new ArrayList<CrmAppointment>();
		list = dao.find("from CrmAppointment o where o.crmPatient.id = "
				+ idPatient + " and o.state = " + state
				+ " order by o.startAppointmentDate desc");
		return list;
	}

	public List<CrmAppointment> listAppointmentByPatient(BigDecimal idPatient,
			String state) {
		List<CrmAppointment> list = new ArrayList<CrmAppointment>();
		list = dao.find("from CrmAppointment o where o.crmPatient.id = "
				+ idPatient + " and o.state in (" + state
				+ ") order by o.startAppointmentDate desc");
		return list;
	}

	public List<CrmAppointment> listAppointmentByPatient(BigDecimal idPatient,
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
						+ "T23:59:59.999+05:00') and o.crmPatient.id = "
						+ idPatient
						+ " and o.state = "
						+ stateString
						+ " order by o.startAppointmentDate desc");

		return list;
	}

	public List<VwAppointment> getListAppointmentByCriteria(String where) {
		List<VwAppointment> list = dao.find(where
				+ " order by o.startAppointmentDate asc");
		return list;
	}

	public CrmDoctor getCrmDoctor() {
		BigDecimal idUser = FacesUtil.getCurrentUser().getId();
		List<CrmDoctor> list = dao
				.find("from CrmDoctor o where o.state = 1 and o.crmUser.id = "
						+ idUser);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public CrmNurse getCrmNurse() {
		BigDecimal idUser = FacesUtil.getCurrentUser().getId();
		List<CrmNurse> list = dao
				.find("from CrmNurse o where o.state = 1 and o.crmUser.id = "
						+ idUser);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public CrmAppointment getFirstAppointmentbyPatient(BigDecimal idPatient) {
		List<CrmAppointment> list = dao
				.find("FROM CrmAppointment o WHERE o.crmPatient.id = "
						+ idPatient
						+ " AND state IN (3,4) ORDER BY o.startAppointmentDate",
						1);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<CrmCie> getListCieByPatient(BigDecimal idPatient) {
		List<CrmCie> list = dao
				.find("SELECT o.crmCie FROM CrmDiagnosis o WHERE o.crmAppointment.crmPatient.id = "
						+ idPatient + " ORDER BY o.crmCie.description");
		return list;
	}

	public List<String> getListHistoryByPatient(BigDecimal idPatient) {
		List<String> list = dao
				.find("SELECT o.reason FROM CrmHistoryHistory o WHERE o.crmAppointment.crmPatient.id = "
						+ idPatient + " ORDER BY o.reason");
		return list;
	}

	public int savePatient(CrmPatient entity, boolean automatic,
			boolean existsSAP, String country) {
		if (entity.getId() == null) {
			BigDecimal id = getId(CrmPatient.class);
			if (automatic) {
				String doc = country + FacesUtil.lpad(id.toString(), '0', 8);
				entity.setDoc(doc);
				entity.setCodeSap(doc);
			} else {
				if (!existsSAP) {
					entity.setCodeSap(entity.getDoc());
				}
			}
			entity.setId(id);
		}
		return this.persist(entity);
	}

	public void removePatient(BigDecimal id) {
		dao.executeHQL("delete from CrmPatient o where o.id = " + id);
	}

	public List<CrmPatient> getListPatientByField(String field, String value) {
		List<CrmPatient> list = null;

		if (field.equals("DOC")) {
			list = dao.find("FROM CrmPatient o WHERE doc = '" + value + "'");
		} else if (field.equals("NAMES")) {
			list = dao.find("FROM CrmPatient o WHERE o.firstnames LIKE '%"
					+ value + "%' or o.surnames LIKE '%" + value
					+ "%' OR UPPER(firstnames || ' ' || surnames) LIKE '%"
					+ value
					+ "%' OR UPPER(surnames || ' ' || firstnames) LIKE '%"
					+ value + "%'");
		} else if (field.equals("PHONE")) {
			list = dao.find("FROM CrmPatient o WHERE phoneNumber = '" + value
					+ "' OR cellNumber = '" + value + "'");
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

	public CrmHistoryHistory getHistoryHistory(BigDecimal idAppointment) {
		List<CrmHistoryHistory> list = null;
		list = dao.find("from CrmHistoryHistory o where o.crmAppointment.id = "
				+ idAppointment);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryHistory();
		}
	}

	public List<CrmHistoryHistory> getListHistoryHistory(BigDecimal idPatient) {
		return dao.find("from CrmHistoryHistory o where o.crmPatient.id = "
				+ idPatient);
	}

	public CrmHistoryRecord getHistoryRecord(BigDecimal idAppointment) {
		List<CrmHistoryRecord> list = null;
		list = dao.find("from CrmHistoryRecord o where o.crmAppointment.id = "
				+ idAppointment);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryRecord();
		}
	}

	public List<CrmHistoryRecord> getListHistoryRecord(BigDecimal idPatient) {
		return dao.find("from CrmHistoryRecord o where o.crmPatient.id = "
				+ idPatient);
	}

	public CrmHistoryHomeopathic getHistoryHomeopathic(BigDecimal idAppointment) {
		List<CrmHistoryHomeopathic> list = null;
		list = dao
				.find("from CrmHistoryHomeopathic o where o.crmAppointment.id = "
						+ idAppointment);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryHomeopathic();
		}
	}

	public List<CrmHistoryHomeopathic> getListHistoryHomeopathic(
			BigDecimal idPatient) {
		return dao.find("from CrmHistoryHomeopathic o where o.crmPatient.id = "
				+ idPatient);
	}

	public CrmHistoryPhysique getHistoryPhysique(BigDecimal idAppointment) {
		List<CrmHistoryPhysique> list = null;
		list = dao
				.find("from CrmHistoryPhysique o where o.crmAppointment.id = "
						+ idAppointment);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryPhysique();
		}
	}

	public List<CrmHistoryPhysique> getListHistoryPhysique(BigDecimal idPatient) {
		return dao.find("from CrmHistoryPhysique o where o.crmPatient.id = "
				+ idPatient);
	}

	public CrmHistoryOrganometry getHistoryOrganometry(BigDecimal idAppointment) {
		List<CrmHistoryOrganometry> list = null;
		list = dao
				.find("from CrmHistoryOrganometry o where o.crmAppointment.id = "
						+ idAppointment);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmHistoryOrganometry();
		}
	}

	public List<CrmHistoryOrganometry> getListHistoryOrganometry(
			BigDecimal idPatient) {
		return dao.find("from CrmHistoryOrganometry o where o.crmPatient.id = "
				+ idPatient);
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
		return this.persist(entity);
	}

	public int saveHistoryHistory(CrmHistoryHistory entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryHistory.class));
		}
		return this.persist(entity);
	}

	public int saveHistoryHomeopathic(CrmHistoryHomeopathic entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryHomeopathic.class));
		}
		return this.persist(entity);
	}

	public int saveHistoryPhysique(CrmHistoryPhysique entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryPhysique.class));
		}
		return this.persist(entity);
	}

	public int saveHistoryOrganometry(CrmHistoryOrganometry entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmHistoryOrganometry.class));
		}
		return this.persist(entity);
	}

	public Integer saveDiagnosis(CrmAppointment entity, List<CrmDiagnosis> list) {
		int i = 0;

		dao.executeHQL("delete from CrmDiagnosis o where o.crmAppointment.id = "
				+ entity.getId());

		for (CrmDiagnosis row : list) {
			row.setId(getId(CrmDiagnosis.class));
			this.persist(row);
		}

		return i;
	}

	public Integer saveMedication(CrmAppointment entity,
			List<CrmMedication> list, String materialType) {
		int i = 0;

		dao.executeHQL("delete from CrmMedication o where o.crmAppointment.id = "
				+ entity.getId()
				+ " and o.materialType = '"
				+ materialType
				+ "'");

		for (CrmMedication row : list) {
			row.setId(getId(CrmMedication.class));
			this.persist(row);
		}

		return i;
	}

	public Integer saveNotes(CrmNote entity) {
		entity.setId(getId(CrmNote.class));
		return this.persist(entity);
	}

	public Integer saveStudyCase(CrmCaseStudy entity, BigDecimal idDiagnosis) {
		CrmCie crmCie = new CrmCie();
		crmCie.setId(idDiagnosis);
		entity.setCrmCie(crmCie);
		return this.persist(entity);
	}

	public List<CrmDiagnosis> getListDiagnosisByPatient(BigDecimal idPatient) {
		List<CrmDiagnosis> list = dao
				.find("from CrmDiagnosis o where o.crmAppointment.crmPatient.id = "
						+ idPatient
						+ " order by o.crmAppointment.startAppointmentDate desc");
		return list;
	}

	public List<CrmDiagnosis> getListDiagnosisByAppointment(
			BigDecimal idAppointment) {
		List<CrmDiagnosis> list = dao
				.find("from CrmDiagnosis o where o.crmAppointment.id = "
						+ idAppointment + " order by o.id");
		return list;
	}

	public List<CrmMedication> getListMedicationByPatient(BigDecimal idPatient) {
		List<CrmMedication> list = dao
				.find("from CrmMedication o where o.crmAppointment.crmPatient.id = "
						+ idPatient
						+ " order by o.crmAppointment.startAppointmentDate desc");
		return list;
	}

	public List<CrmMedication> getListMedicationByAppointment(
			BigDecimal idAppointment, String materialType) {
		List<CrmMedication> list = dao
				.find("from CrmMedication o where o.crmAppointment.id = "
						+ idAppointment + " and materialType = '"
						+ materialType + "' order by o.id");
		return list;
	}

	public List<CrmNote> getListNoteByPatient(BigDecimal idPatient) {
		List<CrmNote> list = dao.find("from CrmNote o where o.crmPatient.id = "
				+ idPatient + " order by o.noteDate desc");
		return list;
	}

	public List<CrmConsent> getListConsentByPatient(BigDecimal idPatient) {
		List<CrmConsent> list = dao
				.find("from CrmConsent o where o.crmPatient.id = " + idPatient
						+ " order by o.dateInformed desc");
		return list;
	}

	public List<CrmCaseStudy> getListSuccessStoryByPatient(BigDecimal idPatient) {
		List<CrmCaseStudy> list = dao
				.find("from CrmCaseStudy o where o.crmAppointment.crmPatient.id = "
						+ idPatient + " order by o.id desc");
		return list;
	}

	public Date getMaxDateByProcedure(BigDecimal idPatient,
			BigDecimal idProcedureDetail) {
		Date result = null;
		List<Date> list = dao
				.find("select max(o.startAppointmentDate) from CrmAppointment o where o.crmPatient.id = "
						+ idPatient
						+ " and o.crmProcedureDetail.id = "
						+ idProcedureDetail + " and o.state in (1,3,4)");

		if (list.size() > 0) {
			result = list.get(0);
		}

		return result;
	}

	public CrmPatient getContactById(BigDecimal id) {
		List<CrmPatient> list = null;
		list = dao.find("FROM CrmPatient o WHERE o.id = " + id);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmPatient();
		}
	}

	public CrmPatient getContactByDoc(String doc) {
		List<CrmPatient> list = null;
		/*
		 * list = dao.find("FROM CrmPatient o WHERE o.doc = '" + doc +
		 * "' AND o.codeSap = '" + doc + "'");
		 */
		list = dao.find("FROM CrmPatient o WHERE o.doc = '" + doc + "'");
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return new CrmPatient();
		}
	}

	public List<CrmPatient> getContactByName(String name) {
		List<CrmPatient> list = null;
		list = dao.find("FROM CrmPatient o WHERE o.firstnames LIKE '%" + name
				+ "%' or o.surnames LIKE '%" + name
				+ "%' OR UPPER(firstnames || ' ' || surnames) LIKE '%" + name
				+ "%' OR UPPER(surnames || ' ' || firstnames) LIKE '%" + name
				+ "%'");
		return list;
	}

	public long getContactExist(String doc) {
		long result = (Long) dao.find(
				"SELECT count(*) FROM CrmPatient o WHERE o.doc = '" + doc
						+ "' AND o.codeSap = '" + doc + "'").get(0);
		return result;
	}

	public List<VwTherapyMaterials> getListVwTherapyMaterials(
			BigDecimal idPatient) {
		return dao.find("FROM VwTherapyMaterials o WHERE o.idPatient = "
				+ idPatient);
	}

	public int persist(Object entity) {
		int result = 0;
		try {
			result = dao.persist(entity);
		} catch (RuntimeException ex) {
			if (ex.getCause() instanceof ConstraintViolationException) {
				result = -1;
			} else if (ex.getCause() instanceof DataIntegrityViolationException) {
				result = -2;
			}
		}
		return result;
	}

}
