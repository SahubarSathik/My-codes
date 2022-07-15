package org.login;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XpathFb {

	WebDriver driver;

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

	private void forgotPassword() {
		PageFactory.initElements(driver, this);
		driver.findElement(By.xpath(
				"//input[@id='email']//parent::div//following-sibling::div//child::input//parent::div//parent::div//parent::div//following-sibling::div//child::button//parent::div/following-sibling::div//child::a"))
				.click();
		driver.quit();

	}

	@Test
	private void XPath() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//button[.='✕']")).click();

		driver.findElement(By.tagName("input")).sendKeys("iphone 13", Keys.ENTER);

		String mobileName = "APPLE";

		String mobileXpath = "//div[contains(text(),'" + mobileName + "')]";

		System.out.println(mobileXpath);
		String mobileRate = "//div[contains(text(),'" + mobileName
				+ "')]//ancestor::div[@class='_3pLy-c row']//descendant::div[@class='_30jeq3 _1_WHN1']";
		System.out.println(mobileRate);

		List<WebElement> findElements = driver.findElements(By.xpath(mobileXpath));

		ArrayList<String> li = new ArrayList<>();

		for (int i = 0; i < findElements.size(); i++) {

			WebElement webElement = findElements.get(i);
			String names = webElement.getText();
			li.add(names);

		}

		List<WebElement> findElements2 = driver.findElements(By.xpath(mobileRate));

		ArrayList<String> li2 = new ArrayList<>();

		for (int i = 0; i < findElements2.size(); i++) {

			String rates = findElements2.get(i).getText();
			li2.add(rates);

		}

		Map<String, String> m = new LinkedHashMap<>();

		Set<Entry<String, String>> entrySet = m.entrySet();
		for (int i = 0; i < entrySet.size(); i++) {
			m.put(li2.get(i), li.get(i));

		}
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}

	}

}
