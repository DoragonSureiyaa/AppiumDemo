package pages.e249;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import jdk.nashorn.internal.objects.annotations.Getter;
import model.Page;
import org.openqa.selenium.WebElement;

/**
 * Created by tomasz.skrzypek on 2016-03-15.
 */
public class MainMenuPage extends Page{

    private static final String ID_VIEW = "com.greythinker.punchback:id/";

    @AndroidFindBy(id = ID_VIEW + "guide")
    public WebElement stepByStepGuideButton;

    public MainMenuPage(AppiumDriver driver) {
        super(driver);
    }

    public ConfigurationStartPage clickGuideButton() {
        stepByStepGuideButton.click();
        return new ConfigurationStartPage(driver);
    }
}
