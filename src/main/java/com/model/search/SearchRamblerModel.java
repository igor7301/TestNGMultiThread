package com.model.search;

import com.application.ApplicationSetup;
import com.data.Data;
import com.pageObjects.RamblerPage;
import sun.security.util.PendingException;

/**
 * Created by v-ikomarov on 3/3/2015.
 */
public class SearchRamblerModel extends ApplicationSetup implements SearchModel {

    @Override
    public void loadUrl(String url) {

    }

    @Override
    public void makeSearch() {
        new RamblerPage(getWebDriver()).makeSearch(((Data)getBean("data")).getElemForSearch());
//        throw new PendingException("exception");
    }

    @Override
    public void makeSearch(String elem) {
        new RamblerPage(getWebDriver()).makeSearch(elem);
    }
}
