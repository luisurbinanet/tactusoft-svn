package co.com.tactusoft.crm.view.backing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import net.sf.jasperreports.engine.JRException;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.GenerateFormulaPDF;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCaseStudy;
import co.com.tactusoft.crm.model.entities.CrmCie;
import co.com.tactusoft.crm.model.entities.CrmConsent;
import co.com.tactusoft.crm.model.entities.CrmDiagnosis;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmHistoryConsultant;
import co.com.tactusoft.crm.model.entities.CrmHistoryHistory;
import co.com.tactusoft.crm.model.entities.CrmHistoryHomeopathic;
import co.com.tactusoft.crm.model.entities.CrmHistoryOrganometry;
import co.com.tactusoft.crm.model.entities.CrmHistoryPhysique;
import co.com.tactusoft.crm.model.entities.CrmHistoryRecord;
import co.com.tactusoft.crm.model.entities.CrmHoliday;
import co.com.tactusoft.crm.model.entities.CrmMaterialGroup;
import co.com.tactusoft.crm.model.entities.CrmMedication;
import co.com.tactusoft.crm.model.entities.CrmNote;
import co.com.tactusoft.crm.model.entities.CrmNurse;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;
import co.com.tactusoft.crm.model.entities.CrmTherapy;
import co.com.tactusoft.crm.model.entities.VwAppointment;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.DataModelCustom;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.beans.Candidate;
import co.com.tactusoft.crm.view.beans.ResultSearchAppointment;
import co.com.tactusoft.crm.view.datamodel.CandidateDataModel;
import co.com.tactusoft.crm.view.datamodel.CieDataModel;
import co.com.tactusoft.crm.view.datamodel.DiagnosisDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryHistoryDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryHomeopathicDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryOrganometryDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryPhysiqueDataModel;
import co.com.tactusoft.crm.view.datamodel.HistoryRecordDataModel;
import co.com.tactusoft.crm.view.datamodel.MedicationDataModel;
import co.com.tactusoft.crm.view.datamodel.VwAppointmentDataModel;
import co.com.tactusoft.crm.view.datamodel.WSBeanDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomListsExecute;

