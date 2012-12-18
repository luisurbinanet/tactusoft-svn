package co.com.tactusoft.crm.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_call_range", catalog = "crm_db")
public class VwCallRange implements Serializable {

	private static final long serialVersionUID = 1L;
	private String expressionRegular;
	private String callNumber;
	private Integer trunkid;

	public VwCallRange() {

	}

	public VwCallRange(String expressionRegular, String callNumber, Integer trunkid) {
		this.expressionRegular = expressionRegular;
		this.callNumber = callNumber;
	}

	@Id
	@Column(name = "expression_regular")
	public String getExpressionRegular() {
		return expressionRegular;
	}

	public void setExpressionRegular(String expressionRegular) {
		this.expressionRegular = expressionRegular;
	}

	@Column(name = "call_number")
	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	@Column(name = "trunkid")
	public Integer getTrunkid() {
		return trunkid;
	}

	public void setTrunkid(Integer trunkid) {
		this.trunkid = trunkid;
	}
}
