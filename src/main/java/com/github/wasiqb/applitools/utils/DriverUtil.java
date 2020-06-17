package com.github.wasiqb.applitools.utils;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DriverUtil {
    private final WebDriver driver;

    public DriverUtil (final WebDriver driver) {
        this.driver = driver;
    }

    public ElementUtil find (final By locator) {
        return finds (locator).get (0);
    }

    public List<ElementUtil> finds (final By locator) {
        final List<ElementUtil> elements = this.driver.findElements (locator)
            .stream ()
            .map (ElementUtil::new)
            .collect (Collectors.toList ());
        scrollIntoView (elements.get (0));
        return elements;
    }

    public void navigate (final String url) {
        perform (d -> d.get (url));
    }

    public void quit () {
        perform (WebDriver::quit);
    }

    WebDriver driver () {
        return this.driver;
    }

    private void perform (final Consumer<WebDriver> action) {
        action.accept (this.driver);
    }

    private void scrollIntoView (final ElementUtil element) {
        ((JavascriptExecutor) this.driver).executeScript ("arguments[0].scrollIntoView (true);", element.element ());
    }
}