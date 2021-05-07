package Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ProviderForDriver;

import java.time.Duration;

public class Waiters {
    public static WebElement waitForElementToBeVisible(WebElement webElement, int time){
        return (new WebDriverWait(ProviderForDriver.getDriver(), Duration.ofSeconds(time)))
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
