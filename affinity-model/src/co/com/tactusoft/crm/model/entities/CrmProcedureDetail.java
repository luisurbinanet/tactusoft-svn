package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;

/**
 * CrmProcedureDetail generated by hbm2java
 */
@Entity
@Table(name = "crm_procedure_detail", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CrmProcedureDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmProcedure crmProcedure;
	private String name;
	private Integer timeDoctor;
	private Integer timeNurses;
	private Integer timeStretchers;
	private boolean noRepeat;
	private Short noRepeatDays;
	private String docType;
	private String formulaDocType;
	private String formulaDocTypePs;
	private boolean availability;
	private int minMedication;
	private int maxMedication;
	private boolean caseStudy;
	private String codPublicity;
	private boolean dependent;
	private String typeHistory;
	private Byte evaluation;
	private int state;
	private Set<CrmAppointment> crmAppointments = new HashSet<CrmAppointment>(0);

	public CrmProcedureDetail() {
	}

	public CrmProcedureDetail(BigDecimal id, CrmProcedure crmProcedure,
			String name, int state) {
		this.id = id;
		this.crmProcedure = crmProcedure;
		this.name = name;
		this.state = state;
	}

	public CrmProcedureDetail(BigDecimal id, CrmProcedure crmProcedure,
			String name, Integer timeDoctor, Integer timeNurses,
			Integer timeStretchers, boolean noRepeat, Short noRepeatDays,
			String docType, String formulaDocType, String formulaDocTypePs,
			boolean availability, String codPublicity, boolean dependent,
			String typeHistory, Byte evaluation, int state,
			Set<CrmAppointment> crmAppointments) {
		this.id = id;
		this.crmProcedure = crmProcedure;
		this.name = name;
		this.timeDoctor = timeDoctor;
		this.timeNurses = timeNurses;
		this.timeStretchers = timeStretchers;
		this.noRepeat = noRepeat;
		this.noRepeatDays = noRepeatDays;
		this.availability = availability;
		this.docType = docType;
		this.formulaDocType = formulaDocType;
		this.formulaDocTypePs = formulaDocTypePs;
		this.codPublicity = codPublicity;
		this.dependent = dependent;
		this.typeHistory = typeHistory;
		this.evaluation = evaluation;
		this.state = state;
		this.crmAppointments = crmAppointments;
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
	@JoinColumn(name = "id_procedure", nullable = false)
	public CrmProcedure getCrmProcedure() {
		return this.crmProcedure;
	}

	public void setCrmProcedure(CrmProcedure crmProcedure) {
		this.crmProcedure = crmProcedure;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "time_doctor")
	public Integer getTimeDoctor() {
		return this.timeDoctor;
	}

	public void setTimeDoctor(Integer timeDoctor) {
		this.timeDoctor = timeDoctor;
	}

	@Column(name = "time_nurses")
	public Integer getTimeNurses() {
		return this.timeNurses;
	}

	public void setTimeNurses(Integer timeNurses) {
		this.timeNurses = timeNurses;
	}

	@Column(name = "time_stretchers")
	public Integer getTimeStretchers() {
		return this.timeStretchers;
	}

	public void setTimeStretchers(Integer timeStretchers) {
		this.timeStretchers = timeStretchers;
	}

	@Column(name = "no_repeat")
	public boolean isNoRepeat() {
		return this.noRepeat;
	}

	public void setNoRepeat(boolean noRepeat) {
		this.noRepeat = noRepeat;
	}

	@Column(name = "no_repeat_days")
	public Short getNoRepeatDays() {
		return this.noRepeatDays;
	}

	public void setNoRepeatDays(Short noRepeatDays) {
		this.noRepeatDays = noRepeatDays;
	}

	@Column(name = "doc_type")
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	@Column(name = "formula_doc_type")
	public String getFormulaDocType() {
		return formulaDocType;
	}

	public void setFormulaDocType(String formulaDocType) {
		this.formulaDocType = formulaDocType;
	}

	@Column(name = "formula_doc_type_ps")
	public String getFormulaDocTypePs() {
		return formulaDocTypePs;
	}

	public void setFormulaDocTypePs(String formulaDocTypePs) {
		this.formulaDocTypePs = formulaDocTypePs;
	}

	@Column(name = "availability")
	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	@Column(name = "min_medication")
	public int getMinMedication() {
		return minMedication;
	}

	public void setMinMedication(int minMedication) {
		this.minMedication = minMedication;
	}

	@Column(name = "max_medication")
	public int getMaxMedication() {
		return maxMedication;
	}

	public void setMaxMedication(int maxMedication) {
		this.maxMedication = maxMedication;
	}

	@Column(name = "cod_publicity", length = 4)
	public String getCodPublicity() {
		return this.codPublicity;
	}

	public void setCodPublicity(String codPublicity) {
		this.codPublicity = codPublicity;
	}

	@Column(name = "dependent")
	public boolean isDependent() {
		return dependent;
	}

	public void setDependent(boolean dependent) {
		this.dependent = dependent;
	}

	@Column(name = "case_study")
	public boolean isCaseStudy() {
		return caseStudy;
	}

	public void setCaseStudy(boolean caseStudy) {
		this.caseStudy = caseStudy;
	}

	@Column(name = "type_history", length = 45)
	public String getTypeHistory() {
		return typeHistory;
	}

	public void setTypeHistory(String typeHistory) {
		this.typeHistory = typeHistory;
	}

	@Column(name = "evaluation")
	public Byte getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Byte evaluation) {
		this.evaluation = evaluation;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmProcedureDetail")
	public Set<CrmAppointment> getCrmAppointments() {
		return this.crmAppointments;
	}

	public void setCrmAppointments(Set<CrmAppointment> crmAppointments) {
		this.crmAppointments = crmAppointments;
	}

}
