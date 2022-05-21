package org.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PropertyFileMethod extends BaseClass{
	

	
	
	
	@Test
	private void getProperty() throws IOException {

		String browser = getKeyFromProperyFile("browser");
		getDriver(browser);
		String url = getKeyFromProperyFile("url");
		launch(url);
		locators("id", "email").sendKeys(getKeyFromProperyFile("username"));
		locators("name", "pass").sendKeys(getKeyFromProperyFile("password"));
//		String username = getKeyFromProperyFile("username");
//		String password = getKeyFromProperyFile("password");
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
