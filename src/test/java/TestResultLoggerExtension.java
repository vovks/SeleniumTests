import io.qameta.allure.Attachment;
import io.qameta.allure.model.TestResult;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.DriverProvider;

import java.util.List;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        System.out.println("Test in after all section");
        DriverProvider.closeBrowser();
    }


    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test is failed");
        makeScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
