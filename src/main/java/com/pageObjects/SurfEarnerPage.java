package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

/**
 * Created by IKomarov on 29.03.2016.
 */
public class SurfEarnerPage  extends  AbstractPage{

    @FindBy(css = "input[name='LoginForm[email]']")
    private WebElement email;

    @FindBy(css = "input[name='LoginForm[password]']")
    private WebElement password;


    public SurfEarnerPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        this.email.sendKeys("");
        this.email.sendKeys(email);

        this.password.sendKeys("");
        this.password.sendKeys(password);

        waitForManualAuthentication();

    }

    public void waitForManualAuthentication() {
        int timeOut = 1800;
        int i = 0;
        while (!getWebDriver().getCurrentUrl().contains("user") && i < timeOut) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;

        }
    }


}
