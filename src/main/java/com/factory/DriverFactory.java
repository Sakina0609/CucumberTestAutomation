package com.factory;

import com.qa.util.EnumBrowser;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver init_driver(EnumBrowser browser) {
        browser.browserValue().setup();
        tlDriver.set(browser.getDriverValue());
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver(){
        return tlDriver.get();
    }
}
