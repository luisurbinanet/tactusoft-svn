package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal id;
	private String code;
	private String firstName;
	private String secondName;
	private String firstSurname;
	private String secondSurname;
	private String gender;
	private String address;
	private String email;
	private String phoneNumber;
	private String cellNumber;
	private String country;
	private String region;
	private String city;
	private Boolean cycle;
	private Integer sendPhone;
	private Integer sendEmail;
	private Integer sendPortal;
	private Integer sendSMS;
	
	private String SAPCode;
	private String names;
	
	public Patient() {

	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public Boolean getCycle() {
		return cycle;
	}

	public void setCycle(Boolean cycle) {
		this.cycle = cycle;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getSendPhone() {
		return sendPhone;
	}

	public void setSendPhone(Integer sendPhone) {
		this.sendPhone = sendPhone;
	}

	public Integer getSendEmail() {
		return sendEmail;
	}

	public void setSendEmail(Integer sendEmail) {
		this.sendEmail = sendEmail;
	}

	public Integer getSendPortal() {
		return sendPortal;
	}

	public void setSendPortal(Integer sendPortal) {
		this.sendPortal = sendPortal;
	}

	public Integer getSendSMS() {
		return sendSMS;
	}

	public void setSendSMS(Integer sendSMS) {
		this.sendSMS = sendSMS;
	}

	public String getSAPCode() {
		return SAPCode;
	}

	public void setSAPCode(String sAPCode) {
		SAPCode = sAPCode;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

}
