package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.util.FacesUtil;

public class Candidate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private CrmDoctor doctor;
	private Date startDate;
	private Date endDate;

	public Candidate() {

	}

	public Candidate(int id) {
		this.id = id;
	}

	public Candidate(int id, CrmDoctor doctor, Date startDate, Date endDate) {
		this.id = id;
		this.doctor = doctor;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDetail() {
		String dateString = FacesUtil.formatDate(startDate, "dd/MM/yyyy");
		String startHour = FacesUtil.formatDate(startDate, "HH:mm");
		String endHour = FacesUtil.formatDate(endDate, "HH:mm");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		int day = calendar.get(Calendar.DAY_OF_WEEK);

		String detDay = null;
		switch (day) {
		case Calendar.SUNDAY:
			detDay = FacesUtil.getMessage("day_sunday");
			break;
		case Calendar.MONDAY:
			detDay = FacesUtil.getMessage("day_monday");
			break;
		case Calendar.TUESDAY:
			detDay = FacesUtil.getMessage("day_tuesday");
			break;
		case Calendar.WEDNESDAY:
			detDay = FacesUtil.getMessage("day_wednesday");
			break;
		case Calendar.THURSDAY:
			detDay = FacesUtil.getMessage("day_thursday");
			break;
		case Calendar.FRIDAY:
			detDay = FacesUtil.getMessage("day_friday");
			break;
		case Calendar.SATURDAY:
			detDay = FacesUtil.getMessage("day_saturday");
			break;
		}

		return detDay + ", " + dateString + "    " + startHour + " - "
				+ endHour;
	}

	public String getDoctorDetail() {
		String dateString = FacesUtil.formatDate(startDate, "dd/MM/yyyy");
		String startHour = FacesUtil.formatDate(startDate, "HH:mm");
		String endHour = FacesUtil.formatDate(endDate, "HH:mm");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		int day = calendar.get(Calendar.DAY_OF_WEEK);

		String detDay = null;
		switch (day) {
		case Calendar.SUNDAY:
			detDay = FacesUtil.getMessage("day_sunday");
			break;
		case Calendar.MONDAY:
			detDay = FacesUtil.getMessage("day_monday");
			break;
		case Calendar.TUESDAY:
			detDay = FacesUtil.getMessage("day_tuesday");
			break;
		case Calendar.WEDNESDAY:
			detDay = FacesUtil.getMessage("day_wednesday");
			break;
		case Calendar.THURSDAY:
			detDay = FacesUtil.getMessage("day_thursday");
			break;
		case Calendar.FRIDAY:
			detDay = FacesUtil.getMessage("day_friday");
			break;
		case Calendar.SATURDAY:
			detDay = FacesUtil.getMessage("day_saturday");
			break;
		}

		return this.doctor.getNames() + ":   " + detDay + ", "
				+ dateString + "    " + startHour + " - " + endHour;
	}

}
