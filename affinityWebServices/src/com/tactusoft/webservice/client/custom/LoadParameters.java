package com.tactusoft.webservice.client.custom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadParameters {

	private static String RUTA_LINUX = "/opt/affinityWeb";
	private static String RUTA_WINDOWS = "C:/tmp/affinityWeb";
	private static String path = "";
	
	private String ENVIRONMENT;
	private String URL_CUSTOMER_MAINTAIN_ALL;
	private String URL_CUSTOMER_FIND;
	private String URL_SALESORDER_CREATEFROMDAT;
	private String URL_CUSTOMER2;
	private String user;
	private String password;

	public LoadParameters() {
		try {
			
			if (OSValidator.isWindows()) {
				path = RUTA_WINDOWS;
			} else {
				path = RUTA_LINUX;
			}
			
			BufferedReader in = new BufferedReader(new FileReader(
					path + "/parametros.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				String fields[] = str.split("=");
				String name = fields[0];
				String value = fields[1];

				if (name.equals("ENVIRONMENT")) {
					ENVIRONMENT = value;
				} else if (name.equals("URL_CUSTOMER_MAINTAIN_ALL")) {
					URL_CUSTOMER_MAINTAIN_ALL = value;
				} else if (name.equals("URL_CUSTOMER_FIND")) {
					URL_CUSTOMER_FIND = value;
				} else if (name.equals("URL_SALESORDER_CREATEFROMDAT")) {
					URL_SALESORDER_CREATEFROMDAT = value;
				} else if (name.equals("URL_CUSTOMER2")) {
					URL_CUSTOMER2 = value;
				} else if (name.equals("LOGIN")) {
					String[] value2 = value.split(",");
					user = value2[0];
					password = value2[1];
				}
			}
			in.close();
		} catch (IOException e) {
			System.out.println("AFFINITYWEB-ERROR: No se encuentra el archivo parametros en " + path);
		}
	}

	public String getENVIRONMENT() {
		return ENVIRONMENT;
	}

	public void setENVIRONMENT(String eNVIRONMENT) {
		ENVIRONMENT = eNVIRONMENT;
	}

	public String getURL_CUSTOMER_MAINTAIN_ALL() {
		return URL_CUSTOMER_MAINTAIN_ALL;
	}

	public void setURL_CUSTOMER_MAINTAIN_ALL(String uRL_CUSTOMER_MAINTAIN_ALL) {
		URL_CUSTOMER_MAINTAIN_ALL = uRL_CUSTOMER_MAINTAIN_ALL;
	}

	public String getURL_CUSTOMER_FIND() {
		return URL_CUSTOMER_FIND;
	}

	public void setURL_CUSTOMER_FIND(String uRL_CUSTOMER_FIND) {
		URL_CUSTOMER_FIND = uRL_CUSTOMER_FIND;
	}

	public String getURL_SALESORDER_CREATEFROMDAT() {
		return URL_SALESORDER_CREATEFROMDAT;
	}

	public void setURL_SALESORDER_CREATEFROMDAT(
			String uRL_SALESORDER_CREATEFROMDAT) {
		URL_SALESORDER_CREATEFROMDAT = uRL_SALESORDER_CREATEFROMDAT;
	}

	public String getURL_CUSTOMER2() {
		return URL_CUSTOMER2;
	}

	public void setURL_CUSTOMER2(String uRL_CUSTOMER2) {
		URL_CUSTOMER2 = uRL_CUSTOMER2;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
