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

	private boolean readOnlySelectedHistoryHistory;
	private boolean readOnlySelectedHistoryRecord;
	private boolean readOnlySelectedHistoryHomeopathic;
	private boolean readOnlySelectedHistoryPhysique;

	private double imc;
	private String descImc;

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
		return readOnlySelectedHistoryHistory;
	}

	public void setReadOnlySelectedHistoryHistory(
			boolean readOnlySelectedHistoryHistory) {
		this.readOnlySelectedHistoryHistory = readOnlySelectedHistoryHistory;
	}

	public boolean isReadOnlySelectedHistoryRecord() {
		return readOnlySelectedHistoryRecord;
	}

	public void setReadOnlySelectedHistoryRecord(
			boolean readOnlySelectedHistoryRecord) {
		this.readOnlySelectedHistoryRecord = readOnlySelectedHistoryRecord;
	}

	public boolean isReadOnlySelectedHistoryHomeopathic() {
		return readOnlySelectedHistoryHomeopathic;
	}

	public void setReadOnlySelectedHistoryHomeopathic(
			boolean readOnlySelectedHistoryHomeopathic) {
		this.readOnlySelectedHistoryHomeopathic = readOnlySelectedHistoryHomeopathic;
	}

	public boolean isReadOnlySelectedHistoryPhysique() {
		return readOnlySelectedHistoryPhysique;
	}

	public void setReadOnlySelectedHistoryPhysique(
			boolean readOnlySelectedHistoryPhysique) {
		this.readOnlySelectedHistoryPhysique = readOnlySelectedHistoryPhysique;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public String getDescImc() {
		return descImc;
	}

	public void setDescImc(String descImc) {
		this.descImc = descImc;
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

		readOnlySelectedHistoryHistory = true;
		readOnlySelectedHistoryRecord = true;
		readOnlySelectedHistoryHomeopathic = true;
		readOnlySelectedHistoryPhysique = true;
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
		selectedHistoryPhysique = processService.getHistoryPhysique(selected
				.getId());

		getRenderedRecord();

		if (selected.getId() == null) {
			disabledSaveButton = true;
		} else {
			disabledSaveButton = false;
		}

		readOnlySelectedHistoryHistory = selectedHistoryHistory.getId() != null ? true
				: false;
		readOnlySelectedHistoryRecord = selectedHistoryRecord.getId() != null ? true
				: false;
		readOnlySelectedHistoryHomeopathic = selectedHistoryHomeopathic.getId() != null ? true
				: false;
		readOnlySelectedHistoryPhysique = selectedHistoryPhysique.getId() != null ? true
				: false;
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
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selected.getNeighborhood())) {
			field = FacesUtil.getMessage("pat_neighborhood");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selected.getTypeHousing().equals(Constant.DEFAULT_VALUE_STRING)) {
			field = FacesUtil.getMessage("pat_type_housing");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getReason())) {
			field = FacesUtil.getMessage("his_history_reason");
			message = FacesUtil.getMessage("his_history_history");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getDisease())) {
			field = FacesUtil.getMessage("his_history_disease");
			message = FacesUtil.getMessage("his_history_history");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getResults())) {
			field = FacesUtil.getMessage("his_history_results");
			message = FacesUtil.getMessage("his_history_history");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getArthritis()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getArthritisTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getArthritisMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_arthritis");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getCancer()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getCancerTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getCancerMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_cancer");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getPulmonary()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getPulmonaryTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getPulmonaryMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_pulmonary");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getDiabetes()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getDiabetesTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getDiabetesMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_diabetes");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getHypertension()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getHypertensionTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getHypertensionMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_hypertension");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getHospitalizations()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getHospitalizationsTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getHospitalizationsMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_hospitalizations");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getAllergy()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getAllergyTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getAllergyMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_allergy");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getInfections()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getInfectionsTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getInfectionsMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_infections");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryPhysique.getHeartRate() == 0) {
			field = FacesUtil.getMessage("his_physique_heart_rate");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryPhysique.getRespiratoryRate() == 0) {
			field = FacesUtil.getMessage("his_physique_respiratory_rate");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryPhysique.getHeight().intValue() == 0) {
			field = FacesUtil.getMessage("his_physique_height");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryPhysique.getWeight().intValue() == 0) {
			field = FacesUtil.getMessage("his_physique_weight");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil
				.isEmptyOrBlank(selectedHistoryPhysique.getBloodPressure())) {
			field = FacesUtil.getMessage("his_physique_blood_pressure");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (message == null) {

			selectedHistoryHistory.setCrmPatient(selected);
			selectedHistoryRecord.setCrmPatient(selected);
			selectedHistoryHomeopathic.setCrmPatient(selected);
			selectedHistoryPhysique.setCrmPatient(selected);

			int result = processService.savePatient(selected);
			if (result == 0) {
				result = processService
						.saveHistoryHistory(selectedHistoryHistory);
				if (result == 0) {
					result = processService
							.saveHistoryRecord(selectedHistoryRecord);
					if (result == 0) {
						result = processService
								.saveHistoryHomeopathic(selectedHistoryHomeopathic);
						if (result == 0) {
							result = processService
									.saveHistoryPhysique(selectedHistoryPhysique);
							if (result == 0) {
								message = FacesUtil.getMessage("msg_record_ok");
								FacesUtil.addInfo(message);
							} else {

							}
						} else {

						}
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

	public void calculateIMC() {
		/*double weight = selectedHistoryPhysique.getWeight().doubleValue();
		double height = selectedHistoryPhysique.getHeight().doubleValue() / 100;

		if (height > 0) {
			imc = weight / (height * height);
		} else {
			imc = 0;
		}*/
	}

}
