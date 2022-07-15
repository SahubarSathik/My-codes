package utils;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExel {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\Sathik\\eclipse-workspace\\login\\test_data.xlsx");
		XSSFWorkbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("sathik");
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(1);
		cell.setCellValue("Ram");
		FileOutputStream fo = new FileOutputStream(f);
		book.write(fo);
	}

}
