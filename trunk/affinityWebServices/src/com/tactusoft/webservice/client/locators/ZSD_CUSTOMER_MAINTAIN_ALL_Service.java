/**
 * ZSD_CUSTOMER_MAINTAIN_ALL_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

public interface ZSD_CUSTOMER_MAINTAIN_ALL_Service extends
		javax.xml.rpc.Service {
	public java.lang.String getZSD_CUSTOMER_MAINTAIN_ALLAddress();

	public com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType getZSD_CUSTOMER_MAINTAIN_ALL(
			String username, String password)
			throws javax.xml.rpc.ServiceException;

	public com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType getZSD_CUSTOMER_MAINTAIN_ALL(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
