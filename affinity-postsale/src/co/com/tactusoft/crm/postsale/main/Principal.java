package co.com.tactusoft.crm.postsale.main;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmCampaignMedication;
import co.com.tactusoft.crm.model.entities.CrmLog;
import co.com.tactusoft.crm.model.entities.CrmLogDetail;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmSapMedication;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.model.entities.VwAppointmentMedication;
import co.com.tactusoft.crm.postsale.bo.ProcessBO;
import co.com.tactusoft.crm.postsale.util.Utils;
import co.com.tactusoft.crm.util.FacesUtil;

public class Principal {

	public static void main(String[] args) {
		System.out.println("INCIANDO PROCESO...");
		Date currentDate = new Date();
		String currentDateString = Utils.formatDate(currentDate, "yyyy-MM-dd");

		System.out.println("CARGANDO BASE DE DATOS...");
		@SuppressWarnings("resource")
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		ProcessBO processBO = beanFactory.getBean(ProcessBO.class);

		if (processBO.getListLog(currentDateString).isEmpty()) {

			List<StorageBean> listStorage = new LinkedList<StorageBean>();

			CrmLog crmLog = new CrmLog();
			crmLog.setLogDate(new Date());
			crmLog.setLogType("POSTVENTA");
			processBO.save(crmLog);

			Map<BigDecimal, CrmCampaign> mapCampaign = new HashMap<BigDecimal, CrmCampaign>();
			Map<BigDecimal, Date> mapCallDates = new HashMap<BigDecimal, Date>();

			int currentDay = Utils.getCurrentDay(currentDate);

			Date yesterdayDate = null;
			int yesterday = currentDay - 1;
			if (yesterday != 1) {
				yesterdayDate = Utils.addDaysToDate(currentDate, -1);
			} else {
				yesterdayDate = Utils.addDaysToDate(currentDate, -2);
			}
			String yesterdayString = Utils.formatDate(yesterdayDate,
					"yyyy-MM-dd");

			Date tomorrowDate = null;
			int tomorrow = currentDay + 2;
			if (tomorrow != 1) {
				tomorrowDate = Utils.addDaysToDate(currentDate, 2);
			} else {
				tomorrowDate = Utils.addDaysToDate(currentDate, 3);
			}
			String tomorrowString = Utils
					.formatDate(tomorrowDate, "yyyy-MM-dd");

			// Buscando fecha llamada x sucursal
			List<CrmBranch> listCrmBranch = processBO.getListBranchActive();
			for (CrmBranch branch : listCrmBranch) {
				Date callDate = currentDate;
				boolean validate = true;
				do {
					callDate = Utils.addDaysToDate(callDate, 1);
					int day = Utils.getCurrentDay(callDate);
					if (day != 1
							&& processBO.getListHoliday(callDate,
									branch.getId()).isEmpty()) {
						mapCallDates.put(branch.getId(),
								Utils.getDateWithoutTime(callDate));
						validate = false;
						break;
					}
				} while (validate);
			}

			System.out.println("ACTUALIZANDO CITAS...");
			// ACTUALIZAR TODAS LAS CITAS QUE NO FUERON ATENDIDAS
			CrmLogDetail crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail.setMessage("ACTUALIZANDO CITAS");
			processBO.save(crmLogDetail);

			if (Utils.getCurrentHour(currentDate) >= 20) {
				processBO.updateAppointment(currentDateString);
			} else {
				processBO.updateAppointment(yesterdayString);
			}

			System.out.println("BUSCANDO CITAS INASISTIDAS...");
			// INASISTENCIA DIA ANTERIOR
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail.setMessage("BUSCANDO CITAS INASISTIDAS");
			processBO.save(crmLogDetail);

			List<CrmAppointment> listNoAttendet = processBO
					.getListAppointmentNoAttendet(yesterdayString);
			for (CrmAppointment row : listNoAttendet) {
				CrmBranch crmBranch = row.getCrmBranch();
				CrmCampaign crmCampaign = mapCampaign.get(row.getCrmPatient()
						.getId());
				Date callDate = mapCallDates.get(crmBranch.getId());
				String callDateString = FacesUtil.formatDate(
						mapCallDates.get(crmBranch.getId()), "yyyy-MM-dd");

				if (crmCampaign == null) {
					crmCampaign = new CrmCampaign();

					CrmUser crmUser = processBO.getUser(crmBranch,
							callDateString);
					if (crmUser == null) {
						crmUser = new CrmUser();
						crmUser.setId(new BigDecimal(2));
					}

					crmCampaign.setCrmLog(crmLog);
					crmCampaign.setCrmPatient(row.getCrmPatient());
					crmCampaign.setCrmBranch(crmBranch);
					crmCampaign.setCrmUser(crmUser);
					crmCampaign.setDateCall(callDate);
					crmCampaign.setState(1);
					processBO.save(crmCampaign);

					mapCampaign.put(row.getCrmPatient().getId(), crmCampaign);
				}

				CrmCampaignDetail crmCampaignDetail = new CrmCampaignDetail();
				crmCampaignDetail.setCrmCampaign(crmCampaign);
				crmCampaignDetail.setCrmAppointment(row);
				crmCampaignDetail.setCampaingType("NO_ATTENDET");
				crmCampaignDetail.setStatus(0);
				crmCampaignDetail.setCallDate(callDate);
				processBO.save(crmCampaignDetail);
			}

			System.out.println("BUSCANDO CITAS CONFIRMADAS...");
			// CONFIRMADAS DIA SIGUIENTE
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail.setMessage("BUSCANDO CITAS CONFIRMADAS");
			processBO.save(crmLogDetail);

			List<CrmAppointment> listConfirmed = processBO
					.getListAppointmentConfirmed(tomorrowString,
							currentDateString);
			for (CrmAppointment row : listConfirmed) {
				CrmBranch crmBranch = row.getCrmBranch();
				CrmCampaign crmCampaign = mapCampaign.get(row.getCrmPatient()
						.getId());
				Date callDate = mapCallDates.get(crmBranch.getId());
				String callDateString = FacesUtil.formatDate(
						mapCallDates.get(crmBranch.getId()), "yyyy-MM-dd");

				if (crmCampaign == null) {
					crmCampaign = new CrmCampaign();
					CrmUser crmUser = processBO.getUser(crmBranch,
							callDateString);
					if (crmUser == null) {
						crmUser = new CrmUser();
						crmUser.setId(new BigDecimal(2));
					}

					crmCampaign.setCrmLog(crmLog);
					crmCampaign.setCrmPatient(row.getCrmPatient());
					crmCampaign.setCrmBranch(crmBranch);
					crmCampaign.setCrmUser(crmUser);
					crmCampaign.setDateCall(callDate);
					crmCampaign.setState(1);
					processBO.save(crmCampaign);

					mapCampaign.put(row.getCrmPatient().getId(), crmCampaign);
				}

				CrmCampaignDetail crmCampaignDetail = new CrmCampaignDetail();
				crmCampaignDetail.setCrmCampaign(crmCampaign);
				crmCampaignDetail.setCrmAppointment(row);
				crmCampaignDetail.setCampaingType("CONFIRMED");
				crmCampaignDetail.setStatus(0);
				crmCampaignDetail.setCallDate(callDate);
				processBO.save(crmCampaignDetail);
			}

			System.out
					.println("BUSCANDO PACIENTES CON MAS DE 25 DIAS SIN CITA CONTROL");
			// SIN CITAS DE CONTROL EN 25 DÍAS
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail
					.setMessage("BUSCANDO PACIENTES CON MAS DE 25 DIAS SIN CITA CONTROL");
			processBO.save(crmLogDetail);

			Date ago25Date = Utils.addDaysToDate(currentDate, -25);
			String ago25DateString = Utils.formatDate(ago25Date, "yyyy-MM-dd");
			List<CrmAppointment> listControl = processBO
					.getListAppointmentControl(ago25DateString);
			for (CrmAppointment row : listControl) {
				CrmBranch crmBranch = row.getCrmBranch();
				CrmCampaign crmCampaign = mapCampaign.get(row.getCrmPatient()
						.getId());
				Date callDate = mapCallDates.get(crmBranch.getId());
				String callDateString = FacesUtil.formatDate(
						mapCallDates.get(crmBranch.getId()), "yyyy-MM-dd");

				if (crmCampaign == null) {
					crmCampaign = new CrmCampaign();

					CrmUser crmUser = processBO.getUser(crmBranch,
							callDateString);
					if (crmUser == null) {
						crmUser = new CrmUser();
						crmUser.setId(new BigDecimal(2));
					}

					crmCampaign.setCrmLog(crmLog);
					crmCampaign.setCrmPatient(row.getCrmPatient());
					crmCampaign.setCrmBranch(crmBranch);
					crmCampaign.setCrmUser(crmUser);
					crmCampaign.setDateCall(callDate);
					crmCampaign.setState(1);
					processBO.save(crmCampaign);

					mapCampaign.put(row.getCrmPatient().getId(), crmCampaign);
				}

				CrmCampaignDetail crmCampaignDetail = new CrmCampaignDetail();
				crmCampaignDetail.setCrmCampaign(crmCampaign);
				crmCampaignDetail.setCrmAppointment(row);
				crmCampaignDetail.setCampaingType("CONTROL");
				crmCampaignDetail.setStatus(0);
				crmCampaignDetail.setCallDate(callDate);
				processBO.save(crmCampaignDetail);
			}

			System.out
					.println("BUSCANDO MEDICAMENTOS Y TERAPIAS NO FACTURADAS");
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail
					.setMessage("BUSCANDO MEDICAMENTOS Y TERAPIAS NO FACTURADAS");
			processBO.save(crmLogDetail);

			List<CrmAppointment> listClosed = processBO
					.getListAppointmentClosed(yesterdayString);
			for (CrmAppointment row : listClosed) {
				String rowInitDate = Utils.formatDate(
						row.getStartAppointmentDate(), "yyyy-MM-dd");
				String endDate = Utils.formatDate(
						Utils.addDaysToDate(row.getStartAppointmentDate(), 3),
						"yyyy-MM-dd");

				List<VwAppointmentMedication> listVwAppointmentMedication = processBO
						.getListAppointmentMedicationByCode(row.getCode());

				List<CrmSapMedication> listSapMedication = processBO
						.getListSapMedicationByLoadState(
								row.getCrmPatient(),
								row.getCrmProcedureDetail().getFormulaDocType(),
								rowInitDate, endDate);

				if (listSapMedication.size() > 0) {
					for (VwAppointmentMedication row2 : listVwAppointmentMedication) {

						boolean exists = false;
						int index = 0;
						while (!exists && index < listSapMedication.size()) {
							Long materialLong = Long
									.parseLong(listSapMedication.get(index)
											.getIdMaterial());
							if (row2.getId().getCodMaterial() == materialLong) {
								exists = true;
							}
							index++;
						}

						if (!exists) {
							listStorage.add(new StorageBean(
									row.getCrmPatient(), row, "MEDICATION",
									String.valueOf(row2.getId()
											.getCodMaterial()), row2
											.getDescMaterial(), row2
											.getUnitMaterial()));
						}
					}
				} else {
					for (VwAppointmentMedication row4 : listVwAppointmentMedication) {
						listStorage.add(new StorageBean(row.getCrmPatient(),
								row, "MEDICATION", String.valueOf(row4.getId()
										.getCodMaterial()), row4
										.getDescMaterial(), row4
										.getUnitMaterial()));
					}
				}

				List<CrmSapMedication> listSapAppointment = processBO
						.getListSapAppointmentByLoadState(row.getCrmPatient(),
								rowInitDate, endDate);

				if (listSapAppointment.size() > 0) {
					processBO.updateSapMedicationByLoadState(
							row.getCrmPatient(), rowInitDate, endDate,
							row.getId());
				}
			}

			// ORDENAR LISTA POR PACIENTE
			Collections.sort(listStorage, new Comparator<StorageBean>() {
				public int compare(StorageBean s1, StorageBean s2) {
					return s1.getCrmPatient().getId().intValue()
							- s2.getCrmPatient().getId().intValue();
				}
			});

			CrmPatient crmPatientOld = new CrmPatient();
			crmPatientOld.setId(new BigDecimal(0));
			CrmCampaign crmCampaign = null;
			for (StorageBean row : listStorage) {
				if (row.getCrmPatient().getId().longValue() != crmPatientOld
						.getId().longValue()) {
					crmCampaign = mapCampaign.get(row.getCrmPatient().getId());
					Date callDate = null;
					if (crmCampaign == null) {
						CrmBranch crmBranch = processBO.getBranch(row
								.getCrmPatient());
						crmCampaign = new CrmCampaign();

						callDate = mapCallDates.get(crmBranch.getId());
						String callDateString = FacesUtil.formatDate(
								mapCallDates.get(crmBranch.getId()),
								"yyyy-MM-dd");

						CrmUser crmUser = processBO.getUser(crmBranch,
								callDateString);
						if (crmUser == null) {
							crmUser = new CrmUser();
							crmUser.setId(new BigDecimal(2));
						}

						crmCampaign.setCrmLog(crmLog);
						crmCampaign.setCrmPatient(row.getCrmPatient());
						crmCampaign.setCrmBranch(crmBranch);
						crmCampaign.setCrmUser(crmUser);
						crmCampaign.setDateCall(callDate);
						crmCampaign.setState(1);
						processBO.save(crmCampaign);
					}

					callDate = mapCallDates.get(crmCampaign.getCrmBranch()
							.getId());
					CrmCampaignDetail crmCampaignDetail = new CrmCampaignDetail();
					crmCampaignDetail.setCrmCampaign(crmCampaign);
					crmCampaignDetail.setCrmAppointment(null);
					crmCampaignDetail.setCampaingType("MEDICATION");
					crmCampaignDetail.setStatus(0);
					crmCampaignDetail.setCallDate(callDate);
					processBO.save(crmCampaignDetail);
				}

				CrmCampaignMedication crmCampaignMedication = new CrmCampaignMedication();
				crmCampaignMedication.setCrmCampaign(crmCampaign);
				crmCampaignMedication.setCodMaterial(row.getMedicationCode());
				crmCampaignMedication.setDescMaterial(row.getMedicationName());
				crmCampaignMedication.setUnit(row.getUnit());
				processBO.save(crmCampaignMedication);

				crmPatientOld = row.getCrmPatient();
			}

			processBO.updateCrmSapMedication();

			System.out.println("PROCESO TERMINADO");
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail.setMessage("PROCESO TERMINADO");
			processBO.save(crmLogDetail);
		}
	}
}
