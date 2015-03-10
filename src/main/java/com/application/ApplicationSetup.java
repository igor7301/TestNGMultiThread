package com.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;

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
        if (!THREAD_PARAM.containsKey(threadId)) {

            Map<PARAM, Object> map = new HashMap<PARAM, Object>();
            map.put(PARAM.CONTEXT, new ClassPathXmlApplicationContext(CONTEXT_PATH));
            map.put(PARAM.WEBDRIVER, new FirefoxDriver());

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