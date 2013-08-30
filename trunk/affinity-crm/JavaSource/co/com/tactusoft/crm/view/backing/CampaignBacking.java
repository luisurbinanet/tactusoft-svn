package co.com.tactusoft.crm.view.backing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import org.asteriskjava.live.CallerId;
import org.asteriskjava.live.ManagerCommunicationException;
import org.asteriskjava.live.NoSuchChannelException;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.AstTrunkDialpatterns;
import co.com.tactusoft.crm.model.entities.CrmAppointment;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;
import co.com.tactusoft.crm.model.entities.CrmCampaignMedication;
import co.com.tactusoft.crm.model.entities.CrmCampaignTask;
import co.com.tactusoft.crm.model.entities.CrmParameter;
import co.com.tactusoft.crm.model.entities.CrmRecall;
import co.com.tactusoft.crm.model.entities.VwCallRange;
import co.com.tactusoft.crm.util.AjaxBehaviorCustom;
import co.com.tactusoft.crm.util.Asterisk;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;
import co.com.tactusoft.crm.view.datamodel.CampaignDataModel;
import co.com.tactusoft.crm.view.datamodel.CampaignMedicationlDataModel;

import com.tactusoft.webservice.client.beans.WSBean;

@Named
@Scope("view")
public class CampaignBacking extends BaseBacking {

	private static final long serialVersionUID = 1L;

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
	private Integer[] levelValuesConfirmed;
	private Integer[] levelValuesControl;
	private Integer[] levelValuesMedication;

	private List<CrmRecall> listAllLevelNoAttendet;
	private List<CrmRecall> listAllLevelConfirmed;
	private List<CrmRecall> listAllLevelControl;
	private List<CrmRecall> listAllLevelMedication;

	private List<CrmRecall> levelsNoAttendet;
	private List<CrmRecall> levelsConfirmed;
	private List<CrmRecall> levelsControl;
	private List<CrmRecall> levelsMedication;

	private List<CrmRecall> listNoAttendet;
	private List<CrmRecall> listConfirmed;
	private List<CrmRecall> listControl;
	private List<CrmRecall> listMedication;

	private HtmlPanelGroup panelGroupNoAttendet;
	private HtmlPanelGroup panelGroupConfirmed;
	private HtmlPanelGroup panelGroupControl;
	private HtmlPanelGroup panelGroupMedication;

	private Map<Integer, CrmRecall> mapNoAttendet;
	private Map<Integer, CrmRecall> mapConfirmed;
	private Map<Integer, CrmRecall> mapControl;
	private Map<Integer, CrmRecall> mapMedication;

	private String[] task = new String[4];
	private CrmRecall[] selectedCrmRecall = new CrmRecall[4];
	private Date[] selectedDates = new Date[4];

	private Integer phoneType;
	private String indicative;

	private List<VwCallRange> listCallRange;
	private List<AstTrunkDialpatterns> listDialpatterns;
	private String remoteChannel;
	private String idCall;
	private String agentNumber;

	private String asteriskHost;
	private int asteriskPort;
	private String asteriskUser;
	private String asteriskPassword;
	private boolean called;
	private String phone;

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
				.getListRecall(Constant.RECALL_NO_ATTENDET);
		mapNoAttendet = new HashMap<Integer, CrmRecall>();
		for (CrmRecall row : listAllLevelNoAttendet) {
			mapNoAttendet.put(row.getId(), row);
		}

		listAllLevelConfirmed = tablesService
				.getListRecall(Constant.RECALL_CONFIRMED);
		mapConfirmed = new HashMap<Integer, CrmRecall>();
		for (CrmRecall row : listAllLevelConfirmed) {
			mapConfirmed.put(row.getId(), row);
		}

		listAllLevelControl = tablesService
				.getListRecall(Constant.RECALL_CONTROL);
		mapControl = new HashMap<Integer, CrmRecall>();
		for (CrmRecall row : listAllLevelControl) {
			mapControl.put(row.getId(), row);
		}

