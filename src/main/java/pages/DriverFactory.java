package pages;

import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(BrowserType browserName) {
        WebDriver driver = null;

        switch (browserName){
            case CHROME:
                System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty(Constants.SYSTEM_PROPERTY_FIREFOX_DRIVER, Constants.PATH_TO_FIREFOX_DRIVER);
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
