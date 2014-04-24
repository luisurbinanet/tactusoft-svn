package co.com.tactusoft.crm.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VwFirstDiagnosis implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String idCie;
	private String descCie;
	private long countCie;

	public VwFirstDiagnosis() {
	}

	public VwFirstDiagnosis(String idCie, long countCie) {
		this.idCie = idCie;
		this.countCie = countCie;
	}

	public VwFirstDiagnosis(String idCie, String descCie, long countCie) {
		this.idCie = idCie;
		this.descCie = descCie;
		this.countCie = countCie;
	}

	@Id
	@Column(name = "id_cie", nullable = false, scale = 0)
	public String getIdCie() {
		return this.idCie;
	}

	public void setIdCie(String idCie) {
		this.idCie = idCie;
	}

	@Column(name = "desc_cie", length = 1000)
	public String getDescCie() {
		return this.descCie;
	}

	public void setDescCie(String descCie) {
		this.descCie = descCie;
	}

	@Column(name = "count_cie", nullable = false)
	public long getCountCie() {
		return this.countCie;
	}

	public void setCountCie(long countCie) {
		this.countCie = countCie;
	}

}
