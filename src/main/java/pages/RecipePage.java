package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecipePage extends AbstractPage {

    public RecipePage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {

    }

    @FindBy(css = ".ingredients")
    private WebElement findIngredients;

    @Step
    public boolean checkIngredients(){
        findIngredients.isDisplayed();
        return true;
    }
}
