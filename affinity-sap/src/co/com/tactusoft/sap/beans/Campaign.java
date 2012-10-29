package co.com.tactusoft.sap.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class Campaign implements Serializable, Comparable<Campaign> {

	private static final long serialVersionUID = 1L;
	private BigDecimal idPatient;
	private String codeMaterial;
	private String nameMaterial;
	private String codeBranch;

	public Campaign() {

	}

	public BigDecimal getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(BigDecimal idPatient) {
		this.idPatient = idPatient;
	}

	public String getCodeMaterial() {
		return codeMaterial;
	}

	public void setCodeMaterial(String codeMaterial) {
		this.codeMaterial = codeMaterial;
	}

	public String getNameMaterial() {
		return nameMaterial;
	}

	public void setNameMaterial(String nameMaterial) {
		this.nameMaterial = nameMaterial;
	}

	public String getCodeBranch() {
		return codeBranch;
	}

	public void setCodeBranch(String codeBranch) {
		this.codeBranch = codeBranch;
	}

	@Override
	public int compareTo(Campaign object) {
		return this.idPatient.intValue() - object.getIdPatient().intValue();
	}

}
