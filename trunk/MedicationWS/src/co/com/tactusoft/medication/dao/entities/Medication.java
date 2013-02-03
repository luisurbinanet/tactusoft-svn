package co.com.tactusoft.medication.dao.entities;

import java.io.Serializable;

public class Medication implements Serializable {

	private static final long serialVersionUID = 1L;

	private String IdClienteCrm;
	private String idReceta;
	private String idMedico;
	private String idProductoCrm;
	private String idMaterialSAP;
	private String cantidad;

	public Medication() {

	}

	public Medication(String IdClienteCrm, String idReceta, String idMedico,
			String idProductoCrm, String idMaterialSAP, String cantidad) {
		this.IdClienteCrm = IdClienteCrm;
		this.idReceta = idReceta;
		this.idMedico = idMedico;
		this.idProductoCrm = idProductoCrm;
		this.idMaterialSAP = idMaterialSAP;
		this.cantidad = cantidad;
	}

	public String getIdClienteCrm() {
		return IdClienteCrm;
	}

	public void setIdClienteCrm(String idClienteCrm) {
		IdClienteCrm = idClienteCrm;
	}

	public String getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(String idReceta) {
		this.idReceta = idReceta;
	}

	public String getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(String idMedico) {
		this.idMedico = idMedico;
	}

	public String getIdProductoCrm() {
		return idProductoCrm;
	}

	public void setIdProductoCrm(String idProductoCrm) {
		this.idProductoCrm = idProductoCrm;
	}

	public String getIdMaterialSAP() {
		return idMaterialSAP;
	}

	public void setIdMaterialSAP(String idMaterialSAP) {
		this.idMaterialSAP = idMaterialSAP;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

}
