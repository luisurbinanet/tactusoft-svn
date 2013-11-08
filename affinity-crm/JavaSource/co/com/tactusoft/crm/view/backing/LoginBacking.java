package co.com.tactusoft.crm.view.backing;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.controller.bo.SecurityBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.security.UserData;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("session")
public class LoginBacking {

	@Inject
	private ParameterBo parameterBo;

	@Inject
	private SecurityBo securityBo;

	@Inject
	private TablesBo tablesBo;

	private String userName;
	private String password;
	private boolean visibleBadCredentials;
	private boolean authenticated;
	private String message;

	public LoginBacking() {
	}

	@PostConstruct
	public void init() {
		// TimerBacking timerBacking = FacesUtil.findBean("timerBacking");
		// timerBacking.execute();
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

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String doLoginOld() throws Exception {
		String page = null;

		this.visibleBadCredentials = false;
		this.authenticated = false;

		AuthenticationManager authenticationManager = (AuthenticationManager) FacesUtil
				.findBean("authenticationManager");

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				this.userName, this.password);

		try {
			Authentication authenticationResponseToken = authenticationManager
					.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(
					authenticationResponseToken);

			if (authenticationResponseToken.isAuthenticated()) {
				this.password = null;
				this.visibleBadCredentials = false;
				this.authenticated = true;
				page = ((UserData) authenticationResponseToken.getPrincipal())
						.getPageDefault() + "?faces-redirect=true";

				SessionBacking sessionBacking = FacesUtil
						.findBean("sessionBacking");

				List<CrmParameter> list = parameterBo
						.getListParameterByGroup("AMBIENTE");
				sessionBacking.setIpWeb(FacesUtil.getServerIP());
				for (CrmParameter row : list) {
					if (row.getCode().equals("ENV_AMBIENTE")) {
						sessionBacking.setEnvironment(row.getTextValue());
					} else if (row.getCode().equals("ENV_VERSION")) {
						sessionBacking.setVersion(row.getTextValue());
					}
				}
			}

		} catch (BadCredentialsException badCredentialsException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);
		} catch (LockedException lockedException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);
		} catch (DisabledException disabledException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_enabled");
			FacesUtil.addWarn(message);
		} catch (NullPointerException nullPointerException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);
		} catch (AuthenticationServiceException authenticationServiceException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);
		}

		return page;
	}

	public String doLogin() throws Exception {
		String page = null;

		this.visibleBadCredentials = false;
		this.authenticated = false;

		AuthenticationManager authenticationManager = (AuthenticationManager) FacesUtil
				.findBean("authenticationManager");

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				this.userName, this.password);

		try {
			Authentication authenticationResponseToken = authenticationManager
					.authenticate(usernamePasswordAuthenticationToken);
			SecurityContextHolder.getContext().setAuthentication(
					authenticationResponseToken);

			if (authenticationResponseToken.isAuthenticated()) {

				if (securityBo.getListCrmRoleByUser(this.userName).isEmpty()) {
					message = FacesUtil
							.getMessage("log_msg_validate_credentials");
					throw new AccessDeniedException(message);
				}
				
				UserData user = (UserData) authenticationResponseToken
						.getPrincipal();
				CrmUser crmUser = user.getUser();
				crmUser.setPassword(FacesUtil.getMD5(this.password));
				tablesBo.saveUser(crmUser);

				this.password = null;
				this.visibleBadCredentials = false;
				this.authenticated = true;

				page = user.getPageDefault() + "?faces-redirect=true";

				SessionBacking sessionBacking = FacesUtil
						.findBean("sessionBacking");

				List<CrmParameter> list = parameterBo
						.getListParameterByGroup("AMBIENTE");
				sessionBacking.setIpWeb(FacesUtil.getServerIP());
				for (CrmParameter row : list) {
					if (row.getCode().equals("ENV_AMBIENTE")) {
						sessionBacking.setEnvironment(row.getTextValue());
					} else if (row.getCode().equals("ENV_VERSION")) {
						sessionBacking.setVersion(row.getTextValue());
					}
				}

			}

		} catch (BadCredentialsException badCredentialsException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);
		} catch (LockedException lockedException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);
		} catch (DisabledException disabledException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_enabled");
			FacesUtil.addWarn(message);
		} catch (NullPointerException nullPointerException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);
		} catch (AuthenticationServiceException authenticationServiceException) {
			this.visibleBadCredentials = true;
			message = FacesUtil.getMessage("log_msg_validate_credentials");
			FacesUtil.addWarn(message);
		}

		return page;
	}

	public String logout() {
		this.userName = null;
		this.password = null;
		this.visibleBadCredentials = false;
		this.authenticated = false;

		FacesUtil.logout();
		return "/pages/public/login?faces-redirect=true";
	}

	public List<String> getRole() {
		return FacesUtil.getCurrentRoles();
	}

}
