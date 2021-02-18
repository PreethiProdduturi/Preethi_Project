package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public ExcelUtils(String ExcelPath,String sheetName) {
		try {
			workbook = new XSSFWorkbook(ExcelPath);
			sheet= workbook.getSheet(sheetName);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getRowCount();
		getCellDataString(1,0);
		getCellDataNumeric(1,1);
	}
	public static void getRowCount() {
		int rowcount=sheet.getPhysicalNumberOfRows();
		System.out.println("num of rows is"+rowcount);
       }

	public static void getCellDataString(int rowNum,int colNum) {
		String cell=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(cell);
      }
	public static void getCellDataNumeric(int rowNum,int colNum) {
		double cell=sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		System.out.println(cell);
      }
}
