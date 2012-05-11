package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
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

/**
 * CrmAppointment generated by hbm2java
 */
@Entity
@Table(name = "crm_appointment", catalog = "crm_db")
public class CrmAppointment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmProcedureDetail crmProcedureDetail;
	private CrmDoctor crmDoctor;
	private String patient;
	private Date startAppointmentDate;
	private Date endAppointmentDate;
	private BigDecimal idPublicity;
	private BigDecimal idBranch;
	private BigDecimal appointmentDetailType;

	public CrmAppointment() {
	}

	public CrmAppointment(BigDecimal id, CrmProcedureDetail crmProcedureDetail,
			CrmDoctor crmDoctor, String patient, Date startAppointmentDate,
			Date endAppointmentDate, BigDecimal idPublicity,
			BigDecimal idBranch, BigDecimal appointmentDetailType) {
		this.id = id;
		this.crmProcedureDetail = crmProcedureDetail;
		this.crmDoctor = crmDoctor;
		this.patient = patient;
		this.startAppointmentDate = startAppointmentDate;
		this.endAppointmentDate = endAppointmentDate;
		this.idPublicity = idPublicity;
		this.idBranch = idBranch;
		this.appointmentDetailType = appointmentDetailType;
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
	@JoinColumn(name = "id_procedure_detail", nullable = false)
	public CrmProcedureDetail getCrmProcedureDetail() {
		return this.crmProcedureDetail;
	}

	public void setCrmProcedureDetail(CrmProcedureDetail crmProcedureDetail) {
		this.crmProcedureDetail = crmProcedureDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_doctor", nullable = false)
	public CrmDoctor getCrmDoctor() {
		return this.crmDoctor;
	}

	public void setCrmDoctor(CrmDoctor crmDoctor) {
		this.crmDoctor = crmDoctor;
	}

	@Column(name = "patient", nullable = false, length = 45)
	public String getPatient() {
		return this.patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_appointment_date", nullable = false, length = 19)
	public Date getStartAppointmentDate() {
		return this.startAppointmentDate;
	}

	public void setStartAppointmentDate(Date startAppointmentDate) {
		this.startAppointmentDate = startAppointmentDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_appointment_date", nullable = false, length = 19)
	public Date getEndAppointmentDate() {
		return this.endAppointmentDate;
	}

	public void setEndAppointmentDate(Date endAppointmentDate) {
		this.endAppointmentDate = endAppointmentDate;
	}

	@Column(name = "id_publicity", nullable = false, scale = 0)
	public BigDecimal getIdPublicity() {
		return this.idPublicity;
	}

	public void setIdPublicity(BigDecimal idPublicity) {
		this.idPublicity = idPublicity;
	}

	@Column(name = "id_branch", nullable = false, scale = 0)
	public BigDecimal getIdBranch() {
		return this.idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	@Column(name = "appointment_detail_type", nullable = false, scale = 0)
	public BigDecimal getAppointmentDetailType() {
		return this.appointmentDetailType;
	}

	public void setAppointmentDetailType(BigDecimal appointmentDetailType) {
		this.appointmentDetailType = appointmentDetailType;
	}

}
