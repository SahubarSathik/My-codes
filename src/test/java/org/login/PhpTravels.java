package org.login;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class PhpTravels {
	@Test
	public static void main() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://phptravels.com/order");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		List<WebElement> beforePriceList = driver
				.findElements(By.xpath("//div[@class='show-price yearly']//child::span[@class='money number']"));

		for (WebElement webElement : beforePriceList) {
			String beforePrice = webElement.getText();
			System.err.println(beforePrice);
		

			List<WebElement> buyNowButton = driver.findElements(By.xpath(
					"//div[@class='show-price yearly']//child::span[@class='money number']//parent::div//following-sibling::a"));

			for (int j = 0; j < buyNowButton.size(); j++) {
				WebElement webElement2 = buyNowButton.get(j);
				js.executeScript("arguments[0].click();", webElement2);
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='gumroad-overlay-iframe']")));
			Object executeScript = js.executeScript("arguments[0]",driver.findElement(By.xpath("//div[@class='product-price-tag']//child::div[3]")));
				String afterPrice = executeScript.toString();
		//String afterPrice = driver.findElement(By.xpath("//div[@class='product-price-tag']//child::div[3]"))
						//.getText();
				
				driver.findElement(By.xpath("//button[@class='filled']")).click();
				driver.switchTo().defaultContent();
				System.out.println(afterPrice);
				
				//Assert.assertEquals(beforePrice, afterPrice);
			}

		}
		
	
}
}