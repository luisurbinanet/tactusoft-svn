package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiDelay;
import co.com.tactusoft.kpi.util.Util;
import co.com.tactusoft.kpi.view.model.KpiDelayModel;

@Controller
@Scope("session")
public class KpiDelayBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TablesBo service;

	private KpiDelayModel model;
	private KpiDelay selected;

	public KpiDelayBacking() {
		selected = new KpiDelay();
	}

	public KpiDelayModel getModel() {
		if (model == null) {
			model = new KpiDelayModel(service.getListKpiDelay());
		}
		return model;
	}

	public void setModel(KpiDelayModel model) {
		this.model = model;
	}

	public KpiDelay getSelected() {
		return selected;
	}

	public void setSelected(KpiDelay selected) {
		if (selected == null) {
			selected = new KpiDelay();
		}
		this.selected = selected;
	}

	public void newAction() {
		selected = new KpiDelay();
	}

	public void deleteAction() {
		service.remove(selected);
		model = new KpiDelayModel(service.getListKpiDelay());
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
				selected.setId(service.getId("KpiDelay"));
				selected.setState(1);
			}

			selected.setName(selected.getName().toUpperCase());
			selected.setDescription(selected.getDescription().toUpperCase());
			service.save(selected);
			message = "El registro " + selected.getName()
					+ " actualizado con Exito";
			selected = new KpiDelay();
			model = new KpiDelayModel(service.getListKpiDelay());
			Util.addInfo("Información", message);

		}
	}

}
