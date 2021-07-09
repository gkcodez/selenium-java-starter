package DataDriven;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;

	// Constructor to connect to the Excel with sheetname and Path
	public DataDriven(String Path, String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to set the rowcount of the excel.
	public int excel_get_rows() throws Exception {
		try {
			return ExcelWSheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method to get the data and get the value as strings.
	public String getCellDataasstring(int RowNum, int ColNum) throws Exception {
		try {
			String CellData = ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
			System.out.println(CellData);
			return CellData;
		} catch (Exception e) {
			return "Errors in Getting Cell Data";
		}
	}

	// This method to get the data and get the value as number.
	public double getCellDataasnumber(int RowNum, int ColNum) throws Exception {
		try {
			double CellData = ExcelWSheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
			System.out.println(CellData);
			return CellData;
		} catch (Exception e) {
			return 000.00;
		}
	}

	public static void main(String[] args) throws Exception {
		DataDriven dd = new DataDriven(
				"D:\\DATA\\Work\\Automation\\Selenium\\References\\dataDrivenExcel.xlsx", "Sheet1");
		System.out.println(" \n Below are the details of " + dd.excel_get_rows()
				+ " Debenhams employees \n ");
		System.out.println("***************************");
		for (int i = 1; i <= dd.excel_get_rows(); i++) {
			for (int j = 0; j <= 4; j++) {
				if (i != dd.excel_get_rows()) {
					dd.getCellDataasstring(0, j);
				}
				dd.getCellDataasstring(i, j);
				if (i != dd.excel_get_rows()) {
					System.out.println("");
				}
			}
			if (i != dd.excel_get_rows()) {
				System.out.println("\n***************************");
			}
		}
	}
}