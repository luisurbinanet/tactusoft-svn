package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import co.com.tactusoft.crm.util.FacesUtil;

/**
 * CrmDoctorSchedule generated by hbm2java
 */
@Entity
@Table(name = "crm_doctor_schedule", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_doctor", "day" }))
public class CrmDoctorSchedule implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmDoctor crmDoctor;
	private Integer day;
	private Date startHour;
	private Date endHour;

	public CrmDoctorSchedule() {
	}

	public CrmDoctorSchedule(BigDecimal id, CrmDoctor crmDoctor, Integer day,
			Date startHour, Date endHour) {
		this.id = id;
		this.crmDoctor = crmDoctor;
		this.day = day;
		this.startHour = startHour;
		this.endHour = endHour;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor", nullable = false)
	public CrmDoctor getCrmDoctor() {
		return this.crmDoctor;
	}

	public void setCrmDoctor(CrmDoctor crmDoctor) {
		this.crmDoctor = crmDoctor;
	}

	@Column(name = "day", nullable = false)
	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "start_hour", nullable = false, length = 8)
	public Date getStartHour() {
		return this.startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "end_hour", nullable = false, length = 8)
	public Date getEndHour() {
		return this.endHour;
	}

	public void setEndHour(Date endHour) {
		this.endHour = endHour;
	}

	@Transient
	public String getDetDay() {
		String det = null;
		switch (this.day) {
		case Calendar.SUNDAY:
			det = FacesUtil.getMessage("day_sunday");
			break;
		case Calendar.MONDAY:
			det = FacesUtil.getMessage("day_monday");
			break;
		case Calendar.TUESDAY:
			det = FacesUtil.getMessage("day_tuesday");
			break;
		case Calendar.WEDNESDAY:
			det = FacesUtil.getMessage("day_wednesday");
			break;
		case Calendar.THURSDAY:
			det = FacesUtil.getMessage("day_thursday");
			break;
		case Calendar.FRIDAY:
			det = FacesUtil.getMessage("day_friday");
			break;
		case Calendar.SATURDAY:
			det = FacesUtil.getMessage("day_saturday");
			break;
		}
		return det;
	}

}
