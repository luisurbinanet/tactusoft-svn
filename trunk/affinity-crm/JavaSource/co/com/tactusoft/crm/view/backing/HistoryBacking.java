package co.com.tactusoft.crm.view.backing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.DateSelectEvent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmHistoryHistory;
import co.com.tactusoft.crm.model.entities.CrmHistoryHomeopathic;
import co.com.tactusoft.crm.model.entities.CrmHistoryOrganometry;
import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmHistoryRecord;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;

@Named
@Scope("session")
public class HistoryBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private CrmHistoryHistory selectedHistoryHistory;
	private CrmHistoryRecord selectedHistoryRecord;
	private CrmHistoryHomeopathic selectedHistoryHomeopathic;
	private CrmHistoryPhysique selectedHistoryPhysique;
	private CrmHistoryOrganometry selectedHistoryOrganometry;

	private List<CrmAppointment> listAppointment;
	private AppointmentDataModel appointmentModel;
	private CrmAppointment selectedAppointment;

	private Boolean disabledSaveButton;

	private boolean readOnlySelectedHistoryHistory;
	private boolean readOnlySelectedHistoryRecord;
	private boolean readOnlySelectedHistoryHomeopathic;
	private boolean readOnlySelectedHistoryPhysique;
	private boolean readOnlySelectedHistoryOrganometry;

	public int age;
	private double imc;
	private String descImc;

	private Date maxDate;

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

	public CrmHistoryOrganometry getSelectedHistoryOrganometry() {
		return selectedHistoryOrganometry;
	}

	public void setSelectedHistoryOrganometry(
			CrmHistoryOrganometry selectedHistoryOrganometry) {
		this.selectedHistoryOrganometry = selectedHistoryOrganometry;
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

	public boolean isReadOnlySelectedHistoryOrganometry() {
		return readOnlySelectedHistoryOrganometry;
	}

	public void setReadOnlySelectedHistoryOrganometry(
			boolean readOnlySelectedHistoryOrganometry) {
		this.readOnlySelectedHistoryOrganometry = readOnlySelectedHistoryOrganometry;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public void newAction(ActionEvent event) {
		selectedHistoryHistory = new CrmHistoryHistory();
		selectedHistoryRecord = new CrmHistoryRecord();
		selectedHistoryHomeopathic = new CrmHistoryHomeopathic();
		selectedHistoryPhysique = new CrmHistoryPhysique();
		selectedHistoryOrganometry = new CrmHistoryOrganometry();

		listAppointment = new ArrayList<CrmAppointment>();
		appointmentModel = new AppointmentDataModel(listAppointment);
		selectedAppointment = new CrmAppointment();

		selectedPatient = new CrmPatient();
		selectedPatient.setCrmOccupation(new CrmOccupation());
		selectedPatient.getCrmOccupation().setId(Constant.DEFAULT_VALUE);

		disabledSaveButton = true;
		optionSearchPatient = 1;
		age = 0;

		readOnlySelectedHistoryHistory = true;
		readOnlySelectedHistoryRecord = true;
		readOnlySelectedHistoryHomeopathic = true;
		readOnlySelectedHistoryPhysique = true;
		readOnlySelectedHistoryOrganometry = true;

		maxDate = new Date();
	}

	public void searchAction(ActionEvent event) {
		String message = null;

		if (selectedPatient == null
				|| FacesUtil.isEmptyOrBlank(selectedPatient.getCodeSap())) {
			message = FacesUtil.getMessage("his_msg_error_1");
			FacesUtil.addError(message);
		} else {

			if (selectedPatient.getCrmOccupation() == null) {
				selectedPatient.setCrmOccupation(new CrmOccupation());
			}

			listAppointment = processService.listAppointmentByPatient(
					selectedPatient.getCodeSap(), 3);
			appointmentModel = new AppointmentDataModel(listAppointment);

			selectedHistoryHistory = processService
					.getHistoryHistory(selectedPatient.getId());
			selectedHistoryRecord = processService
					.getHistoryRecord(selectedPatient.getId());
			selectedHistoryHomeopathic = processService
					.getHistoryHomeopathic(selectedPatient.getId());
			selectedHistoryPhysique = processService
					.getHistoryPhysique(selectedPatient.getId());
			selectedHistoryOrganometry = processService
					.getHistoryOrganometry(selectedPatient.getId());

			getRenderedRecord();

			if (selectedPatient.getId() == null) {
				disabledSaveButton = true;
			} else {
				disabledSaveButton = false;
			}

			readOnlySelectedHistoryHistory = selectedHistoryHistory.getId() != null ? true
					: false;
			readOnlySelectedHistoryRecord = selectedHistoryRecord.getId() != null ? true
					: false;
			readOnlySelectedHistoryHomeopathic = selectedHistoryHomeopathic
					.getId() != null ? true : false;
			readOnlySelectedHistoryPhysique = selectedHistoryPhysique.getId() != null ? true
					: false;
			readOnlySelectedHistoryOrganometry = selectedHistoryOrganometry
					.getId() != null ? true : false;
		}
	}

	public void saveAction(ActionEvent event) {
		String field = null;
		String message = null;

		if (selectedPatient == null || selectedPatient.getId() == null) {
			message = FacesUtil.getMessage("his_msg_error_1");
			FacesUtil.addError(message);
		}

		if (selectedPatient.getBornDate() == null) {
			field = FacesUtil.getMessage("pat_born_date");
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

		if (selectedHistoryOrganometry.getOrganometryCheck()) {
			if (FacesUtil.isEmptyOrBlank(selectedHistoryOrganometry
					.getOrganometryAnalysis())) {
				field = FacesUtil.getMessage("his_organometry_analysis");
				message = FacesUtil.getMessage("his_organometry", field);
				message = message + " - "
						+ FacesUtil.getMessage("glb_required", field);
				FacesUtil.addError(message);
			}
		}

		if (message == null) {

			selectedHistoryHistory.setCrmPatient(selectedPatient);
			selectedHistoryRecord.setCrmPatient(selectedPatient);
			selectedHistoryHomeopathic.setCrmPatient(selectedPatient);
			selectedHistoryPhysique.setCrmPatient(selectedPatient);
			selectedHistoryOrganometry.setCrmPatient(selectedPatient);

			int result = processService.savePatient(selectedPatient);
			if (result == 0) {

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getHead())) {
					selectedHistoryHistory.setHead(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory
						.getNeuromuscular())) {
					selectedHistoryHistory
							.setNeuromuscular(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getOrl())) {
					selectedHistoryHistory.setOrl(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getGu())) {
					selectedHistoryHistory.setGu(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getCr())) {
					selectedHistoryHistory.setCr(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory
						.getPsychiatric())) {
					selectedHistoryHistory
							.setPsychiatric(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getGi())) {
					selectedHistoryHistory.setGi(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getSkin())) {
					selectedHistoryHistory.setSkin(Constant.HISTORY_NOT_REFER);
				}

				// HOMEOPATHIC
				if (FacesUtil.isEmptyOrBlank(selectedHistoryHomeopathic
						.getMental())) {
					selectedHistoryHomeopathic
							.setMental(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHomeopathic
						.getSpecial())) {
					selectedHistoryHomeopathic
							.setSpecial(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHomeopathic
						.getGeneral())) {
					selectedHistoryHomeopathic
							.setGeneral(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHomeopathic
						.getMiasm())) {
					selectedHistoryHomeopathic
							.setMiasm(Constant.HISTORY_NOT_REFER);
				}

				// PHYSIQUE
				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getGeneralState())) {
					selectedHistoryPhysique
							.setGeneralState(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getHeadNeck())) {
					selectedHistoryPhysique
							.setHeadNeck(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getChest())) {
					selectedHistoryPhysique
							.setChest(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getLungs())) {
					selectedHistoryPhysique
							.setLungs(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getHeart())) {
					selectedHistoryPhysique
							.setHeart(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getAbdomen())) {
					selectedHistoryPhysique
							.setAbdomen(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getGenitals())) {
					selectedHistoryPhysique
							.setGenitals(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getOsteo())) {
					selectedHistoryPhysique
							.setOsteo(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getTips())) {
					selectedHistoryPhysique.setTips(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getHighlights())) {
					selectedHistoryPhysique
							.setGeneralState(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getSkin())) {
					selectedHistoryPhysique.setSkin(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getObs())) {
					selectedHistoryPhysique.setObs(Constant.HISTORY_NOT_REFER);
				}

				if (selectedHistoryOrganometry.getOrganometryCheck()) {

				}

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
								result = processService
										.saveHistoryOrganometry(selectedHistoryOrganometry);
								if (result == 0) {
									message = FacesUtil
											.getMessage("msg_record_ok");
									FacesUtil.addInfo(message);
								} else {

								}
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
		if (selectedPatient == null) {
			result = 0;
		} else if (selectedPatient.getId() == null) {
			result = 0;
		} else {
			if (selectedPatient.getAge() <= 5) {
				result = 1;
			} else {
				if (selectedPatient.getGender().equals("W")) {
					result = 2;
				} else {
					result = 3;
				}
			}
		}
		return result;
	}

	public void calculateIMC() {
		double weight = selectedHistoryPhysique.getWeight().doubleValue();
		double height = selectedHistoryPhysique.getHeight().doubleValue() / 100;

		if (height > 0) {
			imc = weight / (height * height);
		} else {
			imc = 0;
		}

		descImc = "Prueba";
	}

	public void handleBornDateSelect(DateSelectEvent event) {
		Date bornDate = event.getDate();
		age = calculateAge(bornDate);
	}

	private int calculateAge(Date bornDate) {
		int age = 0;
		if (bornDate != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(bornDate);

			Calendar currentDate = Calendar.getInstance();
			currentDate.setTime(new Date());

			age = currentDate.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);

			if ((calendar.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))
					|| (calendar.get(Calendar.MONTH) == currentDate
							.get(Calendar.MONTH) && calendar
							.get(Calendar.DAY_OF_MONTH) > currentDate
							.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		}
		return age;
	}

}
