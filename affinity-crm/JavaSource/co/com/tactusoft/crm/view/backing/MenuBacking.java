package co.com.tactusoft.crm.view.backing;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmPage;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
@Scope("session")
public class MenuBacking implements Serializable {

	private static final long serialVersionUID = 1L;
	private MenuModel model;
	private List<CrmPage> listPage;

	public MenuBacking() {
		model = new DefaultMenuModel();
		listPage = FacesUtil.getCurrentUserData().getListPage();

		for (CrmPage crmPage : listPage) {
			if (crmPage.getParent() == null) {
				DefaultSubMenu submenu = new DefaultSubMenu();
				submenu.setLabel(crmPage.getName());
				submenu.setIcon(crmPage.getIcon());
				for (CrmPage children : listPage) {
					if ((children.getParent() != null)
							&& (children.getParent().intValue() == crmPage
									.getId().intValue())) {
						DefaultMenuItem menuItem = new DefaultMenuItem();
						menuItem.setValue(children.getName());
						menuItem.setIcon(children.getIcon());
						List<String> params = new ArrayList<String>();
						params.add(children.getPage());
						menuItem.setParams(new HashMap<String, List<String>>());
						menuItem.getParams().put("page", params);
						menuItem.setAjax(true);
						menuItem.setCommand("#{menuBacking.actionPage}");
						submenu.addElement(menuItem);
					}
				}
				model.addElement(submenu);
			}
		}
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	private void refreshBackings() {
		PatientBacking patientBacking = FacesUtil.findBean("patientBacking");
		patientBacking.newAction(null);

		ContactBacking contactBacking = FacesUtil.findBean("contactBacking");
		contactBacking.newAction(null);

		HistoryBacking historyBacking = FacesUtil.findBean("historyBacking");
		historyBacking.newAction(null);

		AppointmentBacking appointmentBacking = FacesUtil
				.findBean("appointmentBacking");
		appointmentBacking.newAction(null);

		SearchByPatientBacking searchByPatientBacking = FacesUtil
				.findBean("searchByPatientBacking");
		searchByPatientBacking.newAction(null);
		
		AppointmentPatientBacking appointmentPatientBacking = FacesUtil
				.findBean("appointmentPatientBacking");
		appointmentPatientBacking.newAction(null);

		CampaignBacking campaignBacking = FacesUtil.findBean("campaignBacking");
		campaignBacking.newAction();
		campaignBacking.refreshList();
	}

	public void actionPage(ActionEvent event) {
		refreshBackings();

		DefaultMenuItem menuItem = (DefaultMenuItem) event.getSource();
		String page = (String) menuItem.getParams().get("page").get(0);
		if (page != null) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("../.." + page);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String actionPage() {
		refreshBackings();
		
		String page = FacesUtil.getParam("page");
		if (page != null) {
			page = page + "?faces-redirect=true";
		}
		return page;
	}

}
