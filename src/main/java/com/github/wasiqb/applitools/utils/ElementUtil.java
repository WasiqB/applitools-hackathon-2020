package com.github.wasiqb.applitools.utils;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementUtil {
    private final WebElement element;

    ElementUtil (final WebElement element) {
        this.element = element;
    }

    public void click () {
        perform (WebElement::click);
    }

    public WebElement element () {
        return this.element;
    }

    public ElementUtil find (final By locator) {
        return new ElementUtil (this.element.findElement (locator));
    }

    public List<ElementUtil> finds (final By locator) {
        return this.element.findElements (locator)
            .stream ()
            .map (ElementUtil::new)
            .collect (Collectors.toList ());
    }

    public String id () {
        return get (e -> e.getAttribute ("id"));
    }

    public boolean isVisible () {
        return get (WebElement::isDisplayed);
    }

    public String text () {
        return get (WebElement::getText);
    }

    private <T> T get (final Function<WebElement, T> action) {
        return action.apply (this.element);
    }

    private void perform (final Consumer<WebElement> action) {
        action.accept (this.element);
    }
}