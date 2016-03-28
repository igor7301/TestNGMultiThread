package com.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by IKomarov on 28.03.2016.
 */
public class GooglePage extends AbstractPage {
    @FindBy(css = "#lst-ib")
    private WebElement search;

    @FindBy (css = "input[name='btnK']")
    private WebElement submit;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void makeSearch(String elem) {
        try {
            search.sendKeys(elem);
            search.sendKeys(Keys.ENTER);
            //submit.click();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


}
