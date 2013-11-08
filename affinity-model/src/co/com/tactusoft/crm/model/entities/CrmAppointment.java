package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * CrmAppointment generated by hbm2java
 */
@Entity
@Table(name = "crm_appointment", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class CrmAppointment implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmProcedureDetail crmProcedureDetail;
	private CrmUser crmUserByIdUserChecked;
	private CrmPatient crmPatient;
	private CrmUser crmUserByIdUserModified;
	private CrmUser crmUserByIdUserCreate;
	private CrmBranch crmBranch;
	private CrmUser crmUserByIdUserCanceled;
	private CrmUser crmUserByIdUserOpened;
	private CrmDoctor crmDoctor;
	private String code;
	private String patientNames;
	private Date startAppointmentDate;
	private Date endAppointmentDate;
	private String codPublicity;
	private String namePublicity;
	private String obs;
	private Boolean untimely;
	private Boolean closeAppointment;
	private Boolean medicationTherapy;
	private int state;
	private Date dateCreate;
	private Date dateModified;
	private Date dateChecked;
	private Date dateCanceled;
	private Date dateOpened;
	private String obsOpened;
	private Long sapMaterialCode;
	private String sapMaterialDesc;
	private String obsCancel;
	private Set<CrmDiagnosis> crmDiagnosises = new HashSet<CrmDiagnosis>(0);
	private Set<CrmMedication> crmMedications = new HashSet<CrmMedication>(0);

	public CrmAppointment() {
	}

	public CrmAppointment(BigDecimal id, CrmProcedureDetail crmProcedureDetail,
			CrmPatient crmPatient, CrmBranch crmBranch, CrmDoctor crmDoctor,
			String code, Date startAppointmentDate, Date endAppointmentDate,
			int state) {
		this.id = id;
		this.crmProcedureDetail = crmProcedureDetail;
		this.crmPatient = crmPatient;
		this.crmBranch = crmBranch;
		this.crmDoctor = crmDoctor;
		this.code = code;
		this.startAppointmentDate = startAppointmentDate;
		this.endAppointmentDate = endAppointmentDate;
		this.state = state;
	}

	public CrmAppointment(BigDecimal id, CrmProcedureDetail crmProcedureDetail,
			CrmUser crmUserByIdUserChecked, CrmPatient crmPatient,
			CrmUser crmUserByIdUserModified, CrmUser crmUserByIdUserCreate,
			CrmBranch crmBranch, CrmUser crmUserByIdUserCanceled,
			CrmUser crmUserByIdUserOpened, CrmDoctor crmDoctor, String code,
			String patientNames, Date startAppointmentDate,
			Date endAppointmentDate, String codPublicity, String namePublicity,
			String obs, Boolean untimely, Boolean closeAppointment,
			Boolean medicationTherapy, int state, Date dateCreate,
			Date dateModified, Date dateChecked, Date dateCanceled,
			Date dateOpened, String obsOpened,
			Set<CrmDiagnosis> crmDiagnosises, Set<CrmMedication> crmMedications) {
		this.id = id;
		this.crmProcedureDetail = crmProcedureDetail;
		this.crmUserByIdUserChecked = crmUserByIdUserChecked;
		this.crmPatient = crmPatient;
		this.crmUserByIdUserModified = crmUserByIdUserModified;
		this.crmUserByIdUserCreate = crmUserByIdUserCreate;
		this.crmBranch = crmBranch;
		this.crmUserByIdUserCanceled = crmUserByIdUserCanceled;
		this.crmUserByIdUserOpened = crmUserByIdUserOpened;
		this.crmDoctor = crmDoctor;
		this.code = code;
		this.patientNames = patientNames;
		this.startAppointmentDate = startAppointmentDate;
		this.endAppointmentDate = endAppointmentDate;
		this.codPublicity = codPublicity;
		this.namePublicity = namePublicity;
		this.obs = obs;
		this.untimely = untimely;
		this.closeAppointment = closeAppointment;
		this.medicationTherapy = medicationTherapy;
		this.state = state;
		this.dateCreate = dateCreate;
		this.dateModified = dateModified;
		this.dateChecked = dateChecked;
		this.dateCanceled = dateCanceled;
		this.dateOpened = dateOpened;
		this.crmDiagnosises = crmDiagnosises;
		this.crmMedications = crmMedications;
		this.obsOpened = obsOpened;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_procedure_detail", nullable = false)
	public CrmProcedureDetail getCrmProcedureDetail() {
		return this.crmProcedureDetail;
	}

	public void setCrmProcedureDetail(CrmProcedureDetail crmProcedureDetail) {
		this.crmProcedureDetail = crmProcedureDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user_checked")
	public CrmUser getCrmUserByIdUserChecked() {
		return this.crmUserByIdUserChecked;
	}

	public void setCrmUserByIdUserChecked(CrmUser crmUserByIdUserChecked) {
		this.crmUserByIdUserChecked = crmUserByIdUserChecked;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_patient", nullable = false)
	public CrmPatient getCrmPatient() {
		return this.crmPatient;
	}

	public void setCrmPatient(CrmPatient crmPatient) {
		this.crmPatient = crmPatient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user_modified")
	public CrmUser getCrmUserByIdUserModified() {
		return this.crmUserByIdUserModified;
	}

	public void setCrmUserByIdUserModified(CrmUser crmUserByIdUserModified) {
		this.crmUserByIdUserModified = crmUserByIdUserModified;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user_create")
	public CrmUser getCrmUserByIdUserCreate() {
		return this.crmUserByIdUserCreate;
	}

	public void setCrmUserByIdUserCreate(CrmUser crmUserByIdUserCreate) {
		this.crmUserByIdUserCreate = crmUserByIdUserCreate;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_branch", nullable = false)
	public CrmBranch getCrmBranch() {
		return this.crmBranch;
	}

	public void setCrmBranch(CrmBranch crmBranch) {
		this.crmBranch = crmBranch;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user_canceled")
	public CrmUser getCrmUserByIdUserCanceled() {
		return this.crmUserByIdUserCanceled;
	}

	public void setCrmUserByIdUserCanceled(CrmUser crmUserByIdUserCanceled) {
		this.crmUserByIdUserCanceled = crmUserByIdUserCanceled;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user_opened")
	public CrmUser getCrmUserByIdUserOpened() {
		return crmUserByIdUserOpened;
	}

	public void setCrmUserByIdUserOpened(CrmUser crmUserByIdUserOpened) {
		this.crmUserByIdUserOpened = crmUserByIdUserOpened;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_doctor", nullable = false)
	public CrmDoctor getCrmDoctor() {
		return this.crmDoctor;
	}

	public void setCrmDoctor(CrmDoctor crmDoctor) {
		this.crmDoctor = crmDoctor;
	}

	@Column(name = "code", unique = true, nullable = false, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "patient_names", length = 1000)
	public String getPatientNames() {
		return this.patientNames;
	}

	public void setPatientNames(String patientNames) {
		this.patientNames = patientNames;
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

	@Column(name = "cod_publicity", length = 45)
	public String getCodPublicity() {
		return this.codPublicity;
	}

	public void setCodPublicity(String codPublicity) {
		this.codPublicity = codPublicity;
	}

	@Column(name = "name_publicity", length = 1000)
	public String getNamePublicity() {
		return this.namePublicity;
	}

	public void setNamePublicity(String namePublicity) {
		this.namePublicity = namePublicity;
	}

	@Column(name = "obs", length = 65535)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Column(name = "untimely")
	public Boolean getUntimely() {
		return this.untimely;
	}

	public void setUntimely(Boolean untimely) {
		this.untimely = untimely;
	}

	@Column(name = "close_appointment", nullable = false)
	public Boolean getCloseAppointment() {
		return this.closeAppointment;
	}

	public void setCloseAppointment(Boolean closeAppointment) {
		this.closeAppointment = closeAppointment;
	}

	@Column(name = "medication_therapy")
	public Boolean getMedicationTherapy() {
		return this.medicationTherapy;
	}

	public void setMedicationTherapy(Boolean medicationTherapy) {
		this.medicationTherapy = medicationTherapy;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_create", length = 19)
	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_modified", length = 19)
	public Date getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_checked", length = 19)
	public Date getDateChecked() {
		return this.dateChecked;
	}

	public void setDateChecked(Date dateChecked) {
		this.dateChecked = dateChecked;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_canceled", length = 19)
	public Date getDateCanceled() {
		return this.dateCanceled;
	}

	public void setDateCanceled(Date dateCanceled) {
		this.dateCanceled = dateCanceled;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_opened", length = 19)
	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	@Column(name = "obs_opened", length = 65535)
	public String getObsOpened() {
		return obsOpened;
	}

	public void setObsOpened(String obsOpened) {
		this.obsOpened = obsOpened;
	}

	@Column(name = "sap_material_code")
	public Long getSapMaterialCode() {
		return sapMaterialCode;
	}

	public void setSapMaterialCode(Long sapMaterialCode) {
		this.sapMaterialCode = sapMaterialCode;
	}

	@Column(name = "sap_material_desc", length = 1000)
	public String getSapMaterialDesc() {
		return sapMaterialDesc;
	}

	public void setSapMaterialDesc(String sapMaterialDesc) {
		this.sapMaterialDesc = sapMaterialDesc;
	}

	@Column(name = "obs_cancel", length = 65535)
	public String getObsCancel() {
		return obsCancel;
	}

	public void setObsCancel(String obsCancel) {
		this.obsCancel = obsCancel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmAppointment")
	public Set<CrmDiagnosis> getCrmDiagnosises() {
		return this.crmDiagnosises;
	}

	public void setCrmDiagnosises(Set<CrmDiagnosis> crmDiagnosises) {
		this.crmDiagnosises = crmDiagnosises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmAppointment")
	public Set<CrmMedication> getCrmMedications() {
		return this.crmMedications;
	}

	public void setCrmMedications(Set<CrmMedication> crmMedications) {
		this.crmMedications = crmMedications;
	}

}
