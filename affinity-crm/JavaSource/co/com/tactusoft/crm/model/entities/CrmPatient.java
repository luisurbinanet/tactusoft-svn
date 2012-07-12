package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import co.com.tactusoft.crm.util.FacesUtil;

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
	private CrmOccupation crmOccupation;
	private String doc;
	private String codeSap;
	private String firstnames;
	private String surnames;
	private Date bornDate;
	private String gender;
	private String address;
	private String zipCode;
	private String neighborhood;
	private String phoneNumber;
	private String cellNumber;
	private String email;
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
	private String salesOrg;
	private BigDecimal idUserCreate;
	private Date dateCreate;
	private BigDecimal idUserModified;
	private Date dateModified;
	private Set<CrmHistoryPhysique> crmHistoryPhysiques = new HashSet<CrmHistoryPhysique>(
			0);
	private Set<CrmHistoryHomeopathic> crmHistoryHomeopathics = new HashSet<CrmHistoryHomeopathic>(
			0);
	private Set<CrmHistoryOrganometry> crmHistoryOrganometries = new HashSet<CrmHistoryOrganometry>(
			0);
	private Set<CrmHistoryRecord> crmHistoryRecords = new HashSet<CrmHistoryRecord>(
			0);
	private Set<CrmHistoryHistory> crmHistoryHistories = new HashSet<CrmHistoryHistory>(
			0);
	private Set<CrmAppointment> crmAppointments = new HashSet<CrmAppointment>(0);
	
	private String names;
	private int age;

	public CrmPatient() {
	}

	public CrmPatient(BigDecimal id, String doc, String codeSap) {
		this.id = id;
		this.doc = doc;
		this.codeSap = codeSap;
	}

	public CrmPatient(BigDecimal id, CrmOccupation crmOccupation, String doc,
			String codeSap, String firstnames, String surnames, Date bornDate,
			String gender, String address, String zipCode, String neighborhood,
			String phoneNumber, String cellNumber, String email,
			String typeHousing, String country, String region, String city,
			String guardian, String guardianAddress,
			String guardianRelationship, String guardianTelephone, String obs,
			Boolean cycle, Boolean sendPhone, Boolean sendEmail,
			Boolean sendPostal, Boolean sendSms, String salesOrg,
			BigDecimal idUserCreate, Date dateCreate,
			BigDecimal idUserModified, Date dateModified,
			Set<CrmHistoryPhysique> crmHistoryPhysiques,
			Set<CrmHistoryHomeopathic> crmHistoryHomeopathics,
			Set<CrmHistoryOrganometry> crmHistoryOrganometries,
			Set<CrmHistoryRecord> crmHistoryRecords,
			Set<CrmHistoryHistory> crmHistoryHistories,
			Set<CrmAppointment> crmAppointments) {
		this.id = id;
		this.crmOccupation = crmOccupation;
		this.doc = doc;
		this.codeSap = codeSap;
		this.firstnames = firstnames;
		this.surnames = surnames;
		this.bornDate = bornDate;
		this.gender = gender;
		this.address = address;
		this.zipCode = zipCode;
		this.neighborhood = neighborhood;
		this.phoneNumber = phoneNumber;
		this.cellNumber = cellNumber;
		this.email = email;
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
		this.salesOrg = salesOrg;
		this.idUserCreate = idUserCreate;
		this.dateCreate = dateCreate;
		this.idUserModified = idUserModified;
		this.dateModified = dateModified;
		this.crmHistoryPhysiques = crmHistoryPhysiques;
		this.crmHistoryHomeopathics = crmHistoryHomeopathics;
		this.crmHistoryOrganometries = crmHistoryOrganometries;
		this.crmHistoryRecords = crmHistoryRecords;
		this.crmHistoryHistories = crmHistoryHistories;
		this.crmAppointments = crmAppointments;
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
	@JoinColumn(name = "id_occupation")
	public CrmOccupation getCrmOccupation() {
		return this.crmOccupation;
	}

	public void setCrmOccupation(CrmOccupation crmOccupation) {
		this.crmOccupation = crmOccupation;
	}

	@Column(name = "doc", unique = true, nullable = false, length = 45)
	public String getDoc() {
		return this.doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	@Column(name = "code_sap", unique = true, nullable = false, length = 45)
	public String getCodeSap() {
		return this.codeSap;
	}

	public void setCodeSap(String codeSap) {
		this.codeSap = codeSap;
	}

	@Column(name = "firstnames", length = 45)
	public String getFirstnames() {
		return this.firstnames;
	}

	public void setFirstnames(String firstnames) {
		this.firstnames = firstnames;
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

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zip_code", length = 45)
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "neighborhood", length = 45)
	public String getNeighborhood() {
		return this.neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	@Column(name = "phone_number", length = 45)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "cell_number", length = 45)
	public String getCellNumber() {
		return this.cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	@Column(name = "email", length = 1000)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Column(name = "obs", length = 65535)
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

	@Column(name = "sales_org", length = 45)
	public String getSalesOrg() {
		return this.salesOrg;
	}

	public void setSalesOrg(String salesOrg) {
		this.salesOrg = salesOrg;
	}

	@Column(name = "id_user_create", scale = 0)
	public BigDecimal getIdUserCreate() {
		return this.idUserCreate;
	}

	public void setIdUserCreate(BigDecimal idUserCreate) {
		this.idUserCreate = idUserCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_create", length = 19)
	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	@Column(name = "id_user_modified", scale = 0)
	public BigDecimal getIdUserModified() {
		return this.idUserModified;
	}

	public void setIdUserModified(BigDecimal idUserModified) {
		this.idUserModified = idUserModified;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified", length = 19)
	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmPatient")
	public Set<CrmHistoryPhysique> getCrmHistoryPhysiques() {
		return this.crmHistoryPhysiques;
	}

	public void setCrmHistoryPhysiques(
			Set<CrmHistoryPhysique> crmHistoryPhysiques) {
		this.crmHistoryPhysiques = crmHistoryPhysiques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmPatient")
	public Set<CrmHistoryHomeopathic> getCrmHistoryHomeopathics() {
		return this.crmHistoryHomeopathics;
	}

	public void setCrmHistoryHomeopathics(
			Set<CrmHistoryHomeopathic> crmHistoryHomeopathics) {
		this.crmHistoryHomeopathics = crmHistoryHomeopathics;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmPatient")
	public Set<CrmHistoryOrganometry> getCrmHistoryOrganometries() {
		return this.crmHistoryOrganometries;
	}

	public void setCrmHistoryOrganometries(
			Set<CrmHistoryOrganometry> crmHistoryOrganometries) {
		this.crmHistoryOrganometries = crmHistoryOrganometries;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmPatient")
	public Set<CrmHistoryRecord> getCrmHistoryRecords() {
		return this.crmHistoryRecords;
	}

	public void setCrmHistoryRecords(Set<CrmHistoryRecord> crmHistoryRecords) {
		this.crmHistoryRecords = crmHistoryRecords;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmPatient")
	public Set<CrmHistoryHistory> getCrmHistoryHistories() {
		return this.crmHistoryHistories;
	}

	public void setCrmHistoryHistories(
			Set<CrmHistoryHistory> crmHistoryHistories) {
		this.crmHistoryHistories = crmHistoryHistories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmPatient")
	public Set<CrmAppointment> getCrmAppointments() {
		return this.crmAppointments;
	}

	public void setCrmAppointments(Set<CrmAppointment> crmAppointments) {
		this.crmAppointments = crmAppointments;
	}

	@Transient
	public String getNames() {
		if (FacesUtil.isEmptyOrBlank(this.names)) {
			if (FacesUtil.isEmptyOrBlank(this.surnames)) {
				this.names = "";
			} else {
				this.names = this.surnames + " " + this.firstnames;
			}
		}
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	@Transient
	public int getAge() {
		if (bornDate != null) {
			Calendar bornDate = Calendar.getInstance();
			bornDate.setTime(this.bornDate);

			Calendar currentDate = Calendar.getInstance();
			currentDate.setTime(new Date());

			age = currentDate.get(Calendar.YEAR) - bornDate.get(Calendar.YEAR);

			if ((bornDate.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))
					|| (bornDate.get(Calendar.MONTH) == currentDate
							.get(Calendar.MONTH) && bornDate
							.get(Calendar.DAY_OF_MONTH) > currentDate
							.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		}
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
