package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class RamblerPage extends  AbstractPage {

    @FindBy (css = "#search_query")
    private WebElement search;

    @FindBy (css = ".b-search__submit")
    private WebElement submit;

    public RamblerPage(WebDriver driver) {
        super(driver);
    }

    public void makeSearch(String elem) {
        search.sendKeys(elem);
        submit.click();
    }


}
