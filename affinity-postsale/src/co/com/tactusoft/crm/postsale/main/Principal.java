package co.com.tactusoft.crm.postsale.main;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.postsale.bo.ProcessBO;
import co.com.tactusoft.crm.postsale.util.Utils;

public class Principal {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		ProcessBO dao = beanFactory.getBean(ProcessBO.class);

		Date currentDate = new Date();
		// String currentDateString = Utils.formatDate(currentDate,
		// "yyyy-MM-dd");
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

		// INASISTENCIA DIA ANTERIOR
		List<CrmAppointment> listNoAttendet = dao
				.getListAppointmentNoAttendet(yesterdayString);
		for (CrmAppointment row : listNoAttendet) {

		}

		// CONFIRMADAS DIA SIGUIENTE
		List<CrmAppointment> listConfirmed = dao
				.getListAppointmentConfirmed(tomorrowString);
		for (CrmAppointment row : listConfirmed) {

		}

		// SIN CITAS DE CONTROL EN 25 DÍAS

	}

}
