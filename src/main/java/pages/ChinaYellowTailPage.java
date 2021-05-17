package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementToBeVisible;

public class ChinaYellowTailPage extends AbstractPage{

    public ChinaYellowTailPage() {
        super();
        waitForLoadableElement();
    }

    @Step("wait element is loaded")
    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(findWineButtonChina,3);
    }

    @FindBy(css = "[href=\"/basic\"]>.sgg-comp-button-inner")
    private WebElement findWineButtonChina;

    @FindBy(css = ".sgg-comp-social-icon>.fa.fa-weibo")
    private WebElement findWeiboButton;

    @Step("FindWineButton China is visible")
    public String checkFindWineButtonChina(){
        return findWineButtonChina.getText();
    }

    @Step("click on Weibo button")
    public void clickWeiboButton(){
        findWeiboButton.click();
    }


}
