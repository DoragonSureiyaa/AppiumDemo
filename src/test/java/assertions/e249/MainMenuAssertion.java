package assertions.e249;

import static org.testng.Assert.assertEquals;

import model.AbstractAssertions;
import pages.e249.MainMenuPage;

/**
 * Created by tomasz.skrzypek on 2016-03-15.
 */
public class MainMenuAssertion extends AbstractAssertions<MainMenuPage> {

    public MainMenuAssertion assertThatStepByStepGuideButtonExist() {
        assertEquals(page.stepByStepGuideButton.getAttribute("clickable"), "true");
        return this;
    }
}
