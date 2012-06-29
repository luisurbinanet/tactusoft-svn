package co.com.tactusoft.crm.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmUser;

import com.tactusoft.webservice.client.beans.WSBean;

public class UserData implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private List<CrmRole> roles;
	private List<CrmRole> listRoleAll;
	private CrmUser user;
	private List<CrmPage> listPage;
	private List<CrmPage> listPageAll;
	private String pageDefault;
	private List<CrmBranch> listBranch;
	private List<CrmBranch> listBranchAll;
	private List<CrmParameter> listParameter;
	private List<WSBean> listWSGroupSellers;
	private CrmPatient selectedPatient;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public List<CrmRole> getRoles() {
		return roles;
	}

	public void setRoles(List<CrmRole> roles) {
		this.roles = roles;
	}

	public List<CrmRole> getListRoleAll() {
		return listRoleAll;
	}

	public void setListRoleAll(List<CrmRole> listRoleAll) {
		this.listRoleAll = listRoleAll;
	}

	public CrmUser getUser() {
		return user;
	}

	public void setUser(CrmUser user) {
		this.user = user;
	}

	public List<CrmPage> getListPage() {
		return listPage;
	}

	public void setListPage(List<CrmPage> listPage) {
		this.listPage = listPage;
	}

	public List<CrmPage> getListPageAll() {
		return listPageAll;
	}

	public void setListPageAll(List<CrmPage> listPageAll) {
		this.listPageAll = listPageAll;
	}

	public String getPageDefault() {
		return pageDefault;
	}

	public void setPageDefault(String pageDefault) {
		this.pageDefault = pageDefault;
	}
	
	public List<CrmBranch> getListBranch() {
		return listBranch;
	}

	public void setListBranch(List<CrmBranch> listBranch) {
		this.listBranch = listBranch;
	}

	public List<CrmBranch> getListBranchAll() {
		return listBranchAll;
	}

	public void setListBranchAll(List<CrmBranch> listBranchAll) {
		this.listBranchAll = listBranchAll;
	}

	public List<CrmParameter> getListParameter() {
		return listParameter;
	}

	public void setListParameter(List<CrmParameter> listParameter) {
		this.listParameter = listParameter;
	}

	public List<WSBean> getListWSGroupSellers() {
		return listWSGroupSellers;
	}

	public void setListWSGroupSellers(List<WSBean> listWSGroupSellers) {
		this.listWSGroupSellers = listWSGroupSellers;
	}

	public CrmPatient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(CrmPatient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		for (CrmRole role : roles) {
			list.add(new GrantedAuthorityImpl(role.getName()));
		}
		return list;
	}
}
