package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.controller.bo.SecurityBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCity;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmDomain;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.model.entities.CrmSpeciality;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SAPEnvironment;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.beans.WSBean;
import com.tactusoft.webservice.client.execute.CustomListsExecute;
import com.tactusoft.webservice.client.execute.CustomerExecute;

public class BaseBacking implements Serializable {

	@Inject
	protected TablesBo tablesService;

	@Inject
	protected ProcessBo processService;

	@Inject
	protected SecurityBo securityService;

	private static final long serialVersionUID = 1L;

	protected List<CrmPatient> listPatient;
	protected PatientDataModel patientModel;
	protected CrmPatient selectedPatient;
	protected CrmPatient selectedPatientTemp;
	protected String docPatient;
	protected String namePatient;
	protected int optionSearchPatient;
	protected boolean disabledAddPatient;

	protected List<SelectItem> listAllProfile;
	protected Map<BigDecimal, CrmProfile> mapAllProfile;

	protected List<SelectItem> listProfile;
	protected BigDecimal idProfile;
	protected Map<BigDecimal, CrmProfile> mapProfile;

	protected List<SelectItem> listWSDoctor;
	protected Map<String, String> mapWSDoctor;
	protected String selectedWSDoctor;

	protected List<SelectItem> listCrmBranch;
	protected Map<BigDecimal, CrmBranch> mapCrmBranch;
	protected BigDecimal idBranch;

	protected List<SelectItem> listCrmSpeciality;
	protected Map<BigDecimal, CrmSpeciality> mapCrmSpeciality;
	protected BigDecimal idSpeciality;

	protected List<SelectItem> listWSGroupSellers;
	protected Map<String, String> mapWSGroupSellers;
	protected String selectedWSGroupSellers;

	protected List<SelectItem> listCountry;
	protected BigDecimal idCountry;
	protected Map<BigDecimal, CrmCountry> mapCountry;

	protected List<CrmRegion> listAllRegion;
	protected List<SelectItem> listRegion;
	protected BigDecimal idRegion;
	protected Map<BigDecimal, CrmRegion> mapRegion;

	protected List<CrmCity> listAllCity;
	protected List<SelectItem> listCity;
	protected BigDecimal idCity;
	protected Map<BigDecimal, CrmCity> mapCity;

	protected List<SelectItem> listBranch;
	protected String salesOff;

	protected List<SelectItem> listMaritalStatus;
	protected BigDecimal idMaritalStatus;
	protected Map<BigDecimal, CrmCountry> mapMaritalStatus;

	protected List<SelectItem> listMembershipType;
	protected BigDecimal idMembershipType;
	protected Map<BigDecimal, CrmCountry> mapMembershipType;

	protected List<SelectItem> listKin;
	protected BigDecimal idKin;
	protected Map<BigDecimal, CrmCountry> mapKin;

	protected List<SelectItem> listOccupation;
	protected Map<BigDecimal, CrmOccupation> mapOccupation;
	protected BigDecimal idOccupation;

	protected Integer numPhone;
	protected Integer numCell;

	protected String typeHousing;
	protected String neighborhood;
	
	protected Date today;
	protected Date todayMax;

	public List<CrmPatient> getListPatient() {
		return listPatient;
	}

	public void setListPatient(List<CrmPatient> listPatient) {
		this.listPatient = listPatient;
	}

	public PatientDataModel getPatientModel() {
		return patientModel;
	}

	public void setPatientModel(PatientDataModel patientModel) {
		this.patientModel = patientModel;
	}

	public CrmPatient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(CrmPatient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public CrmPatient getSelectedPatientTemp() {
		return selectedPatientTemp;
	}

	public void setSelectedPatientTemp(CrmPatient selectedPatientTemp) {
		this.selectedPatientTemp = selectedPatientTemp;
	}

	public String getDocPatient() {
		return docPatient;
	}

	public void setDocPatient(String docPatient) {
		this.docPatient = docPatient;
	}

	public String getNamePatient() {
		return namePatient;
	}

	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}

