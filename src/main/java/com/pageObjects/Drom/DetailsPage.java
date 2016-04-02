package com.pageObjects.Drom;

import com.pageObjects.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Igor on 02.04.16.
 */
public class DetailsPage extends AbstractPage {


    @FindBy(css = "#usual_photos .relative a")
    private WebElement carPhotoGallery;


    @FindBy(css = ".fancybox-next span")
    private WebElement nextButton;


    @FindBy(css = ".fancybox-close")
    private WebElement closePhotoGalleryBtn;

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public void openCarPhotoGallery() {
        getCarPhotoGallery().click();
    }

    public void takeALookAllAvailablePhotographs() {
        int i = 0;
        int maxPhotos = 10;
        while (getNextButton().isDisplayed()) {
           getNextButton().click();
            i++;
            if (i >= maxPhotos) {
                break;
            }
       }
    }

    public WebElement getCarPhotoGallery() {
        return carPhotoGallery;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public void closePhotoGallery() {
        getClosePhotoGalleryBtn().click();
    }

    public WebElement getClosePhotoGalleryBtn() {
        return closePhotoGalleryBtn;
    }
}
