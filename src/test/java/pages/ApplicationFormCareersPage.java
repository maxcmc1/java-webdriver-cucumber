package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationFormCareersPage extends CareersHeader{

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement applyOrWithdrawButton;

    public ApplicationFormCareersPage clickApplyOrWithdrawButton(){
        click(applyOrWithdrawButton);
        return new ApplicationFormCareersPage();
    }



}
