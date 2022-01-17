package object_repository;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import elements.Login;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginPage extends CreateAccountPage{
	
	@Test()
	public static void login() throws IOException, AWTException, BiffException
	{
		w=Workbook.getWorkbook(new File("C:\\Users\\gomathi\\eclipse-workspace\\AutomationPractice\\src\\test\\java\\data.xls"));
		s=w.getSheet("Sheet1");
		String username = s.getCell(0,1).getContents();
		String password = s.getCell(3, 1).getContents();
		
		PageFactory.initElements(driver, Login.class);
		Login.txtUserName.sendKeys(username);
		Login.txtPassword.sendKeys(password);
		Robot robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage src = robot.createScreenCapture(rect);
		File Destination = new File("C:\\Users\\gomathi\\eclipse-workspace\\AutomationPractice\\Screenshots\\LoginPage.png");
		ImageIO.write(src, "png", Destination);
		Login.btnLogin.click();
	}

}
