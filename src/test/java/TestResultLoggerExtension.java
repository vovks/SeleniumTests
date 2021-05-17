import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.DriverProvider;

import java.util.Optional;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println("Test in after all section");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test is failed");
        makeScreenshot();
        DriverProvider.closeBrowser();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        DriverProvider.closeBrowser();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        DriverProvider.closeBrowser();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        DriverProvider.closeBrowser();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
