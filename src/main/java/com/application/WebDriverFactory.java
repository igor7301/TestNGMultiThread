package com.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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

    public static WebDriver getChromeWebDriver() {
        DesiredCapabilities capabilities = null;
        String pathToChromeDriver = "D:\\Personal\\chromedriver_win32\\chromedriver.exe";
        String pathToSerfEarnerExtension = "D:\\Personal\\extensionSerfEarner.crx";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");

        try {
            options.addExtensions(new File(pathToSerfEarnerExtension));
        }
        catch (IllegalArgumentException e) {
            LOGGER.warn("SerfEarner extension isn't found at the path: " + pathToSerfEarnerExtension + ". Chrome will be ran without extension;");
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        try {
            LOGGER.info("Chrome driver is running...");
            return new ChromeDriver(capabilities);
        }
        catch (IllegalStateException e) {
            LOGGER.warn("Chrome driver isn't found at the path: " + pathToChromeDriver + ". Firefox driver is running instead.....");
            return getFirefoxWebDriver();

        }


    }

}
