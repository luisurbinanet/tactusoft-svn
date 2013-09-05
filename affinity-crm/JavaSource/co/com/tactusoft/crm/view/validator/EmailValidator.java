package co.com.tactusoft.crm.view.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import co.com.tactusoft.crm.util.FacesUtil;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
			+ "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
			+ "(\\.[A-Za-z]{2,})$";

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent,
			Object object) throws ValidatorException {
		String enteredEmail = (String) object;
		if (!FacesUtil.isEmptyOrBlank(enteredEmail)) {
			// Set the email pattern string
			Pattern p = Pattern.compile(EMAIL_PATTERN);

			// Match the given string with the pattern
			Matcher m = p.matcher(enteredEmail);

			// Check whether match is found
			boolean matchFound = m.matches();

			if (!matchFound) {
				String title = FacesUtil.getMessage("msg_error");
				String message = FacesUtil.getMessage("msg_validator_email");
				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, title, message));
			}
		}
	}

}
