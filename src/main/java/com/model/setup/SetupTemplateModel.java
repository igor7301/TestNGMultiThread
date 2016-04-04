package com.model.setup;

import com.application.ApplicationSetup;
import com.application.workPlace.HomeWorkPlace;
import com.application.workPlace.LuxoftWorkPlace;
import com.application.workPlace.WorkPlace;
import com.pageObjects.SurfEarnerPage;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class SetupTemplateModel extends ApplicationSetup implements SetupModel {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetupTemplateModel.class);
    private String message;
    private WORKPLACE workPlace;

    enum WORKPLACE {
        HOME, LUXOFT;
    }

    public SetupTemplateModel() {
        LOGGER.info("Setup template model constructor");
    }

    public void loadURL(String url) {
        getWebDriver().navigate().to(url);
    }

    public void loginToSurfEarner(String email, String password) {
        SurfEarnerPage surfEarnerPage = new SurfEarnerPage(getWebDriver());
        surfEarnerPage.login(email, password);
    }

    public void printTestMessage() {
        LOGGER.info("Test message: " + message);
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = WORKPLACE.valueOf(workPlace);
    }

    public WorkPlace getWorkPlace() {
        if (workPlace == WORKPLACE.HOME) {
            return new HomeWorkPlace();

        }
        else if (workPlace == WORKPLACE.LUXOFT) {
            return new LuxoftWorkPlace();
        }

        throw new RuntimeException("Workplace property is not correct: " + workPlace + ". It should be one of : " + WORKPLACE.values());
    }
}
