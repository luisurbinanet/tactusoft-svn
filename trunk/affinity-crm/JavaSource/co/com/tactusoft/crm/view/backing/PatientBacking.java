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

import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCity;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomerExecute;

@Named
@Scope("view")
public class PatientBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<CrmPatient> list;
	private PatientDataModel model;
	private CrmPatient selected;

	private List<SelectItem> listBranch;
	private String salesOff;

	private List<SelectItem> listCountry;
	private BigDecimal idCountry;
	private Map<BigDecimal, CrmCountry> mapCountry;

	private List<SelectItem> listRegion;
	private BigDecimal idRegion;
	private Map<BigDecimal, CrmRegion> mapRegion;

	private List<SelectItem> listCity;
	private BigDecimal idCity;
	private Map<BigDecimal, CrmCity> mapCity;

	private List<String> selectedSendOptions;

	private boolean disabledSaveButton;
	private boolean exitSAP;
	private boolean automatic;

	public PatientBacking() {
		newAction(null);
	}

	public List<CrmPatient> getList() {
		return list;
	}

	public void setList(List<CrmPatient> list) {
		this.list = list;
	}

	public PatientDataModel getModel() {
		if (model == null) {
			model = new PatientDataModel(list);
		}
		return model;
	}

	public void setModel(PatientDataModel model) {
		this.model = model;
	}

	public CrmPatient getSelected() {
		return selected;
	}

	public void setSelected(CrmPatient selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				listBranch.add(new SelectItem(row.getCode(), row.getName()
						+ " (" + row.getSociety() + ")"));
			}
		}
		return listBranch;
	}

	public void setListBranch(List<SelectItem> listBranch) {
		this.listBranch = listBranch;
	}

	public String getSalesOff() {
		return salesOff;
	}

	public void setSalesOff(String salesOff) {
		this.salesOff = salesOff;
	}

	public List<SelectItem> getListCountry() {
		if (listCountry == null) {
			listCountry = new LinkedList<SelectItem>();
			mapCountry = new HashMap<BigDecimal, CrmCountry>();
			for (CrmCountry row : tablesService.getListCountry()) {
				listCountry.add(new SelectItem(row.getId(), row.getName()));
				mapCountry.put(row.getId(), row);
			}

			if (listCountry.size() > 0) {
				idCountry = (BigDecimal) listCountry.get(0).getValue();
				handleCountryChange();
			}
		}
		return listCountry;
	}

	public void setListCountry(List<SelectItem> listCountry) {
		this.listCountry = listCountry;
	}

	public BigDecimal getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(BigDecimal idCountry) {
		this.idCountry = idCountry;
	}

	public List<SelectItem> getListRegion() {
		return listRegion;
	}

	public void setListRegion(List<SelectItem> listRegion) {
		this.listRegion = listRegion;
	}

	public BigDecimal getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(BigDecimal idRegion) {
		this.idRegion = idRegion;
	}

	public List<SelectItem> getListCity() {
		return listCity;
	}

	public void setListCity(List<SelectItem> listCity) {
		this.listCity = listCity;
	}

	public BigDecimal getIdCity() {
		return idCity;
	}

	public void setIdCity(BigDecimal idCity) {
		this.idCity = idCity;
	}

	public List<String> getSelectedSendOptions() {
		return selectedSendOptions;
	}

	public void setSelectedSendOptions(List<String> selectedSendOptions) {
		this.selectedSendOptions = selectedSendOptions;
	}

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public boolean isExitSAP() {
		return exitSAP;
	}

	public void setExitSAP(boolean exitSAP) {
		this.exitSAP = exitSAP;
	}

	public boolean isAutomatic() {
		return automatic;
	}

	public void setAutomatic(boolean automatic) {
		this.automatic = automatic;
	}

	public void handleCountryChange() {
		if (idCountry != null) {
			CrmCountry crmCountry = mapCountry.get(idCountry);
			automatic = crmCountry.getAutomatic();

			listRegion = new LinkedList<SelectItem>();
			mapRegion = new HashMap<BigDecimal, CrmRegion>();
			for (CrmRegion row : crmCountry.getCrmRegions()) {
				listRegion.add(new SelectItem(row.getId(), row.getName()));
				mapRegion.put(row.getId(), row);
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
		} else {
			idRegion = null;
			idCity = null;
			listRegion = new LinkedList<SelectItem>();
			listCity = new LinkedList<SelectItem>();
		}
	}

	public void handleRegionChange() {
		CrmRegion crmRegion = mapRegion.get(idRegion);
		listCity = new LinkedList<SelectItem>();
		mapCity = new HashMap<BigDecimal, CrmCity>();
		for (CrmCity row : crmRegion.getCrmCities()) {
			listCity.add(new SelectItem(row.getId(), row.getName()));
			mapCity.put(row.getId(), row);
		}

		if (listRegion.size() > 0) {
			idCity = (BigDecimal) listCity.get(0).getValue();
		} else {
			idCity = null;
		}
	}

	public void newAction(ActionEvent event) {
		optionSearchPatient = 1;
		selected = new CrmPatient();
		selected.setGender("-1");
		selected.setCycle(false);
		disabledSaveButton = false;
		exitSAP = false;
	}

	private void searchIdCountry(String countryCode) {
		idCountry = null;
		for (Map.Entry<BigDecimal, CrmCountry> entry : mapCountry.entrySet()) {
			if (entry.getValue().getCode().equals(countryCode)) {
				idCountry = entry.getValue().getId();
				break;
			}
		}
		handleCountryChange();
	}

	private void searchIdRegion(String regionCode) {
		idRegion = null;
		for (Map.Entry<BigDecimal, CrmRegion> entry : mapRegion.entrySet()) {
			if (entry.getValue().getCode().equals(regionCode)) {
				idRegion = entry.getValue().getId();
				break;
			}
		}
		handleRegionChange();
	}

	private void searchIdCity(String cityCode) {
		idCity = null;
		for (Map.Entry<BigDecimal, CrmCity> entry : mapCity.entrySet()) {
			String entryName = FacesUtil.removeCharacter(entry.getValue()
					.getName());
			String beanName = FacesUtil.removeCharacter(cityCode);
			if (entryName.equals(beanName)) {
				idCity = entry.getValue().getId();
				break;
			}
		}
	}

	public void searchAction() {
		String doc = selected.getDoc();
		selected = processService.getPatientByDoc(doc);
		exitSAP = false;
		if (selected.getId() == null) {
			selected.setDoc(doc);
			SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
			CrmProfile profile = FacesUtil.getCurrentUser().getCrmProfile();

			List<WSBean> customer = CustomerExecute.findByDoc(
					sap.getUrlCustomer2(), sap.getUsername(),
					sap.getPassword(), profile.getSociety(), selected.getDoc(),
					0);

			String message = null;
			if (customer.size() == 0) {
				message = FacesUtil.getMessage("pat_msg_no_exists");
				FacesUtil.addWarn(message);
			} else {
				exitSAP = true;
				WSBean bean = customer.get(0);
				selected.setCodeSap(bean.getCode());
				selected.setFirstnames(bean.getNames());
				selected.setAddress(bean.getAddress());
				selected.setPhoneNumber(bean.getTelephone1());

				try {
					searchIdCountry(bean.getCountry());
					searchIdRegion(bean.getRegion());
					searchIdCity(bean.getCity());
				} catch (Exception ex) {
					idCountry = null;
					idRegion = null;
					idCity = null;
				}

				message = FacesUtil.getMessage("pat_msg_exists_sap");
				FacesUtil.addWarn(message);
			}
			disabledSaveButton = false;
		} else {
			searchIdCountry(selected.getCountry());
			searchIdRegion(selected.getRegion());
			idCity = new BigDecimal(selected.getCity());
			disabledSaveButton = true;
		}
	}

	public void saveAction() {
		String message = null;
		try {
			SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
			CrmProfile profile = FacesUtil.getCurrentUser().getCrmProfile();

			List<WSBean> customer = new LinkedList<WSBean>();
			if (exitSAP || automatic) {
				customer = CustomerExecute.findByDoc(sap.getUrlCustomer2(),
						sap.getUsername(), sap.getPassword(),
						profile.getSociety(), selected.getDoc(), 0);
			}

			if (exitSAP || automatic || customer.size() == 0) {
				String names = null;

				names = selected.getFirstnames() + " " + selected.getSurnames();

				String tratamiento = "Señor";
				if (selected.getGender().equals("W")) {
					tratamiento = "Señora";
				}

				CrmCountry crmCountry = mapCountry.get(idCountry);
				CrmRegion crmRegion = mapRegion.get(idRegion);
				CrmCity crmCity = mapCity.get(idCity);

				if (automatic) {
					Long autonumeric = processService
							.getDocAutomatic(crmCountry.getCode());
					String doc = crmCountry.getCode()
							+ FacesUtil.lpad(autonumeric.toString(), '0', 8);
					selected.setDoc(doc);
				}

				String direccion = selected.getAddress();
				if (direccion.length() > 35) {
					direccion = direccion.substring(0, 34);
				}

				String codeSap = null;
				if (!exitSAP) {
					codeSap = CustomerExecute.excecute(
							sap.getUrlCustomerMaintainAll(), sap.getUsername(),
							sap.getPassword(), sap.getEnvironment(), "13",
							selected.getDoc(), tratamiento, names, direccion,
							selected.getZipCode(), selected.getPhoneNumber(),
							selected.getCellNumber(), selected.getEmail(),
							crmCountry.getCode(), crmCity.getName(),
							crmRegion.getCode(), "D001", profile.getSalesOrg(),
							profile.getDistrChan(), profile.getDivision(),
							profile.getSociety(), this.salesOff, "01",
							profile.getPaymentTerm(), profile.getAccount(),
							"01", "1", "1", crmCountry.getCurrencyIso());
				} else {
					codeSap = selected.getCodeSap();
				}

				if (!FacesUtil.isEmptyOrBlank(codeSap)) {

					selected.setCodeSap(codeSap);
					selected.setSalesOrg(profile.getSalesOrg());
					selected.setCountry(crmCountry.getCode());
					selected.setRegion(crmRegion.getCode());
					selected.setCity(crmCity.getCode());

					selected.setSendPhone(false);
					selected.setSendEmail(false);
					selected.setSendPostal(false);
					selected.setSendSms(false);

					for (String send : selectedSendOptions) {
						if (send.equals("1")) {
							selected.setSendPhone(true);
						} else if (send.equals("2")) {
							selected.setSendEmail(true);
						} else if (send.equals("3")) {
							selected.setSendPostal(true);
						} else if (send.equals("4")) {
							selected.setSendSms(true);
						}
					}

					selected.setIdUserCreate(FacesUtil.getCurrentIdUsuario());
					selected.setDateCreate(new Date());
					processService.savePatient(selected);

					disabledSaveButton = true;
					message = FacesUtil.getMessage("pat_msg_ok", codeSap);
					FacesUtil.addInfo(message);
				} else {
					message = FacesUtil.getMessage("msg_record_config");
					FacesUtil.addError(message);
				}
			} else {
				String field = FacesUtil.getMessage("pat");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						field);
				FacesUtil.addError(message);
			}
		} catch (Exception ex) {
			message = FacesUtil.getMessage("pat_msg_error_cnx");
			FacesUtil.addError(message);
		}
	}
}
