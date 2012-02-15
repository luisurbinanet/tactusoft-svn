package co.com.tactusoft.kpi.view.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ReportDaily implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal id;
	private String metric;
	private String um;
	private String type;
	private Double[] listPlan;
	private Double[] listCurrent;

	public ReportDaily() {

	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double[] getListPlan() {
		return listPlan;
	}

	public void setListPlan(Double[] listPlan) {
		this.listPlan = listPlan;
	}

	public Double[] getListCurrent() {
		return listCurrent;
	}

	public void setListCurrent(Double[] listCurrent) {
		this.listCurrent = listCurrent;
	}

}
