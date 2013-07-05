package co.com.tactusoft.dialer.dao.entities;

import java.io.Serializable;

public class AstTrunkDialpatterns implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer trunkid;
	private String expressionRegular;
	private String callNumber;
	private Integer prefix;

	public AstTrunkDialpatterns() {

	}

	public AstTrunkDialpatterns(Integer trunkid, String expressionRegular,
			String callNumber, Integer prefix) {
		this.trunkid = trunkid;
		this.expressionRegular = expressionRegular;
		this.callNumber = callNumber;
		this.prefix = prefix;
	}

	public Integer getTrunkid() {
		return trunkid;
	}

	public void setTrunkid(Integer trunkid) {
		this.trunkid = trunkid;
	}

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

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}

}
