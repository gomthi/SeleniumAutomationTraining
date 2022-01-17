package object_repository;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import elements.CreateAccount;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CreateAccountPage {
	
	public static WebDriver driver;
	public static Workbook w;
	public static Sheet s;
	@BeforeClass
	public static void browserLaunch() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\gomathi\\eclipse-workspace\\AutomationPractice\\src\\test\\java\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String driverName = prop.getProperty("driverName");
		String driverPath = prop.getProperty("path");
		String url = prop.getProperty("url");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(driverName, driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(driverName, driverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
		}
		else {
			System.setProperty(driverName, driverPath);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
		}
		
	}
	/*@AfterClass
	public static void browserClose() {
		driver.close();
	}*/
	
	@BeforeMethod
	public static void dataDriven() throws BiffException, IOException {
		w=Workbook.getWorkbook(new File("C:\\Users\\gomathi\\eclipse-workspace\\AutomationPractice\\src\\test\\java\\data.xls"));
		s=w.getSheet("Sheet1");
		
		
	}
	
	@Test()
	public static void createAccount() throws AWTException, IOException {
		
			String username = s.getCell(0,1).getContents();
			//System.out.println(username);
			String firstname = s.getCell(1, 1).getContents();
			//System.out.println(firstname);
			String lastname = s.getCell(2, 1).getContents();
			String password = s.getCell(3, 1).getContents();
			String date = s.getCell(4, 1).getContents();
			String month = s.getCell(5, 1).getContents();
			String year = s.getCell(6, 1).getContents();
			String address = s.getCell(7, 1).getContents();
			String city = s.getCell(8, 1).getContents();
			String state = s.getCell(9, 1).getContents();
			String zipcode = s.getCell(10, 1).getContents();
			String country = s.getCell(11, 1).getContents();
			String mobile = s.getCell(12, 1).getContents();
			
			
		PageFactory.initElements(driver, CreateAccount.class);
		CreateAccount.txtEmail.sendKeys(username);
		CreateAccount.btnCreateAccount.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		CreateAccount.optionGender.click();
		CreateAccount.txtFirstName.sendKeys(firstname);
		CreateAccount.txtLastName.sendKeys(lastname);
		CreateAccount.txtPassword.sendKeys(password);
		Select s1 = new Select(CreateAccount.dropDownDay);
		s1.selectByValue(date);
		
		Select s2= new Select(CreateAccount.dropDownMonth);
		s2.selectByIndex(7);
		
		Select s3 = new Select(CreateAccount.dropDownYear);
		s3.selectByValue(year);
		
		CreateAccount.txtAddress.sendKeys(address);
		CreateAccount.txtCity.sendKeys(city);
		
		Select s4= new Select(CreateAccount.dropDownState);
		s4.selectByVisibleText(state);
		
		CreateAccount.txtZipcode.sendKeys(zipcode);
		Select s5 = new Select(CreateAccount.dropDownCountry);
		s5.selectByVisibleText(country);
		
		CreateAccount.txtMobileNumber.sendKeys(mobile);
		CreateAccount.btnSubmit.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage src = robot.createScreenCapture(rect);
		File Destination = new File("C:\\Users\\gomathi\\eclipse-workspace\\AutomationPractice\\Screenshots\\AccountCreatedPage.png");
		ImageIO.write(src, "png", Destination);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		CreateAccount.btnSignout.click();
		}
		
	
	
}
