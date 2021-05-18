package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static utils.Waiters.waitForElementToBeVisible;


public class WelcomePage extends AbstractPage{

    public WelcomePage() {
        super();
    }

    @Step("wait element is loaded")
    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(welcomeButton, 3);

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

    @Step("confirmation text --I am of legal drinking age in-- is visible")
    public String getConfirmationText(){
        return getConfirmationText.getText();
    }

    @Step("confirmation Checkbox before --I am of legal drinking age in-- is visible")
    public boolean getConfirmationCheckbox(){
        try {
            return confirmationCheckbox.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Dropdown with Select is visible")
    public boolean getElementSelect(){
        try {
            return elementSelect.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Welcome button is visible")
    public boolean checkWelcomeButtonIsDisabled(){
        try {
            return welcomeButtonIsDisabled.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("navigate to Main Page")
    public MainPage welcomePageIsPassed(){
        confirmationCheckbox.click();

        Select select = new Select(elementSelect);
        select.selectByIndex(3);

        welcomeButton.click();
        return new MainPage();
    }

}

