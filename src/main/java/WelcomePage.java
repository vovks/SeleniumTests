import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class WelcomePage {
    WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[for=\"confirm\"]")
    private WebElement getConfirmationText;

    @FindBy(css = "div.confirmation-checkbox > label")
    private WebElement confirmationCheckbox;

    @FindBy(css = ".agegate-selector-options")
    private WebElement elementSelect;

    @FindBy(css = "[value=Welcome][disabled]")
    private WebElement welcomeButtonIsDisabled;

    @FindBy(css = "[value=Welcome]")
    private WebElement welcomeButton;

    public String getConfirmationText(){
        return getConfirmationText.getText();
    }

    public boolean getConfirmationCheckbox(){
        confirmationCheckbox.isDisplayed();
        return true;
    }

    public boolean getElementSelect(){
        elementSelect.isDisplayed();
        return true;
    }

    public boolean checkWelcomeButtonIsDisabled(){
        welcomeButtonIsDisabled.isDisplayed();
        return true;
    }

    public MainPage welcomePageIsPassed(){
        confirmationCheckbox.click();

        Select select = new Select(elementSelect);
        select.selectByIndex(3);

        welcomeButton.click();
        return new MainPage(driver);
    }

}

