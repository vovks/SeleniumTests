package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhereToBuyPage extends AbstractPage {

    public WhereToBuyPage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {

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
}
