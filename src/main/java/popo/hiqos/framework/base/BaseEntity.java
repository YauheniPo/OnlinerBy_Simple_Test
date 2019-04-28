package popo.hiqos.framework.base;

import com.codeborne.selenide.testng.BrowserPerTest;
import com.codeborne.selenide.testng.ScreenShooter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import popo.hiqos.framework.base.driver.Browser;

@Log4j2
@Listeners({BrowserPerTest.class, ScreenShooter.class})
public class BaseEntity {

    @BeforeMethod()
    public void beforeTest() {
        Browser.getInstance();
        Browser.openStartPage();
    }

    protected RemoteWebDriver getWebDriver() {
        return Browser.getDriver();
    }
}
