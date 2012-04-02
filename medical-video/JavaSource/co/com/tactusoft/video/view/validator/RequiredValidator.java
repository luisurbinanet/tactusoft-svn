package co.com.tactusoft.video.view.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import co.com.tactusoft.video.util.FacesUtil;

@FacesValidator("requiredValidator")
public class RequiredValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent,
			Object object) throws ValidatorException {

		String fieldLabel = (String) uiComponent.getAttributes().get(
				"fieldLabel");

		String value = (String) object;
		if (value.length() == 0) {
			String title = FacesUtil.getMessage("msg_warn");
			String message = FacesUtil.getMessage("msg_field_required",
					fieldLabel);
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_WARN, title, message));
		}

	}

}
