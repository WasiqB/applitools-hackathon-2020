package com.github.wasiqb.applitools.utils;

import static com.github.wasiqb.applitools.utils.Constants.CONFIG_PATH;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;
import static java.lang.System.getenv;
import static java.text.MessageFormat.format;
import static java.util.Optional.ofNullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigUtil {
    private static final Properties CONFIG;

    static {
        final String dir = getProperty ("user.dir");
        final String configPath = format ("{0}/src/test/resources/{1}", dir, CONFIG_PATH);
        CONFIG = new Properties ();
        try (final FileInputStream in = new FileInputStream (new File (configPath))) {
            CONFIG.load (in);
        } catch (final IOException e) {
            throw new RuntimeException ("Error while loading Config properties.");
        }
    }

    public static boolean getConfigBool (final String key) {
        return parseBoolean (getConfigString (key));
    }

    public static int getConfigInt (final String key) {
        return parseInt (getConfigString (key));
    }

    public static String getConfigString (final String key) {
        return ofNullable (getenv (key)).orElse (ofNullable (getProperty (key)).orElse (CONFIG.getProperty (key)));
    }

    private ConfigUtil () {
        // Util class.
    }
}