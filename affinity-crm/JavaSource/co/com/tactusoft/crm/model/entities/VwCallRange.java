package co.com.tactusoft.crm.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_call_range", catalog = "crm_db")
public class VwCallRange implements Serializable {

	private static final long serialVersionUID = 1L;
	private String expressionRegular;
	private String callNumber;

	public VwCallRange(String expressionRegular, String callNumber) {
		this.expressionRegular = expressionRegular;
		this.callNumber = callNumber;
	}

	@Id
	public String getExpressionRegular() {
		return expressionRegular;
	}

	public void setExpressionRegular(String expressionRegular) {
		this.expressionRegular = expressionRegular;
	}

	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

}
