package co.com.tactusoft.crm.model.entities.sap;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CrmSapMedication generated by hbm2java
 */
@Entity
@SqlResultSetMapping(name = "implicit", entities = @EntityResult(entityClass = SapMedication.class))
@NamedNativeQuery(name = "SapMedication.findByDateBill", query = "select FacEnc.vbeln as id_bill\n"
		+ ",FacDet.POSNR as pos_bill\n"
		+ ",to_date(FacEnc.FKDAT,'YYYYMMDD') as date_bill \n"
		+ ",Ped.auart as type_bill\n"
		+ ",Cli.kunnr as id_patient\n"
		+ ",Cli.STCD1 as doc_patient\n"
		+ ",FacDet.Matnr as id_material\n"
		+ ",FacDet.MATKL AS grp_material\n"
		+ ",FacDet.PSTYV as position_type\n"
		+ ",Mat.Maktx as name_material\n"
		+ ",facdet.fkimg as unit\n"
		+ ",FacDet.cmpre*100 as amount\n"
		+ ",FacEnc.VTWEG as id_canal\n"
		+ ",Ped.VKBUR as id_sales_off\n"
		+ ",Intr.pernr as id_interlocutor\n"
		+ ",Ped.ERNAM user_sap\n"
		+ "from (select t9.* , (select max(aubel) as aubel from sapsr3.vbrp t8 where t9.vbeln=t8.vbeln and mandt=300 ) as aubel\n"
		+ "from sapsr3.vbrk t9 where t9.mandt=300 ) FacEnc \n"
		+ "left join sapsr3.vbrp FacDet on FacEnc.vbeln=FacDet.vbeln  and FacDet.mandt=FacEnc.mandt\n"
		+ "left join sapsr3.vbak Ped on (FacEnc.aubel=Ped.vbeln and Ped.mandt=FacEnc.mandt and Ped.auart in ('ZCM','ZCMT','ZFCS','ZFCT','ZOP','ZOT'))\n"
		+ "left join sapsr3.kna1 Cli on FacEnc.KUNRG=Cli.kunnr and Cli.mandt=FacEnc.mandt\n"
		+ "left join (select * from sapsr3.vbpa where parvw  ='Z2'  ) Intr on ( Intr.vbeln=Ped.vbeln and Intr.mandt=FacEnc.mandt)    \n"
		+ "left join sapsr3.makt Mat on FacDet.mandt = Mat.mandt and FacDet.matnr = Mat.matnr and MAt.SPRAS = 'S'\n"
		+ "where FacEnc.FKDAT  >= to_char(sysdate-0 ,'YYYYMMDD') \n"
		+ "and  FacEnc.VKORG in ('1000','4000')  order by 1,2", resultSetMapping = "implicit")
public class SapMedication implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private SapMedicationId id;
	private Date dateBill;
	private String typeBill;
	private String idPatient;
	private String docPatient;
	private String idMaterial;
	private String nameMaterial;
	private String grpMaterial;
	private String positionType;
	private Integer unit;
	private BigDecimal amount;
	private String idCanal;
	private BigDecimal idSalesOff;
	private String idInterlocutor;
	private String userSap;

	public SapMedication() {
	}

	public SapMedication(SapMedicationId id) {
		this.id = id;
	}

	public SapMedication(SapMedicationId id, Date dateBill, String typeBill,
			String idPatient, String docPatient, String idMaterial,
			String nameMaterial, Integer unit, BigDecimal amount,
			String idCanal, BigDecimal idSalesOff, String idInterlocutor,
			String userSap) {
		this.id = id;
		this.dateBill = dateBill;
		this.typeBill = typeBill;
		this.idPatient = idPatient;
		this.docPatient = docPatient;
		this.idMaterial = idMaterial;
		this.nameMaterial = nameMaterial;
		this.unit = unit;
		this.amount = amount;
		this.idCanal = idCanal;
		this.idSalesOff = idSalesOff;
		this.idInterlocutor = idInterlocutor;
		this.userSap = userSap;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idBill", column = @Column(name = "id_bill", nullable = false, length = 30)),
			@AttributeOverride(name = "posBill", column = @Column(name = "pos_bill", nullable = false, length = 10)) })
	public SapMedicationId getId() {
		return this.id;
	}

	public void setId(SapMedicationId id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_bill", length = 19)
	public Date getDateBill() {
		return this.dateBill;
	}

	public void setDateBill(Date dateBill) {
		this.dateBill = dateBill;
	}

	@Column(name = "type_bill", length = 4)
	public String getTypeBill() {
		return this.typeBill;
	}

	public void setTypeBill(String typeBill) {
		this.typeBill = typeBill;
	}

	@Column(name = "id_patient", length = 10)
	public String getIdPatient() {
		return this.idPatient;
	}

	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}

	@Column(name = "doc_patient", length = 30)
	public String getDocPatient() {
		return this.docPatient;
	}

	public void setDocPatient(String docPatient) {
		this.docPatient = docPatient;
	}

	@Column(name = "id_material", length = 18)
	public String getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(String idMaterial) {
		this.idMaterial = idMaterial;
	}

	@Column(name = "name_material")
	public String getNameMaterial() {
		return this.nameMaterial;
	}

	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
	}

	@Column(name = "grp_material")
	public String getGrpMaterial() {
		return grpMaterial;
	}

	public void setGrpMaterial(String grpMaterial) {
		this.grpMaterial = grpMaterial;
	}

	@Column(name = "position_type")
	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	@Column(name = "unit")
	public Integer getUnit() {
		return this.unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	@Column(name = "amount", precision = 10)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "id_canal", length = 2)
	public String getIdCanal() {
		return this.idCanal;
	}

	public void setIdCanal(String idCanal) {
		this.idCanal = idCanal;
	}

	@Column(name = "id_sales_off", scale = 0)
	public BigDecimal getIdSalesOff() {
		return this.idSalesOff;
	}

	public void setIdSalesOff(BigDecimal idSalesOff) {
		this.idSalesOff = idSalesOff;
	}

	@Column(name = "id_interlocutor", length = 8)
	public String getIdInterlocutor() {
		return this.idInterlocutor;
	}

	public void setIdInterlocutor(String idInterlocutor) {
		this.idInterlocutor = idInterlocutor;
	}

	@Column(name = "user_sap", length = 30)
	public String getUserSap() {
		return this.userSap;
	}

	public void setUserSap(String userSap) {
		this.userSap = userSap;
	}

}