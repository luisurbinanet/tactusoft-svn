package co.com.tactusoft.crm.postsale.main;

import java.math.BigDecimal;
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
import co.com.tactusoft.crm.model.entities.CrmSapMedication;
import co.com.tactusoft.crm.model.entities.CrmSapMedicationDistinct;
import co.com.tactusoft.crm.model.entities.CrmSapMedicationId;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.model.entities.VwAppointmentMedication;
import co.com.tactusoft.crm.model.entities.VwMedication;
import co.com.tactusoft.crm.model.entities.sap.SapMedication;
import co.com.tactusoft.crm.postsale.bo.ProcessBO;
import co.com.tactusoft.crm.postsale.bo.SapBO;
import co.com.tactusoft.crm.postsale.util.Utils;
import co.com.tactusoft.crm.util.FacesUtil;

public class Principal2 {

	private BeanFactory beanFactory;
	private ProcessBO processBO;
	private SapBO sapBO;

	public void execute() {
		System.out.println("INCIANDO PROCESO...");
		Date currentDate = Utils.stringTOSDate("13/11/2013", "dd/MM/yyyy");
		//String currentDateString = Utils.formatDate(currentDate, "yyyy-MM-dd");

		System.out.println("CARGANDO BASE DE DATOS...");
		beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
		processBO = beanFactory.getBean(ProcessBO.class);
		sapBO = beanFactory.getBean(SapBO.class);
		
		int numDays = processBO.getLogLastDay(currentDate);
		
		Date processDate = Utils.addDaysToDate(currentDate, numDays * -1);
		String processDateString = Utils.formatDate(processDate,
				"yyyy-MM-dd");

		System.out.println("ACTUALIZANDO FACTURAS CON SUS CITAS");

		List<CrmSapMedicationDistinct> listDistinct = processBO
				.getListSapMedicationByLoadStateDistinct(processDateString);
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
		CrmLogDetail crmLogDetail = new CrmLogDetail();
		CrmLog crmLog = new CrmLog();
		crmLog.setId(427);
		crmLogDetail.setCrmLog(crmLog);
		crmLogDetail.setId(2839);
		crmLogDetail.setLogDate(new Date());
		crmLogDetail.setMessage("FACTURAS ACTUALIZADAS: " + count);
		processBO.save(crmLogDetail);
		
		
		

	}

	public static void main(String[] args) {
		Principal2 principal2 = new Principal2();
		principal2.execute();
	}
}
