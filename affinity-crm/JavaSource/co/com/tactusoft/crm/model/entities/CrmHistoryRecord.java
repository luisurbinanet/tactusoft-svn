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
import javax.persistence.UniqueConstraint;

/**
 * CrmHistoryRecord generated by hbm2java
 */
@Entity
@Table(name = "crm_history_record", catalog = "crm_db", uniqueConstraints = @UniqueConstraint(columnNames = "id_patient"))
public class CrmHistoryRecord implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private CrmPatient crmPatient;
	private Boolean arthritis;
	private String arthritisTime;
	private String arthritisMedication;
	private Boolean cancer;
	private String cancerTime;
	private String cancerMedication;
	private Boolean pulmonary;
	private String pulmonaryTime;
	private String pulmonaryMedication;
	private Boolean diabetes;
	private String diabetesTime;
	private String diabetesMedication;
	private Boolean hypertension;
	private String hypertensionTime;
	private String hypertensionMedication;
	private Boolean hospitalizations;
	private String hospitalizationsTime;
	private String hospitalizationsMedication;
	private Boolean allergy;
	private String allergyTime;
	private String allergyMedication;
	private Boolean infections;
	private String infectionsTime;
	private String infectionsMedication;
	private String occupational;
	private String toxic;
	private String bloodType;
	private String pregnancy;
	private String parity;
	private String abortions;
	private String familyHistory;
	private String stillbirths;
	private String caesarean;
	private String menarche;
	private String sexarca;
	private Date fur;
	private String bleeding;
	private Date fuc;
	private Date fuep;
	private String psa;
	private String psaDate;
	private String neonatal;
	private String perinatal;
	private String vaccination;
	private String growth;
	private String hypertensionParent;
	private String epocParent;
	private String heartDiseaseParent;
	private String asthmaParent;
	private String acvParent;
	private String cancerParent;
	private String diabetesParent;

	public CrmHistoryRecord() {
	}

	public CrmHistoryRecord(BigDecimal id, CrmPatient crmPatient) {
		this.id = id;
		this.crmPatient = crmPatient;
	}

	public CrmHistoryRecord(BigDecimal id, CrmPatient crmPatient,
			Boolean arthritis, String arthritisTime, Boolean cancer,
			String cancerTime, String cancerMedication, Boolean pulmonary,
			String pulmonaryTime, String pulmonaryMedication, Boolean diabetes,
			String diabetesTime, String diabetesMedication,
			Boolean hypertension, String hypertensionTime,
			String hypertensionMedication, Boolean hospitalizations,
			String hospitalizationsTime, String hospitalizationsMedication,
			Boolean allergy, String allergyTime, String allergyMedication,
			Boolean infections, String infectionsTime,
			String infectionsMedication, String arthritisMedication,
			String occupational, String toxic, String bloodType,
			String pregnancy, String parity, String abortions,
			String familyHistory, String stillbirths, String caesarean,
			String menarche, String sexarca, Date fur, String bleeding,
			Date fuc, Date fuep, String psa, String psaDate, String neonatal,
			String perinatal, String vaccination, String growth,
			String hypertensionParent, String epocParent,
			String heartDiseaseParent, String asthmaParent, String acvParent,
			String cancerParent, String diabetesParent) {
		this.id = id;
		this.crmPatient = crmPatient;
		this.arthritis = arthritis;
		this.arthritisTime = arthritisTime;
		this.cancer = cancer;
		this.cancerTime = cancerTime;
		this.cancerMedication = cancerMedication;
		this.pulmonary = pulmonary;
		this.pulmonaryTime = pulmonaryTime;
		this.pulmonaryMedication = pulmonaryMedication;
		this.diabetes = diabetes;
		this.diabetesTime = diabetesTime;
		this.diabetesMedication = diabetesMedication;
		this.hypertension = hypertension;
		this.hypertensionTime = hypertensionTime;
		this.hypertensionMedication = hypertensionMedication;
		this.hospitalizations = hospitalizations;
		this.hospitalizationsTime = hospitalizationsTime;
		this.hospitalizationsMedication = hospitalizationsMedication;
		this.allergy = allergy;
		this.allergyTime = allergyTime;
		this.allergyMedication = allergyMedication;
		this.infections = infections;
		this.infectionsTime = infectionsTime;
		this.infectionsMedication = infectionsMedication;
		this.arthritisMedication = arthritisMedication;
		this.occupational = occupational;
		this.toxic = toxic;
		this.bloodType = bloodType;
		this.pregnancy = pregnancy;
		this.parity = parity;
		this.abortions = abortions;
		this.familyHistory = familyHistory;
		this.stillbirths = stillbirths;
		this.caesarean = caesarean;
		this.menarche = menarche;
		this.sexarca = sexarca;
		this.fur = fur;
		this.bleeding = bleeding;
		this.fuc = fuc;
		this.fuep = fuep;
		this.psa = psa;
		this.psaDate = psaDate;
		this.neonatal = neonatal;
		this.perinatal = perinatal;
		this.vaccination = vaccination;
		this.growth = growth;
		this.hypertensionParent = hypertensionParent;
		this.epocParent = epocParent;
		this.heartDiseaseParent = heartDiseaseParent;
		this.asthmaParent = asthmaParent;
		this.acvParent = acvParent;
		this.cancerParent = cancerParent;
		this.diabetesParent = diabetesParent;
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

	@Column(name = "arthritis")
	public Boolean getArthritis() {
		return this.arthritis;
	}

	public void setArthritis(Boolean arthritis) {
		this.arthritis = arthritis;
	}

	@Column(name = "arthritis_time", length = 45)
	public String getArthritisTime() {
		return this.arthritisTime;
	}

	public void setArthritisTime(String arthritisTime) {
		this.arthritisTime = arthritisTime;
	}

	@Column(name = "cancer")
	public Boolean getCancer() {
		return this.cancer;
	}

	public void setCancer(Boolean cancer) {
		this.cancer = cancer;
	}

	@Column(name = "cancer_time", length = 45)
	public String getCancerTime() {
		return this.cancerTime;
	}

	public void setCancerTime(String cancerTime) {
		this.cancerTime = cancerTime;
	}

	@Column(name = "cancer_medication", length = 65535)
	public String getCancerMedication() {
		return this.cancerMedication;
	}

	public void setCancerMedication(String cancerMedication) {
		this.cancerMedication = cancerMedication;
	}

	@Column(name = "pulmonary")
	public Boolean getPulmonary() {
		return this.pulmonary;
	}

	public void setPulmonary(Boolean pulmonary) {
		this.pulmonary = pulmonary;
	}

	@Column(name = "pulmonary_time", length = 45)
	public String getPulmonaryTime() {
		return this.pulmonaryTime;
	}

	public void setPulmonaryTime(String pulmonaryTime) {
		this.pulmonaryTime = pulmonaryTime;
	}

	@Column(name = "pulmonary_medication", length = 65535)
	public String getPulmonaryMedication() {
		return this.pulmonaryMedication;
	}

	public void setPulmonaryMedication(String pulmonaryMedication) {
		this.pulmonaryMedication = pulmonaryMedication;
	}

	@Column(name = "diabetes")
	public Boolean getDiabetes() {
		return this.diabetes;
	}

	public void setDiabetes(Boolean diabetes) {
		this.diabetes = diabetes;
	}

	@Column(name = "diabetes_time", length = 45)
	public String getDiabetesTime() {
		return this.diabetesTime;
	}

	public void setDiabetesTime(String diabetesTime) {
		this.diabetesTime = diabetesTime;
	}

	@Column(name = "diabetes_medication", length = 65535)
	public String getDiabetesMedication() {
		return this.diabetesMedication;
	}

	public void setDiabetesMedication(String diabetesMedication) {
		this.diabetesMedication = diabetesMedication;
	}

	@Column(name = "hypertension")
	public Boolean getHypertension() {
		return this.hypertension;
	}

	public void setHypertension(Boolean hypertension) {
		this.hypertension = hypertension;
	}

	@Column(name = "hypertension_time", length = 45)
	public String getHypertensionTime() {
		return this.hypertensionTime;
	}

	public void setHypertensionTime(String hypertensionTime) {
		this.hypertensionTime = hypertensionTime;
	}

	@Column(name = "hypertension_medication", length = 65535)
	public String getHypertensionMedication() {
		return this.hypertensionMedication;
	}

	public void setHypertensionMedication(String hypertensionMedication) {
		this.hypertensionMedication = hypertensionMedication;
	}

	@Column(name = "hospitalizations")
	public Boolean getHospitalizations() {
		return this.hospitalizations;
	}

	public void setHospitalizations(Boolean hospitalizations) {
		this.hospitalizations = hospitalizations;
	}

	@Column(name = "hospitalizations_time", length = 45)
	public String getHospitalizationsTime() {
		return this.hospitalizationsTime;
	}

	public void setHospitalizationsTime(String hospitalizationsTime) {
		this.hospitalizationsTime = hospitalizationsTime;
	}

	@Column(name = "hospitalizations_medication", length = 65535)
	public String getHospitalizationsMedication() {
		return this.hospitalizationsMedication;
	}

	public void setHospitalizationsMedication(String hospitalizationsMedication) {
		this.hospitalizationsMedication = hospitalizationsMedication;
	}

	@Column(name = "allergy")
	public Boolean getAllergy() {
		return this.allergy;
	}

	public void setAllergy(Boolean allergy) {
		this.allergy = allergy;
	}

	@Column(name = "allergy_time", length = 45)
	public String getAllergyTime() {
		return this.allergyTime;
	}

	public void setAllergyTime(String allergyTime) {
		this.allergyTime = allergyTime;
	}

	@Column(name = "allergy_medication", length = 65535)
	public String getAllergyMedication() {
		return this.allergyMedication;
	}

	public void setAllergyMedication(String allergyMedication) {
		this.allergyMedication = allergyMedication;
	}

	@Column(name = "infections")
	public Boolean getInfections() {
		return this.infections;
	}

	public void setInfections(Boolean infections) {
		this.infections = infections;
	}

	@Column(name = "infections_time", length = 45)
	public String getInfectionsTime() {
		return this.infectionsTime;
	}

	public void setInfectionsTime(String infectionsTime) {
		this.infectionsTime = infectionsTime;
	}

	@Column(name = "infections_medication", length = 65535)
	public String getInfectionsMedication() {
		return this.infectionsMedication;
	}

	public void setInfectionsMedication(String infectionsMedication) {
		this.infectionsMedication = infectionsMedication;
	}

	@Column(name = "arthritis_medication", length = 65535)
	public String getArthritisMedication() {
		return this.arthritisMedication;
	}

	public void setArthritisMedication(String arthritisMedication) {
		this.arthritisMedication = arthritisMedication;
	}

	@Column(name = "occupational", length = 65535)
	public String getOccupational() {
		return this.occupational;
	}

	public void setOccupational(String occupational) {
		this.occupational = occupational;
	}

	@Column(name = "toxic", length = 65535)
	public String getToxic() {
		return this.toxic;
	}

	public void setToxic(String toxic) {
		this.toxic = toxic;
	}

	@Column(name = "blood_type", length = 65535)
	public String getBloodType() {
		return this.bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Column(name = "pregnancy", length = 45)
	public String getPregnancy() {
		return this.pregnancy;
	}

	public void setPregnancy(String pregnancy) {
		this.pregnancy = pregnancy;
	}

	@Column(name = "parity", length = 45)
	public String getParity() {
		return this.parity;
	}

	public void setParity(String parity) {
		this.parity = parity;
	}

	@Column(name = "abortions", length = 45)
	public String getAbortions() {
		return this.abortions;
	}

	public void setAbortions(String abortions) {
		this.abortions = abortions;
	}

	@Column(name = "family_history", length = 45)
	public String getFamilyHistory() {
		return this.familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	@Column(name = "stillbirths", length = 45)
	public String getStillbirths() {
		return this.stillbirths;
	}

	public void setStillbirths(String stillbirths) {
		this.stillbirths = stillbirths;
	}

	@Column(name = "caesarean", length = 45)
	public String getCaesarean() {
		return this.caesarean;
	}

	public void setCaesarean(String caesarean) {
		this.caesarean = caesarean;
	}

	@Column(name = "menarche", length = 45)
	public String getMenarche() {
		return this.menarche;
	}

	public void setMenarche(String menarche) {
		this.menarche = menarche;
	}

	@Column(name = "sexarca", length = 45)
	public String getSexarca() {
		return this.sexarca;
	}

	public void setSexarca(String sexarca) {
		this.sexarca = sexarca;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fur", length = 10)
	public Date getFur() {
		return this.fur;
	}

	public void setFur(Date fur) {
		this.fur = fur;
	}

	@Column(name = "bleeding", length = 1000)
	public String getBleeding() {
		return this.bleeding;
	}

	public void setBleeding(String bleeding) {
		this.bleeding = bleeding;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fuc", length = 10)
	public Date getFuc() {
		return this.fuc;
	}

	public void setFuc(Date fuc) {
		this.fuc = fuc;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fuep", length = 10)
	public Date getFuep() {
		return this.fuep;
	}

	public void setFuep(Date fuep) {
		this.fuep = fuep;
	}

	@Column(name = "psa", length = 45)
	public String getPsa() {
		return this.psa;
	}

	public void setPsa(String psa) {
		this.psa = psa;
	}

	@Column(name = "psa_date", length = 45)
	public String getPsaDate() {
		return this.psaDate;
	}

	public void setPsaDate(String psaDate) {
		this.psaDate = psaDate;
	}

	@Column(name = "neonatal", length = 65535)
	public String getNeonatal() {
		return this.neonatal;
	}

	public void setNeonatal(String neonatal) {
		this.neonatal = neonatal;
	}

	@Column(name = "perinatal", length = 65535)
	public String getPerinatal() {
		return this.perinatal;
	}

	public void setPerinatal(String perinatal) {
		this.perinatal = perinatal;
	}

	@Column(name = "vaccination", length = 65535)
	public String getVaccination() {
		return this.vaccination;
	}

	public void setVaccination(String vaccination) {
		this.vaccination = vaccination;
	}

	@Column(name = "growth", length = 65535)
	public String getGrowth() {
		return this.growth;
	}

	public void setGrowth(String growth) {
		this.growth = growth;
	}

	@Column(name = "hypertension_parent", length = 65535)
	public String getHypertensionParent() {
		return this.hypertensionParent;
	}

	public void setHypertensionParent(String hypertensionParent) {
		this.hypertensionParent = hypertensionParent;
	}

	@Column(name = "epoc_parent", length = 65535)
	public String getEpocParent() {
		return this.epocParent;
	}

	public void setEpocParent(String epocParent) {
		this.epocParent = epocParent;
	}

	@Column(name = "heart_disease_parent", length = 65535)
	public String getHeartDiseaseParent() {
		return this.heartDiseaseParent;
	}

	public void setHeartDiseaseParent(String heartDiseaseParent) {
		this.heartDiseaseParent = heartDiseaseParent;
	}

	@Column(name = "asthma_parent", length = 65535)
	public String getAsthmaParent() {
		return this.asthmaParent;
	}

	public void setAsthmaParent(String asthmaParent) {
		this.asthmaParent = asthmaParent;
	}

	@Column(name = "acv_parent", length = 65535)
	public String getAcvParent() {
		return this.acvParent;
	}

	public void setAcvParent(String acvParent) {
		this.acvParent = acvParent;
	}

	@Column(name = "cancer_parent", length = 65535)
	public String getCancerParent() {
		return this.cancerParent;
	}

	public void setCancerParent(String cancerParent) {
		this.cancerParent = cancerParent;
	}

	@Column(name = "diabetes_parent", length = 65535)
	public String getDiabetesParent() {
		return this.diabetesParent;
	}

	public void setDiabetesParent(String diabetesParent) {
		this.diabetesParent = diabetesParent;
	}

}
