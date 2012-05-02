package co.com.tactusoft.crm.view.beans;

import java.io.Serializable;

public class Material implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String descr;
	private String price;

	public Material() {

	}

	public Material(String code, String descr, String price) {
		this.code = code;
		this.descr = descr;
		this.price = price;
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

}
