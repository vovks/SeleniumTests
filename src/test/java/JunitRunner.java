import Utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.ProviderForDriver;

import java.time.Duration;

public class JunitRunner {

    @BeforeEach
    public void before() {
        ProviderForDriver.getDriver().get(Constants.BASIC_URL);
        ProviderForDriver.getDriver().manage().deleteAllCookies();
        ProviderForDriver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterEach
    public void after(){
        ProviderForDriver.closeBrowser();
    }
}
