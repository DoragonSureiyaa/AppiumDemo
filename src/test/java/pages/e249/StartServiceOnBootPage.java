package pages.e249;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import model.Page;
import org.openqa.selenium.WebElement;

/**
 * Created by tomasz.skrzypek on 2016-03-15.
 */
public class StartServiceOnBootPage extends Page{

    private static final String ID_VIEW = "com.greythinker.punchback:id/";

    @AndroidFindBy(id = ID_VIEW + "home")
    private WebElement skipButton;

    public StartServiceOnBootPage(AppiumDriver driver) {
        super(driver);
    }

    public MainMenuPage clickSkipButton() {
        skipButton.click();
        return new MainMenuPage(driver);
    }
}
