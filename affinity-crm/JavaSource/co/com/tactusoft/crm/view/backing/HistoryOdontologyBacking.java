package co.com.tactusoft.crm.view.backing;

import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmOdontologyFamilaryRecord;
import co.com.tactusoft.crm.model.entities.CrmOdontologyPersonalRecord;
import co.com.tactusoft.crm.model.entities.CrmOdontologySoftTissue;
import co.com.tactusoft.crm.model.entities.CrmOdontologyStomatolog;
import co.com.tactusoft.crm.model.entities.CrmOdontologyTempJoint;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;

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

	}

	@Override
	public void saveAction(ActionEvent event) {
		closeAppointmentAction(null);
	}

}
