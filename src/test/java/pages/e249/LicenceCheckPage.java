package pages.e249;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import model.Page;
import org.openqa.selenium.WebElement;

/**
 * Created by tomasz.skrzypek on 2016-03-15.
 */
public class LicenceCheckPage extends Page {

    private static final String ID_VIEW = "android:id/";

    @AndroidFindBy(id = ID_VIEW + "button2")
    private WebElement dontShowButton;

    public LicenceCheckPage(AppiumDriver driver) {
        super(driver);
    }

    public ConfigurationStartPage clickDontShowButton() {
        dontShowButton.click();
        return new ConfigurationStartPage(driver);
    }
}
