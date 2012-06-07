/**
 * Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

public interface ZBAPI_SALESORDER_CREATEFROMDAT_Service extends
		javax.xml.rpc.Service {
	public java.lang.String getZBAPI_SALESORDER_CREATEFROMDATAddress();

	public com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType getZBAPI_SALESORDER_CREATEFROMDAT(
			String username, String password)
			throws javax.xml.rpc.ServiceException;

	public com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType getZBAPI_SALESORDER_CREATEFROMDAT(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
