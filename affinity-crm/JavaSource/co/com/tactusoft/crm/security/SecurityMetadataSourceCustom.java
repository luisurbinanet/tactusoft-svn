package co.com.tactusoft.crm.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.util.FacesUtil;

public class SecurityMetadataSourceCustom implements
		FilterInvocationSecurityMetadataSource {

	public List<ConfigAttribute> getAttributes(Object object) {
		StringBuilder access = new StringBuilder();
		FilterInvocation fi = (FilterInvocation) object;
		String url = fi.getRequestUrl();

		try {

			if (url.contains("public") || url.contains("jquery")
					|| url.contains("primefaces")
					|| url.contains("javax.faces.resource")
					|| url.contains(".css") || url.contains(".png")
					|| url.contains(".jpg") || url.contains(".gif")
					|| url.contains(".swf") || url.contains("script.js")
					|| url.contains("index.jsp") || url.contains("Include")) {
				return null;
			}

			List<CrmPage> listPage = FacesUtil.getCurrentUserData()
					.getListPage();

			for (CrmPage menu : listPage) {
				String page = menu.getPage();
				if (page != null && url.contains(page)
						|| (url.contains("appointmentEdit"))) {
					return null;
				}
			}

			access.append(url);

		} catch (Exception ex) {
			access.append(url);
		}

		return SecurityConfig.createListFromCommaDelimitedString(access
				.toString());
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
