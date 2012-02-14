package co.com.tactusoft.kpi.view.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("workOrderValidator")
public class WorkOrderValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent,
			Object object) throws ValidatorException {

		String fieldLabel = (String) uiComponent.getAttributes().get(
				"fieldLabel");

		Integer scheduledOrders = (Integer) object;
		if (scheduledOrders <= 0) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Advertencia", "El Campo "
							+ fieldLabel + " es Obligatorio"));
		}

	}

}
