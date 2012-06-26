package com.tactusoft.webservice.client.execute;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.rpc.holders.StringHolder;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.beans.WSBeanComparator;
import com.tactusoft.webservice.client.holders.Bapicustomer04Holder;
import com.tactusoft.webservice.client.holders.Bapicustomer05Holder;
import com.tactusoft.webservice.client.holders.BapicustomerKna1Holder;
import com.tactusoft.webservice.client.holders.Bapiret1Holder;
import com.tactusoft.webservice.client.holders.Bapireturn1Holder;
import com.tactusoft.webservice.client.holders.Kna1Holder;
import com.tactusoft.webservice.client.holders.TableOfBapicustomer02Holder;
import com.tactusoft.webservice.client.holders.TableOfBapicustomerAddressdataHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicustomerSpecialdataHolder;
import com.tactusoft.webservice.client.holders.TableOfBapikna110Holder;
import com.tactusoft.webservice.client.holders.TableOfBapikna111Holder;
import com.tactusoft.webservice.client.holders.TableOfFknasHolder;
import com.tactusoft.webservice.client.holders.TableOfFknb5Holder;
import com.tactusoft.webservice.client.holders.TableOfFknbkHolder;
import com.tactusoft.webservice.client.holders.TableOfFknexHolder;
import com.tactusoft.webservice.client.holders.TableOfFknvaHolder;
import com.tactusoft.webservice.client.holders.TableOfFknvdHolder;
import com.tactusoft.webservice.client.holders.TableOfFknviHolder;
import com.tactusoft.webservice.client.holders.TableOfFknvkHolder;
import com.tactusoft.webservice.client.holders.TableOfFknvlHolder;
import com.tactusoft.webservice.client.holders.TableOfFknvpHolder;
import com.tactusoft.webservice.client.holders.TableOfFknzaHolder;
import com.tactusoft.webservice.client.holders.TableOfFkuntxtHolder;
import com.tactusoft.webservice.client.locators.ZBAPI_CUSTOMER_FINDProxy;
import com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALLProxy;
import com.tactusoft.webservice.client.locators.Zfi_customers2Proxy;
import com.tactusoft.webservice.client.objects.Bapiaddr1;
import com.tactusoft.webservice.client.objects.Bapiaddr2;
import com.tactusoft.webservice.client.objects.Bapicustomer04;
import com.tactusoft.webservice.client.objects.BapicustomerAddressdata;
import com.tactusoft.webservice.client.objects.BapicustomerIdrange;
import com.tactusoft.webservice.client.objects.Bapikna110;
import com.tactusoft.webservice.client.objects.Bapikna111;
import com.tactusoft.webservice.client.objects.Bapireturn1;
import com.tactusoft.webservice.client.objects.CustAddOnData;
import com.tactusoft.webservice.client.objects.Fknvi;
import com.tactusoft.webservice.client.objects.Fknvk;
import com.tactusoft.webservice.client.objects.Kna1;
import com.tactusoft.webservice.client.objects.Knb1;
import com.tactusoft.webservice.client.objects.Knvv;

public class CustomerExecute {

