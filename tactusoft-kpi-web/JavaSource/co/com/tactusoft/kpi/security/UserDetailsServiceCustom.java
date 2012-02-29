package co.com.tactusoft.kpi.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.controller.bo.SecurityBo;
import co.com.tactusoft.kpi.model.entities.KpiRole;
import co.com.tactusoft.kpi.model.entities.KpiUser;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.backing.MenuBacking;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

	@Resource
	private SecurityBo service;

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		UserData user = null;
		try {
			KpiUser object = service.getObject(userName.toLowerCase());

			if (object != null) {
				user = new UserData();
				user.setUsername(object.getUsername());
				user.setPassword(object.getPassword());

				List<KpiRole> list = service.getRoles(object.getId());
				List<String> roles = new ArrayList<String>();
				for (KpiRole role : list) {
					roles.add(role.getName());
				}

				user.setRoles(roles);
				user.setKpiUser(object);
				
				MenuBacking menuBacking = FacesUtil.findBean("menuBacking");
				menuBacking.init(roles);
				user.setListMenu(menuBacking.getListMenu());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

}
