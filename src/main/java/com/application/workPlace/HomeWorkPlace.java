package com.application.workPlace;

/**
 * Created by IKomarov on 04.04.2016.
 */
public class HomeWorkPlace extends WorkPlace {
    private  final String pathToChromeDriverMac = "/Users/Igor/Downloads/chromedriver";
    private  final String pathToSerfEarnerExtensionMac = "/Users/Igor/IdeaProjects/extensionSurfEarner.crx";


    public String getPathToChromeDriverWin() {
        throw new RuntimeException("Implement me for HOME profile!!!");
    }

    public String getPathToChromeDriverMac() {
        return pathToChromeDriverMac;
    }

    @Override
    String getPathToSerfEarnerExtensionWin() {
        throw new RuntimeException("Implement me  for HOME profile!!!");
    }

    @Override
    String getPathToSerfEarnerExtensionMac() {
        return pathToSerfEarnerExtensionMac;
    }


}
