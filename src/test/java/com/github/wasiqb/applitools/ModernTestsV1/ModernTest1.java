package com.github.wasiqb.applitools.ModernTestsV1;

import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigString;
import static com.github.wasiqb.applitools.utils.Constants.APP_V1;

import com.github.wasiqb.applitools.BaseVisualTest;
import com.github.wasiqb.applitools.pages.DashboardPage;
import com.github.wasiqb.applitools.pages.ProductPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ModernTest1 extends BaseVisualTest {
    private DashboardPage dashboardPage;

    public String getUrl () {
        return getConfigString (APP_V1);
    }

    @BeforeTest
    public void setup () {
        this.driverUtil.navigate (getUrl ());
    }

    @Test
    public void test1 () {
        this.eyes.check ("Cross-Device Elements Test");
    }

    @Test
    public void test2 () {
        this.dashboardPage = new DashboardPage (this.driverUtil);
        this.dashboardPage.filterByColor ("Black");
        this.eyes.check ("Filter Results", this.dashboardPage.productGrid ());
    }

    @Test
    public void test3 () {
        this.dashboardPage.items ()
            .get (0)
            .click ();
        final ProductPage productPage = new ProductPage (this.driverUtil);
        productPage.isAt ();
        this.eyes.check ("Product Details test");
    }
}