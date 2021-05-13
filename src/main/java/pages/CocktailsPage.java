package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

import static Utils.Waiters.waitForElementToBeVisible;

public class CocktailsPage extends AbstractPage{

    public CocktailsPage() {
        super();
    }

    @Step
    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(findVeryBerrySlushieRecipe, 3);

    }

    @FindBy(css = ".selected span")
    private WebElement findSelectType;

    @FindBy(css = ".filter-options [data-value=\"red\"]")
    private WebElement selectRedWineCocktails;

    @FindBy(css = "[href=\"mulled-wine\"]")
    private WebElement findMulledWineRecipe;

    @FindBy(css = "[href=\"red-wine-spritzer\"]")
    private WebElement findRedWineSpritzerRecipe;

    @FindBy(css = "[href=\"chocolate-fondue\"]")
    private WebElement findChocolateFondueRecipe;

    @FindBy(css = "[href=\"yellow-tailshake\"]")
    private WebElement findYellowTailshakeRecipe;

    @FindBy(css = "[href=\"red-hot-chocolate\"]")
    private WebElement findRedHotChocolateRecipe;

    @FindBy(css = "[href=\"winter-red-spritz\"]")
    private WebElement findWinterRedSpritzRecipe;

    @FindBy(css = "[href=\"very-berry-slushie\"]")
    private WebElement findVeryBerrySlushieRecipe;

    @FindBy(css = "[href=\"raspberry-rose\"]")
    private WebElement findRaspberryRoseRecipe;

    @FindBy(css = ".filter-options [data-value=\"bubbles\"]")
    private WebElement selectSparklingWineCocktails;


    @Step
    public void clickSelectType(){
        findSelectType.click();
    }

    @Step
    public void clickOnRedWineCocktailsType(){
        selectRedWineCocktails.click();
    }

    @Step
    public boolean getListOfCocktailsRecipes(){
        List<WebElement> wineRecipes = new ArrayList<>();

        boolean isAllNotShown = true;
        wineRecipes.add(findMulledWineRecipe);
        wineRecipes.add(findRedWineSpritzerRecipe);
        wineRecipes.add(findChocolateFondueRecipe);
        wineRecipes.add(findYellowTailshakeRecipe);
        wineRecipes.add(findRedHotChocolateRecipe);
        wineRecipes.add(findWinterRedSpritzRecipe);
        wineRecipes.add(findVeryBerrySlushieRecipe);

        for (WebElement item: wineRecipes) {
            if (!item.isDisplayed()) {
                isAllNotShown = false;
                return isAllNotShown;
            }
        };

            return isAllNotShown;
    }

    @Step
    public RecipePage clickOnRaspberryRoseRecipe(){
        findRaspberryRoseRecipe.click();
        return new RecipePage();
    }

    @Step
    public void clickOnSparklingWineCocktailsType(){
        selectSparklingWineCocktails.click();
    }

    @Step
    public String checkMultipleType(){
        return findSelectType.getText();
    }

    @Step
    public int getListOfMultipleCocktailsRecipes(){
        return DriverProvider.getDriver().findElements(By.cssSelector("[data-types=\"bubbles\"], [data-types=\"red\"]")).size();
        }

}
