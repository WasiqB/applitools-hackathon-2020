package com.github.wasiqb.applitools.utils;

import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigBool;
import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigString;
import static com.github.wasiqb.applitools.utils.Constants.DEBUG;
import static com.github.wasiqb.applitools.utils.Constants.EYE_API;
import static java.util.Objects.requireNonNull;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

public class EyeUtils {
    private static final BatchInfo BATCH_DP = new BatchInfo ("UFG Hackathon");

    private final DriverUtil driverUtil;
    private final Eyes       eyes;

    public EyeUtils (final DriverUtil driverUtil) {
        this.driverUtil = requireNonNull (driverUtil, "DriverUtil can't be null");
        final VisualGridRunner runner = new VisualGridRunner (10);
        this.eyes = new Eyes (runner);
        setEyeOptions ();
    }

    public void check (final String stepName) {
        this.eyes.check (Target.window ()
            .fully ()
            .withName (stepName));
    }

    public void check (final String stepName, final ElementUtil elementUtil) {
        this.eyes.check (Target.region (elementUtil.element ())
            .withName (stepName));
    }

    public void close () {
        this.eyes.closeAsync ();
    }

    public void open (final String testName) {
        this.eyes.open (requireNonNull (this.driverUtil.driver (), "Driver can't be null"), "AppliFashion", testName,
            RectangleSize.parse ("800x600"));
    }

    public void quit () {
        this.eyes.abortIfNotClosed ();
    }

    private void setEyeOptions () {
        final Configuration configuration = new Configuration ();
        configuration.setApiKey (getConfigString (EYE_API));
        configuration.setBatch (BATCH_DP);
        if (getConfigBool (DEBUG)) {
            this.eyes.setLogHandler (new StdoutLogHandler (true));
        } else {
            configuration.addBrowser (1200, 700, BrowserType.CHROME);
            configuration.addBrowser (1200, 700, BrowserType.FIREFOX);
            configuration.addBrowser (1200, 700, BrowserType.EDGE_CHROMIUM);
            configuration.addBrowser (1200, 700, BrowserType.CHROME);
            configuration.addBrowser (1200, 700, BrowserType.FIREFOX);
            configuration.addBrowser (1200, 700, BrowserType.EDGE_CHROMIUM);
            configuration.addDeviceEmulation (DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
        }
        this.eyes.setConfiguration (configuration);
    }
}