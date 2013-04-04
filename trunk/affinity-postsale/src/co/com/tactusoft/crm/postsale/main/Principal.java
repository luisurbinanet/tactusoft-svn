package co.com.tactusoft.crm.postsale.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmLog;
import co.com.tactusoft.crm.model.entities.CrmLogDetail;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmSapMedication;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.model.entities.VwAppointmentMedication;
import co.com.tactusoft.crm.postsale.bo.ProcessBO;
import co.com.tactusoft.crm.postsale.util.Utils;

public class Principal {

	public static void main(String[] args) {
		System.out.println("INCIANDO PROCESO...");

		System.out.println("CARGANDO BASE DE DATOS...");
		@SuppressWarnings("resource")
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		ProcessBO processBO = beanFactory.getBean(ProcessBO.class);

		List<StorageBean> listStorage = new LinkedList<StorageBean>();

		CrmLog crmLog = new CrmLog();
		crmLog.setLogDate(new Date());
		crmLog.setLogType("POSTVENTA");
		processBO.save(crmLog);

		Date currentDate = new Date();
		String currentDateString = Utils.formatDate(currentDate, "yyyy-MM-dd");
		int currentDay = Utils.getCurrentDay(currentDate);

		Date yesterdayDate = null;
		int yesterday = currentDay - 1;
		if (yesterday != 1) {
			yesterdayDate = Utils.addDaysToDate(currentDate, -1);
		} else {
			yesterdayDate = Utils.addDaysToDate(currentDate, -2);
		}
		String yesterdayString = Utils.formatDate(yesterdayDate, "yyyy-MM-dd");

		Date tomorrowDate = null;
		int tomorrow = currentDay + 2;
		if (tomorrow != 1) {
			tomorrowDate = Utils.addDaysToDate(currentDate, 2);
		} else {
			tomorrowDate = Utils.addDaysToDate(currentDate, 3);
		}
		String tomorrowString = Utils.formatDate(tomorrowDate, "yyyy-MM-dd");

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
			listStorage.add(new StorageBean(row.getCrmPatient(), row,
					"NO_ATTENDET"));
		}

		System.out.println("BUSCANDO CITAS CONFIRMADAS...");
		// CONFIRMADAS DIA SIGUIENTE
		crmLogDetail = new CrmLogDetail();
		crmLogDetail.setCrmLog(crmLog);
		crmLogDetail.setLogDate(new Date());
		crmLogDetail.setMessage("BUSCANDO CITAS CONFIRMADAS");
		processBO.save(crmLogDetail);

		List<CrmAppointment> listConfirmed = processBO
				.getListAppointmentConfirmed(tomorrowString);
		for (CrmAppointment row : listConfirmed) {
			listStorage.add(new StorageBean(row.getCrmPatient(), row,
					"CONFIRMED"));
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
			listStorage
					.add(new StorageBean(row.getCrmPatient(), row, "CONTROL"));
		}

		System.out.println("BUSCANDO MEDICAMENTOS Y TERAPIAS NO FACTURADAS");
		// SIN CITAS DE CONTROL EN 25 DÍAS
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
					.getListSapMedicationByLoadState(row.getCrmPatient()
							.getCodeSap(), row.getCrmProcedureDetail()
							.getFormulaDocType(), rowInitDate, endDate);

			if (listSapMedication.size() > 0) {
				for (VwAppointmentMedication row2 : listVwAppointmentMedication) {

					boolean exists = false;
					int index = 0;
					while (!exists && index < listSapMedication.size()) {
						Long materialLong = Long.parseLong(listSapMedication
								.get(index).getIdMaterial());
						if (row2.getId().getCodMaterial() == materialLong) {
							exists = true;
						}
						index++;
					}

					if (!exists) {
						listStorage.add(new StorageBean(row.getCrmPatient(),
								row, "MEDICATION", String.valueOf(row2.getId()
										.getCodMaterial()), row2
										.getDescMaterial(), row2
										.getUnitMaterial()));
					}
				}
			} else {
				for (VwAppointmentMedication row4 : listVwAppointmentMedication) {
					listStorage.add(new StorageBean(row.getCrmPatient(), row,
							"MEDICATION", String.valueOf(row4.getId()
									.getCodMaterial()), row4.getDescMaterial(),
							row4.getUnitMaterial()));
				}
			}
		}

		// ORDENAR LISTA POR PACIENTE
		Collections.sort(listStorage, new Comparator<StorageBean>() {
			public int compare(StorageBean s1, StorageBean s2) {
				return s1.getCrmPatient().getId().intValue()
						- s2.getCrmPatient().getId().intValue();
			}
		});

		System.out.println("ASIGNANDO TAREAS..");
		crmLogDetail = new CrmLogDetail();
		crmLogDetail.setCrmLog(crmLog);
		crmLogDetail.setLogDate(new Date());
		crmLogDetail.setMessage("ASIGNANDO TAREAS");
		processBO.save(crmLogDetail);

		if (listStorage.size() > 0) {
			CrmPatient crmPatient = listStorage.get(0).getCrmPatient();
			CrmBranch crmBranch = new CrmBranch();
			if (listStorage.get(0).getCrmAppointment() != null) {
				crmBranch = listStorage.get(0).getCrmAppointment()
						.getCrmBranch();
			} else {
				crmBranch = processBO.getBranch(crmPatient);
			}
			CrmUser crmUser = processBO.getUser(crmBranch);

			// Primer Registro
			CrmCampaign crmCampaign = new CrmCampaign();
			if (crmUser != null) {
				crmCampaign.setCrmLog(crmLog);
				crmCampaign.setCrmPatient(crmPatient);

				crmCampaign.setCrmBranch(crmBranch);
				crmCampaign.setCrmUser(processBO.getUser(crmBranch));
				crmCampaign.setDateCall(Utils.addDaysToDate(currentDate, 1));
				crmCampaign.setState(1);
				processBO.save(crmCampaign);
			}

			for (StorageBean row : listStorage) {
				crmBranch = new CrmBranch();
				if (row.getCrmAppointment() != null) {
					crmBranch = row.getCrmAppointment().getCrmBranch();
				} else {
					crmBranch = processBO.getBranch(crmPatient);
				}
				crmUser = processBO.getUser(crmBranch);

				if (row.getCrmPatient().getId().intValue() != crmPatient
						.getId().intValue()) {

					if (crmUser != null) {
						crmCampaign = new CrmCampaign();
						crmCampaign.setCrmLog(crmLog);
						crmCampaign.setCrmPatient(row.getCrmPatient());
						crmCampaign.setCrmBranch(crmBranch);
						crmCampaign.setCrmUser(crmUser);
						crmCampaign.setDateCall(Utils.addDaysToDate(
								currentDate, 1));
						crmCampaign.setState(1);
						processBO.save(crmCampaign);
					}
				}

				if (crmUser != null) {
					CrmCampaignDetail crmCampaignDetail = new CrmCampaignDetail();
					crmCampaignDetail.setCrmCampaign(crmCampaign);
					crmCampaignDetail
							.setCrmAppointment(row.getCrmAppointment());
					crmCampaignDetail.setCampaingType(row.getType());
					crmCampaignDetail.setCodMaterial(row.getMedicationCode());
					crmCampaignDetail.setDescMaterial(row.getMedicationName());
					crmCampaignDetail.setUnit(row.getUnit());
					processBO.save(crmCampaignDetail);
				}

				crmPatient = row.getCrmPatient();
			}
		} else {
			System.out.println("NO EXISTEN TAREAS..");
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail.setMessage("NO EXISTEN TAREAS");
			processBO.save(crmLogDetail);
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
