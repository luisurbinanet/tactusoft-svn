package co.com.tactusoft.crm.model.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * CrmHistoryHistory generated by hbm2java
 */
@Entity
@Table(name = "crm_history_history", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_patient", "id_appointment" }))
public class CrmHistoryHistory implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmPatient crmPatient;
	private CrmAppointment crmAppointment;
	private String reason;
	private String disease;
	private String results;
	private String head;
	private String orl;
	private String cr;
	private String gi;
	private String neuromuscular;
	private String gu;
	private String psychiatric;
	private String skin;

	public CrmHistoryHistory() {
	}

	public CrmHistoryHistory(BigDecimal id, CrmPatient crmPatient) {
		this.id = id;
		this.crmPatient = crmPatient;
	}

	public CrmHistoryHistory(BigDecimal id, CrmPatient crmPatient,
			CrmAppointment crmAppointment, String reason, String disease,
			String results, String head, String orl, String cr, String gi,
			String neuromuscular, String gu, String psychiatric, String skin) {
		this.id = id;
		this.crmPatient = crmPatient;
		this.crmAppointment = crmAppointment;
		this.reason = reason;
		this.disease = disease;
		this.results = results;
		this.head = head;
		this.orl = orl;
		this.cr = cr;
		this.gi = gi;
		this.neuromuscular = neuromuscular;
		this.gu = gu;
		this.psychiatric = psychiatric;
		this.skin = skin;
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
	@JoinColumn(name = "id_patient", unique = true, nullable = false)
	public CrmPatient getCrmPatient() {
		return this.crmPatient;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appointment", unique = true, nullable = false)
	public CrmAppointment getCrmAppointment() {
		return crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	public void setCrmPatient(CrmPatient crmPatient) {
		this.crmPatient = crmPatient;
	}

	@Column(name = "reason", length = 65535)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "disease", length = 65535)
	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Column(name = "results", length = 65535)
	public String getResults() {
		return this.results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	@Column(name = "head", length = 65535)
	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	@Column(name = "orl", length = 65535)
	public String getOrl() {
		return this.orl;
	}

	public void setOrl(String orl) {
		this.orl = orl;
	}

	@Column(name = "cr", length = 65535)
	public String getCr() {
		return this.cr;
	}

	public void setCr(String cr) {
		this.cr = cr;
	}

	@Column(name = "gi", length = 65535)
	public String getGi() {
		return this.gi;
	}

	public void setGi(String gi) {
		this.gi = gi;
	}

	@Column(name = "neuromuscular", length = 65535)
	public String getNeuromuscular() {
		return this.neuromuscular;
	}

	public void setNeuromuscular(String neuromuscular) {
		this.neuromuscular = neuromuscular;
	}

	@Column(name = "gu", length = 65535)
	public String getGu() {
		return this.gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}

	@Column(name = "psychiatric", length = 65535)
	public String getPsychiatric() {
		return this.psychiatric;
	}

	public void setPsychiatric(String psychiatric) {
		this.psychiatric = psychiatric;
	}

	@Column(name = "skin", length = 65535)
	public String getSkin() {
		return this.skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

}
