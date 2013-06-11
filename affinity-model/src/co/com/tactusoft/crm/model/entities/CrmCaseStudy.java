package co.com.tactusoft.crm.model.entities;

// Generated 03-jun-2013 11:22:06 by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "crm_case_study", catalog = "crm_db")
public class CrmCaseStudy implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private CrmCie crmCie;
	private CrmAppointment crmAppointment;
	private Date startDate;
	private String reason;
	private int percent;

	public CrmCaseStudy() {
	}

	public CrmCaseStudy(CrmCie crmCie, CrmAppointment crmAppointment,
			Date startDate, String reason, int percent) {
		this.crmCie = crmCie;
		this.crmAppointment = crmAppointment;
		this.startDate = startDate;
		this.reason = reason;
		this.percent = percent;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cie", nullable = false)
	public CrmCie getCrmCie() {
		return this.crmCie;
	}

	public void setCrmCie(CrmCie crmCie) {
		this.crmCie = crmCie;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appointment", nullable = false)
	public CrmAppointment getCrmAppointment() {
		return this.crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "reason", nullable = false, length = 65535)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "percent", nullable = false)
	public int getPercent() {
		return this.percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

}
