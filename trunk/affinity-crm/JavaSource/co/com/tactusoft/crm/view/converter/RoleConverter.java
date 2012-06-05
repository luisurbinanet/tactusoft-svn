package co.com.tactusoft.crm.view.converter;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import co.com.tactusoft.crm.model.entities.CrmRole;
import co.com.tactusoft.crm.util.FacesUtil;

@FacesConverter(value="roleConverter")
public class RoleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String submittedValue) {
		if (submittedValue.trim().equals("")) {
			return null;
		} else {
			try {
				int id = new BigDecimal(submittedValue).intValue();
				List<CrmRole> list = FacesUtil.getCurrentUserData().getListRoleAll();

				for (CrmRole data : list) {
					if (data.getId().intValue() == id) {
						return data;
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
			return String.valueOf(((CrmRole) value).getId());
		}
	}

}
