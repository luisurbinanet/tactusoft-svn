package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.VwAppointmentDataModel;

@Named
@Scope("view")
public class AppointmentSearchBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private boolean dates;
	private Date startDate;
	private Date endDate;
	private boolean datesCreate;
	private Date startDateCreate;
	private Date endDateCreate;
	private int state;

	private List<VwAppointment> listAppointment;
	private VwAppointmentDataModel appointmentModel;
	private CrmAppointment selectedAppointment;
	private List<String> listProcedureSelected;

	public AppointmentSearchBacking() {
		newAction(null);
	}

	public boolean isDates() {
		return dates;
	}

	public void setDates(boolean dates) {
		this.dates = dates;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isDatesCreate() {
		return datesCreate;
	}

	public void setDatesCreate(boolean datesCreate) {
		this.datesCreate = datesCreate;
	}

	public Date getStartDateCreate() {
		return startDateCreate;
	}

	public void setStartDateCreate(Date startDateCreate) {
		this.startDateCreate = startDateCreate;
	}

	public Date getEndDateCreate() {
		return endDateCreate;
	}

	public void setEndDateCreate(Date endDateCreate) {
		this.endDateCreate = endDateCreate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<VwAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<VwAppointment> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public VwAppointmentDataModel getAppointmentModel() {
		return appointmentModel;
	}

	public void setAppointmentModel(VwAppointmentDataModel appointmentModel) {
		this.appointmentModel = appointmentModel;
	}

	public CrmAppointment getSelectedAppointment() {
		return selectedAppointment;
	}

	public void setSelectedAppointment(CrmAppointment selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	public List<String> getListProcedureSelected() {
		return listProcedureSelected;
	}

	public void setListProcedureSelected(List<String> listProcedureSelected) {
		this.listProcedureSelected = listProcedureSelected;
	}

	public void newAction(ActionEvent event) {
		listAppointment = new LinkedList<VwAppointment>();
		appointmentModel = new VwAppointmentDataModel(listAppointment);
		selectedAppointment = new CrmAppointment();

		startDate = new Date();
		startDateCreate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH, 1);
		endDate = calendar.getTime();
		endDateCreate = calendar.getTime();

		listStates = new LinkedList<SelectItem>();
		String message = FacesUtil.getMessage(Constant.ALL_LABEL);
		listStates.add(new SelectItem(Constant.DEFAULT_VALUE, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_CONFIRMED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_CONFIRMED, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_CANCELED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_CANCELED, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_CHECKED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_CHECKED, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_ATTENDED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_ATTENDED, message));
		message = FacesUtil.getMessage(Constant.APP_STATE_NOATTENDED_LABEL);
		listStates.add(new SelectItem(Constant.APP_STATE_NOATTENDED, message));
	}

	public void searchAppoinmentAction(ActionEvent event) {
		if (selectedsBranchObject != null && selectedsBranchObject.length > 0) {
			String where = "from VwAppointment o where 1 = 1 ";

			if (dates) {
				String startDateString = FacesUtil.formatDate(startDate,
						"yyyy-MM-dd");
				String endDateString = FacesUtil.formatDate(endDate,
						"yyyy-MM-dd");

				where = where + " and (o.startAppointmentDate between '"
						+ startDateString + "T00:00:00.000+05:00' and '"
						+ endDateString + "T23:59:59.999+05:00')";
			}

			if (datesCreate) {
				String startDateCreateString = FacesUtil.formatDate(
						startDateCreate, "yyyy-MM-dd");
				String endDateCreateString = FacesUtil.formatDate(
						endDateCreate, "yyyy-MM-dd");

				where = where + " and (o.dateCreate between '"
						+ startDateCreateString + "T00:00:00.000+05:00' and '"
						+ endDateCreateString + "T23:59:59.999+05:00')";
			}

			if (selectedsBranchObject != null
					&& selectedsBranchObject.length > 0) {
				String branchs = " and o.branchId in (";
				for (CrmBranch crmBranch : selectedsBranchObject) {
					branchs = branchs + crmBranch.getId() + ",";
				}
				branchs = branchs.substring(0, branchs.length() - 1) + ")";
				where = where + branchs;

				if (idDoctor.intValue() == -1) {
					String doctors = " and o.doctorId in (";
					for (SelectItem item : listDoctor) {
						if (((BigDecimal) item.getValue()).intValue() != -1) {
							doctors = doctors + item.getValue() + ",";
						}
					}
					doctors = doctors.substring(0, doctors.length() - 1) + ")";
					where = where + doctors;
				} else {
					where = where + " and o.doctorId = " + idDoctor.intValue();
				}

				String procedures = " and o.prcDetId in ("
						+ getStringSelecteds(listProcedureSelected) + ")";
				where = where + procedures;
			}

			if (state != -1) {
				where = where + " and o.state = " + state;
			}

			listAppointment = processService
					.getListAppointmentByCriteria(where);
			appointmentModel = new VwAppointmentDataModel(listAppointment);
		} else {
			String message = FacesUtil.getMessage("app_no_branch");
			FacesUtil.addInfo(message);
		}
	}

	public boolean isDisabledExport() {
		boolean result = true;
		if (listAppointment.size() > 0) {
			result = false;
		}
		return result;
	}

}