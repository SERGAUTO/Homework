package uz.alpinizm.kamildemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        Configuration.baseUrl = "https://kamil-demo.alpinizm.uz/";
        Configuration.browser = Browser.CHROME.browserName();
        Configuration.timeout = Duration.ofSeconds(20).toMillis();
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = false;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Selenide.open(StringUtils.EMPTY);
    }
}
