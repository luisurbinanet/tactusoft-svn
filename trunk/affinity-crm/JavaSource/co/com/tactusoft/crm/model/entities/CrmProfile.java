package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmProfile generated by hbm2java
 */
@Entity
@Table(name = "crm_profile", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class CrmProfile implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String code;
	private String description;
	private String salesOrg;
	private String distrChan;
	private String division;
	private String country;
	private String city;
	private String region;
	private int state;
	private Set<CrmUser> crmUsers = new HashSet<CrmUser>(0);

	public CrmProfile() {
	}

	public CrmProfile(BigDecimal id, String code, int state) {
		this.id = id;
		this.code = code;
		this.state = state;
	}

	public CrmProfile(BigDecimal id, String code, String description,
			String salesOrg, String distrChan, String division, String country,
			String city, String region, int state, Set<CrmUser> crmUsers) {
		this.id = id;
		this.code = code;
		this.description = description;
		this.salesOrg = salesOrg;
		this.distrChan = distrChan;
		this.division = division;
		this.country = country;
		this.city = city;
		this.region = region;
		this.state = state;
		this.crmUsers = crmUsers;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "code", unique = true, nullable = false, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "sales_org", length = 4)
	public String getSalesOrg() {
		return this.salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	@Column(name = "distr_chan", length = 4)
	public String getDistrChan() {
		return this.distrChan;
	}

	public void setDistrChan(String distrChan) {
		this.distrChan = distrChan;
	}

	@Column(name = "division", length = 4)
	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Column(name = "country", length = 2)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "region", length = 2)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmProfile")
	public Set<CrmUser> getCrmUsers() {
		return this.crmUsers;
	}

	public void setCrmUsers(Set<CrmUser> crmUsers) {
		this.crmUsers = crmUsers;
	}

}
