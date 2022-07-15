package org.login;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Array;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageObjects extends BaseClass {
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[.='✕']")).click();

		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		searchBox.sendKeys("iPhone", Keys.ENTER);
		java.util.List<WebElement> mobileNames = driver
				.findElements(By.xpath("//div[contains(text(),'APPLE iPhone')]"));

		for (int i = 0; i < mobileNames.size(); i++) {
			String name = mobileNames.get(i).getText();

			System.out.println(name);
			File f = new File("C:\\Users\\Sathik\\eclipse-workspace\\login\\test_data\\workbook1.xlsx");

			FileInputStream fi = new FileInputStream(f);

			Workbook book = new XSSFWorkbook(fi);
			Sheet sheet = book.getSheet("iPhones");
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			DataFormatter df = new DataFormatter();
			String stringCellValue = df.formatCellValue(cell);

			System.out.println(stringCellValue);

			if (!name.equals(stringCellValue)) {

				System.out.println(name + " The Mobile is not Matched With " + stringCellValue);
 
			} 
		}

	}
}
