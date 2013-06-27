package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

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
		if (crmDoctor != null) {

		}
	}

	public List<CrmCaseStudy> getList() {
		return list;
	}

	public void setList(List<CrmCaseStudy> list) {
		this.list = list;
	}

	public CaseStudyDataModel getModel() {
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
		selectedsBranchObject = null;
	}

	public void searchAction(ActionEvent event) {
		if (selectedsBranchObject != null && selectedsBranchObject.length > 0) {
			list = tablesService.getListCaseStudy();
			model = new CaseStudyDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		} else {
			String message = FacesUtil.getMessage("app_no_branch");
			FacesUtil.addInfo(message);
		}
	}

}
