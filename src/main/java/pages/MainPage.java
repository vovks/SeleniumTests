package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;
import static Utils.Waiters.waitForElementToBeVisible;

public class MainPage extends AbstractPage{

    public MainPage() {
        super();
    }

    @Step
    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(elementMenu,3);
        waitForElementToBeVisible(headerContactUs,3);
    }


    @FindBy (css = ".fa.fa-bars span")
    private WebElement elementMenu;

    @FindBy (css = ".content.animation-screen.-one >h2")
    private WebElement bigText;

    @FindBy (css = ".content.animation-screen.-one > .header-sub-copy")
    private WebElement smallerText;

    @FindBy (css = ".content.animation-screen.-one > .button.home-button")
    private WebElement findWineButton;

    @FindBy (id = "primary-footer")
    private WebElement elementFooter;

    @FindBy (css = ".main-nav [href$='/wines/']")
    private WebElement headerWines;

    @FindBy (css = ".main-nav [href$='/stores/']")
    private WebElement headerWhereToBuy;

    @FindBy (css = ".main-nav [href$='/cocktails/']")
    private WebElement headerCocktails;

    @FindBy (css = ".main-nav [href$='/our-story/']")
    private WebElement headerOurStory;

    @FindBy (css = ".main-nav [href$='/faqs/']")
    private WebElement headerFaqs;

    @FindBy (css = ".main-nav [href$='/contact/']")
    private WebElement headerContactUs;

    @FindBy (css = ".main-nav [href='#']")
    private WebElement headerCountrySelect;

    @FindBy (css = ".top-nav.-active [href$='.com']")
    private WebElement headerYellowTail;

    @FindBy (css = "[href$='cn/']")
    private WebElement countryChina;


    @Step
    public String getElementMenu(){
        return elementMenu.getText();
    }

    @Step
    public boolean searchElementMenu(){
        elementMenu.isDisplayed();
        return true;
    }

    @Step
    public boolean searchBigText(){
        bigText.isDisplayed();
        return true;
    }

    @Step
    public boolean searchSmallerText(){
        smallerText.isDisplayed();
        return true;
    }

    @Step
    public boolean searchFindWineButton(){
        findWineButton.isDisplayed();
        return true;
    }

    @Step
    public boolean searchElementFooter(){
        elementFooter.isDisplayed();
        return true;
    }

    @Step
    public void clickElementMenu(){
        elementMenu.click();
    }

    @Step
    public boolean getHeaderLinks(){
        List<WebElement> headerLinks = new ArrayList<>();

        headerLinks.add(headerWines);
        headerLinks.add(headerWhereToBuy);
        headerLinks.add(headerCocktails);
        headerLinks.add(headerOurStory);
        headerLinks.add(headerFaqs);
        headerLinks.add(headerContactUs);
        headerLinks.add(headerCountrySelect);

        for (WebElement item: headerLinks) {
            if (!item.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    @Step
    public void clickYellowTailElement(){
        headerYellowTail.click();
    }

    @Step
    public void clickCountrySelect(){
        headerCountrySelect.click();
    }

    @Step
    public ChinaYellowTailPage clickCountryChina(){
        countryChina.click();
        return new ChinaYellowTailPage();
    }

    @Step
    public WhereToBuyPage clickWhereToBuy(){
        headerWhereToBuy.click();
        return new WhereToBuyPage();
    }

    @Step
    public CocktailsPage clickCocktails(){
        headerCocktails.click();
        return new CocktailsPage();
    }

}
