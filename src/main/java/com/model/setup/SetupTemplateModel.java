package com.model.setup;

import com.application.ApplicationSetup;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class SetupTemplateModel extends ApplicationSetup implements SetupModel {
    @Override
    public void loadURL(String url) {
        getWebDriver().navigate().to(url);
    }
}
