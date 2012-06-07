/**
 * Customers2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

public interface Zfi_customers2_Service extends javax.xml.rpc.Service {
	public java.lang.String getCustomers2Address();

	public com.tactusoft.webservice.client.locators.Zfi_customers2_PortType getCustomers2(
			String username, String password)
			throws javax.xml.rpc.ServiceException;

	public com.tactusoft.webservice.client.locators.Zfi_customers2_PortType getCustomers2(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
