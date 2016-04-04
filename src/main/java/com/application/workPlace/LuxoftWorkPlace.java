package com.application.workPlace;

/**
 * Created by IKomarov on 04.04.2016.
 */
public class LuxoftWorkPlace extends WorkPlace {
    private  final String pathToChromeDriverWin = "D:\\Personal\\chromedriver_win32\\chromedriver.exe";
    private  final String pathToSerfEarnerExtensionWin = "D:\\Personal\\extensionSerfEarner.crx";


    @Override
    String getPathToChromeDriverWin() {
        return pathToChromeDriverWin;
    }

    @Override
    String getPathToChromeDriverMac() {
        throw new RuntimeException("Implement me!!!");
    }

    @Override
    String getPathToSerfEarnerExtensionWin() {
        return pathToSerfEarnerExtensionWin;
    }

    @Override
    String getPathToSerfEarnerExtensionMac() {
        throw new RuntimeException("Implement me!!!");
    }
}
