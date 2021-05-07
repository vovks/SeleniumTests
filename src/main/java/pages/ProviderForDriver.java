package pages;

import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProviderForDriver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver createDriver() {
        String browserName = "chrome";

        if(browserName == "chrome") {
            System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
            return new ChromeDriver();
        } else {
            System.setProperty(Constants.SYSTEM_PROPERTY_FIREFOX_DRIVER, Constants.PATH_TO_FIREFOX_DRIVER);
            return new FirefoxDriver();
        }
    }

    public static WebDriver getDriver(){
        if(driver.get() == null){
            driver.set(createDriver());
        }
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }
}
