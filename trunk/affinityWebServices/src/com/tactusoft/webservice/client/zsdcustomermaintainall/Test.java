package com.tactusoft.webservice.client.zsdcustomermaintainall;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char1;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char10;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char15;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char16;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char2;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char3;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char35;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char4;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Char6;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Clnt3;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Cuky5;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Fknvi;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Kna1;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Knvv;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Lang;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.Numeric2;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.TableOfFknvi;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.ZsdCustomerMaintainAll;
import com.tactusoft.webservice.client.zsdcustomermaintainall.Z_SD_CUSTOMER_MAINTAIN_ALLStub.ZsdCustomerMaintainAllResponse;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// CREAR CLIENTES
		String url = "http://192.168.1.212:8001/sap/bc/srt/rfc/sap/zsd_customer_maintain_all/300/zsd_customer_maintain_all/zsd_customer_maintain_all";
		String username = "TACTUSOFT";
		String password = "AFFINITY";

		String ambiente = "300";
		String tipoDocumento = "1";
		String nroDocumento = "11887766";
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
		String orgVentas = "4000";
		String canalDistribucion = "10";
		String division = "10";
		String sociedad = "4000";
		String oficinaVentas = "1025";
		String grupoCliente = "01";
		String condicionPago = "Z001";
		String cuenta = "1305050000";
		String grupoPrecios = "01";
		String esquemaClientes = "1";
		String estadoCliente = "1";
		String moneda = "COP";

		String result = Test.excecute(url, username, password, ambiente,
				tipoDocumento, nroDocumento, tratamiento, nombre, direccion,
				telefono, celular, correoElectronico, pais, ciudad, region,
				grupoCuenta, orgVentas, canalDistribucion, division, sociedad,
				oficinaVentas, grupoCliente, condicionPago, cuenta,
				grupoPrecios, esquemaClientes, estadoCliente, moneda);

	}

	public static String excecute(String url, String user, String password,
			String ambiente, String tipoDocumento, String nroDocumento,
			String tratamiento, String nombre, String direccion,
			String telefono, String celular, String correoElectronico,
			String pais, String ciudad, String region, String grupoCuenta,
			String orgVentas, String canalDistribucion, String division,
			String sociedad, String oficinaVentas, String grupoCliente,
			String condicionPago, String cuenta, String grupoPrecios,
			String esquemaClientes, String estadoCliente, String moneda) {

		String result = null;

		try {
			Z_SD_CUSTOMER_MAINTAIN_ALLStub stub = new Z_SD_CUSTOMER_MAINTAIN_ALLStub(
					url);

			ServiceClient sc = stub._getServiceClient();
			Options options = sc.getOptions();
			HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
			auth.setPreemptiveAuthentication(true);
			auth.setUsername(user);
			auth.setPassword(password);
			options.setProperty(HTTPConstants.AUTHENTICATE, auth);

			ZsdCustomerMaintainAll zsdCustomerMaintainAll0 = new ZsdCustomerMaintainAll();

			Kna1 ziKna1 = new Kna1();

			Clnt3 mandt = new Clnt3();
			mandt.setClnt3(ambiente);
			ziKna1.setMandt(mandt);
			Char15 anred = new Char15();
			anred.setChar15(tratamiento);
			ziKna1.setAnred(anred);
			Char35 name1 = new Char35();
			name1.setChar35(nombre);
			ziKna1.setName1(name1);
			Char10 sortl = new Char10();
			sortl.setChar10(nroDocumento);
			ziKna1.setSortl(sortl);
			Char4 ktokd = new Char4();
			ktokd.setChar4(grupoCuenta);
			ziKna1.setKtokd(ktokd);
			Char3 land1 = new Char3();
			land1.setChar3(pais);
			ziKna1.setLand1(land1);
			Char35 ort01 = new Char35();
			ort01.setChar35(ciudad);
			ziKna1.setOrt01(ort01);
			Char3 regio = new Char3();
			regio.setChar3(region);
			ziKna1.setRegio(regio);
			Char2 stcdt = new Char2();
			stcdt.setChar2(tipoDocumento);
			ziKna1.setStcdt(stcdt);
			Char16 stcd1 = new Char16();
			stcd1.setChar16(nroDocumento);
			ziKna1.setStcd1(stcd1);
			Char35 stras = new Char35();
			stras.setChar35(direccion);
			ziKna1.setStras(stras);
			Char16 telf1 = new Char16();
			telf1.setChar16(telefono);
			ziKna1.setTelf1(telf1);
			Char16 telf2 = new Char16();
			telf2.setChar16(celular);
			ziKna1.setTelf2(telf2);
			Lang spras = new Lang();
			spras.setLang("S");
			ziKna1.setSpras(spras);// IDIOMA
			Char1 stkzn = new Char1();
			stkzn.setChar1("X");
			ziKna1.setStkzn(stkzn);// Persona Física
			Char2 fityp = new Char2();
			fityp.setChar2("05");
			ziKna1.setFityp(fityp);// Clase Impuesto Persona Natural

			zsdCustomerMaintainAll0.setZiKna1(ziKna1);

			Knvv ziKnvv = new Knvv();
			ziKnvv.setMandt(mandt);
			Char4 vkorg = new Char4();
			vkorg.setChar4(orgVentas);
			ziKnvv.setVkorg(vkorg);
			Char2 vtweg = new Char2();
			vtweg.setChar2(canalDistribucion);
			ziKnvv.setVtweg(vtweg);
			Char2 spart = new Char2();
			spart.setChar2(division);
			ziKnvv.setSpart(spart);
			Char4 vkbur = new Char4();
			vkbur.setChar4(oficinaVentas);
			ziKnvv.setVkbur(vkbur);
			Char2 kdgrp = new Char2();
			kdgrp.setChar2(grupoCliente);
			ziKnvv.setKdgrp(kdgrp);
			// Char4 zterm = new Char4();
			// zterm.setChar4(sociedad);
			// ziKnvv.setZterm(zterm);
			Char6 bzirk = new Char6();
			bzirk.setChar6("COFC05");
			ziKnvv.setBzirk(bzirk);
			Cuky5 waers = new Cuky5();
			waers.setCuky5(moneda);
			ziKnvv.setWaers(waers);
			Char2 konda = new Char2();
			konda.setChar2(grupoPrecios);
			ziKnvv.setKonda(konda);// GRUPO DE PRECIOS 01
			Char1 kalks = new Char1();
			kalks.setChar1(esquemaClientes);
			ziKnvv.setKalks(kalks);// ESQUEMA DE CLIENTES 1
			Char1 versg = new Char1();
			versg.setChar1(estadoCliente);
			ziKnvv.setVersg(versg);// GRUPO ESTADO CLIENTE 1
			Char4 zterm = new Char4();
			zterm.setChar4(condicionPago);
			ziKnvv.setZterm(zterm);
			Numeric2 lprio = new Numeric2();
			lprio.setNumeric2("2");
			ziKnvv.setLprio(lprio);// PRIORIDAD ENTREGA
			Char2 vsbed = new Char2();
			vsbed.setChar2("01");
			ziKnvv.setVsbed(vsbed);// CONDICION EXPEDICION
			ziKnvv.setVwerk(vkorg);// CENTRO DE SUMINISTRO

			zsdCustomerMaintainAll0.setZiKnvv(ziKnvv);

			Fknvi fknvi = new Fknvi();
			fknvi.setMandt(mandt);
			fknvi.setAland(land1);
			Char4 tatyp = new Char4();
			tatyp.setChar4("MWST");
			fknvi.setTatyp(tatyp);
			Char1 taxkd = new Char1();
			taxkd.setChar1("1");
			fknvi.setTaxkd(taxkd);

			Fknvi[] fknviArray = new Fknvi[1];
			fknviArray[0] = fknvi;
			TableOfFknvi ztXknvi = new TableOfFknvi();
			ztXknvi.setItem(fknviArray);
			zsdCustomerMaintainAll0.setZtXknvi(ztXknvi);

			ZsdCustomerMaintainAllResponse response = stub
					.zsdCustomerMaintainAll(zsdCustomerMaintainAll0);

			if (response.getZsySubrc() != 0) {
				result = "ERROR: " + response.getZsyMsgv3();
			} else {
				result = response.getZeKunnr().getChar10();
			}
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return result;

	}
}
