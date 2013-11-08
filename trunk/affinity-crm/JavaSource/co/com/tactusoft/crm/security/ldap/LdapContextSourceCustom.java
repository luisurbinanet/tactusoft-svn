package co.com.tactusoft.crm.security.ldap;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.ldap.core.support.LdapContextSource;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmParameter;

/**
 * 
 * @author csarmiento
 * 
 */
public class LdapContextSourceCustom extends LdapContextSource {

	@Resource
	private ParameterBo service;
	private String[] userDnPatterns;
	private String groupSearchBase;
	private String groupRoleAttribute;

	public LdapContextSourceCustom() {
	}

	@PostConstruct
	public void init() {
		String url = null;
		String base = null;
		String userDn = null;
		String password = null;

		List<CrmParameter> listParameter = service
				.getListParameterByGroup("LDAP");
		for (CrmParameter row : listParameter) {
			if (row.getCode().equals("LDAP_URL")) {
				url = row.getTextValue();
			} else if (row.getCode().equals("LDAP_BASE")) {
				base = row.getTextValue();
			} else if (row.getCode().equals("LADAP_USER_DN")) {
				userDn = row.getTextValue();
			} else if (row.getCode().equals("LDAP_PASS")) {
				password = row.getTextValue();
			} else if (row.getCode().equals("LDAP_USER_DN_PATTERNS")) {
				userDnPatterns = new String[1];
				this.userDnPatterns[0] = row.getTextValue();
			} else if (row.getCode().equals("LDAP_GROUP")) {
				groupSearchBase = row.getTextValue();
			} else if (row.getCode().equals("LDAP_GROUP_ROLE_ATTRIBUTE")) {
				groupRoleAttribute = row.getTextValue();
			}
		}

		this.setUrl(url);
		this.setBase(base);
		this.setUserDn(userDn);
		this.setPassword(password);
	}

	public String[] getUserDnPatterns() {
		return userDnPatterns;
	}

	public void setUserDnPatterns(String userDnPatterns[]) {
		this.userDnPatterns = userDnPatterns;
	}

	public String getGroupSearchBase() {
		return groupSearchBase;
	}

	public void setGroupSearchBase(String groupSearchBase) {
		this.groupSearchBase = groupSearchBase;
	}

	public String getGroupRoleAttribute() {
		return groupRoleAttribute;
	}

	public void setGroupRoleAttribute(String groupRoleAttribute) {
		this.groupRoleAttribute = groupRoleAttribute;
	}

}
