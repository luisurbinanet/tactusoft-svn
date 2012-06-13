package com.tactusoft.webservice.client.execute;

import java.util.ArrayList;
import java.util.List;

import mc_style.functions.soap.sap.document.sap_com.ZWeblists;
import mc_style.functions.soap.sap.document.sap_com.ZWeblistsResponse;
import mc_style.functions.soap.sap.document.sap_com.Zweblist;
import mc_style.functions.soap.sap.document.sap_com.Zweblistline;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import com.tactusoft.axis2.ZWEBLISTStub;
import com.tactusoft.webservice.client.beans.WSBean;

public class CustomLists {

	public static List<WSBean> getDoctors(String url, String user,
			String password) {

		List<WSBean> list = new ArrayList<WSBean>();

		try {
			ZWeblists parameter = new ZWeblists();
			parameter.setZdatoslista(new Zweblist());
			parameter.setZlista("INTERLOCUTORES_COMERCIALES");

			ZWEBLISTStub stub = new ZWEBLISTStub(url);

			ServiceClient sc = stub._getServiceClient();
			Options options = sc.getOptions();
			HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
			auth.setPreemptiveAuthentication(true);
			auth.setUsername(user);
			auth.setPassword(password);
			options.setProperty(HTTPConstants.AUTHENTICATE, auth);

			ZWeblistsResponse result = stub.zWeblists(parameter);

			for (Zweblistline row : result.getZdatoslista().getItem()) {
				if (!row.getText1().toString().isEmpty()
						&& !row.getText3().toString().isEmpty()) {
					list.add(new WSBean(row.getText1().toString(), row
							.getText3().toString()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String args[]) {
		List<WSBean> list = getDoctors(
				"http://ansrvsap2.affinity.net:8001/sap/bc/srt/rfc/sap/zweblist/300/zweblist/zweblist",
				"TACTUSOFT", "AFFINITY");
		for (WSBean row : list) {
			System.out.println(row.getCode() + " - " + row.getNames());
		}
	}

}
