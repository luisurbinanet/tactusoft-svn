package co.com.tactusoft.crm.postsale.main;

import java.io.Serializable;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmPatient;

public class StorageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private CrmPatient crmPatient;
	private CrmAppointment crmAppointment;
	private String type;

	public StorageBean(){
		
	}
	
	public StorageBean(CrmPatient crmPatient, CrmAppointment crmAppointment,
			String type) {
		this.crmPatient = crmPatient;
		this.crmAppointment = crmAppointment;
		this.type = type;
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

}
