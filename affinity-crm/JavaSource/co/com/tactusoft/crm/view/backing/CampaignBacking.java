package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmCampaignMedication;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmRecall;
import co.com.tactusoft.crm.util.AjaxBehaviorCustom;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDataModel;
import co.com.tactusoft.crm.view.datamodel.CampaignMedicationlDataModel;

import com.tactusoft.webservice.client.beans.WSBean;

@Named
@Scope("view")
public class CampaignBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

	@Inject
	protected ParameterBo parameterService;

	protected List<CrmCampaign> list;
	protected CampaignDataModel model;

	protected CrmCampaign selected;
	protected CrmCampaign selectedNoAttendet;
	protected CrmCampaign selectedConfirmed;
	protected CrmCampaign selectedControl;
	protected CrmCampaign selectedMediaction;

	protected CrmCampaignDetail selectedDetailNoAttendet;
	protected CrmCampaignDetail selectedDetailConfirmed;
	protected CrmCampaignDetail selectedDetailControl;
	protected CrmCampaignDetail selectedDetailMediaction;

	protected List<CrmCampaignMedication> listDetailMedication;
	protected CampaignMedicationlDataModel modelDetailMedication;

	protected Map<String, String> mapText;
	protected CrmAppointment selectedAppointment;

	private Integer[] levelValuesNoAttendet;

	private List<CrmRecall> listAllLevelNoAttendet;

	private List<CrmRecall> levelsNoAttendet;

	private List<CrmRecall> listNoAttendet;
	private List<CrmRecall> listConfirmedControl;
	private List<CrmRecall> listControl;
	private List<CrmRecall> listMedication;

	private HtmlPanelGroup panelGroupNoAttendet;

	public CampaignBacking() {
		newAction();
	}

	@PostConstruct
	public void init() {
		List<CrmParameter> listParameter = parameterService
				.getListParameterByGroup("CAMPAIGN");
		mapText = new HashMap<String, String>();
		for (CrmParameter row : listParameter) {
			mapText.put(row.getCode(), row.getTextValue());
		}

		listAllLevelNoAttendet = tablesService
				.getListRecall(Constant.NO_ATTENDET);

		refreshList();
	}

	public List<CrmCampaign> getList() {
		return list;
	}

	public void setList(List<CrmCampaign> list) {
		this.list = list;
	}

	public CampaignDataModel getModel() {
		return model;
	}

	public void setModel(CampaignDataModel model) {
		this.model = model;
	}

	public CrmCampaign getSelectedNoAttendet() {
		return selectedNoAttendet;
	}

	public void setSelectedNoAttendet(CrmCampaign selectedNoAttendet) {
		this.selectedNoAttendet = selectedNoAttendet;
	}

	public CrmCampaign getSelectedConfirmed() {
		return selectedConfirmed;
	}

	public void setSelectedConfirmed(CrmCampaign selectedConfirmed) {
		this.selectedConfirmed = selectedConfirmed;
	}

	public CrmCampaign getSelectedControl() {
		return selectedControl;
	}

	public void setSelectedControl(CrmCampaign selectedControl) {
		this.selectedControl = selectedControl;
	}

	public CrmCampaign getSelectedMediaction() {
		return selectedMediaction;
	}

	public void setSelectedMediaction(CrmCampaign selectedMediaction) {
		this.selectedMediaction = selectedMediaction;
	}

	public CrmCampaignDetail getSelectedDetailNoAttendet() {
		return selectedDetailNoAttendet;
	}

	public void setSelectedDetailNoAttendet(
			CrmCampaignDetail selectedDetailNoAttendet) {
		this.selectedDetailNoAttendet = selectedDetailNoAttendet;
	}

	public CrmCampaignDetail getSelectedDetailConfirmed() {
		return selectedDetailConfirmed;
	}

	public void setSelectedDetailConfirmed(
			CrmCampaignDetail selectedDetailConfirmed) {
		this.selectedDetailConfirmed = selectedDetailConfirmed;
	}

	public CrmCampaignDetail getSelectedDetailControl() {
		return selectedDetailControl;
	}

	public void setSelectedDetailControl(CrmCampaignDetail selectedDetailControl) {
		this.selectedDetailControl = selectedDetailControl;
	}

	public CrmCampaignDetail getSelectedDetailMediaction() {
		return selectedDetailMediaction;
	}

	public void setSelectedDetailMediaction(
			CrmCampaignDetail selectedDetailMediaction) {
		this.selectedDetailMediaction = selectedDetailMediaction;
	}

	public List<CrmCampaignMedication> getListDetailMedication() {
		return listDetailMedication;
	}

	public void setListDetailMedication(
			List<CrmCampaignMedication> listDetailMedication) {
		this.listDetailMedication = listDetailMedication;
	}

	public CampaignMedicationlDataModel getModelDetailMedication() {
		return modelDetailMedication;
	}

	public void setModelDetailMedication(
			CampaignMedicationlDataModel modelDetailMedication) {
		this.modelDetailMedication = modelDetailMedication;
	}

	public Map<String, String> getMapText() {
		return mapText;
	}

	public void setMapText(Map<String, String> mapText) {
		this.mapText = mapText;
	}

	public CrmAppointment getSelectedAppointment() {
		return selectedAppointment;
	}

	public void setSelectedAppointment(CrmAppointment selectedAppointment) {
		this.selectedAppointment = selectedAppointment;
	}

	public CrmCampaign getSelected() {
		return selected;
	}

	public void setSelected(CrmCampaign selected) {
		this.selected = selected;
	}

	public Integer[] getLevelValuesNoAttendet() {
		return levelValuesNoAttendet;
	}

	public void setLevelValuesNoAttendet(Integer[] levelValuesNoAttendet) {
		this.levelValuesNoAttendet = levelValuesNoAttendet;
	}

	public List<CrmRecall> getLevelsNoAttendet() {
		if (levelsNoAttendet == null) {
			levelsNoAttendet = tablesService.getLevels(Constant.NO_ATTENDET);
		}
		return levelsNoAttendet;
	}

	public void setLevelsNoAttendet(List<CrmRecall> levelsNoAttendet) {
		this.levelsNoAttendet = levelsNoAttendet;
	}

	public List<SelectItem> getItemsLevel(Long type, Long level,
			CrmRecall parent) {
		List<SelectItem> itemsLevel = new ArrayList<SelectItem>();
		String label = FacesUtil.getMessage(Constant.DEFAULT_LABEL);
		itemsLevel
				.add(new SelectItem(Constant.DEFAULT_VALUE.intValue(), label));
		levelValuesNoAttendet[level.intValue()] = Constant.DEFAULT_VALUE
				.intValue();

		if (type == Constant.NO_ATTENDET) {
			List<CrmRecall> listAllLevel = this.getListNoAttendet();
			for (CrmRecall recall : listAllLevel) {
				if (parent == null && level == 0) {
					if (recall.getCrmRecall() == null) {
						itemsLevel.add(new SelectItem(recall.getId(), recall
								.getDescription()));
					}
				} else {
					if (parent != null
							&& recall.getCrmRecall().getId() == parent
									.getCrmRecall().getId()) {
						itemsLevel.add(new SelectItem(recall.getId(), recall
								.getDescription()));
					}
				}
			}
		}
		return itemsLevel;
	}

	public List<CrmRecall> getListNoAttendet() {
		if (listNoAttendet == null) {
			listNoAttendet = tablesService.getListRecall(Constant.NO_ATTENDET);
		}
		return listNoAttendet;
	}

	public void setListNoAttendet(List<CrmRecall> listNoAttendet) {
		this.listNoAttendet = listNoAttendet;
	}

	public List<CrmRecall> getListConfirmedControl() {
		return listConfirmedControl;
	}

	public void setListConfirmedControl(List<CrmRecall> listConfirmedControl) {
		this.listConfirmedControl = listConfirmedControl;
	}

	public List<CrmRecall> getListControl() {
		return listControl;
	}

	public void setListControl(List<CrmRecall> listControl) {
		this.listControl = listControl;
	}

	public List<CrmRecall> getListMedication() {
		return listMedication;
	}

	public void setListMedication(List<CrmRecall> listMedication) {
		this.listMedication = listMedication;
	}

	public HtmlPanelGroup getPanelGroupNoAttendet() {
		if (panelGroupNoAttendet == null) {
			getLevelsNoAttendet();
			levelValuesNoAttendet = new Integer[levelsNoAttendet.size()];
			panelGroupNoAttendet = createPanelGroup(Constant.NO_ATTENDET);
		}
		return panelGroupNoAttendet;
	}

	public void setPanelGroupNoAttendet(HtmlPanelGroup panelGroupNoAttendet) {
		this.panelGroupNoAttendet = panelGroupNoAttendet;
	}

	protected void refreshList() {
		List<CrmCampaign> listTemp = tablesService.getListCampaignNoAttendet();
		if (listTemp.size() > 0) {
			selectedNoAttendet = listTemp.get(0);
		} else {
			selectedNoAttendet = null;
		}

		listTemp = tablesService.getListCampaignConfirmed();
		if (listTemp.size() > 0) {
			selectedConfirmed = listTemp.get(0);
		} else {
			selectedConfirmed = null;
		}

		listTemp = tablesService.getListCampaignControl();
		if (listTemp.size() > 0) {
			selectedControl = listTemp.get(0);
		} else {
			selectedControl = null;
		}

		listTemp = tablesService.getListCampaignMedication();
		if (listTemp.size() > 0) {
			selectedMediaction = listTemp.get(0);
		} else {
			selectedMediaction = null;
		}
	}

	public void newAction() {
		selectedConfirmed = null;
		selectedControl = null;
		selectedMediaction = null;
		selectedNoAttendet = null;
	}

	public void generateDetailNoAttendet() {
		selected = selectedNoAttendet;
		generateDetail();
	}

	public void generateDetailConfirmed() {
		selected = selectedConfirmed;
		generateDetail();
	}

	public void generateDetailMedication() {
		selected = selectedMediaction;
		generateDetail();
	}

	public void generateDetailControl() {
		selected = selectedControl;
		generateDetail();
	}

	public void generateDetail() {
		selectedDetailNoAttendet = null;
		selectedDetailConfirmed = null;
		selectedDetailControl = null;
		selectedDetailMediaction = null;

		List<CrmCampaignDetail> listDetail = selected.getCrmCampaignDetails();
		for (CrmCampaignDetail row : listDetail) {
			if (row.getCampaignType() == Constant.NO_ATTENDET) {
				selectedDetailNoAttendet = row;
			} else if (row.getCampaignType() == Constant.CONFIRMED) {
				selectedDetailConfirmed = row;
			} else if (row.getCampaignType() == Constant.CONTROL) {
				selectedDetailControl = row;
			} else if (row.getCampaignType() == Constant.MEDICATION) {
				selectedDetailMediaction = row;
			}
		}

		if (selectedDetailMediaction != null) {
			listDetailMedication = tablesService
					.getListCampaignMedication(selected.getId());
		} else {
			listDetailMedication = new ArrayList<CrmCampaignMedication>();
		}

		modelDetailMedication = new CampaignMedicationlDataModel(
				listDetailMedication);
	}

	public boolean isRenderedMedication() {
		return listDetailMedication != null && listDetailMedication.size() > 0;
	}

	public String getDescCampaignType(int typeCampaign) {
		return typeCampaign == Constant.NO_ATTENDET ? "No asistió a la cita"
				: typeCampaign == Constant.CONFIRMED ? "Confirmar la cita"
						: typeCampaign == Constant.CONTROL ? "No ha asistido a control"
								: "Medicamentos NO adquiridos";
	}

	public String getText(String typeCampaign) {
		return mapText.get(typeCampaign);
	}

	public String getDocType(String country, String code) {
		for (WSBean row : FacesUtil.getCurrentUserData().getListWSDocType()) {
			if (row.getNames().contains(country) && row.getCode().equals(code)) {
				return row.getNames();
			}
		}
		return "Tipo de Identificación Desconocida";
	}

	public String editAppoinmnetAction() {
		AppointmentBacking appointmentEditBacking = FacesUtil
				.findBean("appointmentBacking");

		appointmentEditBacking.newAction(null);
		appointmentEditBacking.setSelected(selectedAppointment);
		appointmentEditBacking.setSelectedPatient(selectedAppointment
				.getCrmPatient());
		appointmentEditBacking.setCurrentDate(selectedAppointment
				.getStartAppointmentDate());
		appointmentEditBacking.setIdBranch(selectedAppointment.getCrmBranch()
				.getId());
		appointmentEditBacking.handleBranchChange();
		appointmentEditBacking.setIdProcedureDetail(selectedAppointment
				.getCrmProcedureDetail().getId());
		appointmentEditBacking.handleProcedureDetailChange();
		appointmentEditBacking.setSelectedWSGroupSellers(selectedAppointment
				.getCodPublicity());
		appointmentEditBacking.setEdit(true);
		appointmentEditBacking.setSaved(false);
		appointmentEditBacking.setFromPage("CAMPAIGN");
		for (SelectItem item : appointmentEditBacking.getListBranch()) {
			long value = ((BigDecimal) item.getValue()).longValue();
			if (value == selectedAppointment.getCrmBranch().getId().longValue()) {
				appointmentEditBacking.setSaved(false);
				break;
			}
		}
		appointmentEditBacking.setIdBranch(selectedAppointment.getCrmBranch()
				.getId());

		return "/pages/processes/appointmentEdit.jsf?faces-redirect=true";
	}

	public void saveAction() {
		String message = null;
		selected.setState(1);
		int result = tablesService.saveCampaign(selected);
		if (selectedDetailConfirmed != null) {
			tablesService.saveCampaignDetail(selectedDetailConfirmed);
		}
		if (selectedDetailControl != null) {
			tablesService.saveCampaignDetail(selectedDetailControl);
		}
		if (selectedDetailMediaction != null) {
			tablesService.saveCampaignDetail(selectedDetailMediaction);
		}
		if (selectedDetailNoAttendet != null) {
			tablesService.saveCampaignDetail(selectedDetailNoAttendet);
		}
		if (result == 0) {
			refreshList();
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		} else if (result == -1) {
			String paramValue = FacesUtil.getMessage("doc_code");
			message = FacesUtil.getMessage("msg_record_unique_exception",
					paramValue);
			FacesUtil.addError(message);
		}
	}

	public HtmlPanelGroup createPanelGroup(int type) {
		Application application = FacesUtil.getApplication();
		ELContext eLContext = FacesContext.getCurrentInstance().getELContext();
		ExpressionFactory expressionFactory = application
				.getExpressionFactory();
		HtmlPanelGroup result = (HtmlPanelGroup) application
				.createComponent(HtmlPanelGroup.COMPONENT_TYPE);

		List<CrmRecall> listLevel = new ArrayList<CrmRecall>();
		for (CrmRecall row : listAllLevelNoAttendet) {
			if (row.getCrmRecall() == null) {
				listLevel.add(row);
			}
		}

		PanelGrid panelGrid = (PanelGrid) application
				.createComponent(PanelGrid.COMPONENT_TYPE);
		panelGrid.setId("pnl_" + type);
		HtmlOutputText title = (HtmlOutputText) application
				.createComponent(HtmlOutputText.COMPONENT_TYPE);
		title.setValue("Respuestas");
		panelGrid.getFacets().put("header", title);
		panelGrid.setStyle("width:100%");
		panelGrid.setColumns(2);
		result.getChildren().add(panelGrid);

		for (int index = 0; index < levelValuesNoAttendet.length; index++) {
			HtmlOutputText text = (HtmlOutputText) application
					.createComponent(HtmlOutputText.COMPONENT_TYPE);
			text.setId("outLevel_" + type + "_" + index);
			text.setValue("Nivel " + (index + 1));
			panelGrid.getChildren().add(text);

			SelectOneMenu selectOneMenu = (SelectOneMenu) application
					.createComponent(SelectOneMenu.COMPONENT_TYPE);
			selectOneMenu.setId("somLevel_" + type + "_" + index);
			selectOneMenu.setStyle("width: 350px;");
			selectOneMenu.setSubmittedValue(Constant.DEFAULT_VALUE.intValue());

			List<SelectItem> listItem = new ArrayList<SelectItem>();
			listItem.add(new SelectItem(Constant.DEFAULT_VALUE.intValue(),
					FacesUtil.getMessage(Constant.DEFAULT_LABEL)));
			if (index == 0) {
				for (CrmRecall row : listLevel) {
					SelectItem selectItem = new SelectItem(row.getId(),
							row.getDescription());
					listItem.add(selectItem);
				}
			} else {
				selectOneMenu.setDisabled(true);
			}

			List<UIComponent> menuChildren = selectOneMenu.getChildren();
			UISelectItems items = (UISelectItems) application
					.createComponent(UISelectItems.COMPONENT_TYPE);
			items.setValue(listItem);
			menuChildren.add(items);
			selectOneMenu.getChildren().addAll(menuChildren);

			if (index < levelValuesNoAttendet.length - 1) {
				MethodExpression methodExpression = FacesUtil
						.createMethodExpression(
								"#{campaignBacking.levelValueChangeEvent("
										+ type + "," + index + ")}", null,
								new Class[] { Long.class, Long.class });
				AjaxBehaviorCustom pajax = new AjaxBehaviorCustom();
				pajax.setUpdate(":editForm:" + panelGrid.getId());
				// pajax.setProcess("@all");
				pajax.setListener(methodExpression);
				selectOneMenu.addClientBehavior("change", pajax);
			}

			ValueExpression valueExpression = expressionFactory
					.createValueExpression(eLContext,
							"#{campaignBacking.levelValuesNoAttendet[" + index
									+ "]}", Integer.class);
			selectOneMenu.setValueExpression("value", valueExpression);

			panelGrid.getChildren().add(selectOneMenu);
		}

		return result;
	}

	public void levelValueChangeEvent(Long type, Long level) {
		List<SelectItem> listItem = new ArrayList<SelectItem>();
		listItem.add(new SelectItem(Constant.DEFAULT_VALUE.intValue(),
				FacesUtil.getMessage(Constant.DEFAULT_LABEL)));

		SelectOneMenu selectOneMenu = (SelectOneMenu) FacesContext
				.getCurrentInstance()
				.getViewRoot()
				.findComponent(":editForm:somLevel_" + type + "_" + (level + 1));

		
		Integer value = -1;
		
		if (selectOneMenu != null) {
			if (type.intValue() == Constant.NO_ATTENDET) {
				value = levelValuesNoAttendet[level.intValue()];
				if (value != Constant.DEFAULT_VALUE.intValue()) {
					for (CrmRecall row : listAllLevelNoAttendet) {
						if (row.getCrmRecall() != null
								&& row.getCrmRecall().getId() == value) {
							SelectItem selectItem = new SelectItem(row.getId(),
									row.getDescription());
							listItem.add(selectItem);
						}
					}
				}

				if (listItem.size() > 1) {
					selectOneMenu.setDisabled(false);
				} else {
					selectOneMenu.setDisabled(true);
				}

				selectOneMenu.getChildren().clear();
				selectOneMenu.getChildren().addAll(getUIComponent(listItem));
				/*selectOneMenu.setSubmittedValue(Constant.DEFAULT_VALUE
						.intValue());*/
			}
		}
		
		SelectOneMenu parentSelectOneMenu = (SelectOneMenu) FacesContext
				.getCurrentInstance()
				.getViewRoot()
				.findComponent(":editForm:somLevel_" + type + "_" + level);
		parentSelectOneMenu.setValue(value);
	}

	private List<UIComponent> getUIComponent(List<SelectItem> listItem) {
		Application application = FacesUtil.getApplication();
		List<UIComponent> menuChildren = new ArrayList<UIComponent>();
		UISelectItems items = (UISelectItems) application
				.createComponent(UISelectItems.COMPONENT_TYPE);
		items.setValue(listItem);
		menuChildren.add(items);
		return menuChildren;
	}
}
