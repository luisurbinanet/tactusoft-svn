package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmSpeciality;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.SpecialityDataModel;

@Named
@Scope("view")
public class SpecialityBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmSpeciality> list;
	private SpecialityDataModel model;
	private CrmSpeciality selected;

	public SpecialityBacking() {
		newAction();
	}

	public List<CrmSpeciality> getList() {
		return list;
	}

	public void setList(List<CrmSpeciality> list) {
		this.list = list;
	}

	public SpecialityDataModel getModel() {
		if (model == null) {
			list = tableService.getListSpeciality();
			model = new SpecialityDataModel(list);
		}
		return model;
	}

	public void setModel(SpecialityDataModel model) {
		this.model = model;
	}

	public CrmSpeciality getSelected() {
		return selected;
	}

	public void setSelected(CrmSpeciality selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmSpeciality();
		selected.setState(1);
	}

	public void saveAction() {
		String message = null;

		int result = tableService.saveSpeciality(selected);
		if (result == 0) {
			list = tableService.getListSpeciality();
			model = new SpecialityDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("doc_code");
			message = FacesUtil.getMessage("msg_record_unique_exception", paramValue);
			FacesUtil.addError(message);

		}
	}

}