	public static String excecute(String url, String user, String password,
			String ambiente, String tipoDocumento, String nroDocumento,
			String tratamiento, String nombre, String direccion,
			String telefono, String celular, String correoElectronico,
			String pais, String ciudad, String region, String grupoCuenta,
			String orgVentas, String canalDistribucion, String division,
			String sociedad, String oficinaVentas, String grupoCliente,
			String condicionPago, String cuenta, String grupoPrecios, 
			String esquemaClientes, String estadoCliente) {

		// CREAR CLIENTES
		Bapiaddr2 ziBapiaddr2 = new Bapiaddr2();
		String ziCustomerIsConsumer = new String();
		String ziForceExternalNumberRange = new String();
		String ziFromCustomermaster = new String();
		String ziKnb1Reference = null;

		String ziMaintainAddressByKna1 = null;
		String ziNoBankMasterUpdate = null;
		String ziRaiseNoBte = null;
		CustAddOnData zpiAddOnData = new CustAddOnData();
		String zpiCamChanged = null;
		String zpiPostflag = null;
		TableOfFkuntxtHolder ztUpdTxt = new TableOfFkuntxtHolder();
		TableOfFknasHolder ztXknas = new TableOfFknasHolder();
		TableOfFknb5Holder ztXknb5 = new TableOfFknb5Holder();
		TableOfFknbkHolder ztXknbk = new TableOfFknbkHolder();
		TableOfFknexHolder ztXknex = new TableOfFknexHolder();
		TableOfFknvaHolder ztXknva = new TableOfFknvaHolder();
		TableOfFknvdHolder ztXknvd = new TableOfFknvdHolder();
		TableOfFknvlHolder ztXknvl = new TableOfFknvlHolder();
		TableOfFknvpHolder ztXknvp = new TableOfFknvpHolder();
		TableOfFknzaHolder ztXknza = new TableOfFknzaHolder();
		TableOfFknasHolder ztYknas = new TableOfFknasHolder();
		TableOfFknb5Holder ztYknb5 = new TableOfFknb5Holder();
		TableOfFknbkHolder ztYknbk = new TableOfFknbkHolder();
		TableOfFknexHolder ztYknex = new TableOfFknexHolder();
		TableOfFknvaHolder ztYknva = new TableOfFknvaHolder();
		TableOfFknvdHolder ztYknvd = new TableOfFknvdHolder();
		TableOfFknviHolder ztYknvi = new TableOfFknviHolder();
		TableOfFknvkHolder ztYknvk = new TableOfFknvkHolder();
		TableOfFknvlHolder ztYknvl = new TableOfFknvlHolder();
		TableOfFknvpHolder ztYknvp = new TableOfFknvpHolder();
		TableOfFknzaHolder ztYknza = new TableOfFknzaHolder();
		StringHolder zeKunnr = new StringHolder();
		Kna1Holder zoKna1 = new Kna1Holder();

		Kna1 ziKna1 = new Kna1();
		ziKna1.setMandt(ambiente);
		ziKna1.setAnred(tratamiento);
		ziKna1.setName1(nombre);
		ziKna1.setSortl(nroDocumento);
		ziKna1.setKtokd(grupoCuenta);
		ziKna1.setLand1(pais);
		ziKna1.setOrt01(ciudad);
		ziKna1.setRegio(region);
		ziKna1.setStcdt(tipoDocumento);
		ziKna1.setStcd1(nroDocumento);
		ziKna1.setStras(direccion);
		ziKna1.setTelf1(telefono);
		ziKna1.setTelf2(celular);
		ziKna1.setSpras("S");// IDIOMA
		ziKna1.setStkzn("X");// Persona Física
		ziKna1.setFityp("05");// Clase Impuesto Persona Natural
		
		Fknvk fknvk = new Fknvk();
		fknvk.setMandt(ambiente);
		fknvk.setGbdat("1982-01-01");
		Fknvk[] fknvkArray = new Fknvk[1];
		fknvkArray[0] = fknvk;
		TableOfFknvkHolder ztXknvk = new TableOfFknvkHolder(fknvkArray);

		Bapiaddr1 ziBapiaddr1 = new Bapiaddr1();

		Knvv ziKnvv = new Knvv();
		ziKnvv.setMandt(ambiente);
		ziKnvv.setVkorg(orgVentas);
		ziKnvv.setVtweg(canalDistribucion);
		ziKnvv.setSpart(division);
		ziKnvv.setVkbur(oficinaVentas);
		ziKnvv.setKdgrp(grupoCliente);
		ziKnvv.setZterm(sociedad);
		ziKnvv.setBzirk("COFC05");
		ziKnvv.setWaers("COP");
		ziKnvv.setKonda(grupoPrecios);// GRUPO DE PRECIOS 01
		ziKnvv.setKalks(esquemaClientes);// ESQUEMA DE CLIENTES 1
		ziKnvv.setVersg(estadoCliente);// GRUPO ESTADO CLIENTE 1
		ziKnvv.setZterm(condicionPago);
		ziKnvv.setLprio("2");// PRIORIDAD ENTREGA
		ziKnvv.setVsbed("01");// CONDICION EXPEDICION
		ziKnvv.setVwerk(orgVentas);// CENTRO DE SUMINISTRO

		Knb1 ziKnb1 = new Knb1();
		ziKnb1.setMandt(ambiente);
		ziKnb1.setBukrs(orgVentas);
		ziKnb1.setAkont(cuenta);// cuenta asociada
		ziKnb1.setZterm(condicionPago);

		Fknvi fknvi = new Fknvi();
		fknvi.setMandt(ambiente);
		fknvi.setAland("CO");
		fknvi.setTatyp("MWST");
		fknvi.setTaxkd("1");

		Fknvi[] fknviArray = new Fknvi[1];
		fknviArray[0] = fknvi;
		TableOfFknviHolder ztXknvi = new TableOfFknviHolder(fknviArray);

		ZSD_CUSTOMER_MAINTAIN_ALLProxy execute = new ZSD_CUSTOMER_MAINTAIN_ALLProxy(
				url, user, password);
		try {
			execute.zsdCustomerMaintainAll(ziBapiaddr1, ziBapiaddr2,
					ziCustomerIsConsumer, ziForceExternalNumberRange,
					ziFromCustomermaster, ziKna1, ziKnb1, ziKnb1Reference,
					ziKnvv, ziMaintainAddressByKna1, ziNoBankMasterUpdate,
					ziRaiseNoBte, zpiAddOnData, zpiCamChanged, zpiPostflag,
					ztUpdTxt, ztXknas, ztXknb5, ztXknbk, ztXknex, ztXknva,
					ztXknvd, ztXknvi, ztXknvk, ztXknvl, ztXknvp, ztXknza,
					ztYknas, ztYknb5, ztYknbk, ztYknex, ztYknva, ztYknvd,
					ztYknvi, ztYknvk, ztYknvl, ztYknvp, ztYknza, zeKunnr,
					zoKna1);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return zeKunnr.value;
	}

	public static Bapikna111[] find(String url, String user, String password,
			String field, String value, int maxCnt) {
		ZBAPI_CUSTOMER_FINDProxy zBAPI_CUSTOMER_FINDProxy = new ZBAPI_CUSTOMER_FINDProxy(
				url, user, password);

		String plHold = "X";
		TableOfBapikna111Holder resultTab = new TableOfBapikna111Holder();

		Bapikna110 condition1 = new Bapikna110();
		condition1.setTabname("KNA1");
		condition1.setFieldname(field);
		condition1.setFieldvalue(value);

		Bapikna110[] arrayBapikna110 = new Bapikna110[1];
		arrayBapikna110[0] = condition1;

		TableOfBapikna110Holder seloptTab = new TableOfBapikna110Holder(
				arrayBapikna110);

		Bapireturn1 bapireturn1 = null;
		try {
			bapireturn1 = zBAPI_CUSTOMER_FINDProxy.customerFind(maxCnt, plHold,
					resultTab, seloptTab);

			if (bapireturn1.getType().equals("E")) {
				return null;
			} else {
				return resultTab.value;
			}

		} catch (RemoteException e1) {
			// e1.printStackTrace();
		}

		return null;
	}

	public static List<WSBean> findByName(String url, String user,
			String password, String value, int maxCnt) {
		List<WSBean> result = new ArrayList<WSBean>();
		value = "*" + value.replace(" ", "*") + "*";
		Bapikna111[] list = find(url, user, password, "NAME1", value, maxCnt);
		if (list != null && list[0].getType().equals("S")) {
			for (Bapikna111 row : list) {
				result.add(new WSBean(row.getCustomer(), row.getFieldvalue()));
			}
		}

		Collections.sort(result, new WSBeanComparator());
		return result;
	}

	public static List<WSBean> findByDoc(String url, String user,
			String password, String society, String value, int maxCnt) {
		List<WSBean> result = new ArrayList<WSBean>();
		Bapikna111[] list = find(url, user, password, "SORTL", value, maxCnt);
		if (list != null && list[0].getType().equals("S")) {
			for (Bapikna111 row : list) {
				Bapicustomer04 bapicustomer04 = getDetail(url, user, password,
						society, row.getCustomer());
				result.add(new WSBean(row.getCustomer(), bapicustomer04
						.getName()));
			}
		}

		Collections.sort(result, new WSBeanComparator());
		return result;
	}

	public static BapicustomerAddressdata[] getAddresses(String url,
			String user, String password, String customer) {
		Zfi_customers2Proxy Zfi_customers2Proxy = new Zfi_customers2Proxy(url,
				user, password);
		String CPDOnly = " ";
		BapicustomerIdrange[] idRange = new BapicustomerIdrange[1];
		BapicustomerIdrange bapicustomerIdrange = new BapicustomerIdrange();
		bapicustomerIdrange.setSign("I");
		bapicustomerIdrange.setOption("BT");
		bapicustomerIdrange.setLow(customer);
		bapicustomerIdrange.setHigh(customer);
		idRange[0] = bapicustomerIdrange;
		Integer maxRows = 100;
		TableOfBapicustomerAddressdataHolder addressData = new TableOfBapicustomerAddressdataHolder();
		Bapireturn1Holder _return = new Bapireturn1Holder();
		TableOfBapicustomerSpecialdataHolder specialData = new TableOfBapicustomerSpecialdataHolder();

		try {
			Zfi_customers2Proxy.customerGetList(CPDOnly, idRange, maxRows,
					addressData, _return, specialData);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return addressData.value;
	}

	public static Bapicustomer04 getDetail(String url, String user,
			String password, String companycode, String customerNo) {
		Zfi_customers2Proxy Zfi_customers2Proxy = new Zfi_customers2Proxy(url,
				user, password);

		Bapicustomer04Holder customerAddress = new Bapicustomer04Holder();
		TableOfBapicustomer02Holder customerBankDetail = new TableOfBapicustomer02Holder();
		Bapicustomer05Holder customerCompanyDetail = new Bapicustomer05Holder();
		BapicustomerKna1Holder customerGeneralDetail = new BapicustomerKna1Holder();
		Bapiret1Holder _return = new Bapiret1Holder();

		try {
			Zfi_customers2Proxy.customerGetDetail2(companycode, customerNo,
					customerAddress, customerBankDetail, customerCompanyDetail,
					customerGeneralDetail, _return);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return customerAddress.value;
	}

	public static void main(String args[]) {

		// CREAR CLIENTES
		String url = "http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zsd_customer_maintain_all/300/zsd_customer_maintain_all/zsd_customer_maintain_all";
		String username = "TACTUSOFT";
		String password = "AFFINITY";
		
		
		/*String ambiente = "300";
		String tipoDocumento = "1";
		String nroDocumento = "86473621";
		String tratamiento = "1";
		String nombre = "Carlos Arturo Sarmiento";
		String direccion = "Carrera 55A 163 35";
		String telefono = "6501550";
		String celular = "3003044115";
		String correoElectronico = "carlossarmientor@gmail.com";
		String pais = "CO";
		String ciudad = "BOGOTA";
		String region = "11";
		String grupoCuenta = "D001";
		String orgVentas = "1000";
		String canalDistribucion = "10";
		String division = "10";
		String sociedad = "1000";
		String oficinaVentas = "1025";
		String grupoCliente = "01";
		String condicionPago = "Z001";
		String cuenta = "1305050000";
		String grupoPrecios = "01"; 
		String esquemaClientes = "1"; 
		String estadoCliente = "1";
		
		String code = CustomerExecute.excecute(url, username, password, ambiente,
				tipoDocumento, nroDocumento, tratamiento, nombre, direccion,
				telefono, celular, correoElectronico, pais, ciudad, region,
				grupoCuenta, orgVentas, canalDistribucion, division, sociedad,
				oficinaVentas, grupoCliente, condicionPago, cuenta, grupoPrecios,
				esquemaClientes, estadoCliente);
		
		System.out.println("PRUEBA");*/

		
		List<WSBean> result = findByDoc(url, username, password, "1000",
		"PRUEBAD1", 0); 
		for (WSBean row : result) {
			System.out.println(row.getCode());
		}	


		url = "http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zcustomer2/300/zcustomer2/zcustomer2";
		//Bapicustomer04 detail = getDetail(url, username, password, "1000",
		//		"0000765439");
		//System.out.println("PRUEBA");

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
