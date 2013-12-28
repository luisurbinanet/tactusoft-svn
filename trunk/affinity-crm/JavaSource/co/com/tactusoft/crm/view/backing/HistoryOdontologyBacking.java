package co.com.tactusoft.crm.view.backing;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import net.sf.jasperreports.engine.JRException;

import org.springframework.context.annotation.Scope;

import com.tactusoft.webservice.client.beans.WSBean;

import co.com.tactusoft.crm.controller.bo.GenerateFormulaPDF;
import co.com.tactusoft.crm.model.entities.CrmCie;
import co.com.tactusoft.crm.model.entities.CrmDiagnosis;
import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmMaterialGroup;
import co.com.tactusoft.crm.model.entities.CrmMedication;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmOdontologyEvolution;
import co.com.tactusoft.crm.model.entities.CrmOdontologyOdontogram;
import co.com.tactusoft.crm.model.entities.CrmOdontologyPeriodontal;
import co.com.tactusoft.crm.model.entities.CrmOdontologySoftTissue;
import co.com.tactusoft.crm.model.entities.CrmOdontologyStomatolog;
import co.com.tactusoft.crm.model.entities.CrmOdontologySupplExams;
import co.com.tactusoft.crm.model.entities.CrmOdontologyTempJoint;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.DiagnosisDataModel;
import co.com.tactusoft.crm.view.datamodel.MedicationDataModel;
import co.com.tactusoft.crm.view.datamodel.WSBeanDataModel;

@Named
@Scope("session")
public class HistoryOdontologyBacking extends HistoryBacking {

	private static final long serialVersionUID = 1L;

	private CrmHistoryPhysique crmHistoryPhysique;
	private CrmOdontologyStomatolog crmOdontologyStomatolog;
	private CrmOdontologyTempJoint crmOdontologyTempJoint;
	private CrmOdontologySoftTissue crmOdontologySoftTissue;
	private CrmOdontologyPeriodontal crmOdontologyPeriodontal;
	private CrmOdontologySupplExams crmOdontologySupplExams;
	private CrmOdontologyEvolution crmOdontologyEvolution;
	private CrmOdontologyOdontogram crmOdontologyOdontogram;

	public HistoryOdontologyBacking() {

	}

	public CrmHistoryPhysique getCrmHistoryPhysique() {
		return crmHistoryPhysique;
	}

	public void setCrmHistoryPhysique(CrmHistoryPhysique crmHistoryPhysique) {
		this.crmHistoryPhysique = crmHistoryPhysique;
	}

	public CrmOdontologyStomatolog getCrmOdontologyStomatolog() {
		return crmOdontologyStomatolog;
	}

	public void setCrmOdontologyStomatolog(
			CrmOdontologyStomatolog crmOdontologyStomatolog) {
		this.crmOdontologyStomatolog = crmOdontologyStomatolog;
	}

	public CrmOdontologyTempJoint getCrmOdontologyTempJoint() {
		return crmOdontologyTempJoint;
	}

	public void setCrmOdontologyTempJoint(
			CrmOdontologyTempJoint crmOdontologyTempJoint) {
		this.crmOdontologyTempJoint = crmOdontologyTempJoint;
	}

	public CrmOdontologySoftTissue getCrmOdontologySoftTissue() {
		return crmOdontologySoftTissue;
	}

	public void setCrmOdontologySoftTissue(
			CrmOdontologySoftTissue crmOdontologySoftTissue) {
		this.crmOdontologySoftTissue = crmOdontologySoftTissue;
	}

	public CrmOdontologyPeriodontal getCrmOdontologyPeriodontal() {
		return crmOdontologyPeriodontal;
	}

	public void setCrmOdontologyPeriodontal(
			CrmOdontologyPeriodontal crmOdontologyPeriodontal) {
		this.crmOdontologyPeriodontal = crmOdontologyPeriodontal;
	}

	public CrmOdontologySupplExams getCrmOdontologySupplExams() {
		return crmOdontologySupplExams;
	}

	public void setCrmOdontologySupplExams(
			CrmOdontologySupplExams crmOdontologySupplExams) {
		this.crmOdontologySupplExams = crmOdontologySupplExams;
	}

	public CrmOdontologyEvolution getCrmOdontologyEvolution() {
		return crmOdontologyEvolution;
	}

