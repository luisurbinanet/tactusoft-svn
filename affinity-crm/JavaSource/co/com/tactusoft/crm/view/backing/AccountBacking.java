package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ProcessBo;
import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmCity;
import co.com.tactusoft.crm.model.entities.CrmCountry;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.model.entities.CrmProfile;
import co.com.tactusoft.crm.model.entities.CrmRegion;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.util.SugarEnvironment;
import co.com.tactusoft.crm.view.datamodel.PatientDataModel;

import com.tactusoft.webservice.client.execute.SugarWS;

@Named
@Scope("view")
public class AccountBacking extends BaseBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	@Inject
	private ProcessBo processService;

	private List<CrmPatient> list;
	private PatientDataModel model;
	private CrmPatient selected;

	public AccountBacking() {
		newAction();
	}

	@PostConstruct
	public void init() {
		list = tableService.getListGroup();
		model = new PatientDataModel(list);

		if (list.size() > 0) {
			selected = list.get(0);
		}
	}

	public List<CrmPatient> getList() {
		return list;
	}

	public void setList(List<CrmPatient> list) {
		this.list = list;
	}

	public PatientDataModel getModel() {
		return model;
	}

	public void setModel(PatientDataModel model) {
		this.model = model;
	}

	public CrmPatient getSelected() {
		return selected;
	}

	public void setSelected(CrmPatient selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmPatient();
		selected.setCrmOccupation(new CrmOccupation());
	}

	public void editAction() {
		if (selected != null && selected.getId() != null) {
			idCountry = selected.getIdCountry();
			handleCountryChange();
			idRegion = selected.getIdRegion();
			handleRegionChange();
			idCity = selected.getIdCity();
		}
	}

	public void saveAction() {
		String message = null;
		boolean saved = false;

		selected.setCodeSap(null);
		selected.setPatientType(Constant.PATIENT_TYPE_ACCOUNT);
		if (FacesUtil.isEmptyOrBlank(selected.getDoc())) {
			selected.setDoc(null);
		}

		RequestContext context = RequestContext.getCurrentInstance();
		CrmProfile profile = new CrmProfile();
		profile.setId(new BigDecimal(0));
		selected.setCrmProfile(profile);
		selected.setIdCountry(idCountry);
		selected.setIdRegion(idRegion);
		selected.setIdCity(idCity);
		selected.setCrmUserByIdUserCreate(FacesUtil.getCurrentUser());
		selected.setDateCreate(new Date());

		int result = processService.savePatient(selected, false, false, null);
		if (result == 0) {
			list = tableService.getListGroup();
			model = new PatientDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			saved = true;

			CrmCountry crmCountry = mapCountry.get(idCountry);
			CrmRegion crmRegion = mapRegion.get(idRegion);
			CrmCity crmCity = mapCity.get(idCity);

			SugarEnvironment sugarEnvironment = FacesUtil
					.findBean("sugarEnvironment");
			SugarWS createSugarContact = new SugarWS(sugarEnvironment.getUrl(),
					sugarEnvironment.getUsername(), sugarEnvironment.getKey());
			createSugarContact.persistAccount(selected.getId().intValue(),
					selected.getDoc(), selected.getFirstnames(),
					selected.getFirstnames(), selected.getSurnames(),
					crmCountry.getName(), crmRegion.getName(),
					crmCity.getName(), null, null,
					String.valueOf(selected.getPhoneNumber()), null,
					selected.getEmail());

			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("acc_code");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);
		}
		context.addCallbackParam("saved", saved);
	}

}
