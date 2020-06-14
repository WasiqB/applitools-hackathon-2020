package com.github.wasiqb.applitools.pages;

import static com.github.wasiqb.applitools.utils.ReporterUtil.log;
import static java.text.MessageFormat.format;

import com.github.wasiqb.applitools.utils.ElementUtil;
import org.openqa.selenium.By;

public class ProductItem {
    private final ElementUtil elementUtil;

    public ProductItem (final ElementUtil elementUtil) {
        this.elementUtil = elementUtil;
    }

    public ElementUtil compareIcon () {
        return this.elementUtil.find (By.className ("ti-control-shuffle"));
    }

    public ElementUtil heartIcon () {
        return this.elementUtil.find (By.className ("ti-heart"));
    }

    public ElementUtil image () {
        return this.elementUtil.find (By.className ("img-fluid"));
    }

    public ElementUtil priceBox () {
        return this.elementUtil.find (By.className ("price_box"));
    }

    public ElementUtil shoppingIcon () {
        return this.elementUtil.find (By.className ("ti-shopping-cart"));
    }

    public ElementUtil title () {
        return this.elementUtil.find (By.tagName ("h3"));
    }

    public void verifyLaptopView (final int version, final int taskId, final String browser, final String viewport,
        final String device) {
        log (version, taskId, format ("Product: {0} image", title ().text ()), image (), browser, viewport, device,
            true);
        log (version, taskId, format ("Product: {0} title", title ().text ()), title (), browser, viewport, device,
            true);
        log (version, taskId, format ("Product: {0} Price", title ().text ()), priceBox (), browser, viewport, device,
            true);
        log (version, taskId, format ("Product: {0} Heart icon", title ().text ()), heartIcon (), browser, viewport,
            device, false);
        log (version, taskId, format ("Product: {0} Compare icon", title ().text ()), compareIcon (), browser, viewport,
            device, false);
        log (version, taskId, format ("Product: {0} Shopping icon", title ().text ()), shoppingIcon (), browser,
            viewport, device, false);
    }

    public void verifyMobileView (final int version, final int taskId, final String browser, final String viewport,
        final String device) {
        log (version, taskId, format ("Product: {0} image", title ().text ()), image (), browser, viewport, device,
            true);
        log (version, taskId, format ("Product: {0} title", title ().text ()), title (), browser, viewport, device,
            true);
        log (version, taskId, format ("Product: {0} Price", title ().text ()), priceBox (), browser, viewport, device,
            true);
        log (version, taskId, format ("Product: {0} Heart icon", title ().text ()), heartIcon (), browser, viewport,
            device, true);
        log (version, taskId, format ("Product: {0} Compare icon", title ().text ()), compareIcon (), browser, viewport,
            device, true);
        log (version, taskId, format ("Product: {0} Shopping icon", title ().text ()), shoppingIcon (), browser,
            viewport, device, true);
    }
}