package com.github.wasiqb.applitools.utils;

import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigInt;
import static com.github.wasiqb.applitools.utils.Constants.WAIT_EXPLICIT;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.truth.StringSubject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
    private final WebDriver     driver;
    private final WebDriverWait wait;

    public DriverUtil (final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver, getConfigInt (WAIT_EXPLICIT));
    }

    public void close () {
        perform (WebDriver::close);
    }

    public ElementUtil find (final By locator) {
        return finds (locator).get (0);
    }

    public List<ElementUtil> finds (final By locator) {
        final List<ElementUtil> elements = this.wait.until (visibilityOfAllElementsLocatedBy (locator))
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

    public StringSubject verifyUrl () {
        return assertWithMessage ("Page URL mismatch.").that (get (WebDriver::getCurrentUrl));
    }

    WebDriver driver () {
        return this.driver;
    }

    private <T> T get (final Function<WebDriver, T> action) {
        return action.apply (this.driver);
    }

    private void perform (final Consumer<WebDriver> action) {
        action.accept (this.driver);
    }

    private void scrollIntoView (final ElementUtil element) {
        ((JavascriptExecutor) this.driver).executeScript ("arguments[0].scrollIntoView (true);", element.element ());
    }
}