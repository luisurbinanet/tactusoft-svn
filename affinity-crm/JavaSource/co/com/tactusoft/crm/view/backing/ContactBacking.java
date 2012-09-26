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

import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;

@Named
@Scope("session")
public class ContactBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;
	private boolean disabledSaveButton;
	private boolean newRecord;
	private boolean automatic;

	private List<SelectItem> listDocType;
	private CrmPatient tmpSelectedPatient;

	private List<String> selectedSendOptions;

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

	public CrmPatient getTmpSelectedPatient() {
		return tmpSelectedPatient;
	}

	public void setTmpSelectedPatient(CrmPatient tmpSelectedPatient) {
		this.tmpSelectedPatient = tmpSelectedPatient;
	}

	public List<String> getSelectedSendOptions() {
		return selectedSendOptions;
	}

	public void setSelectedSendOptions(List<String> selectedSendOptions) {
		this.selectedSendOptions = selectedSendOptions;
	}

	public void newAction(ActionEvent event) {
		selectedPatient = new CrmPatient();
		selectedPatient.setCrmProfile(new CrmProfile());
		selectedPatient.setGender("-1");
		selectedPatient.setCycle(false);
		disabledSaveButton = false;
		newRecord = true;

		// Busquedas
		optionSearchPatient = 1;
		docPatient = null;
		namePatient = null;
		patientModel = new PatientDataModel();
	}

	public void saveAction() {
		String message = null;
		CrmCountry crmCountry = mapCountry.get(selectedPatient.getIdCountry());
		CrmProfile profile = mapProfile.get(selectedPatient.getCrmProfile()
				.getId());

		selectedPatient.setFirstnames(selectedPatient.getFirstnames()
				.toUpperCase());
		selectedPatient
				.setSurnames(selectedPatient.getSurnames().toUpperCase());
		selectedPatient.setSalesOrg(profile.getSalesOrg());

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

		if (FacesUtil.isEmptyOrBlank(selectedPatient.getDoc())) {
			selectedPatient.setDoc(null);
		}
		selectedPatient.setCodeSap(selectedPatient.getDoc());

		if (FacesUtil.isEmptyOrBlank(selectedPatient.getDocType())) {
			selectedPatient.setDocType(null);
		}

		try {
			processService.savePatient(selectedPatient, automatic && newRecord,
					false, crmCountry.getCode());
			message = FacesUtil.getMessage("con_msg_update_ok",
					selectedPatient.getNames());
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

	public void refreshSearchAction(ActionEvent event) {
		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		tmpSelectedPatient = new CrmPatient();
		optionSearchPatient = 1;
		docPatient = null;
		namePatient = null;
		disabledAddPatient = true;
	}

	public void searchAction(ActionEvent event) {
		listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		tmpSelectedPatient = new CrmPatient();
		if (optionSearchPatient == 1) {
			tmpSelectedPatient = processService.getContactByDoc(docPatient);
			if (tmpSelectedPatient.getId() != null) {
				listPatient.add(tmpSelectedPatient);
				patientModel = new PatientDataModel(listPatient);
				disabledAddPatient = false;
			}
		} else {
			listPatient = processService.getContactByName(namePatient
					.toUpperCase());
			patientModel = new PatientDataModel(listPatient);
			if (listPatient.size() > 0) {
				tmpSelectedPatient = listPatient.get(0);
				disabledAddPatient = false;
			}
		}
	}

	public void updateAction(ActionEvent event) {
		newAction(null);
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

	public void addContactAction(ActionEvent event) {
		selectedPatient = tmpSelectedPatient;
		newRecord = false;
	}

	public String goAppointment() {
		AppointmentBacking appointmentBacking = FacesUtil
				.findBean("appointmentBacking");
		appointmentBacking.setSelectedPatient(selectedPatient);
		return "/pages/processes/appointment.jsf?faces-redirect=true";
	}

}
