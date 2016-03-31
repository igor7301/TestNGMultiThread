package com.pageObjects;

import com.pageObjects.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by IKomarov on 29.03.2016.
 */
public class RamblerResultPage extends AbstractPage {

    public static final String RESULT_LINK = ".b-serp-item__header a";

    @FindBy(css = ".b-serp-item")
    private List<WebElement> results;

    public RamblerResultPage(WebDriver driver) {
        super(driver);
    }


    public void chooseResult(int number) {
        results.get(number).findElement(By.cssSelector(RESULT_LINK)).click();
    }

    public int getSizeOfResults() {
        return results.size();
    }

}
