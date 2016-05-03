package com.pageObjects.Drom;

import com.pageObjects.AbstractPage;
import com.pageObjects.IsElementLocationStable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Igor on 02.04.16.
 */
public class FinderFragment extends AbstractPage {


    @FindBy (css = "#fid")
    private WebElement company;


    @FindBy (css = "#mid")
    private WebElement model;

    @FindBy (css = "input[type='submit']")
    private WebElement findBtn;



    public FinderFragment(WebDriver driver) {
        super(driver, By.className("filtersWrap"));


        new WebDriverWait(getWebDriver(), 10)
                .until(new IsElementLocationStable(getWebDriver(), By.className("filtersWrap")));
    }


    public void makeSearch() {
      getFindBtn().click();
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getModel() {
        return model;
    }

    public WebElement getFindBtn() {
        return findBtn;
    }
}
