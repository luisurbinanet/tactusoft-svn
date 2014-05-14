package co.com.tactusoft.crm.controller.bo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;

import org.hibernate.internal.SessionFactoryImpl;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.orm.hibernate4.SessionFactoryUtils;

import com.lowagie.text.pdf.PdfWriter;

import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;

public class GenerateFormulaPDF {

	public static void PDF(BigDecimal idAppointment, String type)
			throws JRException, IOException, SQLException {
		String imagePath = FacesUtil.getRealPath("/images/");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("P_APPOINTMENT", idAppointment.intValue());
		param.put("P_IMAGE", imagePath);

		SessionFactoryImpl sessionFactory = FacesUtil
				.findBean("sessionFactory");
		Connection connection = SessionFactoryUtils.getDataSource(
				sessionFactory).getConnection();

		String path = "/reports/formula.jasper";
		String nameReport = "FormulaMedica.pdf";
		if (type.equals(Constant.MATERIAL_TYPE_THERAPY)) {
			path = "/reports/therapy.jasper";
			nameReport = "FormulaTerapia.pdf";
		} else if (type.equals(Constant.MATERIAL_TYPE_EXAMS)) {
			path = "/reports/lab.jasper";
			nameReport = "ExamanesLab.pdf";
		} else if (type.equals(Constant.MATERIAL_TYPE_ODONTOLOGY)) {
			path = "/reports/formulaOdo.jasper";
			nameReport = "FormulaOdontologica.pdf";
		}

		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(path);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
				param, connection);
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition",
				"attachment; filename=" + nameReport);
		ServletOutputStream servletOutputStream = httpServletResponse
				.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,
				servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}

	public static void remissionPDF(BigDecimal idNote) throws JRException,
			IOException, SQLException {
		String imagePath = FacesUtil.getRealPath("/images/");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("P_APPOINTMENT", idNote.intValue());
		param.put("P_IMAGE", imagePath);

		SessionFactoryImpl sessionFactory = FacesUtil
				.findBean("sessionFactory");
		Connection connection = SessionFactoryUtils.getDataSource(
				sessionFactory).getConnection();

		String path = "/reports/remission.jasper";
		String nameReport = "Remission.pdf";

		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(path);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
				param, connection);
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition",
				"attachment; filename=" + nameReport);
		ServletOutputStream servletOutputStream = httpServletResponse
				.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,
				servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}

	public static void historyPDF(BigDecimal idPatient, String type,
			Integer gender) throws JRException, IOException, SQLException {
		String imagePath = FacesUtil.getRealPath("/images/");
		String subreportsPath = FacesUtil.getRealPath("/reports/") + "/";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("P_ID_PATIENT", idPatient);
		param.put("SUBREPORT_DIR", subreportsPath);
		param.put("P_IMAGE", imagePath);
		param.put("P_GENDER", gender.toString());

		SessionFactoryImpl sessionFactory = FacesUtil
				.findBean("sessionFactory");
		Connection connection = SessionFactoryUtils.getDataSource(
				sessionFactory).getConnection();

		String nameReport = "HistoriaClinica";
		String path = "/reports/history.jasper";
		if (type.equals(Constant.ODONTOLOGY_HISTORY_TYPE)) {
			path = "/reports/historyOdo.jasper";
			nameReport = "HistoriaOdontologica";
		}

		nameReport = nameReport + idPatient + ".pdf";

		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(path);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
				param, connection);
		HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext
				.getCurrentInstance().getExternalContext().getResponse();
		httpServletResponse.addHeader("Content-disposition",
				"attachment; filename=" + nameReport);
		ServletOutputStream servletOutputStream = httpServletResponse
				.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,
				servletOutputStream);
		FacesContext.getCurrentInstance().responseComplete();
	}

	public static StreamedContent getHistoryPDF(BigDecimal idPatient,
			String type, Integer gender) throws JRException, IOException,
			SQLException {
		byte[] reportPdf = null;
		String imagePath = FacesUtil.getRealPath("/images/");
		String subreportsPath = FacesUtil.getRealPath("/reports/") + "/";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("P_ID_PATIENT", idPatient);
		param.put("SUBREPORT_DIR", subreportsPath);
		param.put("P_IMAGE", imagePath);
		param.put("P_GENDER", gender.toString());

		SessionFactoryImpl sessionFactory = FacesUtil
				.findBean("sessionFactory");
		Connection connection = SessionFactoryUtils.getDataSource(
				sessionFactory).getConnection();

		String nameReport = "HistoriaClinica";
		String path = "/reports/history.jasper";
		if (type.equals(Constant.ODONTOLOGY_HISTORY_TYPE)) {
			path = "/reports/historyOdo.jasper";
			nameReport = "HistoriaOdontologica";
		}

		nameReport = nameReport + idPatient + ".pdf";

		String reportPath = FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(path);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
				param, connection);
		reportPdf = JasperExportManager.exportReportToPdf(jasperPrint);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, new Boolean(
				true));
		exporter.setParameter(JRPdfExporterParameter.IS_128_BIT_KEY,
				new Boolean(true));
		/*
		 * exporter.setParameter(JRPdfExporterParameter.PERMISSIONS, new
		 * Integer( PdfWriter.ALLOW_PRINTING | PdfWriter.ALLOW_COPY));
		 */
		// exporter.setParameter(JRPdfExporterParameter.USER_PASSWORD, "crm");
		exporter.setParameter(JRPdfExporterParameter.OWNER_PASSWORD, "1c2rm3");
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, nameReport);
		exporter.exportReport();

		InputStream fis = new ByteArrayInputStream(out.toByteArray());

		return new DefaultStreamedContent(fis,
				"application/pdf; charset=UTF-8", nameReport);
	}

}
