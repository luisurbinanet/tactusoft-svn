	package com.tactusoft.webservice.client.execute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.tactusoft.webservice.client.objects.Bapicustomer04;
import com.tactusoft.webservice.client.vtiger.CustomH;
import com.tactusoft.webservice.client.vtiger.VTLogin;

public class Test {

	public static String getMD5(String text) {
		String md5 = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes("UTF-8"), 0, text.length());
			byte[] bt = md.digest();
			BigInteger bi = new BigInteger(1, bt);
			md5 = bi.toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return md5;
	}

	public static String md5Hex(String input) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(input.getBytes());
		return new BigInteger(1, hash).toString(16);
	}

	public static void main(String args[]) {

		getJson();

		// CREAR CLIENTES
		/*String url = "http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/z_sd_customer_maintain_all/300/z_sd_customer_maintain_all/z_sd_customer_maintain_all";
		String username = "TACTUSOFT";
		String password = "AFFINITY";

		String ambiente = "300";
		String tipoDocumento = "1";
		String nroDocumento = "MX00000121";
		String tratamiento = "Señor";
		String nombres = "Prueba 24 de julio 2012 ";
		String apellidos = "Prueba 24 de julio 2012";
		String direccion = "Prueba 24 de julio 2012";
		String telefono = "Prueba 24 de jul";
		String codigoPostal = "12345";
		String celular = "Prueba 24 de jul";
		String correoElectronico = "";
		String pais = "MX";
		String ciudad = "Distrito Federal";
		String region = "DF";
		String grupoCuenta = "D001";
		String orgVentas = "3000";
		String canalDistribucion = "10";
		String division = "00";
		String sociedad = "3000";
		String oficinaVentas = "3000";
		String grupoCliente = "01";
		String condicionPago = "Z001";
		String cuenta = "1305050000";
		String grupoPrecios = "01";
		String esquemaClientes = "1";
		String estadoCliente = "1";
		String moneda = "MXN";

		/*
		 * String code = CustomerExecute.excecute(url, username, password,
		 * ambiente, tipoDocumento, nroDocumento, tratamiento, nombres,
		 * apellidos, direccion, codigoPostal, telefono, celular,
		 * correoElectronico, pais, ciudad, region, grupoCuenta, orgVentas,
		 * canalDistribucion, division, sociedad, oficinaVentas, grupoCliente,
		 * condicionPago, cuenta, grupoPrecios, esquemaClientes, estadoCliente,
		 * moneda);
		 * 
		 * System.out.println(code);
		 */

		/*
		 * url =
		 * "http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zcustomer2/300/zcustomer2/zcustomer2"
		 * ; List<WSBean> result = findByDoc(url, username, password, "4000",
		 * "A0224466", 0); for (WSBean row : result) {
		 * System.out.println(row.getCode()); }
		 */

		/*url = "http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zcustomer2/300/zcustomer2/zcustomer2";
		Bapicustomer04 detail = CustomerExecute.getDetail(url, username,
				password, "3000", "0000765694");
		System.out.println("PRUEBA");*/

		/*
		 * BapicustomerAddressdata[] add = CustomerExecute
		 * .getAddresses("0000765441");
		 * 
		 * Bapikna111[] result = findByDoc("22734930", 0); for (Bapikna111 row :
		 * result) {
		 * 
		 * }
		 */

		/*
		 * String customerNo = null; Bapikna111[] result =
		 * CustomerExecute.findSORTL("8647362", 0); for (Bapikna111 row :
		 * result) { customerNo = row.getCustomer();
		 * System.out.println(row.getCustomer() + "-" + row.getFieldvalue()); }
		 * 
		 * LoadParameters loadParameters = new LoadParameters();
		 * Zfi_customers2Proxy Zfi_customers2Proxy = new Zfi_customers2Proxy(
		 * loadParameters.getURL_CUSTOMER2(), loadParameters.getUser(),
		 * loadParameters.getPassword()); try { Bapiret1 bap =
		 * Zfi_customers2Proxy.customerDisplay(customerNo);
		 * System.out.println(""); } catch (RemoteException e) {
		 * e.printStackTrace(); }
		 */

		// Bapikna111[] result = find("05", 0);
		// for (Bapikna111 row : result) {

		// }

		// System.out.println(result.length);

		// CustomerExecute.getAddresses(0000765441);

		/*
		 * Zfi_customers2Proxy zfi_customers2Proxy = new Zfi_customers2Proxy();
		 * Kna1Holder customerData = new Kna1Holder(); StringHolder
		 * customerNumberOut = new StringHolder(); try {
		 * zfi_customers2Proxy.customerCheckExistence(customerNo1, "20", "10",
		 * "1000", customerData, customerNumberOut, _return2);
		 * System.out.println(customerData.value.getKunnr()); } catch
		 * (RemoteException e) { e.printStackTrace(); }
		 */
	}

	public static void getJson() {
		SugarWS createSugarContact = new SugarWS("http://192.168.1.47/vtigercrm6", "admin", "iMc5y2W2cDQg2vJr");
		/*String result = /*createSugarContact.createAccounts(2,"8647362", "Sarmiento Royero",
				"Carlos Arturo", "Colombia", "Cundinamarca", "Bogotá", "Carrera 55A 163 35", "00000", "6501550",
				"3003044115", "tactusoft@hotmail.com");createSugarContact.getAccounts(5);*/
		System.out.println(createSugarContact.persitLead(5,"864736", "Sarmiento Royero",
				"Carlos", "Colombia", "Cundinamarca", "Bogotá", "Carrera 55A 163 35", "00000", "6501550",
				"3003044115", "tactusoft@hotmail.com",1));
		//System.out.println(createSugarContact.getModules());
		//System.out.println(result);
	}

	public static String convertStreamToString(InputStream is) {
		// The incoming input stream is accumulated in a String to be returned
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
		} catch (IOException e) {
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
		return sb.toString();
	}

}
