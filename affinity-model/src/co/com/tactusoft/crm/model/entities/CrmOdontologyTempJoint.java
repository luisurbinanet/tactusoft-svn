package co.com.tactusoft.crm.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CrmOdontologyTempJoint generated by hbm2java
 */
@Entity
@Table(name = "crm_odontology_temp_joint", catalog = "crm_db")
public class CrmOdontologyTempJoint implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private CrmAppointment crmAppointment;
	private Integer openingNoise;
	private Integer closureNoise;
	private Integer lateralityNoise;
	private Integer openingDeviaton;
	private Integer closureDeviaton;
	private Integer lateralityDeviaton;
	private Integer openingPain;
	private Integer closurePain;
	private Integer lateralityPain;
	private Integer openingFatigue;
	private Integer closureFatigue;
	private Integer lateralityFatigue;
	private String obs;

	public CrmOdontologyTempJoint() {
	}

	public CrmOdontologyTempJoint(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	public CrmOdontologyTempJoint(CrmAppointment crmAppointment,
			Integer openingNoise, Integer closureNoise, Integer lateralityNoise,
			Integer openingDeviaton, Integer closureDeviaton,
			Integer lateralityDeviaton, Integer openingPain,
			Integer closurePain, Integer lateralityPain,
			Integer openingFatigue, Integer closureFatigue,
			Integer lateralityFatigue, String obs) {
		this.crmAppointment = crmAppointment;
		this.openingNoise = openingNoise;
		this.closureNoise = closureNoise;
		this.lateralityNoise = lateralityNoise;
		this.openingDeviaton = openingDeviaton;
		this.closureDeviaton = closureDeviaton;
		this.lateralityDeviaton = lateralityDeviaton;
		this.openingPain = openingPain;
		this.closurePain = closurePain;
		this.lateralityPain = lateralityPain;
		this.openingFatigue = openingFatigue;
		this.closureFatigue = closureFatigue;
		this.lateralityFatigue = lateralityFatigue;
		this.obs = obs;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_appointment", nullable = false)
	public CrmAppointment getCrmAppointment() {
		return this.crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	@Column(name = "opening_noise")
	public Integer getOpeningNoise() {
		return this.openingNoise;
	}

	public void setOpeningNoise(Integer openingNoise) {
		this.openingNoise = openingNoise;
	}

	@Column(name = "closure_noise")
	public Integer getClosureNoise() {
		return this.closureNoise;
	}

	public void setClosureNoise(Integer closureNoise) {
		this.closureNoise = closureNoise;
	}

	@Column(name = "laterality_noise")
	public Integer getLateralityNoise() {
		return this.lateralityNoise;
	}

	public void setLateralityNoise(Integer lateralityNoise) {
		this.lateralityNoise = lateralityNoise;
	}

	@Column(name = "opening_deviaton")
	public Integer getOpeningDeviaton() {
		return this.openingDeviaton;
	}

	public void setOpeningDeviaton(Integer openingDeviaton) {
		this.openingDeviaton = openingDeviaton;
	}

	@Column(name = "closure_deviaton")
	public Integer getClosureDeviaton() {
		return this.closureDeviaton;
	}

	public void setClosureDeviaton(Integer closureDeviaton) {
		this.closureDeviaton = closureDeviaton;
	}

	@Column(name = "laterality_deviaton")
	public Integer getLateralityDeviaton() {
		return this.lateralityDeviaton;
	}

	public void setLateralityDeviaton(Integer lateralityDeviaton) {
		this.lateralityDeviaton = lateralityDeviaton;
	}

	@Column(name = "opening_pain")
	public Integer getOpeningPain() {
		return this.openingPain;
	}

	public void setOpeningPain(Integer openingPain) {
		this.openingPain = openingPain;
	}

	@Column(name = "closure_pain")
	public Integer getClosurePain() {
		return this.closurePain;
	}

	public void setClosurePain(Integer closurePain) {
		this.closurePain = closurePain;
	}

	@Column(name = "laterality_pain")
	public Integer getLateralityPain() {
		return this.lateralityPain;
	}

	public void setLateralityPain(Integer lateralityPain) {
		this.lateralityPain = lateralityPain;
	}

	@Column(name = "opening_fatigue")
	public Integer getOpeningFatigue() {
		return this.openingFatigue;
	}

	public void setOpeningFatigue(Integer openingFatigue) {
		this.openingFatigue = openingFatigue;
	}

	@Column(name = "closure_fatigue")
	public Integer getClosureFatigue() {
		return this.closureFatigue;
	}

	public void setClosureFatigue(Integer closureFatigue) {
		this.closureFatigue = closureFatigue;
	}

	@Column(name = "laterality_fatigue")
	public Integer getLateralityFatigue() {
		return this.lateralityFatigue;
	}

	public void setLateralityFatigue(Integer lateralityFatigue) {
		this.lateralityFatigue = lateralityFatigue;
	}

	@Column(name = "obs", length = 65535)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}