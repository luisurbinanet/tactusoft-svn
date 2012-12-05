package co.com.tactusoft.crm.view.backing;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.view.datamodel.VwAppointmentDataModel;

@Named
@Scope("session")
public class HistoryBackingNew extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private CrmDoctor doctor;

	private List<VwAppointment> listAppointment;
	private VwAppointmentDataModel appointmentModel;
	private VwAppointment selectedAppointment;

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

	public void newAction(ActionEvent event) {

	}

	public void searchAction(ActionEvent event) {

	}

	public void editAppointmentAction() {

	}

}
