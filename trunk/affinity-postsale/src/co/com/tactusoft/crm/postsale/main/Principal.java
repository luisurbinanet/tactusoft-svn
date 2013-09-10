package co.com.tactusoft.crm.postsale.main;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
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
import co.com.tactusoft.crm.model.entities.CrmSapMedication;
import co.com.tactusoft.crm.model.entities.CrmSapMedicationDistinct;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.model.entities.VwAppointmentMedication;
import co.com.tactusoft.crm.model.entities.VwMedication;
import co.com.tactusoft.crm.postsale.bo.ProcessBO;
import co.com.tactusoft.crm.postsale.util.Utils;
import co.com.tactusoft.crm.util.FacesUtil;

public class Principal {

	private static int NO_ATTENDET = 1;
	private static int CONFIRMED = 2;
	private static int CONTROL = 3;
	private static int MEDICATION = 4;

	private BeanFactory beanFactory;
	private ProcessBO processBO;

	private Map<BigDecimal, CrmCampaign> mapCampaign;
	private Map<BigDecimal, Date> mapCallDates;
	private CrmLog crmLog;

	private void insertDetail(CrmCampaign crmCampaign,
			CrmAppointment crmAppointment, int type) {
		CrmBranch crmBranch = crmAppointment.getCrmBranch();
		Date callDate = mapCallDates.get(crmBranch.getId());
		String callDateString = FacesUtil.formatDate(
				mapCallDates.get(crmBranch.getId()), "yyyy-MM-dd");

		if (crmCampaign == null) {
			crmCampaign = new CrmCampaign();

			CrmUser crmUser = processBO.getUser(crmBranch, callDateString);
			if (crmUser == null) {
				crmUser = new CrmUser();
				crmUser.setId(new BigDecimal(50));
			}

			crmCampaign.setCrmLog(crmLog);
			crmCampaign.setCrmPatient(crmAppointment.getCrmPatient());
			crmCampaign.setCrmBranch(crmBranch);
			crmCampaign.setCrmUser(crmUser);
			crmCampaign.setDateCall(callDate);
			crmCampaign.setState(1);
			processBO.save(crmCampaign);

			mapCampaign
					.put(crmAppointment.getCrmPatient().getId(), crmCampaign);
		}

		CrmCampaignDetail crmCampaignDetail = new CrmCampaignDetail();
		crmCampaignDetail.setCrmCampaign(crmCampaign);
		crmCampaignDetail.setCrmAppointment(crmAppointment);
		crmCampaignDetail.setIdCampaignType(type);
		crmCampaignDetail.setStatus(0);
		crmCampaignDetail.setCallDate(callDate);
		processBO.save(crmCampaignDetail);
	}

	public void execute() {
		System.out.println("INCIANDO PROCESO...");
		Date currentDate = new Date();
		//Date currentDate = Utils.stringTOSDate("08/09/2013", "dd/MM/yyyy");
		String currentDateString = Utils.formatDate(currentDate, "yyyy-MM-dd");

		System.out.println("CARGANDO BASE DE DATOS...");
		beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
		processBO = beanFactory.getBean(ProcessBO.class);

		if (processBO.getListLog(currentDateString).isEmpty()) {

			processBO.updateCampaign(currentDateString);

			crmLog = new CrmLog();
			crmLog.setLogDate(new Date());
			crmLog.setLogType("POSTVENTA");
			processBO.save(crmLog);

			mapCampaign = new HashMap<BigDecimal, CrmCampaign>();
			mapCallDates = new HashMap<BigDecimal, Date>();

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
				CrmCampaign crmCampaign = mapCampaign.get(row.getCrmPatient()
						.getId());
				insertDetail(crmCampaign, row, Principal.NO_ATTENDET);
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
				CrmCampaign crmCampaign = mapCampaign.get(row.getCrmPatient()
						.getId());
				insertDetail(crmCampaign, row, Principal.CONFIRMED);
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
				CrmCampaign crmCampaign = mapCampaign.get(row.getCrmPatient()
						.getId());
				insertDetail(crmCampaign, row, Principal.CONTROL);
			}

			System.out.println("ACTUALIZANDO FACTURAS CON SUS CITAS");
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail.setMessage("ACTUALIZANDO FACTURAS CON SUS CITAS");
			processBO.save(crmLogDetail);

			List<CrmSapMedicationDistinct> listDistinct = processBO
					.getListSapMedicationByLoadStateDistinct(currentDateString);
			int count = 0;
			for (CrmSapMedicationDistinct row : listDistinct) {
				String rowInitDateString = Utils.formatDate(
						Utils.addDaysToDate(row.getDateBill(), -3),
						"yyyy-MM-dd");
				CrmAppointment crmAppointment = processBO.getAppointment(
						row.getIdPatient(), rowInitDateString,
						Utils.formatDate(row.getDateBill(), "yyyy-MM-dd"),
						row.getTypeBill());
				if (crmAppointment != null) {
					processBO.updateSapMedicationById(row.getIdBill(),
							row.getTypeBill(), crmAppointment.getId(), -1);
					count++;
					System.out.println("Actualizado: " + row.getIdBill());
				}
			}

			System.out.println("FACTURAS ACTUALIZADAS: " + count);
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail.setMessage("FACTURAS ACTUALIZADAS: " + count);
			processBO.save(crmLogDetail);

			System.out
					.println("BUSCANDO MEDICAMENTOS Y TERAPIAS NO FACTURADAS");
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail
					.setMessage("BUSCANDO MEDICAMENTOS Y TERAPIAS NO FACTURADAS");
			processBO.save(crmLogDetail);

			List<CrmAppointment> listClosed = processBO
					.getListAppointmentClosed(currentDateString);
			for (CrmAppointment row : listClosed) {
				List<CrmSapMedication> listSapMedication = processBO
						.getListSapMedicationByAppointment(row.getId());

				boolean validate = false;
				if (listSapMedication.size() > 0) {
					List<VwAppointmentMedication> listVwAppointmentMedication = processBO
							.getListAppointmentMedicationByCode(row.getCode());
					if (listVwAppointmentMedication.size() > listSapMedication
							.size()) {
						validate = true;
					}
				} else {
					validate = true;
				}

				if (validate) {
					CrmCampaign crmCampaign = mapCampaign.get(row
							.getCrmPatient().getId());
					insertDetail(crmCampaign, row, Principal.MEDICATION);
				}
			}

			processBO.updateCrmSapMedication(currentDateString);

			for (CrmCampaignDetail row : processBO
					.getListCampaignDetailMedication(crmLog)) {
				for (VwMedication row2 : processBO
						.getListVwMedicationByAppointment(row
								.getCrmAppointment().getId(), row
								.getCrmAppointment().getCrmProcedureDetail()
								.getFormulaDocTypePs())) {
					CrmCampaignMedication crmCampaignMedication = new CrmCampaignMedication(
							row.getCrmCampaign(), String.valueOf(row2
									.getCodMaterial()), row2.getDescMaterial(),
							row2.getSold(), row2.getUnit(), row2.getSaleUnit(),
							row2.getPosology());
					processBO.save(crmCampaignMedication);
				}
			}

			System.out.println("PROCESO TERMINADO");
			crmLogDetail = new CrmLogDetail();
			crmLogDetail.setCrmLog(crmLog);
			crmLogDetail.setLogDate(new Date());
			crmLogDetail.setMessage("PROCESO TERMINADO");
			processBO.save(crmLogDetail);
		}

	}

	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.execute();
	}
}
