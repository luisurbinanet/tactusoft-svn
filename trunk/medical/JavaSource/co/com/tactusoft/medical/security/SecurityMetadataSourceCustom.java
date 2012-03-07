package co.com.tactusoft.medical.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import co.com.tactusoft.medical.util.FacesUtil;

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
					|| url.contains("/pages/view/carousel") || url.contains("/pages/view/body")
					|| url.contains("/pages/view/responseQuestion") || url.contains("index.jsp")) {
				return null;
			}

			/*List<MenuDataModel> listMenu = FacesUtil.getCurrentUserData()
					.getListMenu();

			for (MenuDataModel menu : listMenu) {
				String page = menu.getPage();
				if (page != null) {
					if (url.contains(page)) {
						return null;
					}
				} else {
					for (MenuDataModel menu2 : menu.getChilds()) {
						page = menu2.getPage();
						if (page != null) {
							if (url.contains(page)) {
								return null;
							}
						}
					}
				}
			}*/
			
			if (FacesUtil.getCurrentRole().equals("ADMIN")){
				return null;
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
