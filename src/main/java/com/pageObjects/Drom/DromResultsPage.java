package com.pageObjects.Drom;

import com.pageObjects.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Igor on 02.04.16.
 */
public class DromResultsPage extends AbstractPage {

    @FindBy(css = ".newCatList .row")
    private List<WebElement> results;


    @FindBy(css = ".b-pagination__item_next")
    private WebElement nextPage;


    public DromResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getResults() {
        return results;
    }

    public void chooseResult(int number) {
        try {
            getResults().get(number).click();

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

    public boolean hasNextPage() {
        return nextPage.isDisplayed();
    }

    public void goToNextPage() {
         nextPage.click();
    }
}
