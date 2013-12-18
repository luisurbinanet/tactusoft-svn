package co.com.tactusoft.crm.view.backing;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmOdontologyEvolution;
import co.com.tactusoft.crm.model.entities.CrmOdontologyFamilaryRecord;
import co.com.tactusoft.crm.model.entities.CrmOdontologyPeriodontal;
import co.com.tactusoft.crm.model.entities.CrmOdontologyPersonalRecord;
import co.com.tactusoft.crm.model.entities.CrmOdontologySoftTissue;
import co.com.tactusoft.crm.model.entities.CrmOdontologyStomatolog;
import co.com.tactusoft.crm.model.entities.CrmOdontologySupplExams;
import co.com.tactusoft.crm.model.entities.CrmOdontologyTempJoint;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("session")
public class HistoryOdontologyBacking extends HistoryBacking {

	private static final long serialVersionUID = 1L;

	private CrmOdontologyPersonalRecord crmOdontologyPersonalRecord;
	private CrmOdontologyFamilaryRecord crmOdontologyFamilaryRecord;
	private CrmHistoryPhysique crmHistoryPhysique;
	private CrmOdontologyStomatolog crmOdontologyStomatolog;
	private CrmOdontologyTempJoint crmOdontologyTempJoint;
	private CrmOdontologySoftTissue crmOdontologySoftTissue;
	private CrmOdontologyPeriodontal crmOdontologyPeriodontal;
	private CrmOdontologySupplExams crmOdontologySupplExams;
	private CrmOdontologyEvolution crmOdontologyEvolution;

	public HistoryOdontologyBacking() {

	}

	public CrmOdontologyPersonalRecord getCrmOdontologyPersonalRecord() {
		return crmOdontologyPersonalRecord;
	}

	public void setCrmOdontologyPersonalRecord(
			CrmOdontologyPersonalRecord crmOdontologyPersonalRecord) {
		this.crmOdontologyPersonalRecord = crmOdontologyPersonalRecord;
	}

	public CrmOdontologyFamilaryRecord getCrmOdontologyFamilaryRecord() {
		return crmOdontologyFamilaryRecord;
	}

	public void setCrmOdontologyFamilaryRecord(
			CrmOdontologyFamilaryRecord crmOdontologyFamilaryRecord) {
		this.crmOdontologyFamilaryRecord = crmOdontologyFamilaryRecord;
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

		crmOdontologyPersonalRecord = processService
				.getOdontologyPersonalRecord(selectedAppointment.getId());
		crmOdontologyPersonalRecord.setCrmAppointment(currentAppointment);

		crmOdontologyFamilaryRecord = processService
				.getOdontologyFamilaryRecord(selectedAppointment.getId());
		crmOdontologyFamilaryRecord.setCrmAppointment(currentAppointment);

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

		if (this.getHeartRate() == 0) {
			field = FacesUtil.getMessage("his_physique_heart_rate");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedHistoryPhysique
					.setHeartRate(String.valueOf(this.heartRate));
		}

		if (this.getRespiratoryRate() == 0) {
			field = FacesUtil.getMessage("his_physique_respiratory_rate");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedHistoryPhysique.setRespiratoryRate(String
					.valueOf(this.respiratoryRate));
		}

		if (message == null) {
			if (FacesUtil.isEmptyOrBlank(crmOdontologyPersonalRecord.getObs())) {
				crmOdontologyPersonalRecord.setObs("NO REFIERE");
			}
			if (FacesUtil.isEmptyOrBlank(crmOdontologyFamilaryRecord.getObs())) {
				crmOdontologyFamilaryRecord.setObs("NO REFIERE");
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getObs())) {
				selectedHistoryPhysique.setObs("NO REFIERE");
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getObs())) {
				selectedHistoryPhysique.setObs("NO REFIERE");
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologyStomatolog.getObs())) {
				crmOdontologyStomatolog.setObs("NO REFIERE");
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologyTempJoint.getObs())) {
				crmOdontologyTempJoint.setObs("NO REFIERE");
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologySoftTissue.getObs())) {
				crmOdontologySoftTissue.setObs("NO REFIERE");
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologyPeriodontal.getObs())) {
				crmOdontologyPeriodontal.setObs("NO REFIERE");
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologySupplExams.getObs())) {
				crmOdontologySupplExams.setObs("NO REFIERE");
			}

			if (FacesUtil.isEmptyOrBlank(crmOdontologyEvolution.getObs())) {
				crmOdontologyEvolution.setObs("NO REFIERE");
			}

			processService.save(crmOdontologyPersonalRecord);
			processService.save(crmOdontologyFamilaryRecord);
			processService.saveHistoryPhysique(selectedHistoryPhysique);
			processService.save(crmOdontologyStomatolog);
			processService.save(crmOdontologyTempJoint);
			processService.save(crmOdontologySoftTissue);
			processService.save(crmOdontologyPeriodontal);
			processService.save(crmOdontologySupplExams);
			processService.save(crmOdontologyEvolution);

			viewMode = true;

			if (event != null) {
				currentAppointment.setCloseAppointment(true);
			}

			currentAppointment.setState(Constant.APP_STATE_ATTENDED);
			processService.saveAppointment(currentAppointment);
			message = FacesUtil.getMessage("his_msg_message_med_ok");
			FacesUtil.addInfo(message);
			// refreshLists();

			if (event != null) {
				// refreshAction();
			}
		}
	}

	@Override
	public void saveAction(ActionEvent event) {
		closeAppointmentAction(null);
	}

	public String returnAction() {
		this.modeEdit = false;
		HistoryBacking historyBacking = FacesUtil
				.findBean("historyOdontologyBacking");
		historyBacking.setModeEdit(false);
		historyBacking.newAction(null);
		return "history?faces-redirect=true";
	}

}
