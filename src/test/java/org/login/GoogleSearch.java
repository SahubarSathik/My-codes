package org.login;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class GoogleSearch extends BaseClass{

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("yamaha");
		List<WebElement> findElements = driver.findElements(By.xpath
				("//li[@class='sbct']//child::div[@class='wM6W7d']//child::span"));
        System.out.println(findElements.size());
		for (int i = 0; i < findElements.size(); i++) {
			String text = findElements.get(i).getText();
			System.out.println(text);
		}
		
}
	}
	
	
	

