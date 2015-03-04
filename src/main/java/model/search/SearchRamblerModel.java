package model.search;

import application.ApplicationSetup;
import data.Data;
import pageObjects.RamblerPage;

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
    }

    @Override
    public void makeSearch(String elem) {
        new RamblerPage(getWebDriver()).makeSearch(elem);
    }
}
