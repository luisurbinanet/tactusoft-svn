package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmProcedure;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Candidate;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

@Named
@Scope("view")
public class AppointmentBacking extends BaseBacking {

	private static final long serialVersionUID = -7936516411298237407L;

	private CrmAppointment selected;

	private List<SelectItem> listBranch;
	private Map<BigDecimal, CrmBranch> mapBranch;

	private List<SelectItem> listProcedure;
	private Map<BigDecimal, CrmProcedure> mapProcedure;
	private BigDecimal idProcedure;

	private List<SelectItem> listProcedureDetail;
	private Map<BigDecimal, CrmProcedureDetail> mapProcedureDetail;

	private List<SelectItem> listSearch;
	private BigDecimal idSearch;

	private List<SelectItem> listDoctor;
	private Map<BigDecimal, CrmDoctor> mapDoctor;

	private Date currentDate;
	private int appointmentsNumber;

	private List<SelectItem> listAppointment;
	private Map<Integer, Candidate> mapAppointment;
	private Integer selectedAppointment;

	private boolean disabledSaveButton;
	private boolean renderedForDate;
	private boolean renderedForDoctor;

	public AppointmentBacking() {
		newAction(null);
	}

	public CrmAppointment getSelected() {
		return selected;
	}

	public void setSelected(CrmAppointment selected) {
		this.selected = selected;
	}

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			mapBranch = new HashMap<BigDecimal, CrmBranch>();
			for (CrmBranch row : tablesService.getListBranchActive()) {
				mapBranch.put(row.getId(), row);
				listBranch.add(new SelectItem(row.getId(), row.getName()));
			}
		}
		return listBranch;
	}

	public void setListBranch(List<SelectItem> listBranch) {
		this.listBranch = listBranch;
	}

	public Map<BigDecimal, CrmBranch> getMapBranch() {
		return mapBranch;
	}

	public void setMapBranch(Map<BigDecimal, CrmBranch> mapBranch) {
		this.mapBranch = mapBranch;
	}

	public List<SelectItem> getListProcedure() {
		if (listProcedure == null) {
			listProcedure = new LinkedList<SelectItem>();
			mapProcedure = new HashMap<BigDecimal, CrmProcedure>();
			for (CrmProcedure row : tablesService.getListProcedureActive()) {
				mapProcedure.put(row.getId(), row);
				listProcedure.add(new SelectItem(row.getId(), row.getName()));
			}

			if (listProcedure.size() > 0) {
				idProcedure = (BigDecimal) listProcedure.get(0).getValue();
				handleProcedureChange();
			}
		}
		return listProcedure;
	}

	public void setListProcedure(List<SelectItem> listProcedure) {
		this.listProcedure = listProcedure;
	}

	public Map<BigDecimal, CrmProcedure> getMapProcedure() {
		return mapProcedure;
	}

	public void setMapProcedure(Map<BigDecimal, CrmProcedure> mapProcedure) {
		this.mapProcedure = mapProcedure;
	}

	public BigDecimal getIdProcedure() {
		return idProcedure;
	}

	public void setIdProcedure(BigDecimal idProcedure) {
		this.idProcedure = idProcedure;
	}

	public List<SelectItem> getListProcedureDetail() {
		return listProcedureDetail;
	}

	public void setListProcedureDetail(List<SelectItem> listProcedureDetail) {
		this.listProcedureDetail = listProcedureDetail;
	}

	public Map<BigDecimal, CrmProcedureDetail> getMapProcedureDetail() {
		return mapProcedureDetail;
	}

	public void setMapProcedureDetail(
			Map<BigDecimal, CrmProcedureDetail> mapProcedureDetail) {
		this.mapProcedureDetail = mapProcedureDetail;
	}

	public List<SelectItem> getListSearch() {
		if (listSearch == null) {
			listSearch = new LinkedList<SelectItem>();
			listSearch.add(new SelectItem(Constant.DEFAULT_VALUE, FacesUtil
					.getMessage(Constant.DEFAULT_LABEL)));
			listSearch.add(new SelectItem(Constant.APP_TYPE_FOR_DATE_VALUE,
					FacesUtil.getMessage(Constant.APP_TYPE_FOR_DATE_DESC)));
			listSearch.add(new SelectItem(Constant.APP_TYPE_FOR_DOCTOR_VALUE,
					FacesUtil.getMessage(Constant.APP_TYPE_FOR_DOCTOR_DESC)));
		}
		return listSearch;
	}

	public void setListSearch(List<SelectItem> listSearch) {
		this.listSearch = listSearch;
	}

	public BigDecimal getIdSearch() {
		return idSearch;
	}

	public void setIdSearch(BigDecimal idSearch) {
		this.idSearch = idSearch;
	}

	public List<SelectItem> getListDoctor() {
		return listDoctor;
	}

	public void setListDoctor(List<SelectItem> listDoctor) {
		this.listDoctor = listDoctor;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public int getAppointmentsNumber() {
		return appointmentsNumber;
	}

	public void setAppointmentsNumber(int appointmentsNumber) {
		this.appointmentsNumber = appointmentsNumber;
	}

	public List<SelectItem> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<SelectItem> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public Integer getSelectedAppointment() {
		return selectedAppointment;
	}

	public void setSelectedAppointment(Integer selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	public boolean isDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public boolean isRenderedForDate() {
		return renderedForDate;
	}

	public void setRenderedForDate(boolean renderedForDate) {
		this.renderedForDate = renderedForDate;
	}

	public boolean isRenderedForDoctor() {
		return renderedForDoctor;
	}

	public void setRenderedForDoctor(boolean renderedForDoctor) {
		this.renderedForDoctor = renderedForDoctor;
	}

	public boolean isDisabledAddPatient() {
		if (listPatient.size() == 0) {
			return true;
		} else if (listPatient.size() == 1) {
			if (listPatient.get(0).getSAPCode().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public void newAction(ActionEvent event) {
		listPatient = new LinkedList<Patient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;
		idSearch = Constant.DEFAULT_VALUE;

		selected = new CrmAppointment();
		selected.setCrmBranch(new CrmBranch());
		selected.setCrmDoctor(new CrmDoctor());
		selected.setCrmProcedureDetail(new CrmProcedureDetail());

		selectedPatient = new Patient();
		currentDate = new Date();

		renderedForDate = false;
		renderedForDoctor = false;
		
		optionSearchPatient = 1;
		docPatient = "";
		namePatient = "";

		String message = FacesUtil.getMessage("app_msg_error_not_avalaible");
		listAppointment = new LinkedList<SelectItem>();
		listAppointment.add(new SelectItem(null, message));
		this.selectedAppointment = 0;
	}

	public void handleProcedureChange() {
		listProcedureDetail = new LinkedList<SelectItem>();
		mapProcedureDetail = new HashMap<BigDecimal, CrmProcedureDetail>();
		for (CrmProcedureDetail row : tablesService
				.getListProcedureDetailByProcedure(idProcedure)) {
			mapProcedureDetail.put(row.getId(), row);
			listProcedureDetail.add(new SelectItem(row.getId(), row.getName()));
		}

		idSearch = Constant.DEFAULT_VALUE;
		handleSearchChange();
	}

	public void handleProcedureDetailChange() {
		idSearch = Constant.DEFAULT_VALUE;
		handleSearchChange();
	}

	public void handleSearchChange() {
		if (this.idSearch.intValue() == Constant.APP_TYPE_FOR_DATE_VALUE
				.intValue()) {
			this.renderedForDate = true;
			this.renderedForDoctor = false;
		} else if (this.idSearch.intValue() == Constant.APP_TYPE_FOR_DOCTOR_VALUE
				.intValue()) {
			this.renderedForDate = false;
			this.renderedForDoctor = true;

			listDoctor = new LinkedList<SelectItem>();
			mapDoctor = new HashMap<BigDecimal, CrmDoctor>();
			for (CrmDoctor row : tablesService.getListDoctorActive()) {
				mapDoctor.put(row.getId(), row);
				listDoctor.add(new SelectItem(row.getId(), row.getFirstName()
						+ " " + row.getFirstSurname()));
			}

		} else {
			this.renderedForDate = false;
			this.renderedForDoctor = false;
		}
	}

	public void searchAppointMentChange() {
		List<Candidate> listCandidate = null;
		listAppointment = new LinkedList<SelectItem>();
		mapAppointment = new HashMap<Integer, Candidate>();

		CrmProcedureDetail procedureDetail = mapProcedureDetail.get(selected
				.getCrmProcedureDetail().getId());

		if (this.renderedForDate) {
			listCandidate = processService.getScheduleAppointmentForDate(
					selected.getCrmBranch().getId(), this.currentDate,
					procedureDetail);

			for (Candidate row : listCandidate) {
				listAppointment.add(new SelectItem(row.getId(), row
						.getDoctorDetail()));
				mapAppointment.put(row.getId(), row);
			}
		} else if (this.renderedForDoctor) {
			CrmDoctor doctor = mapDoctor.get(selected.getCrmDoctor().getId());
			listCandidate = processService.getScheduleAppointmentForDoctor(
					selected.getCrmBranch().getId(), doctor,
					this.appointmentsNumber, procedureDetail);

			for (Candidate row : listCandidate) {
				listAppointment
						.add(new SelectItem(row.getId(), row.getDetail()));
				mapAppointment.put(row.getId(), row);
			}
		}

		if (listAppointment.size() == 0) {
			String message = FacesUtil.getMessage("app_msg_error_not_avalaible");
			listAppointment.add(new SelectItem(null, message));
			this.selectedAppointment = 0;
		}
	}

	public void saveAction() {
		String message = null;

		// validar Selección Paciente
		if (this.selectedPatient.getSAPCode() == null) {
			message = FacesUtil.getMessage("app_msg_error_pat");
			FacesUtil.addError(message);
		}

		// validar Selección Cita
		if (this.selectedAppointment == 0) {
			message = FacesUtil.getMessage("app_msg_error_app");
			FacesUtil.addError(message);
		}

		if (message == null) {
			Candidate candidate = mapAppointment.get(this.selectedAppointment);
			CrmProcedureDetail procedureDetail = mapProcedureDetail
					.get(selected.getCrmProcedureDetail().getId());

			int validateApp = processService.validateAppointmentForDate(
					selected.getCrmBranch().getId(), candidate.getStartDate(),
					candidate.getEndDate(), procedureDetail, candidate
							.getDoctor().getId(), selectedPatient.getSAPCode());

			if (validateApp != 0) {
				switch (validateApp) {
				case -1:
					message = FacesUtil.getMessage("app_msg_error_1");
					break;
				case -2:
					message = FacesUtil.getMessage("app_msg_error_2");
					break;
				case -3:
					message = FacesUtil.getMessage("app_msg_error_3");
					break;
				case -4:
					message = FacesUtil.getMessage("app_msg_error_4");
					break;
				}
				FacesUtil.addError(message);
			} else {
				String code = "";

				selected.setCode(code);
				selected.setPatient(selectedPatient.getSAPCode());
				selected.setPatientSap(selectedPatient.getSAPCode());
				selected.setPatientNames(selectedPatient.getNames());
				selected.setCrmDoctor(candidate.getDoctor());
				selected.setCrmBranch(mapBranch.get(selected.getCrmBranch()
						.getId()));
				selected.setCrmProcedureDetail(procedureDetail);

				selected.setStartAppointmentDate(candidate.getStartDate());
				selected.setEndAppointmentDate(candidate.getEndDate());

				selected.setState(Constant.STATE_APP_ACTIVE);

				CrmAppointment crmAppointment = processService
						.saveAppointment(selected);
				message = FacesUtil.getMessage("app_msg_ok",
						crmAppointment.getCode());
				FacesUtil.addInfo(message);
			}
		}
	}

}
