package co.com.tactusoft.crm.view.backing;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmHistoryHistory;
import co.com.tactusoft.crm.model.entities.CrmHistoryHomeopathic;
import co.com.tactusoft.crm.model.entities.CrmHistoryOrganometry;
import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmHistoryRecord;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.view.datamodel.HistoryHistoryDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryHomeopathicDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryOrganometryDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryPhysiqueDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryRecordDataModel;
import co.com.tactusoft.crm.view.datamodel.VwAppointmentDataModel;

@Named
@Scope("session")
public class HistoryBackingNew extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private CrmDoctor doctor;

	private List<VwAppointment> listAppointment;
	private VwAppointmentDataModel appointmentModel;
	private VwAppointment selectedAppointment;

	private boolean modeEdit;
	private String part;

	private HistoryHistoryDataModel historyHistoryModel;
	private HistoryRecordDataModel historyRecordModel;
	private HistoryHomeopathicDataModel historyHomeopathicModel;
	private HistoryPhysiqueDataModel historyPhysiqueModel;
	private HistoryOrganometryDataModel historyOrganometryModel;

	public HistoryBackingNew() {
		newAction(null);
	}

	@PostConstruct
	public void init() {
		doctor = processService.getCrmDoctor();
		appointmentModel = null;
	}

	public List<VwAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<VwAppointment> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public VwAppointmentDataModel getAppointmentModel() {
		if (appointmentModel == null) {
			if (doctor != null) {
				listAppointment = processService
						.getListVwAppointmentByHistory(doctor.getId());
				appointmentModel = new VwAppointmentDataModel(listAppointment);
				if (listAppointment.size() > 0) {
					selectedAppointment = listAppointment.get(0);
				}
			}
		}
		return appointmentModel;
	}

	public void setAppointmentModel(VwAppointmentDataModel appointmentModel) {
		this.appointmentModel = appointmentModel;
	}

	public VwAppointment getSelectedAppointment() {
		return selectedAppointment;
	}

	public void setSelectedAppointment(VwAppointment selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	public boolean isModeEdit() {
		return modeEdit;
	}

	public void setModeEdit(boolean modeEdit) {
		this.modeEdit = modeEdit;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public HistoryHistoryDataModel getHistoryHistoryModel() {
		return historyHistoryModel;
	}

	public void setHistoryHistoryModel(
			HistoryHistoryDataModel historyHistoryModel) {
		this.historyHistoryModel = historyHistoryModel;
	}

	public HistoryRecordDataModel getHistoryRecordModel() {
		return historyRecordModel;
	}

	public void setHistoryRecordModel(HistoryRecordDataModel historyRecordModel) {
		this.historyRecordModel = historyRecordModel;
	}

	public HistoryHomeopathicDataModel getHistoryHomeopathicModel() {
		return historyHomeopathicModel;
	}

	public void setHistoryHomeopathicModel(
			HistoryHomeopathicDataModel historyHomeopathicModel) {
		this.historyHomeopathicModel = historyHomeopathicModel;
	}

	public HistoryPhysiqueDataModel getHistoryPhysiqueModel() {
		return historyPhysiqueModel;
	}

	public void setHistoryPhysiqueModel(
			HistoryPhysiqueDataModel historyPhysiqueModel) {
		this.historyPhysiqueModel = historyPhysiqueModel;
	}

	public HistoryOrganometryDataModel getHistoryOrganometryModel() {
		return historyOrganometryModel;
	}

	public void setHistoryOrganometryModel(
			HistoryOrganometryDataModel historyOrganometryModel) {
		this.historyOrganometryModel = historyOrganometryModel;
	}

	public void newAction(ActionEvent event) {
		modeEdit = false;
		part = Constant.HISTORY_HISTORY;
	}

	public void searchAction(ActionEvent event) {

	}

	public void editAppointmentAction() {
		modeEdit = true;
		part = Constant.HISTORY_HISTORY;

		List<CrmHistoryHistory> listTempHistory = processService
				.getListHistoryHistory(selectedAppointment.getPatId());
		historyHistoryModel = new HistoryHistoryDataModel(listTempHistory);

		List<CrmHistoryRecord> listTempRecord = processService
				.getListHistoryRecord(selectedAppointment.getPatId());
		historyRecordModel = new HistoryRecordDataModel(listTempRecord);

		List<CrmHistoryHomeopathic> listTempHomeopathic = processService
				.getListHistoryHomeopathic(selectedAppointment.getPatId());
		historyHomeopathicModel = new HistoryHomeopathicDataModel(
				listTempHomeopathic);

		List<CrmHistoryPhysique> listTempPhysique = processService
				.getListHistoryPhysique(selectedAppointment.getPatId());
		historyPhysiqueModel = new HistoryPhysiqueDataModel(listTempPhysique);

		List<CrmHistoryOrganometry> listTempOrganometry = processService
				.getListHistoryOrganometry(selectedAppointment.getPatId());
		historyOrganometryModel = new HistoryOrganometryDataModel(
				listTempOrganometry);
	}

	public void viewHistoryAction() {
		RequestContext context = RequestContext.getCurrentInstance();
		if (this.part.equals(Constant.HISTORY_HISTORY)) {
			context.execute("dlgHistory.show()");
		} else if (this.part.equals(Constant.HISTORY_RECORD)) {
			context.execute("dlgRecord.show()");
		}
	}
}
