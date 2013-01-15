package co.com.tactusoft.crm.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DatesIdBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date minDate;
	private Date maxDate;
	private Long day;

	public DatesIdBean() {

	}

	@Column(name = "min_date")
	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	@Column(name = "max_date")
	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	@Column(name = "day")
	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

}
