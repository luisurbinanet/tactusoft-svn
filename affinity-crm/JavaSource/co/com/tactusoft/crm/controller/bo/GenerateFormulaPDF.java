package co.com.tactusoft.crm.controller.bo;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import co.com.tactusoft.crm.util.FacesUtil;

public class GenerateFormulaPDF {

	public static void PDF(BigDecimal idAppointment) throws JRException, IOException,
			SQLException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p_appointment", idAppointment.intValue());

		AnnotationSessionFactoryBean sessionFactory = FacesUtil
				.findBean("sessionFactory");
		DataSource datasource = sessionFactory.getDataSource();

		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/reports/formula.jasper");
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
				param, datasource.getConnection());
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition",
				"attachment; filename=report.pdf");
		ServletOutputStream servletOutputStream = httpServletResponse
				.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,
				servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}
}
