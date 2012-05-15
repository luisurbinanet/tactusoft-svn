package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmProcedure;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.beans.Patient;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.execute.CustomerExecute;
import com.tactusoft.webservice.client.objects.Bapikna111;

@Named
@Scope("view")
public class AppointmentBacking implements Serializable {

	private static final long serialVersionUID = -7936516411298237407L;

	@Inject
	private TablesBo tableService;

	@Inject
	private ProcessBo processService;

	private CrmAppointment selected;

	private List<Patient> listPatient;
	private PatientDataModel patientModel;
	private Patient selectedPatient;
	private String namePatient;

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

	public List<Patient> getListPatient() {
		return listPatient;
	}

	public void setListPatient(List<Patient> listPatient) {
		this.listPatient = listPatient;
	}

	public PatientDataModel getPatientModel() {
		return patientModel;
	}

	public void setPatientModel(PatientDataModel patientModel) {
		this.patientModel = patientModel;
	}

	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public String getNamePatient() {
		return namePatient;
	}

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			mapBranch = new HashMap<BigDecimal, CrmBranch>();
			for (CrmBranch row : tableService.getListBranchActive()) {
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

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public List<SelectItem> getListProcedure() {
		if (listProcedure == null) {
			listProcedure = new LinkedList<SelectItem>();
			mapProcedure = new HashMap<BigDecimal, CrmProcedure>();
			for (CrmProcedure row : tableService.getListProcedureActive()) {
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

	//
	public void searchPatientAction() {
		if (this.namePatient.isEmpty()) {
		} else {
			Bapikna111[] result = CustomerExecute.find(this.namePatient, 0);
			listPatient = new ArrayList<Patient>();
			if (result != null) {
				for (Bapikna111 row : result) {
					Patient patient = new Patient();
					patient.setSAPCode(row.getCustomer());
					patient.setNames(row.getFieldvalue());
					listPatient.add(patient);
				}
				patientModel = new PatientDataModel(listPatient);
			}
		}
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
		selectedPatient = new Patient();
		listPatient = new LinkedList<Patient>();
		patientModel = new PatientDataModel(listPatient);
		disabledSaveButton = false;

		selected = new CrmAppointment();
		selected.setCrmBranch(new CrmBranch());
		selected.setCrmDoctor(new CrmDoctor());
		selected.setCrmProcedureDetail(new CrmProcedureDetail());

		renderedForDate = false;
		renderedForDoctor = false;
	}

	public void saveAction() {
		String code = "";

		selected.setCode(code);
		selected.setCrmBranch(mapBranch.get(selected.getCrmBranch().getId()));
		selected.setCrmProcedureDetail(mapProcedureDetail.get(selected
				.getCrmProcedureDetail().getId()));

		processService.saveAppointment(selected);
	}

	public void handleProcedureChange() {
		listProcedureDetail = new LinkedList<SelectItem>();
		mapProcedureDetail = new HashMap<BigDecimal, CrmProcedureDetail>();
		for (CrmProcedureDetail row : tableService
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
			for (CrmDoctor row : tableService.getListDoctorActive()) {
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
		processService.getScheduleAppointment(selected.getCrmBranch().getId());
	}

}
