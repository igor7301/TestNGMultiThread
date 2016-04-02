package com.pageObjects.Drom;

import com.pageObjects.AbstractPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Igor on 02.04.16.
 */
public class DromHomePage extends AbstractPage {


    public DromHomePage(WebDriver driver) {
        super(driver);
    }

    public void makeSearch() {
        new FinderFragment(getWebDriver()).makeSearch();
    }
}
