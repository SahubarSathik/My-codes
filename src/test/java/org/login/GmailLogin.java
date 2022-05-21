package org.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class GmailLogin {
WebDriver driver;
@Test
private void gmail() {
	driver =new ChromeDriver();
	driver.get("https://accounts.google.com/");
	driver.findElement(By.id("identifierId")).sendKeys("sathikdme@gmail.com");
	
}	
	
}
