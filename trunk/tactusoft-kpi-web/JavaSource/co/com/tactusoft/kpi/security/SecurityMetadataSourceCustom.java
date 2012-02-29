package co.com.tactusoft.kpi.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.MenuModel;

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

			List<MenuModel> listMenu = FacesUtil.getCurrentUserData()
					.getListMenu();

			for (MenuModel menu : listMenu) {
				String page = menu.getPage();
				if (page != null) {
					if (url.contains(page)) {
						return null;
					}
				} else {
					for (MenuModel menu2 : menu.getChilds()) {
						page = menu2.getPage();
						if (page != null) {
							if (url.contains(page)) {
								return null;
							}
						}
					}
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
