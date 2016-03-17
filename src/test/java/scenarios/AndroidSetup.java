package scenarios;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tomasz.skrzypek on 2016-03-12.
 */
public abstract class AndroidSetup {


    private AppiumDriverLocalService service;
    //private static final File APP_DIR = new File("/REPO/testdroid-samples-master/testdroid-samples-master/appium/sample-scripts/AppiumDemo/apps");
    private static final File APP_DIR = new File("C://");
    protected AppiumDriver driver;
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private File app;

    @BeforeMethod
    public void prepareAndroidForAppium() throws MalformedURLException {
        //startAppiumServer();

        app = new File(APP_DIR, "e249.apk");

        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "Android6");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());

        driver =  new AppiumDriver(new URL("http://192.168.0.7:4726/wd/hub"), capabilities) {
            @Override
            public WebElement scrollTo(String s) {
                return null;
            }

            @Override
            public WebElement scrollToExact(String s) {
                return null;
            }
        };

        setUpTest();
    }

    protected AppiumDriver getDriver() {
        return driver;
    }

    protected void setUpTest() {
    }

    String osName = System.getProperty("os.name");
    String deviceUnderExecution = "Android6";

    private void startAppiumServer() {
        service = AppiumDriverLocalService.buildDefaultService();

        if (osName.contains("Mac")) {
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .usingDriverExecutable(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"))
                    .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js"))
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723)
                    .withLogFile(new File("target/"+deviceUnderExecution+".log")));
        }
        else if (osName.contains("Windows")) {
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                    .withIPAddress("127.0.0.1")
                    .usingPort(4723));
        }
        else {
            Assert.fail("Unspecified OS found, Appium can't run");
        }

        System.out.println("- - - - - - - - Starting Appium Server- - - - - - - - ");
        service.start();
    }
}