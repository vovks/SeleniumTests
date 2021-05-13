package pages;

import Utils.Constants;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static Utils.Constants.FILENAME_WITH_PROPERTIES;

public class DriverProvider {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    /*public static WebDriver createDriver() {
        String browserName = "chrome";

        if(browserName == "chrome") {
            System.setProperty(Constants.SYSTEM_PROPERTY_CHROME_DRIVER, Constants.PATH_TO_CHROME_DRIVER);
            return new ChromeDriver();
        } else {
            System.setProperty(Constants.SYSTEM_PROPERTY_FIREFOX_DRIVER, Constants.PATH_TO_FIREFOX_DRIVER);
            return new FirefoxDriver();
        }
    }*/

    public static WebDriver getDriver(){
        if(driver.get() == null){
            //driver.set(createDriver());
            String browserType = loadProperties().getProperty("browserType");
            driver.set(DriverFactory.createDriver(BrowserType.valueOf(browserType)));
        }
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().quit();
        driver.remove();
    }

    public static Properties loadProperties(){
        String current = System.getProperty("user.dir");
        String separator = System.getProperty("file.separator");
        String resourcesFolder = "src" + separator + "main" + separator + "resources";

        Path file = Paths.get(current + separator + resourcesFolder + separator + FILENAME_WITH_PROPERTIES);

        Properties properties = new Properties();
        try {
            properties.load(Files.newInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("No such properties file");
        }
        return properties;
    }
}
