package com.pageObjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;

import java.lang.reflect.Field;

/**
 * Created by Admin on 05.03.15.
 */
public class CustomElementLocator extends AjaxElementLocator {

    public CustomElementLocator(SearchContext context, Field field, int timeOutInSeconds) {
        super(context, field, timeOutInSeconds);
    }

    @Override
    protected boolean isElementUsable(WebElement element) {
        return element.isDisplayed();
    }
}
