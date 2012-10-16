package co.com.tactusoft.sap.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.tactusoft.sap.bo.ProcessBO;
import co.com.tactusoft.sap.entities.CrmSapMedication;
import co.com.tactusoft.sap.entities.VwAppointment;

public class Principal {

	public Principal() {

	}

	public static String formatDate(Date date, String format) {
		String stringDate = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat(format);
		stringDate = formatter.format(date);
		return stringDate;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		ProcessBO dao = context.getBean(ProcessBO.class);

		String minDate = Principal.formatDate(dao.getMinDateByLoadState(),
				"yyyy-MM-dd");
		String maxDate = Principal.formatDate(dao.getMaxDateByLoadState(),
				"yyyy-MM-dd");

		for (VwAppointment row : dao
				.getListAppointmentByDates(minDate, maxDate)) {
			
			if(row.getPatCodeSap().equals("0000879356")){
				System.out.println("");
			}

			String date = Principal.formatDate(row.getStartAppointmentDate(),
					"yyyy-MM-dd");
			List<CrmSapMedication> listSapMedication = dao
					.getListSapMedicationByLoadState(row.getPatCodeSap(),
							row.getPrcFormulaDocType(), date);

			for (CrmSapMedication sap : listSapMedication) {
				if (sap.getIdPatient().equals(row.getPatCodeSap()))
					System.out.println(sap.getId().getIdBill() + " - "
							+ sap.getIdMaterial() + " - " + row.getCode()
							+ " - " + sap.getDateBill());
			}
		}

	}

}
