package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;

@Named
@Scope("view")
public class DoctorAppointmentBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProcessBo processService;

	private CrmDoctor doctor;
	private List<CrmAppointment> listAppointment;
	
	private CrmBranch branch;
	private List<CrmAppointment> listAppointmentByBranch;

	private ScheduleModel eventModel;

	public DoctorAppointmentBacking() {

	}

	public CrmDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(CrmDoctor doctor) {
		this.doctor = doctor;
	}

	public List<CrmAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<CrmAppointment> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public CrmBranch getBranch() {
		return branch;
	}

	public void setBranch(CrmBranch branch) {
		this.branch = branch;
	}

	public List<CrmAppointment> getListAppointmentByBranch() {
		return listAppointmentByBranch;
	}

	public void setListAppointmentByBranch(
			List<CrmAppointment> listAppointmentByBranch) {
		this.listAppointmentByBranch = listAppointmentByBranch;
	}

	public ScheduleModel getEventModel() {
		if (eventModel == null) {
			eventModel = new DefaultScheduleModel();
			doctor = processService.getCrmDoctor();
			if (doctor != null) {
				listAppointment = processService
						.getListAppointmentByDoctor(doctor.getId());
				for (CrmAppointment row : listAppointment) {
					eventModel.addEvent(new DefaultScheduleEvent("Cita Nro."
							+ row.getCode() + ". Paciente: "
							+ row.getPatientNames(), row
							.getStartAppointmentDate(), row
							.getStartAppointmentDate()));
				}
			}
		}
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

}
