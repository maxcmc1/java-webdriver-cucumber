package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class LoginCareersPage extends CareersHeader {


    @FindBy(xpath = "//label[@*='loginUsername']/..//input")
    private WebElement email;

    @FindBy(xpath = "//label[@*='loginPassword']/..//input")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement loginButton;


    public LandingCareersPage login(Map<String, String> user){
        fill(email, user.get("email"));
        fill(password, user.get("password"));
        click(loginButton);
        return new LandingCareersPage();
    }

    public LandingCareersPage login(String email, String password){
        this.email.sendKeys(email);
        this.email.sendKeys(password);
        loginButton.click();
        return new LandingCareersPage();
    }

}
