package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

import static utils.Waiters.waitForElementToBeVisible;

public class CocktailsPage extends AbstractPage{

    public CocktailsPage() {
        super();
    }

    @Step("wait element is loaded")
    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(recipes.get(0), 3);

    }

    @FindBy(css = ".selected span")
    private WebElement findSelectType;

    @FindBy(css = ".filter-options [data-value=\"red\"]")
    private WebElement selectRedWineCocktails;

    @FindBy(css = "[href=\"raspberry-rose\"]")
    private WebElement findRaspberryRoseRecipe;

    @FindBy(css = ".filter-options [data-value=\"bubbles\"]")
    private WebElement selectSparklingWineCocktails;

    @FindBy(css = "[data-types=\"bubbles\"], [data-types=\"red\"]")
    private List<WebElement> recipesOnPage;

    @FindBy(css = "[href=\"mulled-wine\"], [href=\"red-wine-spritzer\"], [href=\"chocolate-fondue\"], [href=\"yellow-tailshake\"], [href=\"red-hot-chocolate\"], [href=\"winter-red-spritz\"], [href=\"very-berry-slushie\"]")
    private List<WebElement> recipes;

    @Step("click on Select")
    public void clickSelectType(){
        findSelectType.click();
    }

    @Step("Select Red Wine Cocktails group")
    public void clickOnRedWineCocktailsType(){
        selectRedWineCocktails.click();
    }

    @Step("check list of Cocktails recipes ")
    public int getListOfCocktailsRecipes(){
        return recipes.size();
    }

    @Step("navigate to RecipePage")
    public RecipePage clickOnRaspberryRoseRecipe(){
        findRaspberryRoseRecipe.click();
        return new RecipePage();
    }

    @Step("select Sparkling Wine Cocktails group")
    public void clickOnSparklingWineCocktailsType(){
        selectSparklingWineCocktails.click();
    }

    @Step("check MULTIPLE type is visible")
    public String checkMultipleType(){
        return findSelectType.getText();
    }

    @Step("check list of recipes on page ")
    public int getListOfMultipleCocktailsRecipes(){
        return recipesOnPage.size();
        }

}
