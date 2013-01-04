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
 * CrmNote generated by hbm2java
 */
@Entity
@Table(name = "crm_note", catalog = "crm_db")
public class CrmNote implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmPatient crmPatient;
	private CrmDoctor crmDoctor;
	private CrmNurse crmNurse;
	private String noteType;
	private String note;
	private Date noteDate;

	public CrmNote() {
	}

	public CrmNote(BigDecimal id, CrmPatient crmPatient, CrmDoctor crmDoctor,
			CrmNurse crmNurse, String noteType, String note) {
		this.id = id;
		this.crmPatient = crmPatient;
		this.crmDoctor = crmDoctor;
		this.crmNurse = crmNurse;
		this.noteType = noteType;
		this.note = note;
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
	@JoinColumn(name = "id_patient", nullable = false)
	public CrmPatient getCrmPatient() {
		return crmPatient;
	}

	public void setCrmPatient(CrmPatient crmPatient) {
		this.crmPatient = crmPatient;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_doctor", nullable = true)
	public CrmDoctor getCrmDoctor() {
		return crmDoctor;
	}

	public void setCrmDoctor(CrmDoctor crmDoctor) {
		this.crmDoctor = crmDoctor;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_nurse", nullable = true)
	public CrmNurse getCrmNurse() {
		return crmNurse;
	}

	public void setCrmNurse(CrmNurse crmNurse) {
		this.crmNurse = crmNurse;
	}

	@Column(name = "note_type", nullable = false, length = 45)
	public String getNoteType() {
		return this.noteType;
	}

	public void setNoteType(String noteType) {
		this.noteType = noteType;
	}

	@Column(name = "note", nullable = false, length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "note_date", length = 10)
	public Date getNoteDate() {
		return noteDate;
	}

	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

}