	public void setCrmOdontologyEvolution(
			CrmOdontologyEvolution crmOdontologyEvolution) {
		this.crmOdontologyEvolution = crmOdontologyEvolution;
	}

	public CrmOdontologyOdontogram getCrmOdontologyOdontogram() {
		return crmOdontologyOdontogram;
	}

	public void setCrmOdontologyOdontogram(
			CrmOdontologyOdontogram crmOdontologyOdontogram) {
		this.crmOdontologyOdontogram = crmOdontologyOdontogram;
	}

	public void loadValues(VwAppointment vwAppointment) {
		this.selectedAppointment = vwAppointment;
		modeEdit = true;
		modeHistorial = false;
		part = Constant.HISTORY_HISTORY;
		activeIndex = -1;
		age = 0;
		imc = 0;
		descImc = null;

		newAction(null);

		currentAppointment = processService.getAppointment(selectedAppointment
				.getId());

		selectedPatient = processService.getContactById(selectedAppointment
				.getPatId());

		refreshLists();

		if (selectedPatient.getCrmOccupation() == null) {
			selectedPatient.setCrmOccupation(new CrmOccupation());
			idOccupation = null;
		} else {
			idOccupation = selectedPatient.getCrmOccupation().getId();
		}

		neighborhood = selectedPatient.getNeighborhood();
		typeHousing = selectedPatient.getTypeHousing();

		if (selectedPatient.getBornDate() != null) {
			age = calculateAge(selectedPatient.getBornDate());
		}

		idMembershipType = selectedPatient.getIdMemberShip();

		listDiagnosis = processService
				.getListDiagnosisByAppointment(currentAppointment.getId());
		diagnosisModel = new DiagnosisDataModel(listDiagnosis);

		listMedication = processService.getListMedicationByAppointment(
				currentAppointment.getId(), Constant.MATERIAL_TYPE_ODONTOLOGY);
		medicationModel = new MedicationDataModel(listMedication);

		selectedHistoryHistory = processService
				.getHistoryHistory(selectedAppointment.getId());
		selectedHistoryHistory.setCrmPatient(selectedPatient);
		selectedHistoryHistory.setCrmAppointment(currentAppointment);

		selectedHistoryRecord = processService
				.getHistoryRecord(selectedAppointment.getId());
		selectedHistoryRecord.setCrmPatient(selectedPatient);
		selectedHistoryRecord.setCrmAppointment(currentAppointment);

		selectedHistoryPhysique = processService
				.getHistoryPhysique(selectedAppointment.getId());
		selectedHistoryPhysique.setCrmPatient(selectedPatient);
		selectedHistoryPhysique.setCrmAppointment(currentAppointment);

		crmOdontologyStomatolog = processService
				.getOdontologyStomatolog(selectedAppointment.getId());
		crmOdontologyStomatolog.setCrmAppointment(currentAppointment);

		crmOdontologyTempJoint = processService
				.getOdontologyTempJoint(selectedAppointment.getId());
		crmOdontologyTempJoint.setCrmAppointment(currentAppointment);

		crmOdontologySoftTissue = processService
				.getOdontologySoftTissue(selectedAppointment.getId());
		crmOdontologySoftTissue.setCrmAppointment(currentAppointment);

		crmOdontologyPeriodontal = processService
				.getOdontologyPeriodontal(selectedAppointment.getId());
		crmOdontologyPeriodontal.setCrmAppointment(currentAppointment);

		crmOdontologySupplExams = processService
				.getOdontologySupplExams(selectedAppointment.getId());
		crmOdontologySupplExams.setCrmAppointment(currentAppointment);

		crmOdontologyEvolution = processService
				.getOdontologyEvolution(selectedAppointment.getId());
		crmOdontologyEvolution.setCrmAppointment(currentAppointment);

		crmOdontologyOdontogram = processService
				.getOdontologyOdontogram(selectedAppointment.getId());
		crmOdontologyOdontogram.setCrmAppointment(currentAppointment);

		try {
			this.heartRate = Integer.parseInt(selectedHistoryPhysique
					.getHeartRate());
		} catch (Exception ex) {
			this.heartRate = 0;
		}

		try {
			this.respiratoryRate = Integer.parseInt(selectedHistoryPhysique
					.getRespiratoryRate());
		} catch (Exception ex) {
			this.respiratoryRate = 0;
		}

		try {
			this.weight = Double.parseDouble(selectedHistoryPhysique
					.getWeight());
		} catch (Exception ex) {
			this.weight = 0d;
		}

		try {
			this.height = Double.parseDouble(selectedHistoryPhysique
					.getHeight());
		} catch (Exception ex) {
			this.height = 0d;
		}

		crmOdontologyStomatolog = processService
				.getOdontologyStomatolog(selectedAppointment.getId());
		crmOdontologyStomatolog.setCrmAppointment(currentAppointment);
	}

