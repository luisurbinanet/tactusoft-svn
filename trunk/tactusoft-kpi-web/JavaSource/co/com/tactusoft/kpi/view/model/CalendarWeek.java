package co.com.tactusoft.kpi.view.model;

import java.io.Serializable;
import java.util.Date;

public class CalendarWeek implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer week;
	private Date starDate;
	private Date endDate;
	private String label;

	public CalendarWeek() {

	}

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public Date getStarDate() {
		return starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
