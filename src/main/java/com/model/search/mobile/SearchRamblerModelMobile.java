package com.model.search.mobile;

import com.model.search.SearchModel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by IKomarov on 31.03.2016.
 */
public class SearchRamblerModelMobile implements SearchModel{
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
