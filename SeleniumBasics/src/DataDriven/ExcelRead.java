package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {
		XSSFWorkbook ExcelWbook;
		XSSFSheet ExcelSheet;
		XSSFCell ExcelCell;
		String path = "D:\\DATA\\Work\\Automation\\Selenium\\References\\ExcelRead.xlsx";
		String sheetName = "Sheet1";
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWbook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelWbook.getSheet(sheetName);
			ExcelCell = ExcelSheet.getRow(2).getCell(0);
			String Celldata = ExcelCell.getStringCellValue();
			System.out.println(Celldata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
