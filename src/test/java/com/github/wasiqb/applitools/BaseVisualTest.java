package com.github.wasiqb.applitools;

import static java.text.MessageFormat.format;

import com.github.wasiqb.applitools.utils.EyeUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseVisualTest extends BaseTest {
    private EyeUtils eyes;
    private int count;

    @AfterMethod(alwaysRun = true)
    public void closeVisualTests() {
        this.eyes.close();
    }

    @BeforeMethod(alwaysRun = true)
    public void prepareVisualTests() {
        this.eyes.open(format("Task {0}", this.count++));
    }

    @BeforeTest(alwaysRun = true)
    public void setupVisualTests() {
        this.eyes = new EyeUtils(BaseTest.driverUtil);
        this.count = 1;
    }

    @AfterTest(alwaysRun = true)
    public void tearDownVisualTests() {
        this.eyes.quit();
    }
}