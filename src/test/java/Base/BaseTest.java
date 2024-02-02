package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @AfterMethod
    public void tearDown() {
        driverThreadLocal.get().quit();
    }

}
