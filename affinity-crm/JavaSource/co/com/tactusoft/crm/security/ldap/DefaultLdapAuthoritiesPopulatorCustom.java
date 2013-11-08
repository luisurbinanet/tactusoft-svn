package co.com.tactusoft.crm.security.ldap;

import org.springframework.ldap.core.ContextSource;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;

public class DefaultLdapAuthoritiesPopulatorCustom extends
		DefaultLdapAuthoritiesPopulator {

	public DefaultLdapAuthoritiesPopulatorCustom(ContextSource contextSource,
			String groupSearchBase) {
		super(contextSource, ((LdapContextSourceCustom) contextSource)
				.getGroupSearchBase());
		LdapContextSourceCustom contextSourceCustom = (LdapContextSourceCustom) contextSource;
		this.setGroupRoleAttribute(contextSourceCustom.getGroupRoleAttribute());
	}

}
