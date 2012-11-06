package co.com.tactusoft.sap.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class CrmUserCampaignId implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idUser;
	private String codeBranch;

	public BigDecimal getIdUser() {
		return idUser;
	}

	public void setIdUser(BigDecimal idUser) {
		this.idUser = idUser;
	}

	public String getCodeBranch() {
		return codeBranch;
	}

	public void setCodeBranch(String codeBranch) {
		this.codeBranch = codeBranch;
	}

}
