package com.model.setup;

import com.application.ApplicationSetup;
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

    public void afterPropertiesSet() throws Exception {

        instance = this;
    }

    public static SetupTemplateModel getInstance() {
        return instance;
    }
}
