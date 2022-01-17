package login;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gomathi\\eclipse-workspace\\YoungLiving\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://support.google.com/mail/answer/56256?hl=en");
		//driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		//String title = driver.getTitle();
		//System.out.println(title);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Create an account ']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			String title = driver.switchTo().window(string).getTitle();
			System.out.println(title);
		}
		String actualTitle="Create your Google Account";
		for (String string : windowHandles) {
			if(driver.switchTo().window(string).getTitle().equals(actualTitle))
				break;
			
		}
		driver.findElement(By.id("firstName")).sendKeys("hello"); 
				
		}

}
