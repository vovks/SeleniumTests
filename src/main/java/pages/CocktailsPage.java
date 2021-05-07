package pages;

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


    public void clickSelectType(){
        findSelectType.click();
    }

    public void clickOnRedWineCocktailsType(){
        selectRedWineCocktails.click();
    }

    public boolean getListOfCocktailsRecipes(){
        List<WebElement> wineRecipes = new ArrayList<>();

        wineRecipes.add(findMulledWineRecipe);
        wineRecipes.add(findRedWineSpritzerRecipe);
        wineRecipes.add(findChocolateFondueRecipe);
        wineRecipes.add(findYellowTailshakeRecipe);
        wineRecipes.add(findRedHotChocolateRecipe);
        wineRecipes.add(findWinterRedSpritzRecipe);
        wineRecipes.add(findVeryBerrySlushieRecipe);

        for (WebElement item: wineRecipes) {
            item.isDisplayed();
        }
        return true;
    }

    public RecipePage clickOnRaspberryRoseRecipe(){
        findRaspberryRoseRecipe.click();
        return new RecipePage();
    }

    public void clickOnSparklingWineCocktailsType(){
        selectSparklingWineCocktails.click();
    }

    public String checkMultipleType(){
        return findSelectType.getText();
    }

    public int getListOfMultipleCocktailsRecipes(){
        return ProviderForDriver.getDriver().findElements(By.cssSelector("[data-types=\"bubbles\"], [data-types=\"red\"]")).size();
        }

}
