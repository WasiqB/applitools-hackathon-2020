package com.github.wasiqb.applitools.pages;

import static com.google.common.truth.Truth.assertThat;

import com.github.wasiqb.applitools.utils.DriverUtil;
import com.github.wasiqb.applitools.utils.ElementUtil;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    public ProductPage (final DriverUtil driverUtil) {
        super (driverUtil);
    }

    public ElementUtil addToCart () {
        return this.driverUtil.find (By.cssSelector ("div.btn_add_to_cart"));
    }

    public void isAt () {
        assertThat (addToCart ().isVisible ()).isTrue ();
    }
}
