package co.com.tactusoft.crm.view.backing;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmHistoryHistory;
import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmHistoryRecord;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;

@Named
@Scope("view")
public class HistoryBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private CrmHistoryHistory selectedHistoryHistory;
	private CrmHistoryRecord selectedHistoryRecord;
	private CrmHistoryPhysique selectedHistoryPhysique;
	private List<CrmAppointment> listAppointment;
	private AppointmentDataModel appointmentModel;
	private CrmAppointment selectedAppointment;
	private CrmPatient selected;

	private Boolean disabledSaveButton;

	public HistoryBacking() {
		newAction(null);
	}

	public CrmHistoryHistory getSelectedHistoryHistory() {
		return selectedHistoryHistory;
	}

	public void setSelectedHistoryHistory(
			CrmHistoryHistory selectedHistoryHistory) {
		this.selectedHistoryHistory = selectedHistoryHistory;
	}

	public CrmHistoryRecord getSelectedHistoryRecord() {
		return selectedHistoryRecord;
	}

	public void setSelectedHistoryRecord(CrmHistoryRecord selectedHistoryRecord) {
		this.selectedHistoryRecord = selectedHistoryRecord;
	}

	public CrmHistoryPhysique getSelectedHistoryPhysique() {
		return selectedHistoryPhysique;
	}

	public void setSelectedHistoryPhysique(
			CrmHistoryPhysique selectedHistoryPhysique) {
		this.selectedHistoryPhysique = selectedHistoryPhysique;
	}

	public List<CrmAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<CrmAppointment> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public AppointmentDataModel getAppointmentModel() {
		return appointmentModel;
	}

	public void setAppointmentModel(AppointmentDataModel appointmentModel) {
		this.appointmentModel = appointmentModel;
	}

	public CrmAppointment getSelectedAppointment() {
		return selectedAppointment;
	}

	public void setSelectedAppointment(CrmAppointment selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	public CrmPatient getSelected() {
		return selected;
	}

	public void setSelected(CrmPatient selected) {
		this.selected = selected;
	}

	public Boolean getDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(Boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public void newAction(ActionEvent event) {
		selectedHistoryRecord = new CrmHistoryRecord();
		selectedHistoryHistory = new CrmHistoryHistory();
		selectedHistoryPhysique = new CrmHistoryPhysique();
		listAppointment = new ArrayList<CrmAppointment>();
		appointmentModel = new AppointmentDataModel(listAppointment);
		selectedAppointment = new CrmAppointment();
		selected = new CrmPatient();
		selectedPatient = new CrmPatient();

		disabledSaveButton = true;
		optionSearchPatient = 1;
	}

	public void saveAction(ActionEvent event) {
		String message = null;
		selectedHistoryRecord.setIdPatient(selected.getId());
		int result = processService.saveHistoryRecord(selectedHistoryRecord);
		if (result == 0) {
			selectedHistoryHistory.setIdPatient(selected.getId());
			result = processService.saveHistoryHistory(selectedHistoryHistory);
			if (result == 0) {
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			}
		}
	}

	public void searchAction(ActionEvent event) {
		selected = processService.getPatientByCodeSap(selectedPatient
				.getCodeSap());
		listAppointment = processService.listAppointmentByPatient(
				selectedPatient.getCodeSap(), 3);
		appointmentModel = new AppointmentDataModel(listAppointment);

		selectedHistoryRecord = processService.getHistoryRecord(selected
				.getId());
		selectedHistoryHistory = processService.getHistoryHistory(selected
				.getId());
		selectedHistoryPhysique = processService.getHistoryPhysique(selected
				.getId());

		disabledSaveButton = false;
	}

	public boolean isReadOnlySelectedHistoryRecord() {
		return selectedHistoryRecord.getId() != null ? true : false;
	}

	public boolean isReadOnlySelectedHistoryHistory() {
		return selectedHistoryHistory.getId() != null ? true : false;
	}

	public boolean isReadOnlySelectedHistoryPhysique() {
		return selectedHistoryPhysique.getId() != null ? true : false;
	}

}
