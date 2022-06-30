package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * class to interact with page
 *
 * This class has web elements required for the custom made jacket designer flow
 */

public class FabricPage extends CommonMethods {

    public FabricPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    //Navigation menu
    public By clothingButton = By.xpath("//button[text()='Custom Made']");
    public By menuButton = By.xpath("//button[@aria-label='Toggle navigation']");
    public By jacketLink = By.xpath("//div[@automation-key-category-id='custom-made_jackets']//a[contains(text(),'Jacket')]");

    //Fabric selection page
    public By.ByCssSelector configuration = (By.ByCssSelector) By.cssSelector("cmtm-configurator");
    public By closeButtonParent = By.tagName("ss-button");//close button for pop up in image section
    public By cmtmRoot = By.tagName("cmtm-root");//root element  for shadow root1
    public By.ByCssSelector panelFooter = (By.ByCssSelector) By.cssSelector("ss-side-sticky");//bottom panel for buttons
    public By.ByCssSelector nextButton = (By.ByCssSelector) By.cssSelector("ss-button[title='Next']");// Next button
   //Style Selection page
    public By.ByCssSelector panelSection = (By.ByCssSelector) By.cssSelector("section");// main panel section in page
    public By.ByCssSelector sideTitle = (By.ByCssSelector) By.cssSelector("ss-side-title");//root for shadow element
    public By.ByCssSelector title = (By.ByCssSelector) By.cssSelector("h1");// page section header
    public By jacketSection = By.cssSelector("cmtm-section[data-id='JacketSection']");

    //Size Page
    //public By sizeSection =  By.cssSelector("cmtm-section[data-id='SizeSection']");//root element for first shadow root
    public By guardShadow = (By.ByCssSelector) By.cssSelector("cmtm-guard");
    public By.ByCssSelector entryPageShadow = (By.ByCssSelector) By.cssSelector("sp-entry-page");//root element for second shadow root
    public By.ByCssSelector sideViewer = (By.ByCssSelector) By.cssSelector("ss-side-viewer");//root element for third shadow root
    public By.ByCssSelector getStarted = (By.ByCssSelector) By.cssSelector("ss-button[title='Get started']");//Get started button

    //Size Selector Page
    //public By.ByCssSelector
    public By.ByCssSelector headerSelectSize = (By.ByCssSelector) By.cssSelector("h2");
    public By.ByCssSelector selectSizeDropdown = (By.ByCssSelector) By.cssSelector("ss-button[title='Select size']");//drop down for select size
    public By.ByCssSelector saveAndContinue = (By.ByCssSelector) By.cssSelector("ss-button[title='Save & Continue']");//Bottom Save & Continue button
    public By.ByCssSelector editorShadow = (By.ByCssSelector) By.cssSelector("sp-editor");//second shadowroot in size page
    public By.ByCssSelector sizeSelectorRoot = (By.ByCssSelector) By.cssSelector("ss-size-selector");//root element for size selector shadow
    public By.ByCssSelector selectedSize = (By.ByCssSelector) By.cssSelector("ss-button[title='42']");
    public By.ByCssSelector selectSize = (By.ByCssSelector) By.cssSelector("ss-button[title='Select size']"); // Bottom Select Size button





}