		listAllLevelMedication = tablesService
				.getListRecall(Constant.RECALL_MEDICATION);
		mapMedication = new HashMap<Integer, CrmRecall>();
		for (CrmRecall row : listAllLevelMedication) {
			mapMedication.put(row.getId(), row);
		}

		listCallRange = tablesService.getVwCallRange();
		listDialpatterns = tablesService.getListDialpatterns();
		List<CrmParameter> listParameterAterisk = parameterService
				.getListParameterByGroup("ASTERISK");
		for (CrmParameter crmParameter : listParameterAterisk) {
			if (crmParameter.getCode().equals("ASTERISK_HOST")) {
				asteriskHost = crmParameter.getTextValue();
			} else if (crmParameter.getCode().equals("ASTERISK_PORT")) {
				asteriskPort = Integer.parseInt(crmParameter.getTextValue());
			} else if (crmParameter.getCode().equals("ASTERISK_USER")) {
				asteriskUser = crmParameter.getTextValue();
			} else if (crmParameter.getCode().equals("ASTERISK_PASSWORD")) {
				asteriskPassword = crmParameter.getTextValue();
			}
		}
		agentNumber = FacesUtil.getCurrentUser().getExtensionAgent();

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

	public Integer[] getLevelValuesConfirmed() {
		return levelValuesConfirmed;
	}

	public void setLevelValuesConfirmed(Integer[] levelValuesConfirmed) {
		this.levelValuesConfirmed = levelValuesConfirmed;
	}

	public Integer[] getLevelValuesControl() {
		return levelValuesControl;
	}

	public void setLevelValuesControl(Integer[] levelValuesControl) {
		this.levelValuesControl = levelValuesControl;
	}

	public Integer[] getLevelValuesMedication() {
		return levelValuesMedication;
	}

	public void setLevelValuesMedication(Integer[] levelValuesMedication) {
		this.levelValuesMedication = levelValuesMedication;
	}

	public List<CrmRecall> getLevelsNoAttendet() {
		if (levelsNoAttendet == null) {
			levelsNoAttendet = tablesService
					.getLevels(Constant.RECALL_NO_ATTENDET);
		}
		return levelsNoAttendet;
	}

	public void setLevelsNoAttendet(List<CrmRecall> levelsNoAttendet) {
		this.levelsNoAttendet = levelsNoAttendet;
	}

	public List<CrmRecall> getLevelsConfirmed() {
		if (levelsConfirmed == null) {
			levelsConfirmed = tablesService
					.getLevels(Constant.RECALL_CONFIRMED);
		}
		return levelsConfirmed;
	}

	public void setLevelsConfirmed(List<CrmRecall> levelsConfirmed) {
		this.levelsConfirmed = levelsConfirmed;
	}

	public List<CrmRecall> getLevelsControl() {
		if (levelsControl == null) {
			levelsControl = tablesService.getLevels(Constant.RECALL_CONTROL);
		}
		return levelsControl;
	}

	public void setLevelsControl(List<CrmRecall> levelsControl) {
		this.levelsControl = levelsControl;
	}

	public List<CrmRecall> getLevelsMedication() {
		if (levelsMedication == null) {
			levelsMedication = tablesService
					.getLevels(Constant.RECALL_MEDICATION);
		}
		return levelsMedication;
	}

	public void setLevelsMedication(List<CrmRecall> levelsMedication) {
		this.levelsMedication = levelsMedication;
	}

	public List<CrmRecall> getListNoAttendet() {
		if (listNoAttendet == null) {
			listNoAttendet = tablesService
					.getListRecall(Constant.RECALL_NO_ATTENDET);
		}
		return listNoAttendet;
	}

	public void setListNoAttendet(List<CrmRecall> listNoAttendet) {
		this.listNoAttendet = listNoAttendet;
	}

	public List<CrmRecall> getListConfirmed() {
		return listConfirmed;
	}

