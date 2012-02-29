package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiCompany;
import co.com.tactusoft.kpi.util.Constant;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.KpiCompanyModel;

@Named
@Scope("view")
public class KpiCompanyBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private TablesBo service;

	private KpiCompanyModel model;
	private KpiCompany selected; 

	public KpiCompanyBacking() {
		selected = new KpiCompany();
		model = null;
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
		String field = null;

		if (selected.getName().length() == 0) {
			field = FacesUtil.getMessage("cmp_name");
			message = FacesUtil.getMessage("msg_field_required",field);
			FacesUtil.addWarn(message);
		}

		if (selected.getLegalRep().length() == 0) {
			field = FacesUtil.getMessage("cmp_legal_rep");
			message = FacesUtil.getMessage("msg_field_required",field);
			FacesUtil.addWarn(message);
		}
		
		if (selected.getEmail().length() == 0) {
			field = FacesUtil.getMessage("cmp_email");
			message = FacesUtil.getMessage("msg_field_required",field);
			FacesUtil.addWarn(message);
		}

		if (message == null) {
			if (selected.getId() == null) {
				selected.setId(service.getId("KpiCompany"));
				selected.setState(Constant.STATE_ACTIVE);
			}

			selected.setName(selected.getName().toUpperCase());
			selected.setLegalRep(selected.getLegalRep().toUpperCase());
			selected.setEmail(selected.getEmail());
			service.save(selected);
			message = FacesUtil.getMessage("msg_record_ok", selected.getName());
			model = new KpiCompanyModel(service.getListKpiCompany());
			FacesUtil.addInfo(message);
		}
	}

}
