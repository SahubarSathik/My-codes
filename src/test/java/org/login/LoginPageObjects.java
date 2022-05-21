package org.login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageObjects extends BaseClass {
	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\Sathik\\eclipse-workspace\\login\\test_data\\workbook1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(stream);

		Sheet sheet = book.getSheet("sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);

		System.out.println(cell);

		Cell cell2 = row.getCell(1);
		DataFormatter dft = new DataFormatter();
		String value = dft.formatCellValue(cell2);
		System.out.println(value);
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("http://www.faceebook.com/");
		driver.manage().window().maximize();
		
		
		WebElement textUser = driver.findElement(By.id("email"));
		textUser.sendKeys(cell.getStringCellValue());
		
		WebElement textpass = driver.findElement(By.id("pass"));
		textpass.sendKeys(value);
		
	
		screenshot("C:\\Users\\Sathik\\eclipse-workspace\\login\\test_datarose.png");

		
		
		
		
		
		
		
		

		// FileOutputStream fo = new FileOutputStream(f);
		//
		// book.write(fo);

	}
}
