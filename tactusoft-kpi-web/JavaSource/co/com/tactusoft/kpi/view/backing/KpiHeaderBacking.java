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

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.com.tactusoft.kpi.controller.bo.AdminBo;
import co.com.tactusoft.kpi.controller.bo.TablesBo;
import co.com.tactusoft.kpi.model.entities.KpiCompany;
import co.com.tactusoft.kpi.model.entities.KpiDelay;
import co.com.tactusoft.kpi.model.entities.KpiHeader;
import co.com.tactusoft.kpi.model.entities.KpiHeaderDelay;
import co.com.tactusoft.kpi.util.Constant;
import co.com.tactusoft.kpi.util.FacesUtil;
import co.com.tactusoft.kpi.view.model.KpiHeaderDelayModel;
import co.com.tactusoft.kpi.view.model.KpiHeaderModel;

@Controller
@Scope("session")
public class KpiHeaderBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private TablesBo tableService;
	@Resource
	private AdminBo adminService;

	private KpiHeaderModel model;
	private KpiHeaderDelayModel modelHeaderDelay;

	private KpiHeader selected;
	private KpiHeaderDelay selectedHeaderDelay;

	List<KpiHeaderDelay> listHeaderDelay;
	List<KpiDelay> listNew;
	KpiHeaderDelay[] listDelete;
	KpiHeaderDelay[] listDeleteOld;

	private List<SelectItem> listItemCompany;
	private List<SelectItem> listItemDelay;
	private Map<BigDecimal, KpiCompany> mapKpiCompany;
	private Map<BigDecimal, KpiDelay> mapKpiDelay;
	private BigDecimal idSelectedCompany;
	private BigDecimal idSelectedDelay;

	public KpiHeaderBacking() {
		selected = new KpiHeader();
	}

	public KpiHeaderModel getModel() {
		return model;
	}

	public void setModel(KpiHeaderModel model) {
		this.model = model;
	}

	public KpiHeaderDelayModel getModelHeaderDelay() {
		return modelHeaderDelay;
	}

	public void setModelHeaderDelay(KpiHeaderDelayModel modelConfig) {
		this.modelHeaderDelay = modelConfig;
	}

	public KpiHeader getSelected() {
		return selected;
	}

	public void setSelected(KpiHeader selected) {
		this.selected = selected;
	}

	public KpiHeaderDelay getSelectedHeaderDelay() {
		return selectedHeaderDelay;
	}

	public void setSelectedHeaderDelay(KpiHeaderDelay selectedHeaderDelay) {
		this.selectedHeaderDelay = selectedHeaderDelay;
	}

	public List<SelectItem> getListItemCompany() {
		if (listItemCompany == null) {
			mapKpiCompany = new HashMap<BigDecimal, KpiCompany>();
			listItemCompany = new ArrayList<SelectItem>();
			List<KpiCompany> list = tableService.getListKpiCompanyActive();

			SelectItem item = new SelectItem();
			item.setValue(Constant.defaultValue);
			item.setLabel(Constant.defaultLabel);
			listItemCompany.add(item);
			this.idSelectedCompany = new BigDecimal(-1);

			for (KpiCompany row : list) {
				item = new SelectItem();
				item.setValue(row.getId());
				item.setLabel(row.getName());

				listItemCompany.add(item);
				mapKpiCompany.put(row.getId(), row);
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

	public List<SelectItem> getListItemDelay() {
		return listItemDelay;
	}

	public void setListItemDelay(List<SelectItem> listItemDelay) {
		this.listItemDelay = listItemDelay;
	}

	public BigDecimal getIdSelectedDelay() {
		return idSelectedDelay;
	}

	public void setIdSelectedDelay(BigDecimal idSelectedDelay) {
		this.idSelectedDelay = idSelectedDelay;
	}

	public KpiHeaderDelay[] getListDelete() {
		return listDelete;
	}

	public void setListDelete(KpiHeaderDelay[] listDelete) {
		this.listDelete = listDelete;
	}

	public void newAction(ActionEvent event) {
		selected = new KpiHeader();
	}

	public void searchAction() {
		selected = new KpiHeader();
		modelHeaderDelay = new KpiHeaderDelayModel();
		if (this.idSelectedCompany.intValue() != -1) {
			model = new KpiHeaderModel(
					adminService
							.getListKpiHeaderByCompany(this.idSelectedCompany));
		} else {
			model = new KpiHeaderModel();
			listDeleteOld = null;
			listDelete = null;
			listNew = new ArrayList<KpiDelay>();
		}
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

			tableService.save(selected);
			message = FacesUtil.getMessage("msg_record_ok", selected.getName());
			model = new KpiHeaderModel(
					adminService
							.getListKpiHeaderByCompany(this.idSelectedCompany));
			FacesUtil.addInfo(message);
		}
	}

	public void deleteAction(ActionEvent event) {
		for (KpiHeaderDelay row : listDelete) {
			listHeaderDelay.remove(row);
		}
		modelHeaderDelay = new KpiHeaderDelayModel(listHeaderDelay);
		listDeleteOld = listDelete;
	}

	public void saveAllAction(ActionEvent event) {
		try {
			for (KpiHeaderDelay row : listDeleteOld) {
				adminService.remove(row);
			}

		} catch (NullPointerException ex) {

		}

		for (KpiDelay row : listNew) {
			KpiHeaderDelay object = new KpiHeaderDelay();
			object.setId(tableService.getId("KpiHeaderDelay"));
			object.setKpiHeader(this.selected);
			object.setKpiDelay(row);
			adminService.save(object);
		}

		String message = FacesUtil.getMessage("msg_record_ok",
				selected.getName());
		FacesUtil.addInfo(message);
	}

	public void onRowSelect(SelectEvent event) {
		BigDecimal idSelectedHeader = ((KpiHeader) event.getObject()).getId();
		listHeaderDelay = adminService
				.getListKpiConfigByHeader(idSelectedHeader);
		modelHeaderDelay = new KpiHeaderDelayModel(listHeaderDelay);
		listNew = new ArrayList<KpiDelay>();
	}

	public void addAction(ActionEvent event) {
		listItemDelay = new ArrayList<SelectItem>();
		mapKpiDelay = new HashMap<BigDecimal, KpiDelay>();
		for (KpiDelay row : tableService.getListKpiDelay()) {
			boolean sw = true;
			for (int i = 0; i < listHeaderDelay.size(); i++) {
				if (listHeaderDelay.get(i).getKpiDelay().getId().intValue() == row
						.getId().intValue()) {
					sw = false;
					break;
				}
			}

			if (sw) {
				SelectItem item = new SelectItem();
				item.setValue(row.getId());
				item.setLabel(row.getName());

				listItemDelay.add(item);
				mapKpiDelay.put(row.getId(), row);
			}
		}
	}

	public void addSaveAction(ActionEvent event) {
		listNew.add(mapKpiDelay.get(idSelectedDelay));
		KpiHeaderDelay object = new KpiHeaderDelay();
		object.setKpiDelay(mapKpiDelay.get(idSelectedDelay));
		listHeaderDelay.add(object);
		modelHeaderDelay = new KpiHeaderDelayModel(listHeaderDelay);
	}

}
