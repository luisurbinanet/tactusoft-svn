package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VwDoctorHourId generated by hbm2java
 */
@Embeddable
public class VwDoctorHourId implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal idBranch;
	private Date appointmentDate;
	private BigDecimal idDoctor;
	private String doctorName;
	private String doctorSurname;

	public VwDoctorHourId() {
	}

	public VwDoctorHourId(BigDecimal idBranch, BigDecimal idDoctor,
			String doctorName, String doctorSurname) {
		this.idBranch = idBranch;
		this.idDoctor = idDoctor;
		this.doctorName = doctorName;
		this.doctorSurname = doctorSurname;
	}

	public VwDoctorHourId(BigDecimal idBranch, Date appointmentDate,
			BigDecimal idDoctor, String doctorName,
			String doctorSurname) {
		this.idBranch = idBranch;
		this.appointmentDate = appointmentDate;
		this.idDoctor = idDoctor;
		this.doctorName = doctorName;
		this.doctorSurname = doctorSurname;
	}

	@Column(name = "id_branch", nullable = false, scale = 0)
	public BigDecimal getIdBranch() {
		return this.idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	@Column(name = "appointment_date", length = 10)
	public Date getAppointmentDate() {
		return this.appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Column(name = "id_doctor", nullable = false, scale = 0)
	public BigDecimal getIdDoctor() {
		return this.idDoctor;
	}

	public void setIdDoctor(BigDecimal idDoctor) {
		this.idDoctor = idDoctor;
	}

	@Column(name = "doctor_name", nullable = false, length = 45)
	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Column(name = "doctor_surname", nullable = false, length = 45)
	public String getDoctorSurname() {
		return this.doctorSurname;
	}

	public void setDoctorSurname(String doctorSurname) {
		this.doctorSurname = doctorSurname;
	}
}
