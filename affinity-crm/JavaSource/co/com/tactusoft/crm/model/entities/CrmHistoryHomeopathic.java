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
 * CrmHistoryHomeopathic generated by hbm2java
 */
@Entity
@Table(name = "crm_history_homeopathic", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id_patient", "id_appointment" }))
public class CrmHistoryHomeopathic implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmPatient crmPatient;
	private CrmAppointment crmAppointment;
	private String biotypology;
	private String mental;
	private String special;
	private String general;
	private String miasm;

	public CrmHistoryHomeopathic() {
	}

	public CrmHistoryHomeopathic(BigDecimal id, CrmPatient crmPatient) {
		this.id = id;
		this.crmPatient = crmPatient;
	}

	public CrmHistoryHomeopathic(BigDecimal id, CrmPatient crmPatient,
			CrmAppointment crmAppointment, String biotypology, String mental,
			String special, String general, String miasm) {
		this.id = id;
		this.crmPatient = crmPatient;
		this.crmAppointment = crmAppointment;
		this.biotypology = biotypology;
		this.mental = mental;
		this.special = special;
		this.general = general;
		this.miasm = miasm;
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
		return this.crmPatient;
	}

	public void setCrmPatient(CrmPatient crmPatient) {
		this.crmPatient = crmPatient;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appointment", nullable = false)
	public CrmAppointment getCrmAppointment() {
		return crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	@Column(name = "biotypology", length = 45)
	public String getBiotypology() {
		return this.biotypology;
	}

	public void setBiotypology(String biotypology) {
		this.biotypology = biotypology;
	}

	@Column(name = "mental", length = 65535)
	public String getMental() {
		return this.mental;
	}

	public void setMental(String mental) {
		this.mental = mental;
	}

	@Column(name = "special", length = 65535)
	public String getSpecial() {
		return this.special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	@Column(name = "general", length = 65535)
	public String getGeneral() {
		return this.general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}

	@Column(name = "miasm", length = 65535)
	public String getMiasm() {
		return this.miasm;
	}

	public void setMiasm(String miasm) {
		this.miasm = miasm;
	}

}
