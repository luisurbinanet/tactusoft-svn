package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmBranch generated by hbm2java
 */
@Entity
@Table(name = "crm_branch", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class CrmBranch implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String code;
	private String name;
	private String society;
	private Integer doctors;
	private Integer nurses;
	private Integer stretchers;
	private Integer state;
	private Set<CrmDoctorSchedule> crmDoctorSchedules = new HashSet<CrmDoctorSchedule>(
			0);
	private Set<CrmProcedureBranch> crmProcedureBranchs = new HashSet<CrmProcedureBranch>(
			0);
	private Set<CrmHolidayBranch> crmHolidayBranchs = new HashSet<CrmHolidayBranch>(
			0);
	private Set<CrmAppointment> crmAppointments = new HashSet<CrmAppointment>(0);
	private Set<CrmUserBranch> crmUserBranchs = new HashSet<CrmUserBranch>(0);

	public CrmBranch() {
	}

	public CrmBranch(BigDecimal id) {
		this.id = id;
	}

	public CrmBranch(BigDecimal id, String code, String name, String society,
			Integer doctors, Integer nurses, Integer stretchers, Integer state,
			Set<CrmDoctorSchedule> crmDoctorSchedules,
			Set<CrmProcedureBranch> crmProcedureBranchs,
			Set<CrmHolidayBranch> crmHolidayBranchs,
			Set<CrmAppointment> crmAppointments,
			Set<CrmUserBranch> crmUserBranchs) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.society = society;
		this.doctors = doctors;
		this.nurses = nurses;
		this.stretchers = stretchers;
		this.state = state;
		this.crmDoctorSchedules = crmDoctorSchedules;
		this.crmProcedureBranchs = crmProcedureBranchs;
		this.crmHolidayBranchs = crmHolidayBranchs;
		this.crmAppointments = crmAppointments;
		this.crmUserBranchs = crmUserBranchs;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "code", unique = true, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", length = 1000)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "society", length = 4)
	public String getSociety() {
		return this.society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	@Column(name = "doctors")
	public Integer getDoctors() {
		return this.doctors;
	}

	public void setDoctors(Integer doctors) {
		this.doctors = doctors;
	}

	@Column(name = "nurses")
	public Integer getNurses() {
		return this.nurses;
	}

	public void setNurses(Integer nurses) {
		this.nurses = nurses;
	}

	@Column(name = "stretchers")
	public Integer getStretchers() {
		return this.stretchers;
	}

	public void setStretchers(Integer stretchers) {
		this.stretchers = stretchers;
	}

	@Column(name = "state")
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmBranch")
	public Set<CrmDoctorSchedule> getCrmDoctorSchedules() {
		return this.crmDoctorSchedules;
	}

	public void setCrmDoctorSchedules(Set<CrmDoctorSchedule> crmDoctorSchedules) {
		this.crmDoctorSchedules = crmDoctorSchedules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmBranch")
	public Set<CrmProcedureBranch> getCrmProcedureBranchs() {
		return this.crmProcedureBranchs;
	}

	public void setCrmProcedureBranchs(
			Set<CrmProcedureBranch> crmProcedureBranchs) {
		this.crmProcedureBranchs = crmProcedureBranchs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmBranch")
	public Set<CrmHolidayBranch> getCrmHolidayBranchs() {
		return this.crmHolidayBranchs;
	}

	public void setCrmHolidayBranchs(Set<CrmHolidayBranch> crmHolidayBranchs) {
		this.crmHolidayBranchs = crmHolidayBranchs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmBranch")
	public Set<CrmAppointment> getCrmAppointments() {
		return this.crmAppointments;
	}

	public void setCrmAppointments(Set<CrmAppointment> crmAppointments) {
		this.crmAppointments = crmAppointments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmBranch")
	public Set<CrmUserBranch> getCrmUserBranchs() {
		return this.crmUserBranchs;
	}

	public void setCrmUserBranchs(Set<CrmUserBranch> crmUserBranchs) {
		this.crmUserBranchs = crmUserBranchs;
	}

}
