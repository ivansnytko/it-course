package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.*;

public class SelenidePage {
    String priceByNameXpath = "\"//*[text() ='%s']/folow-sibl::button[2]\"";

    public boolean isPriceByProductNameDisplayed(String productName) {
        return $(By.xpath(String.format(priceByNameXpath, productName))).isDisplayed();
    }


}
