package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.TablesBo;
import co.com.tactusoft.crm.model.entities.CrmDoctor;
import co.com.tactusoft.crm.model.entities.CrmSpeciality;
import co.com.tactusoft.crm.util.FacesUtil;
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

	private List<SelectItem> listCrmSpeciality;
	private Map<BigDecimal, CrmSpeciality> mapCrmSpeciality;

	public DoctorBacking() {
		newAction();
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

	public List<SelectItem> getListCrmSpeciality() {
		if (listCrmSpeciality == null) {
			listCrmSpeciality = new LinkedList<SelectItem>();
			mapCrmSpeciality = new HashMap<BigDecimal, CrmSpeciality>();
			for (CrmSpeciality row : tableService.getListSpecialityActive()) {
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

	public void newAction() {
		selected = new CrmDoctor();
		selected.setOnSite(false);
		selected.setVirtual(false);
		selected.setState(1);
		selected.setCrmSpeciality(new CrmSpeciality());
	}

	public void saveAction() {
		String message = null;

		selected.setCrmSpeciality(mapCrmSpeciality.get(selected.getCrmSpeciality()
				.getId()));

		int result = tableService.saveDoctor(selected);
		if (result == 0) {
			list = tableService.getListDoctor();
			model = new DoctorDataModel(list);
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("doc_code");
			message = FacesUtil.getMessage("msg_record_unique_exception", paramValue);
			FacesUtil.addError(message);

		}
	}

}
