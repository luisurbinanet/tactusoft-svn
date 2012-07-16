package com.tactusoft.webservice.client.execute;

import com.tactusoft.webservice.client.objects.Bapicustomer04;

public class Test {
	
	public static void main(String args[]) {

		// CREAR CLIENTES
		String url = "http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/z_sd_customer_maintain_all/300/z_sd_customer_maintain_all/z_sd_customer_maintain_all";
		String username = "TACTUSOFT";
		String password = "AFFINITY";

		String ambiente = "300";
		String tipoDocumento = "1";
		String nroDocumento = "MX00000121";
		String tratamiento = "Señor";
		String nombres = "Carlos Arturo ";
		String apellidos = "Sarmiento Royero";
		String direccion = "PRUEBA1207111";
		String telefono = "PRUEBA1207111";
		String codigoPostal = "12345";
		String celular = "PRUEBA1207111";
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

		url = "http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zcustomer2/300/zcustomer2/zcustomer2";
		Bapicustomer04 detail = CustomerExecute.getDetail(url, username, password, "3000",
				"0000765694");
		System.out.println("PRUEBA");

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


}
