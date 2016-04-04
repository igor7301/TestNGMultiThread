package com.application.workPlace;

/**
 * Created by IKomarov on 04.04.2016.
 */
public abstract class WorkPlace{

    abstract String getPathToChromeDriverWin();

    abstract String getPathToChromeDriverMac();

    abstract String getPathToSerfEarnerExtensionWin();

    abstract String getPathToSerfEarnerExtensionMac();

    public String getPathToSerfEarnerExtension() {

        if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {

            return getPathToSerfEarnerExtensionWin();
        }
        else {
            return getPathToSerfEarnerExtensionMac();
        }
    }

    public String getPathToChromeDriver() {

        if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {

            return getPathToChromeDriverWin();
        }
        else {
            return getPathToChromeDriverMac();
        }
    }
}
