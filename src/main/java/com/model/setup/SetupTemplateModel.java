package com.model.setup;

import com.application.ApplicationSetup;
import com.pageObjects.SurfEarnerPage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class SetupTemplateModel extends ApplicationSetup implements SetupModel {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetupTemplateModel.class);
    private String message;


    public SetupTemplateModel() {
        LOGGER.info("Setup template model constructor");
    }

    @Override
    public void loadURL(String url) {
        getWebDriver().navigate().to(url);
    }

    @Override
    public void loginToSurfEarner(String email, String password) {
        SurfEarnerPage surfEarnerPage = new SurfEarnerPage(getWebDriver());
        surfEarnerPage.login(email, password);
    }

    @Override
    public void printTestMessage() {
        LOGGER.info("Test message: " + message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
