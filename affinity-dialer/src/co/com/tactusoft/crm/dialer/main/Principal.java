package co.com.tactusoft.crm.dialer.main;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.tactusoft.dialer.bo.ServicesBO;
import co.com.tactusoft.dialer.bo.ServicesCRMBO;
import co.com.tactusoft.dialer.dao.entities.Agent;
import co.com.tactusoft.dialer.dao.entities.AstTrunkDialpatterns;
import co.com.tactusoft.dialer.dao.entities.TblCallOutBoundExt;

public class Principal {

	public static boolean getRegularExpression(String regex, String match) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(match);
		boolean found = false;
		while (matcher.find()) {
			found = true;
		}
		return found;
	}

	public static boolean isEmptyOrBlank(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("INCIANDO PROCESO...");

		System.out.println("Conectado a base de datos...");
		BeanFactory beanFactory = new ClassPathXmlApplicationContext(
				"spring-config.xml");

		System.out.println("Conectado a ASTERISK");
		Asterisk asterisk = new Asterisk("192.168.1.251", 5038, "crmaffinity",
				"4dm1n.aff");

		ServicesBO servicesBO = beanFactory.getBean(ServicesBO.class);
		ServicesCRMBO servicesCRMBO = beanFactory.getBean(ServicesCRMBO.class);

		List<AstTrunkDialpatterns> listExpressionRegular = servicesBO
				.getListRegularExpression();

		List<TblCallOutBoundExt> listCustomer = servicesCRMBO.getListCustomer();
		for (TblCallOutBoundExt customer : listCustomer) {
			String phone = customer.getStTelefonoMovil();
			if (isEmptyOrBlank(phone)) {
				phone = customer.getStTelefono();
			}

			String remoteChannel = null;
			for (AstTrunkDialpatterns dial : listExpressionRegular) {
				String pattern = dial.getExpressionRegular()
						.replace("d", "\\d");
				if (getRegularExpression(pattern, "03" + phone)) {
					remoteChannel = dial.getCallNumber().replace(
							"numero_a_marcar", "03" + phone);
				}
			}

			System.out.println("Customer: " + customer.getStNombre());
			int idCall = -1;
			if (!isEmptyOrBlank(remoteChannel)) {
				for (Agent row : servicesBO.getListAgent()) {
					System.out.println("Agent: " + row.getAgent() + " "
							+ row.getReadyForCall());
					if (row.getReadyForCall() == 1 && row.getAgent() == 7005) {
						asterisk.callActionAplication(remoteChannel, row
								.getAgent().toString(), customer
								.getIdUsuarioWeb().toString() + ":" + phone,
								"6060", customer.getIdUsuarioWeb().toString(),
								phone);
					}
				}
			}

			servicesCRMBO.updateCustomer(customer.getIdCallOutBoundExt(),
					idCall);
		}
		System.out.println("FINALIZANDO PROCESO...");
	}
}
