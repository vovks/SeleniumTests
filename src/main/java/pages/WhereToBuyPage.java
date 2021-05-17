package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementToBeVisible;

public class WhereToBuyPage extends AbstractPage {

    public WhereToBuyPage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(findElementResults, 3);
    }

    @FindBy(id = "locationName")
    private WebElement findElementLocation;

    @FindBy(css = ".search-submit")
    private WebElement findSearchSubmitButton;

    @FindBy(css = ".tiles > .tile")
    private WebElement findElementResults;

    @Step("click on Search button")
    public void clickSearchButton(){
        findSearchSubmitButton.click();
    }

    @Step("Enter data in --Your location-- field")
    public void sendTextInLocationField(){
        findElementLocation.click();
        findElementLocation.sendKeys("Austrian Club");
    }

    @Step("Results of search are visible")
    public boolean getElementResults(){
        try {
            if (findElementResults.isDisplayed()){
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }
        return findElementResults.isDisplayed();
    }
}
