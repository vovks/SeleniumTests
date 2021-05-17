import utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.DriverProvider;

import java.time.Duration;

@ExtendWith(TestResultLoggerExtension.class)
public class JunitRunner {

    @BeforeEach
    public void before() {
        DriverProvider.getDriver().get(Constants.BASIC_URL);
        DriverProvider.getDriver().manage().deleteAllCookies();
        DriverProvider.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
}
