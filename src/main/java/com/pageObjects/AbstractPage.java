package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class AbstractPage {

    public AbstractPage(WebDriver driver) {
        PageFactory.initElements(new CustomElementLocatorFactory(driver), this);
    }


    public AbstractPage(WebDriver driver, By locator) {
        PageFactory.initElements(new CustomElementLocatorFactory(driver.findElement(locator)), this);
    }
}