package org.example;

import org.example.pages.LoginPage;
import org.example.pages.SignUpFormPage;
import org.example.utils.ScreenShotUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class FacebookTest2 extends BaseTest{

    @Test
    public void testFrame() throws InterruptedException {
        driver.get("https://symonstorozhenko.wixsite.com/website-1");

        Thread.sleep(5000);
        WebElement frame = driver.findElement(By.xpath("//*[@title= 'Wix Chat']"));
        driver.switchTo().frame(frame);
        driver.findElement(By.cssSelector("#minimized-chat")).click();
        driver.switchTo().defaultContent();

        Alert alert = driver.switchTo().alert();
        //alert.accept();
        alert.dismiss();
        /////////// alert.sendKeys("");
         alert.getText();

//        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.titleIs("Google"));
//        wait.until(x->frame.isDisplayed());
//        WebElement amountOfProducts= driver.findElement();
//        String amountBeforeFilter = amountOfProducts.getText();
//        FluentWait fluentWait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class).ignoring(ElementNotInteractableException.class);
//        fluentWait.until(x-> {
//            WebElement element = driver.findElement();
//            element.sendKeys();
//            return true;
//        });
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
        Thread.sleep(5000);
        ScreenShotUtils.takeScreenshot(driver);
        element.submit();
    }



}
