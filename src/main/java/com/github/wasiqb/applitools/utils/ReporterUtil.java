package com.github.wasiqb.applitools.utils;

import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigString;
import static com.github.wasiqb.applitools.utils.Constants.FILE_PATH_PATTERN;
import static com.github.wasiqb.applitools.utils.Constants.MESSAGE_PATTERN;
import static com.github.wasiqb.applitools.utils.Constants.REPORT_PATH;
import static com.github.wasiqb.applitools.utils.Constants.ROOT_DIR;
import static java.text.MessageFormat.format;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.testng.asserts.SoftAssert;

public class ReporterUtil {
    private static final SoftAssert ASSERT = new SoftAssert ();

    public static void done () {
        ASSERT.assertAll ();
    }

    public static void log (final int version, final int taskId, final String elementName,
        final ElementUtil elementUtil, final String browser, final String viewport, final String device,
        final boolean visible) {
        final boolean status = elementUtil.isVisible () == visible;
        final String statusString = status ? "Pass" : "Fail";
        final String message = format (MESSAGE_PATTERN, taskId, elementName, elementUtil.id (), browser, viewport,
            device, statusString);
        ASSERT.assertTrue (status, message);
        final String path = format (FILE_PATH_PATTERN, ROOT_DIR, getConfigString (REPORT_PATH), version);
        try (final BufferedWriter writer = new BufferedWriter (new FileWriter (path, true))) {
            writer.write (message);
            writer.newLine ();
        } catch (final Exception e) {
            throw new RuntimeException ("Error while writing Report file.");
        }
    }
}