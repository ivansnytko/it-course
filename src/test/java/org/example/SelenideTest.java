package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.example.pages.SelenidePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertEquals;

public class SelenideTest {

    @Test
    public void googleTest() throws IOException, InterruptedException {
        SelenidePage selenidePage = open("", SelenidePage.class);

        SelenidePage selenide2Page = page(SelenidePage.class);
        Configuration.remote = "http://192.168.0.111:4444";
        Configuration.timeout = 10000;
        Configuration.browser = "firefox";
        Configuration.headless = true;
        open("http://www.google.com");
        SelenideElement selenideElement = $(By.name("q"));
        $(By.name("q")).shouldBe(disappear).click();
        $(By.xpath("q")).val("Selenium");
        $(By.id("q")).submit();
        WebDriverRunner.isChrome();

        ElementsCollection list = $$(By.name("q"));
        list.should(sizeGreaterThan(1));
        



    }
}
