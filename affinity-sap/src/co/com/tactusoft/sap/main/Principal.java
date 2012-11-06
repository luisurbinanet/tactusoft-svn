package co.com.tactusoft.sap.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.tactusoft.sap.beans.Campaign;
import co.com.tactusoft.sap.bo.ProcessBO;
import co.com.tactusoft.sap.entities.CrmSapMedication;
import co.com.tactusoft.sap.entities.VwAppointment;
import co.com.tactusoft.sap.entities.VwAppointmentMedication;

public class Principal {

	public static final int CONST_MAX_DAYS = 3;

	public Principal() {

	}

	public static String formatDate(Date date, String format) {
		String stringDate = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat(format);
		stringDate = formatter.format(date);
		return stringDate;
	}

	public static Date getDateWithoutTime(Date date) {
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		try {
			now = df1.parse(df1.format(date));
		} catch (ParseException e) {
			now = null;
		}
		return now;
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

		List<Campaign> listMedCampaing = new ArrayList<Campaign>();
		Campaign campaign = null;

		for (VwAppointment row : dao
				.getListAppointmentByDates(minDate, maxDate)) {

			String date = Principal.formatDate(row.getStartAppointmentDate(),
					"yyyy-MM-dd");

			List<CrmSapMedication> listSapMedication = dao
					.getListSapMedicationByLoadState(row.getPatCodeSap(),
							row.getPrcFormulaDocType(), date);

			for (CrmSapMedication sap : listSapMedication) {
				if (getDateWithoutTime(row.getStartAppointmentDate())
						.compareTo(sap.getDateBill()) == 0) {

					campaign = getCampaign(dao, row.getCode(),
							listSapMedication);

					if (campaign != null) {
						listMedCampaing.add(campaign);
					}

					break;
				} else {
					Calendar c = Calendar.getInstance();
					Calendar starDate = new GregorianCalendar();
					starDate.setTime(getDateWithoutTime(row
							.getStartAppointmentDate()));
					Calendar endDate = new GregorianCalendar();
					endDate.setTime(sap.getDateBill());
					c.setTimeInMillis(endDate.getTime().getTime()
							- starDate.getTime().getTime());
					int days = c.get(Calendar.DAY_OF_YEAR);
					if (days <= CONST_MAX_DAYS) {
						campaign = getCampaign(dao, row.getCode(),
								listSapMedication);

						if (campaign != null) {
							listMedCampaing.add(campaign);
						}
					}
				}
			}
		}

		Collections.sort(listMedCampaing);
		for (Campaign row : listMedCampaing) {
			System.out.println(row.getIdPatient() + " - "
					+ row.getNameMaterial());
		}

	}

	private static Campaign getCampaign(ProcessBO dao, String code,
			List<CrmSapMedication> listSapMedication) {
		Campaign campaign = null;
		List<VwAppointmentMedication> listMedication = dao
				.getListAppointmentMedicationByCode(code);
		for (VwAppointmentMedication vw : listMedication) {
			boolean exists = false;
			for (CrmSapMedication sap2 : listSapMedication) {

				campaign = new Campaign();
				campaign.setCodeBranch(sap2.getIdSalesOff().toString());
				campaign.setIdPatient(vw.getPatId());
				campaign.setCodeMaterial(vw.getId().getCodMaterial());
				campaign.setNameMaterial(vw.getId().getDescMaterial());

				if (vw.getId().getCodMaterial().equals(sap2.getIdMaterial())) {
					exists = true;
					break;
				}
			}
			if (exists) {
				campaign = null;
			}
		}

		return campaign;
	}

}
