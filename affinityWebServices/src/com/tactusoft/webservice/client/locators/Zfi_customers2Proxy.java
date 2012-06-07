package com.tactusoft.webservice.client.locators;

public class Zfi_customers2Proxy implements
		com.tactusoft.webservice.client.locators.Zfi_customers2_PortType {

	private String username;
	private String password;
	private String _endpoint = null;
	private com.tactusoft.webservice.client.locators.Zfi_customers2_PortType zfi_customers2 = null;
	private Zfi_customers2_ServiceLocator customers2Locator;

	public Zfi_customers2Proxy() {
		customers2Locator = new Zfi_customers2_ServiceLocator();
		_initZfi_customers2Proxy();
	}

	public Zfi_customers2Proxy(String url, String username, String password) {
		this.username = username;
		this.password = password;
		customers2Locator = new Zfi_customers2_ServiceLocator(url);
		_initZfi_customers2Proxy();
	}

	public Zfi_customers2Proxy(String endpoint) {
		_endpoint = endpoint;
		customers2Locator = new Zfi_customers2_ServiceLocator();
		_initZfi_customers2Proxy();
	}

	private void _initZfi_customers2Proxy() {
		try {
			zfi_customers2 = customers2Locator.getCustomers2(this.username,
					this.password);
			if (zfi_customers2 != null) {
				if (_endpoint != null)
					((javax.xml.rpc.Stub) zfi_customers2)
							._setProperty(
									"javax.xml.rpc.service.endpoint.address",
									_endpoint);
				else
					_endpoint = (String) ((javax.xml.rpc.Stub) zfi_customers2)
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
		if (zfi_customers2 != null)
			((javax.xml.rpc.Stub) zfi_customers2)._setProperty(
					"javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public com.tactusoft.webservice.client.locators.Zfi_customers2_PortType getZfi_customers2() {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2;
	}

	public com.tactusoft.webservice.client.objects.Bapireturn customerCreatePassword(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerCreatePassword(customerNo);
	}

	public void customerGetDetail1(
			java.lang.String customerNo,
			java.lang.String distributionChannel,
			java.lang.String division,
			java.lang.String salesOrganiation,
			com.tactusoft.webservice.client.holders.Bapikna109Holder addressTypeNo,
			com.tactusoft.webservice.client.holders.Bapikna106Holder companyData,
			javax.xml.rpc.holders.StringHolder consumerFlag,
			com.tactusoft.webservice.client.holders.Bapikna105Holder optionalCompanyData,
			com.tactusoft.webservice.client.holders.Bapikna105Holder optionalPersonalData,
			com.tactusoft.webservice.client.holders.Bapikna105Holder optionalPersonalDataNew,
			com.tactusoft.webservice.client.holders.Bapikna1011Holder personalData,
			com.tactusoft.webservice.client.holders.Bapikna1011Holder personalDataNew,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2
				.customerGetDetail1(customerNo, distributionChannel, division,
						salesOrganiation, addressTypeNo, companyData,
						consumerFlag, optionalCompanyData,
						optionalPersonalData, optionalPersonalDataNew,
						personalData, personalDataNew, _return);
	}

	public void customerGetDetail2(
			java.lang.String companyCode,
			java.lang.String customerNo,
			com.tactusoft.webservice.client.holders.Bapicustomer04Holder customerAddress,
			com.tactusoft.webservice.client.holders.TableOfBapicustomer02Holder customerBankDetail,
			com.tactusoft.webservice.client.holders.Bapicustomer05Holder customerCompanyDetail,
			com.tactusoft.webservice.client.holders.BapicustomerKna1Holder customerGeneralDetail,
			com.tactusoft.webservice.client.holders.Bapiret1Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetDetail2(companyCode, customerNo,
				customerAddress, customerBankDetail, customerCompanyDetail,
				customerGeneralDetail, _return);
	}

	public void customerGetHierarchyChildren(
			java.lang.String custHiTyp,
			java.lang.String customerNo,
			java.lang.String nodeLevel,
			com.tactusoft.webservice.client.objects.Sdvtber[] salesArea,
			java.lang.String validOn,
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhHolder nodeList,
			com.tactusoft.webservice.client.holders.Bapiret2Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetHierarchyChildren(custHiTyp, customerNo,
				nodeLevel, salesArea, validOn, nodeList, _return);
	}

	public com.tactusoft.webservice.client.objects.Bapiret2[] customerAddHierarchyNodes(
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhProcessHolder nodeList)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerAddHierarchyNodes(nodeList);
	}

	public com.tactusoft.webservice.client.objects.Bapireturn customerDeletePassword(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerDeletePassword(customerNo);
	}

	public void customerFind(
			java.lang.Integer maxCnt,
			java.lang.String plHold,
			com.tactusoft.webservice.client.objects.Bapikna110[] seloptTab,
			com.tactusoft.webservice.client.holders.TableOfBapikna111Holder resultTab,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerFind(maxCnt, plHold, seloptTab, resultTab,
				_return);
	}

	public void customerGetSalesAreas(
			java.lang.String customerNo,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return,
			com.tactusoft.webservice.client.holders.TableOfBapiknvvkyHolder salesAreas)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetSalesAreas(customerNo, _return, salesAreas);
	}

	public void customerSearch1(
			java.lang.String email,
			java.lang.String salesorganisation,
			javax.xml.rpc.holders.StringHolder customerNo,
			com.tactusoft.webservice.client.holders.TableOfBapikna103Holder multiple,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerSearch1(email, salesorganisation, customerNo,
				multiple, _return);
	}

	public com.tactusoft.webservice.client.objects.Bapiret2 bapiServiceTransactionCommit(
			java.lang.String WAIT) throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.bapiServiceTransactionCommit(WAIT);
	}

	public com.tactusoft.webservice.client.objects.Bapireturn customerChangePassword(
			java.lang.String customerNo, java.lang.String newPassword,
			java.lang.String password, java.lang.String verifyPassword)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerChangePassword(customerNo, newPassword,
				password, verifyPassword);
	}

	public void customerCreateFromData1(
			com.tactusoft.webservice.client.objects.Bapikna106 companyData,
			java.lang.String consumerEn,
			com.tactusoft.webservice.client.objects.Bapikna102 copyReference,
			java.lang.String creditControlFlag,
			com.tactusoft.webservice.client.objects.Bapikna105 optionalCompanyData,
			com.tactusoft.webservice.client.objects.Bapikna105 optionalPersonalData,
			com.tactusoft.webservice.client.objects.Bapikna1011 personalData,
			javax.xml.rpc.holders.StringHolder customerNo,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerCreateFromData1(companyData, consumerEn,
				copyReference, creditControlFlag, optionalCompanyData,
				optionalPersonalData, personalData, customerNo, _return);
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerDelete(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerDelete(customerNo);
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerExistenceCheck(
			java.lang.String companyCode, java.lang.String customerNo,
			java.lang.String distributionChannel, java.lang.String division,
			java.lang.String salesOrganization) throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerExistenceCheck(companyCode, customerNo,
				distributionChannel, division, salesOrganization);
	}

	public void customerGetInternalNumber(
			java.lang.String accountGroup,
			org.apache.axis.holders.UnsignedByteHolder quantity,
			com.tactusoft.webservice.client.holders.TableOfBapicustomerNumbersHolder customer,
			javax.xml.rpc.holders.StringHolder customerId,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetInternalNumber(accountGroup, quantity,
				customer, customerId, _return);
	}

	public void customerGetHierarchyRootList(
			java.lang.String custHiTyp,
			com.tactusoft.webservice.client.objects.Sdvtber[] salesArea,
			java.lang.String validOn,
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhHolder nodeList,
			com.tactusoft.webservice.client.holders.Bapiret2Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetHierarchyRootList(custHiTyp, salesArea,
				validOn, nodeList, _return);
	}

	public void customerSearch(
			com.tactusoft.webservice.client.objects.Bapikna101 piAddress,
			java.lang.String piSalesorg,
			java.lang.String piSearchFlag,
			com.tactusoft.webservice.client.holders.TableOfBapikna103Holder multiple,
			javax.xml.rpc.holders.StringHolder peCustomer,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerSearch(piAddress, piSalesorg, piSearchFlag,
				multiple, peCustomer, _return);
	}

	public void customerCheckPassword(java.lang.String customerNo,
			java.lang.String distributionChannel, java.lang.String division,
			java.lang.String password, java.lang.String salesOrganization,
			com.tactusoft.webservice.client.holders.Kna1Holder customerData,
			javax.xml.rpc.holders.StringHolder customerNumberOut,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerCheckPassword(customerNo, distributionChannel,
				division, password, salesOrganization, customerData,
				customerNumberOut, _return);
	}

	public com.tactusoft.webservice.client.objects.Bapiret2[] customerRemoveHierarchyNodes(
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhProcessHolder nodeList)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerRemoveHierarchyNodes(nodeList);
	}

	public com.tactusoft.webservice.client.objects.Bapireturn1 customerChangeFromData1(
			com.tactusoft.webservice.client.objects.Bapikna106 companyData,
			com.tactusoft.webservice.client.objects.Bapikna106X companyDataX,
			java.lang.String customerNo,
			java.lang.String distributionChannel,
			java.lang.String division,
			com.tactusoft.webservice.client.objects.Bapikna105 optionalCompanyData,
			com.tactusoft.webservice.client.objects.Bapikna105X optionalCompanyDataX,
			com.tactusoft.webservice.client.objects.Bapikna105 optionalPersonalData,
			com.tactusoft.webservice.client.objects.Bapikna105X optionalPersonalDataX,
			com.tactusoft.webservice.client.objects.Bapikna1011 personalData,
			com.tactusoft.webservice.client.objects.Bapikna1011X personalDataX,
			java.lang.String salesOrganisation) throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerChangeFromData1(companyData,
				companyDataX, customerNo, distributionChannel, division,
				optionalCompanyData, optionalCompanyDataX,
				optionalPersonalData, optionalPersonalDataX, personalData,
				personalDataX, salesOrganisation);
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerCheckPassword1(
			java.lang.String customerNo, java.lang.String password)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerCheckPassword1(customerNo, password);
	}

	public void customerGetDetail(java.lang.String customerNo,
			java.lang.String distributionChannel, java.lang.String division,
			java.lang.String passBuffer, java.lang.String piSalesorg,
			com.tactusoft.webservice.client.holders.Bapikna101Holder peAddress,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetDetail(customerNo, distributionChannel,
				division, passBuffer, piSalesorg, peAddress, _return);
	}

	public void customerGetHierarchyRoot(
			java.lang.String custHiTyp,
			java.lang.String customerNo,
			com.tactusoft.webservice.client.objects.Sdvtber[] salesArea,
			java.lang.String validOn,
			com.tactusoft.webservice.client.holders.TableOfBapikna1KnvhHolder nodeList,
			com.tactusoft.webservice.client.holders.Bapiret2Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetHierarchyRoot(custHiTyp, customerNo,
				salesArea, validOn, nodeList, _return);
	}

	public void customerCheckExistence(java.lang.String customerNo,
			java.lang.String distributionChannel, java.lang.String division,
			java.lang.String salesOrganization,
			com.tactusoft.webservice.client.holders.Kna1Holder customerData,
			javax.xml.rpc.holders.StringHolder customerNumberOut,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerCheckExistence(customerNo, distributionChannel,
				division, salesOrganization, customerData, customerNumberOut,
				_return);
	}

	public void customerCreateFromData(
			com.tactusoft.webservice.client.objects.Bapikna101 piAddress,
			com.tactusoft.webservice.client.objects.Bapikna102 piCopyreference,
			javax.xml.rpc.holders.StringHolder customerNo,
			javax.xml.rpc.holders.StringHolder peCustomer,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerCreateFromData(piAddress, piCopyreference,
				customerNo, peCustomer, _return);
	}

	public com.tactusoft.webservice.client.objects.Bapireturn customerGetPassword(
			java.lang.String customerNo,
			com.tactusoft.webservice.client.holders.TableOfBapiuswstaHolder statusinfo)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerGetPassword(customerNo, statusinfo);
	}

	public com.tactusoft.webservice.client.objects.Bapiret2[] customerChangeHierarchyNodes(
			com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[] nodeListAfter,
			com.tactusoft.webservice.client.objects.Bapikna1KnvhProcess[] nodeListBefore)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerChangeHierarchyNodes(nodeListAfter,
				nodeListBefore);
	}

	public void customerChangeFromData(java.lang.String customerNo,
			com.tactusoft.webservice.client.objects.Bapikna101 piAddress,
			java.lang.String piDistrChan, java.lang.String piDivision,
			java.lang.String piSalesorg,
			com.tactusoft.webservice.client.holders.Bapikna101Holder peAddress,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerChangeFromData(customerNo, piAddress,
				piDistrChan, piDivision, piSalesorg, peAddress, _return);
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerDisplay(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerDisplay(customerNo);
	}

	public void customerGetContactList(
			com.tactusoft.webservice.client.objects.BapicustomerIdrange[] customerRange,
			java.lang.Integer maxRows,
			com.tactusoft.webservice.client.holders.TableOfBapicontactAddressdataHolder contactAddressData,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetContactList(customerRange, maxRows,
				contactAddressData, _return);
	}

	public void customerInitPassword(java.lang.String customerNo,
			javax.xml.rpc.holders.StringHolder password,
			com.tactusoft.webservice.client.holders.BapireturnHolder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerInitPassword(customerNo, password, _return);
	}

	public void customerCreate(java.lang.String initializeCustomerNo,
			javax.xml.rpc.holders.StringHolder customer,
			javax.xml.rpc.holders.StringHolder customerNo,
			com.tactusoft.webservice.client.holders.Bapiret1Holder _return)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerCreate(initializeCustomerNo, customer,
				customerNo, _return);
	}

	public com.tactusoft.webservice.client.objects.Bapiret1 customerEdit(
			java.lang.String customerNo) throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.customerEdit(customerNo);
	}

	public void customerGetList(
			java.lang.String CPDOnly,
			com.tactusoft.webservice.client.objects.BapicustomerIdrange[] idRange,
			java.lang.Integer maxRows,
			com.tactusoft.webservice.client.holders.TableOfBapicustomerAddressdataHolder addressData,
			com.tactusoft.webservice.client.holders.Bapireturn1Holder _return,
			com.tactusoft.webservice.client.holders.TableOfBapicustomerSpecialdataHolder specialData)
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		zfi_customers2.customerGetList(CPDOnly, idRange, maxRows, addressData,
				_return, specialData);
	}

	public com.tactusoft.webservice.client.objects.Bapiret2 bapiServiceTransactionRollback()
			throws java.rmi.RemoteException {
		if (zfi_customers2 == null)
			_initZfi_customers2Proxy();
		return zfi_customers2.bapiServiceTransactionRollback();
	}

}