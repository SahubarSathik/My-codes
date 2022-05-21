package org.login;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShotEx {

	@Test
	private void errorPicture() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.switchTo().window("");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement findElement = driver.findElement(ById.id("nav-search"));
		TakesScreenshot sc = (TakesScreenshot)driver;
		File source = findElement.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./test_data/,k.png"));
		
		
//		File source = findElement.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(source, new File("./test_data/rose.png"));

		driver.quit();
	}

}
