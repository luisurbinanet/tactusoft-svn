package co.com.tactusoft.crm.view.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import co.com.tactusoft.crm.util.FacesUtil;

@FacesValidator("numberValidator")
public class NumberValidator implements Validator {

	private static final String NUMBER_PATTERN = "[0-9]*";

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent,
			Object object) throws ValidatorException {

		HtmlInputText inputText = (HtmlInputText) uiComponent;

		String enteredText = (String) object;
		// Set the email pattern string
		Pattern p = Pattern.compile(NUMBER_PATTERN);

		// Match the given string with the pattern
		Matcher m = p.matcher(enteredText);

		// Check whether match is found
		boolean matchFound = m.matches();

		if (!matchFound) {
			String title = FacesUtil.getMessage("msg_error");
			String message = FacesUtil.getMessage("msg_validator_number",
					inputText.getLabel());
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, title, message));
		}
	}

}
