package co.com.tactusoft.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.controller.bo.ParameterBo;
import co.com.tactusoft.crm.view.beans.Material;

@Named
@Scope("session")
public class LoadXLS implements Serializable {

	@Inject
	private ParameterBo service;

	private static final long serialVersionUID = 1L;
	private String urlXLSFile;

	public LoadXLS() {

	}

	public String getUrlXLSFile() {
		if (urlXLSFile == null) {
			urlXLSFile = service.getTextValue("RUTA_ARCHIVO_MATERIALES");
		}
		return urlXLSFile;
	}

	public void setUrlXLSFile(String urlXLSFile) {
		this.urlXLSFile = urlXLSFile;
	}

	public List<Material> getListMaterial() {
		List<Material> list = new LinkedList<Material>();
		try {
			InputStream inp = new FileInputStream(getUrlXLSFile());
			Workbook wb = WorkbookFactory.create(inp);
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> itRows = sheet.rowIterator();
			itRows.next();
			while (itRows.hasNext()) {
				Row row = itRows.next();
				String code = String.valueOf(row.getCell(0)
						.getNumericCellValue());

				if (code.lastIndexOf('0') > 0) {
					code = code.substring(0, code.length() - 2);
				}

				String descr = row.getCell(1).getStringCellValue();
				String price = String.valueOf(row.getCell(2)
						.getNumericCellValue());

				Material material = new Material(code, descr, price, "1");
				list.add(material);
			}
		} catch (FileNotFoundException e) {
			list = new LinkedList<Material>();
			Material material = new Material("-1", "No existe el Archivo", "-1");
			list.add(material);
		} catch (InvalidFormatException e) {
			list = new LinkedList<Material>();
			Material material = new Material("-1", e.getMessage(), "-1");
			list.add(material);
		} catch (IOException e) {
			list = new LinkedList<Material>();
			Material material = new Material("-1", e.getMessage(), "-1");
			list.add(material);
		}

		return list;
	}

}
