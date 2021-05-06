import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomeworkSelenium {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yellowtailwine.com");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterEach
    public void after(){
        driver.quit();
    }

    @Test
    //Case 1: Welcome page: all required elements are displayed
    public void navigationWelcomePageElements() {
        WelcomePage welcomePage = new WelcomePage(driver);

        Assertions.assertTrue(welcomePage.getConfirmationText().contains("I am of legal drinking age in"));
        Assertions.assertTrue(welcomePage.getConfirmationCheckbox());
        Assertions.assertTrue(welcomePage.getElementSelect());
        Assertions.assertTrue(welcomePage.checkWelcomeButtonIsDisabled());
    }

    @Test
    //Case 2: Welcome page: navigate to main page as European customer
    public void navigationWelcomePageEurope() {
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();

        Assertions.assertTrue(mainPage.getElementMenu().contains("MENU"));
        Assertions.assertFalse(driver.getPageSource().contains("no-scroll"));
    }

    @Test
    //Case 3: Main page: all required elements are displayed
    public void navigationMainPageElements() {
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();

        Assertions.assertTrue(mainPage.searchElementMenu());
        Assertions.assertTrue(mainPage.searchBigText());
        Assertions.assertTrue(mainPage.searchSmallerText());
        Assertions.assertTrue(mainPage.searchFindWineButton());
        Assertions.assertTrue(mainPage.searchElementFooter());
    }

    @Test
    //Case 4: Main page: Menu button logic (open header)
    public void verifyingHeaderOpening() {
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();

        mainPage.clickElementMenu();
        mainPage.waitForHeaderLink();

        Assertions.assertTrue(mainPage.getHeaderLinks());

        mainPage.clickYellowTailElement();
        mainPage.waitForElementMenu();

        Assertions.assertTrue(mainPage.searchElementMenu());
    }

    @Test
    //Case 5: Main page: Menu button logic (close header)
    public void verifyingHeaderClosing() {

        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();

        mainPage.clickElementMenu();
        mainPage.clickYellowTailElement();

        Assertions.assertTrue(mainPage.searchElementMenu());

    }

    @Test
    //Case 6: Main page: Global Nav logic
    public void navigateToChina() {
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        mainPage.clickCountrySelect();

        ChinaYellowTailPage chinaPage = mainPage.clickCountryChina();

        chinaPage.waitForElementFindWineButtonChina();

        Assertions.assertTrue(chinaPage.checkFindWineButtonChina().contains("发现适合你的酒"));
    }

    @Test
    //Case 7: Main page: Global Nav logic (CHINA - separate site is open)
    public void navigationChinaWeiboTab() {
        //driver.manage().deleteAllCookies();
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        mainPage.clickCountrySelect();

        ChinaYellowTailPage chinaPage = mainPage.clickCountryChina();

        chinaPage.waitForElementFindWineButtonChina();

        chinaPage.clickWeiboButton();

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
    public void navigateToStores() {
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        WhereToBuyPage storesPage = mainPage.clickWhereToBuy();

        storesPage.sendTextInLocationField();
        storesPage.clickSearchButton();

        Assertions.assertTrue(storesPage.getElementResults());
    }

    @Test
    //Case 9: Cocktails: Select one wine
    public void navigationCocktails() {
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        CocktailsPage cocktailsPage = mainPage.clickCocktails();

        cocktailsPage.clickSelectType();
        cocktailsPage.clickOnRedWineCocktailsType();
        cocktailsPage.clickSelectType();

        cocktailsPage.waitForWineRecipes();

        Assertions.assertTrue(cocktailsPage.getListOfCocktailsRecipes());
    }

    @Test
    //Case 10: Cocktails: Navigate to Cocktail recipe page
    public void navigationCocktailRecipe() {
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        CocktailsPage cocktailsPage = mainPage.clickCocktails();

        RecipePage recipePage = cocktailsPage.clickOnRaspberryRoseRecipe();

        Assertions.assertTrue(recipePage.checkIngredients());
    }

    @Test
    //Case 11: Cocktails: Select several wines
    public void navigationSeveralWineCocktail() {
        WelcomePage welcomePage = new WelcomePage(driver);
        MainPage mainPage = welcomePage.welcomePageIsPassed();
        mainPage.clickElementMenu();
        CocktailsPage cocktailsPage = mainPage.clickCocktails();

        cocktailsPage.clickSelectType();
        cocktailsPage.clickOnRedWineCocktailsType();
        cocktailsPage.clickOnSparklingWineCocktailsType();

        Assertions.assertTrue(cocktailsPage.checkMultipleType().contains("Multiple"));

        Assertions.assertEquals(cocktailsPage.getListOfMultipleCocktailsRecipes(), 18);
    }

}
