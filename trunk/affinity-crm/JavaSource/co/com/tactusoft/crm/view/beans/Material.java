package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;

public class Material implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String descr;
	private String price;
	private String amount;

	public Material() {

	}

	public Material(String code, String descr, String price) {
		this.code = code;
		this.descr = descr;
		this.price = price;
	}

	public Material(String code, String descr, String price, String amount) {
		this.code = code;
		this.descr = descr;
		this.price = price;
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
