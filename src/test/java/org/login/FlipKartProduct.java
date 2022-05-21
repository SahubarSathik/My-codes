package org.login;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipKartProduct {

	@Test
	private void ascendingRupees() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//button[.='✕']")).click();

		driver.findElement(By.tagName("input")).sendKeys("iphone 13", Keys.ENTER);
		
		ArrayList<String> mobileNames = new ArrayList<String>();

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (WebElement mobileName : findElements) {

			String name = mobileName.getText();
			mobileNames.add(name);

		}

		List<WebElement> findElements2 = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		ArrayList<Integer> prices = new ArrayList<Integer>();

		for (WebElement mobilePrice : findElements2) {
			String price = mobilePrice.getText().replace("₹", "").replace(",", "");
			prices.add(Integer.parseInt(price));

		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < mobileNames.size(); i++) {
			map.put(mobileNames.get(i), prices.get(i));
		}

		// map.forEach((k,v)->System.out.println(k+"\t"+v));
		// map.forEach((k,v)->System.out.println(k+"\t"+v));
		List<Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, (o1, o2) -> {
			return o1.getValue().compareTo(o2.getValue());
		});

		list.forEach(s -> System.err.println(s.getKey() + "\t" + s.getValue()));
		//Iterator<Entry<String, Integer>> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			Entry<String, Integer> next = iterator.next();
//			System.out.println(next.getKey() + "\t" + next.getValue());
//
//		}
		driver.quit();
	}

}
