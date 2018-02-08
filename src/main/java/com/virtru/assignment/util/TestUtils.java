package com.virtru.assignment.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestUtils {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            URL url = ClassLoader.getSystemClassLoader().getResource("chromedriver");
            System.setProperty("webdriver.chrome.driver", url.getPath());
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }
}
