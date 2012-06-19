package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("view")
public class DoctorAppointmentBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private List<SelectItem> listDoctor;
	private CrmDoctor doctor;
	private List<CrmAppointment> listAppointment;

	private List<SelectItem> listBranch;
	private BigDecimal idBranch;

	private List<CrmAppointment> listAppointmentByBranch;

	private ScheduleModel eventModel;
	private ScheduleModel branchEventModel;

	public DoctorAppointmentBacking() {
		idBranch = Constant.DEFAULT_VALUE;
		doctor = new CrmDoctor();
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

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listBranch.add(new SelectItem(Constant.DEFAULT_VALUE, label));
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				listBranch.add(new SelectItem(row.getId(), row.getName()));
			}
		}
		return listBranch;
	}

	public void setListBranch(List<SelectItem> listBranch) {
		this.listBranch = listBranch;
	}

	public List<SelectItem> getListDoctor() {
		return listDoctor;
	}

	public void setListDoctor(List<SelectItem> listDoctor) {
		this.listDoctor = listDoctor;
	}

	public BigDecimal getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
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

	public ScheduleModel getBranchEventModel() {
		return branchEventModel;
	}

	public void setBranchEventModel(ScheduleModel branchEventModel) {
		this.branchEventModel = branchEventModel;
	}

	public void handleBranchChange() {
		listDoctor = new LinkedList<SelectItem>();
		String label = FacesUtil.getMessage(Constant.ALL_LABEL);
		listDoctor.add(new SelectItem(Constant.DEFAULT_VALUE, label));
		for (CrmDoctor row : tablesService.getListDoctorByBranch(idBranch)) {
			listDoctor.add(new SelectItem(row.getId(), row.getNames()));
		}
	}

	public void searchAction() {
		if (idBranch.intValue() != -1) {
			branchEventModel = new DefaultScheduleModel();

			if (doctor.getId().intValue() == -1) {
				listAppointment = processService
						.getListAppointmentByBranch(idBranch);
			} else {
				listAppointment = processService
						.getListAppointmentByBranchDoctor(idBranch,
								doctor.getId());
			}

			for (CrmAppointment row : listAppointment) {
				branchEventModel.addEvent(new DefaultScheduleEvent("Cita Nro."
						+ row.getCode() + ". Paciente: "
						+ row.getPatientNames() + ". Doctor: "
						+ row.getCrmDoctor().getNames(), row
						.getStartAppointmentDate(), row
						.getStartAppointmentDate()));
			}
		} else {
			branchEventModel = null;
		}
	}

}
