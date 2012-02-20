package co.com.tactusoft.kpi.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiCompany;
import co.com.tactusoft.kpi.model.entities.KpiHeader;
import co.com.tactusoft.kpi.util.Constant;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.KpiCompanyModel;

@Controller
@Scope("session")
public class KpiHeaderBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TablesBo tableService;

	private KpiCompanyModel model;
	private KpiHeader selected;

	private List<SelectItem> listItemCompany;
	private Map<BigDecimal, KpiCompany> mapKpiCompany = new HashMap<BigDecimal, KpiCompany>();
	private BigDecimal idSelectedCompany;

	public KpiHeaderBacking() {
		selected = new KpiHeader();
	}

	public KpiCompanyModel getModel() {
		if (model == null) {
			model = new KpiCompanyModel(tableService.getListKpiCompany());
		}
		return model;
	}

	public void setModel(KpiCompanyModel model) {
		this.model = model;
	}

	public KpiHeader getSelected() {
		return selected;
	}

	public void setSelected(KpiHeader selected) {
		if (selected == null) {
			selected = new KpiHeader();
		}
		this.selected = selected;
	}

	public List<SelectItem> getListItemCompany() {
		if (listItemCompany == null) {
			listItemCompany = new ArrayList<SelectItem>();
			List<KpiCompany> list = tableService.getListKpiCompanyActive();
			for (KpiCompany row : list) {
				SelectItem item = new SelectItem();
				item.setValue(row.getId());
				item.setLabel(row.getName());

				listItemCompany.add(item);
				mapKpiCompany.put(row.getId(), row);
			}

			if (listItemCompany.size() > 0) {
				// this.idKpiWeek = list.get(0).getId();
			}
		}
		return listItemCompany;
	}

	public void setListItemCompany(List<SelectItem> listItemCompany) {
		this.listItemCompany = listItemCompany;
	}

	public BigDecimal getIdSelectedCompany() {
		return idSelectedCompany;
	}

	public void setIdSelectedCompany(BigDecimal idSelectedCompany) {
		this.idSelectedCompany = idSelectedCompany;
	}

	public void searchAction(ActionEvent event) {
		selected = new KpiHeader();
	}

	public void deleteAction() {
		tableService.remove(selected);
		model = new KpiCompanyModel(tableService.getListKpiCompany());
	}

	public void saveAction() {

		String message = null;
		String field = null;

		if (selected.getName().length() == 0) {
			field = FacesUtil.getMessage("cmp_name");
			message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
		}

		if (message == null) {
			if (selected.getId() == null) {
				selected.setId(tableService.getId("KpiHeader"));
				selected.setState(Constant.STATE_ACTIVE);
				selected.setKpiCompany(mapKpiCompany.get(idSelectedCompany));
			}

			selected.setName(selected.getName().toUpperCase());
			tableService.save(selected);
			message = FacesUtil.getMessage("msg_record_ok", selected.getName());
			model = new KpiCompanyModel(tableService.getListKpiCompany());
			FacesUtil.addInfo(message);
		}
	}

}
