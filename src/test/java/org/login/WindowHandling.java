package org.login;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandling {

	@Test
	private void size() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Andriod Tv", Keys.ENTER);
		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);
		// driver.findElement(By.xpath("//span[contains(text(),'Kodak 80 cm (32
		// inches)')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Acer 80 cm (32 inches)')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Mi 80 cm (32 inches)')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Redmi 80 cm (32 inches)')]")).click();
		Set<String> allWindowsId = driver.getWindowHandles();

		ArrayList<String> list = new ArrayList<String>(allWindowsId);
		driver.switchTo().window(list.get(1));
		
		String stWindow = driver.getWindowHandle();
		System.out.println(stWindow);
		driver.close();
		
		driver.switchTo().window(list.get(2));
		System.out.println(driver.getWindowHandle());
		driver.close();
		
		driver.switchTo().window(list.get(3));
		System.out.println(driver.getWindowHandle());
		driver.close();

		
		driver.quit();

	}

}
