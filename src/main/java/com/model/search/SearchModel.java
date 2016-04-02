package com.model.search;

/**
 * Created by Admin on 03.03.15.
 */
public interface SearchModel {

    public void loadUrl(String url);

    public void makeSearch();

    public void makeSearch(String elem);

    void chooseResult(int number);

}
