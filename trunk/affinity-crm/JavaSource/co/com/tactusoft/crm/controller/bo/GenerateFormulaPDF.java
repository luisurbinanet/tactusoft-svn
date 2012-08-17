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

import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

import co.com.tactusoft.crm.util.FacesUtil;

public class GenerateFormulaPDF {

	public static void PDF(BigDecimal idAppointment) throws JRException,
			IOException, SQLException {
		String imagePath = FacesUtil.getRealPath("/images/");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("P_APPOINTMENT", idAppointment.intValue());
		param.put("P_IMAGE", imagePath);

		SessionFactoryImpl sessionFactory = FacesUtil
				.findBean("sessionFactory");
		Connection connection = SessionFactoryUtils.getDataSource(
				sessionFactory).getConnection();

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
