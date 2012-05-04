package co.com.tactusoft.crm.util;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmParameter;

@Named
@Scope("session")
public class SAPEnvironment implements Serializable {

	@Inject
	private ParameterBo parameterService;

	private static final long serialVersionUID = 1L;

	List<CrmParameter> lisParameter;

	private String environment;
	private String user;
	private String password;
	private String conditionType;

	private String urlCustomerMaintainAll;
	private String urlCustomerFind;
	private String urlCustomerSalesOrderCreate;
	private String urlCustomer2;

	public SAPEnvironment() {
	}

	public SAPEnvironment(String environment, String user, String password,
			String urlCustomerMaintainAll, String urlCustomerFind,
			String urlCustomerSalesOrderCreate, String urlCustomer2) {
		this.user = user;
		this.password = password;
		this.environment = environment;
		this.urlCustomerMaintainAll = urlCustomerMaintainAll;
		this.urlCustomerFind = urlCustomerFind;
		this.urlCustomerSalesOrderCreate = urlCustomerSalesOrderCreate;
		this.urlCustomer2 = urlCustomer2;
	}

	public List<CrmParameter> getLisParameter() {
		if (lisParameter == null) {
			lisParameter = parameterService.getListParameter();
			for (CrmParameter par : lisParameter) {
				if (par.getCode().equals("SAP_ENVIRONMENT")) {
					this.environment = par.getTextValue();
				}

				if (par.getCode().equals("SAP_CONDITION_TYPE")) {
					this.conditionType = par.getTextValue();
				}

				if (par.getCode().equals("SAP_LOGIN")) {
					this.user = par.getTextValue();
				}

				if (par.getCode().equals("SAP_PASSWORD")) {
					this.password = par.getTextValue();
				}

				if (par.getCode().equals("SAP_URL_CUSTOMER_MAINTAIN_ALL")) {
					this.urlCustomerMaintainAll = par.getTextValue();
				}

				if (par.getCode().equals("SAP_URL_CUSTOMER_FIND")) {
					this.urlCustomerFind = par.getTextValue();
				}

				if (par.getCode().equals("SAP_URL_SALESORDER_CREATEFROMDAT")) {
					this.urlCustomerSalesOrderCreate = par.getTextValue();
				}

				if (par.getCode().equals("SAP_URL_CUSTOMER2")) {
					this.urlCustomer2 = par.getTextValue();
				}
			}
		}
		return lisParameter;
	}

	public void setLisParameter(List<CrmParameter> lisParameter) {
		this.lisParameter = lisParameter;
	}

	public String getEnvironment() {
		getLisParameter();
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

	public String getUrlCustomerMaintainAll() {
		return urlCustomerMaintainAll;
	}

	public void setUrlCustomerMaintainAll(String urlCustomerMaintainAll) {
		this.urlCustomerMaintainAll = urlCustomerMaintainAll;
	}

	public String getUrlCustomerFind() {
		return urlCustomerFind;
	}

	public void setUrlCustomerFind(String urlCustomerFind) {
		this.urlCustomerFind = urlCustomerFind;
	}

	public String getUrlCustomerSalesOrderCreate() {
		return urlCustomerSalesOrderCreate;
	}

	public void setUrlCustomerSalesOrderCreate(
			String urlCustomerSalesOrderCreate) {
		this.urlCustomerSalesOrderCreate = urlCustomerSalesOrderCreate;
	}

	public String getUrlCustomer2() {
		return urlCustomer2;
	}

	public void setUrlCustomer2(String urlCustomer2) {
		this.urlCustomer2 = urlCustomer2;
	}

}
