package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmUser generated by hbm2java
 */
@Entity
@Table(name = "crm_user", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class CrmUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmDepartment crmDepartment;
	private CrmProfile crmProfile;
	private String username;
	private String password;
	private String doc;
	private String names;
	private String surnames;
	private String email;
	private String phone;
	private String extension;
	private int state;
	private Set<CrmUserBranch> crmUserBranchs = new HashSet<CrmUserBranch>(0);
	private Set<CrmUserRole> crmUserRoles = new HashSet<CrmUserRole>(0);

	public CrmUser() {
	}

	public CrmUser(BigDecimal id, CrmDepartment crmDepartment,
			CrmProfile crmProfile, String username, String password,
			String doc, String names, String surnames, String email, int state) {
		this.id = id;
		this.crmDepartment = crmDepartment;
		this.crmProfile = crmProfile;
		this.username = username;
		this.password = password;
		this.doc = doc;
		this.names = names;
		this.surnames = surnames;
		this.email = email;
		this.state = state;
	}

	public CrmUser(BigDecimal id, CrmDepartment crmDepartment,
			CrmProfile crmProfile, String username, String password,
			String doc, String names, String surnames, String email,
			String phone, String extension, int state,
			Set<CrmUserBranch> crmUserBranchs, Set<CrmUserRole> crmUserRoles) {
		this.id = id;
		this.crmDepartment = crmDepartment;
		this.crmProfile = crmProfile;
		this.username = username;
		this.password = password;
		this.doc = doc;
		this.names = names;
		this.surnames = surnames;
		this.email = email;
		this.phone = phone;
		this.extension = extension;
		this.state = state;
		this.crmUserBranchs = crmUserBranchs;
		this.crmUserRoles = crmUserRoles;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_departament", nullable = false)
	public CrmDepartment getCrmDepartment() {
		return this.crmDepartment;
	}

	public void setCrmDepartment(CrmDepartment crmDepartment) {
		this.crmDepartment = crmDepartment;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_profile", nullable = false)
	public CrmProfile getCrmProfile() {
		return this.crmProfile;
	}

	public void setCrmProfile(CrmProfile crmProfile) {
		this.crmProfile = crmProfile;
	}

	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "doc", nullable = false, length = 45)
	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	@Column(name = "names", nullable = false)
	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	@Column(name = "surnames", nullable = false)
	public String getSurnames() {
		return this.surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	@Column(name = "email", nullable = false, length = 1000)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "extension")
	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmUser")
	public Set<CrmUserBranch> getCrmUserBranchs() {
		return this.crmUserBranchs;
	}

	public void setCrmUserBranchs(Set<CrmUserBranch> crmUserBranchs) {
		this.crmUserBranchs = crmUserBranchs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmUser")
	public Set<CrmUserRole> getCrmUserRoles() {
		return this.crmUserRoles;
	}

	public void setCrmUserRoles(Set<CrmUserRole> crmUserRoles) {
		this.crmUserRoles = crmUserRoles;
	}

}