package core;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static core.Propiedades.*;
import static core.Propiedades.Browser.*;
import static core.Propiedades.Browser.CHROME;
import static core.Propiedades.Browser.FIREFOX;
import static core.Propiedades.browser;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory() {}

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver initDriver(){
        WebDriver driver = null;
        switch (Propiedades.browser) {
            case FIREFOX: driver = new FirefoxDriver(); break;
            case CHROME: driver = new ChromeDriver(); break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void killDriver(){
        WebDriver driver = getDriver();
        if(driver != null) {
            driver.quit();
            driver = null;
        }
        if(threadDriver != null) {
            threadDriver.remove();
        }
    }

}
