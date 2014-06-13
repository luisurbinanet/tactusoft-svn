package com.tactusoft.webservice.client.vtiger;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

public class CustomH extends DefaultHttpClient {

	private String serviceUrl;
	private String sessionId;
	private String userId;

	public CustomH(String url) {
		if (!url.endsWith("/")) {
			url = url + "/";
		}
		serviceUrl = url + "webservice.php";
	}

	private VTToken getToken(String username) throws JSONException,
			org.primefaces.json.JSONException {

		Map<String, String> getdata = new HashMap<String, String>();
		getdata.put("operation", "getchallenge");
		getdata.put("username", username);

		Object response = this.doGet(getdata);
		if (!getError(response).isResult()) {
			return null;
		}

		JSONObject result = (JSONObject) ((JSONObject) response).get("result");

		VTToken object = new VTToken();
		object.setServertime(result.get("serverTime").toString());
		object.setExpiretime(result.get("expireTime").toString());
		object.setToken(result.get("token").toString());

		return object;
	}

	public VTLogin login(String username, String userAccessKey)
			throws JSONException, org.primefaces.json.JSONException {
		VTToken token = getToken(username);
		try {
			if (token == null) {
				return null;
			} else {
				Map<String, String> postdata = new HashMap<String, String>();
				postdata.put("operation", "login");
				postdata.put("username", username);
				postdata.put("accessKey", getMD5(token.getToken()
						+ userAccessKey));

				Object response = this.doPost(postdata);
				if (!getError(response).isResult()) {
					return null;
				}

				JSONObject result = (JSONObject) ((JSONObject) response)
						.get("result");

				VTLogin object = new VTLogin();
				object.setUsername(username);
				object.setSessionId(result.get("sessionName").toString());
				object.setUserId(result.get("userId").toString());

				sessionId = result.get("sessionName").toString();
				userId = result.get("userId").toString();

				return object;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public JSONObject listTypes() throws JSONException {
		Map<String, String> getdata = new HashMap<String, String>();
		getdata.put("operation", "listtypes");
		getdata.put("sessionName", sessionId);

		Object response = this.doGet(getdata);

		if (!getError(response).isResult()) {
			return null;
		}

		JSONObject result = (JSONObject) ((JSONObject) response).get("result");
		return result;
	}

	public JSONObject getDescribe(String module) throws JSONException {
		Map<String, String> getdata = new HashMap<String, String>();
		getdata.put("operation", "describe");
		getdata.put("sessionName", sessionId);
		getdata.put("elementType", module);

		Object response = this.doGet(getdata);

		if (!getError(response).isResult()) {
			return null;
		}

		JSONObject result = (JSONObject) ((JSONObject) response).get("result");
		return result;
	}

	public JSONObject create(String module, Map<String, Object> valueMap)
			throws JSONException {
		// Assign record to logged in user if not specified
		if (!valueMap.containsKey("assigned_user_id")) {
			valueMap.put("assigned_user_id", userId);
		}

		Map<String, String> postdata = new HashMap<String, String>();
		postdata.put("operation", "create");
		postdata.put("sessionName", sessionId);
		postdata.put("elementType", module);
		postdata.put("element", toJSONString(valueMap));

		Object response = this.doPost(postdata);
		if (!getError(response).isResult()) {
			JSONObject result = (JSONObject) response;
			JSONObject resultError = (JSONObject) result.get("error");
			return resultError;
		}

		JSONObject result = (JSONObject) ((JSONObject) response).get("result");
		return result;
	}

	public JSONArray queryList(String query) throws JSONException {
		Map<String, String> postdata = new HashMap<String, String>();
		postdata.put("operation", "query");
		postdata.put("sessionName", sessionId);
		postdata.put("query", query);

		Object response = this.doGet(postdata);
		if (!getError(response).isResult()) {
			return null;
		}

		JSONArray result = (JSONArray) ((JSONObject) response).get("result");
		return result;
	}

	public JSONObject queryObject(String query) throws JSONException {
		Map<String, String> postdata = new HashMap<String, String>();
		postdata.put("operation", "query");
		postdata.put("sessionName", sessionId);
		postdata.put("query", query);

		Object response = this.doGet(postdata);
		if (!getError(response).isResult()) {
			// JSONObject result = (JSONObject) response;
			// JSONObject resultError = (JSONObject) result.get("error");
			return null;
		}

		JSONArray result = (JSONArray) ((JSONObject) response).get("result");
		JSONObject resultUk = null;
		if (result.length() > 0) {
			resultUk = (JSONObject) result.get(0);
		}
		return resultUk;
	}

	public JSONObject update(Map<String, Object> valueMap) throws JSONException {
		// Assign record to logged in user if not specified
		if (!valueMap.containsKey("assigned_user_id")) {
			valueMap.put("assigned_user_id", userId);
		}

		Map<String, String> getdata = new HashMap<String, String>();
		getdata.put("operation", "update");
		getdata.put("sessionName", sessionId);
		getdata.put("element", toJSONString(valueMap));

		Object response = this.doPost(getdata);

		if (!getError(response).isResult()) {
			return null;
		}

		JSONObject result = (JSONObject) ((JSONObject) response).get("result");
		return result;
	}

	private VTError getError(Object result) {
		VTError object = new VTError();
		object.setResult(true);
		try {
			if (result == null) {
				object.setResult(false);
			} else if (result instanceof Exception) {
				object.setMessage(((Exception) result).getMessage());
				object.setResult(false);
			} else if (result instanceof JSONObject) {
				JSONObject resultObject = (JSONObject) result;
				if (resultObject.get("success").toString() == "false") {
					object.setMessage(resultObject.get("error").toString());
					object.setResult(false);
				}
			}
		} catch (Exception ex) {
		}
		return object;
	}

	public JSONObject doGet(Object data) {
		try {
			String uri = serviceUrl;
			if (data != null) {
				if (!uri.endsWith("?")) {
					uri += "?";
				}
				if (data instanceof String) {
					uri += data;
				} else if (data instanceof Map) {
					List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
					Map<?, ?> dataMap = (Map<?, ?>) data;
					Iterator<?> iterator = dataMap.keySet().iterator();
					while (iterator.hasNext()) {
						Object key = iterator.next();
						params.add(new BasicNameValuePair(key.toString(),
								(String) dataMap.get(key)));
					}
					uri += URLEncodedUtils.format(params, "UTF-8");
				}
			}

			HttpGet httpGet = new HttpGet(uri);

			HttpResponse httpResponse = this.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			String response = EntityUtils.toString(httpEntity);

			return new JSONObject(response);

		} catch (Exception ex) {
			return null;
		}
	}

	public JSONObject doPost(Object data) {
		try {

			HttpPost httpPost = new HttpPost(serviceUrl);
			List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();

			if (data instanceof Map) {
				Map<?, ?> dataMap = (Map<?, ?>) data;
				Iterator<?> iterator = dataMap.keySet().iterator();
				while (iterator.hasNext()) {
					Object key = iterator.next();
					params.add(new BasicNameValuePair(key.toString(),
							(String) dataMap.get(key)));
				}
			}

			httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

			HttpResponse httpResponse = this.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			String response = EntityUtils.toString(httpEntity);

			return new JSONObject(response);

		} catch (Exception ex) {
			return null;
		}
	}

	public static String toJSONString(Object value) {
		if (value == null) {
			return "null";
		}

		if (value instanceof String) {
			return "\"" + escape((String) value) + "\"";
		}

		if (value instanceof Double) {
			if (((Double) value).isInfinite() || ((Double) value).isNaN())
				return "null";
			else
				return value.toString();
		}

		if (value instanceof Float) {
			if (((Float) value).isInfinite() || ((Float) value).isNaN())
				return "null";
			else
				return value.toString();
		}

		if (value instanceof Number) {
			return value.toString();
		}

		if (value instanceof Boolean) {
			return value.toString();
		}

		if (value instanceof Map) {
			return new JSONObject((Map<?, ?>) value).toString();
		}

		if (value instanceof List) {
			return new JSONArray((List<?>) value).toString();
		}

		return value.toString();
	}

	private String getMD5(String text) {
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

	public static String escape(String s) {
		if (s == null)
			return null;
		StringBuffer sb = new StringBuffer();
		escape(s, sb);
		return sb.toString();
	}

	static void escape(String s, StringBuffer sb) {
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				// Reference: http://www.unicode.org/versions/Unicode5.1.0/
				if ((ch >= '\u0000' && ch <= '\u001F')
						|| (ch >= '\u007F' && ch <= '\u009F')
						|| (ch >= '\u2000' && ch <= '\u20FF')) {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
			}
		}// for
	}

}
