package co.com.tactusoft.crm.view.backing;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;
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
				Submenu submenu = new Submenu();
				submenu.setLabel(crmPage.getName());
				submenu.setIcon(crmPage.getIcon());
				for (CrmPage children : listPage) {
					if ((children.getParent() != null)
							&& (children.getParent().intValue() == crmPage
									.getId().intValue())) {
						MenuItem menuItem = new MenuItem();
						menuItem.setValue(children.getName());
						menuItem.setIcon(children.getIcon());
						menuItem.getAttributes()
								.put("page", children.getPage());
						menuItem.setAjax(true);
						menuItem.addActionListener(FacesUtil
								.createMethodActionListener(
										"#{menuBacking.actionPage}", Void.TYPE,
										new Class[] { ActionEvent.class }));
						submenu.getChildren().add(menuItem);
					}
				}
				model.addSubmenu(submenu);
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
	}

	public void actionPage(ActionEvent event) {
		refreshBackings();

		MenuItem menuItem = (MenuItem) event.getSource();
		String page = (String) menuItem.getAttributes().get("page");
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
		String page = FacesUtil.getParam("page");
		if (page != null) {
			page = page + "?faces-redirect=true";
		}
		return page;
	}

}
