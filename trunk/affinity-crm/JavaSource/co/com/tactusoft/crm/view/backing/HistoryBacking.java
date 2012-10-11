package co.com.tactusoft.crm.view.backing;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import net.sf.jasperreports.engine.JRException;

import org.primefaces.event.DateSelectEvent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.GenerateFormulaPDF;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmCie;
import co.com.tactusoft.crm.model.entities.CrmCieMaterial;
import co.com.tactusoft.crm.model.entities.CrmDiagnosis;
import co.com.tactusoft.crm.model.entities.CrmHistoryHistory;
import co.com.tactusoft.crm.model.entities.CrmHistoryHomeopathic;
import co.com.tactusoft.crm.model.entities.CrmHistoryOrganometry;
import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmHistoryRecord;
import co.com.tactusoft.crm.model.entities.CrmMaterialGroup;
import co.com.tactusoft.crm.model.entities.CrmMedication;
import co.com.tactusoft.crm.model.entities.CrmNote;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.datamodel.AppointmentDataModel;
import co.com.tactusoft.crm.view.datamodel.CieDataModel;
import co.com.tactusoft.crm.view.datamodel.DiagnosisDataModel;
import co.com.tactusoft.crm.view.datamodel.MedicationDataModel;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;
import co.com.tactusoft.crm.view.datamodel.WSBeanDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomListsExecute;

