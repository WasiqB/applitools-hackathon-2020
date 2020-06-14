package com.github.wasiqb.applitools;

import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigString;
import static com.github.wasiqb.applitools.utils.Constants.FILE_PATH_PATTERN;
import static com.github.wasiqb.applitools.utils.Constants.REPORT_PATH;
import static com.github.wasiqb.applitools.utils.Constants.ROOT_DIR;
import static com.github.wasiqb.applitools.utils.FileUtil.createFile;
import static com.github.wasiqb.applitools.utils.FileUtil.createFolder;
import static java.text.MessageFormat.format;

import org.testng.annotations.BeforeSuite;

public abstract class BaseTraditionalTest extends BaseTest {
    public abstract int getVersion ();

    @BeforeSuite (alwaysRun = true)
    public void setupSuite () {
        createFolder (format ("{0}{1}", ROOT_DIR, getConfigString (REPORT_PATH)));
        final String path = format (FILE_PATH_PATTERN, ROOT_DIR, getConfigString (REPORT_PATH), getVersion ());
        createFile (path);
    }
}