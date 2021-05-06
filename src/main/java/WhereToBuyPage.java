import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhereToBuyPage {
    WebDriver driver;

    public WhereToBuyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "locationName")
    private WebElement findElementLocation;

    @FindBy(css = ".search-submit")
    private WebElement findSearchSubmitButton;

    @FindBy(css = ".tiles > .tile")
    private WebElement findElementResults;

    public void clickOnElementLocation(){
        findElementLocation.click();
    }

    public void clickSearchButton(){
        findSearchSubmitButton.click();
    }

    public void sendTextInLocationField(){
        findElementLocation.click();
        findElementLocation.sendKeys("Austrian Club");
    }

    public boolean getElementResults(){
        return findElementResults.isDisplayed();
    }

    /*WebElement searchElementLocation = driver.findElement(By.id("locationName"));
        searchElementLocation.click();

        searchElementLocation.sendKeys("Austrian Club");

        WebElement searchElementSubmit = driver.findElement(By.cssSelector(".search-submit"));
        searchElementSubmit.click();

        WebElement searchElementResults = driver.findElement(By.cssSelector(".tiles > .tile"));

        Assertions.assertTrue(searchElementResults.isDisplayed());*/
}
