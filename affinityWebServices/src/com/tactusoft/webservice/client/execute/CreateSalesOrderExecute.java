package com.tactusoft.webservice.client.execute;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tactusoft.webservice.client.custom.MaterialesCustom;
import com.tactusoft.webservice.client.custom.ResultCreateOrder;
import com.tactusoft.webservice.client.holders.TableOfBapiaddr1Holder;
import com.tactusoft.webservice.client.holders.TableOfBapiccardHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicondHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicondxHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicublbHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicucfgHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicuinsHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicuprtHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicurefHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicuvalHolder;
import com.tactusoft.webservice.client.holders.TableOfBapicuvkHolder;
import com.tactusoft.webservice.client.holders.TableOfBapiparexHolder;
import com.tactusoft.webservice.client.holders.TableOfBapiparnrHolder;
import com.tactusoft.webservice.client.holders.TableOfBapiret2Holder;
import com.tactusoft.webservice.client.holders.TableOfBapischdlHolder;
import com.tactusoft.webservice.client.holders.TableOfBapischdlxHolder;
import com.tactusoft.webservice.client.holders.TableOfBapisditmHolder;
import com.tactusoft.webservice.client.holders.TableOfBapisditmxHolder;
import com.tactusoft.webservice.client.holders.TableOfBapisdkeyHolder;
import com.tactusoft.webservice.client.holders.TableOfBapisdtextHolder;
import com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDATProxy;
import com.tactusoft.webservice.client.objects.Bapicond;
import com.tactusoft.webservice.client.objects.Bapiparnr;
import com.tactusoft.webservice.client.objects.Bapiret2;
import com.tactusoft.webservice.client.objects.Bapischdl;
import com.tactusoft.webservice.client.objects.Bapisdhd1;
import com.tactusoft.webservice.client.objects.Bapisdhd1X;
import com.tactusoft.webservice.client.objects.Bapisditm;
import com.tactusoft.webservice.client.objects.Bapisdls;
import com.tactusoft.webservice.client.objects.Sender;

public class CreateSalesOrderExecute {

	public static final String BLANK = "0";

