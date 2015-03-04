package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class AbstractPage {

    public AbstractPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
}
