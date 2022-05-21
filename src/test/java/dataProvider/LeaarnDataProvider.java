package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LeaarnDataProvider {
	@DataProvider(name = "login")
	public String[][] getData() {
		String[][] data = new String[2][2];
		data[0][0] = "sathikdme@gmail.com";
		data[0][1] = "123456";

		data[1][0] = "asbc@gamil.com";
		data[1][1] = "465488";
		return data;

	}

	@Test(dataProvider = "login")
	private void login(String email, String pass) {
		
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.findElement(By.name("login")).click();
		System.out.println("Title is :" + driver.getTitle());
		driver.quit();
	}

}
