package org.example.listeners;

import org.example.utils.DriverManager;
import org.example.utils.ScreenShotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("=========================================================");
        System.out.println("Test " + result.getMethod().getMethodName() +  " started");
        System.out.println("=========================================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("=========================================================");
        System.out.println("Test " + result.getMethod().getMethodName() +  " success");
        System.out.println("=========================================================");
        DriverManager.quitDriver();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("=========================================================");
        System.out.println("Test " + result.getMethod().getMethodName() +  " failed");
        System.out.println("=========================================================");
        ScreenShotUtils.takeScreenshot(DriverManager.getDriver());
        System.out.println(DriverManager.getDriver().getPageSource());
        DriverManager.quitDriver();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        DriverManager.quitDriver();
    }
}
