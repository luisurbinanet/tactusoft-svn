package com.tactusoft.webservice.client.execute;

import java.util.HashMap;
import java.util.Map;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.tactusoft.webservice.client.vtiger.CustomH;
import com.tactusoft.webservice.client.vtiger.VTLogin;

public class SugarWS {

	private String url;
	private String user;
	private String keyUser;

	public SugarWS(String url, String user, String keyUser) {
		this.url = url;
		this.user = user;
		this.keyUser = keyUser;
	}

	public String createContact(String doc, String lastname, String firstname,
			String country, String state, String city, String address,
			String zipCode, String numberPhone, String mobile, String email) {
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
				valueMap.put("salutation", "Ms.");
				valueMap.put("title", null);

				result = customH.create("Contacts", valueMap).toString();
			} else {
				result = "-1;Error en autenticación de credenciales";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String createLead(Integer id, String doc, String lastname,
			String firstname, String country, String state, String city,
			String address, String zipCode, String numberPhone, String mobile,
			String email, Integer memberOf) {
		String result = null;
		CustomH customH = new CustomH(url);
		VTLogin login;
		try {
			login = customH.login(user, keyUser);
			if (login != null) {
				Map<String, Object> valueMap = new HashMap<String, Object>();
				// valueMap.put("lead_no", doc);
				valueMap.put("lastname", lastname);
				valueMap.put("firstname", firstname);
				valueMap.put("mobile", mobile);
				valueMap.put("phone", numberPhone);
				valueMap.put("lane", address);
				valueMap.put("country", country);
				valueMap.put("state", state);
				valueMap.put("city", city);
				valueMap.put("code", zipCode);
				valueMap.put("email", email);
				valueMap.put("leadsource", "Self Generated");
				valueMap.put("leadstatus", "Contacted");
				valueMap.put("cf_707", id);
				valueMap.put("cf_709", doc);
				valueMap.put("cf_723", memberOf);

				result = customH.create("Leads", valueMap).toString();
			} else {
				result = "-1;Error en autenticación de credenciales";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String persitLead(Integer id, String doc, String lastname,
			String firstname, String country, String state, String city,
			String address, String zipCode, String numberPhone, String mobile,
			String email, Integer memberOf) {
		String result = null;
		CustomH customH = new CustomH(url);
		VTLogin login = null;
		try {
			int i = 1;
			boolean logged = false;
			while (!logged && i < 100) {
				login = customH.login(user, keyUser);
				if (login != null) {
					logged = true;
					break;
				}
				i++;
			}

			if (logged) {
				JSONObject element = customH
						.queryObject("SELECT * FROM Leads WHERE cf_707 = " + id
								+ ";");
				Map<String, Object> valueMap = new HashMap<String, Object>();
				valueMap.put("lastname", lastname);
				valueMap.put("firstname", firstname);
				valueMap.put("mobile", mobile);
				valueMap.put("phone", numberPhone);
				valueMap.put("lane", address);
				valueMap.put("country", country);
				valueMap.put("state", state);
				valueMap.put("city", city);
				valueMap.put("code", zipCode);
				valueMap.put("email", email);
				valueMap.put("leadsource", "Self Generated");
				valueMap.put("leadstatus", "Contacted");
				valueMap.put("cf_707", id);
				valueMap.put("cf_709", doc);
				valueMap.put("cf_723", memberOf);
				
				if (element != null) {
					String objectTypeId = element.getString("id");
					valueMap.put("id", objectTypeId);
					result = customH.update(valueMap).toString();
				} else {
					result = customH.create("Leads", valueMap).toString();
				}
			} else {
				result = "-1;Error en autenticación de credenciales";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String createAccount(Integer id, String doc, String lastname,
			String firstname, String country, String state, String city,
			String address, String zipCode, String numberPhone, String mobile,
			String email) {
		String result = null;
		CustomH customH = new CustomH(url);
		VTLogin login;
		try {
			login = customH.login(user, keyUser);
			if (login != null) {
				Map<String, Object> valueMap = new HashMap<String, Object>();
				valueMap.put("accountname", firstname);
				valueMap.put("phone", numberPhone);
				valueMap.put("otherphone", mobile);
				valueMap.put("bill_street", address);
				valueMap.put("bill_country", country);
				valueMap.put("bill_state", state);
				valueMap.put("bill_city", city);
				valueMap.put("bill_code", zipCode);
				valueMap.put("ship_street", address);
				valueMap.put("ship_country", country);
				valueMap.put("ship_state", state);
				valueMap.put("ship_city", city);
				valueMap.put("ship_code", zipCode);
				valueMap.put("email1", email);
				valueMap.put("accounttype", "Customer");
				valueMap.put("cf_715", lastname);
				valueMap.put("cf_717", id);
				valueMap.put("cf_719", doc);
				result = customH.create("Accounts", valueMap).toString();
			} else {
				result = "-1;Error en autenticación de credenciales";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String persistAccount(Integer id, String doc, String lastname,
			String firstname, String ownership, String country, String state, String city,
			String address, String zipCode, String numberPhone, String mobile,
			String email) {
		String result = null;
		CustomH customH = new CustomH(url);
		VTLogin login;
		try {
			int i = 1;
			boolean logged = false;
			while (!logged && i < 100) {
				login = customH.login(user, keyUser);
				if (login != null) {
					logged = true;
					break;
				}
				i++;
			}

			if (logged) {
				JSONObject element = customH
						.queryObject("SELECT * FROM Accounts WHERE cf_717 = "
								+ id + ";");
				Map<String, Object> valueMap = new HashMap<String, Object>();
				valueMap.put("accountname", firstname);
				valueMap.put("ownership", ownership);
				valueMap.put("phone", numberPhone);
				valueMap.put("otherphone", mobile);
				valueMap.put("bill_street", address);
				valueMap.put("bill_country", country);
				valueMap.put("bill_state", state);
				valueMap.put("bill_city", city);
				valueMap.put("bill_code", zipCode);
				valueMap.put("ship_street", address);
				valueMap.put("ship_country", country);
				valueMap.put("ship_state", state);
				valueMap.put("ship_city", city);
				valueMap.put("ship_code", zipCode);
				valueMap.put("email1", email);
				valueMap.put("accounttype", "Customer");
				valueMap.put("cf_715", lastname);
				valueMap.put("cf_717", id);
				valueMap.put("cf_719", doc);
				if (element != null) {
					String objectTypeId = element.getString("id");
					valueMap.put("id", objectTypeId);
					result = customH.update(valueMap).toString();
				} else {
					result = customH.create("Accounts", valueMap).toString();
				}
			} else {
				result = "-1;Error en autenticación de credenciales";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return result;
	}

	public String getAccounts(Integer id) {
		String result = null;
		CustomH customH = new CustomH(url);
		VTLogin login;
		try {
			login = customH.login(user, keyUser);
			if (login != null) {
				String query = "SELECT * FROM Accounts WHERE cf_717 = " + id
						+ ";";
				result = customH.queryObject(query).toString();
			} else {
				result = "Error en autenticación de credenciales";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getModules() {
		String result = null;
		CustomH customH = new CustomH(url);
		VTLogin login;
		try {
			login = customH.login(user, keyUser);
			if (login != null) {
				result = customH.listTypes().toString();
			} else {
				result = "Error en autenticación de credenciales";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}

}
