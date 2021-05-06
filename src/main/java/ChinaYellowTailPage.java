import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChinaYellowTailPage {
    WebDriver driver;

    public ChinaYellowTailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href=\"/basic\"]>.sgg-comp-button-inner")
    private WebElement findWineButtonChina;

    @FindBy(css = ".sgg-comp-social-icon>.fa.fa-weibo")
    private WebElement findWeiboButton;

    public String checkFindWineButtonChina(){
        return findWineButtonChina.getText();
    }

    public void clickWeiboButton(){
        findWeiboButton.click();
    }

    public void waitForElementFindWineButtonChina(){
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOf(findWineButtonChina));
    }
}
