package co.com.tactusoft.kpi.util;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;

import co.com.tactusoft.kpi.model.entities.KpiUser;
import co.com.tactusoft.kpi.security.UserData;

public class FacesUtil {

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

	public static void addFatal(String title, String text) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_FATAL, title, text));
	}

	public static String getMessage(String resourceBundleKey) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(
				"co.com.tactusoft.kpi.view.resources.messages", locale);
		return bundle.getString(resourceBundleKey);
	}

	public static String getMessage(String resourceBundleKey, String paramValue) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(
				"co.com.tactusoft.kpi.view.resources.messages", locale);
		String msgValue = bundle.getString(resourceBundleKey);
		MessageFormat messageFormat = new MessageFormat(msgValue);
		Object[] args = { paramValue };
		return messageFormat.format(args);
	}

	public static void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		ExternalContext ectx = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpSession session = (HttpSession) ectx.getSession(false);
		SecurityContextHolder.clearContext();
		session.invalidate();
	}

	public static KpiUser getCurrentUser() {
		UserData userData = (UserData) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return userData.getKpiUser();
	}

	public static BigDecimal getCurrentIdUsuario() {
		return getCurrentUser().getId();
	}
	
	public static List<String> getCurrentRoles() {
		UserData userData = (UserData) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return userData.getRoles();
	}
}
