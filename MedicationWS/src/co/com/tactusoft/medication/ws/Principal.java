package co.com.tactusoft.medication.ws;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import co.com.tactusoft.medication.bo.ServicesBO;
import co.com.tactusoft.medication.dao.entities.Medication;

@WebService(name = "Principal", serviceName = "Principal")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class Principal extends SpringBeanAutowiringSupport {

	@Resource
	private WebServiceContext context;
	private final AtomicReference<ServicesBO> autoWiredDelegate;

	public Principal() {
		autoWiredDelegate = new AtomicReference<ServicesBO>();
	}

	private ServicesBO getAutoWiredDelegate() {
		final ServicesBO existingValue = autoWiredDelegate.get();
		if (existingValue != null) {
			return existingValue;
		}
		final ServicesBO newValue = createAutoWiredDelegate();
		if (autoWiredDelegate.compareAndSet(null, newValue)) {
			return newValue;
		}
		return autoWiredDelegate.get();
	}

	private ServicesBO createAutoWiredDelegate() {
		final ServletContext servletContext = (ServletContext) context
				.getMessageContext().get("javax.xml.ws.servlet.context");
		final WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		return (ServicesBO) webApplicationContext
				.getAutowireCapableBeanFactory().getBean("servicesBO");
	}

	@WebMethod
	public @WebResult(name = "medication")
	List<Medication> getListMedication(@WebParam(name = "doc") String doc) {
		return getAutoWiredDelegate().getListMedication(doc);
	}

	@WebMethod
	public @WebResult(name = "medication")
	String getListMedicationString(@WebParam(name = "doc") String doc) {
		List<Medication> list = getAutoWiredDelegate().getListMedication(doc);
		StringBuilder result = new StringBuilder();
		for (Medication row : list) {
			result.append(row.getIdClienteCrm() + ";" + row.getIdReceta() + ";"
					+ row.getIdMedico() + ";" + row.getIdProductoCrm() + ";"
					+ row.getIdMaterialSAP() + ";" + row.getCantidad() + "|");
		}
		return result.toString();
	}

}
