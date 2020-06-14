package com.github.wasiqb.applitools.pages;

import static com.github.wasiqb.applitools.utils.ReporterUtil.log;

import com.github.wasiqb.applitools.utils.ElementUtil;
import org.openqa.selenium.By;

public class FooterSection {
    private final ElementUtil elementUtil;

    public FooterSection (final ElementUtil elementUtil) {
        this.elementUtil = elementUtil;
    }

    public ElementUtil additionalLinks () {
        return this.elementUtil.find (By.className ("additional_links"));
    }

    public ElementUtil contact () {
        return this.elementUtil.find (By.className ("contacts"));
    }

    public ElementUtil currencySelector () {
        return this.elementUtil.find (By.className ("currency-selector"));
    }

    public ElementUtil languageSelector () {
        return this.elementUtil.find (By.className ("lang-selector"));
    }

    public ElementUtil newsletter () {
        return this.elementUtil.find (By.id ("newsletter"));
    }

    public ElementUtil quickLinks () {
        return this.elementUtil.find (By.className ("links"));
    }

    public void verifyLaptopTabletView (final int version, final int taskId, final String browser,
        final String viewport, final String device) {
        log (version, taskId, "Additional Links", additionalLinks (), browser, viewport, device, true);
        log (version, taskId, "Contact", contact (), browser, viewport, device, true);
        log (version, taskId, "Currency selector", currencySelector (), browser, viewport, device, true);
        log (version, taskId, "Language selector", languageSelector (), browser, viewport, device, true);
        log (version, taskId, "Newsletter", newsletter (), browser, viewport, device, true);
        log (version, taskId, "Quick links", quickLinks (), browser, viewport, device, true);
    }

    public void verifyMobileView (final int version, final int taskId, final String browser, final String viewport,
        final String device) {
        log (version, taskId, "Additional Links", additionalLinks (), browser, viewport, device, true);
        log (version, taskId, "Contact", contact (), browser, viewport, device, false);
        log (version, taskId, "Currency selector", currencySelector (), browser, viewport, device, true);
        log (version, taskId, "Language selector", languageSelector (), browser, viewport, device, true);
        log (version, taskId, "Newsletter", newsletter (), browser, viewport, device, false);
        log (version, taskId, "Quick links", quickLinks (), browser, viewport, device, false);
    }
}
