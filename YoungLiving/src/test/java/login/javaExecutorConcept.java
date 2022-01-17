package login;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class javaExecutorConcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gomathi\\eclipse-workspace\\YoungLiving\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));
		js.executeScript("arguments[0].value='mobiles'",txtSearch);
		
		Thread.sleep(3000);
		WebElement btnSearch = driver.findElement(By.id("nav-search-submit-button"));
		js.executeScript("arguments[0].click()", btnSearch);
		
		Thread.sleep(5000);
		WebElement txtRecentSearch = driver.findElement(By.xpath("//span[text()='Related searches']"));
		js.executeScript("arguments[0].scrollIntoView(true)",txtRecentSearch);
		
		Thread.sleep(5000);
		WebElement txtMobile = driver.findElement(By.xpath("//span[text()='\"mobiles\"']"));
		js.executeScript("arguments[0].scrollIntoView(false)",txtMobile);
		
		
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\ScreenShots\\Amazon.jpg");
	    FileHandler.copy(source, destination);
		
		
		

	}

}