	@Override
	public void closeAppointmentAction(ActionEvent event) {
		String message = null;
		String field = null;

		if (selectedPatient.getBornDate() == null) {
			field = FacesUtil.getMessage("pat_born_date");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		}

		if (idOccupation == null || idOccupation.intValue() == 0) {
			field = FacesUtil.getMessage("pat_occupation");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setCrmOccupation(mapOccupation.get(idOccupation));
		}

		if (FacesUtil.isEmptyOrBlank(neighborhood)) {
			field = FacesUtil.getMessage("pat_neighborhood");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setNeighborhood(neighborhood);
		}

		if (FacesUtil.isEmptyOrBlank(typeHousing)) {
			field = FacesUtil.getMessage("pat_type_housing");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setTypeHousing(typeHousing);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getReason())) {
			field = FacesUtil.getMessage("his_history_reason");
			message = FacesUtil.getMessage("his_history_history");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getDisease())) {
			field = FacesUtil.getMessage("his_history_disease");
			message = FacesUtil.getMessage("his_history_history");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
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
			FacesUtil.addWarn(message);
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
			FacesUtil.addWarn(message);
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
			FacesUtil.addWarn(message);
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
			FacesUtil.addWarn(message);
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
			FacesUtil.addWarn(message);
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
			FacesUtil.addWarn(message);
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
			FacesUtil.addWarn(message);
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
			FacesUtil.addWarn(message);
		}

		if (this.getHeartRate() == 0) {
			field = FacesUtil.getMessage("his_physique_heart_rate");
			message = FacesUtil.getMessage("his_general_findings", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedHistoryPhysique
					.setHeartRate(String.valueOf(this.heartRate));
		}

		if (this.getRespiratoryRate() == 0) {
			field = FacesUtil.getMessage("his_physique_respiratory_rate");
			message = FacesUtil.getMessage("his_general_findings", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedHistoryPhysique.setRespiratoryRate(String
					.valueOf(this.respiratoryRate));
		}

		if (FacesUtil
				.isEmptyOrBlank(selectedHistoryPhysique.getBloodPressure())) {
			field = FacesUtil.getMessage("his_physique_blood_pressure");
			message = FacesUtil.getMessage("his_general_findings", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		}

		if (message == null) {
			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getObs())) {
				selectedHistoryPhysique.setObs(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getObs())) {
				selectedHistoryPhysique.setObs(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologyStomatolog.getObs())) {
				crmOdontologyStomatolog.setObs(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologyTempJoint.getObs())) {
				crmOdontologyTempJoint.setObs(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologySoftTissue.getObs())) {
				crmOdontologySoftTissue.setObs(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologyPeriodontal.getObs())) {
				crmOdontologyPeriodontal.setObs(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologySupplExams.getObs())) {
				crmOdontologySupplExams.setObs(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologyEvolution.getObs())) {
				crmOdontologyEvolution.setObs(Constant.HISTORY_NOT_REFER);
			}

			if (!FacesUtil.isEmptyOrBlank(selectedPatient.getNeighborhood())) {
				selectedPatient.setNeighborhood(selectedPatient
						.getNeighborhood().toUpperCase());
			}

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

			// RECORD
			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getArthritisMedication())) {
				selectedHistoryRecord
						.setArthritisMedication(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getArthritisTime())) {
				selectedHistoryRecord
						.setArthritisTime(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getCancerMedication())) {
				selectedHistoryRecord
						.setCancerMedication(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord.getCancerTime())) {
				selectedHistoryRecord.setCancerTime(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getPulmonaryMedication())) {
				selectedHistoryRecord
						.setPulmonaryMedication(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getPulmonaryTime())) {
				selectedHistoryRecord
						.setPulmonaryTime(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getDiabetesMedication())) {
				selectedHistoryRecord
						.setDiabetesMedication(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getDiabetesTime())) {
				selectedHistoryRecord
						.setDiabetesTime(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getHypertensionMedication())) {
				selectedHistoryRecord
						.setHypertensionMedication(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getHypertensionTime())) {
				selectedHistoryRecord
						.setHypertensionTime(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getHospitalizationsMedication())) {
				selectedHistoryRecord
						.setHospitalizationsMedication(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getHospitalizationsTime())) {
				selectedHistoryRecord
						.setHospitalizationsTime(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getAllergyMedication())) {
				selectedHistoryRecord
						.setAllergyMedication(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil
					.isEmptyOrBlank(selectedHistoryRecord.getAllergyTime())) {
				selectedHistoryRecord
						.setAllergyTime(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getInfectionsMedication())) {
				selectedHistoryRecord
						.setInfectionsMedication(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getInfectionsTime())) {
				selectedHistoryRecord
						.setInfectionsTime(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
					.getOccupational())) {
				selectedHistoryRecord
						.setOccupational(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord.getToxic())) {
				selectedHistoryRecord.setToxic(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord.getBloodType())) {
				selectedHistoryRecord.setBloodType(Constant.HISTORY_NOT_REFER);
			}

			// PHYSIQUE
			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
					.getGeneralState())) {
				selectedHistoryPhysique
						.setGeneralState(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getHeadNeck())) {
				selectedHistoryPhysique.setHeadNeck(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getChest())) {
				selectedHistoryPhysique.setChest(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getLungs())) {
				selectedHistoryPhysique.setLungs(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getHeart())) {
				selectedHistoryPhysique.setHeart(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getAbdomen())) {
				selectedHistoryPhysique.setAbdomen(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getGenitals())) {
				selectedHistoryPhysique.setGenitals(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getOsteo())) {
				selectedHistoryPhysique.setOsteo(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getTips())) {
				selectedHistoryPhysique.setTips(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
					.getHighlights())) {
				selectedHistoryPhysique
						.setHighlights(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getSkin())) {
				selectedHistoryPhysique.setSkin(Constant.HISTORY_NOT_REFER);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getObs())) {
				selectedHistoryPhysique.setObs(Constant.HISTORY_NOT_REFER);
			}

			int result = processService.savePatient(selectedPatient, false,
					false, null);

			if (result == 0) {
				processService.saveHistoryHistory(selectedHistoryHistory);
				processService.saveHistoryRecord(selectedHistoryRecord);
				processService.saveHistoryPhysique(selectedHistoryPhysique);
				processService.save(crmOdontologyStomatolog);
				processService.save(crmOdontologyTempJoint);
				processService.save(crmOdontologySoftTissue);
				processService.save(crmOdontologyPeriodontal);
				processService.save(crmOdontologySupplExams);
				processService.save(crmOdontologyEvolution);
				processService.save(crmOdontologyOdontogram);

				if (listDiagnosis.size() == 0) {
					message = FacesUtil.getMessage("his_msg_message_dig_1");
					FacesUtil.addWarn(message);
				} else {
					for (CrmDiagnosis row : listDiagnosis) {
						if (FacesUtil.isEmptyOrBlank(row.getPosology())) {
							message = FacesUtil
									.getMessage("his_msg_message_dig_2");
							FacesUtil.addWarn(message);
							break;
						}
					}

					if (listMedication.size() == 0) {
						message = FacesUtil.getMessage("his_msg_message_med_5");
						FacesUtil.addWarn(message);
					} else {
						int idCie = listDiagnosis.get(0).getCrmCie().getId()
								.intValue();
						int numMedication = 0;
						for (CrmMedication row : listMedication) {
							if (row.getCrmCie().getId().intValue() == idCie) {
								numMedication++;
							}
						}

						int minMedication = currentAppointment
								.getCrmProcedureDetail().getMinMedication();
						int maxMedication = currentAppointment
								.getCrmProcedureDetail().getMaxMedication();
						if (minMedication > 0 && numMedication < minMedication) {
							message = FacesUtil.getMessage(
									"his_msg_message_med_1",
									String.valueOf(minMedication));
							FacesUtil.addWarn(message);
						} else if (maxMedication > 0
								&& numMedication > maxMedication) {
							message = FacesUtil.getMessage(
									"his_msg_message_med_3",
									String.valueOf(maxMedication));
							FacesUtil.addWarn(message);
						}
					}
				}

				if (message == null) {
					processService.saveDiagnosis(currentAppointment,
							listDiagnosis);
					processService.saveMedication(currentAppointment,
							listMedication, Constant.MATERIAL_TYPE_ODONTOLOGY);

					if (event != null) {
						currentAppointment.setCloseAppointment(true);
					}

					currentAppointment.setState(Constant.APP_STATE_ATTENDED);
					processService.saveAppointment(currentAppointment);
					message = FacesUtil.getMessage("his_msg_message_med_ok");
					FacesUtil.addInfo(message);
					refreshLists();

					if (event != null) {
						refreshAction();
					}
				}
			}
		}
	}

	@Override
	public void saveAction(ActionEvent event) {
		closeAppointmentAction(null);
	}

	public String returnAction() {
		this.modeEdit = false;
		HistoryBacking historyBacking = FacesUtil.findBean("historyBacking");
		historyBacking.setModeEdit(false);
		historyBacking.newAction(null);
		return "history?faces-redirect=true";
	}

	public boolean isRenderedTab() {
		return selectedAppointment.getPrcEvaluation() == 1 ? true : false;
	}

	@Override
	public void searchCIEAction(ActionEvent event) {
		if ((optionSearchCie == 1 && this.codeCIE.isEmpty())
				|| (optionSearchCie == 2 && this.descCIE.isEmpty())) {
			this.listCie = new ArrayList<CrmCie>();
			disabledAddCie = true;
		} else {
			if (optionSearchCie == 1) {
				this.listCie = processService.getListCieByCode(codeCIE,
						Constant.ODONTOLOGY_HISTORY_TYPE);
			} else {
				this.listCie = processService.getListCieByName(descCIE,
						Constant.ODONTOLOGY_HISTORY_TYPE);
			}

			if (listCie.size() > 0) {
				selectedCie = listCie.get(0);
				disabledAddCie = false;
			} else {
				disabledAddCie = true;
			}
		}
		refreshListCie();
	}

	@Override
	public void selectMedicationAction() {
		this.typeMedication = Constant.MATERIAL_TYPE_ODONTOLOGY;
		if (listMaterial.size() == 0) {
			listAllMaterial = new ArrayList<WSBean>();
			for (WSBean material : listAllBackupMaterial) {
				boolean validateGroup = false;
				for (CrmMaterialGroup row : listMaterialGroup) {
					if (row.getMaterialType().equals(typeMedication)
							&& material.getType().equals(row.getGroup())) {
						validateGroup = true;
						break;
					}
				}

				if (validateGroup) {
					listMaterial.add(material);
					listAllMaterial.add(material);
				}
			}
		}

		refreshListMedication();
		refreshMaterialFields();
	}

	@Override
	protected void refreshListMedication() {
		List<WSBean> listFilter = new ArrayList<WSBean>();
		for (WSBean row : listMaterial) {
			boolean filter = true;
			if (typeMedication.equals(Constant.MATERIAL_TYPE_ODONTOLOGY)) {
				for (CrmMedication med : listMedication) {
					if (Long.parseLong(row.getCode()) == med.getCodMaterial()) {
						filter = false;
						break;
					}
				}
			}

			if (filter) {
				listFilter.add(row);
			}
		}

		this.materialModel = new WSBeanDataModel(listFilter);
		if (listFilter.size() > 0) {
			selectedMaterial = listFilter.get(0);
			disabledAddMaterial = false;
		} else {
			disabledAddMaterial = true;
		}
	}

	@Override
	public void addMaterialAction(ActionEvent event) {
		BigDecimal id = new BigDecimal(listMedication.size() + 1);
		CrmMedication medication = new CrmMedication();
		medication.setId(id);
		medication.setCrmAppointment(currentAppointment);
		medication.setCrmCie(selectedDiagnosis.getCrmCie());
		medication.setCodMaterial(Integer.parseInt(selectedMaterial.getCode()));
		medication.setDescMaterial(selectedMaterial.getNames());
		medication.setSapMaterialType(selectedMaterial.getType());
		medication.setMaterialType(typeMedication);
		medication.setUnit(amount);

		listMedication.add(medication);
		medicationModel = new MedicationDataModel(listMedication);

		refreshListMedication();
	}
	
	@Override
	public void printFormulaAction() {
		try {
			GenerateFormulaPDF.PDF(currentAppointment.getId(),
					Constant.MATERIAL_TYPE_ODONTOLOGY);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
