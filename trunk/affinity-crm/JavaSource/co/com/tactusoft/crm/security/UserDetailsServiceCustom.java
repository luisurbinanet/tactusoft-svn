package co.com.tactusoft.crm.security;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.tactusoft.crm.controller.bo.SecurityBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmUser;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

	@Resource
	private SecurityBo service;
	
	@Resource
	private TablesBo tableService;

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		UserData user = null;
		try {
			CrmUser object = service.getObject(userName.toLowerCase());

			if (object != null) {
				user = new UserData();
				user.setUsername(object.getUsername());
				user.setPassword(object.getPassword());

				List<CrmRole> listRole = service.getListCrmRoleByUser(object
						.getId());
				user.setRoles(listRole);
				user.setUser(object);

				List<CrmPage> listPage = service.getListCrmPageByRole(object
						.getId());
				user.setListPage(listPage);
				
				listPage = tableService.getListPages();
				user.setListPageAll(listPage);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

}
