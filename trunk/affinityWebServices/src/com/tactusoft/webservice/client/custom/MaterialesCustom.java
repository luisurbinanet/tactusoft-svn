package com.tactusoft.webservice.client.custom;

import java.math.BigDecimal;

public class MaterialesCustom {

	private String itmNumber;
	private String material;
	private BigDecimal quantity;
	private String manterialName;
	private String condicionType;
	private Double currency;
	private String currencyType;

	public MaterialesCustom() {

	}

	public String getItmNumber() {
		return itmNumber;
	}

	public void setItmNumber(String itmNumber) {
		this.itmNumber = itmNumber;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getManterialName() {
		return manterialName;
	}

	public void setManterialName(String manterialName) {
		this.manterialName = manterialName;
	}

	public String getCondicionType() {
		return condicionType;
	}

	public void setCondicionType(String condicionType) {
		this.condicionType = condicionType;
	}

	public Double getCurrency() {
		return currency;
	}

	public void setCurrency(Double currency) {
		this.currency = currency;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

}
