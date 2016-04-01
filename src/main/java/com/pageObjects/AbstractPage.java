package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPage.class);

    private WebDriver webDriver;

    public AbstractPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(new CustomElementLocatorFactory(driver), this);
    }


    public AbstractPage(WebDriver driver, By locator) {
        this.webDriver = driver;
        PageFactory.initElements(new CustomElementLocatorFactory(driver.findElement(locator)), this);
    }

    public void scrollPageDown(double from, double to) throws Exception{

        LOGGER.info("From : " + from / 100 + "To : "  + to / 100);

        ((JavascriptExecutor)webDriver).executeScript("function f() {" +
                " window.scrollTo(document.body.scrollHeight*" + from / 100 + ", document.body.scrollHeight*" + to / 100 + ");" +
                " setTimeout(function(){" +
                " if ($(window).scrollTop() != $(document).height()-$(window).height()){" +
                " f();" +
                " }" +
                " }" +
                " , 500);" +
                " }" +
                "f()");

    }


    public void scrollPageToTheBottom() throws Exception{
          scrollPageDown(0, 100);
    }

    public void scrollPageToTheTop() throws Exception{
        ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, 0);");
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }
}
