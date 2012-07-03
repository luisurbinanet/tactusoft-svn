package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmOccupation;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.OccupationDataModel;

@Named
@Scope("view")
public class OccupationBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmOccupation> list;
	private OccupationDataModel model;
	private CrmOccupation selected;

	public OccupationBacking() {
		newAction();
	}

	public List<CrmOccupation> getList() {
		return list;
	}

	public void setList(List<CrmOccupation> list) {
		this.list = list;
	}

	public OccupationDataModel getModel() {
		if (model == null) {
			list = tableService.getListOccupation();
			model = new OccupationDataModel(list);

			if (list.size() > 0) {
				selected = list.get(0);
			}
		}
		return model;
	}

	public void setModel(OccupationDataModel model) {
		this.model = model;
	}

	public CrmOccupation getSelected() {
		return selected;
	}

	public void setSelected(CrmOccupation selected) {
		this.selected = selected;
	}

	public void newAction() {
		selected = new CrmOccupation();
		selected.setState(Constant.STATE_ACTIVE);
	}

	public void saveAction() {
		String message = null;

		int result = tableService.saveOccupation(selected);
		if (result == 0) {
			list = tableService.getListOccupation();
			model = new OccupationDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("ocu_name");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);

		}
	}

}
