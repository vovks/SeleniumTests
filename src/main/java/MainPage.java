import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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


    public String getElementMenu(){
        return elementMenu.getText();
    }

    public boolean searchElementMenu(){
        elementMenu.isDisplayed();
        return true;
    }

    public boolean searchBigText(){
        bigText.isDisplayed();
        return true;
    }

    public boolean searchSmallerText(){
        smallerText.isDisplayed();
        return true;
    }

    public boolean searchFindWineButton(){
        findWineButton.isDisplayed();
        return true;
    }

    public boolean searchElementFooter(){
        elementFooter.isDisplayed();
        return true;
    }

    public void clickElementMenu(){
        elementMenu.click();
    }


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
           item.isDisplayed();
        }
        return true;
    }

    public void waitForHeaderLink(){
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOf(headerContactUs));
    }

    public void clickYellowTailElement(){
        headerYellowTail.click();
    }

    public void waitForElementMenu(){
        (new WebDriverWait(driver, Duration.ofSeconds(3)))
                .until(ExpectedConditions.visibilityOf(elementMenu));
    }

    public void clickCountrySelect(){
        headerCountrySelect.click();
    }

    public ChinaYellowTailPage clickCountryChina(){
        countryChina.click();
        return new ChinaYellowTailPage(driver);
    }

    public WhereToBuyPage clickWhereToBuy(){
        headerWhereToBuy.click();
        return new WhereToBuyPage(driver);
    }

    public CocktailsPage clickCocktails(){
        headerCocktails.click();
        return new CocktailsPage(driver);
    }

}
