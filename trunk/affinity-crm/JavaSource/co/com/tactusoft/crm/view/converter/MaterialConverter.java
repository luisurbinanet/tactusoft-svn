package co.com.tactusoft.crm.view.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import co.com.tactusoft.crm.util.FacesUtil;

import com.tactusoft.webservice.client.beans.WSBean;

@FacesConverter(value = "materialConverter")
public class MaterialConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String submittedValue) {
		if (submittedValue.trim().equals("")) {
			return null;
		} else {
			try {
				List<WSBean> list = FacesUtil.getCurrentUserData()
						.getListWSMaterials();

				for (WSBean data : list) {
					if (data.getCode().equals(submittedValue)) {
						return data;
					}
				}

			} catch (NumberFormatException exception) {
				throw new ConverterException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Conversion Error",
						"Not a valid material"));
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
			return ((WSBean) value).getCode();
		}
	}

}
