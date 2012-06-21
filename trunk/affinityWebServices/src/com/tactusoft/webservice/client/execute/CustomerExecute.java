package com.tactusoft.webservice.client.execute;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.holders.StringHolder;

import com.tactusoft.webservice.client.beans.WSBean;
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
			String condicionPago, String cuenta) {

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
		TableOfFknvkHolder ztXknvk = new TableOfFknvkHolder();
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
		ziKnvv.setKonda("01");// GRUPO DE PRECIOS
		ziKnvv.setKalks("1");// ESQUEMA DE CLIENTES
		ziKnvv.setVersg("1");// GRUPO ESTADO CLIENTE
		ziKnvv.setZterm(condicionPago);
		ziKnvv.setVsbed("01");// CONDICION EXPEDICION
		ziKnvv.setLprio("2");// PRIORIDAD ENTREGA
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
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

		if (bapireturn1.getType().equals("E")) {
			return null;
		} else {
			return resultTab.value;
		}
	}

	public static List<WSBean> findByName(String url, String user,
			String password, String value, int maxCnt) {
		List<WSBean> result = new ArrayList<WSBean>();
		value = "*" + value.replace(" ", "*") + "*";
		Bapikna111[] list = find(url, password, value, "NAME1", value, maxCnt);
		for (Bapikna111 row : list) {
			result.add(new WSBean(row.getCustomer(), row.getFieldvalue()));
		}
		return result;
	}

	public static List<WSBean> findByDoc(String url, String user,
			String password, String value, String society, int maxCnt) {
		List<WSBean> result = new ArrayList<WSBean>();
		Bapikna111[] list = find(url, password, value, "SORTL", value, maxCnt);
		for (Bapikna111 row : list) {
			Bapicustomer04 bapicustomer04 = getDetail(url, user, password,
					society, row.getCustomer());
			result.add(new WSBean(row.getCustomer(), bapicustomer04.getName()));
		}
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
		/*
		 * String code = CustomerExecute.excecute("300", "13", "PRUEBAX99", "1",
		 * "PRUEBAX99", "CO", "BOGOTA", "11", "D001", "4000", "10", "10",
		 * "4000", "4025", "01", "Z001", "PRUEBAX99", "37222477", "PRUEBAX99",
		 * "PRUEBAX99@PRUEBAX3.COM");
		 */

		findByDoc("http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zcustomer2/300/zcustomer2/zcustomer2","TACTUSOFT","AFFINITY","4000","22734930",0);
		// Bapicustomer04 detail = getDetail("1000", "0000137537");

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
