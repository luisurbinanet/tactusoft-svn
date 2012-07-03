package co.com.tactusoft.crm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;

import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmRole;
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

	public static void showMessage(String title, String text) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage(title, text));
	}

	public static void addInfo(String title, String text) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, title, text));
	}

	public static void addInfo(String text) {
		String title = FacesUtil.getMessage("msg_info");
		addInfo(title, text);
	}

	public static void addWarn(String title, String text) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, title, text));
	}

	public static void addWarn(String text) {
		String title = FacesUtil.getMessage("msg_warn");
		addWarn(title, text);
	}

	public static void addError(String title, String text) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, title, text));
	}

	public static void addError(String text) {
		String title = FacesUtil.getMessage("msg_error");
		addError(title, text);
	}

	public static void addFatal(String title, String text) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, title, text));
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
			for (CrmRole role : userData.getRoles()) {
				list.add(role.getName());
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
		FacesContext facesCtx = FacesContext.getCurrentInstance();
		ELContext elCtx = facesCtx.getELContext();
		ExpressionFactory expFact = facesCtx.getApplication()
				.getExpressionFactory();
		return expFact.createMethodExpression(elCtx, "#{" + action + "}",
				String.class, new Class[0]);
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
}
