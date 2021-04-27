import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstTest {
    WebDriver driver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void after(){
        driver.quit();
        System.out.println("Success");
    }

    @Test
    public void navigateToMainPage() throws InterruptedException {
        driver.get("https://www.google.com/");

        By searchField = By.cssSelector(".gLFyf.gsfi");
        WebElement searchElement = driver.findElement(searchField);

        searchElement.click();

        Thread.sleep(1000);

        searchElement.sendKeys("Ананас");
        searchElement.sendKeys(Keys.ENTER);

        By searchResultsSelector = By.cssSelector(".LC20lb.DKV0Md");
        List <WebElement> searchResults = driver.findElements(searchResultsSelector);

       /* for (WebElement item: searchResults){
            Assertions.assertTrue(item.getText().contains("Ананас"));
        }*/

        Assertions.assertTrue(searchResults.get(0).getText().contains("Ананас"));

    }

    
}
