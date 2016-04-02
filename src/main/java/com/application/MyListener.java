package com.application;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by Admin on 10.03.15.
 */
public class MyListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Allure listener for success tests");
        Utils.makeScreenshot("Test_screenshot");
    }

    public void onTestFailure(ITestResult iTestResult) {
//        System.out.println("Allure listener for failed tests");
//        Utils.makeScreenshot("Test_screenshot");

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
