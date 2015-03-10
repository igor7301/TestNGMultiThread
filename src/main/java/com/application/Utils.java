
package com.application;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;


public final class Utils extends ApplicationSetup {
    private Utils() {}

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) THREAD_PARAM.get(Thread.currentThread().getId())
                .get(PARAM.WEBDRIVER))
                .getScreenshotAs(OutputType.BYTES);
    }
}