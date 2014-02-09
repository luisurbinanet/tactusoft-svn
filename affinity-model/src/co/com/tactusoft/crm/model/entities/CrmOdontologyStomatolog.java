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
	private Integer exostosisHead;
	private Integer endostosisHead;
	private Integer dolichocephalicFace;
	private Integer mesocephalicFace;
	private Integer brachycephalicFace;
	private Integer normalSkin;
	private Integer paleSkin;
	private Integer cyanoticSkin;
	private Integer redSkin;
	private Integer transverseFace;
	private Integer longitudinalFace;
	private Integer concaveSideFace;
	private Integer convexSideFace;
	private Integer hypotonicMuscles;
	private Integer hypertonicMuscles;
	private Integer lymphNodeChain;
	private String othres;
	private String obs;

	public CrmOdontologyStomatolog() {
	}

	public CrmOdontologyStomatolog(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	public CrmOdontologyStomatolog(CrmAppointment crmAppointment,
			Integer exostosisHead, Integer endostosisHead,
			Integer dolichocephalicFace, Integer mesocephalicFace,
			Integer brachycephalicFace, Integer normalSkin, Integer paleSkin,
			Integer cyanoticSkin, Integer redSkin, Integer transverseFace,
			Integer longitudinalFace, Integer concaveSideFace,
			Integer convexSideFace, Integer hypotonicMuscles,
			Integer hypertonicMuscles, Integer lymphNodeChain, String othres,
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appointment", nullable = false)
	public CrmAppointment getCrmAppointment() {
		return this.crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	@Column(name = "exostosis_head")
	public Integer getExostosisHead() {
		return this.exostosisHead;
	}

	public void setExostosisHead(Integer exostosisHead) {
		this.exostosisHead = exostosisHead;
	}

	@Column(name = "endostosis_head")
	public Integer getEndostosisHead() {
		return this.endostosisHead;
	}

	public void setEndostosisHead(Integer endostosisHead) {
		this.endostosisHead = endostosisHead;
	}

	@Column(name = "dolichocephalic_face")
	public Integer getDolichocephalicFace() {
		return this.dolichocephalicFace;
	}

	public void setDolichocephalicFace(Integer dolichocephalicFace) {
		this.dolichocephalicFace = dolichocephalicFace;
	}

	@Column(name = "mesocephalic_face")
	public Integer getMesocephalicFace() {
		return this.mesocephalicFace;
	}

	public void setMesocephalicFace(Integer mesocephalicFace) {
		this.mesocephalicFace = mesocephalicFace;
	}

	@Column(name = "brachycephalic_face")
	public Integer getBrachycephalicFace() {
		return this.brachycephalicFace;
	}

	public void setBrachycephalicFace(Integer brachycephalicFace) {
		this.brachycephalicFace = brachycephalicFace;
	}

	@Column(name = "normal_skin")
	public Integer getNormalSkin() {
		return this.normalSkin;
	}

	public void setNormalSkin(Integer normalSkin) {
		this.normalSkin = normalSkin;
	}

	@Column(name = "pale_skin")
	public Integer getPaleSkin() {
		return this.paleSkin;
	}

	public void setPaleSkin(Integer paleSkin) {
		this.paleSkin = paleSkin;
	}

	@Column(name = "cyanotic_skin")
	public Integer getCyanoticSkin() {
		return this.cyanoticSkin;
	}

	public void setCyanoticSkin(Integer cyanoticSkin) {
		this.cyanoticSkin = cyanoticSkin;
	}

	@Column(name = "red_skin")
	public Integer getRedSkin() {
		return this.redSkin;
	}

	public void setRedSkin(Integer redSkin) {
		this.redSkin = redSkin;
	}

	@Column(name = "transverse_face")
	public Integer getTransverseFace() {
		return this.transverseFace;
	}

	public void setTransverseFace(Integer transverseFace) {
		this.transverseFace = transverseFace;
	}

	@Column(name = "longitudinal_face")
	public Integer getLongitudinalFace() {
		return this.longitudinalFace;
	}

	public void setLongitudinalFace(Integer longitudinalFace) {
		this.longitudinalFace = longitudinalFace;
	}

	@Column(name = "concave_side_face")
	public Integer getConcaveSideFace() {
		return this.concaveSideFace;
	}

	public void setConcaveSideFace(Integer concaveSideFace) {
		this.concaveSideFace = concaveSideFace;
	}

	@Column(name = "convex_side_face")
	public Integer getConvexSideFace() {
		return this.convexSideFace;
	}

	public void setConvexSideFace(Integer convexSideFace) {
		this.convexSideFace = convexSideFace;
	}

	@Column(name = "hypotonic_muscles")
	public Integer getHypotonicMuscles() {
		return this.hypotonicMuscles;
	}

	public void setHypotonicMuscles(Integer hypotonicMuscles) {
		this.hypotonicMuscles = hypotonicMuscles;
	}

	@Column(name = "hypertonic_muscles")
	public Integer getHypertonicMuscles() {
		return this.hypertonicMuscles;
	}

	public void setHypertonicMuscles(Integer hypertonicMuscles) {
		this.hypertonicMuscles = hypertonicMuscles;
	}

	@Column(name = "lymph_node_chain")
	public Integer getLymphNodeChain() {
		return this.lymphNodeChain;
	}

	public void setLymphNodeChain(Integer lymphNodeChain) {
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
