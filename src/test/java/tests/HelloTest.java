package tests;

import assertions.e249.MainMenuAssertion;
import org.testng.annotations.Test;
import pages.e249.LicenceCheckPage;
import scenarios.AndroidSetup;

/**
 * Created by tomasz.skrzypek on 2016-03-12.
 */
public class HelloTest extends AndroidSetup {

    @Test
    public void stepByStepGuideForNumberBlockApp() {
        new LicenceCheckPage(getDriver())
                .clickDontShowButton()
                .clickSkipButton()
                .clickGuideButton()
                .clickStartButton()
                .clickSkipButton()
                .check(MainMenuAssertion.class)
                    .assertThatStepByStepGuideButtonExist()
                .endAssertion()
                .clickGuideButton();
    }
}
