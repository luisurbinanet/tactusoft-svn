package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.event.CloseEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;

import co.com.tactusoft.crm.model.entities.CrmCity;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmPatientTicket;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.model.entities.CrmTicket;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.beans.WSBeanPatient;
import com.tactusoft.webservice.client.execute.CustomerExecute;

@Named
@Scope("session")
public class ContactBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;
	private boolean disabledSaveButton;
	private boolean newRecord;
	private boolean automatic;
	private boolean existsSAP;

	private List<SelectItem> listDocType;
	private List<String> selectedSendOptions;

	private List<CrmPatientTicket> listTickets;
	private CrmPatientTicket crmPatientTicketSelected;
	private boolean validateTicket;
	private List<SelectItem> listTicketItems;

	private boolean saved;

	public ContactBacking() {
		newAction(null);
	}

	@PostConstruct
	public void init() {
		List<CrmTicket> listCrmTicket = tablesService.getListTicketActive();
		listTicketItems = FacesUtil.entityToSelectItem(listCrmTicket, "getId",
				"getName");
	}

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}

	public boolean isAutomatic() {
		return automatic;
	}

	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	public List<SelectItem> getListDocType() {
		return listDocType;
	}

	public void setListDocType(List<SelectItem> listDocType) {
		this.listDocType = listDocType;
	}

	public List<String> getSelectedSendOptions() {
		return selectedSendOptions;
	}

	public void setSelectedSendOptions(List<String> selectedSendOptions) {
		this.selectedSendOptions = selectedSendOptions;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public boolean isExistsSAP() {
		return existsSAP;
	}

	public void setExistsSAP(boolean existsSAP) {
		this.existsSAP = existsSAP;
	}

	public boolean isDisabledTicket() {
		return this.selectedPatient != null
				&& !FacesUtil.isEmptyOrBlank(this.selectedPatient.getTicket());
	}

	public List<CrmPatientTicket> getListTickets() {
		return listTickets;
	}

	public void setListTickets(List<CrmPatientTicket> listTickets) {
		this.listTickets = listTickets;
	}

	public CrmPatientTicket getCrmPatientTicketSelected() {
		return crmPatientTicketSelected;
	}

	public void setCrmPatientTicketSelected(
			CrmPatientTicket crmPatientTicketSelected) {
		this.crmPatientTicketSelected = crmPatientTicketSelected;
	}

	public boolean isValidateTicket() {
		return validateTicket;
	}

	public void setValidateTicket(boolean validateTicket) {
		this.validateTicket = validateTicket;
	}

	public List<SelectItem> getListTicketItems() {
		return listTicketItems;
	}

	public void setListTicketItems(List<SelectItem> listTicketItems) {
		this.listTicketItems = listTicketItems;
	}

	public void newAction(ActionEvent event) {
		selectedPatient = new CrmPatient();
		selectedPatient.setCrmProfile(new CrmProfile());
		selectedPatient.setGender("-1");
		selectedPatient.setCycle(false);
		disabledSaveButton = false;
		newRecord = true;
		saved = false;
		existsSAP = false;

		crmPatientTicketSelected = new CrmPatientTicket();
		crmPatientTicketSelected.setCrmTicket(new CrmTicket());
		listTickets = new LinkedList<CrmPatientTicket>();

		// Busquedas
		optionSearchPatient = 1;
		cleanPatientFields();
		patientModel = new PatientDataModel();
		selectedPatientTemp = null;

		mapOccupation = new HashMap<BigDecimal, CrmOccupation>();
	}

	public void saveAction() {
		String message = null;
		boolean isExistsTickets = true;

		if (this.validateTicket) {
			if (listTickets.isEmpty()) {
				message = FacesUtil.getMessage("pat_msg_ticket");
				FacesUtil.addError(message);
			} else {
				isExistsTickets = processService.isExistsTickets(listTickets);
			}
		}

		if (FacesUtil.isEmptyOrBlank(selectedPatient.getPhoneNumber())
				&& FacesUtil.isEmptyOrBlank(selectedPatient.getCellNumber())) {
			message = FacesUtil.getMessage("pat_msg_phone");
			FacesUtil.addError(message);
		} else {
			if ((!FacesUtil.isEmptyOrBlank(selectedPatient.getPhoneNumber()) && selectedPatient
					.getPhoneNumber().length() < this.numPhone)
					|| (!FacesUtil.isEmptyOrBlank(selectedPatient
							.getCellNumber()) && selectedPatient
							.getCellNumber().length() < this.numCell)) {

				String field = FacesUtil.getMessage("pat_phone_number");
				message = FacesUtil.getMessage("glb_length", field,
						String.valueOf(this.numPhone));

				field = FacesUtil.getMessage("pat_cell_number");
				message = message
						+ " y "
						+ FacesUtil.getMessage("glb_length", field,
								String.valueOf(this.numCell));

				FacesUtil.addError(message);
			}

			CrmProfile profile = mapProfile.get(selectedPatient.getCrmProfile()
					.getId());

			if (profile == null) {
				message = FacesUtil.getMessage("pat_msg_profile");
				FacesUtil.addError(message);
			}

			if (!isExistsTickets) {
				this.selectedPatient.setTicket(null);
				message = FacesUtil.getMessage("con_msg_ticket_fail");
				FacesUtil.addError(message);
			}

			if (message == null) {

				CrmCountry crmCountry = mapCountry.get(idCountry);
				selectedPatient.setIdCountry(idCountry);
				selectedPatient.setIdRegion(idRegion);
				selectedPatient.setIdCity(idCity);
				selectedPatient.setFirstnames(selectedPatient.getFirstnames()
						.toUpperCase());
				selectedPatient.setSurnames(selectedPatient.getSurnames()
						.toUpperCase());
				selectedPatient.setSalesOrg(salesOff);

				if (newRecord) {
					selectedPatient.setCrmProfile(profile);
					if (FacesUtil.getCurrentUser() != null) {
						selectedPatient.setCrmUserByIdUserCreate(FacesUtil
								.getCurrentUser());
					}
					selectedPatient.setDateCreate(new Date());
				} else {
					selectedPatient.setCrmUserByIdUserModified(FacesUtil
							.getCurrentUser());
					selectedPatient.setDateModified(new Date());
				}

				if (FacesUtil.isEmptyOrBlank(selectedPatient.getDoc())) {
					selectedPatient.setDoc(null);
				}
				selectedPatient.setCodeSap(selectedPatient.getDoc());

				String docType = null;
				if (FacesUtil.isEmptyOrBlank(selectedPatient.getDocType())) {
					docType = null;
				} else {
					if (automatic) {
						docType = crmCountry.getDefaultDocType();
					} else {
						docType = selectedPatient.getDocType();
					}
				}
				selectedPatient.setDocType(docType);

				try {
					selectedPatient.setFirstnames(selectedPatient
							.getFirstnames().toUpperCase());
					selectedPatient.setSurnames(selectedPatient.getSurnames()
							.toUpperCase());
					processService.savePatient(selectedPatient, automatic
							&& newRecord, false, crmCountry.getCode());
					if (newRecord) {
						processService.savePatientTicket(selectedPatient,
								listTickets);
					}
					message = FacesUtil.getMessage("con_msg_update_ok",
							selectedPatient.getNames());
					FacesUtil.addInfo(message);
					disabledSaveButton = true;
					newRecord = false;
				} catch (Exception ex) {
					String field = FacesUtil.getMessage("con");
					message = FacesUtil.getMessage(
							"msg_record_unique_exception", field);
					FacesUtil.addError(message);
				}
			}
		}
	}

	public void refreshSearchAction(ActionEvent event) {
		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		selectedPatientTemp = new CrmPatient();
		optionSearchPatient = 1;
		cleanPatientFields();
		disabledAddPatient = true;
	}

	public void searchAction(ActionEvent event) {
		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		selectedPatientTemp = new CrmPatient();
		existsSAP = false;
		if (optionSearchPatient == 1) {
			selectedPatientTemp = processService.getContactByDoc(docPatient);
			if (selectedPatientTemp.getId() != null) {
				listPatient.add(selectedPatientTemp);
				patientModel = new PatientDataModel(listPatient);
				disabledAddPatient = false;
				listTickets = processService
						.getListPatientTicket(selectedPatient.getId());
			} else {
				SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
				CrmProfile profile = mapProfile.get(this.idProfile);
				selectedPatientTemp.setCrmProfile(profile);

				List<WSBean> listPatientSAP = CustomerExecute.findByDoc(
						sap.getUrlCustomer2(), sap.getUsername(),
						sap.getPassword(), null, this.docPatient);

				if (listPatientSAP.size() > 0) {
					String codeSap = listPatientSAP.get(0).getCode();

					WSBeanPatient customer = CustomerExecute.getDetailcomplete(
							sap.getUrlCustomer2(), sap.getUsername(),
							sap.getPassword(), codeSap, profile.getSalesOrg(),
							profile.getDistrChan(), profile.getDivision());

					if (customer != null) {
						existsSAP = true;
						selectedPatientTemp.setDoc(this.docPatient);
						selectedPatientTemp.setCodeSap(customer.getCodeSap());
						selectedPatientTemp.setFirstnames(customer
								.getFirstname());
						selectedPatientTemp.setSurnames(customer.getLastname());
						selectedPatientTemp.setAddress(customer.getAddress());
						selectedPatientTemp.setPhoneNumber(customer
								.getPhoneNumber());
						selectedPatientTemp.setEmail(customer.getEmail());
						selectedPatientTemp.setZipCode(customer.getZipCode());
						selectedPatientTemp.setCycle(false);

						for (Map.Entry<BigDecimal, CrmCountry> entry : mapCountry
								.entrySet()) {
							if (customer.getCountry().equalsIgnoreCase(
									entry.getValue().getCode())) {
								idCountry = entry.getValue().getId();
								selectedPatientTemp.setIdCountry(idCountry);
								break;
							}
						}

						newRecord = false;

						listPatient.add(selectedPatientTemp);
						patientModel = new PatientDataModel(listPatient);
					}
				}
			}
		} else if (optionSearchPatient == 2) {
			listPatient = processService.getListPatientByField("NAMES",
					namePatient.toUpperCase());
			patientModel = new PatientDataModel(listPatient);
			if (listPatient.size() > 0) {
				selectedPatientTemp = listPatient.get(0);
				disabledAddPatient = false;
				listTickets = processService
						.getListPatientTicket(selectedPatient.getId());
			}
		} else if (optionSearchPatient == 3) {
			listPatient = processService.getListPatientByField("PHONE",
					this.telPatient);
			patientModel = new PatientDataModel(listPatient);
			if (listPatient.size() > 0) {
				selectedPatientTemp = listPatient.get(0);
				disabledAddPatient = false;
				listTickets = processService
						.getListPatientTicket(selectedPatient.getId());
			}
		}

		if (listTickets == null) {
			listTickets = new LinkedList<CrmPatientTicket>();
		}
	}

	public void addContactAction(ActionEvent event) {
		selectedPatient = selectedPatientTemp;
		newRecord = false;
		idCountry = selectedPatient.getIdCountry();
		handleCountryChange();

		if (existsSAP) {
			String message = FacesUtil.getMessage("pat_msg_exists_sap_4");
			FacesUtil.addWarn(message);
			handleRegionChange();
			selectedPatient
					.setCrmUserByIdUserCreate(FacesUtil.getCurrentUser());
			selectedPatient.setDateCreate(new Date());
		} else {
			idRegion = selectedPatient.getIdRegion();
			handleRegionChange();
			idCity = selectedPatient.getIdCity();
		}
	}

	public void updateAction(ActionEvent event) {
		String message = null;

		selectedPatient.setIdCountry(idCountry);
		selectedPatient.setIdRegion(idRegion);
		selectedPatient.setIdCity(idCity);

		CrmProfile profile = selectedPatient.getCrmProfile();
		CrmCountry crmCountry = mapCountry.get(selectedPatient.getIdCountry());
		CrmRegion crmRegion = mapRegion.get(selectedPatient.getIdRegion());
		CrmCity crmCity = mapCity.get(selectedPatient.getIdCity());

		if (crmCountry == null || crmRegion == null || crmCity == null) {
			message = FacesUtil.getMessage("pat_msg_country");
			FacesUtil.addError(message);
		} else if (FacesUtil.isEmptyOrBlank(selectedPatient.getPhoneNumber())
				&& FacesUtil.isEmptyOrBlank(selectedPatient.getCellNumber())) {
			message = FacesUtil.getMessage("pat_msg_phone");
			FacesUtil.addError(message);
		} else if ((!FacesUtil.isEmptyOrBlank(selectedPatient.getPhoneNumber()) && selectedPatient
				.getPhoneNumber().length() < this.numPhone)
				|| (!FacesUtil.isEmptyOrBlank(selectedPatient.getCellNumber()) && selectedPatient
						.getCellNumber().length() < this.numCell)) {

			String field = FacesUtil.getMessage("pat_phone_number");
			message = FacesUtil.getMessage("glb_length", field,
					String.valueOf(this.numPhone));

			field = FacesUtil.getMessage("pat_cell_number");
			message = message
					+ " y "
					+ FacesUtil.getMessage("glb_length", field,
							String.valueOf(this.numCell));

			FacesUtil.addError(message);
		} else {
			saved = false;
			String codeSap = null;
			SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");

			String docType = selectedPatient.getDocType();
			if (automatic) {
				docType = crmCountry.getDefaultDocType();
			}

			String tratamiento = "Señor";
			if (selectedPatient.getGender().equals("W")) {
				tratamiento = "Señora";
			}

			String address = selectedPatient.getAddress();
			if (address.length() > 35) {
				address = address.substring(0, 34);
			}

			if (FacesUtil.isEmptyOrBlank(selectedPatient.getZipCode())) {
				selectedPatient.setZipCode("00000");
			}

			if (!existsSAP) {
				List<WSBean> listCustomer = CustomerExecute.findByDoc(
						sap.getUrlCustomer2(), sap.getUsername(),
						sap.getPassword(), null, selectedPatient.getDoc(), 0);

				if (listCustomer.size() == 0) {
					codeSap = CustomerExecute.excecute(
							sap.getUrlCustomerMaintainAll(), sap.getUsername(),
							sap.getPassword(), sap.getEnvironment(), docType,
							selectedPatient.getDoc(), tratamiento,
							selectedPatient.getSurnames(),
							selectedPatient.getFirstnames(), address,
							selectedPatient.getZipCode(),
							selectedPatient.getPhoneNumber(),
							selectedPatient.getCellNumber(),
							selectedPatient.getEmail(), crmCountry.getCode(),
							crmCity.getName(), crmRegion.getCode(), "D001",
							profile.getSalesOrg(), profile.getDistrChan(),
							profile.getDivision(), profile.getSociety(),
							this.salesOff, "01", profile.getPaymentTerm(),
							profile.getAccount(), "01", "1", "1",
							crmCountry.getCurrencyIso());
				} else {
					codeSap = listCustomer.get(0).getCode();
				}
				selectedPatient.setCodeSap(codeSap);
			} else {
				codeSap = selectedPatient.getCodeSap();
			}

			selectedPatient.setDocType(docType);
			selectedPatient.setCrmUserByIdUserModified(FacesUtil
					.getCurrentUser());
			selectedPatient.setDateModified(new Date());

			try {
				processService.savePatient(selectedPatient, automatic
						&& newRecord, false, null);
				saved = true;
				message = FacesUtil.getMessage("pat_msg_ok", codeSap);
				FacesUtil.addInfo(message);
			} catch (Exception ex) {
				if (ex instanceof DataIntegrityViolationException) {
					String field = FacesUtil.getMessage("con");
					message = FacesUtil.getMessage(
							"msg_record_unique_exception", field);
				} else {
					message = ex.getMessage();
				}
				FacesUtil.addError(message);
			}
		}
	}

	public void closeAction(ActionEvent event) {
		handleClose(null);
	}

	public void handleClose(CloseEvent event) {
		newAction(null);
	}

	@Override
	public void handleCountryChange() {
		if (idCountry != null) {
			CrmCountry crmCountry = mapCountry.get(idCountry);
			this.numCell = crmCountry.getNumCell();
			this.numPhone = crmCountry.getNumPhone();
			automatic = crmCountry.getAutomatic();

			listRegion = new LinkedList<SelectItem>();
			mapRegion = new HashMap<BigDecimal, CrmRegion>();

			for (CrmRegion row : this.listAllRegion) {
				if (row.getCrmCountry().getId().intValue() == crmCountry
						.getId().intValue()) {
					listRegion.add(new SelectItem(row.getId(), row.getName()));
					mapRegion.put(row.getId(), row);
				}
			}

			if (listRegion.size() > 0) {
				idRegion = (BigDecimal) listRegion.get(0).getValue();
				handleRegionChange();
			} else {
				idRegion = null;
				idCity = null;
				listRegion = new LinkedList<SelectItem>();
				listCity = new LinkedList<SelectItem>();
			}

			listDocType = new LinkedList<SelectItem>();
			String message = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listDocType.add(new SelectItem(null, message));
			for (WSBean row : FacesUtil.getCurrentUserData().getListWSDocType()) {
				if (row.getNames().contains(crmCountry.getCode())) {
					listDocType.add(new SelectItem(row.getCode(), row
							.getNames()));
				}
			}

		} else {
			idRegion = null;
			idCity = null;
			listRegion = new LinkedList<SelectItem>();
			listCity = new LinkedList<SelectItem>();
		}
	}

	public String goAppointment() {
		AppointmentBacking appointmentBacking = FacesUtil
				.findBean("appointmentBacking");
		appointmentBacking.setSelectedPatient(selectedPatient);
		appointmentBacking.getListBranch();
		appointmentBacking.handleBranchChange();
		appointmentBacking.setGenerateNew(true);
		return "/pages/processes/appointment.jsf?faces-redirect=true";
	}

	public String goSearchByPatient() {
		SearchByPatientBacking searchByPatientBacking = FacesUtil
				.findBean("searchByPatientBacking");
		searchByPatientBacking.setSelectedPatient(selectedPatient);
		searchByPatientBacking.searchAppoinmentAction();
		return "/pages/processes/searchByPatient.jsf?faces-redirect=true";
	}

	public String goChecking() {
		AppointmentPatientBacking appointmentPatientBacking = FacesUtil
				.findBean("appointmentPatientBacking");
		appointmentPatientBacking.setSelectedPatient(selectedPatient);
		appointmentPatientBacking.searchAppoinmnetConfirmedAction();
		return "/pages/processes/appointmentCheck.jsf?faces-redirect=true";
	}

	public void addTicket() {
		if (FacesUtil.isEmptyOrBlank(this.crmPatientTicketSelected.getTicket())) {
			String field = FacesUtil.getMessage("pat_ticket");
			String message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		} else {
			this.listTickets.add(crmPatientTicketSelected);
			crmPatientTicketSelected = new CrmPatientTicket();
			crmPatientTicketSelected.setCrmTicket(new CrmTicket());
		}
	}

	public void removeTicket() {
		this.listTickets.remove(crmPatientTicketSelected);
	}

}
