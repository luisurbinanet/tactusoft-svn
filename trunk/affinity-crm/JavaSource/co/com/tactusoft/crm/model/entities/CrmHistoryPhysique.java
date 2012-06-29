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
 * CrmHistoryPhysique generated by hbm2java
 */
@Entity
@Table(name = "crm_history_physique", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "id_patient"))
public class CrmHistoryPhysique implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmPatient crmPatient;
	private Integer heartRate;
	private Integer respiratoryRate;
	private BigDecimal height;
	private BigDecimal weight;
	private String bloodPressure;
	private Boolean generalStateCheck;
	private String generalState;
	private Boolean headNeckCheck;
	private String headNeck;
	private Boolean chestCheck;
	private String chest;
	private Boolean lungsCheck;
	private String lungs;
	private Boolean heartCheck;
	private String heart;
	private Boolean abdomenCheck;
	private String abdomen;
	private Boolean genitalsCheck;
	private String genitals;
	private Boolean osteoCheck;
	private String osteo;
	private Boolean tipsCheck;
	private String tips;
	private Boolean highlightsCheck;
	private String highlights;
	private Boolean skinCheck;
	private String skin;
	private String obs;

	public CrmHistoryPhysique() {
	}

	public CrmHistoryPhysique(BigDecimal id, CrmPatient crmPatient) {
		this.id = id;
		this.crmPatient = crmPatient;
	}

	public CrmHistoryPhysique(BigDecimal id, CrmPatient crmPatient,
			Integer heartRate, Integer respiratoryRate, BigDecimal height,
			BigDecimal weight, String bloodPressure, Boolean generalStateCheck,
			String generalState, Boolean headNeckCheck, String headNeck,
			Boolean chestCheck, String chest, Boolean lungsCheck, String lungs,
			Boolean heartCheck, String heart, Boolean abdomenCheck,
			String abdomen, Boolean genitalsCheck, String genitals,
			Boolean osteoCheck, String osteo, Boolean tipsCheck, String tips,
			Boolean highlightsCheck, String highlights, Boolean skinCheck,
			String skin, String obs) {
		this.id = id;
		this.crmPatient = crmPatient;
		this.heartRate = heartRate;
		this.respiratoryRate = respiratoryRate;
		this.height = height;
		this.weight = weight;
		this.bloodPressure = bloodPressure;
		this.generalStateCheck = generalStateCheck;
		this.generalState = generalState;
		this.headNeckCheck = headNeckCheck;
		this.headNeck = headNeck;
		this.chestCheck = chestCheck;
		this.chest = chest;
		this.lungsCheck = lungsCheck;
		this.lungs = lungs;
		this.heartCheck = heartCheck;
		this.heart = heart;
		this.abdomenCheck = abdomenCheck;
		this.abdomen = abdomen;
		this.genitalsCheck = genitalsCheck;
		this.genitals = genitals;
		this.osteoCheck = osteoCheck;
		this.osteo = osteo;
		this.tipsCheck = tipsCheck;
		this.tips = tips;
		this.highlightsCheck = highlightsCheck;
		this.highlights = highlights;
		this.skinCheck = skinCheck;
		this.skin = skin;
		this.obs = obs;
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

	public void setCrmPatient(CrmPatient crmPatient) {
		this.crmPatient = crmPatient;
	}

	@Column(name = "heart_rate")
	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	@Column(name = "respiratory_rate")
	public Integer getRespiratoryRate() {
		return this.respiratoryRate;
	}

	public void setRespiratoryRate(Integer respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	@Column(name = "height", precision = 5)
	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	@Column(name = "weight", precision = 5)
	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	@Column(name = "blood_pressure", length = 7)
	public String getBloodPressure() {
		return this.bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	@Column(name = "general_state_check")
	public Boolean getGeneralStateCheck() {
		return this.generalStateCheck;
	}

	public void setGeneralStateCheck(Boolean generalStateCheck) {
		this.generalStateCheck = generalStateCheck;
	}

	@Column(name = "general_state", length = 65535)
	public String getGeneralState() {
		return this.generalState;
	}

	public void setGeneralState(String generalState) {
		this.generalState = generalState;
	}

	@Column(name = "head_neck_check")
	public Boolean getHeadNeckCheck() {
		return this.headNeckCheck;
	}

	public void setHeadNeckCheck(Boolean headNeckCheck) {
		this.headNeckCheck = headNeckCheck;
	}

	@Column(name = "head_neck", length = 65535)
	public String getHeadNeck() {
		return this.headNeck;
	}

	public void setHeadNeck(String headNeck) {
		this.headNeck = headNeck;
	}

	@Column(name = "chest_check")
	public Boolean getChestCheck() {
		return this.chestCheck;
	}

	public void setChestCheck(Boolean chestCheck) {
		this.chestCheck = chestCheck;
	}

	@Column(name = "chest", length = 65535)
	public String getChest() {
		return this.chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	@Column(name = "lungs_check")
	public Boolean getLungsCheck() {
		return this.lungsCheck;
	}

	public void setLungsCheck(Boolean lungsCheck) {
		this.lungsCheck = lungsCheck;
	}

	@Column(name = "lungs", length = 65535)
	public String getLungs() {
		return this.lungs;
	}

	public void setLungs(String lungs) {
		this.lungs = lungs;
	}

	@Column(name = "heart_check")
	public Boolean getHeartCheck() {
		return this.heartCheck;
	}

	public void setHeartCheck(Boolean heartCheck) {
		this.heartCheck = heartCheck;
	}

	@Column(name = "heart", length = 65535)
	public String getHeart() {
		return this.heart;
	}

	public void setHeart(String heart) {
		this.heart = heart;
	}

	@Column(name = "abdomen_check")
	public Boolean getAbdomenCheck() {
		return this.abdomenCheck;
	}

	public void setAbdomenCheck(Boolean abdomenCheck) {
		this.abdomenCheck = abdomenCheck;
	}

	@Column(name = "abdomen", length = 65535)
	public String getAbdomen() {
		return this.abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}

	@Column(name = "genitals_check")
	public Boolean getGenitalsCheck() {
		return this.genitalsCheck;
	}

	public void setGenitalsCheck(Boolean genitalsCheck) {
		this.genitalsCheck = genitalsCheck;
	}

	@Column(name = "genitals", length = 65535)
	public String getGenitals() {
		return this.genitals;
	}

	public void setGenitals(String genitals) {
		this.genitals = genitals;
	}

	@Column(name = "osteo_check")
	public Boolean getOsteoCheck() {
		return this.osteoCheck;
	}

	public void setOsteoCheck(Boolean osteoCheck) {
		this.osteoCheck = osteoCheck;
	}

	@Column(name = "osteo", length = 65535)
	public String getOsteo() {
		return this.osteo;
	}

	public void setOsteo(String osteo) {
		this.osteo = osteo;
	}

	@Column(name = "tips_check")
	public Boolean getTipsCheck() {
		return this.tipsCheck;
	}

	public void setTipsCheck(Boolean tipsCheck) {
		this.tipsCheck = tipsCheck;
	}

	@Column(name = "tips", length = 65535)
	public String getTips() {
		return this.tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	@Column(name = "highlights_check")
	public Boolean getHighlightsCheck() {
		return this.highlightsCheck;
	}

	public void setHighlightsCheck(Boolean highlightsCheck) {
		this.highlightsCheck = highlightsCheck;
	}

	@Column(name = "highlights", length = 65535)
	public String getHighlights() {
		return this.highlights;
	}

	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}

	@Column(name = "skin_check")
	public Boolean getSkinCheck() {
		return this.skinCheck;
	}

	public void setSkinCheck(Boolean skinCheck) {
		this.skinCheck = skinCheck;
	}

	@Column(name = "skin", length = 65535)
	public String getSkin() {
		return this.skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	@Column(name = "obs", length = 65535)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
