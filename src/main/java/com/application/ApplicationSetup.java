package com.application;

import com.model.setup.SetupTemplateModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 03.03.15.
 */
public class ApplicationSetup {
     public static final String CONTEXT_PATH = "main-context.xml";
    public static Map<Long, Map<PARAM, Object>> THREAD_PARAM = new HashMap<Long, Map<PARAM, Object>>();

    enum PARAM {
        CONTEXT, WEBDRIVER;
    }

    public Object getBean(String beanName) {
        return ((AbstractApplicationContext)THREAD_PARAM.get(Thread.currentThread().getId()).get(PARAM.CONTEXT))
                .getBean(beanName);
    }

    public WebDriver getWebDriver() {
        return (WebDriver)THREAD_PARAM.get(Thread.currentThread().getId()).get(PARAM.WEBDRIVER);
    }

    @BeforeMethod
    public void beforeTestMethod() {
        Long threadId = Thread.currentThread().getId();

        ClassPathXmlApplicationContext applicationContext;
        if (!THREAD_PARAM.containsKey(threadId)) {

            Map<PARAM, Object> map = new HashMap<PARAM, Object>();
            map.put(PARAM.CONTEXT, applicationContext = new ClassPathXmlApplicationContext(CONTEXT_PATH));


            try {
                map.put(PARAM.WEBDRIVER, new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                        DesiredCapabilities.firefox()));
            } catch (Exception e) {
//                e.printStackTrace();
                try {
                    map.put(PARAM.WEBDRIVER,
                            WebDriverFactory.getChromeWebDriver(((SetupTemplateModel) applicationContext.getBean("setupTemplateModel")).getWorkPlace()));
                }
                catch (Exception xe) {
                    map.put(PARAM.WEBDRIVER,
                            WebDriverFactory.getFirefoxWebDriver());
                }
            }

            THREAD_PARAM.put(threadId, map);

        }

    }

    @AfterMethod
    public void afterTestMethod() {
        Long threadId = Thread.currentThread().getId();
        ((WebDriver)THREAD_PARAM.get(threadId).get(PARAM.WEBDRIVER)).manage().deleteAllCookies();
        ((AbstractApplicationContext) THREAD_PARAM.get(threadId).get(PARAM.CONTEXT)).refresh();

    }

    @AfterSuite
    public void afterSuite() {
        for (Map<PARAM, Object> map : THREAD_PARAM.values()) {
            if((WebDriver)map.get(PARAM.WEBDRIVER) != null) {
                ((WebDriver) map.get(PARAM.WEBDRIVER)).quit();
            }
        }
    }

    @BeforeSuite
    public void beforeSuite() {

    }



}
