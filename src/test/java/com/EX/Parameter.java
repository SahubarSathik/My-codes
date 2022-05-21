package com.EX;

import java.time.Duration;

import org.login.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter {
	WebDriver driver;

	@Parameters({ "emailId", "password", "browser" })
	@Test
	void login(String email, String pass, String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("brower is not defined");
			break;
		}
		System.out.println(email + "\n" + pass);

		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("email")).sendKeys("sathikdme@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("hindujasathik");
		driver.findElement(By.name("login")).click();
		System.out.println("Title is :" + driver.getTitle());

	}
}
