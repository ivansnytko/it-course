package org.example;

import org.apache.commons.io.FileUtils;
import org.example.pages.LoginPage;
import org.example.pages.SignUpFormPage;
import org.example.utils.ScreenShotUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FacebookTest extends BaseTest{

    @Test
    public void testFrame() throws InterruptedException {
        driver.get("https://symonstorozhenko.wixsite.com/website-1");

        Thread.sleep(5000);
        WebElement frame = driver.findElement(By.xpath("//*[@title= 'Wix Chat']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.cssSelector("#minimized-chat")).click();
        driver.switchTo().defaultContent();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
        alert.sendKeys("");
        alert.getText();
        //Fixes
    }

    @Test
    public void staleExc() {
        driver.get("https://facebook.com");
        WebElement element = driver.findElement(By.cssSelector("[data-testid='open-registration-form-button']"));
        driver.navigate().refresh();
        element.click();
    }

    @Test
    public void jsExample() throws InterruptedException {
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        List<WebElement> list = driver.findElements(By.xpath("//*[text() = 'Add to cart']"));
        for (WebElement element: list) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
        }
        Thread.sleep(50000);
    }

    @Test
    public void signUpFacebookTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openUrl();
        SignUpFormPage signUpFormPage = loginPage.clickSignUpBtn();
        Assert.assertTrue(signUpFormPage.isSignUpTitlePresent(), "Sign up title isn't present");
        signUpFormPage.typeFirstName("Ivan");
        WebElement dayPicker = driver.findElement(By.name("birthday_day"));
        Select daySelect = new Select(dayPicker);
        daySelect.selectByIndex(3);
        daySelect.selectByValue("5");
        daySelect.selectByVisibleText("7");
        driver.findElement(By.cssSelector("[name= 'websubmit']")).click();
        WebElement error = driver.findElement(By.id("js_o"));
        Assert.assertEquals(error.getText(), "What's your name?");

    }

    @Test
    public void googleTest() throws IOException, InterruptedException {
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium");
        element.submit();
    }



}
