package com.tactusoft.webservice.client.execute;

import java.util.HashMap;
import java.util.Map;

import org.primefaces.json.JSONException;

import com.tactusoft.webservice.client.vtiger.CustomH;
import com.tactusoft.webservice.client.vtiger.VTLogin;

public class CreateSugarContact {

	public static String createContact(String url, String user, String keyUser,
			String doc, String lastname, String firstname, String country,
			String state, String city, String address, String zipCode,
			String numberPhone, String mobile, String email) {
		String result = null;
		CustomH customH = new CustomH(url);
		VTLogin login;
		try {
			login = customH.login(user, keyUser);
			if (login != null) {
				Map<String, Object> valueMap = new HashMap<String, Object>();
				valueMap.put("contact_no", doc);
				valueMap.put("lastname", lastname);
				valueMap.put("firstname", firstname);
				valueMap.put("mobile", mobile);
				valueMap.put("otherphone", mobile);
				valueMap.put("phone", numberPhone);
				valueMap.put("homephone", numberPhone);
				valueMap.put("mailingstreet", address);
				valueMap.put("otherstreet", address);
				valueMap.put("mailingcountry", country);
				valueMap.put("othercountry", country);
				valueMap.put("mailingstate", state);
				valueMap.put("otherstate", state);
				valueMap.put("mailingcity", city);
				valueMap.put("othercity", city);
				valueMap.put("mailingzip", zipCode);
				valueMap.put("otherzip", zipCode);
				valueMap.put("email", email);

				customH.create("Contacts", valueMap);
				result = "OK";
			} else {
				result = "Error en autenticaci—n de credencales";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

}