@Named
@Scope("session")
public class HistoryBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	private CrmHistoryHistory selectedHistoryHistory;
	private CrmHistoryRecord selectedHistoryRecord;
	private CrmHistoryHomeopathic selectedHistoryHomeopathic;
	private CrmHistoryPhysique selectedHistoryPhysique;
	private CrmHistoryOrganometry selectedHistoryOrganometry;

	private List<CrmAppointment> listAppointment;
	private AppointmentDataModel appointmentModel;
	private CrmAppointment selectedAppointment;

	private Boolean disabledSaveButton;

	private boolean readOnlySelectedHistoryHistory;
	private boolean readOnlySelectedHistoryRecord;
	private boolean readOnlySelectedHistoryHomeopathic;
	private boolean readOnlySelectedHistoryPhysique;
	private boolean readOnlySelectedHistoryOrganometry;

	public int age;
	private double imc;
	private String descImc;
	private Date maxDate;

	private int optionSearchCie;
	private List<CrmCie> listCie;
	private CieDataModel cieModel;
	private CrmCie selectedCie;
	private String codeCIE;
	private String descCIE;
	private boolean disabledAddCie;

	private List<CrmDiagnosis> listDiagnosis;
	private DiagnosisDataModel diagnosisModel;
	private CrmDiagnosis[] selectedsDiagnosis;
	private CrmDiagnosis selectedDiagnosis;

	private List<WSBean> listAllBackupMaterial;
	private List<WSBean> listAllMaterial;
	private int optionSearchMaterial;
	private List<WSBean> listMaterial;
	private WSBeanDataModel materialModel;
	private WSBean selectedMaterial;
	private String codeMaterial;
	private String descMaterial;
	private boolean disabledAddMaterial;

	private List<CrmMedication> listMedication;
	private MedicationDataModel medicationModel;
	private CrmMedication[] selectedMedication;

	private List<CrmMedication> listExam;
	private MedicationDataModel examModel;
	private CrmMedication[] selectedExam;

	private List<CrmMedication> listTherapy;
	private MedicationDataModel therapyModel;
	private CrmMedication[] selectedTherapy;

	private String typeMedication;
	private String titleMedication;
	private int amount;
	private String noteDoctor;
	private boolean viewMode;
	private List<CrmMaterialGroup> listMaterialGroup;
	private List<CrmCieMaterial> listCieMaterial;

	private List<CrmDiagnosis> listDiagnosisView;
	private List<CrmMedication> listMedicationView;
	private List<CrmMedication> listTherapyView;
	private List<CrmMedication> listExamView;
	private List<CrmNote> listNoteView;

	private List<SelectItem> listOccupation;
	private Map<BigDecimal, CrmOccupation> mapOccupation;
	private BigDecimal idOccupation;
	private String neighborhood;
	private String typeHousing;

	public HistoryBacking() {
		newAction(null);
	}

	public CrmHistoryHistory getSelectedHistoryHistory() {
		return selectedHistoryHistory;
	}

	public void setSelectedHistoryHistory(
			CrmHistoryHistory selectedHistoryHistory) {
		this.selectedHistoryHistory = selectedHistoryHistory;
	}

	public CrmHistoryRecord getSelectedHistoryRecord() {
		return selectedHistoryRecord;
	}

	public void setSelectedHistoryRecord(CrmHistoryRecord selectedHistoryRecord) {
		this.selectedHistoryRecord = selectedHistoryRecord;
	}

	public CrmHistoryHomeopathic getSelectedHistoryHomeopathic() {
		return selectedHistoryHomeopathic;
	}

	public void setSelectedHistoryHomeopathic(
			CrmHistoryHomeopathic selectedHistoryHomeopathic) {
		this.selectedHistoryHomeopathic = selectedHistoryHomeopathic;
	}

	public CrmHistoryPhysique getSelectedHistoryPhysique() {
		return selectedHistoryPhysique;
	}

	public void setSelectedHistoryPhysique(
			CrmHistoryPhysique selectedHistoryPhysique) {
		this.selectedHistoryPhysique = selectedHistoryPhysique;
	}

	public CrmHistoryOrganometry getSelectedHistoryOrganometry() {
		return selectedHistoryOrganometry;
	}

	public void setSelectedHistoryOrganometry(
			CrmHistoryOrganometry selectedHistoryOrganometry) {
		this.selectedHistoryOrganometry = selectedHistoryOrganometry;
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

	public Boolean getDisabledSaveButton() {
		return disabledSaveButton;
	}

	public void setDisabledSaveButton(Boolean disabledSaveButton) {
		this.disabledSaveButton = disabledSaveButton;
	}

	public boolean isReadOnlySelectedHistoryHistory() {
		return readOnlySelectedHistoryHistory;
	}

	public void setReadOnlySelectedHistoryHistory(
			boolean readOnlySelectedHistoryHistory) {
		this.readOnlySelectedHistoryHistory = readOnlySelectedHistoryHistory;
	}

	public boolean isReadOnlySelectedHistoryRecord() {
		return readOnlySelectedHistoryRecord;
	}

	public void setReadOnlySelectedHistoryRecord(
			boolean readOnlySelectedHistoryRecord) {
		this.readOnlySelectedHistoryRecord = readOnlySelectedHistoryRecord;
	}

	public boolean isReadOnlySelectedHistoryHomeopathic() {
		return readOnlySelectedHistoryHomeopathic;
	}

	public void setReadOnlySelectedHistoryHomeopathic(
			boolean readOnlySelectedHistoryHomeopathic) {
		this.readOnlySelectedHistoryHomeopathic = readOnlySelectedHistoryHomeopathic;
	}

	public boolean isReadOnlySelectedHistoryPhysique() {
		return readOnlySelectedHistoryPhysique;
	}

	public void setReadOnlySelectedHistoryPhysique(
			boolean readOnlySelectedHistoryPhysique) {
		this.readOnlySelectedHistoryPhysique = readOnlySelectedHistoryPhysique;
	}

	public boolean isReadOnlySelectedHistoryOrganometry() {
		return readOnlySelectedHistoryOrganometry;
	}

	public void setReadOnlySelectedHistoryOrganometry(
			boolean readOnlySelectedHistoryOrganometry) {
		this.readOnlySelectedHistoryOrganometry = readOnlySelectedHistoryOrganometry;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public String getDescImc() {
		return descImc;
	}

	public void setDescImc(String descImc) {
		this.descImc = descImc;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}

	public int getOptionSearchCie() {
		return optionSearchCie;
	}

	public void setOptionSearchCie(int optionSearchCie) {
		this.optionSearchCie = optionSearchCie;
	}

	public List<CrmCie> getListCie() {
		return listCie;
	}

	public void setListCie(List<CrmCie> listCie) {
		this.listCie = listCie;
	}

	public CieDataModel getCieModel() {
		return cieModel;
	}

	public void setCieModel(CieDataModel cieModel) {
		this.cieModel = cieModel;
	}

	public CrmCie getSelectedCie() {
		return selectedCie;
	}

	public void setSelectedCie(CrmCie selectedCie) {
		this.selectedCie = selectedCie;
	}

	public String getCodeCIE() {
		return codeCIE;
	}

	public void setCodeCIE(String codeCIE) {
		this.codeCIE = codeCIE;
	}

	public String getDescCIE() {
		return descCIE;
	}

	public void setDescCIE(String descCIE) {
		this.descCIE = descCIE;
	}

	public boolean isDisabledAddCie() {
		return disabledAddCie;
	}

	public void setDisabledAddCie(boolean disabledAddCie) {
		this.disabledAddCie = disabledAddCie;
	}

	public List<CrmDiagnosis> getListDiagnosis() {
		return listDiagnosis;
	}

	public void setListDiagnosis(List<CrmDiagnosis> listDiagnosis) {
		this.listDiagnosis = listDiagnosis;
	}

	public DiagnosisDataModel getDiagnosisModel() {
		return diagnosisModel;
	}

	public void setDiagnosisModel(DiagnosisDataModel diagnosisModel) {
		this.diagnosisModel = diagnosisModel;
	}

	public CrmDiagnosis[] getSelectedsDiagnosis() {
		return selectedsDiagnosis;
	}

	public void setSelectedsDiagnosis(CrmDiagnosis[] selectedsDiagnosis) {
		this.selectedsDiagnosis = selectedsDiagnosis;
	}

	public CrmDiagnosis getSelectedDiagnosis() {
		return selectedDiagnosis;
	}

	public void setSelectedDiagnosis(CrmDiagnosis selectedDiagnosis) {
		this.selectedDiagnosis = selectedDiagnosis;
	}

	public int getOptionSearchMaterial() {
		return optionSearchMaterial;
	}

	public void setOptionSearchMaterial(int optionSearchMaterial) {
		this.optionSearchMaterial = optionSearchMaterial;
	}

	public List<WSBean> getListMaterial() {
		return listMaterial;
	}

	public void setListMaterial(List<WSBean> listMaterial) {
		this.listMaterial = listMaterial;
	}

	public WSBeanDataModel getMaterialModel() {
		return materialModel;
	}

	public void setMaterialModel(WSBeanDataModel materialModel) {
		this.materialModel = materialModel;
	}

	public WSBean getSelectedMaterial() {
		return selectedMaterial;
	}

	public void setSelectedMaterial(WSBean selectedMaterial) {
		this.selectedMaterial = selectedMaterial;
	}

	public String getCodeMaterial() {
		return codeMaterial;
	}

	public void setCodeMaterial(String codeMaterial) {
		this.codeMaterial = codeMaterial;
	}

	public String getDescMaterial() {
		return descMaterial;
	}

	public void setDescMaterial(String descMaterial) {
		this.descMaterial = descMaterial;
	}

	public boolean isDisabledAddMaterial() {
		return disabledAddMaterial;
	}

	public void setDisabledAddMaterial(boolean disabledAddMaterial) {
		this.disabledAddMaterial = disabledAddMaterial;
	}

	public List<CrmMedication> getListMedication() {
		return listMedication;
	}

	public void setListMedication(List<CrmMedication> listMedication) {
		this.listMedication = listMedication;
	}

	public MedicationDataModel getMedicationModel() {
		return medicationModel;
	}

	public void setMedicationModel(MedicationDataModel medicationModel) {
		this.medicationModel = medicationModel;
	}

	public CrmMedication[] getSelectedMedication() {
		return selectedMedication;
	}

	public void setSelectedMedication(CrmMedication[] selectedMedication) {
		this.selectedMedication = selectedMedication;
	}

	public List<CrmMedication> getListTherapy() {
		return listTherapy;
	}

	public void setListTherapy(List<CrmMedication> listTherapy) {
		this.listTherapy = listTherapy;
	}

	public MedicationDataModel getTherapyModel() {
		return therapyModel;
	}

	public void setTherapyModel(MedicationDataModel therapyModel) {
		this.therapyModel = therapyModel;
	}

	public CrmMedication[] getSelectedTherapy() {
		return selectedTherapy;
	}

	public void setSelectedTherapy(CrmMedication[] selectedTherapy) {
		this.selectedTherapy = selectedTherapy;
	}

	public List<WSBean> getListAllMaterial() {
		return listAllMaterial;
	}

	public void setListAllMaterial(List<WSBean> listAllMaterial) {
		this.listAllMaterial = listAllMaterial;
	}

	public List<CrmMedication> getListExam() {
		return listExam;
	}

	public void setListExam(List<CrmMedication> listExam) {
		this.listExam = listExam;
	}

	public MedicationDataModel getExamModel() {
		return examModel;
	}

	public void setExamModel(MedicationDataModel examModel) {
		this.examModel = examModel;
	}

	public CrmMedication[] getSelectedExam() {
		return selectedExam;
	}

	public void setSelectedExam(CrmMedication[] selectedExam) {
		this.selectedExam = selectedExam;
	}

	public String getTypeMedication() {
		return typeMedication;
	}

	public void setTypeMedication(String typeMedication) {
		this.typeMedication = typeMedication;
	}

	public String getTitleMedication() {
		if (typeMedication.equals(Constant.MATERIAL_TYPE_MEDICINE)) {
			titleMedication = FacesUtil.getMessage("his_history_medicaction");
		} else if (typeMedication.equals(Constant.MATERIAL_TYPE_THERAPY)) {
			titleMedication = FacesUtil.getMessage("his_history_therapy");
		} else if (typeMedication.equals(Constant.MATERIAL_TYPE_EXAMS)) {
			titleMedication = FacesUtil.getMessage("his_history_examinations");
		}
		return titleMedication;
	}

	public void setTitleMedication(String titleMedication) {
		this.titleMedication = titleMedication;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getNoteDoctor() {
		return noteDoctor;
	}

	public void setNoteDoctor(String noteDoctor) {
		this.noteDoctor = noteDoctor;
	}

	public boolean isViewMode() {
		return viewMode;
	}

	public void setViewMode(boolean viewMode) {
		this.viewMode = viewMode;
	}

	public List<CrmDiagnosis> getListDiagnosisView() {
		return listDiagnosisView;
	}

	public void setListDiagnosisView(List<CrmDiagnosis> listDiagnosisView) {
		this.listDiagnosisView = listDiagnosisView;
	}

	public List<CrmMedication> getListMedicationView() {
		return listMedicationView;
	}

	public void setListMedicationView(List<CrmMedication> listMedicationView) {
		this.listMedicationView = listMedicationView;
	}

	public List<CrmMedication> getListTherapyView() {
		return listTherapyView;
	}

	public void setListTherapyView(List<CrmMedication> listTherapyView) {
		this.listTherapyView = listTherapyView;
	}

	public List<CrmMedication> getListExamView() {
		return listExamView;
	}

	public void setListExamView(List<CrmMedication> listExamView) {
		this.listExamView = listExamView;
	}

	public List<CrmNote> getListNoteView() {
		return listNoteView;
	}

	public void setListNoteView(List<CrmNote> listNoteView) {
		this.listNoteView = listNoteView;
	}

	public List<SelectItem> getListOccupation() {
		if (listOccupation == null) {
			listOccupation = new LinkedList<SelectItem>();
			mapOccupation = new HashMap<BigDecimal, CrmOccupation>();
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listOccupation.add(new SelectItem(null, label));
			for (CrmOccupation row : tablesService.getListOccupationActive()) {
				mapOccupation.put(row.getId(), row);
				listOccupation.add(new SelectItem(row.getId(), row.getName()));
			}
		}
		return listOccupation;
	}

	public void setListOccupation(List<SelectItem> listOccupation) {
		this.listOccupation = listOccupation;
	}

	public Map<BigDecimal, CrmOccupation> getMapOccupation() {
		return mapOccupation;
	}

	public void setMapOccupation(Map<BigDecimal, CrmOccupation> mapOccupation) {
		this.mapOccupation = mapOccupation;
	}

	public BigDecimal getIdOccupation() {
		return idOccupation;
	}

	public void setIdOccupation(BigDecimal idOccupation) {
		this.idOccupation = idOccupation;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getTypeHousing() {
		return typeHousing;
	}

	public void setTypeHousing(String typeHousing) {
		this.typeHousing = typeHousing;
	}

	public void newAction(ActionEvent event) {
		selectedHistoryHistory = new CrmHistoryHistory();
		selectedHistoryRecord = new CrmHistoryRecord();
		selectedHistoryHomeopathic = new CrmHistoryHomeopathic();
		selectedHistoryPhysique = new CrmHistoryPhysique();
		selectedHistoryOrganometry = new CrmHistoryOrganometry();

		listAppointment = new ArrayList<CrmAppointment>();
		appointmentModel = new AppointmentDataModel(listAppointment);
		selectedAppointment = new CrmAppointment();

		docPatient = null;
		namePatient = null;
		selectedDiagnosis = new CrmDiagnosis();
		selectedsDiagnosis = null;

		listPatient = new ArrayList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		selectedPatient = new CrmPatient();
		selectedPatient.setCrmOccupation(new CrmOccupation());
		selectedPatient.getCrmOccupation().setId(Constant.DEFAULT_VALUE);
		idOccupation = null;
		neighborhood = null;
		typeHousing = null;

		disabledSaveButton = true;
		optionSearchPatient = 1;
		age = 0;
		imc = 0;
		descImc = null;

		codeMaterial = null;
		descMaterial = null;
		optionSearchMaterial = 1;

		readOnlySelectedHistoryHistory = true;
		readOnlySelectedHistoryRecord = true;
		readOnlySelectedHistoryHomeopathic = true;
		readOnlySelectedHistoryPhysique = true;
		readOnlySelectedHistoryOrganometry = true;

		maxDate = new Date();

		listDiagnosis = new ArrayList<CrmDiagnosis>();
		diagnosisModel = new DiagnosisDataModel(listDiagnosis);
		listMedication = new ArrayList<CrmMedication>();
		medicationModel = new MedicationDataModel(listMedication);
		listTherapy = new ArrayList<CrmMedication>();
		therapyModel = new MedicationDataModel(listTherapy);
		listExam = new ArrayList<CrmMedication>();
		examModel = new MedicationDataModel(listExam);
		viewMode = true;
		typeMedication = Constant.MATERIAL_TYPE_MEDICINE;

		listDiagnosisView = new ArrayList<CrmDiagnosis>();
		listMedicationView = new ArrayList<CrmMedication>();
		listTherapyView = new ArrayList<CrmMedication>();
		listExamView = new ArrayList<CrmMedication>();
		listNoteView = new ArrayList<CrmNote>();

		SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
		try {
			listAllBackupMaterial = CustomListsExecute.getMaterials(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword());
		} catch (Exception ex) {
			listAllBackupMaterial = new ArrayList<WSBean>();
		}

		refreshCieFields();
		refreshMaterialFields();
	}

	public void searchAction(ActionEvent event) {
		String message = null;
		age = 0;

		if (selectedPatient == null
				|| FacesUtil.isEmptyOrBlank(selectedPatient.getCodeSap())) {
			message = FacesUtil.getMessage("his_msg_error_1");
			FacesUtil.addError(message);
		} else {

			listMaterialGroup = processService.getListMaterialGroup();
			listCieMaterial = processService.getListCieMaterial();

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

			listAppointment = processService.listAppointmentByPatient(
					selectedPatient.getId(), "3,4");
			appointmentModel = new AppointmentDataModel(listAppointment);

			selectedHistoryHistory = processService
					.getHistoryHistory(selectedPatient.getId());
			selectedHistoryRecord = processService
					.getHistoryRecord(selectedPatient.getId());
			selectedHistoryHomeopathic = processService
					.getHistoryHomeopathic(selectedPatient.getId());
			selectedHistoryPhysique = processService
					.getHistoryPhysique(selectedPatient.getId());
			selectedHistoryOrganometry = processService
					.getHistoryOrganometry(selectedPatient.getId());

			refreshLists();
			getRenderedRecord();

			if (selectedPatient.getId() == null) {
				disabledSaveButton = true;
			} else {
				disabledSaveButton = false;
			}

			readOnlySelectedHistoryHistory = selectedHistoryHistory.getId() != null ? true
					: false;
			readOnlySelectedHistoryRecord = selectedHistoryRecord.getId() != null ? true
					: false;
			readOnlySelectedHistoryHomeopathic = selectedHistoryHomeopathic
					.getId() != null ? true : false;
			readOnlySelectedHistoryPhysique = selectedHistoryPhysique.getId() != null ? true
					: false;
			readOnlySelectedHistoryOrganometry = selectedHistoryOrganometry
					.getId() != null ? true : false;

			if (selectedHistoryPhysique.getId() != null) {
				calculateIMC();
			}
		}

		listDiagnosis = new ArrayList<CrmDiagnosis>();
		diagnosisModel = new DiagnosisDataModel(listDiagnosis);
	}

	private void refreshLists() {
		listDiagnosisView = processService
				.getListDiagnosisByPatient(selectedPatient.getId());

		listMedicationView = new ArrayList<CrmMedication>();
		listTherapyView = new ArrayList<CrmMedication>();
		listExamView = new ArrayList<CrmMedication>();

		List<CrmMedication> listAllMedication = processService
				.getListMedicationByPatient(selectedPatient.getId());

		for (CrmMedication row : listAllMedication) {
			if (row.getMaterialType().equals(Constant.MATERIAL_TYPE_MEDICINE)) {
				listMedicationView.add(row);
			} else if (row.getMaterialType().equals(
					Constant.MATERIAL_TYPE_THERAPY)) {
				listTherapyView.add(row);
			} else if (row.getMaterialType().equals(
					Constant.MATERIAL_TYPE_EXAMS)) {
				listExamView.add(row);
			}
		}

		listNoteView = processService.getListNoteByPatient(selectedPatient
				.getId());
	}

	public void saveAction(ActionEvent event) {
		String field = null;
		String message = null;

		if (selectedPatient == null || selectedPatient.getId() == null) {
			message = FacesUtil.getMessage("his_msg_error_1");
			FacesUtil.addError(message);
		}

		if (selectedPatient.getBornDate() == null) {
			field = FacesUtil.getMessage("pat_born_date");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (idOccupation == null || idOccupation.intValue() == 0) {
			field = FacesUtil.getMessage("pat_occupation");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		} else {
			selectedPatient.setCrmOccupation(mapOccupation.get(idOccupation));
		}

		if (FacesUtil.isEmptyOrBlank(neighborhood)) {
			field = FacesUtil.getMessage("pat_neighborhood");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		} else {
			selectedPatient.setNeighborhood(neighborhood);
		}

		if (FacesUtil.isEmptyOrBlank(typeHousing)) {
			field = FacesUtil.getMessage("pat_type_housing");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		} else {
			selectedPatient.setTypeHousing(typeHousing);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getReason())) {
			field = FacesUtil.getMessage("his_history_reason");
			message = FacesUtil.getMessage("his_history_history");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getDisease())) {
			field = FacesUtil.getMessage("his_history_disease");
			message = FacesUtil.getMessage("his_history_history");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getResults())) {
			field = FacesUtil.getMessage("his_history_results");
			message = FacesUtil.getMessage("his_history_history");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getArthritis()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getArthritisTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getArthritisMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_arthritis");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getCancer()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getCancerTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getCancerMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_cancer");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getPulmonary()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getPulmonaryTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getPulmonaryMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_pulmonary");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getDiabetes()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getDiabetesTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getDiabetesMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_diabetes");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getHypertension()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getHypertensionTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getHypertensionMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_hypertension");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getHospitalizations()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getHospitalizationsTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getHospitalizationsMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_hospitalizations");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getAllergy()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getAllergyTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getAllergyMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_allergy");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryRecord.getInfections()
				&& (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getInfectionsTime()) || FacesUtil
						.isEmptyOrBlank(selectedHistoryRecord
								.getInfectionsMedication()))) {
			field = FacesUtil.getMessage("his_rec_per_infections");
			message = FacesUtil.getMessage("his_history_record");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryPhysique.getHeartRate() == 0) {
			field = FacesUtil.getMessage("his_physique_heart_rate");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryPhysique.getRespiratoryRate() == 0) {
			field = FacesUtil.getMessage("his_physique_respiratory_rate");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryPhysique.getHeight().intValue() == 0) {
			field = FacesUtil.getMessage("his_physique_height");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryPhysique.getWeight().intValue() == 0) {
			field = FacesUtil.getMessage("his_physique_weight");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (FacesUtil
				.isEmptyOrBlank(selectedHistoryPhysique.getBloodPressure())) {
			field = FacesUtil.getMessage("his_physique_blood_pressure");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addError(message);
		}

		if (selectedHistoryOrganometry.getOrganometryCheck()) {
			if (FacesUtil.isEmptyOrBlank(selectedHistoryOrganometry
					.getOrganometryAnalysis())) {
				field = FacesUtil.getMessage("his_organometry_analysis");
				message = FacesUtil.getMessage("his_organometry", field);
				message = message + " - "
						+ FacesUtil.getMessage("glb_required", field);
				FacesUtil.addError(message);
			}
		}

		if (message == null) {

			selectedHistoryHistory.setCrmPatient(selectedPatient);
			selectedHistoryRecord.setCrmPatient(selectedPatient);
			selectedHistoryHomeopathic.setCrmPatient(selectedPatient);
			selectedHistoryPhysique.setCrmPatient(selectedPatient);
			selectedHistoryOrganometry.setCrmPatient(selectedPatient);

			int result = processService.savePatient(selectedPatient, false,
					false, null);
			if (result == 0) {

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getHead())) {
					selectedHistoryHistory.setHead(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory
						.getNeuromuscular())) {
					selectedHistoryHistory
							.setNeuromuscular(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getOrl())) {
					selectedHistoryHistory.setOrl(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getGu())) {
					selectedHistoryHistory.setGu(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getCr())) {
					selectedHistoryHistory.setCr(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory
						.getPsychiatric())) {
					selectedHistoryHistory
							.setPsychiatric(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getGi())) {
					selectedHistoryHistory.setGi(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getSkin())) {
					selectedHistoryHistory.setSkin(Constant.HISTORY_NOT_REFER);
				}

				// RECORD
				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getArthritisMedication())) {
					selectedHistoryRecord
							.setArthritisMedication(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getArthritisTime())) {
					selectedHistoryRecord
							.setArthritisTime(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getCancerMedication())) {
					selectedHistoryRecord
							.setCancerMedication(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getCancerTime())) {
					selectedHistoryRecord
							.setCancerTime(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getPulmonaryMedication())) {
					selectedHistoryRecord
							.setPulmonaryMedication(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getPulmonaryTime())) {
					selectedHistoryRecord
							.setPulmonaryTime(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getDiabetesMedication())) {
					selectedHistoryRecord
							.setDiabetesMedication(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getDiabetesTime())) {
					selectedHistoryRecord
							.setDiabetesTime(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getHypertensionMedication())) {
					selectedHistoryRecord
							.setHypertensionMedication(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getHypertensionTime())) {
					selectedHistoryRecord
							.setHypertensionTime(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getHospitalizationsMedication())) {
					selectedHistoryRecord
							.setHospitalizationsMedication(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getHospitalizationsTime())) {
					selectedHistoryRecord
							.setHospitalizationsTime(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getAllergyMedication())) {
					selectedHistoryRecord
							.setAllergyMedication(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getAllergyTime())) {
					selectedHistoryRecord
							.setAllergyTime(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getInfectionsMedication())) {
					selectedHistoryRecord
							.setInfectionsMedication(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getInfectionsTime())) {
					selectedHistoryRecord
							.setInfectionsTime(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getOccupational())) {
					selectedHistoryRecord
							.setOccupational(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord.getToxic())) {
					selectedHistoryRecord.setToxic(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getBloodType())) {
					selectedHistoryRecord
							.setBloodType(Constant.HISTORY_NOT_REFER);
				}

				// HOMEOPATHIC
				if (FacesUtil.isEmptyOrBlank(selectedHistoryHomeopathic
						.getMental())) {
					selectedHistoryHomeopathic
							.setMental(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHomeopathic
						.getSpecial())) {
					selectedHistoryHomeopathic
							.setSpecial(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHomeopathic
						.getGeneral())) {
					selectedHistoryHomeopathic
							.setGeneral(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHomeopathic
						.getMiasm())) {
					selectedHistoryHomeopathic
							.setMiasm(Constant.HISTORY_NOT_REFER);
				}

				// PHYSIQUE
				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getGeneralState())) {
					selectedHistoryPhysique
							.setGeneralState(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getHeadNeck())) {
					selectedHistoryPhysique
							.setHeadNeck(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getChest())) {
					selectedHistoryPhysique
							.setChest(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getLungs())) {
					selectedHistoryPhysique
							.setLungs(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getHeart())) {
					selectedHistoryPhysique
							.setHeart(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getAbdomen())) {
					selectedHistoryPhysique
							.setAbdomen(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getGenitals())) {
					selectedHistoryPhysique
							.setGenitals(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getOsteo())) {
					selectedHistoryPhysique
							.setOsteo(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getTips())) {
					selectedHistoryPhysique.setTips(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getHighlights())) {
					selectedHistoryPhysique
							.setHighlights(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getSkin())) {
					selectedHistoryPhysique.setSkin(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getObs())) {
					selectedHistoryPhysique.setObs(Constant.HISTORY_NOT_REFER);
				}

				result = processService
						.saveHistoryHistory(selectedHistoryHistory);
				if (result == 0) {
					result = processService
							.saveHistoryRecord(selectedHistoryRecord);
					if (result == 0) {
						result = processService
								.saveHistoryHomeopathic(selectedHistoryHomeopathic);
						if (result == 0) {
							result = processService
									.saveHistoryPhysique(selectedHistoryPhysique);
							if (result == 0) {
								result = processService
										.saveHistoryOrganometry(selectedHistoryOrganometry);
								if (result == 0) {
									message = FacesUtil
											.getMessage("msg_record_ok");
									FacesUtil.addInfo(message);
								} else {

								}
							} else {

							}
						} else {

						}
					} else {

					}
				} else {

				}
			}
		}
	}

	public int getRenderedRecord() {
		int result = 0;
		if (selectedPatient == null) {
			result = 0;
		} else if (selectedPatient.getId() == null) {
			result = 0;
		} else {
			if (selectedPatient.getAge() <= 5) {
				result = 1;
			} else {
				if (selectedPatient.getGender().equals("W")) {
					result = 2;
				} else {
					result = 3;
				}
			}
		}
		return result;
	}

	public void calculateIMC() {
		double weight = selectedHistoryPhysique.getWeight().doubleValue();
		double height = selectedHistoryPhysique.getHeight().doubleValue() / 100;

		if (height > 0) {
			imc = weight / (height * height);
		} else {
			imc = 0;
		}

		if (imc < 185) {
			descImc = "INFERIOR";
		} else if (imc >= 185 && imc <= 249) {
			descImc = "NORMAL";
		} else if (imc >= 250 && imc <= 299) {
			descImc = "SOBREPESO";
		} else if (imc >= 300) {
			descImc = "OBESIDAD";
		}
	}

	public void handleBornDateSelect(DateSelectEvent event) {
		Date bornDate = event.getDate();
		age = calculateAge(bornDate);
	}

	private int calculateAge(Date bornDate) {
		int age = 0;
		if (bornDate != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(bornDate);

			Calendar currentDate = Calendar.getInstance();
			currentDate.setTime(new Date());

			age = currentDate.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);

			if ((calendar.get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))
					|| (calendar.get(Calendar.MONTH) == currentDate
							.get(Calendar.MONTH) && calendar
							.get(Calendar.DAY_OF_MONTH) > currentDate
							.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		}
		return age;
	}

	public void searchCIEAction(ActionEvent event) {
		if ((optionSearchCie == 1 && this.codeCIE.isEmpty())
				|| (optionSearchCie == 2 && this.descCIE.isEmpty())) {
			this.listCie = new ArrayList<CrmCie>();
			disabledAddCie = true;
		} else {
			if (optionSearchCie == 1) {
				this.listCie = processService.getListCieByCode(codeCIE);
			} else {
				this.listCie = processService.getListCieByName(descCIE);
			}

			if (listCie.size() > 0) {
				selectedCie = listCie.get(0);
				disabledAddCie = false;
			} else {
				disabledAddCie = true;
			}
		}
		refreshListCie();
	}

	public void addCieAction(ActionEvent event) {
		BigDecimal id = new BigDecimal(listDiagnosis.size() + 1);
		CrmDiagnosis diagnosis = new CrmDiagnosis();
		diagnosis.setId(id);
		diagnosis.setCrmAppointment(selectedAppointment);
		diagnosis.setCrmCie(selectedCie);
		listDiagnosis.add(diagnosis);
		diagnosisModel = new DiagnosisDataModel(listDiagnosis);
		refreshListCie();
	}

	public void searchDiagnosisAction(ActionEvent event) {
		optionSearchCie = 1;
	}

	private void refreshListCie() {
		List<CrmCie> listCieFilter = new ArrayList<CrmCie>();
		for (CrmCie row : listCie) {
			boolean filter = true;
			for (CrmDiagnosis dig : listDiagnosis) {
				if (row.getId().intValue() == dig.getCrmCie().getId()
						.intValue()) {
					filter = false;
					break;
				}
			}

			if (filter) {
				listCieFilter.add(row);
			}
		}

		this.cieModel = new CieDataModel(listCieFilter);
		if (listCieFilter.size() > 0) {
			selectedCie = listCieFilter.get(0);
			disabledAddCie = false;
		} else {
			disabledAddCie = true;
		}
	}

	public void removeDiagnosisAction(ActionEvent event) {
		for (CrmDiagnosis row : selectedsDiagnosis) {
			listDiagnosis.remove(row);

			List<CrmMedication> listDelete = new ArrayList<CrmMedication>();
			for (CrmMedication med : listMedication) {
				if (med.getCrmCie().getId().intValue() == row.getCrmCie()
						.getId().intValue()) {
					listDelete.add(med);
				}
			}

			for (CrmMedication med : listDelete) {
				listMedication.remove(med);
			}
		}
		diagnosisModel = new DiagnosisDataModel(listDiagnosis);
	}

	public boolean isDisabledDiagnosis() {
		return listDiagnosis.size() == 0 ? true : false;
	}

	// Medication
	public void searchMaterialAction(ActionEvent event) {
		if ((optionSearchMaterial == 1 && this.codeMaterial.isEmpty())
				|| (optionSearchMaterial == 2 && this.descMaterial.isEmpty())) {
			this.listMaterial = new ArrayList<WSBean>();
			disabledAddMaterial = true;
		} else {
			this.listMaterial = new ArrayList<WSBean>();
			for (WSBean material : listAllMaterial) {
				if (optionSearchMaterial == 1) {
					if (material.getCode().toUpperCase()
							.contains(codeMaterial.toUpperCase())) {
						this.listMaterial.add(material);
					}
				} else {
					if (material.getNames().toUpperCase()
							.contains(descMaterial.toUpperCase())) {
						this.listMaterial.add(material);
					}
				}
			}

			if (listMaterial.size() > 0) {
				selectedMaterial = listMaterial.get(0);
				disabledAddMaterial = false;
			} else {
				disabledAddMaterial = true;
			}
		}
		refreshListMedication();
	}

	public void addMaterialAction(ActionEvent event) {
		BigDecimal id = new BigDecimal(listMedication.size() + 1);
		CrmMedication medication = new CrmMedication();
		medication.setId(id);
		medication.setCrmAppointment(selectedAppointment);
		medication.setCrmCie(selectedDiagnosis.getCrmCie());
		medication.setCodMaterial(Integer.parseInt(selectedMaterial.getCode()));
		medication.setDescMaterial(selectedMaterial.getNames());
		medication.setMaterialType(typeMedication);
		medication.setUnit(amount);

		if (typeMedication.equals(Constant.MATERIAL_TYPE_MEDICINE)) {
			listMedication.add(medication);
			medicationModel = new MedicationDataModel(listMedication);
		} else if (typeMedication.equals(Constant.MATERIAL_TYPE_THERAPY)) {
			listTherapy.add(medication);
			therapyModel = new MedicationDataModel(listTherapy);
		} else if (typeMedication.equals(Constant.MATERIAL_TYPE_EXAMS)) {
			listExam.add(medication);
			examModel = new MedicationDataModel(listExam);
		}

		refreshListMedication();
	}

	public void searchMedicationAction(ActionEvent event) {
		optionSearchCie = 1;
	}

	private void refreshListMedication() {
		List<WSBean> listFilter = new ArrayList<WSBean>();
		for (WSBean row : listMaterial) {
			boolean filter = true;
			if (typeMedication.equals(Constant.MATERIAL_TYPE_MEDICINE)) {
				for (CrmMedication med : listMedication) {
					if (Long.parseLong(row.getCode()) == med.getCodMaterial()) {
						filter = false;
						break;
					}
				}
			} else if (typeMedication.equals(Constant.MATERIAL_TYPE_THERAPY)) {
				for (CrmMedication med : listTherapy) {
					if (Long.parseLong(row.getCode()) == med.getCodMaterial()) {
						filter = false;
						break;
					}
				}
			} else if (typeMedication.equals(Constant.MATERIAL_TYPE_EXAMS)) {
				for (CrmMedication med : listExam) {
					if (Long.parseLong(row.getCode()) == med.getCodMaterial()) {
						filter = false;
						break;
					}
				}
			}

			if (filter) {
				listFilter.add(row);
			}
		}

		this.materialModel = new WSBeanDataModel(listFilter);
		if (listFilter.size() > 0) {
			selectedMaterial = listFilter.get(0);
			disabledAddMaterial = false;
		} else {
			disabledAddMaterial = true;
		}
	}

	public void removeMedicationAction(ActionEvent event) {
		for (CrmMedication row : selectedMedication) {
			listMedication.remove(row);
		}
		medicationModel = new MedicationDataModel(listMedication);
	}

	public void removeTherapyAction(ActionEvent event) {
		for (CrmMedication row : selectedTherapy) {
			listTherapy.remove(row);
		}
		therapyModel = new MedicationDataModel(listTherapy);
		selectedTherapy = null;
	}

	public void removeExamAction(ActionEvent event) {
		for (CrmMedication row : selectedExam) {
			listExam.remove(row);
		}
		examModel = new MedicationDataModel(listExam);
		selectedExam = null;
	}

	public void refreshCieFields() {
		optionSearchCie = 1;
		listCie = new ArrayList<CrmCie>();
		cieModel = new CieDataModel(listCie);
		selectedCie = new CrmCie();
		codeCIE = null;
		descCIE = null;
		disabledAddCie = true;
	}

	public void refreshMaterialFields() {
		optionSearchMaterial = 1;
		listMaterial = new ArrayList<WSBean>();
		materialModel = new WSBeanDataModel(listMaterial);
		selectedMaterial = new WSBean();
		codeMaterial = null;
		descMaterial = null;
		disabledAddMaterial = true;
		amount = 1;
	}

	public void selectDiagnosisAction(ActionEvent event) {
		refreshCieFields();
	}

	public void selectMedicationAction() {
		this.typeMedication = Constant.MATERIAL_TYPE_MEDICINE;
		refreshMaterialFields();

		listAllMaterial = new ArrayList<WSBean>();
		for (CrmCieMaterial row : listCieMaterial) {
			if (selectedDiagnosis.getCrmCie().getId().intValue() == row
					.getCrmCie().getId().intValue()) {
				listMaterial.add(new WSBean(row.getMaterial(), row
						.getDescription()));
				listAllMaterial.add(new WSBean(row.getMaterial(), row
						.getDescription()));
			}
		}

		if (listMaterial.size() == 0) {
			for (WSBean material : listAllBackupMaterial) {
				boolean validateGroup = false;
				for (CrmMaterialGroup row : listMaterialGroup) {
					if (row.getMaterialType().equals(typeMedication)
							&& material.getType().equals(row.getGroup())) {
						validateGroup = true;
						break;
					}
				}

				if (validateGroup) {
					listMaterial.add(material);
					listAllMaterial.add(material);
				}
			}
		}

		refreshListMedication();
	}

	public void selectTherapyAction(ActionEvent event) {
		this.typeMedication = Constant.MATERIAL_TYPE_THERAPY;
		listAllMaterial = new ArrayList<WSBean>();

		for (WSBean material : listAllBackupMaterial) {
			boolean validateGroup = false;
			for (CrmMaterialGroup row : listMaterialGroup) {
				if (row.getMaterialType().equals(typeMedication)
						&& material.getType().equals(row.getGroup())) {
					validateGroup = true;
					break;
				}
			}

			if (validateGroup) {
				listAllMaterial.add(material);
			}
		}
		refreshMaterialFields();
	}

	public void selectExamsAction(ActionEvent event) {
		this.typeMedication = Constant.MATERIAL_TYPE_EXAMS;
		listAllMaterial = new ArrayList<WSBean>();

		for (WSBean material : listAllBackupMaterial) {
			boolean validateGroup = false;
			for (CrmMaterialGroup row : listMaterialGroup) {
				if (row.getMaterialType().equals(typeMedication)
						&& material.getType().equals(row.getGroup())) {
					validateGroup = true;
					break;
				}
			}

			if (validateGroup) {
				listAllMaterial.add(material);
			}
		}
		refreshMaterialFields();
	}

	public void closeAppointmentAction(ActionEvent event) {
		String message = null;
		boolean medicationTherapy = false;

		if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {
			if (listDiagnosis.size() < 2) {
				message = FacesUtil.getMessage("his_msg_message_dig_1");
				FacesUtil.addWarn(message);
			} else {
				for (CrmDiagnosis row : listDiagnosis) {
					if (FacesUtil.isEmptyOrBlank(row.getPosology())) {
						message = FacesUtil.getMessage("his_msg_message_dig_2");
						FacesUtil.addWarn(message);
						break;
					}
				}
			}

			if (listMedication.size() == 0) {
				message = FacesUtil.getMessage("his_msg_message_med_1");
				FacesUtil.addWarn(message);
			}

			if (listTherapy.size() > 0) {
				for (CrmMedication row : listTherapy) {
					if (FacesUtil.isEmptyOrBlank(row.getDiagnosis())) {
						message = FacesUtil.getMessage("his_msg_message_med_2");
						FacesUtil.addWarn(message);
						break;
					}
				}
				medicationTherapy = true;
			}

			if (FacesUtil.isEmptyOrBlank(noteDoctor)) {
				String field = FacesUtil.getMessage("his_history_note");
				message = FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
			}

			if (message == null) {
				processService
						.saveDiagnosis(selectedAppointment, listDiagnosis);
				processService.saveMedication(selectedAppointment,
						listMedication, Constant.MATERIAL_TYPE_MEDICINE);
				processService.saveMedication(selectedAppointment, listTherapy,
						Constant.MATERIAL_TYPE_THERAPY);
				processService.saveMedication(selectedAppointment, listExam,
						Constant.MATERIAL_TYPE_EXAMS);
				processService.saveNotes(selectedAppointment, noteDoctor,
						Constant.NOTE_TYPE_DOCTOR);

				viewMode = true;
				selectedAppointment.setMedicationTherapy(medicationTherapy);
				selectedAppointment.setCloseAppointment(true);
				selectedAppointment.setState(Constant.APP_STATE_ATTENDED);
				processService.saveAppointment(selectedAppointment);
				message = FacesUtil.getMessage("his_msg_message_med_ok");
				FacesUtil.addInfo(message);
				refreshLists();
			}
		} else if (this.getRolePrincipal().equals(Constant.ROLE_NURSE)) {
			if (FacesUtil.isEmptyOrBlank(noteDoctor)) {
				String field = FacesUtil.getMessage("his_history_note");
				message = FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
			} else {
				processService.saveNotes(selectedAppointment, noteDoctor,
						Constant.NOTE_TYPE_NURSE);

				viewMode = true;
				selectedAppointment.setCloseAppointment(true);
				selectedAppointment.setState(Constant.APP_STATE_ATTENDED);
				processService.saveAppointment(selectedAppointment);
				message = FacesUtil.getMessage("his_msg_message_med_ok");
				FacesUtil.addInfo(message);
				refreshLists();
			}
		}
	}

	public void printFormulaAction() {
		try {
			GenerateFormulaPDF.PDF(selectedAppointment.getId(),
					Constant.MATERIAL_TYPE_MEDICINE);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printFormulaTherapyAction() {
		try {
			GenerateFormulaPDF.PDF(selectedAppointment.getId(),
					Constant.MATERIAL_TYPE_THERAPY);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isDisabledMedication() {
		return listMedication.size() == 0 ? true : false;
	}

	public boolean isDisabledTherapy() {
		return listTherapy.size() == 0 ? true : false;
	}

	public boolean isDisabledExam() {
		return listExam.size() == 0 ? true : false;
	}

}
