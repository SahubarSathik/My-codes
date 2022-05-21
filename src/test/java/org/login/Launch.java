package org.login;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
public class Launch extends BaseClass{
	
	
	@Test
	public void question() throws AWTException {
		getDriver("chrome");
		launch("https://www.flipkart.com/");
		implityWait(10);
		WebElement userName = locators("Xpath","//span[contains(text(),'Enter Email/Mobile number')]");
		textSend(userName, "sahubarsathik");
		WebElement password = locators("xpath", "//span[contains(text(),'Enter Password')]");
		rightClk(userName);
		PressKey(KeyEvent.VK_CONTROL);
		PressKey(KeyEvent.VK_C);
		rightClk(password);
		PressKey(KeyEvent.VK_CONTROL);
		PressKey(KeyEvent.VK_V);
	}

}
