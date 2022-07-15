package org.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xddf.usermodel.text.UnderlineType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Tables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebElement findElement;
	public static Actions act;
	public static Robot r;
	public static Select toSelect;

	public static WebDriver getDriver(String browser) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

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
		return driver;

	}

	public static void launch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void wait1() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static WebElement locators(String locator, String value) {
		if (locator.equals("id")) {
			findElement = driver.findElement(By.id(value));
			return findElement;
		} else if (locator.equals("name")) {
			findElement = driver.findElement(By.name(value));
			return findElement;
		} else if (locator.equals("className")) {
			findElement = driver.findElement(By.className(value));
			return findElement;
		} else if (locator.equals("linkText")) {
			findElement = driver.findElement(By.linkText(value));
			return findElement;
		} else if (locator.equals("tagName")) {
			findElement = driver.findElement(By.tagName(value));
			return findElement;
		} else if (locator.equals("xpath")) {
			findElement = driver.findElement(By.xpath(value));
			return findElement;
		}
		return findElement;
	}

	public static void textSend(WebElement refName, String textValue) {
		refName.sendKeys(textValue);
	}

	public static void buttonClick(WebElement refName) {
		refName.click();
	}

	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void getText(WebElement refName) {
		String text = refName.getText();
		System.out.println(text);
	}

	public static void getAttribute(WebElement refName, String value) {

		String attribute = refName.getAttribute(value);
		System.out.println(attribute);
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);

	}

	public static void navigateBack() {
		driver.navigate().back();

	}

	public static void navigateForward() {
		driver.navigate().forward();

	}

	public static void navigateRefresh() {
		driver.navigate().refresh();

	}

	public static void courseOver(WebElement refName) {
		act = new Actions(driver);
		act.moveToElement(refName).perform();
	}

	public static void rightClk(WebElement refName) {
		act = new Actions(driver);
		act.contextClick(refName).perform();

	}

	public static void doubleClk(WebElement refName) {
		act = new Actions(driver);
		act.doubleClick(refName).perform();

	}

	public static void dgAndDp(WebElement refName) {
		act = new Actions(driver);
		act.dragAndDrop(refName, refName).perform();

	}

	public static void robotClass(int KeyEvent, int size) throws AWTException {
		r = new Robot();

		for (int i = 0; i < size; i++) {

			r.keyPress(KeyEvent);
			r.keyRelease(KeyEvent);
		}

	}

	public static void PressAndRelease(int KeyEvent) throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent);
		r.keyRelease(KeyEvent);
	}

	public static void PressKey(int KeyEvent) throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent);
		r.keyPress(KeyEvent);
	}

	public static void ReleaseKey(int KeyEvent) throws AWTException {
		r = new Robot();
		r.keyRelease(KeyEvent);
		r.keyRelease(KeyEvent);
	}

	// Sendkeys Using JavaScript
	public static void textSendJavaSc(String value, WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	// getAttribute Using JavaScript
	public static void getAttributeJavaScript(WebElement refName) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		Object executeScript = jk.executeScript("return arguments[0].getttribute('value')", refName);
		System.out.println(executeScript);
	}

	// click using JavaScript
	public static void textSendJavaSc(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].click()", element);
	}

	// scroll Down using JavaScript
	public static void scrollDownJavaSc(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// scroll Up using JavaScript
	public static void scrollUpJavaSc(WebElement element) {
		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}

	public static void promptAlert(String value) {
		Alert text = driver.switchTo().alert();
		text.sendKeys(value);
		text.accept();
	}

	public static boolean isMultipleValue(WebElement refname) {
		toSelect = new Select(refname);
		boolean multiple = toSelect.isMultiple();
		System.out.println(multiple);
		return multiple;
	}

	public static List<WebElement> options(WebElement refname) {
		toSelect = new Select(refname);
		List<WebElement> options = toSelect.getOptions();
		System.out.println(options.size());
		for (WebElement list : options) {
			String text = list.getText();
			System.out.println(text);
		}
		return options;
	}

	public void deselectAllMethod(WebElement refname) {
		toSelect = new Select(refname);
		toSelect.deselectAll();

	}

	public void selectByIndexMethod(WebElement refname, int index) {
		toSelect = new Select(refname);
		toSelect.selectByIndex(index);
	}

	public void selectByVisibleTextMethod(WebElement refname, String text) {
		toSelect = new Select(refname);
		toSelect.selectByVisibleText(text);
	}

	public void selectByValueMethod(WebElement refname, String value) {
		toSelect = new Select(refname);
		toSelect.selectByValue(value);
	}

	public void deselectByValueMethod(WebElement refname, String value) {
		toSelect = new Select(refname);
		toSelect.deselectByValue(value);
	}

	public void deselectByVisibleTextMethod(WebElement refname, String text) {
		toSelect = new Select(refname);
		toSelect.deselectByVisibleText(text);
	}

	public void deselectByIndexMethod(WebElement refname, int index) {
		toSelect = new Select(refname);
		toSelect.deselectByIndex(index);
	}

	public List<WebElement> getAllSelectOPtionsMethod(WebElement refname, int index) {
		toSelect = new Select(refname);
		List<WebElement> allSelectedOptions = toSelect.getAllSelectedOptions();
		for (int i = 0; i < allSelectedOptions.size(); i++) {
			WebElement webElement = allSelectedOptions.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}

		return allSelectedOptions;
	}

	public WebElement getFirstSelectedOptionMethod(WebElement refname) {
		toSelect = new Select(refname);
		WebElement firstSelectedOption = toSelect.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);
		return firstSelectedOption;
	}

	public static void implityWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

	}

	public static void screenshot(String location) throws IOException {
		TakesScreenshot tks = (TakesScreenshot) driver;
		File defaultLocation = tks.getScreenshotAs(OutputType.FILE);
		System.out.println(defaultLocation);
		FileUtils.copyFile(defaultLocation, new File(location));
	}

	public static Properties getDataFromProperty() throws IOException {
		// To get location of the file
		File file = new File(
				"C:\\Users\\Sathik\\eclipse-workspace\\login\\src\\test\\resources\\loginDataPropery.properties");
		// To get file read
		FileReader fileReader = new FileReader(file);

		// For Reading the Property File
		Properties properties = new Properties();
		// To load the Property File
		properties.load(fileReader);

		return properties;
	}

	public static String getKeyFromProperyFile(String key) throws IOException {
		String string = getDataFromProperty().get(key).toString();
		return string;

	}

}
