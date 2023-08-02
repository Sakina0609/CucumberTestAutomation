package com.qa.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.VoidDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public enum EnumBrowser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    SAFARI("safari"),
    HEADLESS("headless");
    private String browserName;

    EnumBrowser(String browserName) {
        this.browserName = browserName;
    }

    public WebDriverManager browserValue() {
        switch (this) {
            case CHROME:
                return WebDriverManager.chromedriver();
            case FIREFOX:
                return WebDriverManager.firefoxdriver();
            case EDGE:
                return WebDriverManager.edgedriver();
            case SAFARI:
                return WebDriverManager.safaridriver();
            case HEADLESS:
            default:
                return new VoidDriverManager();
        }
    }

    public WebDriver getDriverValue() {

        switch (this){
            case CHROME: return new ChromeDriver();
            case FIREFOX: return new FirefoxDriver();
            case EDGE: return new EdgeDriver();
            case SAFARI: return new SafariDriver();
            case HEADLESS:
            default:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                return new ChromeDriver(options);
        }
    }
}




