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
    @Override
    public void loadUrl(String url) {

    }

    @Override
    public void makeSearch() {
        new GooglePage(getWebDriver()).makeSearch(((Data)getBean("data")).getElemForSearch());
    }

    @Override
    public void makeSearch(String elem) {

    }
}
