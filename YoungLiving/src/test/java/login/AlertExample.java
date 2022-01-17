package login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gomathi\\eclipse-workspace\\YoungLiving\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Thread.sleep(3000);
		WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
		//js.executeScript("arguments[0].value='mobile'", txtSearch);
		txtSearch.sendKeys("mobile");
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		
		WebElement txtDiscount = driver.findElement(By.xpath("//span[text()='Discount']"));
		js.executeScript("arguments[0].scrollIntoView(true)",txtDiscount);
		
		Thread.sleep(5000);
		WebElement txtBrand = driver.findElement(By.xpath("//span[text()='Brand']"));
		js.executeScript("arguments[0].scrollIntoView(false)",txtBrand);
		
	}

}
