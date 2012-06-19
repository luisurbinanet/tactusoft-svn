package co.com.tactusoft.crm.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.controller.bo.SecurityBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmUser;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomLists;

@Service
public class UserDetailsServiceCustom implements UserDetailsService {

	@Resource
	private SecurityBo service;

	@Resource
	private TablesBo tableService;

	@Resource
	private ParameterBo parameterService;

	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		UserData user = null;
		try {
			CrmUser object = service.getObject(userName.toLowerCase());

			if (object != null) {
				user = new UserData();
				user.setUsername(object.getUsername());
				user.setPassword(object.getPassword());

				// get Roles
				List<CrmRole> listRole = service.getListCrmRoleByUser(object
						.getId());
				user.setRoles(listRole);
				user.setUser(object);

				String idRoles = "";
				for (CrmRole row : listRole) {
					idRoles = idRoles + row.getId() + ",";
				}

				idRoles = idRoles.substring(0, idRoles.length() - 1);

				List<CrmRole> listRoleAll = tableService.getListRoleActive();
				user.setListRoleAll(listRoleAll);

				// get Pages
				List<CrmPage> listPage = service.getListCrmPageByRole(idRoles);
				user.setListPage(listPage);

				listPage = tableService.getListPages();
				user.setListPageAll(listPage);

				// get Default Page
				String pageDefault = listRole.get(0).getCrmPage().getPage();
				user.setPageDefault(pageDefault);

				// get Branch
				List<CrmBranch> listBranch = service.getListBranchByUser(object
						.getId());
				user.setListBranch(listBranch);

				listBranch = tableService.getListBranchActive();
				user.setListBranchAll(listBranch);

				// get Parameter
				List<CrmParameter> listParameter;
				listParameter = parameterService.getListParameter();
				user.setListParameter(listParameter);

				// get listWSGroupSellers
				try {

					String url = null;
					for (CrmParameter row : listParameter) {
						if (row.getCode().equals("SAP_URL_ZWEBLIST")) {
							url = row.getTextValue();
							break;
						}
					}

					String username = null;
					for (CrmParameter row : listParameter) {
						if (row.getCode().equals("SAP_USERNAME")) {
							username = row.getTextValue();
							break;
						}
					}

					String password = null;
					for (CrmParameter row : listParameter) {
						if (row.getCode().equals("SAP_PASSWORD")) {
							password = row.getTextValue();
							break;
						}
					}

					List<WSBean> result = CustomLists.getGroupSellers(url,
							username, password);
					user.setListWSGroupSellers(result);
				} catch (Exception ex) {
					user.setListWSGroupSellers(new ArrayList<WSBean>());
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user;
	}

}
