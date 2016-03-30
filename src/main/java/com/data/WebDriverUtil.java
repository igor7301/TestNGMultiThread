package com.data;

import com.application.ApplicationSetup;
import com.pageObjects.RandomPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by IKomarov on 29.03.2016.
 */
public class WebDriverUtil extends ApplicationSetup{

    public void closeAllTabs() {
        String mainWindowHandler =   getWebDriver().getWindowHandle();
        for (String currentWindowHandler : getWebDriver().getWindowHandles()) {
            if(!mainWindowHandler.equals(currentWindowHandler)) {
                getWebDriver().switchTo().window(currentWindowHandler).close();
            }
        }
        getWebDriver().switchTo().window(mainWindowHandler);
    }


    public void makeActivityInRandomTab(WebDriver webDriver) {
        RandomPage randomPage = new RandomPage(webDriver);

        try {
            randomPage.scrollPageToTheBottom();
            Thread.sleep(100000);
            randomPage.scrollPageToTheTop();
            Thread.sleep(100000);
        } catch (Exception e) {

        }
    }


    public void makeActivityInAllTabs() {
        String mainWindowHandler =   getWebDriver().getWindowHandle();
        for (String currentWindowHandler : getWebDriver().getWindowHandles()) {
            if(!mainWindowHandler.equals(currentWindowHandler)) {
                makeActivityInRandomTab(getWebDriver().switchTo().window(currentWindowHandler));
            }
        }
        getWebDriver().switchTo().window(mainWindowHandler);
    }
}
