package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


    public void scrollPageToTheBottom() throws Exception{
        ((JavascriptExecutor)webDriver).executeScript("function f() {" +
                " window.scrollTo(0, document.body.scrollHeight);" +
                " setTimeout(function(){" +
                " if ($(window).scrollTop() != $(document).height()-$(window).height()){" +
                " f();" +
                " }" +
                " }" +
                " , 500);" +
                " }" +
                "f()");

    }

    public void scrollPageToTheTop() throws Exception{
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 0);");
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }
}
