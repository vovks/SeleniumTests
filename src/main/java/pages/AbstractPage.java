package pages;

import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(DriverProvider.getDriver(), this);
    }

    public abstract void waitForLoadableElement();
}
