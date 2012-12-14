package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("session")
public class SessionBacking implements Serializable {

	private static final long serialVersionUID = 1L;
	private String environment;
	private String ipWeb;
	private String version;

	public SessionBacking() {

	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getIpWeb() {
		return ipWeb;
	}

	public void setIpWeb(String ipWeb) {
		this.ipWeb = ipWeb;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUsernameNames() {
		return FacesUtil.getCurrentUser().getNames() + " "
				+ FacesUtil.getCurrentUser().getSurnames();
	}

}
