package pages;

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

    public boolean checkIngredients(){
        findIngredients.isDisplayed();
        return true;
    }
}
