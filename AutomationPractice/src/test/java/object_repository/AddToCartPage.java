package object_repository;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import elements.AddToCart;

public class AddToCartPage extends LoginPage{
	
	@Test(dependsOnMethods="login")
	public static void AddToCartPage() throws InterruptedException, AWTException, IOException {
		PageFactory.initElements(driver, AddToCart.class);
		Thread.sleep(3000);
		Actions ac= new Actions(driver);
		ac.moveToElement(AddToCart.linkWomen).build().perform();
		Thread.sleep(3000);
		AddToCart.linkBlouses.click();
		Thread.sleep(3000);
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("(//div[@class='layered_subtitle_heading'])[9]")));
		ac.moveToElement(AddToCart.imgBlouse).build().perform();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Thread.sleep(3000);
		AddToCart.btnAddToCart.click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0]. click();", AddToCart.btnClose);
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//div[@class='nav']")));
		Thread.sleep(3000);
		AddToCart.linkDresses.click();
		Thread.sleep(3000);
		AddToCart.linkEveningDresses.click();
		Thread.sleep(3000);
		AddToCart.imgDress.click();
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		AddToCart.btnAddToCart1.click();
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		JavascriptExecutor jb= (JavascriptExecutor) driver;
		jb.executeScript("arguments[0]. click();", AddToCart.btnClose);
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		jb.executeScript("arguments[0].scrollIntoView()",AddToCart.verifyAddedProduct);
		String productAddedInCart = AddToCart.verifyAddedProduct.getText();
		int cartNumber=Integer.parseInt(productAddedInCart);
		System.out.println("Product added in Cart = "+productAddedInCart);	
		if(cartNumber>0)
		{
			Assert.assertTrue(true);
			System.out.println(productAddedInCart+"  Product Added in cart");
		}
		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage src = robot.createScreenCapture(rect);
		File Destination = new File("C:\\Users\\gomathi\\eclipse-workspace\\AutomationPractice\\Screenshots\\AddToCartPage.png");
		ImageIO.write(src, "png", Destination);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
	}

}
