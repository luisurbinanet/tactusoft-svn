package co.com.tactusoft.crm.view.backing;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmHistoryHistory;
import co.com.tactusoft.crm.model.entities.CrmHistoryHomeopathic;
import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmHistoryRecord;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;

@Named
@Scope("view")
public class HistoryBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private CrmHistoryHistory selectedHistoryHistory;
	private CrmHistoryRecord selectedHistoryRecord;
	private CrmHistoryHomeopathic selectedHistoryHomeopathic;
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

	public CrmHistoryHomeopathic getSelectedHistoryHomeopathic() {
		return selectedHistoryHomeopathic;
	}

	public void setSelectedHistoryHomeopathic(
			CrmHistoryHomeopathic selectedHistoryHomeopathic) {
		this.selectedHistoryHomeopathic = selectedHistoryHomeopathic;
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

	public boolean isReadOnlySelectedHistoryHistory() {
		return selectedHistoryHistory.getId() != null ? true : false;
	}

	public boolean isReadOnlySelectedHistoryRecord() {
		return selectedHistoryRecord.getId() != null ? true : false;
	}

	public boolean isReadOnlySelectedHistoryHomeopathic() {
		return selectedHistoryHomeopathic.getId() != null ? true : false;
	}

	public boolean isReadOnlySelectedHistoryPhysique() {
		return selectedHistoryPhysique.getId() != null ? true : false;
	}

	public void newAction(ActionEvent event) {
		selectedHistoryHistory = new CrmHistoryHistory();
		selectedHistoryRecord = new CrmHistoryRecord();
		selectedHistoryHomeopathic = new CrmHistoryHomeopathic();
		selectedHistoryPhysique = new CrmHistoryPhysique();

		listAppointment = new ArrayList<CrmAppointment>();
		appointmentModel = new AppointmentDataModel(listAppointment);
		selectedAppointment = new CrmAppointment();
		selected = new CrmPatient();
		selectedPatient = new CrmPatient();

		disabledSaveButton = true;
		optionSearchPatient = 1;
	}

	public void searchAction(ActionEvent event) {
		selected = processService.getPatientByCodeSap(selectedPatient
				.getCodeSap());

		listAppointment = processService.listAppointmentByPatient(
				selectedPatient.getCodeSap(), 3);
		appointmentModel = new AppointmentDataModel(listAppointment);

		selectedHistoryHistory = processService.getHistoryHistory(selected
				.getId());
		selectedHistoryRecord = processService.getHistoryRecord(selected
				.getId());
		selectedHistoryHomeopathic = processService
				.getHistoryHomeopathic(selected.getId());

		getRenderedRecord();

		if (selected.getId() == null) {
			disabledSaveButton = true;
		} else {
			disabledSaveButton = false;
		}
	}

	public void saveAction(ActionEvent event) {
		String field = null;
		String message = null;

		if (selected == null || selected.getId() == null) {
			message = FacesUtil.getMessage("his_msg_error_1");
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selected.getOccupation())) {
			field = FacesUtil.getMessage("pat_occupation");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selected.getNeighborhood())) {
			field = FacesUtil.getMessage("pat_neighborhood");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selected.getTypeHousing().equals(Constant.DEFAULT_VALUE_STRING)) {
			field = FacesUtil.getMessage("pat_type_housing");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getReason())) {
			field = FacesUtil.getMessage("his_history_reason");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getDisease())) {
			field = FacesUtil.getMessage("his_history_disease");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getResults())) {
			field = FacesUtil.getMessage("his_history_results");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (message == null) {
			int result = processService.savePatient(selected);
			if (result == 0) {
				selectedHistoryHistory.setCrmPatient(selected);
				result = processService
						.saveHistoryHistory(selectedHistoryHistory);
				if (result == 0) {
					selectedHistoryRecord.setCrmPatient(selected);
					result = processService
							.saveHistoryRecord(selectedHistoryRecord);
					if (result == 0) {
						message = FacesUtil.getMessage("msg_record_ok");
						FacesUtil.addInfo(message);
					} else {

					}
				} else {

				}
			}
		}
	}

	public int getRenderedRecord() {
		int result = 0;
		if (selected.getId() == null) {
			result = 0;
		} else {
			if (selected.getAge() <= 5) {
				result = 1;
			} else {
				if (selected.getGender().equals("W")) {
					result = 2;
				} else {
					result = 3;
				}
			}
		}
		return result;
	}

}
