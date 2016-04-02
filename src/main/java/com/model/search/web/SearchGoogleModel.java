package com.model.search.web;

import com.application.ApplicationSetup;
import com.data.Data;
import com.model.search.SearchModel;
import com.pageObjects.GooglePage;
import com.pageObjects.YandexPage;

/**
 * Created by IKomarov on 28.03.2016.
 */
public class SearchGoogleModel extends ApplicationSetup implements SearchModel {
    public void loadUrl(String url) {

    }

    public void makeSearch() {
        new GooglePage(getWebDriver()).makeSearch(((Data)getBean("data")).getElemForSearch());
    }

    public void makeSearch(String elem) {
        throw  new RuntimeException("Implement mee!!!");
    }

    public void chooseResult(int number) {
        throw  new RuntimeException("Implement mee!!!");
    }
}
