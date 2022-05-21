package org.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCases extends BaseClass{
	@FindBy(xpath="//u[contains(text(),'Greens Technologys Software Training Centers in Chennai')]")
	public static WebElement lastLine;
	
	@FindBy(xpath="//h1[contains(text(),'Placements')]")
	public static WebElement firstline;
	
	@FindBy(xpath="//a[text()='Certifications']")
	public static WebElement certification;
	
	@FindBy(xpath = "//a[starts-with(@href,'selenium')]")
	public static WebElement selenium;
	
	@FindBy(xpath = "//a[contains(text(),'TESTIMONIALS')]")
	public static WebElement testimoials;
	
	@FindBy(xpath = "/html/body/div[2]/div")
	public static WebElement print;
	
	
	@Test
	private void note1() {
		getDriver("chrome");
		launch("http://www.greenstechnologys.com/index.html");
		PageFactory.initElements(driver, this);
		
		scrollDownJavaSc(lastLine);
		getText(lastLine);
		
		scrollUpJavaSc(firstline);
		getText(firstline);
		
		buttonClick(certification);
		buttonClick(selenium);		
		buttonClick(testimoials);
		getText(print);

	}
	
		

		
		
		
		
		
		
		
	
	
}
