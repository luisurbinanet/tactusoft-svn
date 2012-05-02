package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import co.com.tactusoft.crm.view.beans.Material;

public class Test {

	public List<Material> getListMaterial() {
		List<Material> list = new LinkedList<Material>();
		try {
			InputStream inp = new FileInputStream(
					"C:/affinity/Materiales4000.xlsx");
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

				Material material = new Material(code, descr, price);
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

	public static void main(String[] args) {
		try {
			InputStream inp = new FileInputStream(
					"C:/affinity/Materiales4000.xlsx");
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
				System.out.println(code + " - " + descr + " - " + price);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
