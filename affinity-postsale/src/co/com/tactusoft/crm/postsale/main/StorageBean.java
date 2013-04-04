package co.com.tactusoft.crm.postsale.main;

import java.io.Serializable;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmPatient;

public class StorageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private CrmPatient crmPatient;
	private CrmAppointment crmAppointment;
	private String type;
	private String medicationCode;
	private String medicationName;
	private int unit;

	public StorageBean() {

	}

	public StorageBean(CrmPatient crmPatient, CrmAppointment crmAppointment,
			String type) {
		this.crmPatient = crmPatient;
		this.crmAppointment = crmAppointment;
		this.type = type;
	}

	public StorageBean(CrmPatient crmPatient, CrmAppointment crmAppointment,
			String type, String medicationCode, String medicationName, int unit) {
		this.crmPatient = crmPatient;
		this.crmAppointment = crmAppointment;
		this.type = type;
		this.medicationCode = medicationCode;
		this.medicationName = medicationName;
		this.unit = unit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CrmPatient getCrmPatient() {
		return crmPatient;
	}

	public void setCrmPatient(CrmPatient crmPatient) {
		this.crmPatient = crmPatient;
	}

	public CrmAppointment getCrmAppointment() {
		return crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	public String getMedicationCode() {
		return medicationCode;
	}

	public void setMedicationCode(String medicationCode) {
		this.medicationCode = medicationCode;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

}
