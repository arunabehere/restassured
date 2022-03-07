package com.qa.utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static String excelPath = "./resources/testdata.xlsx"; ///we can also use System.getProperty("user.dir")
	public static XSSFWorkbook wb ;
	public static Sheet sh;

	public ExcelUtil(String excelPath , String sheetName)  {
		try {
			wb = new XSSFWorkbook(excelPath);
			sh = wb.getSheet(sheetName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static int getRowCount() {
		int rowCount = sh.getPhysicalNumberOfRows();
		return rowCount;
	}

	public void getCellData() throws IOException{
		try {

			DataFormatter df = new DataFormatter();
			int count = getRowCount();

			for (int i=1; i<count; i++) {
				for (int j=0; j<3; j++) {
					Object value = df.formatCellValue(sh.getRow(i).getCell(j));
					System.out.print("value is  ,"+value +" ");
				}
				System.out.println();
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			wb.close();
		}
	}

	public static void main (String args[]) throws IOException {
		ExcelUtil util = new ExcelUtil(excelPath, "Sheet1");
		util.getCellData();
	}
}
