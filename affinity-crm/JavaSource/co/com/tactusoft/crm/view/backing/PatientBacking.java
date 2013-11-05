package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmCity;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.beans.WSBeanPatient;
import com.tactusoft.webservice.client.execute.CustomerExecute;

@Named
@Scope("session")
public class PatientBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<CrmPatient> list;

	private List<SelectItem> listDocType;
	private List<String> selectedPatientSendOptions;

	private boolean disabledSaveButton;
	private boolean existsSAP;
	private boolean automatic;

	private boolean newRecord;

	public PatientBacking() {
		newAction(null);
	}

	public List<CrmPatient> getList() {
		return list;
	}

	public void setList(List<CrmPatient> list) {
		this.list = list;
	}

	public List<SelectItem> getListDocType() {
		return listDocType;
	}

	public void setListDocType(List<SelectItem> listDocType) {
		this.listDocType = listDocType;
	}

	public List<String> getselectedPatientSendOptions() {
		return selectedPatientSendOptions;
	}

	public void setselectedPatientSendOptions(
			List<String> selectedPatientSendOptions) {
		this.selectedPatientSendOptions = selectedPatientSendOptions;
	}

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public boolean isExistsSAP() {
		return existsSAP;
	}

	public void setExistsSAP(boolean existsSAP) {
		this.existsSAP = existsSAP;
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

	public Map<BigDecimal, CrmCountry> getMapCountry() {
		return mapCountry;
	}

	public void setMapCountry(Map<BigDecimal, CrmCountry> mapCountry) {
		this.mapCountry = mapCountry;
	}

	public Map<BigDecimal, CrmRegion> getMapRegion() {
		return mapRegion;
	}

	public void setMapRegion(Map<BigDecimal, CrmRegion> mapRegion) {
		this.mapRegion = mapRegion;
	}

	public Map<BigDecimal, CrmCity> getMapCity() {
		return mapCity;
	}

	public void setMapCity(Map<BigDecimal, CrmCity> mapCity) {
		this.mapCity = mapCity;
	}

	public void newAction(ActionEvent event) {
		optionSearchPatient = 1;
		selectedPatient = new CrmPatient();
		selectedPatient.setCrmProfile(new CrmProfile());
		selectedPatient.setGender("-1");
		selectedPatient.setCycle(false);
		disabledSaveButton = false;
		existsSAP = false;
		newRecord = true;

		// Busquedas
		optionSearchPatient = 1;
		patientModel = new PatientDataModel();
		cleanPatientFields();
	}

	@Override
	public void handleCountryChange() {
		if (idCountry != null) {
			CrmCountry crmCountry = mapCountry.get(idCountry);
			automatic = crmCountry.getAutomatic();
			this.numCell = crmCountry.getNumCell();
			this.numPhone = crmCountry.getNumPhone();

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

	public void searchAction() {
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
			}
		} else if (optionSearchPatient == 3) {
			listPatient = processService.getListPatientByField("PHONE",
					this.telPatient);
			patientModel = new PatientDataModel(listPatient);
			if (listPatient.size() > 0) {
				selectedPatientTemp = listPatient.get(0);
				disabledAddPatient = false;
			}
		}
	}

	public void addPatientAction(ActionEvent event) {
		selectedPatient = selectedPatientTemp;
		newRecord = false;
		idCountry = selectedPatient.getIdCountry();
		handleCountryChange();

		if (existsSAP) {
			String message = FacesUtil.getMessage("pat_msg_exists_sap");
			FacesUtil.addWarn(message);
			handleRegionChange();
		} else {
			idRegion = selectedPatient.getIdRegion();
			handleRegionChange();
			idCity = selectedPatient.getIdCity();
		}
	}

	public void saveAction() {
		String message = null;

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

			if (selectedPatient.isCycle()
					&& selectedPatientSendOptions.isEmpty()) {
				message = FacesUtil.getMessage("pat_msg_send");
				FacesUtil.addError(message);
			}

			CrmProfile profile = mapProfile.get(selectedPatient.getCrmProfile()
					.getId());

			if (profile == null) {
				message = FacesUtil.getMessage("pat_msg_profile");
				FacesUtil.addError(message);
			}

			if (message == null) {
				try {
					SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");

					List<WSBean> customer = new LinkedList<WSBean>();

					if (newRecord) {
						selectedPatient.setCrmProfile(profile);
						if (!existsSAP || !automatic) {
							customer = CustomerExecute.findByDoc(
									sap.getUrlCustomer2(), sap.getUsername(),
									sap.getPassword(), profile.getSociety(),
									selectedPatient.getDoc(), 0);
						}
					} else {
						if (!FacesUtil.isEmptyOrBlank(selectedPatient
								.getCodeSap())
								&& !selectedPatient.getDoc().equalsIgnoreCase(
										selectedPatient.getCodeSap())) {
							existsSAP = true;
						}
					}

					if (existsSAP || automatic || customer.size() == 0) {
						String tratamiento = "Señor";
						if (selectedPatient.getGender().equals("W")) {
							tratamiento = "Señora";
						}

						CrmCountry crmCountry = mapCountry.get(idCountry);
						CrmRegion crmRegion = mapRegion.get(idRegion);
						CrmCity crmCity = mapCity.get(idCity);

						String direccion = selectedPatient.getAddress();
						if (direccion.length() > 35) {
							direccion = direccion.substring(0, 34);
						}

						if (FacesUtil.isEmptyOrBlank(selectedPatient
								.getZipCode())) {
							selectedPatient.setZipCode("00000");
						}

						selectedPatient.setIdCountry(idCountry);
						selectedPatient.setIdRegion(idRegion);
						selectedPatient.setIdCity(idCity);
						selectedPatient.setSalesOrg(this.salesOff);
						selectedPatient.setSendPhone(false);
						selectedPatient.setSendEmail(false);
						selectedPatient.setSendPostal(false);
						selectedPatient.setSendSms(false);

						for (String send : selectedPatientSendOptions) {
							if (send.equals("1")) {
								selectedPatient.setSendPhone(true);
							} else if (send.equals("2")) {
								selectedPatient.setSendEmail(true);
							} else if (send.equals("3")) {
								selectedPatient.setSendPostal(true);
							} else if (send.equals("4")) {
								selectedPatient.setSendSms(true);
							}
						}

						String docType = selectedPatient.getDocType();
						if (automatic) {
							docType = crmCountry.getDefaultDocType();
						}

						selectedPatient.setDocType(docType);
						selectedPatient.setCrmUserByIdUserCreate(FacesUtil
								.getCurrentUser());
						selectedPatient.setDateCreate(new Date());
						processService.savePatient(selectedPatient, automatic
								&& newRecord, existsSAP, crmCountry.getCode());

						String codeSap = null;
						if (!existsSAP || newRecord) {
							codeSap = CustomerExecute.excecute(
									sap.getUrlCustomerMaintainAll(),
									sap.getUsername(), sap.getPassword(),
									sap.getEnvironment(), docType,
									selectedPatient.getDoc(), tratamiento,
									selectedPatient.getSurnames(),
									selectedPatient.getFirstnames(), direccion,
									selectedPatient.getZipCode(),
									selectedPatient.getPhoneNumber(),
									selectedPatient.getCellNumber(),
									selectedPatient.getEmail(),
									crmCountry.getCode(), crmCity.getName(),
									crmRegion.getCode(), "D001",
									profile.getSalesOrg(),
									profile.getDistrChan(),
									profile.getDivision(),
									profile.getSociety(), this.salesOff, "01",
									profile.getPaymentTerm(),
									profile.getAccount(), "01", "1", "1",
									crmCountry.getCurrencyIso());

						} else {
							codeSap = selectedPatient.getCodeSap();
						}

						if (codeSap.isEmpty()) {
							processService.removePatient(selectedPatient
									.getId());
							message = FacesUtil.getMessage("pat_msg_error_cnx");
							FacesUtil.addError(message);
						} else {
							selectedPatient.setCodeSap(codeSap);

							if (newRecord) {
								message = FacesUtil.getMessage("pat_msg_ok",
										codeSap);
							} else {
								selectedPatient
										.setCrmUserByIdUserModified(FacesUtil
												.getCurrentUser());
								message = FacesUtil.getMessage(
										"pat_msg_update_ok", codeSap);
							}

							if (!existsSAP) {
								selectedPatient.setFirstnames(selectedPatient
										.getFirstnames().toUpperCase());
								selectedPatient.setSurnames(selectedPatient
										.getSurnames().toUpperCase());
								selectedPatient.setAddress(selectedPatient
										.getAddress().toUpperCase());

								processService.savePatient(selectedPatient,
										automatic, existsSAP,
										crmCountry.getCode());
							}
							FacesUtil.addInfo(message);

							disabledSaveButton = true;
							newRecord = false;
							existsSAP = true;
						}

					} else {
						String field = FacesUtil.getMessage("pat");
						message = FacesUtil.getMessage(
								"msg_record_unique_exception", field);
						FacesUtil.addError(message);
					}
				} catch (Exception ex) {
					processService.removePatient(selectedPatient.getId());
					message = FacesUtil.getMessage("pat_msg_error_cnx");
					FacesUtil.addError(message);
				}
			}
		}
	}

	public String goAppointment() {
		AppointmentBacking appointmentBacking = FacesUtil
				.findBean("appointmentBacking");
		appointmentBacking.setSelectedPatient(selectedPatient);
		appointmentBacking.getListBranch();
		appointmentBacking.handleBranchChange();
		return "/pages/processes/appointment.jsf?faces-redirect=true";
	}

	public String goSearchByPatient() {
		SearchByPatientBacking searchByPatientBacking = FacesUtil
				.findBean("searchByPatientBacking");
		searchByPatientBacking.setSelectedPatient(selectedPatient);
		searchByPatientBacking.searchAppoinmentAction();
		return "/pages/processes/searchByPatient.jsf?faces-redirect=true";
	}
}
