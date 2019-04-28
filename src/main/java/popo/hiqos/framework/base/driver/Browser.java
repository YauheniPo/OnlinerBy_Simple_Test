package popo.hiqos.framework.base.driver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.remote.RemoteWebDriver;
import popo.hiqos.framework.util.ResourcePropertiesManager;

import java.util.Locale;

@Log4j2
public final class Browser {

    private static ResourcePropertiesManager rpStage = new ResourcePropertiesManager("stage.properties");
    private static ResourcePropertiesManager rpBrowser = new ResourcePropertiesManager("browser.properties");
    private static final String BROWSER_URL = rpStage.getStringProperty("url");
    private static BrowserType currentBrowser = BrowserType.valueOf((System.getenv("browser") == null
            ? rpBrowser.getStringProperty("browser") : ResourcePropertiesManager.getSystemEnvProperty("browser"))
            .toUpperCase(Locale.ENGLISH));
    private static final boolean IS_BROWSER_HEADLESS = rpBrowser.getBooleanProperties("browser.headless");
    private static final long IMPLICITLY_WAIT = rpBrowser.getLongProperties("browser.timeout");
    private static Browser instance = null;

    public static void getInstance() {
        if (instance == null) {
            synchronized (Browser.class) {
                instance = new Browser();
                initDriverConfigs();
            }
        }
    }

    private static void initDriverConfigs() {
        Configuration.timeout = IMPLICITLY_WAIT;
        Configuration.headless = IS_BROWSER_HEADLESS;
        Configuration.baseUrl = BROWSER_URL;
        Configuration.startMaximized = true;
        DriverManager.setUp(currentBrowser);
    }

    public static void openStartPage() {
        Selenide.open("/");
    }

    public static RemoteWebDriver getDriver() {
        return (RemoteWebDriver) WebDriverRunner.getWebDriver();
    }

    @AllArgsConstructor()
    public enum BrowserType {
        FIREFOX("firefox"),
        CHROME("chrome"),
        EDGE("edge"),
        IE("ie");

        @Getter
        private final String value;
    }
}
