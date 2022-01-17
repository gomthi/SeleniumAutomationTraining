package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart {

	@FindBy(xpath="//a[@title='Women']")
	public static WebElement linkWomen;
	
	@FindBy(linkText="Blouses")
	public static WebElement linkBlouses;
	
	@FindBy(xpath="(//img[@class='replace-2x img-responsive'])[2]")
	public static WebElement imgBlouse;
	
	@FindBy(linkText="Add to cart")
	public static WebElement btnAddToCart;
	
	@FindBy(xpath="//div[@class='clearfix']/div/span")
	public static WebElement btnClose;
	
	@FindBy(xpath="//a[@title='View my shopping cart']/span[1]")
	public static WebElement verifyAddedProduct;
	
	@FindBy(xpath="(//a[@title='Dresses'])[2]")
	public static WebElement linkDresses;
	
	@FindBy(xpath="(//a[@title='Evening Dresses'])[3]")
	public static WebElement linkEveningDresses;
	
	@FindBy(xpath="//img[@title='Printed Dress']")
	public static WebElement imgDress;
	
	@FindBy(xpath="//p[@id='add_to_cart']/button")
	public static WebElement btnAddToCart1;
	
	
	
}
