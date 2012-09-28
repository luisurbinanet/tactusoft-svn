package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.event.CloseEvent;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.controller.bo.SecurityBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmBranch;
import co.com.tactusoft.crm.model.entities.CrmCity;
import co.com.tactusoft.crm.model.entities.CrmCountry;
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
	protected String docPatient;
	protected String namePatient;
	protected int optionSearchPatient;
	protected boolean disabledAddPatient;

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

		if ((optionSearchPatient == 1 && this.docPatient.isEmpty())
				|| (optionSearchPatient == 2 && this.namePatient.isEmpty())) {

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

					for (WSBean row : result) {
						CrmPatient patient = new CrmPatient();
						patient.setCodeSap(row.getCode());
						patient.setNames(row.getNames());
						listPatient.add(patient);
					}
				}
			} else {
				listPatient = processService.getListPatientByNameOrDoc("NAMES",
						this.namePatient.toUpperCase());

				/*
				 * result = CustomerExecute.findByName(sap.getUrlCustomer2(),
				 * sap.getUsername(), sap.getPassword(), profile.getSociety(),
				 * this.namePatient);
				 * 
				 * for (WSBean row : result) { boolean validate = true;
				 * 
				 * for (CrmPatient pat : listPatient) { if
				 * (row.getCode().equals(pat.getCodeSap())) { validate = false;
				 * break; } }
				 * 
				 * if (validate) { CrmPatient patient = new CrmPatient();
				 * patient.setCodeSap(row.getCode());
				 * patient.setNames(row.getNames()); listPatient.add(patient); }
				 * }
				 */
			}

			patientModel = new PatientDataModel(listPatient);

			if (listPatient.size() > 0) {
				selectedPatient = listPatient.get(0);
			}
		}
	}

	public void patientHandleClose(CloseEvent event) {
		// selectedPatient = null;
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
		if ((selectedPatient == null) || (selectedPatient.getCodeSap() == null)) {
			return true;
		}
		return false;
	}

	public List<SelectItem> getListCrmBranch() {
		if (listCrmBranch == null) {
			listCrmBranch = new LinkedList<SelectItem>();
			mapCrmBranch = new LinkedHashMap<BigDecimal, CrmBranch>();
			String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
			listCrmBranch.add(new SelectItem(Constant.DEFAULT_VALUE, label));
			for (CrmBranch row : tablesService.getListBranchActive()) {
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

	public String getSalesOff() {
		return salesOff;
	}

	public void setSalesOff(String salesOff) {
		this.salesOff = salesOff;
	}

	public String getRolePrincipal() {
		return FacesUtil.getCurrentUserData().getRolePrincipal();
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

}
