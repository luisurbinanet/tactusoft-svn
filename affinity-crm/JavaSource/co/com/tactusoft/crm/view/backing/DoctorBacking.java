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
import co.com.tactusoft.crm.model.entities.CrmSpecialty;
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

	private List<SelectItem> listCrmSpecialty;
	private Map<BigDecimal, CrmSpecialty> mapCrmSpecialty;

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

	public List<SelectItem> getListCrmSpecialty() {
		if (listCrmSpecialty == null) {
			listCrmSpecialty = new LinkedList<SelectItem>();
			mapCrmSpecialty = new HashMap<BigDecimal, CrmSpecialty>();
			for (CrmSpecialty row : tableService.getListSpecialityActive()) {
				mapCrmSpecialty.put(row.getId(), row);
				listCrmSpecialty.add(new SelectItem(row.getId(), row
						.getDescription()));
			}
		}
		return listCrmSpecialty;
	}

	public void setListCrmSpecialty(List<SelectItem> listCrmSpecialty) {
		this.listCrmSpecialty = listCrmSpecialty;
	}

	public void newAction() {
		selected = new CrmDoctor();
		selected.setOnSite(false);
		selected.setVirtual(false);
		selected.setState(1);
		selected.setCrmSpecialty(new CrmSpecialty());
	}

	public void saveAction() {
		selected.setCrmSpecialty(mapCrmSpecialty.get(selected.getCrmSpecialty()
				.getId()));
		tableService.saveDoctor(selected);

		list = tableService.getListDoctor();
		model = new DoctorDataModel(list);
	}

}
