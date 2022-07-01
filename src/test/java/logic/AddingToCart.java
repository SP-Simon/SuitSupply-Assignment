package logic;

import framework.CreateSession;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import pages.FabricPage;

public class AddingToCart {

    FabricPage fabricPage;
    SearchContext shadowRoot;
    WebDriver driver;
    WebElement nextButton;


    public AddingToCart() {
        driver = CreateSession.getWebDriver();
        fabricPage = new FabricPage(driver);
    }

    public SearchContext initializeShadowRoot() {

        WebElement cmtmroot = driver.findElement(By.tagName("cmtm-root"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        SearchContext element = cmtmroot.getShadowRoot();
        return element;
    }

    //Launch the application
    @Given("^launch the application with \"([^\"]*)\"$")
    public void launchTheApplicationWith(String url) {
        fabricPage.get(url);
    }


    //Function to Navigate to Custom made Jacket Screen
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

    }

    @And("^select fabric$")
    public void selectFabric() throws InterruptedException {

        //WebElement shadowPanelRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot),fabricPage.configuration);
        //fabricPage.waitForChildLoader(shadowPanelRoot);
        if (fabricPage.waitForElementVisibility(fabricPage.closeButtonParent)) {
            fabricPage.findElement(fabricPage.closeButtonParent).click();
        }
        WebElement shadowFooterRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.panelFooter);
        WebElement nextButton = fabricPage.shadowRootElement(shadowFooterRoot, fabricPage.nextButton);
        nextButton.click();

    }

    //Function to choose style
    @And("^select the style$")
    public void selectTheStyle() throws InterruptedException {

        WebElement titleRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.panelSection);
        fabricPage.waitForChildLoader(titleRoot);
        WebElement shadowFooterRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.panelFooter);
        WebElement nextButton = fabricPage.shadowRootElement(shadowFooterRoot, fabricPage.nextButton);
        if (fabricPage.isChildElementFound(titleRoot, fabricPage.jacketSection)) {
            WebElement title = fabricPage.shadowRootElement(titleRoot.findElement(fabricPage.sideTitle), fabricPage.title);
            if (title.getText().equals("Your style")) {
                nextButton.click();
            } else {
                System.out.println("failed");
            }
        }

    }

    //Function to choose the desired size
    @And("^choose the size$")
    public void chooseTheSize() throws InterruptedException {

        //Waiting for Page load
        WebElement titleRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.panelSection);
        fabricPage.waitForChildLoader(titleRoot);

        WebElement sizeSection = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), (By.ByCssSelector) fabricPage.guardShadow);
        WebElement sideViewerRoot = fabricPage.shadowRootElement(sizeSection.findElement(fabricPage.entryPageShadow), fabricPage.sideViewer);
        fabricPage.waitForElementVisibility(sideViewerRoot.findElement(fabricPage.getStarted));
        sideViewerRoot.findElement(fabricPage.getStarted).click();

        //Check for page load
        WebElement nextContext = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.sideViewer);
        if (fabricPage.waitForAttributeToBe(nextContext, "class", "active-next")) {
            //Click on Select Size Dropdown Button
            WebElement spEditor = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.spEditor);
            WebElement ssSideViewer = fabricPage.shadowRootElement(spEditor, fabricPage.sideViewer);
            if (fabricPage.isChildElementFound(ssSideViewer, fabricPage.dropDownButtonParent)) {
                WebElement ssButton = ssSideViewer.findElement(fabricPage.dropDownButtonParent);
                fabricPage.waitForElementVisibility(ssButton);
                ssButton.click();
            }

            //Select the desired size from the list
            WebElement spSizePicker = fabricPage.shadowRootElement(spEditor, fabricPage.spSizePicker);
            if (fabricPage.isChildElementFound(spSizePicker, fabricPage.sizeSelectorRoot)) {
                WebElement sizePickerParentRoot = fabricPage.shadowRootElement(spEditor, fabricPage.sizeSelectorRoot);
                WebElement sizePicker = fabricPage.shadowRootElement(sizePickerParentRoot, fabricPage.selectedSize);
                if (fabricPage.waitForElementVisibility(sizePicker)) {
                    sizePicker.click();
                }
            }

            WebElement panelFooter = spSizePicker.findElement(fabricPage.panelFooter);
            WebElement selectSizeButton = fabricPage.shadowRootElement(panelFooter, fabricPage.selectSizeButton);
            fabricPage.waitForElementToBeEnabled(selectSizeButton);
            selectSizeButton.click();
        }
        WebElement spEditor = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.spEditor);
        nextContext = fabricPage.shadowRootElement(spEditor, fabricPage.sideViewer);
        if (fabricPage.waitForAttributeToBe(nextContext, "class", "active-main")) {
            WebElement panelFooter = fabricPage.shadowRootElement(spEditor, fabricPage.panelFooter);
            if (fabricPage.waitForElementVisibility(panelFooter)) {
                WebElement ssButtonSaveAndContinue = fabricPage.shadowRootElement(panelFooter, fabricPage.ssButtonSaveAndContinue);
                fabricPage.waitForElementToBeClickable(ssButtonSaveAndContinue);
                Thread.sleep(2000);
                ssButtonSaveAndContinue.click();
                Thread.sleep(2000);
            }
        }
        spEditor = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.spEditor);
        WebElement spProfileName = fabricPage.shadowRootElement(spEditor, fabricPage.spProfileName);
        WebElement panelFooter = spProfileName.findElement(fabricPage.panelFooter);
        WebElement getMainDiv = fabricPage.shadowRootElement(panelFooter, fabricPage.divFooterMain);
        if (fabricPage.isChildElementFound(getMainDiv,fabricPage.applyButton)) {
            getMainDiv.findElement(fabricPage.applyButton);
            Thread.sleep(2000);
            getMainDiv.click();
        }


        System.out.println("Done");


        //Click on Save & Continue button


//        //Enter Name and save Profile
//        ssSideViewer.findElement(fabricPage.saveProfileInput).sendKeys("test");
//        //WebElement applyButton = fabricPage.shadowRootElement(selectSizeRoot,fabricPage.applyButton);
//
//        System.out.println("Done");


    }

    //Function to cart
    @And("^add to cart$")
    public void addToCart() {

        WebElement shadowFooterRoot = fabricPage.shadowRootElement(fabricPage.findElement(fabricPage.cmtmRoot), fabricPage.panelFooter);
        WebElement addButton = fabricPage.shadowRootElement(shadowFooterRoot, fabricPage.addButton);
        addButton.click();
        fabricPage.waitForUrlContains("/cart");
        fabricPage.waitForPageToLoad("Cart");
        System.out.println("Done");
    }
}
