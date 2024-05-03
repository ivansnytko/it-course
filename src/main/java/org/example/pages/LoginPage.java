package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(css = "[data-testid='open-registration-form-button']")
    private WebElement signUpBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,LoginPage.class);
    }

    public void openUrl() {
        driver.get("https://facebook.com");
    }

    public SignUpFormPage clickSignUpBtn() {
        signUpBtn.click();
        return new SignUpFormPage(driver);
    }
}
