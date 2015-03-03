package model.search;

import application.ApplicationSetup;

/**
 * Created by Admin on 03.03.15.
 */
public class SearchHotel extends ApplicationSetup implements Search {
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
        System.out.println(url + " bean param: " + getA());
    }
}
