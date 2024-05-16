package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.pages.SelenidePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;

public class SelenideTest {

    @Test
    public void googleTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
        SelenidePage selenidePage = open("", SelenidePage.class);

        SelenidePage selenide2Page = page(SelenidePage.class);
        Configuration.remote = "http://192.168.0.111:4444";
        Configuration.timeout = 10000;
        Configuration.browser = "firefox";
        Configuration.headless = true;
        open("http://www.google.com");
        SelenideElement selenideElement = $(By.name("q"));
        $(By.xpath("q")).val("Selenium");
        $(By.id("q")).submit();
        Assert.fail();

        



    }
}
