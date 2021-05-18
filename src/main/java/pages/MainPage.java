package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static utils.Waiters.waitForElementToBeVisible;

public class MainPage extends AbstractPage{

    public MainPage() {
        super();
    }

    @Step("wait elements are loaded")
    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(elementMenu,3);
        waitForElementToBeVisible(headerLinks.get(0),3);
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

    @FindBy (css = ".main-nav [href$='/stores/']")
    private WebElement headerWhereToBuy;

    @FindBy (css = ".main-nav [href$='/cocktails/']")
    private WebElement headerCocktails;

    @FindBy (css = ".main-nav [href='#']")
    private WebElement headerCountrySelect;

    @FindBy (css = ".main-nav [href$='/wines/'], .main-nav [href$='/stores/'], .main-nav [href$='/cocktails/'], .main-nav [href$='/our-story/'], .main-nav [href$='/faqs/'], .main-nav [href$='/contact/'], .main-nav [href='#']")
    List<WebElement> headerLinks;

    @FindBy (css = ".top-nav.-active [href$='.com']")
    private WebElement headerYellowTail;

    @FindBy (css = "[href$='cn/']")
    private WebElement countryChina;


    @Step("check --Menu-- text is visible")
    public String getElementMenu(){
        return elementMenu.getText();
    }

    @Step("check element Menu is visible")
    public boolean searchElementMenu(){
        try {
            return elementMenu.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("check --WELCOME TO THE WORLD OF [Yellow tail]-- is visible")
    public boolean searchBigText(){
        try {
            return bigText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("check --We are passionate about creating great tasting, quality wines for everyone to enjoy-- is visible")
    public boolean searchSmallerText(){
        try {
            return smallerText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("check --find your wine button-- is visible")
    public boolean searchFindWineButton(){
        try {
            return findWineButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("check footer is visible")
    public boolean searchElementFooter(){
        try {
            return elementFooter.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("click on Menu")
    public void clickElementMenu(){
        elementMenu.click();
    }

    @Step("check all header links are visible")
    public int getHeaderLinks(){
        return headerLinks.size();
    }

    @Step("click on [yellow tail] header")
    public void clickYellowTailElement(){
        headerYellowTail.click();
    }

    @Step("click on CountrySelect")
    public void clickCountrySelect(){
        headerCountrySelect.click();
    }

    @Step("navigate to China Page")
    public ChinaYellowTailPage clickCountryChina(){
        countryChina.click();
        return new ChinaYellowTailPage();
    }

    @Step("click on --Where To Buy-- Page")
    public WhereToBuyPage clickWhereToBuy(){
        headerWhereToBuy.click();
        return new WhereToBuyPage();
    }

    @Step("click on Cocktails Page")
    public CocktailsPage clickCocktails(){
        headerCocktails.click();
        return new CocktailsPage();
    }

}
