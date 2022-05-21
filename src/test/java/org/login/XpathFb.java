package org.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XpathFb {

	WebDriver driver;

	@BeforeTest
	private void LoginFacebook() {

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@id='email']//parent::div//following-sibling::div//child::input"))
				.sendKeys("123456");
		driver.findElement(By.xpath(
				"//input[@id='email']//parent::div//following-sibling::div//child::input//parent::div//parent::div//parent::div//following-sibling::div//child::button"))
				.click();
	}

	@Test
	private void forgotPassword() {
		PageFactory.initElements(driver, this);
		driver.findElement(By.xpath(
				"//input[@id='email']//parent::div//following-sibling::div//child::input//parent::div//parent::div//parent::div//following-sibling::div//child::button//parent::div/following-sibling::div//child::a"))
				.click();
		driver.quit();

	}

}
