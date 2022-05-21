package org.login;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int brokenCount = 0;
		for (int i = 0; i < allLinks.size(); i++) {
			WebElement img = allLinks.get(i);
			String attribute = img.getAttribute("href");

			// To Convert String into Url
			URL url = new URL(attribute); 

			// Open the url by using openConnection
			URLConnection openConnection = url.openConnection();

			// Convert url into httpUrlConnnection
			HttpsURLConnection connection = (HttpsURLConnection) openConnection;

			// To get Response Code
			int responseCode = connection.getResponseCode();

			// Check response code value as 200
			if (responseCode != 200) {
				brokenCount++;
				System.out.println("Broken Links are ;"+attribute);
			}
		}
		System.out.println("Number Broken Links :" + brokenCount);
		driver.quit();
	}
}
