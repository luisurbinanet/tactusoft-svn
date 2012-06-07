/**
 * ZBAPI_CUSTOMER_FIND_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

public interface ZBAPI_CUSTOMER_FIND_PortType extends java.rmi.Remote {
	public com.tactusoft.webservice.client.objects.Bapireturn1 customerFind(
			java.lang.Integer maxCnt,
			java.lang.String plHold,
			com.tactusoft.webservice.client.holders.TableOfBapikna111Holder resultTab,
			com.tactusoft.webservice.client.holders.TableOfBapikna110Holder seloptTab)
			throws java.rmi.RemoteException;
}
