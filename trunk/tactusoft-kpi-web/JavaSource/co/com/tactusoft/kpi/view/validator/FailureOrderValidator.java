package co.com.tactusoft.kpi.view.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("failureOrderValidator")
public class FailureOrderValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent,
			Object object) throws ValidatorException {

		Integer failuresOrders = (Integer) object;
		
		Integer scheduledOrders = (Integer) uiComponent.getAttributes().get(
				"scheduledOrders");
		
		Integer finishedOrders = (Integer) uiComponent.getAttributes().get(
				"finishedOrders");

		int sum = scheduledOrders - (finishedOrders + failuresOrders);
		if (sum < 0){
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Advertencia", "Las suma de OT Terminadas y Fallidas no deben superar las Programadas"));
		}
	}

}
