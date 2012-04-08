package co.com.tactusoft.video.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import co.com.tactusoft.video.util.FacesUtil;
import co.com.tactusoft.video.view.datamodel.MenuDataModel;

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
					|| url.contains("/pages/view/responseQuestion")
					|| url.contains("/pages/secure/accessDenied")
					|| url.contains("/pages/secure/expired")
					|| url.contains("index.jsp") || url.contains("flowplayer")) {
				return null;
			}

			List<MenuDataModel> listMenu = FacesUtil.getCurrentUserData()
					.getListMenu();

			if (url.contains("/pages/admin/edit_topic")
					|| url.contains("/pages/admin/edit_video")) {
				return null;
			}

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
