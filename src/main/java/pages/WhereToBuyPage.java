package pages;

import io.qameta.allure.Step;
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

    @Step
    public void clickOnElementLocation(){
        findElementLocation.click();
    }

    @Step
    public void clickSearchButton(){
        findSearchSubmitButton.click();
    }

    @Step
    public void sendTextInLocationField(){
        findElementLocation.click();
        findElementLocation.sendKeys("Austrian Club");
    }

    @Step
    public boolean getElementResults(){
        return findElementResults.isDisplayed();
    }
}
