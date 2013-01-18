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
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.postsale.bo.ProcessBO;
import co.com.tactusoft.crm.postsale.util.Utils;

public class Principal {

	public static void main(String[] args) {
		System.out.println("INCIANDO PROCESO...");

		System.out.println("CARGANDO BASE DE DATOS...");
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		ProcessBO processBO = beanFactory.getBean(ProcessBO.class);

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
		if (Utils.getCurrentHour(currentDate) >= 20) {
			processBO.updateAppointment(currentDateString);
		} else {
			processBO.updateAppointment(yesterdayString);
		}

		List<StorageBean> listStorage = new LinkedList<StorageBean>();

		System.out.println("BUSCANDO CITAS INASISTIDAS...");
		// INASISTENCIA DIA ANTERIOR
		List<CrmAppointment> listNoAttendet = processBO
				.getListAppointmentNoAttendet(yesterdayString);
		for (CrmAppointment row : listNoAttendet) {
			listStorage.add(new StorageBean(row.getCrmPatient(), row,
					"NO_ATTENDET"));
		}

		System.out.println("BUSCANDO CITAS CONFIRMADAS...");
		// CONFIRMADAS DIA SIGUIENTE
		List<CrmAppointment> listConfirmed = processBO
				.getListAppointmentConfirmed(tomorrowString);
		for (CrmAppointment row : listConfirmed) {
			listStorage.add(new StorageBean(row.getCrmPatient(), row,
					"CONFIRMED"));
		}

		System.out.println("BUSCANDO TERAPIAS EN ULTIMOS 25 DIAS...");
		// SIN CITAS DE CONTROL EN 25 DÍAS
		Date ago25Date = Utils.addDaysToDate(currentDate, -25);
		String ago25DateString = Utils.formatDate(ago25Date, "yyyy-MM-dd");
		List<CrmPatient> listControl = processBO
				.getListAppointmentControl(ago25DateString);
		for (CrmPatient row : listControl) {
			listStorage.add(new StorageBean(row, null, "CONTROL"));
		}

		// ORDENAR LISTA POR PACIENTE
		Collections.sort(listStorage, new Comparator<StorageBean>() {
			public int compare(StorageBean s1, StorageBean s2) {
				return s1.getCrmPatient().getId().intValue()
						- s2.getCrmPatient().getId().intValue();
			}
		});

		System.out.println("ASIGNANDO TAREAS..");
		if (listStorage.size() > 0) {
			CrmPatient crmPatient = listStorage.get(0).getCrmPatient();

			// Primer Registro
			CrmCampaign crmCampaign = new CrmCampaign();
			crmCampaign.setCrmPatient(crmPatient);
			CrmBranch crmBranch = new CrmBranch();
			if (listStorage.get(0).getCrmAppointment() != null) {
				crmBranch = listStorage.get(0).getCrmAppointment()
						.getCrmBranch();
			} else {
				crmBranch = processBO.getBranch(crmPatient);
			}
			crmCampaign.setCrmBranch(crmBranch);
			crmCampaign.setCrmUser(processBO.getUser(crmBranch));
			crmCampaign.setDateCall(Utils.addDaysToDate(currentDate, 1));
			crmCampaign.setState(1);
			processBO.save(crmCampaign);

			for (StorageBean row : listStorage) {
				if (row.getCrmPatient().getId().intValue() != crmPatient
						.getId().intValue()) {

					crmCampaign = new CrmCampaign();
					crmCampaign.setCrmPatient(row.getCrmPatient());
					crmBranch = new CrmBranch();
					if (row.getCrmAppointment() != null) {
						crmBranch = row.getCrmAppointment().getCrmBranch();
					} else {
						crmBranch = processBO.getBranch(crmPatient);
					}
					crmCampaign.setCrmBranch(crmBranch);
					crmCampaign.setCrmUser(processBO.getUser(crmBranch));
					crmCampaign
							.setDateCall(Utils.addDaysToDate(currentDate, 1));
					crmCampaign.setState(1);
					processBO.save(crmCampaign);
				}

				CrmCampaignDetail crmCampaignDetail = new CrmCampaignDetail();
				crmCampaignDetail.setCrmCampaign(crmCampaign);
				crmCampaignDetail.setCrmAppointment(row.getCrmAppointment());
				crmCampaignDetail.setCampaingType(row.getType());
				processBO.save(crmCampaignDetail);

				crmPatient = row.getCrmPatient();
			}
		} else {
			System.out.println("NO EXISTEN TAREAS..");
		}

		System.out.println("PROCESO TERMINADO");

	}
}
