package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.DataUtils;
import utils.ReadExcel;

public class DataProviderNew {
/*	@DataProvider(name="getData")
	public String[][] getData() {
		String[][] excelData = ReadExcel.getExcelData();
		String[][] data = new String[3][2];
		data[0][0] = "sathikdme@gmail.com";
		data[0][1] = "123456";

		data[1][0] = "asbc@gamil.com";
		data[1][1] = "465488";
		
		data[2][0] = "pqrs@gamil.com";
		data[2][1] = "jhuiuu";
		
		return excelData;
	}*/

	@Test(dataProvider = "getData", dataProviderClass=DataUtils.class)
	public void login(String data[]) {
		System.out.println(data[0] + "\n" + data[1]);

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("email")).sendKeys(data[0]);
		driver.findElement(By.id("pass")).sendKeys(data[1]);
		driver.findElement(By.name("login")).click();
		System.out.println("Title is :" + driver.getTitle());
		driver.quit();
	}

}
