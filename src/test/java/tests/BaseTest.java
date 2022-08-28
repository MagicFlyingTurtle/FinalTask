package tests;

import com.codeborne.selenide.WebDriverRunner;
import configreader.FrameworkProperties;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

public abstract class BaseTest {

    public abstract String getBaseUrl();

    @BeforeMethod
    public void baseSetup() throws MalformedURLException {
        FrameworkProperties frameworkProperties = ConfigFactory.create(FrameworkProperties.class);
          if (frameworkProperties.isRemote()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "103.0");
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            RemoteWebDriver driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
            WebDriverRunner.setWebDriver(driver);
        }
    }

    @AfterClass
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }

}
