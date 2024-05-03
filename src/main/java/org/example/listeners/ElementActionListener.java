package org.example.listeners;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class ElementActionListener implements WebDriverListener {

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println(String.valueOf(keysToSend) + "was typed into " + element.toString());
    }

    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        WebDriverListener.super.afterGetText(element, result);
    }
}
