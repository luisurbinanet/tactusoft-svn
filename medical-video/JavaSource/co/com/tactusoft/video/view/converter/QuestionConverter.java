package co.com.tactusoft.video.view.converter;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

import co.com.tactusoft.video.model.entities.VidQuestion;
import co.com.tactusoft.video.util.FacesUtil;
import co.com.tactusoft.video.view.backing.QuestionBacking;

@FacesConverter(value="questionConverter")
public class QuestionConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String submittedValue) {
		if (submittedValue.trim().equals("")) {
			return null;
		} else {
			try {
				int id = new BigDecimal(submittedValue).intValue();
				QuestionBacking questionBacking = FacesUtil
						.findBean("questionBacking");
				List<SelectItem> list = questionBacking.getListQuestion();

				for (SelectItem item : list) {
					VidQuestion q = (VidQuestion)item.getValue();
					if (q. getId().intValue() == id) {
						return q;
					}
				}

			} catch (NumberFormatException exception) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"Not a valid player"));
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object value) {
		if (value == null || value.equals("")) {
			return "";
		} else {
			return String.valueOf(((VidQuestion) value).getId());
		}
	}

}
