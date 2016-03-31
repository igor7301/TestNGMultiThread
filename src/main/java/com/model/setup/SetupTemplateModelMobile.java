package com.model.setup;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by IKomarov on 31.03.2016.
 */
public class SetupTemplateModelMobile implements SetupModel, InitializingBean {

    private static SetupModel instance;

    @Override
    public void loadURL(String url) {
        throw  new RuntimeException("Implement mee!!!");
    }

    @Override
    public void loginToSurfEarner(String email, String password) {
        throw  new RuntimeException("Implement mee!!!");
    }

    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public static SetupModel getInstance() {
        return instance;
    }
}
