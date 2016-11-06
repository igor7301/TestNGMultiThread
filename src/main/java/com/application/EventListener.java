package com.application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by Igor on 02.04.16.
 */
public class EventListener implements WebDriverEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventListener.class);

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigate to " + url + " we can do something here....");

    }

    public void afterNavigateTo(String url, WebDriver driver) {

    }

    public void beforeNavigateBack(WebDriver driver) {

    }

    public void afterNavigateBack(WebDriver driver) {

    }

    public void beforeNavigateForward(WebDriver driver) {

    }

    public void afterNavigateForward(WebDriver driver) {

    }


    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {

    }

    public void beforeClickOn(WebElement element, WebDriver driver) {

        //от нуля до 10 секунд задержка перед нажатием
        int random = new Random(System.currentTimeMillis()).nextInt(10000);
        try {
        //вначале прокручиваем до элемента
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView(true);", element);

            LOGGER.info("Before click on element:  DELAY: " + random );
            //задержка перед кликом
            Thread.sleep(random);
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {

    }

    public void beforeScript(String script, WebDriver driver) {

    }

    public void afterScript(String script, WebDriver driver) {

    }

    public void onException(Throwable throwable, WebDriver driver) {

    }
}
