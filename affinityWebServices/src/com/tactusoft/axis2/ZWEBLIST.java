
/**
 * ZWEBLIST.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.tactusoft.axis2;

/*
 *  ZWEBLIST java interface
 */

public interface ZWEBLIST {

	/**
	 * Auto generated method signature
	 * 
	 * @param zWeblists0
	 */

	public mc_style.functions.soap.sap.document.sap_com.ZWeblistsResponse zWeblists(

	mc_style.functions.soap.sap.document.sap_com.ZWeblists zWeblists0)
			throws java.rmi.RemoteException;

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param zWeblists0
	 */
	public void startzWeblists(

	mc_style.functions.soap.sap.document.sap_com.ZWeblists zWeblists0,

	final com.tactusoft.axis2.ZWEBLISTCallbackHandler callback)

	throws java.rmi.RemoteException;

	//
}
