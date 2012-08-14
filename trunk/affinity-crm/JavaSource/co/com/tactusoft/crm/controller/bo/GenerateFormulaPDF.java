package co.com.tactusoft.crm.controller.bo;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.hibernate.impl.SessionFactoryImpl;

import co.com.tactusoft.crm.util.FacesUtil;

public class GenerateFormulaPDF {

	public static void PDF(BigDecimal idAppointment) throws JRException,
			IOException, SQLException {
		String imagePath = FacesUtil.getRealPath("/images/");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p_appointment", idAppointment.intValue());
		param.put("p_image", imagePath);

		SessionFactoryImpl sessionFactory = FacesUtil
				.findBean("sessionFactory");
		Connection connection = sessionFactory.getConnectionProvider()
				.getConnection();

		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath("/reports/formula.jasper");
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
				param, connection);
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
