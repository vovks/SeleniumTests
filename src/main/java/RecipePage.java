import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecipePage {
    WebDriver driver;

    public RecipePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ingredients")
    private WebElement findIngredients;

    public boolean checkIngredients(){
        findIngredients.isDisplayed();
        return true;
    }
}
