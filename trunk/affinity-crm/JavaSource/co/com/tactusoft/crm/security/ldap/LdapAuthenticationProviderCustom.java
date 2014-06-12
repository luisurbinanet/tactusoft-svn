package co.com.tactusoft.crm.security.ldap;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.controller.bo.SecurityBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmNurse;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.security.UserData;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.util.SugarEnvironment;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomListsExecute;

@Named
@Scope("session")
public class LdapAuthenticationProviderCustom {

	@Inject
	private SecurityBo securityService;

	@Inject
	private TablesBo tableService;

	@Inject
	private ParameterBo parameterService;

	public LdapAuthenticationProviderCustom() {
	}

	public UserData getUserData(UserData userData) {
		UserData user = userData;

		// get profile
		List<CrmProfile> listProfile = tableService.getListProfileByUser(user
				.getUser().getId());
		user.setListProfile(listProfile);

		// get Roles
		List<CrmRole> listRole = securityService.getListCrmRoleByUser(user
				.getUser().getId());
		List<SimpleGrantedAuthority> listGrantedAuthority = new ArrayList<SimpleGrantedAuthority>();
		for (CrmRole role : listRole) {
			listGrantedAuthority
					.add(new SimpleGrantedAuthority(role.getName()));
		}
		user.setRoles(listGrantedAuthority);
		user.setOpenAppointment(false);
		user.setPrintFormula(false);
		user.setPrintHistorial(false);

		String idRoles = "";
		for (CrmRole row : listRole) {
			idRoles = idRoles + row.getId() + ",";
			if (row.getOpenAppointment() && !user.isOpenAppointment()) {
				user.setOpenAppointment(true);
			}
			if (row.getPrintFormula()) {
				user.setPrintFormula(true);
			}

			if (row.getPrintHistorial()) {
				user.setPrintHistorial(true);
			}
		}

		idRoles = idRoles.substring(0, idRoles.length() - 1);

		List<CrmRole> listRoleAll = tableService.getListRoleActive();
		user.setListRoleAll(listRoleAll);

		// get Pages
		List<CrmPage> listPage = securityService.getListCrmPageByRole(idRoles);
		user.setListPage(listPage);

		listPage = tableService.getListPages();
		user.setListPageAll(listPage);

		// get Default Page
		String pageDefault = listRole.get(0).getCrmPage().getPage();
		user.setPageDefault(pageDefault);

		// get Branch
		List<CrmBranch> listBranch = securityService.getListBranchByUser(user
				.getUser().getId());
		user.setListBranch(listBranch);

		// get Parameter
		List<CrmParameter> listParameter;
		listParameter = parameterService.getListParameter();
		user.setListParameter(listParameter);

		// get listWSGroupSellers
		SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
		sap.getLisParameter();

		SugarEnvironment sugar = FacesUtil.findBean("sugarEnvironment");
		sugar.getLisParameter();

		listBranch = tableService.getListBranch();
		user.setListBranchAll(listBranch);

		try {

			List<WSBean> result = new ArrayList<WSBean>();
			try {
				result = CustomListsExecute.getBranchs(sap.getUrlWebList(),
						sap.getUsername(), sap.getPassword());
			} catch (Exception ex) {
				result = new ArrayList<WSBean>();
			}

			for (WSBean row : result) {
				boolean notExists = true;
				for (CrmBranch rowDB : listBranch) {
					if (row.getCode().equals(rowDB.getCode())) {
						notExists = false;
					}
				}

				if (notExists) {
					CrmBranch newBranch = new CrmBranch();
					newBranch.setCode(row.getCode());
					newBranch.setName(row.getNames());
					newBranch.setSociety(row.getSociety());
					newBranch.setState(Constant.STATE_ACTIVE);
					tableService.saveBranch(newBranch);
					user.getListBranchAll().add(newBranch);
				}
			}
		} catch (Exception ex) {
			user.setListBranchAll(listBranch);
		}

		try {
			List<WSBean> result = CustomListsExecute.getGroupSellers(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword());
			user.setListWSGroupSellers(result);
		} catch (Exception ex) {
			user.setListWSGroupSellers(new ArrayList<WSBean>());
		}

		try {
			List<WSBean> result = CustomListsExecute.getMaterials(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword());
			user.setListWSMaterials(result);
		} catch (Exception ex) {
			user.setListWSMaterials(new ArrayList<WSBean>());
		}

		try {
			List<WSBean> result = CustomListsExecute.getDocTypes(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword());
			user.setListWSDocType(result);
		} catch (Exception ex) {
			user.setListWSDocType(new ArrayList<WSBean>());
		}

		CrmDoctor doctor = tableService.getCrmDoctor(user.getUser().getId());
		if (doctor != null) {
			user.setRolePrincipal(Constant.ROLE_DOCTOR);
		} else {
			CrmNurse nurse = tableService.getCrmNurse(user.getUser().getId());
			if (nurse != null) {
				if (nurse.getAux() == Constant.STATE_ACTIVE) {
					user.setRolePrincipal(Constant.ROLE_NURSE_AUX);
				} else {
					user.setRolePrincipal(Constant.ROLE_NURSE);
				}
			} else {
				user.setRolePrincipal(Constant.ROLE_USER);
			}
		}

		return user;
	}

}
