package com.vaadin.demo.dashboard.view.orders;

import com.vaadin.demo.dashboard.event.DashboardEventBus;
import com.vaadin.demo.dashboard.event.DashboardEvent.UserLoginRequestedEvent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.Reindeer;
import com.vaadin.ui.themes.ValoTheme;

public class OrderView extends Panel implements View {

	private static final long serialVersionUID = 1L;

	public OrderView() {
		setSizeFull();
		//addStyleName("transactions");
		DashboardEventBus.register(this);

		VerticalLayout viewLayout = new VerticalLayout();
		viewLayout.setSizeFull();
		viewLayout.setStyleName(Reindeer.LAYOUT_BLUE);
		setContent(viewLayout);

		Component header = buildHeader();
		//viewLayout.addComponent(header);
		//viewLayout.setComponentAlignment(header, Alignment.MIDDLE_CENTER);
		header = buildFields();
		viewLayout.addComponent(header);
		viewLayout.setComponentAlignment(header, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void detach() {
		super.detach();
		// A new instance of TransactionsView is created every time it's
		// navigated to so we'll need to clean up references to it on detach.
		DashboardEventBus.unregister(this);
	}

	private Component buildHeader() {
		HorizontalLayout header = new HorizontalLayout();
		header.addStyleName("viewheader");
		header.setSpacing(true);
		Responsive.makeResponsive(header);

		Label title = new Label("Crear Pedido");
		title.setSizeUndefined();
		title.addStyleName(ValoTheme.LABEL_H1);
		title.addStyleName(ValoTheme.LABEL_NO_MARGIN);
		header.addComponent(title);

		return header;
	}

	private Component buildFields() {
		final TextField clientTextField = new TextField("Cliente");
		clientTextField.setWidth("300px");
		clientTextField.setRequired(true);
		clientTextField.setInvalidAllowed(false);
		
		final TextField dateTextField = new TextField("Cliente");
		dateTextField.setWidth("300px");
		dateTextField.setRequired(true);
		dateTextField.setInvalidAllowed(false);

		final Button okButton = new Button("Aceptar");
		okButton.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(final ClickEvent event) {

			}
		});

		// Add both to a panel
		VerticalLayout fields = new VerticalLayout(clientTextField, dateTextField, okButton);
		// fields.setCaption("Please login to access the application. (test@test.com/passw0rd)");
		fields.setSpacing(true);
		fields.setMargin(new MarginInfo(true, true, true, false));
		fields.setSizeUndefined();

		return fields;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
