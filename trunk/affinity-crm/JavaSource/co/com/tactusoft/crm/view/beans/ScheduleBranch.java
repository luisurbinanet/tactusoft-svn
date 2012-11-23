package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;

import co.com.tactusoft.crm.model.entities.CrmDoctorSchedule;

public class ScheduleBranch implements Serializable {

	private static final long serialVersionUID = 1L;
	private String line;
	private CrmDoctorSchedule crmDoctorSchedule;
	private String message;
	private int state;
	
	public ScheduleBranch(){
		
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public CrmDoctorSchedule getCrmDoctorSchedule() {
		return crmDoctorSchedule;
	}

	public void setCrmDoctorSchedule(CrmDoctorSchedule crmDoctorSchedule) {
		this.crmDoctorSchedule = crmDoctorSchedule;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
