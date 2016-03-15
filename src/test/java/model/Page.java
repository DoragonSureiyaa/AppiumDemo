package model;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by tomasz.skrzypek on 2016-03-13.
 */
public class Page {

    protected AppiumDriver driver;

    public Page(AppiumDriver driver) {
        this.driver = driver;

        pause(500L);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        setupImplicitTimeout();
    }

    public <G extends Page, T extends AbstractAssertions<G>> T check(Class<T> clazz) throws RuntimeException {
        try {
            AbstractAssertions<G> assertion = clazz.newInstance();
            assertion.setPage((G)this);
            return (T) assertion;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Error occur during creating Assertions.", e);
        }
    }

    public void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException var3) {
        }
    }

    protected void setupImplicitTimeout() {
        this.driver.manage().timeouts().implicitlyWait(getImplicitTimeout(), TimeUnit.MILLISECONDS);
    }

    protected Long getImplicitTimeout() {
        return Long.parseLong(System.getProperty("webdriver.implicit-wait", getDefaultImplicitTimeout().toString()));
    }

    protected Long getDefaultImplicitTimeout() {
        return 10000L;
    }
}
