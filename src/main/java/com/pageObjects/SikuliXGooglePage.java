package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * Created by IKomarov on 28.11.2016.
 */
public class SikuliXGooglePage {

    WebDriver webDriver;

    public SikuliXGooglePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void makeSearch(String data) {
        //Create and initialize an instance of Screen object
        Screen screen = new Screen();


        webDriver.manage().window().maximize();

        //Add image path
//        Pattern image = new Pattern("C:\\Users\\IKomarov\\IdeaProjects\\TestNGMultiThread\\src\\test\\resources\\googleSearchFieldFF.png");
        Pattern image = new Pattern("\\src\\test\\resources\\googleSearchFieldFF.png");



        //Wait 10ms for image
        try {
            screen.wait(image, 10);
            screen.click(image);
            screen.write(data + "#ENTER.");

        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }



    }
}
