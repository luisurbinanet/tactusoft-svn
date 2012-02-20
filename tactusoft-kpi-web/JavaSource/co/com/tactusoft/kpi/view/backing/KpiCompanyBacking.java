package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiCompany;
import co.com.tactusoft.kpi.util.Util;
import co.com.tactusoft.kpi.view.model.KpiCompanyModel;

@Controller
@Scope("session")
public class KpiCompanyBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TablesBo service;

	private KpiCompanyModel model;
	private KpiCompany selected; 

	public KpiCompanyBacking() {
		selected = new KpiCompany();
	}

	public KpiCompanyModel getModel() {
		if (model == null) {
			model = new KpiCompanyModel(service.getListKpiCompany());
		}
		return model;
	}

	public void setModel(KpiCompanyModel model) {
		this.model = model;
	}

	public KpiCompany getSelected() {
		return selected;
	}

	public void setSelected(KpiCompany selected) {
		if (selected == null) {
			selected = new KpiCompany();
		}
		this.selected = selected;
	}

	public void newAction() {
		selected = new KpiCompany();
	}

	public void deleteAction() {
		service.remove(selected);
		model = new KpiCompanyModel(service.getListKpiCompany());
	}

	public void saveAction() {

		String message = null;

		if (selected.getName().length() == 0) {
			message = "El Campo Nombre es Obligatorio\n";
			Util.addWarn("Advertencia", message);
		}

		if (selected.getLegalRep().length() == 0) {
			message = "El Representante Legal es Obligatorio";
			Util.addWarn("Advertencia", message);
		}
		
		if (selected.getEmail().length() == 0) {
			message = "El Correo Electrónico es Obligatorio";
			Util.addWarn("Advertencia", message);
		}

		if (message == null) {
			if (selected.getId() == null) {
				selected.setId(service.getId("KpiCompany"));
			}

			selected.setName(selected.getName().toUpperCase());
			selected.setLegalRep(selected.getLegalRep().toUpperCase());
			selected.setEmail(selected.getEmail());
			service.save(selected);
			message = "El registro " + selected.getName()
					+ " actualizado con Exito";
			//selected = new KpiCompany();
			model = new KpiCompanyModel(service.getListKpiCompany());
			Util.addInfo("Información", message);

		}
	}

}
