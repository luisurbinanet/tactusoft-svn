package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;

public class OdontogramBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String tooth;
	private Integer procedure;
	private String descProcedure;
	private String color;

	public OdontogramBean() {

	}

	/**
	 * @param tooth
	 * @param procedure
	 * @param descProcedure
	 */
	public OdontogramBean(String tooth, Integer procedure, String descProcedure, String color) {
		super();
		this.tooth = tooth;
		this.procedure = procedure;
		this.descProcedure = descProcedure;
		this.color = color;
	}

	public String getTooth() {
		return tooth;
	}

	public void setTooth(String tooth) {
		this.tooth = tooth;
	}

	public Integer getProcedure() {
		return procedure;
	}

	public void setProcedure(Integer procedure) {
		this.procedure = procedure;
	}

	public String getDescProcedure() {
		return descProcedure;
	}

	public void setDescProcedure(String descProcedure) {
		this.descProcedure = descProcedure;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
