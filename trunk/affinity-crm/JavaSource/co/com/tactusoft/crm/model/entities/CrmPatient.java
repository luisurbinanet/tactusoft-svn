package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * CrmPatient generated by hbm2java
 */
@Entity
@Table(name = "crm_patient", catalog = "crm_db", uniqueConstraints = {
		@UniqueConstraint(columnNames = "doc"),
		@UniqueConstraint(columnNames = "code_sap") })
public class CrmPatient implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String doc;
	private String codeSap;
	private String names;
	private String surnames;
	private Date bornDate;
	private String gender;
	private String occupation;
	private String address;
	private String neighborhood;
	private String telephone;
	private String typeHousing;
	private String country;
	private String region;
	private String city;
	private String guardian;
	private String guardianAddress;
	private String guardianRelationship;
	private String guardianTelephone;
	private String obs;
	private Boolean cycle;
	private Boolean sendPhone;
	private Boolean sendEmail;
	private Boolean sendPostal;
	private Boolean sendSms;

	public CrmPatient() {
	}

	public CrmPatient(BigDecimal id) {
		this.id = id;
	}

	public CrmPatient(BigDecimal id, String doc, String codeSap, String names,
			String surnames, Date bornDate, String gender, String occupation,
			String address, String neighborhood, String telephone,
			String typeHousing, String country, String region, String city,
			String guardian, String guardianAddress,
			String guardianRelationship, String guardianTelephone, String obs,
			Boolean cycle, Boolean sendPhone, Boolean sendEmail,
			Boolean sendPostal, Boolean sendSms) {
		this.id = id;
		this.doc = doc;
		this.codeSap = codeSap;
		this.names = names;
		this.surnames = surnames;
		this.bornDate = bornDate;
		this.gender = gender;
		this.occupation = occupation;
		this.address = address;
		this.neighborhood = neighborhood;
		this.telephone = telephone;
		this.typeHousing = typeHousing;
		this.country = country;
		this.region = region;
		this.city = city;
		this.guardian = guardian;
		this.guardianAddress = guardianAddress;
		this.guardianRelationship = guardianRelationship;
		this.guardianTelephone = guardianTelephone;
		this.obs = obs;
		this.cycle = cycle;
		this.sendPhone = sendPhone;
		this.sendEmail = sendEmail;
		this.sendPostal = sendPostal;
		this.sendSms = sendSms;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "doc", unique = true, length = 45)
	public String getDoc() {
		return this.doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	@Column(name = "code_sap", unique = true, length = 45)
	public String getCodeSap() {
		return this.codeSap;
	}

	public void setCodeSap(String codeSap) {
		this.codeSap = codeSap;
	}

	@Column(name = "names", length = 45)
	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	@Column(name = "surnames", length = 45)
	public String getSurnames() {
		return this.surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "born_date", length = 10)
	public Date getBornDate() {
		return this.bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	@Column(name = "gender", length = 45)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "occupation")
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "neighborhood", length = 45)
	public String getNeighborhood() {
		return this.neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	@Column(name = "telephone", length = 45)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "type_housing", length = 45)
	public String getTypeHousing() {
		return this.typeHousing;
	}

	public void setTypeHousing(String typeHousing) {
		this.typeHousing = typeHousing;
	}

	@Column(name = "country", length = 45)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "region", length = 45)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "guardian")
	public String getGuardian() {
		return this.guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	@Column(name = "guardian_address")
	public String getGuardianAddress() {
		return this.guardianAddress;
	}

	public void setGuardianAddress(String guardianAddress) {
		this.guardianAddress = guardianAddress;
	}

	@Column(name = "guardian_relationship")
	public String getGuardianRelationship() {
		return this.guardianRelationship;
	}

	public void setGuardianRelationship(String guardianRelationship) {
		this.guardianRelationship = guardianRelationship;
	}

	@Column(name = "guardian_telephone")
	public String getGuardianTelephone() {
		return this.guardianTelephone;
	}

	public void setGuardianTelephone(String guardianTelephone) {
		this.guardianTelephone = guardianTelephone;
	}

	@Column(name = "obs", length = 1000)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Column(name = "cycle")
	public Boolean getCycle() {
		return this.cycle;
	}

	public void setCycle(Boolean cycle) {
		this.cycle = cycle;
	}

	@Column(name = "send_phone")
	public Boolean getSendPhone() {
		return this.sendPhone;
	}

	public void setSendPhone(Boolean sendPhone) {
		this.sendPhone = sendPhone;
	}

	@Column(name = "send_email")
	public Boolean getSendEmail() {
		return this.sendEmail;
	}

	public void setSendEmail(Boolean sendEmail) {
		this.sendEmail = sendEmail;
	}

	@Column(name = "send_postal")
	public Boolean getSendPostal() {
		return this.sendPostal;
	}

	public void setSendPostal(Boolean sendPostal) {
		this.sendPostal = sendPostal;
	}

	@Column(name = "send_sms")
	public Boolean getSendSms() {
		return this.sendSms;
	}

	public void setSendSms(Boolean sendSms) {
		this.sendSms = sendSms;
	}

}
