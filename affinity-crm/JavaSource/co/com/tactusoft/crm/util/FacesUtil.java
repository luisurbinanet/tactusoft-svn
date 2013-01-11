package co.com.tactusoft.crm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.MethodExpressionActionListener;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.security.UserData;

@Named
public class FacesUtil {

	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) {
		FacesContext context = FacesContext.getCurrentInstance();
		return (T) context.getApplication().evaluateExpressionGet(context,
				"#{" + beanName + "}", Object.class);
	}

	public static String getParam(String key) {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String result = params.get(key);
		return result;
	}

	public static String getRealPath(String folder) {
		ServletContext servletContext = (ServletContext) FacesContext
				.getCurrentInstance().getExternalContext().getContext();
		String result = servletContext.getRealPath("/" + folder + "/");
		return result;
	}

	public static void showMessage(String title, String message) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage(title, message));
	}

	public static void addInfo(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));
	}

	public static void addInfo(String text) {
		String title = FacesUtil.getMessage("msg_info");
		addInfo(title, text);
	}

	public static void addWarn(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, title, message));
	}

	public static void addWarn(String message) {
		String title = FacesUtil.getMessage("msg_warn");
		addWarn(title, message);
	}

	public static void addError(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));
	}

	public static void addError(String message) {
		String title = FacesUtil.getMessage("msg_error");
		addError(title, message);
	}

	public static void addFatal(String title, String message) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, title, message));
	}

	public static String getMessage(String resourceBundleKey) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(
				"co.com.tactusoft.crm.view.resources.resources", locale);
		return bundle.getString(resourceBundleKey);
	}

	public static String getMessage(String resourceBundleKey, String paramValue) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(
				"co.com.tactusoft.crm.view.resources.resources", locale);
		String msgValue = bundle.getString(resourceBundleKey);
		MessageFormat messageFormat = new MessageFormat(msgValue);
		Object[] args = { paramValue };
		return messageFormat.format(args);
	}

	public static String getMessage(String resourceBundleKey,
			String paramValue1, String paramValue2) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(
				"co.com.tactusoft.crm.view.resources.resources", locale);
		String msgValue = bundle.getString(resourceBundleKey);
		MessageFormat messageFormat = new MessageFormat(msgValue);
		Object[] args = { paramValue1, paramValue2 };
		return messageFormat.format(args);
	}

	public static void logout() {
		ExternalContext ectx = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) ectx.getSession(false);
		session.invalidate();

	}

	public static UserData getCurrentUserData() {
		UserData userData = null;
		try {
			userData = (UserData) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception ex) {
			userData = new UserData();
		}
		return userData;
	}

	public static CrmUser getCurrentUser() {
		UserData userData = null;
		try {
			userData = (UserData) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
		} catch (Exception ex) {
			userData = new UserData();
		}
		return userData.getUser();
	}

	public static BigDecimal getCurrentIdUsuario() {
		return getCurrentUser().getId();
	}

	public static List<String> getCurrentRoles() {
		List<String> list = new LinkedList<String>();
		UserData userData = null;
		try {
			userData = (UserData) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			for (SimpleGrantedAuthority role : userData.getRoles()) {
				list.add(role.getAuthority());
			}
		} catch (Exception ex) {
			userData = new UserData();
		}
		return list;
	}

	public static void createFile(InputStream inputStream, String fileName)
			throws IOException {
		File f = new File(fileName);
		OutputStream out;
		out = new FileOutputStream(f);
		byte buf[] = new byte[1024];
		int len;
		while ((len = inputStream.read(buf)) > 0)
			out.write(buf, 0, len);
		out.close();
		inputStream.close();
	}

	public static String getExtensionFile(String filename) {
		int dot = filename.lastIndexOf('.');
		return filename.substring(dot);
	}

	public static String getMD5(String text) {
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

	public static String currentDateString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = sdf.format(date);
		return currentDate;
	}

	public static MethodExpression getMethodExpression(String action) {
		return createMethodExpression("#{" + action + "}", String.class,
				new Class[0]);
	}

	private static MethodExpression createMethodExpression(
			String valueExpression, Class<?> valueType,
			Class<?>[] expectedParamTypes) {

		MethodExpression methodExpression = null;
		try {
			ExpressionFactory factory = FacesContext.getCurrentInstance()
					.getApplication().getExpressionFactory();
			methodExpression = factory.createMethodExpression(FacesContext
					.getCurrentInstance().getELContext(), valueExpression,
					valueType, expectedParamTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return methodExpression;
	}

	public static MethodExpressionActionListener createMethodActionListener(
			String valueExpression, Class<?> valueType,
			Class<?>[] expectedParamTypes) {

		MethodExpressionActionListener actionListener = null;
		try {
			actionListener = new MethodExpressionActionListener(
					createMethodExpression(valueExpression, valueType,
							expectedParamTypes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return actionListener;
	}

	public static String lpad(String valueToPad, char filler, int size) {
		char[] array = new char[size];

		int len = size - valueToPad.length();

		for (int i = 0; i < len; i++)
			array[i] = filler;

		valueToPad.getChars(0, valueToPad.length(), array,
				size - valueToPad.length());

		return String.valueOf(array);
	}

	public static boolean isEmptyOrBlank(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static String getContextPath() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestContextPath();
	}

	public static Date getDateWithoutTime(Date date) {
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		try {
			now = df1.parse(df1.format(date));
		} catch (ParseException e) {
			now = null;
		}
		return now;
	}

	public static Date addHourToDate(Date date, Date addHour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(addHour);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int total = (hour * 60) + min;

		calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, total);
		return calendar.getTime();
	}

	public static Date addDaysToDate(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	public static Date addMinutesToDate(Date date, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, hours);
		return calendar.getTime();
	}

	public static String formatDate(Date date, String format) {
		String stringDate = null;
		DateFormat formatter;
		formatter = new SimpleDateFormat(format);
		stringDate = formatter.format(date);
		return stringDate;
	}

	public static String getParameterTextValue(String param) {
		String result = null;
		List<CrmParameter> listParameter = getCurrentUserData()
				.getListParameter();
		for (CrmParameter row : listParameter) {
			if (row.getCode().equals(param)) {
				result = row.getTextValue();
				break;
			}
		}
		return result;
	}

	public static BigDecimal getParameterNumberValue(String param) {
		BigDecimal result = null;
		List<CrmParameter> listParameter = getCurrentUserData()
				.getListParameter();
		for (CrmParameter row : listParameter) {
			if (row.getCode().equals(param)) {
				result = row.getNumberValue();
				break;
			}
		}
		return result;
	}

	public static String removeCharacter(String input) {
		// Cadena de caracteres original a sustituir.
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		// Cadena de caracteres ASCII que reemplazarán los originales.
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		String output = input;
		for (int i = 0; i < original.length(); i++) {
			// Reemplazamos los caracteres especiales.
			output = output.replace(original.charAt(i), ascii.charAt(i));
		}// for i
		return output;
	}

	public static String getAppState(int state) {
		String result = null;
		switch (state) {
		case Constant.APP_STATE_CONFIRMED:
			result = FacesUtil.getMessage("glb_app_confirmed");
			break;
		case Constant.APP_STATE_CANCELED:
			result = FacesUtil.getMessage("glb_app_canceled");
			break;
		case Constant.APP_STATE_CHECKED:
			result = FacesUtil.getMessage("glb_app_checked");
			break;
		case Constant.APP_STATE_ATTENDED:
			result = FacesUtil.getMessage("glb_app_attended");
			break;
		case Constant.APP_STATE_NOATTENDED:
			result = FacesUtil.getMessage("glb_app_no_attended");
			break;
		}
		return result;
	}

	public static String getServerIP() {
		String ip = null;
		try {
			InetAddress thisIp = InetAddress.getLocalHost();
			ip = thisIp.getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ip;
	}

	public static String getClientIP() {
		String ip = null;
		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();
			ip = httpServletRequest.getRemoteAddr();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ip;
	}

	public static int getHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		if (min > 0) {
			hour = hour + 1;
		}
		return hour;
	}

	public static Date stringTOSDate(String strDate, String format) {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = formatoDelTexto.parse(strDate);
		} catch (ParseException ex) {
			date = null;
		}
		return date;
	}

	public static Date stringTOSDate(String strDate) {
		return stringTOSDate(strDate, "dd-MM-yyyy HH:mm:ss");
	}

	public static String getSessionID() {
		HttpServletRequest hrq = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = hrq.getSession();
		String sessionId = session.getId();
		return sessionId;
	}

	public static boolean getRegularExpression(String regex, String match) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(match);
		boolean found = false;
		while (matcher.find()) {
			found = true;
		}
		return found;
	}

	public static List<SelectItem> entityToSelectItem(List<?> _items,
			String _idMethod, String _descMethod) {
		try {
			List<SelectItem> items = new ArrayList<SelectItem>();

			Method idMethod = null;
			Method descMethod = null;

			for (int i = 0; i < _items.size(); i++) {
				Object item = _items.get(i);
				// On the first run, initialize reflection methods for object
				if (idMethod == null) {
					Class<? extends Object> obj = item.getClass();
					idMethod = obj.getMethod(_idMethod, new Class[] {});
					descMethod = obj.getMethod(_descMethod, new Class[] {});
				}
				// invoke Methods
				String id = null;
				try {
					id = (String) idMethod.invoke(item, new Object[] {});
				} catch (ClassCastException ex) {
					id = String.valueOf(idMethod.invoke(item, new Object[] {}));
				}
				String name = (String) descMethod.invoke(item, new Object[] {});

				SelectItem selectItem = new SelectItem();
				selectItem.setLabel(name);
				selectItem.setValue(id.toString());
				items.add(selectItem);
			}

			return items;
		} catch (Exception ex) {
			return null;
		}
	}

	public static Map<BigDecimal, Object> entityToMap(List<?> list,
			String getIdMethod) throws Exception {
		Map<BigDecimal, Object> items = new HashMap<BigDecimal, Object>();

		Method idMethod = null;

		for (int index = 0; index < list.size(); index++) {
			Object item = list.get(index);
			// On the first run, initialize reflection methods for object
			if (idMethod == null) {
				Class<? extends Object> obj = item.getClass();
				idMethod = obj.getMethod(getIdMethod, new Class[] {});
			}
			// invoke Methods
			BigDecimal id = (BigDecimal) idMethod.invoke(item, new Object[] {});
			items.put(id, item);
		}

		return items;
	}

	public static Map<Integer, Object> entityToMapInteger(List<?> list,
			String getIdMethod) throws Exception {
		Map<Integer, Object> items = new HashMap<Integer, Object>();

		Method idMethod = null;

		for (int index = 0; index < list.size(); index++) {
			Object item = list.get(index);
			// On the first run, initialize reflection methods for object
			if (idMethod == null) {
				Class<? extends Object> obj = item.getClass();
				idMethod = obj.getMethod(getIdMethod, new Class[] {});
			}
			// invoke Methods
			Integer id = (Integer) idMethod.invoke(item, new Object[] {});
			items.put(id, item);
		}

		return items;
	}
}
