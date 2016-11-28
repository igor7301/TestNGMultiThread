package com.model.search.web;

import com.application.ApplicationSetup;
import com.data.Data;
import com.model.search.SearchModel;
import com.pageObjects.GooglePage;
import com.pageObjects.SikuliXGooglePage;

/**
 * Created by IKomarov on 28.11.2016.
 */
public class SearchSikuliXGoogleModel extends ApplicationSetup implements SearchModel {

    public void loadUrl(String url) {

    }

    public void makeSearch() {
        new SikuliXGooglePage(getWebDriver()).makeSearch("Hello world! SikuliX works!");
    }

    public void makeSearch(String elem) {
        throw  new RuntimeException("Implement mee!!!");
    }

    public void chooseResult(int number) {
        throw  new RuntimeException("Implement mee!!!");
    }
}
