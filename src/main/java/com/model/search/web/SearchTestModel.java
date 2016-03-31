package com.model.search.web;

import com.application.ApplicationSetup;
import com.model.search.SearchModel;

/**
 * Created by Admin on 03.03.15.
 */
public class SearchTestModel extends ApplicationSetup implements SearchModel {
    private String a;
    private String url;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public void loadUrl(String url) {
        this.url = url;
        getWebDriver().navigate().to(url);

    }

    @Override
    public void makeSearch() {
        System.out.println("bean param: " + getA());
    }

    @Override
    public void makeSearch(String elem) {

    }
}
