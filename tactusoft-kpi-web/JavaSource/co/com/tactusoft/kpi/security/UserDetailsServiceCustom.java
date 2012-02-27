package co.com.tactusoft.kpi.security;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.controller.bo.SecurityBo;
import co.com.tactusoft.kpi.model.entities.KpiUser;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

	@Resource
	private SecurityBo service;

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		UserData user = null;
		try {
			KpiUser object = service.getObject(userName);

			if (object != null) {
				user = new UserData();
				user.setUsername(userName);
				user.setPassword(object.getPassword());
				user.setRole("SUPER_ADMIN");
				user.setKpiUser(object);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

}
