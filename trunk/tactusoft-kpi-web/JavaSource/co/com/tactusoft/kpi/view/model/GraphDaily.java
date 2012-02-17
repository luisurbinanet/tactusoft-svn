package co.com.tactusoft.kpi.view.model;

import java.io.Serializable;

public class GraphDaily implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private Double value;

	public GraphDaily() {

	}

	public GraphDaily(String label, double value) {
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
