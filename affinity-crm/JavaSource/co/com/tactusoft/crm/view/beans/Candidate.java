package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;
import java.util.Date;

import co.com.tactusoft.crm.model.entities.CrmDoctor;

public class Candidate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CrmDoctor doctor;
	private Date startDate;
	private Date endDate;

	public Candidate() {

	}

	public Candidate(CrmDoctor doctor, Date startDate, Date endDate) {
		this.doctor = doctor;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CrmDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(CrmDoctor doctor) {
		this.doctor = doctor;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String detail() {
		return "";
	}

}
