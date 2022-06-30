package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.CommonMethods;

/**
 * class to interact with page
 *
 * This class has web elements for Custom made jacket designer flow
 */
public class Homepage extends CommonMethods {

	
	public Homepage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public By searchbox = By.name("q");


	public By searchResults = By.xpath("//div[@id='tvcap']//div//div//a");
	public By imagesButton = By.xpath("//a[@data-sc='I']");
	public By imageContainer = By.id("islmp");
	public By nextbutton = By.cssSelector("div > div > div > div:nth-child(2) > ss-button");
	
	
	
	
	
	
	
	
}
