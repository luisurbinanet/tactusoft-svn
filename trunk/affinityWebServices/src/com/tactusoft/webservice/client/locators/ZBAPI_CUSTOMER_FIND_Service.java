/**
 * ZBAPI_CUSTOMER_FIND_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

public interface ZBAPI_CUSTOMER_FIND_Service extends javax.xml.rpc.Service {
	public java.lang.String getZBAPI_CUSTOMER_FINDAddress();

	public com.tactusoft.webservice.client.locators.ZBAPI_CUSTOMER_FIND_PortType getZBAPI_CUSTOMER_FIND(
			String username, String password) throws javax.xml.rpc.ServiceException;

	public com.tactusoft.webservice.client.locators.ZBAPI_CUSTOMER_FIND_PortType getZBAPI_CUSTOMER_FIND(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
