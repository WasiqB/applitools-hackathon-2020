package com.github.wasiqb.applitools.utils;

import static com.google.common.truth.Truth.assertWithMessage;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.function.Consumer;
import java.util.function.Function;

import com.google.common.truth.StringSubject;
import org.openqa.selenium.WebElement;

public class ElementUtil {
    private final WebElement element;

    ElementUtil(final WebElement element) {
        this.element = element;
    }

    public void click() {
        perform(WebElement::click);
    }

    public void enterText(final String text) {
        perform(e -> {
            if (isNotEmpty(text)) {
                click();
                e.sendKeys(text);
            }
        });
    }

    public boolean isVisible() {
        return get(WebElement::isDisplayed);
    }

    public String text() {
        return get(WebElement::getText);
    }

    public StringSubject verifyAttr(final String key) {
        return assertWithMessage("Element Attribute does not match.").that((String) get(e -> e.getAttribute(key)));
    }

    public StringSubject verifyText() {
        return assertWithMessage("Element text does not match.").that(text());
    }

    private <T> T get(final Function<WebElement, T> action) {
        return action.apply(this.element);
    }

    private void perform(final Consumer<WebElement> action) {
        action.accept(this.element);
    }
}