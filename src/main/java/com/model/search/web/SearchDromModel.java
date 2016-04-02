package com.model.search.web;

import com.application.ApplicationSetup;
import com.model.search.SearchModel;
import com.pageObjects.Drom.DetailsPage;
import com.pageObjects.Drom.DromHomePage;
import com.pageObjects.Drom.DromResultsPage;

/**
 * Created by Igor on 02.04.16.
 */
public class SearchDromModel extends ApplicationSetup implements SearchModel {


    public void loadUrl(String url) {
        throw  new RuntimeException("Implement mee!!!");
    }

    public void makeSearch() {
        new DromHomePage(getWebDriver()).makeSearch();
    }

    public void makeSearch(String elem) {
        throw  new RuntimeException("Implement mee!!!");
    }

    public void chooseResult(int number) {
       new DromResultsPage(getWebDriver()).chooseResult(number);
    }

    public void takeALookAllPhoto() {
        DetailsPage detailsPage = new DetailsPage(getWebDriver());
        detailsPage.openCarPhotoGallery();
        detailsPage.takeALookAllAvailablePhotographs();
    }

    public void closePhotoGallery() {
        new DetailsPage(getWebDriver()).closePhotoGallery();
    }


    public void goBack() {
        new DetailsPage(getWebDriver()).goBack();
    }

    public void handleAllResults() {
        for (int i = 0; i < getSizeOfResults(); i++) {
            chooseResult(i);
            takeALookAllPhoto();
            closePhotoGallery();
            goBack();
        }

        if (new DromResultsPage(getWebDriver()).hasNextPage()) {
            new DromResultsPage(getWebDriver()).goToNextPage();
            handleAllResults();
        }


    }

    public int getSizeOfResults() {
        return new DromResultsPage(getWebDriver()).getResults().size();
    }
}
