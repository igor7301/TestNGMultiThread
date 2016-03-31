package com.model.search.mobile;

import com.model.search.SearchModel;

/**
 * Created by IKomarov on 31.03.2016.
 */
public class SearchYandexModelMobile implements SearchModel {
    @Override
    public void loadUrl(String url) {
        throw  new RuntimeException("Implement mee!!!");
    }

    @Override
    public void makeSearch() {
        throw  new RuntimeException("Implement mee!!!");
    }

    @Override
    public void makeSearch(String elem) {
        throw  new RuntimeException("Implement mee!!!");
    }
}
