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
 * CrmRole generated by hbm2java
 */
@Entity
@Table(name = "crm_role", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class CrmRole implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmPage crmPage;
	private String name;
	private String description;
	private Boolean openAppointment;
	private Boolean printFormula;
	private Boolean printHistorial;
	private int state;
	private Set<CrmPageRole> crmPageRoles = new HashSet<CrmPageRole>(0);
	private Set<CrmUserRole> crmUserRoles = new HashSet<CrmUserRole>(0);

	public CrmRole() {
	}

	public CrmRole(BigDecimal id, String name, int state) {
		this.id = id;
		this.name = name;
		this.state = state;
	}

	public CrmRole(BigDecimal id, CrmPage crmPage, String name,
			String description, Boolean openAppointment, Boolean printFormula,
			Boolean printHistorial, int state, Set<CrmPageRole> crmPageRoles,
			Set<CrmUserRole> crmUserRoles) {
		this.id = id;
		this.crmPage = crmPage;
		this.name = name;
		this.description = description;
		this.openAppointment = openAppointment;
		this.printFormula = printFormula;
		this.printHistorial = printHistorial;
		this.state = state;
		this.crmPageRoles = crmPageRoles;
		this.crmUserRoles = crmUserRoles;
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
	@JoinColumn(name = "id_page", nullable = false)
	public CrmPage getCrmPage() {
		return this.crmPage;
	}

	public void setCrmPage(CrmPage crmPage) {
		this.crmPage = crmPage;
	}

	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "open_appointment")
	public Boolean getOpenAppointment() {
		return openAppointment;
	}

	public void setOpenAppointment(Boolean openAppointment) {
		this.openAppointment = openAppointment;
	}

	@Column(name = "print_formula")
	public Boolean getPrintFormula() {
		return printFormula;
	}

	public void setPrintFormula(Boolean printFormula) {
		this.printFormula = printFormula;
	}

	@Column(name = "print_historial")
	public Boolean getPrintHistorial() {
		return printHistorial;
	}

	public void setPrintHistorial(Boolean printHistorial) {
		this.printHistorial = printHistorial;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmRole")
	public Set<CrmPageRole> getCrmPageRoles() {
		return this.crmPageRoles;
	}

	public void setCrmPageRoles(Set<CrmPageRole> crmPageRoles) {
		this.crmPageRoles = crmPageRoles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crmRole")
	public Set<CrmUserRole> getCrmUserRoles() {
		return this.crmUserRoles;
	}

	public void setCrmUserRoles(Set<CrmUserRole> crmUserRoles) {
		this.crmUserRoles = crmUserRoles;
	}

}
