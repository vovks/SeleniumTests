package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Utils.Waiters.waitForElementToBeVisible;

public class ChinaYellowTailPage extends AbstractPage{

    public ChinaYellowTailPage() {
        super();
        waitForLoadableElement();
    }

    @Step
    @Override
    public void waitForLoadableElement() {
        waitForElementToBeVisible(findWineButtonChina,3);
    }

    @FindBy(css = "[href=\"/basic\"]>.sgg-comp-button-inner")
    private WebElement findWineButtonChina;

    @FindBy(css = ".sgg-comp-social-icon>.fa.fa-weibo")
    private WebElement findWeiboButton;

    @Step
    public String checkFindWineButtonChina(){
        return findWineButtonChina.getText();
    }

    @Step
    public void clickWeiboButton(){
        findWeiboButton.click();
    }


}
