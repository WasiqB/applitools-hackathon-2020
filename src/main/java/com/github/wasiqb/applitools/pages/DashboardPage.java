package com.github.wasiqb.applitools.pages;

import java.util.List;
import java.util.Optional;

import com.github.wasiqb.applitools.utils.DriverUtil;
import com.github.wasiqb.applitools.utils.ElementUtil;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    public DashboardPage (final DriverUtil driverUtil) {
        super (driverUtil);
    }

    public ElementUtil colorsFilter (final String color) {
        final Optional<ElementUtil> filter = this.driverUtil.finds (
            By.cssSelector ("div#sidebar_filters div.filter_type:nth-child(2) div#filter_1 ul li label"))
            .stream ()
            .filter (e -> e.text ()
                .startsWith (color))
            .findFirst ();
        return filter.orElse (null);
    }

    public ElementUtil filterButton () {
        return this.driverUtil.find (By.id ("filterBtn"));
    }

    public void filterByColor (final String color) {
        if (filterOption ().isVisible ()) {
            filterOption ().click ();
        }
        colorsFilter (color).click ();
        filterButton ().click ();
    }

    public ElementUtil filterOption () {
        return this.driverUtil.find (By.id ("ti-filter"));
    }

    public List<ElementUtil> items () {
        return this.driverUtil.finds (By.className ("grid_item"));
    }

    public ElementUtil productGrid () {
        return this.driverUtil.find (By.id ("product_grid"));
    }
}