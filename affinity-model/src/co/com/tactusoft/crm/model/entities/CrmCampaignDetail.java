package co.com.tactusoft.crm.model.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CrmCampaignDetail generated by hbm2java
 */
@Entity
@Table(name = "crm_campaign_detail", catalog = "crm_db")
public class CrmCampaignDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private CrmCampaign crmCampaign;
	private CrmAppointment crmAppointment;
	private String codMaterial;
	private String descMaterial;
	private String campaingType;

	public CrmCampaignDetail() {
	}

	public CrmCampaignDetail(CrmCampaign crmCampaign, String campaingType) {
		this.crmCampaign = crmCampaign;
		this.campaingType = campaingType;
	}

	public CrmCampaignDetail(CrmCampaign crmCampaign,
			CrmAppointment crmAppointment, String codMaterial,
			String descMaterial, String campaingType) {
		this.crmCampaign = crmCampaign;
		this.crmAppointment = crmAppointment;
		this.codMaterial = codMaterial;
		this.descMaterial = descMaterial;
		this.campaingType = campaingType;
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
	@JoinColumn(name = "id_campaign", nullable = false)
	public CrmCampaign getCrmCampaign() {
		return this.crmCampaign;
	}

	public void setCrmCampaign(CrmCampaign crmCampaign) {
		this.crmCampaign = crmCampaign;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_appointment")
	public CrmAppointment getCrmAppointment() {
		return this.crmAppointment;
	}

	public void setCrmAppointment(CrmAppointment crmAppointment) {
		this.crmAppointment = crmAppointment;
	}

	@Column(name = "cod_material", length = 18)
	public String getCodMaterial() {
		return this.codMaterial;
	}

	public void setCodMaterial(String codMaterial) {
		this.codMaterial = codMaterial;
	}

	@Column(name = "desc_material", length = 1000)
	public String getDescMaterial() {
		return this.descMaterial;
	}

	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}

	@Column(name = "campaing_type", nullable = false, length = 30)
	public String getCampaingType() {
		return this.campaingType;
	}

	public void setCampaingType(String campaingType) {
		this.campaingType = campaingType;
	}

}
