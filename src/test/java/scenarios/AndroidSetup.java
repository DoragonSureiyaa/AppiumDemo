package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tomasz.skrzypek on 2016-03-12.
 */
public abstract class AndroidSetup {

    private static final File APP_DIR = new File("/REPO/testdroid-samples-master/testdroid-samples-master/appium/sample-scripts/AppiumDemo/apps");

    protected AppiumDriver driver;

    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private File app;

    public void setUpTest() {
        app = new File(APP_DIR, "e249.apk");
    }

    @BeforeMethod
    public void prepareAndroidForAppium() throws MalformedURLException {
        setUpTest();

        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Android6");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver =  new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities) {
            @Override
            public WebElement scrollTo(String s) {
                return null;
            }

            @Override
            public WebElement scrollToExact(String s) {
                return null;
            }
        };
    }

    protected AppiumDriver getDriver() {
        return driver;
    }
}
