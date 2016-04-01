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
            for (double i = 0; i < 100; i ++) {
                randomPage.scrollPageDown(i, i+1);
                Thread.sleep(100);
            }
            randomPage.scrollPageToTheTop();
            Thread.sleep(1000);
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
