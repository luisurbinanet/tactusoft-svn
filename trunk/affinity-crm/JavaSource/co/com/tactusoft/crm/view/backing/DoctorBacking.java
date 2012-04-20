package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.view.datamodel.DoctorDataModel;

@Named
@Scope("view")
public class DoctorBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo tableService;

	private List<CrmDoctor> list;
	private DoctorDataModel model;
	private CrmDoctor selected;

	public DoctorBacking() {

	}

	public List<CrmDoctor> getList() {
		return list;
	}

	public void setList(List<CrmDoctor> list) {
		this.list = list;
	}

	public DoctorDataModel getModel() {
		if (model == null) {
			list = tableService.getListDoctor();
			model = new DoctorDataModel(list);
		}
		return model;
	}

	public void setModel(DoctorDataModel model) {
		this.model = model;
	}

	public CrmDoctor getSelected() {
		return selected;
	}

	public void setSelected(CrmDoctor selected) {
		this.selected = selected;
	}

}
