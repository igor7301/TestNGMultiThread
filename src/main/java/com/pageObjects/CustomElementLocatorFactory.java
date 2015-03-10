package com.pageObjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

/**
 * Created by Admin on 05.03.15.
 */
public class CustomElementLocatorFactory implements ElementLocatorFactory {
    private final int timeOutInSeconds = 30;

    SearchContext context;

    public CustomElementLocatorFactory(SearchContext context) {
        this.context = context;
    }

      @Override
    public ElementLocator createLocator(Field field) {
       return new CustomElementLocator(context, field, timeOutInSeconds);
    }
}
