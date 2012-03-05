package co.com.tactusoft.medical.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import co.com.tactusoft.medical.model.entities.MedUser;
import co.com.tactusoft.medical.view.datamodel.MenuDataModel;

public class UserData implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String role;
	private MedUser user;
	private List<MenuDataModel> listMenu;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public MedUser getUser() {
		return user;
	}

	public void setUser(MedUser user) {
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

	public List<MenuDataModel> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<MenuDataModel> listMenu) {
		this.listMenu = listMenu;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new GrantedAuthorityImpl(role));
		return list;
	}
}
