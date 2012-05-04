package co.com.tactusoft.crm.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import co.com.tactusoft.crm.util.FacesUtil;

public class AuthenticationSuccessHandlerCustom implements
		AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication arg2)
			throws IOException, ServletException {

		String page = FacesUtil.getCurrentUserData().getPageDefault();

		response.sendRedirect(response.encodeRedirectURL(request
				.getContextPath() + page));

	}

}
