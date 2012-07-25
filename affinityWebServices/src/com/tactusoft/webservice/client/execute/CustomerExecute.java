package com.tactusoft.webservice.client.execute;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.rpc.holders.StringHolder;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.beans.WSBeanComparator;
import com.tactusoft.webservice.client.beans.WSBeanPatient;
import com.tactusoft.webservice.client.holders.Bapicustomer04Holder;
import com.tactusoft.webservice.client.holders.Bapicustomer05Holder;
import com.tactusoft.webservice.client.holders.BapicustomerKna1Holder;
import com.tactusoft.webservice.client.holders.Bapikna1011Holder;
import com.tactusoft.webservice.client.holders.Bapikna105Holder;
import com.tactusoft.webservice.client.holders.Bapikna106Holder;
import com.tactusoft.webservice.client.holders.Bapikna109Holder;
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
import com.tactusoft.webservice.client.objects.Bapikna1011;
import com.tactusoft.webservice.client.objects.Bapikna1011X;
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
			String tratamiento, String apellidos, String nombres,
			String direccion, String codigoPostal, String telefono,
			String celular, String correoElectronico, String pais,
			String ciudad, String region, String grupoCuenta, String orgVentas,
			String canalDistribucion, String division, String sociedad,
			String oficinaVentas, String grupoCliente, String condicionPago,
			String cuenta, String grupoPrecios, String esquemaClientes,
			String estadoCliente, String moneda) {

		// CREAR CLIENTES
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

		String apellidos17 = apellidos;
		if (apellidos17.length() > 17) {
			apellidos17 = apellidos17.substring(0, 17);
		}

		String nombres17 = nombres;
		if (nombres17.length() > 17) {
			nombres17 = nombres17.substring(0, 17);
		}

		String names = apellidos17 + " " + nombres17;

		Kna1 ziKna1 = new Kna1();
		ziKna1.setMandt(ambiente);
		ziKna1.setAnred(tratamiento);
		ziKna1.setName1(names);
		ziKna1.setSortl(nroDocumento);
		ziKna1.setKtokd(grupoCuenta);
		ziKna1.setLand1(pais);
		ziKna1.setOrt01(ciudad);
		ziKna1.setRegio(region);
		ziKna1.setStcdt(tipoDocumento);
		ziKna1.setStcd1(nroDocumento);
		ziKna1.setStras(direccion);
		ziKna1.setPstlz(codigoPostal);
		ziKna1.setTelf1(telefono);
		ziKna1.setTelfx(celular);
		ziKna1.setSpras("S");// IDIOMA
		ziKna1.setStkzn("X");// Persona Física
		ziKna1.setFityp("05");// Clase Impuesto Persona Natural

		Bapiaddr1 ziBapiaddr1 = new Bapiaddr1();
		Bapiaddr2 ziBapiaddr2 = new Bapiaddr2();

		TableOfFknvkHolder ztXknvk = new TableOfFknvkHolder();

		Knvv ziKnvv = new Knvv();
		ziKnvv.setMandt(ambiente);
		ziKnvv.setVkorg(orgVentas);
		ziKnvv.setVtweg(canalDistribucion);
		ziKnvv.setSpart(division);
		ziKnvv.setVkbur(oficinaVentas);
		ziKnvv.setKdgrp(grupoCliente);
		ziKnvv.setBzirk("COFC05");
		ziKnvv.setWaers(moneda);
		ziKnvv.setKonda(grupoPrecios);// GRUPO DE PRECIOS 01
		ziKnvv.setKalks(esquemaClientes);// ESQUEMA DE CLIENTES 1
		ziKnvv.setVersg(estadoCliente);// GRUPO ESTADO CLIENTE 1
		ziKnvv.setZterm(condicionPago);
		ziKnvv.setLprio("2");// PRIORIDAD ENTREGA
		ziKnvv.setVsbed("01");// CONDICION EXPEDICION
		ziKnvv.setVwerk(orgVentas);// CENTRO DE SUMINISTRO

		Knb1 ziKnb1 = new Knb1();
		ziKnb1.setMandt(ambiente);
		ziKnb1.setBukrs(sociedad);
		ziKnb1.setAkont(cuenta);// cuenta asociada
		ziKnb1.setZterm(condicionPago);

		Fknvi fknvi = new Fknvi();
		fknvi.setMandt(ambiente);
		fknvi.setAland(pais);
		fknvi.setTatyp("MWST");
		fknvi.setTaxkd("1");

		Fknvi[] fknviArray = new Fknvi[1];
		fknviArray[0] = fknvi;
		TableOfFknviHolder ztXknvi = new TableOfFknviHolder(fknviArray);

		ziMaintainAddressByKna1 = "X";

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

	public static String update(String customerNo, String url, String user,
			String password, String tratamiento, String apellidos,
			String nombres, String direccion, String codigoPostal,
			String telefono, String celular, String correoElectronico,
			String pais, String ciudad, String region, String orgVentas,
			String canalDistribucion, String division, String moneda) {

		Bapireturn1 result = new Bapireturn1();
		Zfi_customers2Proxy Zfi_customers2Proxy = new Zfi_customers2Proxy(url,
				user, password);

		try {
			Bapikna109Holder addressTypeNo = new Bapikna109Holder();
			Bapikna106Holder companyData = new Bapikna106Holder();
			StringHolder consumerFlag = new StringHolder();
			Bapikna105Holder optionalCompanyData = new Bapikna105Holder();
			Bapikna105Holder optionalPersonalData = new Bapikna105Holder();
			Bapikna105Holder optionalPersonalDataNew = new Bapikna105Holder();
			Bapikna1011Holder personalData = new Bapikna1011Holder();
			Bapikna1011Holder personalDataNew = new Bapikna1011Holder();
			Bapireturn1Holder _return = new Bapireturn1Holder();

			Zfi_customers2Proxy.customerGetDetail1(customerNo,
					canalDistribucion, division, orgVentas, addressTypeNo,
					companyData, consumerFlag, optionalCompanyData,
					optionalPersonalData, optionalPersonalDataNew,
					personalData, personalDataNew, _return);

			Bapikna1011 bapikna1011 = null;
			if (personalData.value.getLastname().isEmpty()) {
				bapikna1011 = personalDataNew.value;
			} else {
				bapikna1011 = personalData.value;
			}

			String apellidos17 = apellidos;
			if (apellidos17.length() > 17) {
				apellidos17 = apellidos17.substring(0, 17);
			}

			String nombres17 = nombres;
			if (nombres17.length() > 35) {
				nombres17 = nombres17.substring(0, 17);
			}

			bapikna1011.setCurrency(moneda);

			bapikna1011.setTitleP(tratamiento);
			bapikna1011.setOnlyChangeComaddress("X");
			bapikna1011.setLastname(apellidos17);
			bapikna1011.setFirstname(nombres17);
			bapikna1011.setStreet(direccion);
			bapikna1011.setPostlCod1(codigoPostal);
			bapikna1011.setTel1Numbr(telefono);
			bapikna1011.setCountry(pais);
			bapikna1011.setRegion(region);
			bapikna1011.setCity(ciudad);
			bapikna1011.setEMail(correoElectronico);

			Bapikna1011X personalDataX = new Bapikna1011X();
			personalDataX.setTitleP("X");
			personalDataX.setLastname("X");
			personalDataX.setFirstname("X");
			personalDataX.setStreet("X");
			personalDataX.setPostlCod1("X");
			personalDataX.setTel1Numbr("X");
			personalDataX.setCountry("X");
			personalDataX.setRegion("X");
			personalDataX.setCity("X");
			personalDataX.setEMail("X");

			result = Zfi_customers2Proxy.customerChangeFromData1(null,
					null, customerNo, canalDistribucion, division, null,
					null, null, null, bapikna1011, personalDataX, orgVentas);

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return result.getNumber();
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

		try {
			zBAPI_CUSTOMER_FINDProxy.customerFind(maxCnt, plHold, resultTab,
					seloptTab);

			if (resultTab.value[0].getCustomer().isEmpty()) {
				return null;
			} else {
				return resultTab.value;
			}

		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

		return null;
	}

	public static List<WSBean> findByName(String url, String user,
			String password, String society, String names, int maxCnt) {
		List<WSBean> result = new ArrayList<WSBean>();
		names = "*" + names.replace(" ", "*") + "*";

		Bapikna111[] list = find(url, user, password, "NAME1", names, maxCnt);
		if (list != null && !list[0].getType().equals("E")) {
			for (Bapikna111 row : list) {
				Bapicustomer04 bapicustomer04 = getDetail(url, user, password,
						society, row.getCustomer());
				if (bapicustomer04 != null) {
					WSBean bean = new WSBean();
					bean.setCode(row.getCustomer());
					bean.setNames(bapicustomer04.getName());
					bean.setSociety(society);
					bean.setCountry(bapicustomer04.getCountry().isEmpty() ? "-1"
							: bapicustomer04.getCountry());
					bean.setRegion(bapicustomer04.getRegion().isEmpty() ? "-1"
							: bapicustomer04.getRegion());
					bean.setCity(bapicustomer04.getCity().isEmpty() ? "-1"
							: bapicustomer04.getCity());
					bean.setAddress(bapicustomer04.getStreet());
					bean.setTelephone1(bapicustomer04.getTelephone());
					bean.setTelephone2(bapicustomer04.getTelephone2());
					bean.setEmail("");
					result.add(bean);
				}
			}
		}

		Collections.sort(result, new WSBeanComparator());
		return result;
	}

	public static List<WSBean> findByName(String url, String user,
			String password, String society, String names) {
		return findByName(url, user, password, society, names, 0);
	}

	public static List<WSBean> findByDoc(String url, String user,
			String password, String society, String doc, int maxCnt) {
		List<WSBean> result = new ArrayList<WSBean>();

		Bapikna111[] list = find(url, user, password, "STCD1", doc, maxCnt);
		if (list != null && !list[0].getType().equals("E")) {
			Bapikna111 row = list[0];
			Bapicustomer04 bapicustomer04 = getDetail(url, user, password,
					society, row.getCustomer());
			if (bapicustomer04 != null) {
				WSBean bean = new WSBean();
				bean.setCode(row.getCustomer());
				bean.setNames(bapicustomer04.getName());
				bean.setSociety(society);
				bean.setCountry(bapicustomer04.getCountry().isEmpty() ? "-1"
						: bapicustomer04.getCountry());
				bean.setRegion(bapicustomer04.getRegion().isEmpty() ? "-1"
						: bapicustomer04.getRegion());
				bean.setCity(bapicustomer04.getCity().isEmpty() ? "-1"
						: bapicustomer04.getCity());
				bean.setAddress(bapicustomer04.getStreet());
				bean.setTelephone1(bapicustomer04.getTelephone());
				bean.setTelephone2(bapicustomer04.getTelephone2());
				bean.setEmail("");
				result.add(bean);
			}
		}

		Collections.sort(result, new WSBeanComparator());
		return result;
	}

	public static List<WSBean> findByDoc(String url, String user,
			String password, String society, String doc) {
		return findByDoc(url, user, password, society, doc, 0);
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

		if (customerAddress.value.getCustomer().isEmpty()) {
			return null;
		} else {
			return customerAddress.value;
		}
	}

	public static WSBeanPatient getDetailcomplete(String url, String user,
			String password, String customerNo, String orgVentas,
			String canalDistribucion, String division) {

		WSBeanPatient result = null;
		Zfi_customers2Proxy Zfi_customers2Proxy = new Zfi_customers2Proxy(url,
				user, password);

		try {
			Bapikna109Holder addressTypeNo = new Bapikna109Holder();
			Bapikna106Holder companyData = new Bapikna106Holder();
			StringHolder consumerFlag = new StringHolder();
			Bapikna105Holder optionalCompanyData = new Bapikna105Holder();
			Bapikna105Holder optionalPersonalData = new Bapikna105Holder();
			Bapikna105Holder optionalPersonalDataNew = new Bapikna105Holder();
			Bapikna1011Holder personalData = new Bapikna1011Holder();
			Bapikna1011Holder personalDataNew = new Bapikna1011Holder();
			Bapireturn1Holder _return = new Bapireturn1Holder();

			Zfi_customers2Proxy.customerGetDetail1(customerNo,
					canalDistribucion, division, orgVentas, addressTypeNo,
					companyData, consumerFlag, optionalCompanyData,
					optionalPersonalData, optionalPersonalDataNew,
					personalData, personalDataNew, _return);

			if (!_return.value.getType().equals("E")) {
				Bapikna1011 bapikna1011 = null;
				if (personalData.value.getLastname().isEmpty()) {
					bapikna1011 = personalDataNew.value;
				} else {
					bapikna1011 = personalData.value;
				}

				result = new WSBeanPatient();
				result.setCodeSap(customerNo);
				result.setLastname(bapikna1011.getLastname());
				result.setFirstname(bapikna1011.getFirstname());
				result.setCountry(bapikna1011.getCountry());
				result.setRegion(bapikna1011.getRegion());
				result.setCity(bapikna1011.getCity());
				result.setAddress(bapikna1011.getStreet());
				result.setZipCode(bapikna1011.getPostlCod1());
				result.setPhoneNumber(bapikna1011.getTel1Numbr());
				result.setEmail(bapikna1011.getEMail());

				if (bapikna1011.getTitleP().equals("Señor")) {
					result.setGender("M");
				} else {
					result.setGender("W");
				}
			}

		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return result;
	}
}
