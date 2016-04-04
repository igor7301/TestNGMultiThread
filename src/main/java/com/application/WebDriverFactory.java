package com.application;

import com.application.workPlace.WorkPlace;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by IKomarov on 28.03.2016.
 */
public class WebDriverFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);

    private WebDriverFactory() {

    }


    public static WebDriver getFirefoxWebDriver() {
        return new FirefoxDriver();
    }

    public static WebDriver getChromeWebDriver(WorkPlace workPlace) {
        System.setProperty("webdriver.chrome.driver", workPlace.getPathToChromeDriver());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        WebDriver webDriver;
        options.addArguments("start-maximized");

        try {
            options.addExtensions(new File(workPlace.getPathToSerfEarnerExtension()));
        }
        catch (IllegalArgumentException e) {
            LOGGER.warn("SerfEarner extension isn't found at the path: " + workPlace.getPathToSerfEarnerExtension() + ". Chrome will be ran without extension;");
        }
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        try {
            LOGGER.info("Chrome driver is running...");
            webDriver = new ChromeDriver(capabilities);
        }
        catch (IllegalStateException e) {
            LOGGER.warn("Chrome driver isn't found at the path: " + workPlace.getPathToChromeDriver() + ". Firefox driver is running instead.....");
            webDriver = getFirefoxWebDriver();
        }

        EventFiringWebDriver overridedDriver = new EventFiringWebDriver(webDriver);
        overridedDriver.register(new EventListener());
        return overridedDriver;

    }

}
