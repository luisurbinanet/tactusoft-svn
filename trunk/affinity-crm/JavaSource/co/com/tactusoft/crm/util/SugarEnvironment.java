package co.com.tactusoft.crm.util;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmParameter;

@Named
@Scope("session")
public class SugarEnvironment implements Serializable {

	@Inject
	private ParameterBo parameterService;

	private static final long serialVersionUID = 1L;

	List<CrmParameter> lisParameter;

	private String username;
	private String key;
	private String url;

	public SugarEnvironment() {
	}

	public SugarEnvironment(String username, String key, String url) {
		this.username = username;
		this.key = key;
		this.url = url;
	}

	public List<CrmParameter> getLisParameter() {
		if (lisParameter == null) {
			lisParameter = parameterService.getListParameter();
			for (CrmParameter par : lisParameter) {
				if (par.getCode().equals("VTIGER_URL")) {
					this.url = par.getTextValue();
				}

				if (par.getCode().equals("VTIGER_USER")) {
					this.username = par.getTextValue();
				}

				if (par.getCode().equals("VTIGER_KEY")) {
					this.key = par.getTextValue();
				}
			}
		}
		return lisParameter;
	}

	public void setLisParameter(List<CrmParameter> lisParameter) {
		this.lisParameter = lisParameter;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
