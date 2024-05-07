package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {


    private static final Logger LOGGER = LogManager.getLogger(DriverFactory.class);

    public static WebDriver createDriver(String browser) {
        URL url;
        try {
            url = new URL("http://test:test-password@localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        if (browser.equals("chrome")) {
            LOGGER.debug("Browser is chrome");
            ChromeOptions chromeOptions = new ChromeOptions();
            return new RemoteWebDriver(url, chromeOptions);
        } else if(browser.equals("firefox")) {
            LOGGER.debug("Browser is firefox");
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            LOGGER.debug("Options are created");
            return new RemoteWebDriver(url, firefoxOptions);
        }
        return null;
    }
}
