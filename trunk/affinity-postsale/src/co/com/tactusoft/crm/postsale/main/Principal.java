package co.com.tactusoft.crm.postsale.main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.postsale.bo.ProcessBO;
import co.com.tactusoft.crm.postsale.util.Utils;

public class Principal {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		ProcessBO dao = beanFactory.getBean(ProcessBO.class);

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
		int tomorrow = currentDay + 1;
		if (tomorrow != 1) {
			tomorrowDate = Utils.addDaysToDate(currentDate, 1);
		} else {
			tomorrowDate = Utils.addDaysToDate(currentDate, 2);
		}
		String tomorrowString = Utils.formatDate(tomorrowDate, "yyyy-MM-dd");

		// ACTUALIZAR TODAS LAS CITAS QUE NO FUERON ATENDIDAS
		if (Utils.getCurrentHour(currentDate) >= 16) {
			dao.updateAppointment(currentDateString);
		}

		List<StorageBean> listStorage = new LinkedList<StorageBean>();

		// INASISTENCIA DIA ANTERIOR
		List<CrmAppointment> listNoAttendet = dao
				.getListAppointmentNoAttendet(yesterdayString);
		for (CrmAppointment row : listNoAttendet) {
			listStorage.add(new StorageBean(row.getCrmPatient(), row,
					"NO_ATTENDET"));
		}

		// CONFIRMADAS DIA SIGUIENTE
		List<CrmAppointment> listConfirmed = dao
				.getListAppointmentConfirmed(tomorrowString);
		for (CrmAppointment row : listConfirmed) {
			listStorage.add(new StorageBean(row.getCrmPatient(), row,
					"CONFIRMED"));
		}

		// SIN CITAS DE CONTROL EN 25 DÍAS
		Date ago25Date = Utils.addDaysToDate(currentDate, -25);
		String ago25DateString = Utils.formatDate(ago25Date, "yyyy-MM-dd");
		List<CrmPatient> listControl = dao
				.getListAppointmentControl(ago25DateString);
		for (CrmPatient row : listControl) {
			listStorage
					.add(new StorageBean(row, null, "CONTROL"));
		}

		// ORDENAR LISTA POR PACIENTE
		Collections.sort(listStorage, new Comparator<StorageBean>() {
			public int compare(StorageBean s1, StorageBean s2) {
				return s1.getCrmPatient().getId().intValue()
						- s2.getCrmPatient().getId().intValue();
			}
		});

	}
}
