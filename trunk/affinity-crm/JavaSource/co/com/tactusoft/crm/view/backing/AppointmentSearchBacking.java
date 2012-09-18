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
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.VwAppointmentDataModel;

@Named
@Scope("view")
public class AppointmentSearchBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL_ALL);

	private List<SelectItem> listBranch;
	private List<SelectItem> listDoctor;
	private List<SelectItem> listProcedure;
	private List<SelectItem> listStates;

	private BigDecimal idBranch;
	private BigDecimal idDoctor;
	private BigDecimal idProcedure;
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

	private boolean disabledSaveButton;

	public AppointmentSearchBacking() {
		newAction(null);
	}

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			listBranch.add(new SelectItem(Constant.DEFAULT_VALUE, label));
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				listBranch.add(new SelectItem(row.getId(), row.getName()));
			}

			idBranch = Constant.DEFAULT_VALUE;
			handleBranchChange();
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

	public List<SelectItem> getListProcedure() {
		return listProcedure;
	}

	public void setListProcedure(List<SelectItem> listProcedure) {
		this.listProcedure = listProcedure;
	}

	public List<SelectItem> getListStates() {
		return listStates;
	}

	public void setListStates(List<SelectItem> listStates) {
		this.listStates = listStates;
	}

	public BigDecimal getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	public BigDecimal getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(BigDecimal idDoctor) {
		this.idDoctor = idDoctor;
	}

	public BigDecimal getIdProcedure() {
		return idProcedure;
	}

	public void setIdProcedure(BigDecimal idProcedure) {
		this.idProcedure = idProcedure;
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

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
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

	public void handleBranchChange() {
		listDoctor = new LinkedList<SelectItem>();
		listDoctor.add(new SelectItem(Constant.DEFAULT_VALUE, label));

		listProcedure = new LinkedList<SelectItem>();
		listProcedure.add(new SelectItem(Constant.DEFAULT_VALUE, label));

		idDoctor = Constant.DEFAULT_VALUE;
		idProcedure = Constant.DEFAULT_VALUE;

		if (idBranch.intValue() != -1) {
			for (CrmDoctor row : tablesService.getListDoctorByBranch(idBranch)) {
				listDoctor.add(new SelectItem(row.getId(), row.getNames()));
			}

			for (CrmProcedureDetail row : tablesService
					.getListProcedureDetailByBranch(idBranch)) {
				listProcedure.add(new SelectItem(row.getId(), row.getName()));
			}
		}
	}

	public void searchAppoinmentAction(ActionEvent event) {

		String where = "from VwAppointment o where 1 = 1 ";

		if (dates) {
			String startDateString = FacesUtil.formatDate(startDate,
					"yyyy-MM-dd");
			String endDateString = FacesUtil.formatDate(endDate, "yyyy-MM-dd");

			where = where + " and (o.startAppointmentDate between '"
					+ startDateString + "T00:00:00.000+05:00' and '"
					+ endDateString + "T23:59:59.999+05:00')";
		}

		if (datesCreate) {
			String startDateCreateString = FacesUtil.formatDate(
					startDateCreate, "yyyy-MM-dd");
			String endDateCreateString = FacesUtil.formatDate(endDateCreate,
					"yyyy-MM-dd");

			where = where + " and (o.dateCreate between '"
					+ startDateCreateString + "T00:00:00.000+05:00' and '"
					+ endDateCreateString + "T23:59:59.999+05:00')";
		}

		if (idBranch.intValue() != -1) {
			where = where + " and o.branchId = " + idBranch.intValue();

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

			if (idProcedure.intValue() == -1) {
				String procedures = " and o.prcDetId in (";
				for (SelectItem item : listProcedure) {
					if (((BigDecimal) item.getValue()).intValue() != -1) {
						procedures = procedures + item.getValue() + ",";
					}
				}
				procedures = procedures.substring(0, procedures.length() - 1)
						+ ")";
				where = where + procedures;

			} else {
				where = where + " and o.prcDetId = " + idProcedure.intValue();
			}
		} else {
			String branchs = " and o.branchId in (";
			for (SelectItem item : listBranch) {
				if (((BigDecimal) item.getValue()).intValue() != -1) {
					branchs = branchs + item.getValue() + ",";
				}
			}
			branchs = branchs.substring(0, branchs.length() - 1) + ")";
			where = where + branchs;
		}

		if (state != -1) {
			where = where + " and o.state = " + state;
		}

		listAppointment = processService.getListAppointmentByCriteria(where);
		appointmentModel = new VwAppointmentDataModel(listAppointment);
	}

	public boolean isDisabledExport() {
		boolean result = true;
		if (listAppointment.size() > 0) {
			result = false;
		}
		return result;
	}

}