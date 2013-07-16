package co.com.tactusoft.crm.dialer.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.com.tactusoft.dialer.bo.ServicesBO;
import co.com.tactusoft.dialer.bo.ServicesCRMBO;
import co.com.tactusoft.dialer.dao.entities.Agent;
import co.com.tactusoft.dialer.dao.entities.AstTrunkDialpatterns;
import co.com.tactusoft.dialer.dao.entities.Parametros;
import co.com.tactusoft.dialer.dao.entities.TblCallOutBoundExt;

public class Principal {

	private static String fileSource = "E:\\CRM\\file.par";
	private static String fileParameterSource = "E:\\CRM\\file_parameter.par";

	// private static String fileSource = "/opt/dialer/file.par";
	// private static String fileParameterSource =
	// "/opt/dialer/file_parameter.par";

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

	private static String readFile() {
		String result = null;
		try {
			FileReader fileReader = new FileReader(fileSource);
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			// Uncomment the line below if you want to skip the fist line (e.g
			// if headers)
			// line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] rows = line.split(";");
				result = rows[1];
			}
			br.close();

		} catch (IOException e) {
			System.out.println("ERROR: unable to read file " + fileSource);
			e.printStackTrace();
		}
		return result;
	}

	public static Parametros readFileParameter() {
		Parametros parametros = new Parametros();
		try {
			FileReader fileReader = new FileReader(fileParameterSource);
			BufferedReader br = new BufferedReader(fileReader);
			String line;
			// Uncomment the line below if you want to skip the fist line (e.g
			// if headers)
			// line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] rows = line.split(":");
				String field = rows[0];
				String result = rows[1].trim();
				if (field.equalsIgnoreCase("ESTADOS")) {
					parametros.setEstados(result);
				}

				if (field.equalsIgnoreCase("TIEMPO")) {
					try {
						parametros.setTiempo(Integer.parseInt(result));
					} catch (Exception ex) {
						parametros.setTiempo(60);
					}
				}

				if (field.equalsIgnoreCase("TERMINAR")) {
					parametros.setTerminar(result);
				}

				if (field.equalsIgnoreCase("COLA")) {
					parametros.setCola(result);
				}
			}
			br.close();

		} catch (IOException e) {
			System.out.println("ERROR: unable to read file " + fileSource);
			e.printStackTrace();
		}
		return parametros;
	}

	public static void writeFile(String id) {
		try {
			File file = new File(fileSource);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter writer = new BufferedWriter(fw);
			writer.write(currentDateString() + ";" + id);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String currentDateString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(date);
		return currentDate;
	}

	public static String getRemoteChannel(
			List<AstTrunkDialpatterns> listExpressionRegular, String phone) {
		String remoteChannel = null;
		for (AstTrunkDialpatterns dial : listExpressionRegular) {
			String pattern = dial.getExpressionRegular().replace("d", "\\d");
			if (getRegularExpression(pattern, "03" + phone)) {
				remoteChannel = dial.getCallNumber().replace("numero_a_marcar",
						phone);
			}
		}
		return remoteChannel;
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

		/*
		 * List<AstTrunkDialpatterns> listExpressionRegular = servicesBO
		 * .getListRegularExpression();
		 */
		try {
			while (true) {

				String id = readFile();
				Parametros parametros = readFileParameter();
				if (isEmptyOrBlank(parametros.getEstados())) {
					break;
				}

				if (isEmptyOrBlank(parametros.getCola())) {
					break;
				}

				if (isEmptyOrBlank(parametros.getTerminar())
						|| parametros.getTerminar().equalsIgnoreCase("SI")) {
					break;
				}

				List<TblCallOutBoundExt> listCustomer = servicesCRMBO
						.getListCustomer(id, parametros.getEstados());
				for (TblCallOutBoundExt customer : listCustomer) {
					String phone = null;

					try {
						Long.parseLong(customer.getStTelefonoMovil());
						phone = customer.getStTelefonoMovil();

						String remoteChannel = "SIP/SalidaMX/57" + phone;
						//String remoteChannel = getRemoteChannel(listExpressionRegular,phone);

						System.out.println("Customer: "
								+ customer.getStNombre());

						if (!isEmptyOrBlank(remoteChannel)) {
							out: while (true) {
								for (Agent row : servicesBO.getListAgent()) {
									System.out.println("Agent: "
											+ row.getAgent() + " "
											+ row.getReadyForCall());
									if (row.getReadyForCall() == 1) {

										asterisk.unpausedAgent(row.getAgent()
												.toString(), parametros
												.getCola());

										boolean verifed = asterisk.getAgent(
												parametros.getCola(), row
														.getAgent().toString());

										if (verifed) {
											asterisk.callActionAplication(
													remoteChannel, row
															.getAgent()
															.toString(),
													customer.getIdUsuarioWeb()
															.toString()
															+ ":"
															+ phone, parametros
															.getCola(),
													customer.getIdUsuarioWeb()
															.toString(), phone);
											writeFile(customer
													.getIdCallOutBoundExt()
													.toString());
											Thread.sleep(parametros.getTiempo() * 1000);
											break out;
										}
									}
								}
							}
						}
					} catch (Exception ex) {
						phone = null;
					}
				}

				Thread.sleep(parametros.getTiempo() * 1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("FINALIZANDO PROCESO...");
	}
}
