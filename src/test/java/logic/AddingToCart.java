package logic;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.CreateSession;
import org.openqa.selenium.*;
import pages.FabricPage;

public class AddingToCart {

    FabricPage fabricPage;
    SearchContext shadowRoot;
    WebDriver driver;
    WebElement nextButton;


    public AddingToCart(){
        driver = CreateSession.getWebDriver();
        fabricPage = new FabricPage(driver);
        }

    public SearchContext initializeShadowRoot(){

        WebElement cmtmroot = driver.findElement(By.tagName("cmtm-root"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        SearchContext element = cmtmroot.getShadowRoot();
        return  element;
    }

    @Given("^launch the application with \"([^\"]*)\"$")
    public void launchTheApplicationWith(String url) {
        fabricPage.get(url);
    }


    @Then("^click on menu$")
    public void clickOnMenu() throws InterruptedException {
        fabricPage.waitForPageToLoad("Home Page");
        fabricPage.findElement(fabricPage.menuButton).click();
        fabricPage.waitForPageToLoad("Home Page1");
        fabricPage.waitForVisibility(fabricPage.clothingButton);
        fabricPage.findElement(fabricPage.clothingButton).click();
        fabricPage.waitForPageToLoad("Home Page2");
        fabricPage.waitForVisibility(fabricPage.jacketLink);
        fabricPage.findElement(fabricPage.jacketLink).click();
        fabricPage.waitForUrlContains("/custommade?");
        fabricPage.waitForPageToLoad("Home Page3");
        /*if(fabricPage.waitForElementVisibility(fabricPage.closeButtonParent)){
            fabricPage.findElement(fabricPage.closeButtonParent).click();
        }
        WebElement shadowFooterRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot),fabricPage.panelFooter);
        WebElement nextButton = fabricPage.shadowRootElement(shadowFooterRoot,fabricPage.nextButton);
        nextButton.click();*/
        //fabricPage.waitForPageToLoad("Home Page 4");
        /*WebElement titleRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot),fabricPage.panelSection);
        if(fabricPage.isChildElementFound(titleRoot,fabricPage.jacketSection)){
            WebElement title = fabricPage.shadowRootElement(titleRoot.findElement(fabricPage.sideTitle),fabricPage.title);
            if(title.getText().equals("Your style")){
                nextButton.click();
            }
            else{
                System.out.println("failed");
            }
        }*/
        //System.out.println("Done");

//        shadowRoot = initializeShadowRoot();
//        WebElement getPanel = shadowRoot.findElement(By.cssSelector("div.panel"));
//        WebElement getFooter = getPanel.findElement(By.tagName("ss-side-sticky"));
//        System.out.println("Done");

    }

    @And("^select fabric$")
    public void selectFabric() throws InterruptedException {

        WebElement shadowPanelRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot),fabricPage.configuration);
        fabricPage.waitForChildLoader(shadowPanelRoot);
        if(fabricPage.waitForElementVisibility(fabricPage.closeButtonParent)){
            fabricPage.findElement(fabricPage.closeButtonParent).click();
        }
        WebElement shadowFooterRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot),fabricPage.panelFooter);
        WebElement nextButton = fabricPage.shadowRootElement(shadowFooterRoot,fabricPage.nextButton);
        nextButton.click();

    }

    @And("^select the style$")
    public void selectTheStyle() throws InterruptedException {

        WebElement titleRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot),fabricPage.panelSection);
        fabricPage.waitForChildLoader(titleRoot);
        WebElement shadowFooterRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot),fabricPage.panelFooter);
        WebElement nextButton = fabricPage.shadowRootElement(shadowFooterRoot,fabricPage.nextButton);
        if(fabricPage.isChildElementFound(titleRoot,fabricPage.jacketSection)) {
            WebElement title = fabricPage.shadowRootElement(titleRoot.findElement(fabricPage.sideTitle), fabricPage.title);
            if (title.getText().equals("Your style")) {
               nextButton.click();
            } else {
                System.out.println("failed");
            }
        }

    }

    @And("^choose the size$")
    public void chooseTheSize() {

        WebElement titleRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot),fabricPage.panelSection);
        fabricPage.waitForChildLoader(titleRoot);
        WebElement sizeSection = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), (By.ByCssSelector) fabricPage.guardShadow);
        WebElement sideViewerRoot = fabricPage.shadowRootElement(sizeSection.findElement(fabricPage.entryPageShadow),fabricPage.sideViewer);
        fabricPage.waitForElementVisibility(sideViewerRoot.findElement(fabricPage.getStarted));
        sideViewerRoot.findElement(fabricPage.getStarted).click();
        //WebElement getStartedButton = fabricPage.shadowRootElement(sideViewerRoot.findElement(fabricPage.getStarted))
        //sideViewerRoot.click();

        sideViewerRoot.findElement(fabricPage.selectSizeDropdown).click();

        WebElement sizeEditorRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), (By.ByCssSelector) fabricPage.editorShadow);
        WebElement sizePicker = fabricPage.shadowRootElement(sizeEditorRoot.findElement(fabricPage.sizeSelectorRoot), (By.ByCssSelector) fabricPage.selectedSize);
        sizePicker.click();
        System.out.println("Done");

    }
}
