package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpFormPage extends BasePage{


    @FindBy(xpath = "//div[text() = 'Sign Up']")
    private WebElement signUpTitle;

    @FindBy(name = "firstname")
    private WebElement firstName;

    public SignUpFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSignUpTitlePresent() {
        return signUpTitle.isDisplayed();
    }

    public void typeFirstName(String name) {
        firstName.click();
        firstName.sendKeys(name);
    }
}
