package co.com.tactusoft.crm.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IndPatientAppointment implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private BigDecimal idBranch;
	private String branchName;
	private BigDecimal idPatient;
	private String docPatient;
	private String namePatient;
	private BigDecimal idProcedureDetail;
	private String procedureName;
	private long num;

	public IndPatientAppointment() {
	}

	public IndPatientAppointment(BigDecimal idBranch, BigDecimal idPatient,
			BigDecimal idProcedureDetail, String procedureName, long num) {
		this.idBranch = idBranch;
		this.idPatient = idPatient;
		this.idProcedureDetail = idProcedureDetail;
		this.procedureName = procedureName;
		this.num = num;
	}

	public IndPatientAppointment(BigDecimal idBranch, String branchName,
			BigDecimal idPatient, String docPatient, String namePatient,
			BigDecimal idProcedureDetail, String procedureName, long num) {
		this.idBranch = idBranch;
		this.branchName = branchName;
		this.idPatient = idPatient;
		this.docPatient = docPatient;
		this.namePatient = namePatient;
		this.idProcedureDetail = idProcedureDetail;
		this.procedureName = procedureName;
		this.num = num;
	}

	@Id
	@Column(name = "id")
	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "id_branch")
	public BigDecimal getIdBranch() {
		return this.idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	@Column(name = "branch_name")
	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column(name = "id_patient")
	public BigDecimal getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(BigDecimal idPatient) {
		this.idPatient = idPatient;
	}

	@Column(name = "doc_patient")
	public String getDocPatient() {
		return this.docPatient;
	}

	public void setDocPatient(String docPatient) {
		this.docPatient = docPatient;
	}

	@Column(name = "name_patient")
	public String getNamePatient() {
		return this.namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	@Column(name = "id_procedure_detail")
	public BigDecimal getIdProcedureDetail() {
		return this.idProcedureDetail;
	}

	public void setIdProcedureDetail(BigDecimal idProcedureDetail) {
		this.idProcedureDetail = idProcedureDetail;
	}

	@Column(name = "procedure_name")
	public String getProcedureName() {
		return this.procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}

	@Column(name = "num")
	public long getNum() {
		return this.num;
	}

	public void setNum(long num) {
		this.num = num;
	}

}