	public static ResultCreateOrder execute(String url, String username,
			String password, String tipoDocVenta, String orgVentas,
			String canalDistribucion, String division, String oficinaVentas,
			String fechaPedido, String cliente, String viaPago,
			String condicionPago, String solicitante,
			List<MaterialesCustom> listMaterial, String interlocutor,
			String codigoPauta, String medico, String condicionCabecera) {

		ZBAPI_SALESORDER_CREATEFROMDATProxy createSalesOrder = new ZBAPI_SALESORDER_CREATEFROMDATProxy(
				url, username, password);
		ResultCreateOrder result = new ResultCreateOrder();

		try {

			Bapisdhd1 orderHeaderIn = new Bapisdhd1();
			orderHeaderIn.setDocType(tipoDocVenta);
			orderHeaderIn.setSalesOrg(orgVentas);
			orderHeaderIn.setDistrChan(canalDistribucion);
			orderHeaderIn.setSalesOff(oficinaVentas);
			orderHeaderIn.setDivision(division);
			orderHeaderIn.setPurchDate(fechaPedido);
			orderHeaderIn.setPurchNoC("MSJ63958");
			orderHeaderIn.setPymtMeth(viaPago);
			orderHeaderIn.setPmnttrms(condicionPago);
			orderHeaderIn.setSalesGrp(codigoPauta);
			orderHeaderIn.setReqDateH(fechaPedido);
			orderHeaderIn.setPriceDate(fechaPedido);
			orderHeaderIn.setCreatedBy("TACTUSOFT");

			List<Bapiparnr> bapiparnrList = new ArrayList<Bapiparnr>();
			Bapiparnr bapiparnr = new Bapiparnr();
			bapiparnr.setPartnRole("AG");
			bapiparnr.setPartnNumb(cliente);
			bapiparnrList.add(bapiparnr);

			bapiparnr = new Bapiparnr();
			bapiparnr.setPartnRole("RE");
			bapiparnr.setPartnNumb(cliente);
			bapiparnrList.add(bapiparnr);

			bapiparnr = new Bapiparnr();
			bapiparnr.setPartnRole("RG");
			bapiparnr.setPartnNumb(cliente);
			bapiparnrList.add(bapiparnr);

			bapiparnr = new Bapiparnr();
			bapiparnr.setPartnRole("WE");
			bapiparnr.setPartnNumb(cliente);
			bapiparnrList.add(bapiparnr);

			if (medico != null) {
				bapiparnr = new Bapiparnr();
				bapiparnr.setPartnRole("Z2");
				bapiparnr.setPartnNumb(medico);
				bapiparnrList.add(bapiparnr);
			}

			Bapiparnr[] bapiparnrArray = new Bapiparnr[bapiparnrList.size()];
			int index = 0;
			for (Bapiparnr row : bapiparnrList) {
				bapiparnrArray[index] = row;
				index++;
			}

			TableOfBapiparnrHolder orderPartners = new TableOfBapiparnrHolder(
					bapiparnrArray);

			// DETALLE PEDIDO
			Bapisditm[] bapisditmArray = new Bapisditm[listMaterial.size()];
			Bapischdl[] bapischdlArray = new Bapischdl[listMaterial.size()];
			Bapicond[] bapicondArray = new Bapicond[listMaterial.size()];

			Bapisditm bapisditm;
			Bapischdl bapischdl;
			Bapicond bapicond = new Bapicond();

			index = 0;

			if (condicionCabecera != null) {
				bapicondArray = new Bapicond[listMaterial.size() + 1];
				bapicond.setItmNumber("000000");
				bapicond.setCondType(condicionCabecera);
				bapicond.setCurrency("COP");
				bapicondArray[0] = bapicond;
				index++;
			}

			for (MaterialesCustom row : listMaterial) {
				bapisditm = new Bapisditm();
				bapisditm.setItmNumber(row.getItmNumber());
				bapisditm.setMaterial(row.getMaterial());
				bapisditm.setTargetQty(row.getQuantity());
				bapisditmArray[index - 1] = bapisditm;

				bapischdl = new Bapischdl();
				bapischdl.setItmNumber(row.getItmNumber());
				bapischdl.setReqQty(row.getQuantity());
				bapischdlArray[index - 1] = bapischdl;

				bapicond = new Bapicond();
				bapicond.setItmNumber(row.getItmNumber());
				bapicond.setCondStNo("11");
				bapicond.setCondType("ZPR0");
				bapicond.setCurrency("COP");
				bapicond.setCondValue(new BigDecimal(row.getCurrency()));
				bapicondArray[index] = bapicond;

				index++;
			}

			TableOfBapisditmHolder orderItemsIn = new TableOfBapisditmHolder(
					bapisditmArray);
			TableOfBapischdlHolder orderSchedulesIn = new TableOfBapischdlHolder(
					bapischdlArray);
			TableOfBapicondHolder orderConditionsIn = new TableOfBapicondHolder(
					bapicondArray);

			// RESULTADO
			Bapiret2 bapiret2 = new Bapiret2();
			Bapiret2[] bapiret2Vector = new Bapiret2[1];
			bapiret2Vector[0] = bapiret2;
			TableOfBapiret2Holder _return = new TableOfBapiret2Holder(
					bapiret2Vector);

			String salesdocument = new String();

			salesdocument = createSalesOrder.zbapiSalesorderCreatefromdat(" ",
					" ", " ", new TableOfBapiparexHolder(), "", new Bapisdls(),
					new TableOfBapiccardHolder(), new TableOfBapicublbHolder(),
					new TableOfBapicuinsHolder(), new TableOfBapicuprtHolder(),
					new TableOfBapicucfgHolder(), new TableOfBapicurefHolder(),
					new TableOfBapicuvalHolder(), new TableOfBapicuvkHolder(),
					orderConditionsIn, new TableOfBapicondxHolder(),
					orderHeaderIn, new Bapisdhd1X(), orderItemsIn,
					new TableOfBapisditmxHolder(),
					new TableOfBapisdkeyHolder(), orderPartners,
					orderSchedulesIn, new TableOfBapischdlxHolder(),
					new TableOfBapisdtextHolder(),
					new TableOfBapiaddr1Holder(), _return, null, new Sender(),
					" ");

			result.setMessages(_return);
			result.setSalesdocument(salesdocument);

			if (result.getSalesdocument().equals("")) {
				System.out.println(_return.value[0].getMessage());
			}

			System.out.println(salesdocument);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String args[]) {

		String tipoDocVenta = "ZOP";
		String orgVentas = "1000";
		String canalDistribucion = "20";
		String division = "10";
		String oficinaVentas = "1400";

		Date currentDate = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		String fechaPedido = sdf.format(currentDate);

		String cliente = "0000025798";
		String solicitante = null;
		String interlocutor = null;
		String codigoPauta = "Z05";
		String medico = "30000000";

		List<MaterialesCustom> listMaterialTmp = new ArrayList<MaterialesCustom>();

		MaterialesCustom custom = new MaterialesCustom();
		String itmNumber = "000010";
		custom.setItmNumber(itmNumber);
		custom.setMaterial("000000000000400033");
		custom.setQuantity(new BigDecimal(1));
		custom.setCurrency(10000D);
		listMaterialTmp.add(custom);

		custom = new MaterialesCustom();
		itmNumber = "000020";
		custom.setItmNumber(itmNumber);
		custom.setMaterial("000000000000400037");
		custom.setQuantity(new BigDecimal(1));
		custom.setCurrency(10000D);
		listMaterialTmp.add(custom);

		String url = "";
		String username = "TACTUSOFT";
		String password = "AFFINITY";

		ResultCreateOrder result = CreateSalesOrderExecute.execute(url,
				username, password, tipoDocVenta, orgVentas, canalDistribucion,
				division, oficinaVentas, fechaPedido, cliente, "E", "",
				solicitante, listMaterialTmp, interlocutor, codigoPauta,
				medico, "ZHD2");

		if (!result.getSalesdocument().equals("")) {
			System.out.println("Pedido nro." + result.getSalesdocument()
					+ " creado satisfactoriamente");
		} else {
			System.out.println("Error");
		}

	}
}
