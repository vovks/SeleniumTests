package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementToBeVisible;

public class RecipePage extends AbstractPage {

    public RecipePage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(findIngredients, 3);
    }

    @FindBy(css = ".ingredients")
    private WebElement findIngredients;

    @Step("check Ingredients for recipe")
    public boolean checkIngredients(){
        try {
            if (findIngredients.isDisplayed()){
                return true;
            }
        }
        catch (Exception e) {
            return false;
        }
       return findIngredients.isDisplayed();
    }
}
