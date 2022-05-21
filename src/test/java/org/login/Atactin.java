package org.login;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Atactin extends BaseClass{
	@FindBy(id="username")
	public static WebElement username;
	@FindBy(id="password")
	public static WebElement password;
	@FindBy(id="login")
	public static WebElement login;
	@FindBy(id="location")
	public static WebElement Location;
	@FindBy(id="hotels")
	public static WebElement Hotels ;
	@FindBy(id="room_type")
	public static WebElement RoomType;
	@FindBy(id="room_nos")
	public static WebElement NumberofRooms;
	@FindBy(id="datepick_in")
	public static WebElement  CheckInDate;
	@FindBy(id="datepick_out")
	public static WebElement CheckOutDate;
	@FindBy(id="adult_room")
	public static WebElement AdultsperRoom;
	@FindBy(id="child_room")
	public static WebElement ChildrenperRoom;
	
	public static WebElement Submit;
	public static WebElement radiobutton_0;
	@FindBy(id="continue")
	public static WebElement continueButton;
	
	public static WebElement first_name;
	public static WebElement last_name;
	public static WebElement address;
	public static WebElement cc_num;
	public static WebElement cc_type;
	public static WebElement cc_exp_month;
	public static WebElement cc_exp_year;
	public static WebElement cc_cvv;
	public static WebElement book_now;
	public static WebElement order_no;
	
	
	
	
	@Test
	private void login() throws IOException, InvalidFormatException, AWTException {
		getDriver("chrome");
		launch("http://adactinhotelapp.com/index.php");
		
		
		implityWait(10);
		File f = new File("C:\\Users\\Sathik\\eclipse-workspace\\login\\test_data\\workbook1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		 XSSFWorkbook book= new XSSFWorkbook(f);
		 XSSFSheet sheet = book.getSheet("sheet1");
		 
		 XSSFRow row = sheet.getRow(0);
		 XSSFCell cell = row.getCell(0);
		 DataFormatter dft =new DataFormatter();
		 String value = dft.formatCellValue(cell);
		 XSSFCell cell1 = row.getCell(1);
		 String value1 = dft.formatCellValue(cell1);
		 PageFactory.initElements(driver, this);
		 textSend(username, value);
		 textSend(password, value1);
		 buttonClick(login);
		 selectByIndexMethod(Location, 1);
		 selectByValueMethod(Hotels, "Hotel Sunshine");
		 selectByIndexMethod(RoomType, 3);
		 selectByValueMethod(NumberofRooms, "3");
		 buttonClick(CheckInDate);
		 PressKey(KeyEvent.VK_CONTROL);
		 PressKey(KeyEvent.VK_A);
		 ReleaseKey(KeyEvent.VK_CONTROL);
		 ReleaseKey(KeyEvent.VK_V);
		 textSend(CheckInDate, "20/08/2022");
		 buttonClick(CheckOutDate);
		 PressKey(KeyEvent.VK_CONTROL);
		 PressKey(KeyEvent.VK_A);
		 ReleaseKey(KeyEvent.VK_CONTROL);
		 ReleaseKey(KeyEvent.VK_V);
		 textSend(CheckOutDate, "25/08/2022");
		 selectByIndexMethod(AdultsperRoom, 3);
		 selectByIndexMethod(ChildrenperRoom, 3);
		 buttonClick(Submit);
		 buttonClick(radiobutton_0);
		 buttonClick(continueButton);
		 textSend(first_name, "Sahubar");
		 textSend(last_name, "Sathik");
		 textSend(address, "Tamilnadu");
		 textSend(cc_num, "1234567891234567");
		 selectByIndexMethod(cc_type, 2);
		 selectByValueMethod(cc_exp_month, "5");
		 selectByValueMethod(cc_exp_year, "2022");
		 textSend(cc_cvv, "123");
		 buttonClick(book_now);
		// getText(order_no);
		locators("id", "my_itinerary").click();
		List<WebElement> table = driver.findElements(By.tagName("tr"));
		
		 
	}
	

}
