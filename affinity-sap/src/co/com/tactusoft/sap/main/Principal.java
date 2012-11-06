package co.com.tactusoft.sap.main;

import java.math.BigDecimal;
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
import co.com.tactusoft.sap.entities.CrmCampaign;
import co.com.tactusoft.sap.entities.CrmCampaignDetail;
import co.com.tactusoft.sap.entities.CrmSapMedication;
import co.com.tactusoft.sap.entities.CrmUserCampaign;
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
		Date minDateSAP = dao.getMinDateByLoadState();

		if (minDateSAP != null) {

			String minDate = Principal.formatDate(minDateSAP, "yyyy-MM-dd");
			String maxDate = Principal.formatDate(dao.getMaxDateByLoadState(),
					"yyyy-MM-dd");

			List<Campaign> listMedCampaing = new ArrayList<Campaign>();

			for (VwAppointment row : dao.getListAppointmentByDates(minDate,
					maxDate)) {

				String date = Principal.formatDate(
						row.getStartAppointmentDate(), "yyyy-MM-dd");

				List<CrmSapMedication> listSapMedication = dao
						.getListSapMedicationByLoadState(row.getPatCodeSap(),
								row.getPrcFormulaDocType(), date);

				for (CrmSapMedication sap : listSapMedication) {
					if (getDateWithoutTime(row.getStartAppointmentDate())
							.compareTo(sap.getDateBill()) == 0) {

						listMedCampaing.addAll(getCampaign(dao, row.getCode(),
								listSapMedication));
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
							listMedCampaing.addAll(getCampaign(dao,
									row.getCode(), listSapMedication));
							break;
						}
					}
				}
			}

			// Ordenar por Paciente
			Collections.sort(listMedCampaing);

			BigDecimal currentIdPatient = null;
			CrmCampaign crmCampaign = null;
			for (Campaign row : listMedCampaing) {

				System.out.println(row.getIdPatient() + " - "
						+ row.getNameMaterial() + " - " + row.getCodeBranch());

				if (currentIdPatient == null
						|| currentIdPatient.intValue() != row.getIdPatient()
								.intValue()) {
					CrmUserCampaign crmUserCampaign = dao
							.getListUserCampaignByBranchs(
									"'" + row.getCodeBranch() + "'").get(0);

					crmCampaign = new CrmCampaign();
					crmCampaign.setIdBranch(crmUserCampaign.getId()
							.getIdBranch());
					crmCampaign.setIdPatient(row.getIdPatient());
					crmCampaign.setIdUser(crmUserCampaign.getId().getIdUser());
					dao.saveCrmCampaign(crmCampaign);
				}

				currentIdPatient = row.getIdPatient();

				CrmCampaignDetail crmCampaignDetail = new CrmCampaignDetail();
				crmCampaignDetail.setCrmCampaign(crmCampaign);
				crmCampaignDetail.setCodMaterial(row.getCodeMaterial());
				crmCampaignDetail.setDescMaterial(row.getNameMaterial());
				dao.saveCrmCampaignDetail(crmCampaignDetail);
			}
		}
	}

	private static List<Campaign> getCampaign(ProcessBO dao, String code,
			List<CrmSapMedication> listSapMedication) {
		List<Campaign> list = new ArrayList<Campaign>();
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
				}

				sap2.setStatus("P");
				dao.saveCrmSapMedication(sap2);
			}
			if (!exists) {
				list.add(campaign);
			}
		}

		return list;
	}

}
