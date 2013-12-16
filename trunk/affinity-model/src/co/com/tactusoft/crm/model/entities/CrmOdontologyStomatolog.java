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
 * CrmOdontologyStomatolog generated by hbm2java
 */
@Entity
@Table(name = "crm_odontology_stomatolog", catalog = "crm_db")
public class CrmOdontologyStomatolog implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private CrmAppointment crmAppointment;
	private Boolean exostosisHead;
	private Boolean endostosisHead;
	private Boolean dolichocephalicFace;
	private Boolean mesocephalicFace;
	private Boolean brachycephalicFace;
	private Boolean normalSkin;
	private Boolean paleSkin;
	private Boolean cyanoticSkin;
	private Boolean redSkin;
	private Boolean transverseFace;
	private Boolean longitudinalFace;
	private Boolean concaveSideFace;
	private Boolean convexSideFace;
	private Boolean hypotonicMuscles;
	private Boolean hypertonicMuscles;
	private Boolean lymphNodeChain;
	private String othres;
	private String obs;

	public CrmOdontologyStomatolog() {
	}

	public CrmOdontologyStomatolog(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	public CrmOdontologyStomatolog(CrmAppointment crmAppointment,
			Boolean exostosisHead, Boolean endostosisHead,
			Boolean dolichocephalicFace, Boolean mesocephalicFace,
			Boolean brachycephalicFace, Boolean normalSkin, Boolean paleSkin,
			Boolean cyanoticSkin, Boolean redSkin, Boolean transverseFace,
			Boolean longitudinalFace, Boolean concaveSideFace,
			Boolean convexSideFace, Boolean hypotonicMuscles,
			Boolean hypertonicMuscles, Boolean lymphNodeChain, String othres,
			String obs) {
		this.crmAppointment = crmAppointment;
		this.exostosisHead = exostosisHead;
		this.endostosisHead = endostosisHead;
		this.dolichocephalicFace = dolichocephalicFace;
		this.mesocephalicFace = mesocephalicFace;
		this.brachycephalicFace = brachycephalicFace;
		this.normalSkin = normalSkin;
		this.paleSkin = paleSkin;
		this.cyanoticSkin = cyanoticSkin;
		this.redSkin = redSkin;
		this.transverseFace = transverseFace;
		this.longitudinalFace = longitudinalFace;
		this.concaveSideFace = concaveSideFace;
		this.convexSideFace = convexSideFace;
		this.hypotonicMuscles = hypotonicMuscles;
		this.hypertonicMuscles = hypertonicMuscles;
		this.lymphNodeChain = lymphNodeChain;
		this.othres = othres;
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

	@Column(name = "exostosis_head")
	public Boolean getExostosisHead() {
		return this.exostosisHead;
	}

	public void setExostosisHead(Boolean exostosisHead) {
		this.exostosisHead = exostosisHead;
	}

	@Column(name = "endostosis_head")
	public Boolean getEndostosisHead() {
		return this.endostosisHead;
	}

	public void setEndostosisHead(Boolean endostosisHead) {
		this.endostosisHead = endostosisHead;
	}

	@Column(name = "dolichocephalic_face")
	public Boolean getDolichocephalicFace() {
		return this.dolichocephalicFace;
	}

	public void setDolichocephalicFace(Boolean dolichocephalicFace) {
		this.dolichocephalicFace = dolichocephalicFace;
	}

	@Column(name = "mesocephalic_face")
	public Boolean getMesocephalicFace() {
		return this.mesocephalicFace;
	}

	public void setMesocephalicFace(Boolean mesocephalicFace) {
		this.mesocephalicFace = mesocephalicFace;
	}

	@Column(name = "brachycephalic_face")
	public Boolean getBrachycephalicFace() {
		return this.brachycephalicFace;
	}

	public void setBrachycephalicFace(Boolean brachycephalicFace) {
		this.brachycephalicFace = brachycephalicFace;
	}

	@Column(name = "normal_skin")
	public Boolean getNormalSkin() {
		return this.normalSkin;
	}

	public void setNormalSkin(Boolean normalSkin) {
		this.normalSkin = normalSkin;
	}

	@Column(name = "pale_skin")
	public Boolean getPaleSkin() {
		return this.paleSkin;
	}

	public void setPaleSkin(Boolean paleSkin) {
		this.paleSkin = paleSkin;
	}

	@Column(name = "cyanotic_skin")
	public Boolean getCyanoticSkin() {
		return this.cyanoticSkin;
	}

	public void setCyanoticSkin(Boolean cyanoticSkin) {
		this.cyanoticSkin = cyanoticSkin;
	}

	@Column(name = "red_skin")
	public Boolean getRedSkin() {
		return this.redSkin;
	}

	public void setRedSkin(Boolean redSkin) {
		this.redSkin = redSkin;
	}

	@Column(name = "transverse_face")
	public Boolean getTransverseFace() {
		return this.transverseFace;
	}

	public void setTransverseFace(Boolean transverseFace) {
		this.transverseFace = transverseFace;
	}

	@Column(name = "longitudinal_face")
	public Boolean getLongitudinalFace() {
		return this.longitudinalFace;
	}

	public void setLongitudinalFace(Boolean longitudinalFace) {
		this.longitudinalFace = longitudinalFace;
	}

	@Column(name = "concave_side_face")
	public Boolean getConcaveSideFace() {
		return this.concaveSideFace;
	}

	public void setConcaveSideFace(Boolean concaveSideFace) {
		this.concaveSideFace = concaveSideFace;
	}

	@Column(name = "convex_side_face")
	public Boolean getConvexSideFace() {
		return this.convexSideFace;
	}

	public void setConvexSideFace(Boolean convexSideFace) {
		this.convexSideFace = convexSideFace;
	}

	@Column(name = "hypotonic_muscles")
	public Boolean getHypotonicMuscles() {
		return this.hypotonicMuscles;
	}

	public void setHypotonicMuscles(Boolean hypotonicMuscles) {
		this.hypotonicMuscles = hypotonicMuscles;
	}

	@Column(name = "hypertonic_muscles")
	public Boolean getHypertonicMuscles() {
		return this.hypertonicMuscles;
	}

	public void setHypertonicMuscles(Boolean hypertonicMuscles) {
		this.hypertonicMuscles = hypertonicMuscles;
	}

	@Column(name = "lymph_node_chain")
	public Boolean getLymphNodeChain() {
		return this.lymphNodeChain;
	}

	public void setLymphNodeChain(Boolean lymphNodeChain) {
		this.lymphNodeChain = lymphNodeChain;
	}

	@Column(name = "othres", length = 65535)
	public String getOthres() {
		return this.othres;
	}

	public void setOthres(String othres) {
		this.othres = othres;
	}

	@Column(name = "obs", length = 65535)
	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
