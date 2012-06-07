/**
 * ZSD_CUSTOMER_MAINTAIN_ALL_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tactusoft.webservice.client.locators;

public interface ZSD_CUSTOMER_MAINTAIN_ALL_PortType extends java.rmi.Remote {
	public void zsdCustomerMaintainAll(
			com.tactusoft.webservice.client.objects.Bapiaddr1 ziBapiaddr1,
			com.tactusoft.webservice.client.objects.Bapiaddr2 ziBapiaddr2,
			java.lang.String ziCustomerIsConsumer,
			java.lang.String ziForceExternalNumberRange,
			java.lang.String ziFromCustomermaster,
			com.tactusoft.webservice.client.objects.Kna1 ziKna1,
			com.tactusoft.webservice.client.objects.Knb1 ziKnb1,
			java.lang.String ziKnb1Reference,
			com.tactusoft.webservice.client.objects.Knvv ziKnvv,
			java.lang.String ziMaintainAddressByKna1,
			java.lang.String ziNoBankMasterUpdate,
			java.lang.String ziRaiseNoBte,
			com.tactusoft.webservice.client.objects.CustAddOnData zpiAddOnData,
			java.lang.String zpiCamChanged,
			java.lang.String zpiPostflag,
			com.tactusoft.webservice.client.holders.TableOfFkuntxtHolder ztUpdTxt,
			com.tactusoft.webservice.client.holders.TableOfFknasHolder ztXknas,
			com.tactusoft.webservice.client.holders.TableOfFknb5Holder ztXknb5,
			com.tactusoft.webservice.client.holders.TableOfFknbkHolder ztXknbk,
			com.tactusoft.webservice.client.holders.TableOfFknexHolder ztXknex,
			com.tactusoft.webservice.client.holders.TableOfFknvaHolder ztXknva,
			com.tactusoft.webservice.client.holders.TableOfFknvdHolder ztXknvd,
			com.tactusoft.webservice.client.holders.TableOfFknviHolder ztXknvi,
			com.tactusoft.webservice.client.holders.TableOfFknvkHolder ztXknvk,
			com.tactusoft.webservice.client.holders.TableOfFknvlHolder ztXknvl,
			com.tactusoft.webservice.client.holders.TableOfFknvpHolder ztXknvp,
			com.tactusoft.webservice.client.holders.TableOfFknzaHolder ztXknza,
			com.tactusoft.webservice.client.holders.TableOfFknasHolder ztYknas,
			com.tactusoft.webservice.client.holders.TableOfFknb5Holder ztYknb5,
			com.tactusoft.webservice.client.holders.TableOfFknbkHolder ztYknbk,
			com.tactusoft.webservice.client.holders.TableOfFknexHolder ztYknex,
			com.tactusoft.webservice.client.holders.TableOfFknvaHolder ztYknva,
			com.tactusoft.webservice.client.holders.TableOfFknvdHolder ztYknvd,
			com.tactusoft.webservice.client.holders.TableOfFknviHolder ztYknvi,
			com.tactusoft.webservice.client.holders.TableOfFknvkHolder ztYknvk,
			com.tactusoft.webservice.client.holders.TableOfFknvlHolder ztYknvl,
			com.tactusoft.webservice.client.holders.TableOfFknvpHolder ztYknvp,
			com.tactusoft.webservice.client.holders.TableOfFknzaHolder ztYknza,
			javax.xml.rpc.holders.StringHolder zeKunnr,
			com.tactusoft.webservice.client.holders.Kna1Holder zoKna1)
			throws java.rmi.RemoteException;
}