	public int getOptionSearchPatient() {
		return optionSearchPatient;
	}

	public void setOptionSearchPatient(int optionSearchPatient) {
		this.optionSearchPatient = optionSearchPatient;
	}

	public void setDisabledAddPatient(boolean disabledAddPatient) {
		this.disabledAddPatient = disabledAddPatient;
	}

	public void searchPatientAction() {
		SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");
		CrmProfile profile = mapProfile.get(idProfile);

		if ((optionSearchPatient == 1 && FacesUtil
				.isEmptyOrBlank(this.docPatient))
				|| (optionSearchPatient == 2 && FacesUtil
						.isEmptyOrBlank(this.namePatient))) {

			this.listPatient = new ArrayList<CrmPatient>();
			this.patientModel = new PatientDataModel(listPatient);

		} else {
			listPatient = new ArrayList<CrmPatient>();
			List<WSBean> result = null;

			if (optionSearchPatient == 1) {
				listPatient = processService.getListPatientByNameOrDoc("DOC",
						this.docPatient);

				if (listPatient.size() == 0) {
					result = CustomerExecute.findByDoc(sap.getUrlCustomer2(),
							sap.getUsername(), sap.getPassword(),
							profile.getSociety(), this.docPatient);

					if (result.size() > 0) {
						String message = FacesUtil
								.getMessage("pat_msg_exists_sap_2");
						FacesUtil.addWarn(message);
					}

					// for (WSBean row : result) {
					// CrmPatient patient = new CrmPatient();
					// patient.setCodeSap(row.getCode());
					// patient.setNames(row.getNames());
					// listPatient.add(patient);
					// }
				}
			} else {
				listPatient = processService.getListPatientByNameOrDoc("NAMES",
						this.namePatient.toUpperCase());
			}

			patientModel = new PatientDataModel(listPatient);

			if (listPatient.size() > 0) {
				selectedPatient = listPatient.get(0);
				selectedPatientTemp = listPatient.get(0);
			}
		}
	}

	public void patientHandleClose(CloseEvent event) {
		// selectedPatient = null;
	}

	public List<SelectItem> getListAllProfile() {
		if (listAllProfile == null) {
			List<CrmProfile> list = tablesService.getListProfile();
			listAllProfile = new LinkedList<SelectItem>();
			mapAllProfile = new HashMap<BigDecimal, CrmProfile>();
			for (CrmProfile row : list) {
				listAllProfile.add(new SelectItem(row.getId(), row.getCode()));
				mapAllProfile.put(row.getId(), row);
			}

			if (listAllProfile.size() > 0) {
				idProfile = (BigDecimal) listAllProfile.get(0).getValue();
			}
		}
		return listAllProfile;
	}

	public void setListAllProfile(List<SelectItem> listAllProfile) {
		this.listAllProfile = listAllProfile;
	}

	public Map<BigDecimal, CrmProfile> getMapAllProfile() {
		return mapAllProfile;
	}

	public void setMapAllProfile(Map<BigDecimal, CrmProfile> mapAllProfile) {
		this.mapAllProfile = mapAllProfile;
	}

	public List<SelectItem> getListProfile() {
		if (listProfile == null) {
			listProfile = new LinkedList<SelectItem>();
			mapProfile = new HashMap<BigDecimal, CrmProfile>();
			for (CrmProfile row : FacesUtil.getCurrentUserData()
					.getListProfile()) {
				listProfile.add(new SelectItem(row.getId(), row.getCode()));
				mapProfile.put(row.getId(), row);
			}

			if (listProfile.size() > 0) {
				idProfile = (BigDecimal) listProfile.get(0).getValue();
			}
		}
		return listProfile;
	}

	public void setListProfile(List<SelectItem> listProfile) {
		this.listProfile = listProfile;
	}

	public BigDecimal getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(BigDecimal idProfile) {
		this.idProfile = idProfile;
	}

	public Map<BigDecimal, CrmProfile> getMapProfile() {
		return mapProfile;
	}

