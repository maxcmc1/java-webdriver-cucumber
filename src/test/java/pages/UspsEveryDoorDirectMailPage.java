package pages;

import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UspsEveryDoorDirectMailPage extends UspsHeader{

    public UspsEveryDoorDirectMailPage() {

        url = "https://eddm.usps.com/eddm/customer/routeSearch.action";
    }

    @FindBy(xpath = "//input[@id='address']")
    private WebElement searchAddressInput;

    @FindBy(xpath = "//button[contains(@class,'icon-search')]")
    private WebElement searchIconButton;

    @FindBy(xpath = "//div[@id='eddm_overlay-progress']")
    private WebElement overLayLoad;

    private WebElement webElementButton(String button){
        return getDriver().findElement(By.xpath("//div[@id='route-table']//a[contains(text(),'" + button + "')]"));
    }

    @FindBy(xpath = "//div[@id='modal-box-closeModal']")
    private WebElement modalWindow;

    @FindBy(xpath = "//a[contains(@class,'totalsArea')]")
    private WebElement totalCountString;

    // find current element list on the page
    @FindBy(xpath = "//td[@idx='7']")
    private  List<WebElement>  costList;

    @FindBy(xpath = "//span[@class='approx-cost']")
    private WebElement expectedTotalCostString;


    public String getExpectedTotalCostStringText(){
        return expectedTotalCostString.getText();
    }

    // find current element list on the page
    public  List<WebElement> getCostList(){
        return costList;
    }

    public String getTotalCountStringText(){
        return totalCountString.getText();
    }


    public void getSummaryOfAllRows() {
                // initially we have not all elements (25 elements)
        // we need to scroll to the last element so more of them loaded (infinite scroll)
        // we get the number of total expected elements
        int totalCountInt = Integer.parseInt(getTotalCountStringText().replaceAll("\\D*", "")); // "\\D*" - 'Regex' is used for manipulating with strings
        // parsing extracted number from the whole string into integer
        // getting locator of table cell list
        By costListSelector = By.xpath("//td[@idx='7']");

        // get last element from the current costList (25th element)
        int lastIndex = getCostList().size() -1;
        WebElement lastWebElement = costList.get(lastIndex);

        // we scroll to the current last element
        getActions().moveToElement(lastWebElement).perform();

        // wait until total number of elements loaded
        getWait().until(ExpectedConditions.numberOfElementsToBe(costListSelector, totalCountInt));

        costList = getDriver().findElements(costListSelector);

//        Locale locale = new Locale("en", "US");
//        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        double actualTotal = 0; // total of all costs
        for (WebElement cost : costList){
            String costString = cost.getText().replace("$", "");
            double costTotal = Double.parseDouble(costString);

//            double costTotal = format.parse(cost.getText()).doubleValue();

            actualTotal += costTotal;
        }

        System.out.println("Actual total: " + actualTotal);

        double expectedTotal = Double.parseDouble(getExpectedTotalCostStringText());
        System.out.println("Expected total: " + expectedTotal);

        assertThat(actualTotal).isCloseTo(expectedTotal, Percentage.withPercentage(1));

    }


    public void closingModalWindow(){
        click(modalWindow);
    }

    public void selectAllRecords(String button){
        waitingToBeVisible(webElementButton(button));
        click(webElementButton(button));
    }



    public void showTheTable(String buttonShowTable){
        waitingToBeVisible(overLayLoad);
        waitingToBeInVisible(overLayLoad);
        click(webElementButton(buttonShowTable));
    }



    public void searchAddress(String address){
        searchAddressInput.sendKeys(address);
        click(searchIconButton);
    }

}
