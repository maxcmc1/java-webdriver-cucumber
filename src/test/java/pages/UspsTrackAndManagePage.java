package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsTrackAndManagePage extends UspsHeader{


    public UspsTrackAndManagePage(){

        url = "https://www.usps.com/manage/";

    }

    @FindBy(id = "track-package--input")
    private WebElement trackYourPackage;


    public void waitUntilTrackYourPackage(){
        waitingToBeVisible(trackYourPackage);
    }

}