	public void setMapProfile(Map<BigDecimal, CrmProfile> mapProfile) {
		this.mapProfile = mapProfile;
	}

	public List<SelectItem> getListWSDoctor() {
		if (listWSDoctor == null) {
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			try {
				SAPEnvironment sap = FacesUtil.findBean("SAPEnvironment");

				List<WSBean> result = CustomListsExecute.getDoctors(
						sap.getUrlWebList(), sap.getUsername(),
						sap.getPassword());

				listWSDoctor = new ArrayList<SelectItem>();
				mapWSDoctor = new LinkedHashMap<String, String>();
				listWSDoctor.add(new SelectItem(Constant.DEFAULT_VALUE_STRING,
						label));
				for (WSBean row : result) {
					mapWSDoctor.put(row.getCode(), row.getNames());
					listWSDoctor.add(new SelectItem(row.getCode(), row
							.getNames()));
				}
			} catch (Exception ex) {
				listWSDoctor = new ArrayList<SelectItem>();
				listWSDoctor.add(new SelectItem(Constant.DEFAULT_VALUE_STRING,
						label));
			}
		}
		return listWSDoctor;
	}

	public void setListWSDoctor(List<SelectItem> listWSDoctor) {
		this.listWSDoctor = listWSDoctor;
	}

	public Map<String, String> getMapWSDoctor() {
		return mapWSDoctor;
	}

	public void setMapWSDoctor(Map<String, String> mapWSDoctor) {
		this.mapWSDoctor = mapWSDoctor;
	}

	public String getSelectedWSDoctor() {
		return selectedWSDoctor;
	}

	public void setSelectedWSDoctor(String selectedWSDoctor) {
		this.selectedWSDoctor = selectedWSDoctor;
	}

	public TablesBo getTablesService() {
		return tablesService;
	}

	public void setTablesService(TablesBo tablesService) {
		this.tablesService = tablesService;
	}

	public ProcessBo getProcessService() {
		return processService;
	}

	public void setProcessService(ProcessBo processService) {
		this.processService = processService;
	}

