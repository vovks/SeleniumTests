package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static Utils.Waiters.waitForElementToBeVisible;


public class WelcomePage extends AbstractPage{

    public WelcomePage() {
        super();
    }

    @Step
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

    @Step
    public String getConfirmationText(){
        return getConfirmationText.getText();
    }

    @Step
    public boolean getConfirmationCheckbox(){
        confirmationCheckbox.isDisplayed();
        return true;
    }

    @Step
    public boolean getElementSelect(){
        elementSelect.isDisplayed();
        return true;
    }

    @Step
    public boolean checkWelcomeButtonIsDisabled(){
        welcomeButtonIsDisabled.isDisplayed();
        return true;
    }

    @Step
    public MainPage welcomePageIsPassed(){
        confirmationCheckbox.click();

        Select select = new Select(elementSelect);
        select.selectByIndex(3);

        welcomeButton.click();
        return new MainPage();
    }

}