	public void setListConfirmed(List<CrmRecall> listConfirmed) {
		this.listConfirmed = listConfirmed;
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
			panelGroupNoAttendet = createPanelGroup(
					Constant.RECALL_NO_ATTENDET, listAllLevelNoAttendet,
					levelValuesNoAttendet);
		}
		return panelGroupNoAttendet;
	}

	public void setPanelGroupNoAttendet(HtmlPanelGroup panelGroupNoAttendet) {
		this.panelGroupNoAttendet = panelGroupNoAttendet;
	}

	public HtmlPanelGroup getPanelGroupConfirmed() {
		if (panelGroupConfirmed == null) {
			getLevelsConfirmed();
			levelValuesConfirmed = new Integer[levelsConfirmed.size()];
			panelGroupConfirmed = createPanelGroup(Constant.RECALL_CONFIRMED,
					listAllLevelConfirmed, levelValuesConfirmed);
		}
		return panelGroupConfirmed;
	}

	public void setPanelGroupConfirmed(HtmlPanelGroup panelGroupConfirmed) {
		this.panelGroupConfirmed = panelGroupConfirmed;
	}

	public HtmlPanelGroup getPanelGroupControl() {
		if (panelGroupControl == null) {
			getLevelsControl();
			levelValuesControl = new Integer[levelsControl.size()];
			panelGroupControl = createPanelGroup(Constant.RECALL_CONTROL,
					listAllLevelControl, levelValuesControl);
		}
		return panelGroupControl;
	}

	public void setPanelGroupControl(HtmlPanelGroup panelGroupControl) {
		this.panelGroupControl = panelGroupControl;
	}

	public HtmlPanelGroup getPanelGroupMedication() {
		if (panelGroupMedication == null) {
			getLevelsMedication();
			levelValuesMedication = new Integer[levelsMedication.size()];
			panelGroupMedication = createPanelGroup(Constant.RECALL_MEDICATION,
					listAllLevelMedication, levelValuesMedication);
		}
		return panelGroupMedication;
	}

	public void setPanelGroupMedication(HtmlPanelGroup panelGroupMedication) {
		this.panelGroupMedication = panelGroupMedication;
	}

	public String[] getTask() {
		return task;
	}

	public void setTask(String[] task) {
		this.task = task;
	}

	public CrmRecall[] getSelectedCrmRecall() {
		return selectedCrmRecall;
	}

	public void setSelectedCrmRecall(CrmRecall[] selectedCrmRecall) {
		this.selectedCrmRecall = selectedCrmRecall;
	}

	public Date[] getSelectedDates() {
		return selectedDates;
	}

	public void setSelectedDates(Date[] selectedDates) {
		this.selectedDates = selectedDates;
	}

	public Integer getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(Integer phoneType) {
		this.phoneType = phoneType;
	}

	public String getIndicative() {
		return indicative;
	}

	public void setIndicative(String indicative) {
		this.indicative = indicative;
	}

	public boolean isCalled() {
		return called;
	}

	public void setCalled(boolean called) {
		this.called = called;
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
		if (levelValuesNoAttendet != null) {
			for (int index = 0; index < levelValuesNoAttendet.length; index++) {
				levelValuesNoAttendet[index] = Constant.DEFAULT_VALUE
						.intValue();
			}
			levelValueChangeEvent((long) Constant.RECALL_NO_ATTENDET, 0L);
		}

		if (levelValuesConfirmed != null) {
			for (int index = 0; index < levelValuesConfirmed.length; index++) {
				levelValuesConfirmed[index] = Constant.DEFAULT_VALUE.intValue();
			}
			levelValueChangeEvent((long) Constant.RECALL_CONFIRMED, 0L);
		}

		if (levelValuesControl != null) {
			for (int index = 0; index < levelValuesControl.length; index++) {
				levelValuesControl[index] = Constant.DEFAULT_VALUE.intValue();
			}
			levelValueChangeEvent((long) Constant.RECALL_CONTROL, 0L);
		}

		if (levelValuesMedication != null) {
			for (int index = 0; index < levelValuesMedication.length; index++) {
				levelValuesMedication[index] = Constant.DEFAULT_VALUE
						.intValue();
			}
			levelValueChangeEvent((long) Constant.RECALL_MEDICATION, 0L);
		}

		selectedDetailNoAttendet = null;
		selectedDetailConfirmed = null;
		selectedDetailControl = null;
		selectedDetailMediaction = null;

		List<CrmCampaignDetail> listDetail = selected.getCrmCampaignDetails();
		for (CrmCampaignDetail row : listDetail) {
			if (row.getIdCampaignType() == Constant.RECALL_NO_ATTENDET) {
				selectedDetailNoAttendet = row;
			} else if (row.getIdCampaignType() == Constant.RECALL_CONFIRMED) {
				selectedDetailConfirmed = row;
			} else if (row.getIdCampaignType() == Constant.RECALL_CONTROL) {
				selectedDetailControl = row;
			} else if (row.getIdCampaignType() == Constant.RECALL_MEDICATION) {
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

		phoneType = 1;
		if (FacesUtil.isEmptyOrBlank(selected.getCrmPatient().getPhoneNumber())) {
			phoneType = 2;
		}

		phone = null;
		indicative = null;
		called = false;
	}

	public boolean isRenderedMedication() {
		return listDetailMedication != null && listDetailMedication.size() > 0;
	}

	public String getDescCampaignType(int typeCampaign) {
		return typeCampaign == Constant.RECALL_NO_ATTENDET ? "No asistió a la cita"
				: typeCampaign == Constant.RECALL_CONFIRMED ? "Confirmar la cita"
						: typeCampaign == Constant.RECALL_CONTROL ? "No ha asistido a control"
								: "Medicamentos NO adquiridos";
	}

	public String getText(String typeCampaign) {
		return mapText.get(typeCampaign);
	}

	public String getDocType() {
		if (this.selected != null) {
			for (WSBean row : FacesUtil.getCurrentUserData().getListWSDocType()) {
				if (row.getCode().equals(
						this.selected.getCrmPatient().getDocType())) {
					return row.getNames();
				}
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

	public HtmlPanelGroup createPanelGroup(int type,
			List<CrmRecall> listAllLevel, Integer[] levelValues) {
		Application application = FacesUtil.getApplication();
		ELContext eLContext = FacesContext.getCurrentInstance().getELContext();
		ExpressionFactory expressionFactory = application
				.getExpressionFactory();
		HtmlPanelGroup result = (HtmlPanelGroup) application
				.createComponent(HtmlPanelGroup.COMPONENT_TYPE);

		List<CrmRecall> listLevel = new ArrayList<CrmRecall>();
		for (CrmRecall row : listAllLevel) {
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

		for (int index = 0; index < levelValues.length; index++) {
			HtmlOutputText text = (HtmlOutputText) application
					.createComponent(HtmlOutputText.COMPONENT_TYPE);
			text.setId("outLevel_" + type + "_" + index);
			text.setValue("Nivel " + (index + 1));
			panelGrid.getChildren().add(text);

			SelectOneMenu selectOneMenu = (SelectOneMenu) application
					.createComponent(SelectOneMenu.COMPONENT_TYPE);
			selectOneMenu.setId("somLevel_" + type + "_" + index);
			selectOneMenu.setStyle("width: 350px;");
			selectOneMenu.setValue(Constant.DEFAULT_VALUE.intValue());

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

			MethodExpression methodExpression = FacesUtil
					.createMethodExpression(
							"#{campaignBacking.levelValueChangeEvent(" + type
									+ "," + index + ")}", null, new Class[] {
									Long.class, Long.class });
			AjaxBehaviorCustom pajax = new AjaxBehaviorCustom();
			pajax.setUpdate(":editForm:pnlTask_" + type + " :editForm:"
					+ panelGrid.getId());
			// pajax.setProcess("@all");
			pajax.setListener(methodExpression);
			selectOneMenu.addClientBehavior("change", pajax);

			String expression = null;
			if (type == Constant.RECALL_NO_ATTENDET) {
				expression = "#{campaignBacking.levelValuesNoAttendet[" + index
						+ "]}";
			} else if (type == Constant.RECALL_CONFIRMED) {
				expression = "#{campaignBacking.levelValuesConfirmed[" + index
						+ "]}";
			} else if (type == Constant.RECALL_CONTROL) {
				expression = "#{campaignBacking.levelValuesControl[" + index
						+ "]}";
			} else {
				expression = "#{campaignBacking.levelValuesMedication[" + index
						+ "]}";
			}

			ValueExpression valueExpression = expressionFactory
					.createValueExpression(eLContext, expression, Integer.class);
			selectOneMenu.setValueExpression("value", valueExpression);

			panelGrid.getChildren().add(selectOneMenu);
		}

		return result;
	}

	private void refreshLevels(int type, int level, int value,
			List<CrmRecall> listAllLevel) {
		List<SelectItem> listItem = new ArrayList<SelectItem>();
		listItem.add(new SelectItem(Constant.DEFAULT_VALUE.intValue(),
				FacesUtil.getMessage(Constant.DEFAULT_LABEL)));

		String idComponent = ":editForm:somLevel_" + type + "_" + (level + 1);

		SelectOneMenu selectOneMenu = (SelectOneMenu) FacesContext
				.getCurrentInstance().getViewRoot().findComponent(idComponent);
		if (selectOneMenu != null) {
			if (value != Constant.DEFAULT_VALUE.intValue()) {
				for (CrmRecall row : listAllLevel) {
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
		}
	}

	public void levelValueChangeEvent(Long type, Long level) {
		Integer value = -1;
		Integer[] levelValues;

		if (type.intValue() == Constant.RECALL_NO_ATTENDET) {
			levelValues = new Integer[levelValuesNoAttendet.length];
			value = levelValuesNoAttendet[level.intValue()];
			refreshLevels(type.intValue(), level.intValue(), value,
					listAllLevelNoAttendet);
			try {
				levelValuesNoAttendet[level.intValue() + 1] = Constant.DEFAULT_VALUE
						.intValue();
			} catch (Exception ex) {

			}
			if (value != Constant.DEFAULT_VALUE.intValue()) {
				selectedCrmRecall[0] = mapNoAttendet.get(value);
				task[0] = selectedCrmRecall[0].getTask();
			} else {
				selectedCrmRecall[0] = null;
				task[0] = null;
			}
		} else if (type == Constant.RECALL_CONFIRMED) {
			levelValues = new Integer[levelValuesConfirmed.length];
			value = levelValuesConfirmed[level.intValue()];
			refreshLevels(type.intValue(), level.intValue(), value,
					listAllLevelConfirmed);
			try {
				levelValuesConfirmed[level.intValue() + 1] = Constant.DEFAULT_VALUE
						.intValue();
			} catch (Exception ex) {

			}
			if (value != Constant.DEFAULT_VALUE.intValue()) {
				selectedCrmRecall[1] = mapConfirmed.get(value);
				task[1] = selectedCrmRecall[1].getTask();
			} else {
				selectedCrmRecall[1] = null;
				task[1] = null;
			}
		} else if (type == Constant.RECALL_CONTROL) {
			levelValues = new Integer[levelValuesControl.length];
			value = levelValuesControl[level.intValue()];
			refreshLevels(type.intValue(), level.intValue(), value,
					listAllLevelControl);
			try {
				levelValuesControl[level.intValue() + 1] = Constant.DEFAULT_VALUE
						.intValue();
			} catch (Exception ex) {

			}
			if (value != Constant.DEFAULT_VALUE.intValue()) {
				selectedCrmRecall[2] = mapControl.get(value);
				task[2] = selectedCrmRecall[2].getTask();
			} else {
				selectedCrmRecall[2] = null;
				task[2] = null;
			}
		} else {
			levelValues = new Integer[levelValuesMedication.length];
			value = levelValuesMedication[level.intValue()];
			refreshLevels(type.intValue(), level.intValue(), value,
					listAllLevelMedication);
			try {
				levelValuesMedication[level.intValue() + 1] = Constant.DEFAULT_VALUE
						.intValue();
			} catch (Exception ex) {

			}
			if (value != Constant.DEFAULT_VALUE.intValue()) {
				selectedCrmRecall[3] = mapMedication.get(value);
				task[3] = selectedCrmRecall[3].getTask();
			} else {
				selectedCrmRecall[3] = null;
				task[3] = null;
			}
		}

		List<SelectItem> listItem = new ArrayList<SelectItem>();
		listItem.add(new SelectItem(Constant.DEFAULT_VALUE.intValue(),
				FacesUtil.getMessage(Constant.DEFAULT_LABEL)));

		for (int index = level.intValue() + 2; index < levelValues.length; index++) {
			if (type.intValue() == Constant.RECALL_NO_ATTENDET) {
				levelValuesNoAttendet[index] = Constant.DEFAULT_VALUE
						.intValue();
			} else if (type == Constant.RECALL_CONFIRMED) {
				levelValuesConfirmed[index] = Constant.DEFAULT_VALUE.intValue();
			} else if (type == Constant.RECALL_CONTROL) {
				levelValuesControl[index] = Constant.DEFAULT_VALUE.intValue();
			} else {
				levelValuesMedication[index] = Constant.DEFAULT_VALUE
						.intValue();
			}
			String idComponent = ":editForm:somLevel_" + type + "_" + index;
			SelectOneMenu selectOneMenu = (SelectOneMenu) FacesContext
					.getCurrentInstance().getViewRoot()
					.findComponent(idComponent);
			selectOneMenu.getChildren().clear();
			selectOneMenu.getChildren().addAll(getUIComponent(listItem));
			selectOneMenu.setDisabled(true);
		}
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

	private int getLevels(int type, Integer[] levelValues) {
		int count = 0;

		for (int index = 0; index < levelValues.length; index++) {
			String idComponent = ":editForm:somLevel_" + type + "_" + index;
			SelectOneMenu selectOneMenu = (SelectOneMenu) FacesContext
					.getCurrentInstance().getViewRoot()
					.findComponent(idComponent);
			int size = selectOneMenu.getChildren().size();
			UISelectItems uiSelectItems = (UISelectItems) selectOneMenu
					.getChildren().get(size - 1);
			@SuppressWarnings("unchecked")
			List<SelectItem> items = (List<SelectItem>) uiSelectItems
					.getValue();
			if (items.size() > 1) {
				count++;
			}
		}
		return count - 1;
	}

	private void generateNewCampaign(CrmCampaignDetail crmCampaignDetail,
			Integer value, int type) {
		CrmRecall crmRecall = null;

		if (type == Constant.RECALL_NO_ATTENDET) {
			crmRecall = mapNoAttendet.get(value);
		} else if (type == Constant.RECALL_CONFIRMED) {
			crmRecall = mapConfirmed.get(value);
		} else if (type == Constant.RECALL_CONTROL) {
			crmRecall = mapControl.get(value);
		} else {
			crmRecall = mapMedication.get(value);
		}

		Date currentDate = new Date();
		boolean newRecord = false;
		if (crmRecall.getOccurrences() > 0) {
			List<CrmCampaignDetail> list = tablesService
					.getListCampaignByAppointment(crmCampaignDetail
							.getCrmAppointment().getId(),
							Constant.RECALL_NO_ATTENDET);
			if (list.size() <= crmRecall.getOccurrences()) {
				currentDate = FacesUtil.getDateWithoutTime(currentDate);
				if (crmRecall.getNumDays() > 0) {
					newRecord = true;
					if (crmRecall.getNumDays() == 1) {
						int hour = FacesUtil.getHour(currentDate);
						if (hour <= 12) {
							currentDate = FacesUtil.addHoursToDate(currentDate,
									4);
						} else {
							currentDate = FacesUtil.addDaysToDate(currentDate,
									1);
						}
					} else {
						currentDate = FacesUtil.addDaysToDate(currentDate, 1);
					}
				} else if (crmRecall.getNumDaysAux() > 0) {
					currentDate = FacesUtil.addDaysToDate(currentDate,
							crmRecall.getNumDaysAux());
					newRecord = true;
				}
			}
		}

		if (crmRecall.getTask() != null && crmRecall.getTask().equals("DATE")) {
			currentDate = selectedDates[type - 1];
			newRecord = true;
		} else if (crmRecall.getTask() != null
				&& crmRecall.getTask().equals("TASK_DATE")) {
			CrmCampaignTask crmCampaignTask = new CrmCampaignTask();
			crmCampaignTask.setCrmCampaignDetail(crmCampaignDetail);
			crmCampaignTask.setTaskDate(currentDate);
			tablesService.saveCampaignTask(crmCampaignTask);
		}

		selected.setState(2);
		tablesService.saveCampaign(selected);

		crmCampaignDetail.setStatus(value);
		tablesService.saveCampaignDetail(crmCampaignDetail);

		if (newRecord) {
			String currentDateString = FacesUtil.formatDate(currentDate,
					"yyyy-MM-dd");
			CrmCampaign newCrmCampaign = tablesService
					.getListCampaignByPatient(crmCampaignDetail
							.getCrmCampaign().getCrmPatient().getId(),
							currentDateString);
			if (newCrmCampaign == null) {
				newCrmCampaign = crmCampaignDetail.getCrmCampaign();
				newCrmCampaign.setId(null);
				newCrmCampaign.setDateCall(currentDate);
				tablesService.saveCampaign(newCrmCampaign);
			}

			CrmCampaignDetail newCrmCampaignDetail = crmCampaignDetail;
			newCrmCampaignDetail.setCrmCampaign(newCrmCampaign);
			newCrmCampaignDetail.setId(null);
			newCrmCampaignDetail.setCallDate(currentDate);
			newCrmCampaignDetail.setStatus(0);
			tablesService.saveCampaignDetail(newCrmCampaignDetail);
		}
	}

	public void saveAction() {
		String message = null;
		String paramValue = null;
		int level = 0;
		int valueNoAttendet = -1;
		int valueConfirmed = -1;
		int valueControl = -1;
		int valueMedication = -1;
		boolean validate = true;
		RequestContext context = RequestContext.getCurrentInstance();

		if (selectedDetailNoAttendet != null) {
			try {
				paramValue = FacesUtil.getMessage("cam_type_no_attendet");
				message = FacesUtil.getMessage("cam_msg_required", paramValue);
				level = getLevels(Constant.RECALL_NO_ATTENDET,
						levelValuesNoAttendet);
				if (level > 0) {
					valueNoAttendet = levelValuesNoAttendet[level];
					if (valueNoAttendet == Constant.DEFAULT_VALUE.intValue()) {
						FacesUtil.addError(message);
						validate = false;
					} else {
						generateNewCampaign(selectedDetailNoAttendet,
								valueNoAttendet, Constant.RECALL_NO_ATTENDET);
					}
				} else {
					FacesUtil.addError(message);
					validate = false;
				}
			} catch (Exception ex) {

			}
		}
		if (selectedDetailConfirmed != null) {
			try {
				paramValue = FacesUtil.getMessage("cam_type_confirmed");
				message = FacesUtil.getMessage("cam_msg_required", paramValue);
				level = getLevels(Constant.RECALL_CONFIRMED,
						levelValuesConfirmed);
				if (level > 0) {
					valueConfirmed = levelValuesConfirmed[level];
					if (valueConfirmed == Constant.DEFAULT_VALUE.intValue()) {
						FacesUtil.addError(message);
						validate = false;
					} else {
						generateNewCampaign(selectedDetailConfirmed,
								valueConfirmed, Constant.RECALL_CONFIRMED);
					}
				} else {
					FacesUtil.addError(message);
					validate = false;
				}
			} catch (Exception ex) {

			}
		}
		if (selectedDetailControl != null) {
			try {
				paramValue = FacesUtil.getMessage("cam_type_control");
				message = FacesUtil.getMessage("cam_msg_required", paramValue);
				level = getLevels(Constant.RECALL_CONTROL, levelValuesControl);
				if (level > 0) {
					valueControl = levelValuesControl[level];
					if (valueControl == Constant.DEFAULT_VALUE.intValue()) {
						FacesUtil.addError(message);
						validate = false;
					} else {
						generateNewCampaign(selectedDetailControl,
								valueControl, Constant.RECALL_CONTROL);
					}
				} else {
					FacesUtil.addError(message);
					validate = false;
				}
			} catch (Exception ex) {

			}
		}
		if (selectedDetailMediaction != null) {
			try {
				paramValue = FacesUtil.getMessage("cam_type_medication");
				message = FacesUtil.getMessage("cam_msg_required", paramValue);
				level = getLevels(Constant.RECALL_MEDICATION,
						levelValuesMedication);
				if (level > 0) {
					valueMedication = levelValuesMedication[level];
					if (valueMedication == Constant.DEFAULT_VALUE.intValue()) {
						FacesUtil.addError(message);
						validate = false;
					} else {
						generateNewCampaign(selectedDetailMediaction,
								valueMedication, Constant.RECALL_MEDICATION);
					}
				} else {
					FacesUtil.addError(message);
					validate = false;
				}
			} catch (Exception ex) {

			}
		}

		if (validate) {
			refreshList();
			message = FacesUtil.getMessage("msg_record_ok");
			FacesUtil.addInfo(message);
		}

		context.addCallbackParam("validate", validate);
	}

	public void callAction(ActionEvent event) {
		remoteChannel = null;
		called = false;

		phone = selected.getCrmPatient().getPhoneNumber();
		if (phoneType == 2) {
			phone = selected.getCrmPatient().getCellNumber();
		}
		String phoneWithIndicative = phone;

		if (!FacesUtil.isEmptyOrBlank(indicative)) {
			phoneWithIndicative = indicative + phoneWithIndicative;
		}
		for (VwCallRange row : listCallRange) {
			if (FacesUtil.getRegularExpression(row.getExpressionRegular(),
					phoneWithIndicative)) {
				for (AstTrunkDialpatterns dial : listDialpatterns) {
					String pattern = dial.getMatchPatternPass().replace("X",
							"\\d");
					if (FacesUtil.getRegularExpression(pattern, phone)) {
						phoneWithIndicative = phone;
						if (!FacesUtil.isEmptyOrBlank(dial.getPrependDigits())) {
							phoneWithIndicative = dial.getPrependDigits()
									+ phone;
						}

						if (row.getPrefix() == 0
								&& !FacesUtil.isEmptyOrBlank(indicative)) {
							phoneWithIndicative = phone;
						}

						remoteChannel = row.getCallNumber().replace(
								"numero_a_marcar", phoneWithIndicative);
						break;
					}
				}
				break;
			}
		}

		if (remoteChannel != null) {
			String sessionId = FacesUtil.getSessionID().substring(0, 16);
			int numCalls = FacesUtil.getCurrentUserData().getNumCalls();
			numCalls = numCalls + 1;
			FacesUtil.getCurrentUserData().setNumCalls(numCalls);
			idCall = sessionId + numCalls;
			Asterisk asterisk = new Asterisk(asteriskHost, asteriskPort,
					asteriskUser, asteriskPassword);

			try {
				CallerId callerId = new CallerId(Constant.CALLED_TYPE_OUT + ":"
						+ phone, Constant.CALLED_TYPE_OUT + ":" + phone);
				asterisk.callActionAplication(remoteChannel, agentNumber,
						idCall, callerId);
				called = true;
			} catch (ManagerCommunicationException e) {
				called = false;
			} catch (NoSuchChannelException e) {
				called = false;
			}
		} else {
			called = false;
			String message = FacesUtil.getMessage("cam_msg_call_error");
			FacesUtil.addError(message);
		}
	}

}
