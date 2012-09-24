package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.tactusoft.webservice.client.beans.WSBean;

import co.com.tactusoft.crm.model.entities.CrmCity;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("session")
public class ContactBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;
	private boolean disabledSaveButton;
	private boolean newRecord;
	private boolean automatic;

	private List<SelectItem> listDocType;
	private String docSearch;

	public ContactBacking() {
		newAction(null);
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

	public String getDocSearch() {
		return docSearch;
	}

	public void setDocSearch(String docSearch) {
		this.docSearch = docSearch;
	}

	public void newAction(ActionEvent event) {
		selectedPatient = new CrmPatient();
		optionSearchPatient = 1;
		selectedPatient.setCrmProfile(new CrmProfile());
		selectedPatient.setGender("-1");
		selectedPatient.setCycle(false);
		disabledSaveButton = false;
		newRecord = true;
	}

	public void saveAction() {
		String message = null;
		CrmCountry crmCountry = mapCountry.get(idCountry);
		CrmRegion crmRegion = mapRegion.get(idRegion);
		CrmCity crmCity = mapCity.get(idCity);
		CrmProfile profile = mapProfile.get(selectedPatient.getCrmProfile()
				.getId());

		selectedPatient.setSalesOrg(profile.getSalesOrg());
		selectedPatient.setCountry(crmCountry.getCode());
		selectedPatient.setRegion(crmRegion.getCode());
		selectedPatient.setCity(crmCity.getCode());

		String docType = selectedPatient.getDocType();
		if (automatic) {
			docType = crmCountry.getDefaultDocType();
		}
		selectedPatient.setDocType(docType);

		if (newRecord) {
			selectedPatient
					.setCrmUserByIdUserCreate(FacesUtil.getCurrentUser());
			selectedPatient.setDateCreate(new Date());
		} else {
			selectedPatient.setCrmUserByIdUserModified(FacesUtil
					.getCurrentUser());
			selectedPatient.setDateModified(new Date());
		}

		try {
			processService.savePatient(selectedPatient, automatic && newRecord,
					false);
			message = FacesUtil.getMessage("con_msg_update_ok",
					selectedPatient.getDoc());
			FacesUtil.addInfo(message);
			disabledSaveButton = true;
			newRecord = false;
		} catch (Exception ex) {
			String field = FacesUtil.getMessage("con");
			message = FacesUtil
					.getMessage("msg_record_unique_exception", field);
			FacesUtil.addError(message);
		}
	}

	public void searchAction(ActionEvent event) {

	}

	@Override
	public void handleCountryChange() {
		if (idCountry != null) {
			CrmCountry crmCountry = mapCountry.get(idCountry);
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

}