	public boolean isDisabledAddPatient() {
		if ((listPatient == null) || (listPatient.size() == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isDisabledSelectedPatient() {
		if ((selectedPatient == null)
				|| (FacesUtil.isEmptyOrBlank(selectedPatient.getFirstnames()))) {
			return true;
		}
		return false;
	}

	public List<SelectItem> getListCrmBranch() {
		if (listCrmBranch == null) {
			listCrmBranch = new LinkedList<SelectItem>();
			mapCrmBranch = new LinkedHashMap<BigDecimal, CrmBranch>();
			//String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			//listCrmBranch.add(new SelectItem(Constant.DEFAULT_VALUE, label));
			for (CrmBranch row : tablesService.getListBranchActive1000()) {
				mapCrmBranch.put(row.getId(), row);
				listCrmBranch.add(new SelectItem(row.getId(), row.getName()
						+ " (" + row.getSociety() + ")"));
			}
		}
		return listCrmBranch;
	}

	public void setListCrmBranch(List<SelectItem> listCrmBranch) {
		this.listCrmBranch = listCrmBranch;
	}

	public Map<BigDecimal, CrmBranch> getMapCrmBranch() {
		return mapCrmBranch;
	}

	public void setMapCrmBranch(Map<BigDecimal, CrmBranch> mapCrmBranch) {
		this.mapCrmBranch = mapCrmBranch;
	}

	public BigDecimal getIdBranch() {
		return idBranch;
	}

	public void setIdBranch(BigDecimal idBranch) {
		this.idBranch = idBranch;
	}

	public List<SelectItem> getListCrmSpeciality() {
		if (listCrmSpeciality == null) {
			listCrmSpeciality = new LinkedList<SelectItem>();
			mapCrmSpeciality = new LinkedHashMap<BigDecimal, CrmSpeciality>();
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listCrmSpeciality
					.add(new SelectItem(Constant.DEFAULT_VALUE, label));
			for (CrmSpeciality row : tablesService.getListSpecialityActive()) {
				mapCrmSpeciality.put(row.getId(), row);
				listCrmSpeciality.add(new SelectItem(row.getId(), row
						.getDescription()));
			}
		}
		return listCrmSpeciality;
	}

	public void setListCrmSpeciality(List<SelectItem> listCrmSpeciality) {
		this.listCrmSpeciality = listCrmSpeciality;
	}

	public Map<BigDecimal, CrmSpeciality> getMapCrmSpeciality() {
		return mapCrmSpeciality;
	}

	public void setMapCrmSpeciality(
			Map<BigDecimal, CrmSpeciality> mapCrmSpeciality) {
		this.mapCrmSpeciality = mapCrmSpeciality;
	}

	public BigDecimal getIdSpeciality() {
		return idSpeciality;
	}

	public void setIdSpeciality(BigDecimal idSpeciality) {
		this.idSpeciality = idSpeciality;
	}

	public List<SelectItem> getListWSGroupSellers() {
		if (listWSGroupSellers == null) {
			List<WSBean> result = FacesUtil.getCurrentUserData()
					.getListWSGroupSellers();

			listWSGroupSellers = new ArrayList<SelectItem>();
			mapWSGroupSellers = new LinkedHashMap<String, String>();

			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listWSGroupSellers.add(new SelectItem(
					Constant.DEFAULT_VALUE_STRING, label));
			for (WSBean row : result) {
				mapWSGroupSellers.put(row.getCode(), row.getNames());
				listWSGroupSellers.add(new SelectItem(row.getCode(), row
						.getNames()));
			}
		}
		return listWSGroupSellers;
	}

	public void setListWSGroupSellers(List<SelectItem> listWSGroupSellers) {
		this.listWSGroupSellers = listWSGroupSellers;
	}

	public Map<String, String> getMapWSGroupSellers() {
		return mapWSGroupSellers;
	}

	public void setMapWSGroupSellers(Map<String, String> mapWSGroupSellers) {
		this.mapWSGroupSellers = mapWSGroupSellers;
	}

	public String getSelectedWSGroupSellers() {
		return selectedWSGroupSellers;
	}

	public void setSelectedWSGroupSellers(String selectedWSGroupSellers) {
		this.selectedWSGroupSellers = selectedWSGroupSellers;
	}

	public List<SelectItem> getListCountry() {
		if (listCountry == null) {
			listCountry = new LinkedList<SelectItem>();
			mapCountry = new HashMap<BigDecimal, CrmCountry>();
			for (CrmCountry row : tablesService.getListCountry()) {
				listCountry.add(new SelectItem(row.getId(), row.getName()));
				mapCountry.put(row.getId(), row);
			}

			if (listCountry.size() > 0) {
				idCountry = (BigDecimal) listCountry.get(0).getValue();
				listAllRegion = tablesService.getListRegion();
				listAllCity = tablesService.getListCity();
				handleCountryChange();
			}
		}
		return listCountry;
	}

	public void setListCountry(List<SelectItem> listCountry) {
		this.listCountry = listCountry;
	}

	public BigDecimal getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(BigDecimal idCountry) {
		this.idCountry = idCountry;
	}

	public Map<BigDecimal, CrmCountry> getMapCountry() {
		return mapCountry;
	}

	public void setMapCountry(Map<BigDecimal, CrmCountry> mapCountry) {
		this.mapCountry = mapCountry;
	}

	public List<CrmRegion> getListAllRegion() {
		return listAllRegion;
	}

	public void setListAllRegion(List<CrmRegion> listAllRegion) {
		this.listAllRegion = listAllRegion;
	}

	public List<SelectItem> getListRegion() {
		return listRegion;
	}

	public void setListRegion(List<SelectItem> listRegion) {
		this.listRegion = listRegion;
	}

	public BigDecimal getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(BigDecimal idRegion) {
		this.idRegion = idRegion;
	}

	public Map<BigDecimal, CrmRegion> getMapRegion() {
		return mapRegion;
	}

	public void setMapRegion(Map<BigDecimal, CrmRegion> mapRegion) {
		this.mapRegion = mapRegion;
	}

	public List<CrmCity> getListAllCity() {
		return listAllCity;
	}

	public void setListAllCity(List<CrmCity> listAllCity) {
		this.listAllCity = listAllCity;
	}

	public List<SelectItem> getListCity() {
		return listCity;
	}

	public void setListCity(List<SelectItem> listCity) {
		this.listCity = listCity;
	}

	public BigDecimal getIdCity() {
		return idCity;
	}

	public void setIdCity(BigDecimal idCity) {
		this.idCity = idCity;
	}

	public Map<BigDecimal, CrmCity> getMapCity() {
		return mapCity;
	}

	public void setMapCity(Map<BigDecimal, CrmCity> mapCity) {
		this.mapCity = mapCity;
	}

	public List<SelectItem> getListBranch() {
		if (listBranch == null) {
			listBranch = new LinkedList<SelectItem>();
			for (CrmBranch row : FacesUtil.getCurrentUserData().getListBranch()) {
				listBranch.add(new SelectItem(row.getCode(), row.getName()
						+ " (" + row.getSociety() + ")"));
			}
		}
		return listBranch;
	}

	public void setListBranch(List<SelectItem> listBranch) {
		this.listBranch = listBranch;
	}

	public List<SelectItem> getListMaritalStatus() {
		if (listMaritalStatus == null) {
			listMaritalStatus = new LinkedList<SelectItem>();
			for (CrmDomain row : tablesService.getListDomain("ESTADO_CIVIL")) {
				listMaritalStatus.add(new SelectItem(row.getId(), row
						.getItemValue()));
			}
		}
		return listMaritalStatus;
	}

	public void setListMaritalStatus(List<SelectItem> listMaritalStatus) {
		this.listMaritalStatus = listMaritalStatus;
	}

	public BigDecimal getIdMaritalStatus() {
		return idMaritalStatus;
	}

	public void setIdMaritalStatus(BigDecimal idMaritalStatus) {
		this.idMaritalStatus = idMaritalStatus;
	}

	public Map<BigDecimal, CrmCountry> getMapMaritalStatus() {
		return mapMaritalStatus;
	}

	public void setMapMaritalStatus(Map<BigDecimal, CrmCountry> mapMaritalStatus) {
		this.mapMaritalStatus = mapMaritalStatus;
	}

	public List<SelectItem> getListMembershipType() {
		if (listMembershipType == null) {
			listMembershipType = new LinkedList<SelectItem>();
			for (CrmDomain row : tablesService.getListDomain("TIPO_AFILIACION")) {
				listMembershipType.add(new SelectItem(row.getId(), row
						.getItemValue()));
			}
		}
		return listMembershipType;
	}

	public void setListMembershipType(List<SelectItem> listMembershipType) {
		this.listMembershipType = listMembershipType;
	}

	public BigDecimal getIdMembershipType() {
		return idMembershipType;
	}

	public void setIdMembershipType(BigDecimal idMembershipType) {
		this.idMembershipType = idMembershipType;
	}

	public Map<BigDecimal, CrmCountry> getMapMembershipType() {
		return mapMembershipType;
	}

	public void setMapMembershipType(
			Map<BigDecimal, CrmCountry> mapMembershipType) {
		this.mapMembershipType = mapMembershipType;
	}

	public List<SelectItem> getListKin() {
		if (listKin == null) {
			listKin = new LinkedList<SelectItem>();
			String labelDefaultValue = FacesUtil
					.getMessage(Constant.DEFAULT_LABEL);
			listKin.add(new SelectItem(Constant.DEFAULT_VALUE,
					labelDefaultValue));
			for (CrmDomain row : tablesService.getListDomain("PARENTESCO")) {
				listKin.add(new SelectItem(row.getId(), row.getItemValue()));
			}
		}
		return listKin;
	}

	public void setListKin(List<SelectItem> listKin) {
		this.listKin = listKin;
	}

	public BigDecimal getIdKin() {
		return idKin;
	}

	public void setIdKin(BigDecimal idKin) {
		this.idKin = idKin;
	}

	public Map<BigDecimal, CrmCountry> getMapKin() {
		return mapKin;
	}

	public void setMapKin(Map<BigDecimal, CrmCountry> mapKin) {
		this.mapKin = mapKin;
	}

	public String getSalesOff() {
		return salesOff;
	}

	public void setSalesOff(String salesOff) {
		this.salesOff = salesOff;
	}

	public String getRolePrincipal() {
		return FacesUtil.getCurrentUserData().getRolePrincipal();
	}

	public boolean isOpenAppointment() {
		return FacesUtil.getCurrentUserData().isOpenAppointment();
	}

	public boolean isPrintFormula() {
		return FacesUtil.getCurrentUserData().isPrintFormula();
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

	public Integer getNumPhone() {
		return numPhone;
	}

	public void setNumPhone(Integer numPhone) {
		this.numPhone = numPhone;
	}

	public Integer getNumCell() {
		return numCell;
	}

	public void setNumCell(Integer numCell) {
		this.numCell = numCell;
	}

	public String getTypeHousing() {
		return typeHousing;
	}

	public void setTypeHousing(String typeHousing) {
		this.typeHousing = typeHousing;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Date getTodayMax() {
		return todayMax;
	}

	public void setTodayMax(Date todayMax) {
		this.todayMax = todayMax;
	}

	public void newPatientAction(ActionEvent event) {
		optionSearchPatient = 1;
		selectedPatient = new CrmPatient();
		List<CrmPatient> listPatient = new LinkedList<CrmPatient>();
		patientModel = new PatientDataModel(listPatient);
		docPatient = null;
		namePatient = null;
	}

	public void handleCountryChange() {
		if (idCountry != null) {
			CrmCountry crmCountry = mapCountry.get(idCountry);
			listRegion = new LinkedList<SelectItem>();
			mapRegion = new HashMap<BigDecimal, CrmRegion>();

			for (CrmRegion row : this.listAllRegion) {
				if (row.getCrmCountry().getId().intValue() == crmCountry
						.getId().intValue()) {
					listRegion.add(new SelectItem(row.getId(), row.getName()));
					mapRegion.put(row.getId(), row);
				}
			}

			if (listRegion.size() > 0) {
				idRegion = (BigDecimal) listRegion.get(0).getValue();
				handleRegionChange();
			} else {
				idRegion = null;
				idCity = null;
				listRegion = new LinkedList<SelectItem>();
				listCity = new LinkedList<SelectItem>();
			}

		} else {
			idRegion = null;
			idCity = null;
			listRegion = new LinkedList<SelectItem>();
			listCity = new LinkedList<SelectItem>();
		}
	}

	public void handleRegionChange() {
		CrmRegion crmRegion = mapRegion.get(idRegion);
		listCity = new LinkedList<SelectItem>();
		mapCity = new HashMap<BigDecimal, CrmCity>();
		for (CrmCity row : this.listAllCity) {
			if (row.getCrmRegion().getId().intValue() == crmRegion.getId()
					.intValue()) {
				listCity.add(new SelectItem(row.getId(), row.getName()));
				mapCity.put(row.getId(), row);
			}
		}

		if (listRegion.size() > 0) {
			idCity = (BigDecimal) listCity.get(0).getValue();
		} else {
			idCity = null;
		}
	}

	protected int calculateAge(Date bornDate) {
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

	public void addPatient(ActionEvent event) {
		boolean validate = true;
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedPatientTemp.getId() == null) {
			validate = false;
		} else {
			selectedPatient = selectedPatientTemp;
		}
		context.addCallbackParam("validate", validate);
	}

	protected String getStringSelecteds(List<String> listCrmBranch) {
		String result = "";
		for (String row : listCrmBranch) {
			result = result + row + ",";
		}

		if (result.trim().length() > 0) {
			result = result.substring(0, result.length() - 1);
		}

		return result;
	}

}
