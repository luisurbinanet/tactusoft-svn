/**
 * ZBAPI_SALESORDER_CREATEFROMDAT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

public interface ZBAPI_SALESORDER_CREATEFROMDAT_PortType extends java.rmi.Remote {
	public java.lang.String zbapiSalesorderCreatefromdat(
			java.lang.String behaveWhenError,
			java.lang.String binaryRelationshiptype,
			java.lang.String convert,
			com.tactusoft.webservice.client.holders.TableOfBapiparexHolder extensionin,
			java.lang.String intNumberAssignment,
			com.tactusoft.webservice.client.objects.Bapisdls logicSwitch,
			com.tactusoft.webservice.client.holders.TableOfBapiccardHolder orderCcard,
			com.tactusoft.webservice.client.holders.TableOfBapicublbHolder orderCfgsBlob,
			com.tactusoft.webservice.client.holders.TableOfBapicuinsHolder orderCfgsInst,
			com.tactusoft.webservice.client.holders.TableOfBapicuprtHolder orderCfgsPartOf,
			com.tactusoft.webservice.client.holders.TableOfBapicucfgHolder orderCfgsRef,
			com.tactusoft.webservice.client.holders.TableOfBapicurefHolder orderCfgsRefinst,
			com.tactusoft.webservice.client.holders.TableOfBapicuvalHolder orderCfgsValue,
			com.tactusoft.webservice.client.holders.TableOfBapicuvkHolder orderCfgsVk,
			com.tactusoft.webservice.client.holders.TableOfBapicondHolder orderConditionsIn,
			com.tactusoft.webservice.client.holders.TableOfBapicondxHolder orderConditionsInx,
			com.tactusoft.webservice.client.objects.Bapisdhd1 orderHeaderIn,
			com.tactusoft.webservice.client.objects.Bapisdhd1X orderHeaderInx,
			com.tactusoft.webservice.client.holders.TableOfBapisditmHolder orderItemsIn,
			com.tactusoft.webservice.client.holders.TableOfBapisditmxHolder orderItemsInx,
			com.tactusoft.webservice.client.holders.TableOfBapisdkeyHolder orderKeys,
			com.tactusoft.webservice.client.holders.TableOfBapiparnrHolder orderPartners,
			com.tactusoft.webservice.client.holders.TableOfBapischdlHolder orderSchedulesIn,
			com.tactusoft.webservice.client.holders.TableOfBapischdlxHolder orderSchedulesInx,
			com.tactusoft.webservice.client.holders.TableOfBapisdtextHolder orderText,
			com.tactusoft.webservice.client.holders.TableOfBapiaddr1Holder partneraddresses,
			com.tactusoft.webservice.client.holders.TableOfBapiret2Holder _return,
			java.lang.String salesdocumentin,
			com.tactusoft.webservice.client.objects.Sender sender,
			java.lang.String testrun) throws java.rmi.RemoteException;
}
