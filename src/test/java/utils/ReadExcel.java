package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] getExcelData() {
		String fileLocation = "./test_data/Login-data.xlsx";
		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = book.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <=lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				//String value = cell.getStringCellValue();
				data[i-1][j]=value;
			}
		}
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}

}
