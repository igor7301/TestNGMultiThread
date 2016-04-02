package com.model.search.web;

import com.application.ApplicationSetup;
import com.data.Data;
import com.model.search.SearchModel;
import com.pageObjects.RamblerPage;
import com.pageObjects.RamblerResultPage;
import org.springframework.beans.factory.InitializingBean;

import java.util.Random;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class SearchRamblerModel extends ApplicationSetup implements SearchModel, InitializingBean {

    private static SearchRamblerModel instance;

    public void loadUrl(String url) {

    }

    public void makeSearch() {
        new RamblerPage(getWebDriver()).makeSearch(((Data)getBean("data")).getElemForSearch());
    }

    public void makeSearch(String elem) {
        new RamblerPage(getWebDriver()).makeSearch(elem);
    }

    public void chooseResult(int number) {
        throw  new RuntimeException("Implement mee!!!");
    }

    public void afterPropertiesSet() throws Exception {
        instance = this;
    }

    public static SearchRamblerModel getInstance() {
        return instance;
    }

    public void chooseRandomResult() {
        RamblerResultPage ramblerResultPage = new RamblerResultPage(getWebDriver());
        ramblerResultPage.chooseResult(new Random(System.currentTimeMillis()).nextInt(ramblerResultPage.getSizeOfResults()));
    }




}
