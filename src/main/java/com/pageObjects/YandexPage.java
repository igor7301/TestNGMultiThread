package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by IKomarov on 28.03.2016.
 */
public class YandexPage extends  AbstractPage {

    @FindBy(css = ".search2__input .input__box .input__control.input__input")
    private WebElement search;

    @FindBy (css = ".button.suggest2-form__button")
    private WebElement submit;

    public YandexPage(WebDriver driver) {
        super(driver);
    }

    public void makeSearch(String elem) {
        try {
            search.sendKeys(elem);
            submit.click();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
