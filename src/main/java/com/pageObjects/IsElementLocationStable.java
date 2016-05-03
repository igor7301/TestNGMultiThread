package com.pageObjects;

import com.google.common.base.Function;
import org.openqa.selenium.*;


/**
 * Created by Igor on 02.05.16.
 */
public  class IsElementLocationStable implements Function<WebDriver, Boolean> {


    private static final int ITERATIONS = 10;

    private By by;
    private Point startPointLocation;
    private int count;
    private int iterations;

    public IsElementLocationStable(WebDriver webdriver, By by) {
        this(webdriver, by, ITERATIONS);
    }

    public IsElementLocationStable(WebDriver webdriver, By by, int iterations) {
        this.by = by;
        this.iterations = iterations;
        try {
            startPointLocation = webdriver.findElement(this.by).getLocation();
        }
        catch (NoSuchElementException e) {
            startPointLocation = new Point(0, 0);
        }
        catch (StaleElementReferenceException e) {
            startPointLocation = new Point(0, 0);
        }
        count = 0;
    }


    public Boolean apply(WebDriver webdriver) {
        try {
            Point test = webdriver.findElement(by).getLocation();

            if (startPointLocation.equals(test)) {
                count++;
            }
            else {
                count = 0;
            }
            startPointLocation = test;
        }
        catch (NoSuchElementException e) {
            count = 0;
        }
        catch (StaleElementReferenceException e) {
            // Assumed element moved... location not stable.
            count = 0;
        }
        return count == iterations;
    }
}
