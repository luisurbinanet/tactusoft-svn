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
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;

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
	private Date startDate;
	private Date endDate;
	private int state;

	private List<CrmAppointment> listAppointment;
	private AppointmentDataModel appointmentModel;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public void newAction(ActionEvent event) {
		listAppointment = new LinkedList<CrmAppointment>();
		appointmentModel = new AppointmentDataModel(listAppointment);
		selectedAppointment = new CrmAppointment();

		startDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH, 1);
		endDate = calendar.getTime();

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
		}
	}

	public void searchAppoinmentAction(ActionEvent event) {
		if (idBranch.intValue() == -1) {

		} else {
			if (idDoctor.intValue() == -1) {

			} else {

			}

			if (idProcedure.intValue() == -1) {

			} else {

			}
		}

	}

}