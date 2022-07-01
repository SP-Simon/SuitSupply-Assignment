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
    public By.ByCssSelector dropDownButtonParent = (By.ByCssSelector) By.cssSelector("ss-button[automation-key-filter-id=\"SP_SelectSize\"]");//drop down for select size parent
    public By.ByCssSelector dropDownButton = (By.ByCssSelector) By.cssSelector("div[class=\"button\"]");//drop down for select size
    public By.ByCssSelector ssButtonSaveAndContinue = (By.ByCssSelector) By.cssSelector("ss-button[title=\"Save & Continue\"]");//Bottom Save & Continue button parent
    public By.ByCssSelector saveAndContinue = (By.ByCssSelector) By.cssSelector("span");//Bottom Save & Continue button
    public By.ByCssSelector spEditor = (By.ByCssSelector) By.cssSelector("sp-editor");//second shadowroot in size page

    //Size picker page
    public By.ByCssSelector sizeSelectorRoot = (By.ByCssSelector) By.cssSelector("ss-size-selector");//root element for size selector shadow
    public By.ByCssSelector selectedSize = (By.ByCssSelector) By.cssSelector("ss-button[title=\"42\"]");//desired size button/tile
    //public By.ByCssSelector lastSizeRoot = (By.ByCssSelector) By.cssSelector("ss-button:last-of-type");
    public By.ByCssSelector selectSizeButton = (By.ByCssSelector) By.cssSelector("ss-button[type='submit']"); // Bottom Select Size button

    //Save Profile Page
    public By.ByCssSelector saveProfileInputRoot = (By.ByCssSelector) By.cssSelector("ss-input-wrap");//root element for profile input shadow
    public By.ByCssSelector saveProfileInput = (By.ByCssSelector) By.cssSelector("input");
    public By.ByCssSelector applyButton = (By.ByCssSelector) By.cssSelector("ss-button[automation-key-filter-id='SP_Apply']"); // Bottom Select Size button
    public By.ByCssSelector addButton = (By.ByCssSelector) By.cssSelector("ss-button[title='Add']");// Add button

    //Cart Page
    public By summarySection = By.cssSelector("cmtm-section[data-id='SummarySection']");
    public By checkoutButton = By.xpath("//a[contains(text(),'Checkout')]");//checkout button
    public By productDetails = By.xpath("//div[@class='product-card__details']");
    public By removeFromCartButton = By.xpath("//div[@class='product-card__header']//button[@type='button']");

    //To wait for page load
    public By.ByCssSelector nextContext = (By.ByCssSelector) By.cssSelector("div[class='next-content'']");
    public By cmtmModifier = By.tagName("cmtm-modifier");
    public By.ByCssSelector spSizePicker = (By.ByCssSelector) By.cssSelector("sp-size-picker");
    public By.ByCssSelector divFooterMain = (By.ByCssSelector) By.cssSelector("div[class='width-wrapper']");
    public By.ByCssSelector spProfileName = (By.ByCssSelector) By.cssSelector("sp-profile-name");







}
