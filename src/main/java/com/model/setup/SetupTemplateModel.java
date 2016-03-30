package com.model.setup;

import com.application.ApplicationSetup;
import com.pageObjects.SurfEarnerPage;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class SetupTemplateModel extends ApplicationSetup implements SetupModel, InitializingBean {


    private static  SetupTemplateModel instance;

    public SetupTemplateModel() {
        System.out.println("Setup template model");
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

    public void afterPropertiesSet() throws Exception {

        instance = this;
    }

    public static SetupTemplateModel getInstance() {
        return instance;
    }
}
