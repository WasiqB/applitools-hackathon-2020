package com.github.wasiqb.applitools;

import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigInt;
import static com.github.wasiqb.applitools.utils.Constants.TO_PAGE;
import static com.github.wasiqb.applitools.utils.Constants.TO_SCRIPT;
import static com.github.wasiqb.applitools.utils.Constants.WAIT_IMPLICIT;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.edgedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static java.lang.Integer.parseInt;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import com.github.wasiqb.applitools.utils.DriverUtil;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected String     browser;
    protected String     device;
    protected DriverUtil driverUtil;
    protected String     viewport;

    @Parameters ({ "browser", "viewport", "device" })
    @BeforeTest (alwaysRun = true)
    public void setupTest (@Optional (EMPTY) final String browser, @Optional (EMPTY) final String resolution,
        @Optional (EMPTY) final String device) {
        this.browser = browser;
        this.viewport = resolution;
        this.device = device;
        final WebDriver driver = setupBrowser (browser);
        setupDriver (driver, resolution);
        this.driverUtil = new DriverUtil (driver);
    }

    @AfterTest (alwaysRun = true)
    public void tearDownTest () {
        this.driverUtil.close ();
        this.driverUtil.quit ();
    }

    private WebDriver setupBrowser (final String browser) {
        switch (browser.toLowerCase ()) {
            case "edge":
                edgedriver ().setup ();
                return new EdgeDriver ();
            case "firefox":
                firefoxdriver ().setup ();
                return new FirefoxDriver ();
            case "chrome":
            default:
                chromedriver ().setup ();
                return new ChromeDriver ();
        }
    }

    private void setupDriver (final WebDriver driver, final String resolution) {
        final WebDriver.Timeouts timeout = driver.manage ()
            .timeouts ();
        timeout.implicitlyWait (getConfigInt (WAIT_IMPLICIT), SECONDS);
        timeout.pageLoadTimeout (getConfigInt (TO_PAGE), SECONDS);
        timeout.setScriptTimeout (getConfigInt (TO_SCRIPT), SECONDS);
        if (isNotEmpty (resolution)) {
            final String[] sizes = resolution.split ("x");
            driver.manage ()
                .window ()
                .setSize (new Dimension (parseInt (sizes[0].trim ()), parseInt (sizes[1].trim ())));
        } else {
            driver.manage ()
                .window ()
                .setSize (new Dimension (1200, 700));
        }
    }
}