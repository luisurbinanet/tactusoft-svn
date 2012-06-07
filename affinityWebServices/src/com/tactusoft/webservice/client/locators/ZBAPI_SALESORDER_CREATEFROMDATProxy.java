package com.tactusoft.webservice.client.locators;

public class ZBAPI_SALESORDER_CREATEFROMDATProxy implements
		com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType {

	private String username;
	private String password;
	private String _endpoint = null;
	private com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType zBAPI_SALESORDER_CREATEFROMDAT = null;
	private ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator zBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator;

	public ZBAPI_SALESORDER_CREATEFROMDATProxy() {
		zBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator = new ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator();
		_initZBAPI_SALESORDER_CREATEFROMDATProxy();
	}

	public ZBAPI_SALESORDER_CREATEFROMDATProxy(String url, String username,
			String password) {
		this.username = username;
		this.password = password;
		zBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator = new ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator(url);
		_initZBAPI_SALESORDER_CREATEFROMDATProxy();
	}

	public ZBAPI_SALESORDER_CREATEFROMDATProxy(String endpoint) {
		zBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator = new ZBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator();
		_endpoint = endpoint;
		_initZBAPI_SALESORDER_CREATEFROMDATProxy();
	}

	private void _initZBAPI_SALESORDER_CREATEFROMDATProxy() {
		try {
			zBAPI_SALESORDER_CREATEFROMDAT = zBAPI_SALESORDER_CREATEFROMDAT_ServiceLocator
					.getZBAPI_SALESORDER_CREATEFROMDAT(this.username,
							this.password);
			if (zBAPI_SALESORDER_CREATEFROMDAT != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) zBAPI_SALESORDER_CREATEFROMDAT)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) zBAPI_SALESORDER_CREATEFROMDAT)
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
		if (zBAPI_SALESORDER_CREATEFROMDAT != null)
			((javax.xml.rpc.Stub) zBAPI_SALESORDER_CREATEFROMDAT)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.tactusoft.webservice.client.locators.ZBAPI_SALESORDER_CREATEFROMDAT_PortType getZBAPI_SALESORDER_CREATEFROMDAT() {
		if (zBAPI_SALESORDER_CREATEFROMDAT == null)
			_initZBAPI_SALESORDER_CREATEFROMDATProxy();
		return zBAPI_SALESORDER_CREATEFROMDAT;
	}

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
			java.lang.String testrun) throws java.rmi.RemoteException {
		if (zBAPI_SALESORDER_CREATEFROMDAT == null)
			_initZBAPI_SALESORDER_CREATEFROMDATProxy();
		return zBAPI_SALESORDER_CREATEFROMDAT.zbapiSalesorderCreatefromdat(
				behaveWhenError, binaryRelationshiptype, convert, extensionin,
				intNumberAssignment, logicSwitch, orderCcard, orderCfgsBlob,
				orderCfgsInst, orderCfgsPartOf, orderCfgsRef, orderCfgsRefinst,
				orderCfgsValue, orderCfgsVk, orderConditionsIn,
				orderConditionsInx, orderHeaderIn, orderHeaderInx,
				orderItemsIn, orderItemsInx, orderKeys, orderPartners,
				orderSchedulesIn, orderSchedulesInx, orderText,
				partneraddresses, _return, salesdocumentin, sender, testrun);
	}

}