package co.com.tactusoft.crm.security.ldap;

import java.util.Collection;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import co.com.tactusoft.crm.controller.bo.SecurityBo;
import co.com.tactusoft.crm.model.entities.CrmUser;
import co.com.tactusoft.crm.security.UserData;
import co.com.tactusoft.crm.util.FacesUtil;

public class LdapUserDetailsMapperCustom extends LdapUserDetailsMapper {

	@Resource
	private SecurityBo service;

	@Override
	public UserDetails mapUserFromContext(DirContextOperations ctx,
			String username, Collection<? extends GrantedAuthority> authorities) {
		UserData user = null;
		try {
			CrmUser object = service.getObject(username.toLowerCase());
			if (object != null) {
				user = new UserData();
				user.setUsername(object.getUsername());
				user.setPassword(object.getPassword());
				user.setEnabled(object.getState() == 1);
				user.setUser(object);

				LdapAuthenticationProviderCustom ldapAuthenticationProvider = FacesUtil
						.findBean("ldapAuthenticationProviderCustom");
				user = ldapAuthenticationProvider.getUserData(user);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

}
