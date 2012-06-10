package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
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
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.execute.CustomerExecute;

@Named
@Scope("view")
public class PatientBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<Patient> list;
	private PatientDataModel model;
	private Patient selected;

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

	public PatientBacking() {
		newAction(null);
	}

	public List<Patient> getList() {
		return list;
	}

	public void setList(List<Patient> list) {
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

	public Patient getSelected() {
		return selected;
	}

	public void setSelected(Patient selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				listBranch.add(new SelectItem(row.getCode(), row.getName()));
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

	public void handleCountryChange() {
		CrmCountry crmCountry = mapCountry.get(idCountry);
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

		if (listRegion.size() == 0) {
			idCity = null;
		}
	}

	public void newAction(ActionEvent event) {
		optionSearchPatient = 1;
		selected = new Patient();
		disabledSaveButton = false;
	}

	public void saveAction() {
		String message = null;
		try {
			String customer = CustomerExecute.getCustomer(selected.getCode());

			if (customer.isEmpty()) {
				String names = null;

				names = selected.getNames() + " " + selected.getSurnames();

				SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
				CrmProfile profile = FacesUtil.getCurrentUser().getCrmProfile();

				String tratamiento = "1";
				if (selected.getGender().equals("W")) {
					tratamiento = "2";
				}

				CrmCountry crmCountry = mapCountry.get(idCountry);
				CrmRegion crmRegion = mapRegion.get(idRegion);
				CrmCity crmCity = mapCity.get(idCity);

				String SAPCode = CustomerExecute.excecute(sap.getEnvironment(),
						"13", selected.getCode(), tratamiento, names,
						selected.getAddress(), selected.getPhoneNumber(),
						selected.getCellNumber(), selected.getEmail(),
						crmCountry.getCode(), crmCity.getName(),
						crmRegion.getCode(), "D001", profile.getSalesOrg(),
						profile.getDistrChan(), profile.getDivision(),
						profile.getSociety(), this.salesOff, "01",
						profile.getPaymentTerm(), profile.getAccount());

				if (SAPCode != null) {
					selected.setSAPCode(SAPCode);
					disabledSaveButton = true;
					message = FacesUtil.getMessage("pat_msg_ok", SAPCode);
					FacesUtil.addInfo(message);
				} else {
					message = FacesUtil.getMessage("Error");
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
