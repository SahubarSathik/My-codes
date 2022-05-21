package org.login;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTableTestLeaf {
	WebDriver driver;

	@BeforeTest
	private void loadtheUrl() {
		driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	private void gettheCountofNumberofColumns() {
		WebElement table = driver.findElement(By.xpath("//tbody/tr[1]"));
		List<WebElement> head = table.findElements(By.xpath("th"));
		int column = head.size();
		System.out.println("Number of Columns :" + column);

	}

	@Test
	private void gettheCountofNumberofRows() {
		WebElement table = driver.findElement(By.xpath("//tbody"));
		List<WebElement> head = table.findElements(By.xpath("tr"));
		int row = head.size();
		System.out.println("Number of Rows :" + row);
	}

	@Test
	private void gettheprogressvaluefLearntointeractwithElements() {
		List<WebElement> findElements = driver.findElements(
				By.xpath("//td[normalize-space()='Learn to interact with Elements']//following-sibling::td[1]"));
		ListIterator<WebElement> listIterator = findElements.listIterator();
		while (listIterator.hasNext()) {
			WebElement next = listIterator.next();
			System.out.println(next.getText());

		}
	}

	@Test
	private void checktheVitalTaskfortheLeastCompletedProgress() {
		List<WebElement> percentage = driver.findElements(By.xpath("//td[2]"));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		ListIterator<WebElement> listIterator = percentage.listIterator();

		while (listIterator.hasNext()) {

			WebElement next = listIterator.next();
			String text = next.getText().replace("%", "");
			list.add(Integer.parseInt(text));
		}
		System.out.println(list);

		Integer min = Collections.min(list);
		System.out.println(min);
		String smallValue = Integer.toString(min);

		String smallValueXpath = "//td[normalize-space()='" + smallValue + "%']//following-sibling::td/input";
		System.out.println(smallValueXpath);
		driver.findElement(By.xpath(smallValueXpath)).click();

		driver.quit();
	}

}
