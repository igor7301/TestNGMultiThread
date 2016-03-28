package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class AbstractPage {
    private WebDriver webDriver;

    public AbstractPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(new CustomElementLocatorFactory(driver), this);
    }


    public AbstractPage(WebDriver driver, By locator) {
        this.webDriver = driver;
        PageFactory.initElements(new CustomElementLocatorFactory(driver.findElement(locator)), this);
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }
}
