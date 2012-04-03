package co.com.tactusoft.video.security;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.tactusoft.video.controller.bo.SecurityBo;
import co.com.tactusoft.video.model.entities.User;
import co.com.tactusoft.video.util.FacesUtil;
import co.com.tactusoft.video.view.backing.MenuBacking;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

	@Resource
	private SecurityBo service;

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		UserData user = null;
		try {
			User object = service.getObject(userName.toLowerCase());

			if (object != null) {
				user = new UserData();
				user.setUsername(object.getUsername());
				user.setPassword(object.getPassword());

				user.setRole(object.getRole().getName());
				user.setUser(object);
				
				MenuBacking menuBacking = FacesUtil.findBean("menuBacking");
				menuBacking.init(object.getRole().getName());
				user.setListMenu(menuBacking.getListMenu());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

}
