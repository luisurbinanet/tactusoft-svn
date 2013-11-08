package co.com.tactusoft.crm.security.ldap;

import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.ldap.authentication.BindAuthenticator;

public class BindAuthenticatorCustom extends BindAuthenticator {

	public BindAuthenticatorCustom(BaseLdapPathContextSource contextSource) {
		super(contextSource);
		LdapContextSourceCustom contextSourceCustom = (LdapContextSourceCustom)contextSource;
		this.setUserDnPatterns(contextSourceCustom.getUserDnPatterns());
	}

}
