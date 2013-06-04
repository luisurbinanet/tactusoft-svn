package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmCaseStudy;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CaseStudyDataModel;

@Named
@Scope("view")
public class CaseStudyBacking extends BaseBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CrmCaseStudy> list;
	private CaseStudyDataModel model;
	private CrmCaseStudy selected;

	private CrmDoctor crmDoctor;

	public CaseStudyBacking() {
		newAction();
	}

	@PostConstruct
	public void init() {
		crmDoctor = processService.getCrmDoctor();
	}

	public List<CrmCaseStudy> getList() {
		return list;
	}

	public void setList(List<CrmCaseStudy> list) {
		this.list = list;
	}

	public CaseStudyDataModel getModel() {
		if (model == null) {
			list = tablesService.getListCaseStudy();
			model = new CaseStudyDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(CaseStudyDataModel model) {
		this.model = model;
	}

	public CrmCaseStudy getSelected() {
		return selected;
	}

	public void setSelected(CrmCaseStudy selected) {
		this.selected = selected;
	}

	public boolean isDisabledNew() {
		return crmDoctor == null ? true : false;
	}

	public void newAction() {
		selected = new CrmCaseStudy();
		optionSearchPatient = 1;
		docPatient = "";
		namePatient = "";
	}

	public void saveAction() {
		String message = null;
		boolean validate = true;
		RequestContext context = RequestContext.getCurrentInstance();
		if (selectedPatientTemp == null) {
			message = FacesUtil.getMessage("app_msg_error_pat");
			FacesUtil.addError(message);
			validate = false;
		} else {
			//selected.setCrmPatient(selectedPatient);
			//selected.setCrmDoctor(crmDoctor);
			int result = tablesService.saveCaseStudy(selected);
			if (result == 0) {
				list = tablesService.getListCaseStudy();
				model = new CaseStudyDataModel(list);
				message = FacesUtil.getMessage("msg_record_ok");
				FacesUtil.addInfo(message);
			} else if (result == -1) {
				String paramValue = FacesUtil.getMessage("pro_code");
				message = FacesUtil.getMessage("msg_record_unique_exception",
						paramValue);
				FacesUtil.addError(message);
			}
		}
		context.addCallbackParam("validate", validate);
	}

}
