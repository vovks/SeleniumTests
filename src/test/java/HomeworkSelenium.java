import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class HomeworkSelenium {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    }

    @AfterEach
    public void after(){
        driver.quit();
    }

    @Test
    //Case 1: Welcome page: all required elements are displayed
    public void navigationWelcomePageElements() {
        WebElement confirmationText = driver.findElement(By.cssSelector("[for=\"confirm\"]"));
        Assertions.assertTrue(confirmationText.getText().contains("I am of legal drinking age in"));


        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        Assertions.assertTrue(confirmationCheckbox.isDisplayed());


        WebElement searchElementSelect = driver.findElement(By.cssSelector(".agegate-selector-options"));
        Assertions.assertTrue(searchElementSelect.isDisplayed());


        WebElement welcomeButtonDisabling = driver.findElement(By.cssSelector("[value=Welcome][disabled]"));
        Assertions.assertTrue(welcomeButtonDisabling.isDisplayed());
    }

    @Test
    //Case 2: Welcome page: navigate to main page as European customer
    public void navigationWelcomePageEurope() {
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();


        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=Welcome]"));

        welcomeButton.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        Assertions.assertTrue(searchElementMenu.getText().contains("MENU"));
        Assertions.assertFalse(driver.getPageSource().contains("no-scroll"));
    }

    @Test
    //Case 3: Main page: all required elements are displayed
    public void navigationMainPageElements() {
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=Welcome]"));

        welcomeButton.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));
        Assertions.assertTrue(searchElementMenu.isDisplayed());

        WebElement searchBigText = driver.findElement(By.cssSelector(".content.animation-screen.-one >h2"));
        Assertions.assertTrue(searchBigText.isDisplayed());

        WebElement searchSmallerText = driver.findElement(By.cssSelector(".content.animation-screen.-one > .header-sub-copy"));
        Assertions.assertTrue(searchSmallerText.isDisplayed());

        WebElement searchFindWineButton = driver.findElement(By.cssSelector(".content.animation-screen.-one > .button.home-button"));
        Assertions.assertTrue(searchFindWineButton.isDisplayed());

        WebElement searchElementFooter = driver.findElement(By.id("primary-footer"));
        Assertions.assertTrue(searchElementFooter.isDisplayed());
    }

    @Test
    //Case 4: Main page: Menu button logic (open header)
    public void verifyingHeaderOpening() throws InterruptedException {
        WebElement searchElementCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        searchElementCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);


        WebElement searchWelcomeButton = driver.findElement(By.cssSelector("[value=Welcome]"));

        searchWelcomeButton.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        searchElementMenu.click();
        Thread.sleep(1000);
        //не знаю как убрать

        List<WebElement> headerLinks = new ArrayList<>();

        headerLinks.add(driver.findElement(By.cssSelector(".main-nav [href$='/wines/']")));
        headerLinks.add(driver.findElement(By.cssSelector(".main-nav [href$='/stores/']")));
        headerLinks.add(driver.findElement(By.cssSelector(".main-nav [href$='/cocktails/']")));
        headerLinks.add(driver.findElement(By.cssSelector(".main-nav [href$='/our-story/']")));
        headerLinks.add(driver.findElement(By.cssSelector(".main-nav [href$='/faqs/']")));
        headerLinks.add(driver.findElement(By.cssSelector(".main-nav [href='#']")));

        for (WebElement item: headerLinks) {
            Assertions.assertTrue(item.isDisplayed());
        }

        WebElement searchElementYellow = driver.findElement(By.cssSelector(".top-nav.-active [href$='.com']"));

        searchElementYellow.click();
        WebElement explicitWait = (new WebDriverWait(driver,Duration.ofSeconds(3)))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fa.fa-bars span")));

        searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        Assertions.assertTrue(searchElementMenu.isDisplayed());
    }

    @Test
    //Case 5: Main page: Menu button logic (close header)
    public void verifyingHeaderClosing() {
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=Welcome]"));

        welcomeButton.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        searchElementMenu.click();

        WebElement searchElementYellow = driver.findElement(By.cssSelector(".top-nav.-active [href$='.com']"));

        searchElementYellow.click();

        searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        Assertions.assertTrue(searchElementMenu.isDisplayed());
    }

    @Test
    //Case 6: Main page: Global Nav logic
    public void navigationChina() {
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement searchElementWelcome = driver.findElement(By.cssSelector("[value=Welcome]"));

        searchElementWelcome.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        searchElementMenu.click();

        WebElement searchElementLanguage = driver.findElement(By.cssSelector(".main-nav [href='#']"));

        searchElementLanguage.click();

        WebElement searchElementChina= driver.findElement(By.cssSelector("[href$='cn/']"));

        searchElementChina.click();

        WebElement searchWineButton= driver.findElement(By.cssSelector("[href=\"/basic\"]>.sgg-comp-button-inner"));

        Assertions.assertTrue(searchWineButton.getText().contains("发现适合你的酒"));
    }

    @Test
    //Case 7: Main page: Global Nav logic (CHINA - separate site is open)
    public void navigationChinaWeiboTab() {
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement searchElementWelcome = driver.findElement(By.cssSelector("[value=Welcome]"));

        searchElementWelcome.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        searchElementMenu.click();

        WebElement searchElementLanguage = driver.findElement(By.cssSelector(".main-nav [href='#']"));

        searchElementLanguage.click();

        WebElement searchElementChina = driver.findElement(By.cssSelector("[href$='cn/']"));

        searchElementChina.click();

        WebElement searchElementWeibo = driver.findElement(By.cssSelector(".sgg-comp-social-icon>.fa.fa-weibo"));

        searchElementWeibo.click();

        int winHandleNum = driver.getWindowHandles().size();
        if (winHandleNum > 1) {
            for (String winHandle:driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
        }



        Boolean explicitWait = (new WebDriverWait(driver,Duration.ofSeconds(15)))
                .until(ExpectedConditions.urlToBe("https://weibo.com/yellowtailChina"));

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://weibo.com/yellowtailChina"));
    }

    @Test
    //Case 8: Where to buy: enter valid postal code
    public void navigationStores() {
       WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement searchElementWelcome = driver.findElement(By.cssSelector("[value=Welcome]"));

        searchElementWelcome.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        searchElementMenu.click();

        WebElement searchElementStores = driver.findElement(By.cssSelector(".main-nav [href$='/stores/']"));
        searchElementStores.click();

        WebElement searchElementLocation = driver.findElement(By.id("locationName"));
        searchElementLocation.click();

        searchElementLocation.sendKeys("Austrian Club");

        WebElement searchElementSubmit = driver.findElement(By.cssSelector(".search-submit"));
        searchElementSubmit.click();

        WebElement searchElementResults = driver.findElement(By.cssSelector(".tiles > .tile"));

        Assertions.assertTrue(searchElementResults.isDisplayed());
    }

    @Test
    //Case 9: Cocktails: Select one wine
    public void navigationCocktails() {
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement searchElementWelcome = driver.findElement(By.cssSelector("[value=Welcome]"));

        searchElementWelcome.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        searchElementMenu.click();

        WebElement searchElementLanguage = driver.findElement(By.cssSelector(".main-nav [href$='/cocktails/']"));

        searchElementLanguage.click();

        WebElement searchElementListCocktails = driver.findElement(By.cssSelector(".selected span"));

        searchElementListCocktails.click();

        WebElement searchElementCocktail = driver.findElement(By.cssSelector(".filter-options [data-value=\"red\"]"));

        searchElementCocktail.click();
        searchElementListCocktails.click();

        List<WebElement> wineRecipes = new ArrayList<>();
        wineRecipes.add(driver.findElement(By.cssSelector("[href=\"mulled-wine\"]")));
        wineRecipes.add(driver.findElement(By.cssSelector("[href=\"red-wine-spritzer\"]")));
        wineRecipes.add(driver.findElement(By.cssSelector("[href=\"chocolate-fondue\"]")));
        wineRecipes.add(driver.findElement(By.cssSelector("[href=\"yellow-tailshake\"]")));
        wineRecipes.add(driver.findElement(By.cssSelector("[href=\"red-hot-chocolate\"]")));
        wineRecipes.add(driver.findElement(By.cssSelector("[href=\"winter-red-spritz\"]")));
        wineRecipes.add(driver.findElement(By.cssSelector("[href=\"very-berry-slushie\"]")));

        for (WebElement item: wineRecipes) {
            Assertions.assertTrue(item.isDisplayed());
        }
    }

    @Test
    //Case 10: Cocktails: Navigate to Cocktail recipe page
    public void navigationCocktailRecipe() {
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement searchElementWelcome = driver.findElement(By.cssSelector("[value=Welcome]"));

        searchElementWelcome.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        searchElementMenu.click();

        WebElement searchElementLanguage = driver.findElement(By.cssSelector(".main-nav [href$='/cocktails/']"));

        searchElementLanguage.click();

        WebElement searchCocktailRecipe = driver.findElement(By.cssSelector("[href=\"raspberry-rose\"]"));

        searchCocktailRecipe.click();


        WebElement searchIngredients = driver.findElement(By.cssSelector(".ingredients"));

        Assertions.assertTrue(searchIngredients.isDisplayed());
    }

    @Test
    //Case 11: Cocktails: Select several wines
    public void navigationSeveralWineCocktail() {
        WebElement confirmationCheckbox = driver.findElement(By.cssSelector("div.confirmation-checkbox > label"));

        confirmationCheckbox.click();

        Select select = new Select(driver.findElement(By.cssSelector(".agegate-selector-options")));
        select.selectByIndex(3);

        WebElement welcomeButton = driver.findElement(By.cssSelector("[value=Welcome]"));

        welcomeButton.click();

        WebElement searchElementMenu = driver.findElement(By.cssSelector(".fa.fa-bars span"));

        searchElementMenu.click();

        WebElement headerCocktails = driver.findElement(By.cssSelector(".main-nav [href$='/cocktails/']"));

        headerCocktails.click();

        WebElement cocktailsList = driver.findElement(By.cssSelector(".selected span"));

        cocktailsList.click();

        WebElement redWineCocktails = driver.findElement(By.cssSelector(".filter-options [data-value=\"red\"]"));
        redWineCocktails.click();

        WebElement sparklingWineCocktails = driver.findElement(By.cssSelector(".filter-options [data-value=\"bubbles\"]"));
        sparklingWineCocktails.click();

        Assertions.assertTrue(cocktailsList.getText().contains("Multiple"));

        List <WebElement> wineRecipes = driver.findElements(By.cssSelector("[data-types=\"bubbles\"], [data-types=\"red\"]"));

        Assertions.assertEquals(wineRecipes.size(), 18);
    }

}
