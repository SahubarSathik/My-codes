package org.login;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks1 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		;
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for (int i = 1; i < allLinks.size(); i++) {
			String url = allLinks.get(i).getAttribute("href");
			verifyLinkActive(url);

		}
	}

	public static void verifyLinkActive(String linkUrl) throws IOException {

		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			httpURLConnection.setConnectTimeout(3000);
			try {
				httpURLConnection.connect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (httpURLConnection.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());

			}
			if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {

				System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);

			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
	}

}
