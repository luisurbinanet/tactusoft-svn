package co.com.tactusoft.crm.security;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.tactusoft.crm.controller.bo.SecurityBo;
import co.com.tactusoft.crm.model.entities.CrmUser;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

	@Resource
	private SecurityBo service;

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		UserData user = null;
		try {
			CrmUser object = service.getObject(userName.toLowerCase());
			if (object != null) {
				user = new UserData();
				user.setUsername(object.getUsername());
				user.setPassword(object.getPassword());
				user.setUser(object);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}
}