@Named
@Scope("session")
public class HistoryBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	protected CrmDoctor currentDoctor;
	protected CrmNurse currentNurse;
	protected CrmAppointment currentAppointment;
	protected CrmNote currentNote;

	protected List<VwAppointment> listAppointment;
	protected VwAppointmentDataModel appointmentModel;
	protected VwAppointment selectedAppointment;
	protected VwAppointment selectedAppointmentPrint;

	protected boolean modeEdit;
	protected boolean modeHistorial;
	protected String part;

	protected VwAppointmentDataModel historyAppointmentModel;
	protected HistoryHistoryDataModel historyHistoryModel;
	protected HistoryRecordDataModel historyRecordModel;
	protected HistoryHomeopathicDataModel historyHomeopathicModel;
	protected HistoryPhysiqueDataModel historyPhysiqueModel;
	protected HistoryOrganometryDataModel historyOrganometryModel;
	protected DataModelCustom<CrmHistoryConsultant> historyConsultantModel;

	protected CrmHistoryHistory selectedHistoryHistory;
	protected CrmHistoryRecord selectedHistoryRecord;
	protected CrmHistoryHomeopathic selectedHistoryHomeopathic;
	protected CrmHistoryPhysique selectedHistoryPhysique;
	protected CrmHistoryOrganometry selectedHistoryOrganometry;
	protected CrmHistoryConsultant selectedHistoryConsultant;

	protected int activeIndex = -1;
	protected BigDecimal idOccupation;
	protected String neighborhood;
	protected String typeHousing;
	protected int age;
	protected BigDecimal idMembershipType;
	protected double imc;
	protected String descImc;
	protected int heartRate;
	protected int respiratoryRate;
	protected Double height;
	protected Double weight;

	protected int optionSearchCie;
	protected List<CrmCie> listCie;
	protected CieDataModel cieModel;
	protected CrmCie selectedCie;
	protected String codeCIE;
	protected String descCIE;
	protected boolean disabledAddCie;

	protected List<CrmDiagnosis> listDiagnosis;
	protected DiagnosisDataModel diagnosisModel;
	protected CrmDiagnosis[] selectedsDiagnosis;
	protected CrmDiagnosis selectedDiagnosis;

	protected List<WSBean> listAllBackupMaterial;
	protected List<WSBean> listAllMaterial;
	protected int optionSearchMaterial;
	protected List<WSBean> listMaterial;
	protected WSBeanDataModel materialModel;
	protected WSBean selectedMaterial;
	protected String codeMaterial;
	protected String descMaterial;
	protected boolean disabledAddMaterial;

	protected List<CrmMedication> listMedication;
	protected MedicationDataModel medicationModel;
	protected CrmMedication[] selectedMedication;

	protected List<CrmMedication> listOtherMedication;
	protected MedicationDataModel otherMedicationModel;
	protected CrmMedication[] selectedOtherMedication;

	protected List<CrmMedication> listExam;
	protected MedicationDataModel examModel;
	protected CrmMedication[] selectedExam;

	protected List<CrmMedication> listTherapy;
	protected MedicationDataModel therapyModel;
	protected CrmMedication[] selectedTherapy;

	protected String typeMedication;
	protected String titleMedication;
	protected int amount;
	protected String noteType;
	protected String noteDoctor;
	protected boolean viewMode;
	protected List<CrmMaterialGroup> listMaterialGroup;

	protected List<CrmDiagnosis> listDiagnosisView;
	protected List<CrmMedication> listMedicationView;
	protected List<CrmMedication> listTherapyView;
	protected List<CrmMedication> listExamView;
	protected List<CrmNote> listNoteView;
	protected List<CrmConsent> listConsentView;
	protected List<CrmCaseStudy> listSuccessStoryView;

	protected List<SelectItem> listNoteTherapyItem;
	protected Map<Integer, Object> mapNoteTherapy;
	protected Integer idNoteTherapy;
	protected boolean autoNote;

	protected CrmCaseStudy selectedCaseStudy;
	protected List<CrmCie> listCaseStudyCieTemp;
	protected List<SelectItem> listCaseStudyCie;
	protected List<String> listCaseStudyHistoryTemp;
	protected List<SelectItem> listCaseStudyHistory;
	protected BigDecimal idCaseStudyCie;

	protected byte[] consentFile;
	protected Date consentDate;
	protected String consentType;

	protected HtmlPanelGrid containerComponent;
	protected String typeHistory;
	protected String posology;

	private List<SelectItem> listBranchByConsultant;
	private Map<BigDecimal, CrmBranch> mapBranchByConsultant;
	private List<SelectItem> listProcedureDetail;
	private Map<BigDecimal, CrmProcedureDetail> mapProcedureDetail;
	private BigDecimal idProcedureDetail;
	private CrmProcedureDetail procedureDetail;
	private Date currentDate;
	private int minutes = 0;
	private String timeType = null;
	private String infoMessageDate;
	private List<Candidate> listCandidate;
	private CandidateDataModel modelCandidate;
	private Candidate selectedCandidate;
	private Candidate selectedCandidateTemp;
	private int appointmentsNumber;
	private String infoMessage;
	private boolean saved;
	private CrmAppointment selectedApp;
	private boolean validate;
	private boolean disabledSearch;
	private StreamedContent contentHistory;

	public HistoryBacking() {
		newAction(null);
	}

	@PostConstruct
	public void init() {
		appointmentModel = null;
		modeEdit = false;
		modeHistorial = false;
		listMaterialGroup = processService.getListMaterialGroup();
		currentDoctor = processService.getCrmDoctor();
		containerComponent = new HtmlPanelGrid();
	}

	public CrmDoctor getCurrentDoctor() {
		return currentDoctor;
	}

	public void setCurrentDoctor(CrmDoctor currentDoctor) {
		this.currentDoctor = currentDoctor;
	}

	public CrmAppointment getCurrentAppointment() {
		return currentAppointment;
	}

	public void setCurrentAppointment(CrmAppointment currentAppointment) {
		this.currentAppointment = currentAppointment;
	}

	public CrmNurse getCurrentNurse() {
		return currentNurse;
	}

	public void setCurrentNurse(CrmNurse currentNurse) {
		this.currentNurse = currentNurse;
	}

	public VwAppointment getSelectedAppointmentPrint() {
		return selectedAppointmentPrint;
	}

	public void setSelectedAppointmentPrint(
			VwAppointment selectedAppointmentPrint) {
		this.selectedAppointmentPrint = selectedAppointmentPrint;
	}

	public CrmNote getCurrentNote() {
		return currentNote;
	}

	public void setCurrentNote(CrmNote currentNote) {
		this.currentNote = currentNote;
	}

	public List<VwAppointment> getListAppointment() {
		return listAppointment;
	}

	public void setListAppointment(List<VwAppointment> listAppointment) {
		this.listAppointment = listAppointment;
	}

	public VwAppointmentDataModel getAppointmentModel() {
		if (appointmentModel == null) {
			if (currentDoctor != null) {
				listAppointment = processService
						.getListVwAppointmentByHistory(currentDoctor.getId());
				if (this.getRolePrincipal().equals(Constant.ROLE_CONSULTANT)) {
					newAppAction(null);
					List<CrmBranch> listBranchByConsultantTemp = processService
							.getListBranchByDoctor(currentDoctor.getId());
					try {
						listBranchByConsultant = FacesUtil.entityToSelectItem(
								listBranchByConsultantTemp, "getId", "getName");
						mapBranchByConsultant = FacesUtil.entityToMap(
								listBranchByConsultantTemp, "getId");
						if (listBranchByConsultantTemp != null
								&& !listBranchByConsultantTemp.isEmpty()) {
							idBranch = listBranchByConsultantTemp.get(0)
									.getId();
							handleBranchChange();
						} else {
							disabledSearch = true;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else {
				if (this.getRolePrincipal().equals(Constant.ROLE_NURSE_AUX)) {
					BigDecimal idBranch = FacesUtil.getCurrentUserData()
							.getListBranch().get(0).getId();
					listAppointment = processService
							.getListVwAppointmentByBranch(idBranch);
				}
			}

			if (listAppointment != null && listAppointment.size() > 0) {
				appointmentModel = new VwAppointmentDataModel(listAppointment);
				selectedAppointment = listAppointment.get(0);
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

	public boolean isModeHistorial() {
		return modeHistorial;
	}

	public void setModeHistorial(boolean modeHistorial) {
		this.modeHistorial = modeHistorial;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public VwAppointmentDataModel getHistoryAppointmentModel() {
		return historyAppointmentModel;
	}

	public void setHistoryAppointmentModel(
			VwAppointmentDataModel historyAppointmentModel) {
		this.historyAppointmentModel = historyAppointmentModel;
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

	public DataModelCustom<CrmHistoryConsultant> getHistoryConsultantModel() {
		return historyConsultantModel;
	}

	public void setHistoryConsultantModel(
			DataModelCustom<CrmHistoryConsultant> historyConsultantModel) {
		this.historyConsultantModel = historyConsultantModel;
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

	public CrmHistoryConsultant getSelectedHistoryConsultant() {
		return selectedHistoryConsultant;
	}

	public void setSelectedHistoryConsultant(
			CrmHistoryConsultant selectedHistoryConsultant) {
		this.selectedHistoryConsultant = selectedHistoryConsultant;
	}

	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getIdMembershipType() {
		return idMembershipType;
	}

	public void setIdMembershipType(BigDecimal idMembershipType) {
		this.idMembershipType = idMembershipType;
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

	public int getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	public int getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(int respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setDescImc(String descImc) {
		this.descImc = descImc;
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

	public List<WSBean> getListAllBackupMaterial() {
		return listAllBackupMaterial;
	}

	public void setListAllBackupMaterial(List<WSBean> listAllBackupMaterial) {
		this.listAllBackupMaterial = listAllBackupMaterial;
	}

	public List<WSBean> getListAllMaterial() {
		return listAllMaterial;
	}

	public void setListAllMaterial(List<WSBean> listAllMaterial) {
		this.listAllMaterial = listAllMaterial;
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

	public List<CrmMedication> getListOtherMedication() {
		return listOtherMedication;
	}

	public void setListOtherMedication(List<CrmMedication> listOtherMedication) {
		this.listOtherMedication = listOtherMedication;
	}

	public MedicationDataModel getOtherMedicationModel() {
		return otherMedicationModel;
	}

	public void setOtherMedicationModel(MedicationDataModel otherMedicationModel) {
		this.otherMedicationModel = otherMedicationModel;
	}

	public CrmMedication[] getSelectedOtherMedication() {
		return selectedOtherMedication;
	}

	public void setSelectedOtherMedication(
			CrmMedication[] selectedOtherMedication) {
		this.selectedOtherMedication = selectedOtherMedication;
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
		} else if (typeMedication.equals(Constant.MATERIAL_TYPE_OTHER_MEDICINE)) {
			titleMedication = FacesUtil
					.getMessage("his_history_other_medicaction");
		} else if (typeMedication.equals(Constant.MATERIAL_TYPE_ODONTOLOGY)) {
			titleMedication = FacesUtil
					.getMessage("his_history_other_medicaction");
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

	public String getNoteType() {
		return noteType;
	}

	public void setNoteType(String noteType) {
		this.noteType = noteType;
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

	public List<CrmMaterialGroup> getListMaterialGroup() {
		return listMaterialGroup;
	}

	public void setListMaterialGroup(List<CrmMaterialGroup> listMaterialGroup) {
		this.listMaterialGroup = listMaterialGroup;
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

	public List<CrmConsent> getListConsentView() {
		return listConsentView;
	}

	public void setListConsentView(List<CrmConsent> listConsentView) {
		this.listConsentView = listConsentView;
	}

	public List<CrmCaseStudy> getListSuccessStoryView() {
		return listSuccessStoryView;
	}

	public void setListSuccessStoryView(List<CrmCaseStudy> listSuccessStoryView) {
		this.listSuccessStoryView = listSuccessStoryView;
	}

	public List<SelectItem> getListNoteTherapyItem() throws Exception {
		if (listNoteTherapyItem == null) {
			List<CrmTherapy> listNoteTherapy;

			if (currentDoctor == null) {
				currentNurse = processService.getCrmNurse();
				listNoteTherapy = tablesService.getListTherapyNurse();
			} else {
				listNoteTherapy = tablesService.getListTherapyMedical();
			}

			if (listNoteTherapy.size() > 0) {
				idNoteTherapy = listNoteTherapy.get(0).getId();
				autoNote = listNoteTherapy.get(0).getAuto() == 1 ? true : false;
				listNoteTherapyItem = FacesUtil.entityToSelectItem(
						listNoteTherapy, "getId", "getName");
				mapNoteTherapy = FacesUtil.entityToMapInteger(listNoteTherapy,
						"getId");
			}

			handleNoteTypeChange();
		}
		return listNoteTherapyItem;
	}

	public void setListNoteTherapyItem(List<SelectItem> listNoteTherapyItem) {
		this.listNoteTherapyItem = listNoteTherapyItem;
	}

	public Map<Integer, Object> getMapNoteTherapy() {
		return mapNoteTherapy;
	}

	public void setMapNoteTherapy(Map<Integer, Object> mapNoteTherapy) {
		this.mapNoteTherapy = mapNoteTherapy;
	}

	public Integer getIdNoteTherapy() {
		return idNoteTherapy;
	}

	public void setIdNoteTherapy(Integer idNoteTherapy) {
		this.idNoteTherapy = idNoteTherapy;
	}

	public boolean isAutoNote() {
		return autoNote;
	}

	public void setAutoNote(boolean autoNote) {
		this.autoNote = autoNote;
	}

	public CrmCaseStudy getSelectedCaseStudy() {
		return selectedCaseStudy;
	}

	public List<CrmCie> getListCaseStudyCieTemp() {
		return listCaseStudyCieTemp;
	}

	public void setListCaseStudyCieTemp(List<CrmCie> listCaseStudyCieTemp) {
		this.listCaseStudyCieTemp = listCaseStudyCieTemp;
	}

	public List<SelectItem> getListCaseStudyCie() {
		return listCaseStudyCie;
	}

	public void setListCaseStudyCie(List<SelectItem> listCaseStudyCie) {
		this.listCaseStudyCie = listCaseStudyCie;
	}

	public List<String> getListCaseStudyHistoryTemp() {
		return listCaseStudyHistoryTemp;
	}

	public void setListCaseStudyHistoryTemp(
			List<String> listCaseStudyHistoryTemp) {
		this.listCaseStudyHistoryTemp = listCaseStudyHistoryTemp;
	}

	public List<SelectItem> getListCaseStudyHistory() {
		return listCaseStudyHistory;
	}

	public void setListCaseStudyHistory(List<SelectItem> listCaseStudyHistory) {
		this.listCaseStudyHistory = listCaseStudyHistory;
	}

	public void setSelectedCaseStudy(CrmCaseStudy selectedCaseStudy) {
		this.selectedCaseStudy = selectedCaseStudy;
	}

	public BigDecimal getIdCaseStudyCie() {
		return idCaseStudyCie;
	}

	public void setIdCaseStudyCie(BigDecimal idCaseStudyCie) {
		this.idCaseStudyCie = idCaseStudyCie;
	}

	public byte[] getConsentFile() {
		return consentFile;
	}

	public void setConsentFile(byte[] consentFile) {
		this.consentFile = consentFile;
	}

	public Date getConsentDate() {
		return consentDate;
	}

	public void setConsentDate(Date consentDate) {
		this.consentDate = consentDate;
	}

	public HtmlPanelGrid getContainerComponent() {
		return containerComponent;
	}

	public void setContainerComponent(HtmlPanelGrid containerComponent) {
		this.containerComponent = containerComponent;
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

	public Date getMaxDate() {
		return new Date();
	}

	public boolean isDisabledDiagnosis() {
		return listDiagnosis != null && listDiagnosis.size() == 0 ? true
				: false;
	}

	public boolean isDisabledMedication() {
		return listMedication != null && listMedication.size() == 0 ? true
				: false;
	}

	public boolean isDisabledTherapy() {
		return listTherapy != null && listTherapy.size() == 0 ? true : false;
	}

	public boolean isDisabledExam() {
		return listExam != null && listExam.size() == 0 ? true : false;
	}

	public boolean isDisabledOtherMedication() {
		return listOtherMedication != null && listOtherMedication.size() == 0 ? true
				: false;
	}

	public boolean isDisabledNote() {
		return listNoteTherapyItem != null && listNoteTherapyItem.size() == 0 ? true
				: false;
	}

	public String getConsentType() {
		return consentType;
	}

	public void setConsentType(String consentType) {
		this.consentType = consentType;
	}

	public String getTypeHistory() {
		return typeHistory;
	}

	public void setTypeHistory(String typeHistory) {
		this.typeHistory = typeHistory;
	}

	public String getPosology() {
		return posology;
	}

	public void setPosology(String posology) {
		this.posology = posology;
	}

	public List<SelectItem> getListBranchByConsultant() {
		return listBranchByConsultant;
	}

	public void setListBranchByConsultant(
			List<SelectItem> listBranchByConsultant) {
		this.listBranchByConsultant = listBranchByConsultant;
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

	public BigDecimal getIdProcedureDetail() {
		return idProcedureDetail;
	}

	public void setIdProcedureDetail(BigDecimal idProcedureDetail) {
		this.idProcedureDetail = idProcedureDetail;
	}

	public CrmProcedureDetail getProcedureDetail() {
		return procedureDetail;
	}

	public void setProcedureDetail(CrmProcedureDetail procedureDetail) {
		this.procedureDetail = procedureDetail;
	}

	public Map<BigDecimal, CrmBranch> getMapBranchByConsultant() {
		return mapBranchByConsultant;
	}

	public void setMapBranchByConsultant(
			Map<BigDecimal, CrmBranch> mapBranchByConsultant) {
		this.mapBranchByConsultant = mapBranchByConsultant;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public String getInfoMessageDate() {
		return infoMessageDate;
	}

	public void setInfoMessageDate(String infoMessageDate) {
		this.infoMessageDate = infoMessageDate;
	}

	public List<Candidate> getListCandidate() {
		return listCandidate;
	}

	public void setListCandidate(List<Candidate> listCandidate) {
		this.listCandidate = listCandidate;
	}

	public CandidateDataModel getModelCandidate() {
		return modelCandidate;
	}

	public void setModelCandidate(CandidateDataModel modelCandidate) {
		this.modelCandidate = modelCandidate;
	}

	public Candidate getSelectedCandidate() {
		return selectedCandidate;
	}

	public void setSelectedCandidate(Candidate selectedCandidate) {
		this.selectedCandidate = selectedCandidate;
	}

	public Candidate getSelectedCandidateTemp() {
		return selectedCandidateTemp;
	}

	public void setSelectedCandidateTemp(Candidate selectedCandidateTemp) {
		this.selectedCandidateTemp = selectedCandidateTemp;
	}

	public int getAppointmentsNumber() {
		return appointmentsNumber;
	}

	public void setAppointmentsNumber(int appointmentsNumber) {
		this.appointmentsNumber = appointmentsNumber;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}

	public boolean isSaved() {
		return saved;
	}

	public void setSaved(boolean saved) {
		this.saved = saved;
	}

	public CrmAppointment getSelectedApp() {
		return selectedApp;
	}

	public void setSelectedApp(CrmAppointment selectedApp) {
		this.selectedApp = selectedApp;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public boolean isDisabledSearch() {
		return disabledSearch;
	}

	public void setDisabledSearch(boolean disabledSearch) {
		this.disabledSearch = disabledSearch;
	}

	public StreamedContent getContentHistory() {
		return contentHistory;
	}

	public void setContentHistory(StreamedContent contentHistory) {
		this.contentHistory = contentHistory;
	}

	public void calculateIMCAction(ActionEvent event) {
		double weight = this.getWeight();
		double height = this.getHeight() / 100;

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

	public void newAction(ActionEvent event) {
		if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {
			this.noteType = Constant.NOTE_TYPE_DOCTOR;
		} else {
			this.noteType = Constant.NOTE_TYPE_NURSE;
		}

		part = Constant.HISTORY_HISTORY;
		optionSearchPatient = 1;

		appointmentModel = null;
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
		listConsentView = new ArrayList<CrmConsent>();
		listSuccessStoryView = new ArrayList<CrmCaseStudy>();

		selectedDiagnosis = new CrmDiagnosis();
		selectedsDiagnosis = null;
		listNoteTherapyItem = null;

		SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
		try {
			listAllBackupMaterial = CustomListsExecute.getMaterials(
					sap.getUrlWebList(), sap.getUsername(), sap.getPassword());
		} catch (Exception ex) {
			listAllBackupMaterial = new ArrayList<WSBean>();
		}

		refreshCieFields();
		refreshMaterialFields();

		selectedCaseStudy = new CrmCaseStudy();
		listCaseStudyCie = new ArrayList<SelectItem>();
		listCaseStudyHistory = new ArrayList<SelectItem>();
		idCaseStudyCie = null;
		typeHistory = Constant.MEDICAL_HISTORY_TYPE;
	}

	public String editAppointmentAction() {
		if (!selectedAppointment.getPrcTypeHistory().equals("ODONTOLOGY")) {
			consentType = Constant.MEDICAL_HISTORY_TYPE;
			modeEdit = true;
			modeHistorial = false;
			part = Constant.HISTORY_HISTORY;
			activeIndex = -1;
			age = 0;
			imc = 0;
			descImc = null;

			newAction(null);

			currentAppointment = processService
					.getAppointment(selectedAppointment.getId());

			selectedPatient = processService.getContactById(selectedAppointment
					.getPatId());

			refreshLists();

			listDiagnosis = processService
					.getListDiagnosisByAppointment(selectedAppointment.getId());
			diagnosisModel = new DiagnosisDataModel(listDiagnosis);

			listMedication = processService.getListMedicationByAppointment(
					selectedAppointment.getId(),
					Constant.MATERIAL_TYPE_MEDICINE);
			medicationModel = new MedicationDataModel(listMedication);

			listOtherMedication = processService
					.getListMedicationByAppointment(
							selectedAppointment.getId(),
							Constant.MATERIAL_TYPE_OTHER_MEDICINE);
			otherMedicationModel = new MedicationDataModel(listOtherMedication);

			if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {
				listTherapy = processService.getListMedicationByAppointment(
						selectedAppointment.getId(),
						Constant.MATERIAL_TYPE_THERAPY);
				therapyModel = new MedicationDataModel(listTherapy);

				listExam = processService.getListMedicationByAppointment(
						selectedAppointment.getId(),
						Constant.MATERIAL_TYPE_EXAMS);
				examModel = new MedicationDataModel(listExam);
			}

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

			idMembershipType = selectedPatient.getIdMemberShip();

			if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {
				generateHistorial();

				selectedHistoryHistory = processService
						.getHistoryHistory(selectedAppointment.getId());
				selectedHistoryHistory.setCrmPatient(selectedPatient);
				selectedHistoryHistory.setCrmAppointment(currentAppointment);

				selectedHistoryRecord = processService
						.getHistoryRecord(selectedAppointment.getId());
				selectedHistoryRecord.setCrmPatient(selectedPatient);
				selectedHistoryRecord.setCrmAppointment(currentAppointment);

				selectedHistoryHomeopathic = processService
						.getHistoryHomeopathic(selectedAppointment.getId());
				selectedHistoryHomeopathic.setBiotypology("");
				selectedHistoryHomeopathic.setCrmPatient(selectedPatient);
				selectedHistoryHomeopathic
						.setCrmAppointment(currentAppointment);

				selectedHistoryPhysique = processService
						.getHistoryPhysique(selectedAppointment.getId());
				selectedHistoryPhysique.setCrmPatient(selectedPatient);
				selectedHistoryPhysique.setCrmAppointment(currentAppointment);

				try {
					this.heartRate = Integer.parseInt(selectedHistoryPhysique
							.getHeartRate());
				} catch (Exception ex) {
					this.heartRate = 0;
				}

				try {
					this.respiratoryRate = Integer
							.parseInt(selectedHistoryPhysique
									.getRespiratoryRate());
				} catch (Exception ex) {
					this.respiratoryRate = 0;
				}

				try {
					this.weight = Double.parseDouble(selectedHistoryPhysique
							.getWeight());
				} catch (Exception ex) {
					this.weight = 0d;
				}

				try {
					this.height = Double.parseDouble(selectedHistoryPhysique
							.getHeight());
				} catch (Exception ex) {
					this.height = 0d;
				}

				selectedHistoryOrganometry = processService
						.getHistoryOrganometry(selectedAppointment.getId());
				selectedHistoryOrganometry.setCrmPatient(selectedPatient);
				selectedHistoryOrganometry
						.setCrmAppointment(currentAppointment);

				if (currentAppointment.getCrmProcedureDetail().isCaseStudy()) {
					Date firstDate = FacesUtil
							.getDateWithoutTime(processService
									.getFirstAppointmentbyPatient(
											selectedPatient.getId())
									.getStartAppointmentDate());
					selectedCaseStudy.setCrmAppointment(currentAppointment);
					selectedCaseStudy.setStartDate(firstDate);

					listCaseStudyCieTemp = processService
							.getListCieByPatient(selectedPatient.getId());

					listCaseStudyHistoryTemp = processService
							.getListHistoryByPatient(selectedPatient.getId());
					refreshCaseStudyCie();
					refreshCaseStudyHistory();
				}
			} else {
				selectedHistoryConsultant = processService
						.getHistoryConsultant(selectedAppointment.getId());
				selectedHistoryConsultant.setCrmAppointment(currentAppointment);
				handleBranchChange();
			}

			return null;
		} else {
			HistoryOdontologyBacking historyOdontologyBacking = FacesUtil
					.findBean("historyOdontologyBacking");
			historyOdontologyBacking.loadValues(this.selectedAppointment);
			this.consentType = Constant.ODONTOLOGY_HISTORY_TYPE;
			this.selectedPatient = historyOdontologyBacking.selectedPatient;
			return "historyOdontology?faces-redirect=true";
		}
	}

	public void showHistorialAction() {
		generateHistorial();

		if (typeHistory.equals(Constant.MEDICAL_HISTORY_TYPE)) {
			modeEdit = true;
			modeHistorial = true;
			selectedPatient = selectedPatientTemp;
			refreshLists();
		} else {
			HistoryOdontologyBacking historyOdontologyBacking = FacesUtil
					.findBean("historyOdontologyBacking");
			historyOdontologyBacking.modeEdit = true;
			historyOdontologyBacking.modeHistorial = true;
			historyOdontologyBacking.selectedPatient = selectedPatientTemp;
			historyOdontologyBacking.refreshLists();
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("historyOdontology.jsf");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void generateHistorial() {
		try {
			GenerateFormulaPDF.getHistoryPDF(selectedPatient.getId(),
					typeHistory, getRenderedRecord());
		} catch (JRException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void viewHistoryAction() {
		RequestContext context = RequestContext.getCurrentInstance();
		if (this.part.equals(Constant.HISTORY_HISTORY)) {
			context.execute("dlgHistory.show()");
		} else if (this.part.equals(Constant.HISTORY_RECORD)) {
			context.execute("dlgRecord.show()");
		} else if (this.part.equals(Constant.HISTORY_HOMEOPATHIC)) {
			context.execute("dlgHomeopathic.show()");
		} else if (this.part.equals(Constant.HISTORY_PHYSIQUE)) {
			context.execute("dlgPhysique.show()");
		} else if (this.part.equals(Constant.HISTORY_ORGANOMETRY)) {
			context.execute("dlgOrganometry.show()");
		}
	}

	public void onTabChange(TabChangeEvent event) {
		this.part = event.getTab().getId();
	}

	public void handleBornDateSelect(SelectEvent event) {
		Date bornDate = (Date) event.getObject();
		age = calculateAge(bornDate);
	}

	public void saveAction(ActionEvent event) {
		closeAppointmentAction(null);
	}

	public void searchCIEAction(ActionEvent event) {
		if (this.descCIE.isEmpty()) {
			this.listCie = new ArrayList<CrmCie>();
			disabledAddCie = true;
		} else {
			this.listCie = processService.getListCieMedeicalByAll(descCIE);
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
		diagnosis.setCrmAppointment(currentAppointment);
		diagnosis.setCrmCie(selectedCie);
		listDiagnosis.add(diagnosis);
		diagnosisModel = new DiagnosisDataModel(listDiagnosis);
		refreshCaseStudyCie();
		refreshListCie();
	}

	public void searchDiagnosisAction(ActionEvent event) {
		optionSearchCie = 1;
	}

	protected void refreshListCie() {
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
		refreshCaseStudyCie();
	}

	// Medication
	public void searchMaterialAction(ActionEvent event) {
		if (this.descMaterial.isEmpty()) {
			this.listMaterial = new ArrayList<WSBean>();
			disabledAddMaterial = true;
		} else {
			this.listMaterial = new ArrayList<WSBean>();
			for (WSBean material : listAllMaterial) {
				if ((material.getCode().toUpperCase().contains(descMaterial
						.toUpperCase()))
						|| (material.getNames().toUpperCase()
								.contains(descMaterial.toUpperCase()))) {
					this.listMaterial.add(material);
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
		medication.setCrmAppointment(currentAppointment);
		medication.setCrmCie(selectedDiagnosis.getCrmCie());
		medication.setCodMaterial(Integer.parseInt(selectedMaterial.getCode()));
		medication.setDescMaterial(selectedMaterial.getNames());
		medication.setSapMaterialType(selectedMaterial.getType());
		medication.setMaterialType(typeMedication);
		medication.setUnit(amount);

		if (typeMedication.equals(Constant.MATERIAL_TYPE_MEDICINE)) {
			listMedication.add(medication);
			medicationModel = new MedicationDataModel(listMedication);
		} else if (typeMedication.equals(Constant.MATERIAL_TYPE_OTHER_MEDICINE)) {
			listOtherMedication.add(medication);
			otherMedicationModel = new MedicationDataModel(listOtherMedication);
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

	protected void refreshListMedication() {
		List<WSBean> listFilter = new ArrayList<WSBean>();
		for (WSBean row : listMaterial) {
			boolean filter = true;
			if (typeMedication.equals(Constant.MATERIAL_TYPE_MEDICINE)
					|| typeMedication
							.equals(Constant.MATERIAL_TYPE_OTHER_MEDICINE)) {
				for (CrmMedication med : listMedication) {
					if (Long.parseLong(row.getCode()) == med.getCodMaterial()) {
						filter = false;
						break;
					}
				}
				for (CrmMedication med : listOtherMedication) {
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

	public void removeOtherMedicationAction(ActionEvent event) {
		for (CrmMedication row : selectedOtherMedication) {
			listOtherMedication.remove(row);
		}
		otherMedicationModel = new MedicationDataModel(listOtherMedication);
		selectedOtherMedication = null;
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
		if (listMaterial.size() == 0) {
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
					listMaterial.add(material);
					listAllMaterial.add(material);
				}
			}
		}

		refreshListMedication();
		refreshMaterialFields();
	}

	public void selectOtherMedicationAction(ActionEvent event) {
		this.typeMedication = Constant.MATERIAL_TYPE_OTHER_MEDICINE;
		listAllMaterial = new ArrayList<WSBean>();

		for (WSBean material : listAllBackupMaterial) {
			boolean validateGroup = false;
			for (CrmMaterialGroup row : listMaterialGroup) {
				if (row.getMaterialType().equals(
						Constant.MATERIAL_TYPE_MEDICINE)
						&& material.getType().equals(row.getGroup())) {
					validateGroup = true;
					break;
				}
			}

			if (validateGroup) {
				listAllMaterial.add(material);
			}
		}

		refreshListMedication();
		refreshMaterialFields();
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

	protected void refreshLists() {
		this.consentType = Constant.MEDICAL_HISTORY_TYPE;

		List<VwAppointment> listTempApp = processService
				.getListByAppointmentByPatient(selectedPatient.getId(),
						consentType);
		historyAppointmentModel = new VwAppointmentDataModel(listTempApp);

		List<CrmHistoryHistory> listTempHistory = processService
				.getListHistoryHistory(selectedPatient.getId(), consentType);
		historyHistoryModel = new HistoryHistoryDataModel(listTempHistory);

		List<CrmHistoryRecord> listTempRecord = processService
				.getListHistoryRecord(selectedPatient.getId(), consentType);
		historyRecordModel = new HistoryRecordDataModel(listTempRecord);

		List<CrmHistoryHomeopathic> listTempHomeopathic = processService
				.getListHistoryHomeopathic(selectedPatient.getId());
		historyHomeopathicModel = new HistoryHomeopathicDataModel(
				listTempHomeopathic);

		List<CrmHistoryPhysique> listTempPhysique = processService
				.getListHistoryPhysique(selectedPatient.getId(), consentType);
		historyPhysiqueModel = new HistoryPhysiqueDataModel(listTempPhysique);

		List<CrmHistoryOrganometry> listTempOrganometry = processService
				.getListHistoryOrganometry(selectedPatient.getId());
		historyOrganometryModel = new HistoryOrganometryDataModel(
				listTempOrganometry);

		List<CrmHistoryConsultant> listTempConsultant = processService
				.getListHistoryConsultant(selectedPatient.getId());
		historyConsultantModel = new DataModelCustom<CrmHistoryConsultant>(
				listTempConsultant);

		listDiagnosisView = processService.getListDiagnosisByPatient(
				selectedPatient.getId(), consentType);

		listMedicationView = new ArrayList<CrmMedication>();
		listTherapyView = new ArrayList<CrmMedication>();
		listExamView = new ArrayList<CrmMedication>();

		List<CrmMedication> listAllMedication = processService
				.getListMedicationByPatient(selectedPatient.getId(),
						consentType);

		for (CrmMedication row : listAllMedication) {
			if (row.getMaterialType().equals(Constant.MATERIAL_TYPE_MEDICINE)
					|| row.getMaterialType().equals(
							Constant.MATERIAL_TYPE_OTHER_MEDICINE)) {
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
		listConsentView = processService.getListConsentByPatient(
				selectedPatient.getId(), consentType);
		listSuccessStoryView = processService
				.getListSuccessStoryByPatient(selectedPatient.getId());
	}

	public void closeAppointmentAction(ActionEvent event) {
		if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {
			closeAppointmentDoctorAction(event);
		} else {
			closeAppointmentConsultanAction(event);
		}
	}

	public void closeAppointmentConsultanAction(ActionEvent event) {
		String message = null;

		String field = null;

		if (selectedPatient == null || selectedPatient.getId() == null) {
			message = FacesUtil.getMessage("his_msg_error_1");
			FacesUtil.addWarn(message);
		}

		if (selectedPatient.getBornDate() == null) {
			field = FacesUtil.getMessage("pat_born_date");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		}

		if (idOccupation == null || idOccupation.intValue() == 0) {
			field = FacesUtil.getMessage("pat_occupation");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setCrmOccupation(mapOccupation.get(idOccupation));
		}

		if (FacesUtil.isEmptyOrBlank(neighborhood)) {
			field = FacesUtil.getMessage("pat_neighborhood");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setNeighborhood(neighborhood);
		}

		if (FacesUtil.isEmptyOrBlank(typeHousing)) {
			field = FacesUtil.getMessage("pat_type_housing");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setTypeHousing(typeHousing);
		}

		if (FacesUtil.isEmptyOrBlank(selectedHistoryConsultant.getObs())) {
			field = FacesUtil.getMessage("his_consultant");
			message = FacesUtil.getMessage("his_consultant");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		}

		int numDiagnosis = listDiagnosis.size();
		if (numDiagnosis == 0) {
			message = FacesUtil.getMessage("his_msg_message_dig_1");
			FacesUtil.addWarn(message);
		} else {
			int minDiagnosis = currentAppointment.getCrmProcedureDetail()
					.getMinDiagnosis();
			int maxDiagnosis = currentAppointment.getCrmProcedureDetail()
					.getMaxDiagnosis();
			if (numDiagnosis < minDiagnosis || numDiagnosis > maxDiagnosis) {
				message = FacesUtil.getMessage("his_msg_message_med_6",
						String.valueOf(minDiagnosis),
						String.valueOf(maxDiagnosis));
				FacesUtil.addWarn(message);
			}

			if (listMedication.size() == 0) {
				message = FacesUtil.getMessage("his_msg_message_med_5");
				FacesUtil.addWarn(message);
			} else {
				int idCie = listDiagnosis.get(0).getCrmCie().getId().intValue();
				int numMedication = 0;
				for (CrmMedication row : listMedication) {
					if (row.getCrmCie().getId().intValue() == idCie) {
						numMedication++;
					}
				}

				int minMedication = currentAppointment.getCrmProcedureDetail()
						.getMinMedication();
				int maxMedication = currentAppointment.getCrmProcedureDetail()
						.getMaxMedication();
				if (minMedication > 0 && numMedication < minMedication) {
					message = FacesUtil.getMessage("his_msg_message_med_1",
							String.valueOf(minMedication));
					FacesUtil.addWarn(message);
				} else if (maxMedication > 0 && numMedication > maxMedication) {
					message = FacesUtil.getMessage("his_msg_message_med_3",
							String.valueOf(maxMedication));
					FacesUtil.addWarn(message);
				}
			}
		}

		processService.save(selectedHistoryConsultant);

		if (message == null) {
			processService.saveDiagnosis(currentAppointment, listDiagnosis);
			processService.saveMedication(currentAppointment, listMedication,
					Constant.MATERIAL_TYPE_MEDICINE);
			processService.saveMedication(currentAppointment,
					listOtherMedication, Constant.MATERIAL_TYPE_OTHER_MEDICINE);

			viewMode = true;

			if (event != null) {
				currentAppointment.setCloseAppointment(true);
				currentAppointment.setCrmUserByIdUserClosed(FacesUtil
						.getCurrentUser());
				currentAppointment.setDateClosed(new Date());
			}

			currentAppointment.setState(Constant.APP_STATE_ATTENDED);
			processService.saveAppointment(currentAppointment);
			message = FacesUtil.getMessage("his_msg_message_med_ok");
			FacesUtil.addInfo(message);
			refreshLists();

			if (event != null) {
				refreshAction();
			}
		}
	}

	public void closeAppointmentDoctorAction(ActionEvent event) {
		String message = null;
		boolean medicationTherapy = false;

		String field = null;

		if (selectedPatient == null || selectedPatient.getId() == null) {
			message = FacesUtil.getMessage("his_msg_error_1");
			FacesUtil.addWarn(message);
		}

		if (selectedPatient.getBornDate() == null) {
			field = FacesUtil.getMessage("pat_born_date");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		}

		if (idOccupation == null || idOccupation.intValue() == 0) {
			field = FacesUtil.getMessage("pat_occupation");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setCrmOccupation(mapOccupation.get(idOccupation));
		}

		if (FacesUtil.isEmptyOrBlank(neighborhood)) {
			field = FacesUtil.getMessage("pat_neighborhood");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setNeighborhood(neighborhood);
		}

		if (FacesUtil.isEmptyOrBlank(typeHousing)) {
			field = FacesUtil.getMessage("pat_type_housing");
			message = FacesUtil.getMessage("title_patient_complementary");
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedPatient.setTypeHousing(typeHousing);
		}

		if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {

			if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getReason())) {
				field = FacesUtil.getMessage("his_history_reason");
				message = FacesUtil.getMessage("his_history_history");
				message = message + " - "
						+ FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
			}

			if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getDisease())) {
				field = FacesUtil.getMessage("his_history_disease");
				message = FacesUtil.getMessage("his_history_history");
				message = message + " - "
						+ FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
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
				FacesUtil.addWarn(message);
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
				FacesUtil.addWarn(message);
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
				FacesUtil.addWarn(message);
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
				FacesUtil.addWarn(message);
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
				FacesUtil.addWarn(message);
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
				FacesUtil.addWarn(message);
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
				FacesUtil.addWarn(message);
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
				FacesUtil.addWarn(message);
			}
		}

		if (this.getHeartRate() == 0) {
			field = FacesUtil.getMessage("his_physique_heart_rate");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedHistoryPhysique
					.setHeartRate(String.valueOf(this.heartRate));
		}

		if (this.getRespiratoryRate() == 0) {
			field = FacesUtil.getMessage("his_physique_respiratory_rate");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedHistoryPhysique.setRespiratoryRate(String
					.valueOf(this.respiratoryRate));
		}

		if (this.getHeight().intValue() == 0) {
			field = FacesUtil.getMessage("his_physique_height");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedHistoryPhysique.setHeight(String.valueOf(this.height));
		}

		if (this.getWeight().intValue() == 0) {
			field = FacesUtil.getMessage("his_physique_weight");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		} else {
			selectedHistoryPhysique.setWeight(String.valueOf(this.weight));
		}

		if (FacesUtil
				.isEmptyOrBlank(selectedHistoryPhysique.getBloodPressure())) {
			field = FacesUtil.getMessage("his_physique_blood_pressure");
			message = FacesUtil.getMessage("his_history_physique", field);
			message = message + " - "
					+ FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		}

		if (selectedHistoryOrganometry.getOrganometryCheck()) {
			if (FacesUtil.isEmptyOrBlank(selectedHistoryOrganometry
					.getOrganometryAnalysis())) {
				field = FacesUtil.getMessage("his_organometry_analysis");
				message = FacesUtil
						.getMessage("his_history_organometry", field);
				message = message + " - "
						+ FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
			}
		}

		if (currentAppointment.getCrmProcedureDetail().isCaseStudy()) {
			if (idCaseStudyCie == null || idCaseStudyCie.intValue() == 0) {
				field = FacesUtil.getMessage("cst_patology");
				message = FacesUtil.getMessage("title_case_study", field);
				message = message + " - "
						+ FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
			}

			if (FacesUtil.isEmptyOrBlank(selectedCaseStudy.getReason())) {
				field = FacesUtil.getMessage("cst_reason");
				message = FacesUtil.getMessage("title_case_study", field);
				message = message + " - "
						+ FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
			}

			if (selectedCaseStudy.getPercent() == 0) {
				field = FacesUtil.getMessage("cst_perc");
				message = FacesUtil.getMessage("title_case_study", field);
				message = message + " - "
						+ FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
			}
		}

		if (message == null) {

			selectedHistoryHistory.setCrmPatient(selectedPatient);
			selectedHistoryRecord.setCrmPatient(selectedPatient);
			selectedHistoryHomeopathic.setCrmPatient(selectedPatient);
			selectedHistoryPhysique.setCrmPatient(selectedPatient);
			selectedHistoryOrganometry.setCrmPatient(selectedPatient);

			if (!FacesUtil.isEmptyOrBlank(selectedPatient.getNeighborhood())) {
				selectedPatient.setNeighborhood(selectedPatient
						.getNeighborhood().toUpperCase());
			}

			int result = processService.savePatient(selectedPatient, false,
					false, null);

			if (result == 0) {

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getPharmacological())) {
					selectedHistoryRecord
							.setPharmacological(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getImmunizations())) {
					selectedHistoryRecord
							.setImmunizations(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getTransfusion())) {
					selectedHistoryRecord
							.setTransfusion(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord.getOther())) {
					selectedHistoryRecord.setOther(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryRecord
						.getPlanning())) {
					selectedHistoryRecord
							.setPlanning(Constant.HISTORY_NOT_REFER);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryHistory
						.getResults())) {
					selectedHistoryHistory
							.setResults(Constant.HISTORY_NOT_REFER);
				}

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
							.setGeneralState(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getHeadNeck())) {
					selectedHistoryPhysique
							.setHeadNeck(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getChest())) {
					selectedHistoryPhysique.setChest(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getLungs())) {
					selectedHistoryPhysique.setLungs(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getHeart())) {
					selectedHistoryPhysique.setHeart(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getAbdomen())) {
					selectedHistoryPhysique.setAbdomen(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getGenitals())) {
					selectedHistoryPhysique
							.setGenitals(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil
						.isEmptyOrBlank(selectedHistoryPhysique.getOsteo())) {
					selectedHistoryPhysique.setOsteo(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getTips())) {
					selectedHistoryPhysique.setTips(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique
						.getHighlights())) {
					selectedHistoryPhysique
							.setHighlights(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getSkin())) {
					selectedHistoryPhysique.setSkin(Constant.HISTORY_NORMAL);
				}

				if (FacesUtil.isEmptyOrBlank(selectedHistoryPhysique.getObs())) {
					selectedHistoryPhysique.setObs(Constant.HISTORY_NORMAL);
				}

				if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {
					result = processService
							.saveHistoryHistory(selectedHistoryHistory);
					result = processService
							.saveHistoryRecord(selectedHistoryRecord);
					result = processService
							.saveHistoryHomeopathic(selectedHistoryHomeopathic);
				}

				result = processService
						.saveHistoryPhysique(selectedHistoryPhysique);
				result = processService
						.saveHistoryOrganometry(selectedHistoryOrganometry);

				if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {

					int numDiagnosis = listDiagnosis.size();
					if (numDiagnosis == 0) {
						message = FacesUtil.getMessage("his_msg_message_dig_1");
						FacesUtil.addWarn(message);
					} else {
						int minDiagnosis = currentAppointment
								.getCrmProcedureDetail().getMinDiagnosis();
						int maxDiagnosis = currentAppointment
								.getCrmProcedureDetail().getMaxDiagnosis();
						if (numDiagnosis < minDiagnosis
								|| numDiagnosis > maxDiagnosis) {
							message = FacesUtil.getMessage(
									"his_msg_message_med_6",
									String.valueOf(minDiagnosis),
									String.valueOf(maxDiagnosis));
							FacesUtil.addWarn(message);
						}

						/*
						 * for (CrmDiagnosis row : listDiagnosis) { if
						 * (FacesUtil.isEmptyOrBlank(row.getPosology())) {
						 * message = FacesUtil
						 * .getMessage("his_msg_message_dig_2");
						 * FacesUtil.addWarn(message); break; } }
						 */

						if (listMedication.size() == 0) {
							message = FacesUtil
									.getMessage("his_msg_message_med_5");
							FacesUtil.addWarn(message);
						} else {
							int idCie = listDiagnosis.get(0).getCrmCie()
									.getId().intValue();
							int numMedication = 0;
							for (CrmMedication row : listMedication) {
								if (row.getCrmCie().getId().intValue() == idCie) {
									numMedication++;
								}
							}

							int minMedication = currentAppointment
									.getCrmProcedureDetail().getMinMedication();
							int maxMedication = currentAppointment
									.getCrmProcedureDetail().getMaxMedication();
							if (minMedication > 0
									&& numMedication < minMedication) {
								message = FacesUtil.getMessage(
										"his_msg_message_med_1",
										String.valueOf(minMedication));
								FacesUtil.addWarn(message);
							} else if (maxMedication > 0
									&& numMedication > maxMedication) {
								message = FacesUtil.getMessage(
										"his_msg_message_med_3",
										String.valueOf(maxMedication));
								FacesUtil.addWarn(message);
							}

							/*
							 * boolean validate = true; for (CrmMedication row :
							 * listMedication) { if
							 * (FacesUtil.isEmptyOrBlank(row.getPosology())) {
							 * validate = false; break; } }
							 * 
							 * for (CrmDiagnosis row : listDiagnosis) { if
							 * (FacesUtil.isEmptyOrBlank(row.getPosology())) {
							 * validate = false; break; } }
							 * 
							 * if (!validate) { message = FacesUtil
							 * .getMessage("his_msg_message_dig_2");
							 * FacesUtil.addWarn(message); }
							 */
						}
					}

					if (listOtherMedication.size() > 0) {
						for (CrmMedication row : listOtherMedication) {
							if (FacesUtil.isEmptyOrBlank(row.getDiagnosis())
									|| FacesUtil.isEmptyOrBlank(row
											.getPosology())) {
								message = FacesUtil
										.getMessage("his_msg_message_med_4");
								FacesUtil.addWarn(message);
								break;
							}
						}
					}

					if (listTherapy.size() > 0) {
						for (CrmMedication row : listTherapy) {
							if (FacesUtil.isEmptyOrBlank(row.getDiagnosis())) {
								message = FacesUtil
										.getMessage("his_msg_message_med_2");
								FacesUtil.addWarn(message);
								break;
							}
						}
						medicationTherapy = true;
					}

					if (message == null) {
						processService.saveDiagnosis(currentAppointment,
								listDiagnosis);
						processService
								.saveMedication(currentAppointment,
										listMedication,
										Constant.MATERIAL_TYPE_MEDICINE);
						processService.saveMedication(currentAppointment,
								listOtherMedication,
								Constant.MATERIAL_TYPE_OTHER_MEDICINE);
						processService.saveMedication(currentAppointment,
								listTherapy, Constant.MATERIAL_TYPE_THERAPY);
						processService.saveMedication(currentAppointment,
								listExam, Constant.MATERIAL_TYPE_EXAMS);
						processService.saveStudyCase(selectedCaseStudy,
								idCaseStudyCie);

						viewMode = true;
						currentAppointment
								.setMedicationTherapy(medicationTherapy);

						if (event != null) {
							currentAppointment.setCloseAppointment(true);
							currentAppointment
									.setCrmUserByIdUserClosed(FacesUtil
											.getCurrentUser());
							currentAppointment.setDateClosed(new Date());
						}

						currentAppointment
								.setState(Constant.APP_STATE_ATTENDED);
						processService.saveAppointment(currentAppointment);
						message = FacesUtil
								.getMessage("his_msg_message_med_ok");
						FacesUtil.addInfo(message);
						refreshLists();

						if (event != null) {
							refreshAction();
						}
					} else if (this.getRolePrincipal().equals(
							Constant.ROLE_NURSE)) {
					}
				}

			}
		}
	}

	public void refreshAction() {
		if (currentDoctor != null) {
			listAppointment = processService
					.getListVwAppointmentByHistory(currentDoctor.getId());
			appointmentModel = new VwAppointmentDataModel(listAppointment);
			if (listAppointment.size() > 0) {
				selectedAppointment = listAppointment.get(0);
			}
		}
	}

	public void printFormulaAction() {
		try {
			GenerateFormulaPDF.PDF(currentAppointment.getId(),
					Constant.MATERIAL_TYPE_MEDICINE);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printFormulaHistorialAction() {
		try {
			GenerateFormulaPDF.PDF(selectedAppointmentPrint.getId(),
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
			GenerateFormulaPDF.PDF(currentAppointment.getId(),
					Constant.MATERIAL_TYPE_THERAPY);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printFormulaLabAction() {
		try {
			GenerateFormulaPDF.PDF(currentAppointment.getId(),
					Constant.MATERIAL_TYPE_EXAMS);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printRemissiomAction() {
		try {
			GenerateFormulaPDF.remissionPDF(currentNote.getId());
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void handleNoteTypeChange() {
		if (this.noteType.equals(Constant.NOTE_TYPE_THERAPY)
				|| this.noteType.equals(Constant.NOTE_TYPE_NURSE)) {
			if (listNoteTherapyItem != null && listNoteTherapyItem.size() > 0) {
				this.noteDoctor = ((CrmTherapy) mapNoteTherapy
						.get(idNoteTherapy)).getDescription();
				handleTherapyChange();
			}
		} else {
			this.autoNote = false;
			this.noteDoctor = null;
		}
	}

	public void handleTherapyChange() {
		if (listNoteTherapyItem != null && listNoteTherapyItem.size() > 0) {
			CrmTherapy currentTheraphy = (CrmTherapy) mapNoteTherapy
					.get(idNoteTherapy);
			this.noteDoctor = currentTheraphy.getDescription();
			autoNote = currentTheraphy.getAuto() == 1 ? true : false;
			if (autoNote) {
				addComponent(this.noteDoctor);
			}
		}
	}

	public void addComponent(String text) {
		// clean previous component
		containerComponent.getChildren().clear();
		boolean exit = true;
		int id = 1;
		int index = 0;
		int count = 0;

		// dynamically add Child Components to Container Component
		while (exit) {
			int pos = text.indexOf(":" + id, index);
			if (pos == -1) {
				exit = false;
			} else {
				UIColumn col = new UIColumn();
				col.setId("col_" + id);
				HtmlOutputText ot = new HtmlOutputText();
				ot.setId("output_" + id);
				String subText = text.substring(index, pos);
				ot.setValue(subText);
				col.getChildren().add(ot);
				HtmlInputText it = new HtmlInputText();
				it.setId("text_" + id);
				it.setValue("");
				col.getChildren().add(it);

				containerComponent.getChildren().add(col);
				id++;
				count = String.valueOf(id).length() + 1;
				index = pos + count;
			}
		}
	}

	public void saveNoteAction(ActionEvent event) {
		RequestContext context = RequestContext.getCurrentInstance();
		String message = null;
		boolean saved = false;

		if (this.autoNote) {
			if (this.validateComponent()) {
				message = FacesUtil.getMessage("glb_required_all");
				FacesUtil.addWarn(message);
			}
		} else {
			if (FacesUtil.isEmptyOrBlank(noteDoctor)) {
				String field = FacesUtil.getMessage("his_history_note");
				message = FacesUtil.getMessage("glb_required", field);
				FacesUtil.addWarn(message);
			}
		}

		if (message == null) {
			CrmNote crmNote = new CrmNote();
			crmNote.setCrmPatient(this.selectedPatient);
			crmNote.setCrmDoctor(this.currentDoctor);
			crmNote.setCrmNurse(this.currentNurse);
			crmNote.setNote(this.noteDoctor);
			crmNote.setNoteType(this.noteType);
			crmNote.setNoteDate(new Date());

			if (this.noteType.equals(Constant.NOTE_TYPE_NURSE)
					|| this.noteType.equals(Constant.NOTE_TYPE_THERAPY)) {
				crmNote.setOtherNoteType(((CrmTherapy) mapNoteTherapy
						.get(idNoteTherapy)).getName());
			}

			processService.saveNotes(crmNote);
			listNoteView.add(crmNote);
			message = FacesUtil.getMessage("msg_record_ok");
			this.noteDoctor = null;
			FacesUtil.addInfo(message);
			saved = true;
		}

		context.addCallbackParam("saved", saved);
	}

	public boolean validateComponent() {
		String tmpText = this.noteDoctor;
		int id = 1;
		boolean required = false;

		outerloop: for (UIComponent component : containerComponent
				.getChildren()) {
			List<UIComponent> list = (List<UIComponent>) component
					.getChildren();
			for (UIComponent component2 : list) {
				try {
					HtmlInputText it = (HtmlInputText) component2;
					String value = it.getValue().toString();
					if (!FacesUtil.isEmptyOrBlank(value)) {
						tmpText = tmpText.replaceFirst(":" + id, value);
						id++;
					} else {
						required = true;
						break outerloop;
					}
				} catch (ClassCastException ex) {

				}
			}
		}

		if (!required) {
			this.noteDoctor = tmpText;
		}

		return required;
	}

	public void cleanNoteAction(ActionEvent event) {
		if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {
			this.noteType = Constant.NOTE_TYPE_DOCTOR;
		} else {
			this.noteType = Constant.NOTE_TYPE_NURSE;
		}

		if (this.noteType.equals(Constant.NOTE_TYPE_NURSE)
				|| this.noteType.equals(Constant.NOTE_TYPE_THERAPY)) {
			if (listNoteTherapyItem != null && listNoteTherapyItem.size() > 0) {
				idNoteTherapy = Integer.parseInt(listNoteTherapyItem.get(0)
						.getValue().toString());
				handleTherapyChange();
			}
		} else {
			this.autoNote = false;
		}
	}

	public void newConsentAction(ActionEvent event) {
		this.consentFile = null;
		this.consentDate = null;
	}

	public void handleFileUpload(FileUploadEvent event) {
		this.consentFile = event.getFile().getContents();
	}

	public void saveConsentAction() {
		RequestContext context = RequestContext.getCurrentInstance();
		String message = null;
		boolean saved = false;
		CrmConsent crmConsent = new CrmConsent();

		if (consentFile != null) {
			crmConsent.setCrmPatient(this.selectedPatient);
			crmConsent.setConsentFile(consentFile);
			crmConsent.setDateInformed(consentDate);
			crmConsent.setConsentType(consentType);
			processService.persist(crmConsent);
			listConsentView.add(crmConsent);
			saved = true;
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else {
			saved = false;
			String field = FacesUtil.getMessage("con_consent");
			message = FacesUtil.getMessage("glb_required", field);
			FacesUtil.addWarn(message);
		}

		context.addCallbackParam("saved", saved);
	}

	public StreamedContent getFile(byte[] consentFile) {
		StreamedContent file = new DefaultStreamedContent(
				new ByteArrayInputStream(consentFile), "application/pdf",
				"consentimiento.pdf");
		return file;
	}

	public void refreshCaseStudyCie() {
		listCaseStudyCie = new ArrayList<SelectItem>();
		Map<BigDecimal, String> mapCie = new HashMap<BigDecimal, String>();
		for (CrmDiagnosis row : listDiagnosis) {
			mapCie.put(row.getCrmCie().getId(), row.getCrmCie()
					.getDescription());
		}

		if (listCaseStudyCieTemp != null) {
			for (CrmCie row : listCaseStudyCieTemp) {
				mapCie.put(row.getId(), row.getDescription());
			}
		}

		for (Map.Entry<BigDecimal, String> entry : mapCie.entrySet()) {
			listCaseStudyCie.add(new SelectItem(entry.getKey(), entry
					.getValue()));
		}
	}

	public void refreshCaseStudyHistory() {
		listCaseStudyHistory = new ArrayList<SelectItem>();
		if (listCaseStudyHistoryTemp != null) {
			for (String row : listCaseStudyHistoryTemp) {
				listCaseStudyHistory.add(new SelectItem(row, row));
			}
		}
	}

	public void handleTabChange() {
		if (this.getRolePrincipal().equals(Constant.ROLE_DOCTOR)) {
			refreshCaseStudyHistory();
			if (!FacesUtil.isEmptyOrBlank(selectedHistoryHistory.getReason())) {
				boolean exists = false;
				for (SelectItem row : listCaseStudyHistory) {
					if (row.getValue()
							.toString()
							.toUpperCase()
							.equals(selectedHistoryHistory.getReason()
									.toUpperCase())) {
						exists = true;
						break;
					}
				}
				if (!exists) {
					listCaseStudyHistory.add(new SelectItem(
							selectedHistoryHistory.getReason(),
							selectedHistoryHistory.getReason()));
				}
			}
		}
	}

	public void selectPosologyAction() {
		this.posology = null;
		if (this.selectedDiagnosis != null) {
			this.posology = selectedDiagnosis.getPosology();
		}
	}

	public void savePosologyAction() {
		selectedDiagnosis.setPosology(this.posology);
	}

	public void handleBranchChange() {
		listProcedureDetail = new LinkedList<SelectItem>();
		mapProcedureDetail = new LinkedHashMap<BigDecimal, CrmProcedureDetail>();
		List<CrmProcedureDetail> listProcedureDetailTemp = tablesService
				.getListProcedureByBranchConsultant(idBranch);
		if (listProcedureDetailTemp != null) {
			for (CrmProcedureDetail row : listProcedureDetailTemp) {
				mapProcedureDetail.put(row.getId(), row);
				listProcedureDetail.add(new SelectItem(row.getId(), row
						.getName()));
			}
		}

		if (listProcedureDetail.size() > 0) {
			idProcedureDetail = (BigDecimal) listProcedureDetail.get(0)
					.getValue();
			handleProcedureDetailChange();
		} else {
			disabledSearch = true;
		}

		currentDate = new Date();
	}

	public void handleProcedureDetailChange() {
		if (listProcedureDetail.size() > 0) {
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			try {
				String codeBranch = mapBranchByConsultant.get(idBranch)
						.getCode();

				List<WSBean> result = FacesUtil.getCurrentUserData()
						.getListWSGroupSellers();

				listWSGroupSellers = new ArrayList<SelectItem>();
				mapWSGroupSellers = new TreeMap<String, String>();
				listWSGroupSellers.add(new SelectItem(
						Constant.DEFAULT_VALUE_STRING, label));
				for (WSBean row : result) {
					if (row.getBranch().equals(codeBranch)) {
						mapWSGroupSellers.put(row.getCode(), row.getNames());
						listWSGroupSellers.add(new SelectItem(row.getCode(),
								row.getNames()));
					}
				}
			} catch (Exception ex) {
				listWSGroupSellers = new ArrayList<SelectItem>();
				listWSGroupSellers.add(new SelectItem(
						Constant.DEFAULT_VALUE_STRING, label));
			}

			selectedWSGroupSellers = "-1";

			procedureDetail = mapProcedureDetail.get(idProcedureDetail);

			String codPublicity = procedureDetail.getCodPublicity();
			if (!FacesUtil.isEmptyOrBlank(codPublicity)
					&& !codPublicity.equals(Constant.DEFAULT_VALUE_STRING)) {

				String namePublicity = null;
				List<WSBean> result = FacesUtil.getCurrentUserData()
						.getListWSGroupSellers();
				for (WSBean row : result) {
					if (row.getCode().equals(codPublicity)) {
						namePublicity = row.getNames();
						break;
					}
				}

				listWSGroupSellers = new ArrayList<SelectItem>();
				mapWSGroupSellers = new TreeMap<String, String>();
				mapWSGroupSellers.put(codPublicity, namePublicity);
				listWSGroupSellers.add(new SelectItem(codPublicity,
						namePublicity));
			}

			if ((procedureDetail.getTimeDoctor() > procedureDetail
					.getTimeNurses())
					&& (procedureDetail.getTimeDoctor() > procedureDetail
							.getTimeStretchers())) {
				minutes = procedureDetail.getTimeDoctor();
				timeType = Constant.TIME_TYPE_DOCTOR;
			} else if ((procedureDetail.getTimeNurses() > procedureDetail
					.getTimeDoctor())
					&& (procedureDetail.getTimeNurses() > procedureDetail
							.getTimeStretchers())) {
				minutes = procedureDetail.getTimeNurses();
				timeType = Constant.TIME_TYPE_NURSE;
			} else {
				minutes = procedureDetail.getTimeStretchers();
				timeType = Constant.TIME_TYPE_STRETCHERS;
			}

			handleDateSelect(null);
			selectedCandidate = null;
		}
	}

	public void handleDateSelect(SelectEvent event) {
		if (event != null) {
			currentDate = (Date) event.getObject();
		} else {
			currentDate = FacesUtil.getDateWithoutTime(today);
		}

		List<CrmHoliday> listHoliday = processService.getListHoliday(
				currentDate, idBranch);
		if (listHoliday.size() > 0) {
			infoMessageDate = FacesUtil.getMessage("app_msg_error_1");
		} else {
			infoMessageDate = null;
		}
	}

	public String getDetSelectedCandidate() {
		String result = "";
		if (selectedCandidate != null) {
			String message = FacesUtil.getMessage("app_msg_selected");
			result = message + " " + selectedCandidate.getDateDetail();
		}
		return result;
	}

	public void addAppointmentAction() {
		this.selectedCandidate = this.selectedCandidateTemp;
	}

	public void newAppAction(ActionEvent event) {
		selectedApp = new CrmAppointment();
		selectedApp.setCrmBranch(new CrmBranch());
		selectedApp.setCrmDoctor(new CrmDoctor());
		selectedApp.setCrmProcedureDetail(new CrmProcedureDetail());

		currentDate = new Date();
		selectedWSGroupSellers = "-1";

		listCandidate = new LinkedList<Candidate>();
		modelCandidate = new CandidateDataModel(listCandidate);
		selectedCandidate = null;
		selectedCandidateTemp = null;

		infoMessage = null;
		saved = false;
		disabledSearch = false;

		today = new Date();
		todayMax = FacesUtil.addHoursToDate(
				FacesUtil.getDateWithoutTime(today), 18);
	}

	public void searchAppointMentAction() {
		boolean validateNoRepeat = true;
		infoMessage = null;

		if (procedureDetail.isNoRepeat()
				&& procedureDetail.getNoRepeatDays() > 0 && infoMessage == null) {
			Date maxDate = processService.getMaxDateByProcedure(
					selectedPatient.getId(), procedureDetail.getId());
			if (maxDate != null) {
				maxDate = FacesUtil.getDateWithoutTime(maxDate);
				Date currentDate = new Date(this.currentDate.getTime());
				currentDate = FacesUtil.getDateWithoutTime(currentDate);
				long diff = currentDate.getTime() - maxDate.getTime();
				diff = diff / (1000 * 60 * 60 * 24);
				if (diff < procedureDetail.getNoRepeatDays()) {
					validateNoRepeat = false;
				}
			}
		}

		if (validateNoRepeat && infoMessage == null) {
			ResultSearchAppointment resultSearchAppointment = processService
					.getScheduleAppointmentForDoctor(
							mapBranchByConsultant.get(idBranch), currentDoctor,
							this.appointmentsNumber, procedureDetail,
							this.currentDate);
			listCandidate = resultSearchAppointment.getListCandidate();
			infoMessage = resultSearchAppointment.getMessage();

			modelCandidate = new CandidateDataModel(listCandidate);

			if (listAppointment.size() > 0) {
				selectedCandidateTemp = listCandidate.get(0);
			} else {
				selectedCandidate = null;
				selectedCandidateTemp = null;
			}
		} else {
			listCandidate = new ArrayList<Candidate>();
			modelCandidate = new CandidateDataModel(listCandidate);
			selectedCandidate = null;
			selectedCandidateTemp = null;
			if (!validateNoRepeat) {
				String message = procedureDetail.getNoRepeatDays().toString();
				infoMessage = FacesUtil.getMessage("app_msg_error_procedure",
						message);
			}
		}
	}

	public void validateAction() {
		String appType = FacesUtil.getParam("APP_TYPE");
		infoMessage = "";
		validate = true;

		// validar Selección Pauta
		if (this.selectedWSGroupSellers.equals(Constant.DEFAULT_VALUE_STRING)) {
			String field = FacesUtil.getMessage("app_seller_group");
			infoMessage = FacesUtil.getMessage("glb_required", field);
			validate = false;
		}

		// validar Selección Cita
		if ((selectedCandidate == null) && (appType.equals("ORDINARY"))) {
			infoMessage = FacesUtil.getMessage("app_msg_error_app");
			validate = false;
		}
	}

	public void saveAppAction() {
		String appType = FacesUtil.getParam("APP_TYPE");
		infoMessage = "";
		validate = true;

		// validar Selección Pauta
		if (this.selectedWSGroupSellers.equals(Constant.DEFAULT_VALUE_STRING)) {
			String field = FacesUtil.getMessage("app_seller_group");
			infoMessage = FacesUtil.getMessage("glb_required", field);
			validate = false;
		}

		// validar Selección Cita
		if ((selectedCandidate == null) && (appType.equals("ORDINARY"))) {
			infoMessage = FacesUtil.getMessage("app_msg_error_app");
			validate = false;
		}

		if (validate) {
			CrmBranch branch = mapBranchByConsultant.get(idBranch);

			int validateApp = 0;
			validateApp = processService.validateAppointmentForDate(
					selectedCandidate.getStartDate(), selectedPatient.getId());

			this.selectedApp.setId(null);
			this.selectedApp.setCrmDiagnosises(null);
			this.selectedApp.setCrmMedications(null);

			if (validateApp == 0) {
				validateApp = processService.validateAppointmentForDate(
						branch.getId(), selectedCandidate.getStartDate(),
						selectedCandidate.getEndDate(), procedureDetail,
						selectedCandidate.getDoctor().getId(),
						selectedPatient.getId(), timeType, false);
			}

			if (validateApp != 0) {
				switch (validateApp) {
				case -1:
					infoMessage = FacesUtil.getMessage("app_msg_error_1");
					break;
				case -2:
					infoMessage = FacesUtil.getMessage("app_msg_error_2");
					break;
				case -3:
					infoMessage = FacesUtil.getMessage("app_msg_error_3");
					break;
				case -4:
					infoMessage = FacesUtil.getMessage("app_msg_error_4");
					break;
				case -5:
					infoMessage = FacesUtil.getMessage("app_msg_error_5");
					break;
				}
			} else {
				selectedApp.setCrmPatient(selectedPatient);
				selectedApp.setPatientNames(selectedPatient.getFirstnames()
						+ " " + selectedPatient.getSurnames());
				selectedApp.setCrmDoctor(selectedCandidate.getDoctor());
				selectedApp.setCrmBranch(branch);
				selectedApp.setCrmProcedureDetail(procedureDetail);

				selectedApp.setCodPublicity(selectedWSGroupSellers);
				selectedApp.setNamePublicity(mapWSGroupSellers
						.get(selectedWSGroupSellers));

				selectedApp.setStartAppointmentDate(selectedCandidate
						.getStartDate());
				selectedApp.setEndAppointmentDate(selectedCandidate
						.getEndDate());
				selectedApp.setCloseAppointment(false);
				selectedApp.setUntimely(false);
				selectedApp.setState(Constant.APP_STATE_CONFIRMED);
				selectedApp
						.setCrmUserByIdUserCreate(FacesUtil.getCurrentUser());
				selectedApp.setDateCreate(new Date());

				CrmAppointment crmAppointment = processService
						.saveAppointment(selectedApp);

				if (crmAppointment != null) {
					infoMessage = FacesUtil.getMessage("app_msg_ok",
							crmAppointment.getCode());
					saved = true;
				} else {
					infoMessage = FacesUtil.getMessage("app_msg_error");
					saved = false;
				}
			}
		}
	}

	public void handleClose(CloseEvent event) {
		if (saved) {
			newAppAction(null);
		}
	}
}