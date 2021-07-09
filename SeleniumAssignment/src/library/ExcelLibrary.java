package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	String filePath;
	FileInputStream fis;
	Workbook wb;
	Sheet s;
	String sheetname;

	public ExcelLibrary(String sheet, String path) {
		sheetname = sheet;
		filePath = path;
		try {
			fis = new FileInputStream(filePath);
			wb = WorkbookFactory.create(fis);
			s = wb.getSheet(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getExcelData(int rownum, int cellnum) throws InvalidFormatException, IOException {
		String retval = null;
		Row r = s.getRow(rownum);
		Cell c = r.getCell(cellnum);
		retval = c.getStringCellValue();
		return retval;
	}

	public int getRowCount() throws InvalidFormatException, IOException {
		int row = 0;
		row = s.getLastRowNum();
		return row;
	}

	public int getColumnCount() throws InvalidFormatException, IOException {
		int columncount = 0;
		columncount = s.getDefaultColumnWidth();
		return columncount;
	}

	public void writeToExcel(int rownum, int cellnum, String data) throws InvalidFormatException,
			IOException {
		try {
			Row r = s.getRow(rownum);
			Cell c = r.createCell(cellnum);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(filePath);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
