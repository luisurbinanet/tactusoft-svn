package co.com.tactusoft.kpi.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import co.com.tactusoft.kpi.util.FacesUtil;

public class SecurityMetadataSourceCustom implements
		FilterInvocationSecurityMetadataSource {

	public List<ConfigAttribute> getAttributes(Object object) {
		StringBuilder access = new StringBuilder();
		FilterInvocation fi = (FilterInvocation) object;
		String url = fi.getRequestUrl();

		try {

			if (url.contains("secure") || url.contains("jquery")
					|| url.contains("primefaces")
					|| url.contains("javax.faces.resource")
					|| url.contains(".css") || url.contains(".png")
					|| url.contains(".jpg") || url.contains(".gif")
					|| url.contains(".swf") || url.contains("script.js")
					|| url.contains("index.jsp")) {
				return null;
			}

			for (String role : FacesUtil.getCurrentRoles()) {
				if (role.equals("SUPER_ADMIN")) {
					return null;
				}
			}

			access.append(url);

		} catch (ClassCastException ex) {
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
