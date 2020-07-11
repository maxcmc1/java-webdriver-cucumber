package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getActions;
import static support.TestContext.getDriver;

public class UspsHeader extends Page {

    @FindBy(xpath = "//a[@id='mail-ship-width']")
    private WebElement mailAndShip;

    @FindBy(xpath = "//li[@class='tool-zip']//a")
    private WebElement lookUpZipCode;

    @FindBy(xpath = "//a[@role='menuitem'][text()='Calculate a Price']")
    private WebElement calculatePrice;

    @FindBy(xpath = "//li[@class='tool-find']//a")
    private WebElement findUspsLocation;

    private WebElement tabWebElement(String tabItem){
        return getDriver().findElement(By.xpath("//a[@role='menuitem'][text()='" + tabItem + "']"));
    }

    @FindBy(xpath = "//li[contains(@class,'nav-search')]")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@id='global-header--search-track-search']")
    private WebElement searchInput;

    @FindBy(xpath = "//li[@class='menuheader']/a[contains(@href,'manage/')]")
    private WebElement trackAndManage;


    public UspsTrackAndManagePage openTrackAndManageNewWindow(){
        getActions()
                .moveToElement(trackAndManage)
                .keyDown(Keys.COMMAND)
                .click()
                .keyUp(Keys.COMMAND)
                .perform();

        return new UspsTrackAndManagePage();

    }

    public void sendingText(String textInput) {

        mouseOver(searchIcon);
        searchInput.sendKeys(textInput + Keys.RETURN);

    }


    public UspsMailAndShipPage openMailAndShipInNewWindow(){
        getActions()
                .moveToElement(mailAndShip)
                .keyDown(Keys.COMMAND)
                .click()
                .keyUp(Keys.COMMAND)
                .perform();

        return new UspsMailAndShipPage();

    }


    public void navigateToLandPageTabs(String tab){

            switch (tab) {
                case "Help":
                    click(tabWebElement("Help"));
                    break;
                case "International":
                    click(tabWebElement("International"));
                    break;
                case "Business":
                    click(tabWebElement("Business"));
                    break;
                case "Postal Store":
                    click(tabWebElement("Postal Store"));
                    break;
                case "Track & Manage":
                    click(tabWebElement("Track & Manage"));
                    break;
                case "Mail & Ship":
                    click(tabWebElement("Mail & Ship"));
                    break;
                case "Quick Tools":
                    click(tabWebElement("Quick Tools"));
                    break;
                case "Search USPS.com":
                    click(tabWebElement("Search USPS.com"));
                    break;
                case "Every Door Direct Mail":
                    click(tabWebElement("Every Door Direct Mail"));
                    break;
                default:
                    throw new RuntimeException("Unknown menu item: " + tab);

            }

    }

    public void navigateToLandPageTabsByMouseOver(String tab){

        switch (tab){
            case "Help":
                mouseOver(tabWebElement("Help"));
                break;
            case "International":
                mouseOver(tabWebElement("International"));
                break;
            case "Business":
                mouseOver(tabWebElement("Business"));
                break;
            case "Postal Store":
                mouseOver(tabWebElement("Postal Store"));
                break;
            case "Track & Manage":
                mouseOver(tabWebElement("Track & Manage"));
                break;
            case "Mail & Ship":
                mouseOver(tabWebElement("Mail & Ship"));
                break;
            case "Quick Tools":
                mouseOver(tabWebElement("Quick Tools"));
                break;
            case "Search USPS.com":
                mouseOver(tabWebElement("Search USPS.com"));
                break;
            case "Every Door Direct Mail":
                mouseOver(tabWebElement("Every Door Direct Mail"));
                break;
            default:
                throw new RuntimeException("Unknown menu item: " + tab);

        }

    }


    public UspsMailAndShipPage clickMailAndShip(){
        click(mailAndShip);
        return new UspsMailAndShipPage();
    }


    public UspsMailAndShipPage mouseOverMailAndShip(){
        click(lookUpZipCode);
        return new UspsMailAndShipPage();
    }


    public PostagePriceCalculator mouseOverCalculatePrice(){
        mouseOver(mailAndShip);
        click(calculatePrice);
        return new PostagePriceCalculator();
    }

    public FindLocations navigatingToFindLocationPage(){
        mouseOver(mailAndShip);
        click(findUspsLocation);
        return new FindLocations();
    }




}
