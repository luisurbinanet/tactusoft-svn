package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.ParameterDataModel;

@Named
@Scope("view")
public class ParameterBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ParameterBo parameterService;

	private List<CrmParameter> list;
	private ParameterDataModel model;
	private CrmParameter selected;

	public ParameterBacking() {
		newAction();
	}

	public List<CrmParameter> getList() {
		return list;
	}

	public void setList(List<CrmParameter> list) {
		this.list = list;
	}

	public ParameterDataModel getModel() {
		if (model == null) {
			list = parameterService.getListParameter();
			model = new ParameterDataModel(list);
			
			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(ParameterDataModel model) {
		this.model = model;
	}

	public CrmParameter getSelected() {
		return selected;
	}

	public void setSelected(CrmParameter selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmParameter();
	}

	public void saveAction() {
		String message = null;

		int result = parameterService.saveParameter(selected);
		if (result == 0) {
			list = parameterService.getListParameter();
			model = new ParameterDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("doc_code");
			message = FacesUtil.getMessage("msg_record_unique_exception", paramValue);
			FacesUtil.addError(message);

		}
	}

}
