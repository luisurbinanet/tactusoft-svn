package co.com.tactusoft.kpi.view.backing;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.util.FacesUtil;

@Controller
@Scope("session")
public class LoginBacking {

	private String userName;
	private String password;
	private boolean visibleBadCredentials;

	public LoginBacking() {
		this.init();
	}

	public void init() {
		this.userName = null;
		this.password = null;
		this.visibleBadCredentials = false;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVisibleBadCredentials() {
		return visibleBadCredentials;
	}

	public void setVisibleBadCredentials(boolean visibleBadCredentials) {
		this.visibleBadCredentials = visibleBadCredentials;
	}

	public void doLogin() throws Exception {
		String message = null;
		final FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();

		this.visibleBadCredentials = false;

		externalContext.dispatch("/j_spring_security_check?j_username="
				+ this.userName + "&j_password=" + this.password);

		if (externalContext.getRemoteUser() == null) {
			Exception loginError = (Exception) externalContext.getSessionMap()
					.get(WebAttributes.AUTHENTICATION_EXCEPTION);

			if (loginError instanceof BadCredentialsException) {
				this.visibleBadCredentials = true;
			}

			if (loginError instanceof AuthenticationServiceException) {
				this.visibleBadCredentials = true;
			}

			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);

		} else {
			this.init();
			this.visibleBadCredentials = false;
		}

		context.renderResponse();
	}

	public String logout() {
		FacesUtil.logout();
		return "GO_LOGIN";
	}

}
