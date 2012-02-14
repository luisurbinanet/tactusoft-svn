package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiWorkOrder;
import co.com.tactusoft.kpi.util.Util;
import co.com.tactusoft.kpi.view.model.KpiWorkOrderModel;

@Controller
@Scope("session")
public class KpiWorkOrderBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TablesBo service;

	private KpiWorkOrderModel model;
	private KpiWorkOrder selected; 

	public KpiWorkOrderBacking() {
		selected = new KpiWorkOrder();
	}

	public KpiWorkOrderModel getModel() {
		if (model == null) {
			model = new KpiWorkOrderModel(service.getListKpiWorkOrder());
		}
		return model;
	}

	public void setModel(KpiWorkOrderModel model) {
		this.model = model;
	}

	public KpiWorkOrder getSelected() {
		return selected;
	}

	public void setSelected(KpiWorkOrder selected) {
		if (selected == null) {
			selected = new KpiWorkOrder();
		}
		this.selected = selected;
	}

	public void newAction() {
		selected = new KpiWorkOrder();
	}

	public void deleteAction() {
		service.remove(selected);
		model = new KpiWorkOrderModel(service.getListKpiWorkOrder());
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
		
		if (selected.getScheduledHours() == 0) {
			message = "El Campo Horas es Obligatorio";
			Util.addWarn("Advertencia", message);
		}

		if (message == null) {
			if (selected.getId() == null) {
				selected.setId(service.getId("KpiWorkOrder"));
			}

			selected.setName(selected.getName().toUpperCase());
			selected.setDescription(selected.getDescription().toUpperCase());
			service.save(selected);
			message = "El registro " + selected.getName()
					+ " actualizado con Exito";
			//selected = new KpiWorkOrder();
			model = new KpiWorkOrderModel(service.getListKpiWorkOrder());
			Util.addInfo("Información", message);

		}
	}

}
