package com.github.wasiqb.applitools.TraditionalTestsV1;

import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigString;
import static com.github.wasiqb.applitools.utils.Constants.APP_V1;
import static com.github.wasiqb.applitools.utils.Constants.APP_V2;
import static com.github.wasiqb.applitools.utils.ReporterUtil.done;

import com.github.wasiqb.applitools.BaseTraditionalTest;
import com.github.wasiqb.applitools.pages.DashboardPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TraditionalTest1 extends BaseTraditionalTest {
    public String getUrl () {
        return getConfigString (getVersion () == 1 ? APP_V1 : APP_V2);
    }

    @Override
    public int getVersion () {
        return 1;
    }

    @BeforeTest
    public void setup () {
        this.driverUtil.navigate (getUrl ());
    }

    @Test
    public void test1 () {
        final DashboardPage dashboardPage = new DashboardPage (this.driverUtil);
        switch (this.device.toLowerCase ()) {
            case "laptop":
                dashboardPage.verifyLaptopView (getVersion (), 1, this.browser, this.viewport, this.device);
                break;
            case "tablet":
                dashboardPage.verifyTabletView (getVersion (), 1, this.browser, this.viewport, this.device);
                break;
            case "mobile":
            default:
                dashboardPage.verifyMobileView (getVersion (), 1, this.browser, this.viewport, this.device);
                break;
        }
        done ();
    }
}