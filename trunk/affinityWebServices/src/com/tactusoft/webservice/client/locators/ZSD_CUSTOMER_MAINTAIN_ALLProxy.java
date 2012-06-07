package com.tactusoft.webservice.client.locators;

public class ZSD_CUSTOMER_MAINTAIN_ALLProxy
		implements
		com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType {

	private String username;
	private String password;
	private String _endpoint = null;
	private com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType zSD_CUSTOMER_MAINTAIN_ALL_PortType = null;
	private ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator zSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator;

	public ZSD_CUSTOMER_MAINTAIN_ALLProxy() {
		zSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator = new ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator();
		_initZSD_CUSTOMER_MAINTAIN_ALLProxy();
	}

	public ZSD_CUSTOMER_MAINTAIN_ALLProxy(String url, String username,
			String password) {
		this.username = username;
		this.password = password;
		zSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator = new ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator(
				url);
		_initZSD_CUSTOMER_MAINTAIN_ALLProxy();
	}

	public ZSD_CUSTOMER_MAINTAIN_ALLProxy(String endpoint) {
		zSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator = new ZSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator();
		_endpoint = endpoint;
		_initZSD_CUSTOMER_MAINTAIN_ALLProxy();
	}

	private void _initZSD_CUSTOMER_MAINTAIN_ALLProxy() {
		try {
			zSD_CUSTOMER_MAINTAIN_ALL_PortType = zSD_CUSTOMER_MAINTAIN_ALL_ServiceLocator
					.getZSD_CUSTOMER_MAINTAIN_ALL(this.username, this.password);
			if (zSD_CUSTOMER_MAINTAIN_ALL_PortType != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) zSD_CUSTOMER_MAINTAIN_ALL_PortType)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) zSD_CUSTOMER_MAINTAIN_ALL_PortType)
							._getProperty("javax.xml.rpc.service.endpoint.address");
			}

		} catch (javax.xml.rpc.ServiceException serviceException) {
		}
	}

	public String getEndpoint() {
		return _endpoint;
	}

	public void setEndpoint(String endpoint) {
		_endpoint = endpoint;
		if (zSD_CUSTOMER_MAINTAIN_ALL_PortType != null)
			((javax.xml.rpc.Stub) zSD_CUSTOMER_MAINTAIN_ALL_PortType)
					._setProperty("javax.xml.rpc.service.endpoint.address",
							_endpoint);

	}

	public com.tactusoft.webservice.client.locators.ZSD_CUSTOMER_MAINTAIN_ALL_PortType getZSD_CUSTOMER_MAINTAIN_ALL_PortType() {
		if (zSD_CUSTOMER_MAINTAIN_ALL_PortType == null)
			_initZSD_CUSTOMER_MAINTAIN_ALLProxy();
		return zSD_CUSTOMER_MAINTAIN_ALL_PortType;
	}

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
			throws java.rmi.RemoteException {
		if (zSD_CUSTOMER_MAINTAIN_ALL_PortType == null)
			_initZSD_CUSTOMER_MAINTAIN_ALLProxy();
		zSD_CUSTOMER_MAINTAIN_ALL_PortType.zsdCustomerMaintainAll(ziBapiaddr1,
				ziBapiaddr2, ziCustomerIsConsumer, ziForceExternalNumberRange,
				ziFromCustomermaster, ziKna1, ziKnb1, ziKnb1Reference, ziKnvv,
				ziMaintainAddressByKna1, ziNoBankMasterUpdate, ziRaiseNoBte,
				zpiAddOnData, zpiCamChanged, zpiPostflag, ztUpdTxt, ztXknas,
				ztXknb5, ztXknbk, ztXknex, ztXknva, ztXknvd, ztXknvi, ztXknvk,
				ztXknvl, ztXknvp, ztXknza, ztYknas, ztYknb5, ztYknbk, ztYknex,
				ztYknva, ztYknvd, ztYknvi, ztYknvk, ztYknvl, ztYknvp, ztYknza,
				zeKunnr, zoKna1);
	}

}