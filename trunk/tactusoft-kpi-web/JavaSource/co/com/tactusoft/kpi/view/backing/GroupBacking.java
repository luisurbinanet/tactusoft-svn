package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiGroup;
import co.com.tactusoft.kpi.util.Util;
import co.com.tactusoft.kpi.view.model.KpiGroupModel;

@Controller
@Scope("session")
public class GroupBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TablesBo service;

	private KpiGroupModel model;
	private KpiGroup selected;

	public GroupBacking() {
		selected = new KpiGroup();
	}

	public KpiGroupModel getModel() {
		if (model == null) {
			model = new KpiGroupModel(service.getListKpiGroup());
		}
		return model;
	}

	public void setModel(KpiGroupModel model) {
		this.model = model;
	}

	public KpiGroup getSelected() {
		return selected;
	}

	public void setSelected(KpiGroup selected) {
		if (selected == null) {
			selected = new KpiGroup();
		}
		this.selected = selected;
	}

	public void newAction() {
		selected = new KpiGroup();
	}

	public void deleteAction() {
		service.remove(selected);
		model = new KpiGroupModel(service.getListKpiGroup());
	}

	public void saveAction() {

		String message = null;

		if (selected.getName().length() == 0) {
			message = "El Campo Nombre es Obligatorio\n";
			Util.addWarn("Advertencia", message);
		}

		if (selected.getDescription().length() == 0) {
			message = "El Campo Descripción es Obligatorio";
			Util.addWarn("Advertencia", message);
		}

		if (message == null) {
			if (selected.getId() == null) {
				selected.setId(service.getId("KpiGroup"));
			}

			selected.setName(selected.getName().toUpperCase());
			selected.setDescription(selected.getDescription().toUpperCase());
			service.save(selected);
			message = "El registro " + selected.getName()
					+ " actualizado con Exito";
			selected = new KpiGroup();
			model = new KpiGroupModel(service.getListKpiGroup());
			Util.addInfo("Información", message);

		}
	}

}
