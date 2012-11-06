package co.com.tactusoft.sap.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CrmUserCampaignId implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idUser;
	private BigDecimal idBranch;

	@Column(name = "id_user")
	public BigDecimal getIdUser() {
		return idUser;
	}

	public void setIdUser(BigDecimal idUser) {
		this.idUser = idUser;
	}

	@Column(name = "id_branch")
	public BigDecimal getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

}
