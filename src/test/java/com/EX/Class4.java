package com.EX;

import java.util.List;

import org.login.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Class4 extends BaseClass {
	@Test(timeOut=2000,expectedExceptions= {NoSuchElementException.class})
	private void findElements() {
		getDriver("chrome");
		launch("https://www.google.com/");
		implityWait(10);
		locators("name", "q1").sendKeys("cricket",Keys.ENTER);
		List<WebElement> cricket = driver.findElements(By.xpath("//*[contains(text(),'cricket') or contains(text(),'Cricket')]"));
		System.out.println(cricket.size());
		driver.quit();
		
	}
	
	
/*	@Test
	public void tr401() {
		System.out.println("tr401");
	}
	@Test
	public void tr402() {
		System.out.println("tr402");
	}
	@Test
	public void tr403() {
		System.out.println("tr403");
	}*/
}
