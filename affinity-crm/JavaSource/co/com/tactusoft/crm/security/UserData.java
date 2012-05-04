package co.com.tactusoft.crm.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.model.entities.CrmUser;

public class UserData implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private List<CrmRole> roles;
	private CrmUser user;
	private List<CrmPage> listPage;
	private List<CrmPage> listPageAll;
	private String pageDefault;

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

	public CrmUser getUser() {
		return user;
	}

	public void setUser(CrmUser user) {
		this.user = user;
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

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		for (CrmRole role : roles) {
			list.add(new GrantedAuthorityImpl(role.getName()));
		}
		return list;
	}
}
