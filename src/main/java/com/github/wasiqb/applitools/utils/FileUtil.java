package com.github.wasiqb.applitools.utils;

import static java.text.MessageFormat.format;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class FileUtil {
    public static File createFile (final String path) {
        final File report = new File (path);
        if (!report.exists ()) {
            try {
                if (!report.createNewFile ()) {
                    throw new RuntimeException ("Report file already exists.");
                }
            } catch (final IOException e) {
                throw new RuntimeException ("Error while creating Report file.");
            }
        }
        return report;
    }

    public static void createFolder (final String path) {
        final File reportDir = new File (path);
        if (reportDir.exists ()) {
            for (final File file : Objects.requireNonNull (reportDir.listFiles ())) {
                deleteFile (file);
            }
            deleteFile (reportDir);
        }
        if (!reportDir.mkdir ()) {
            throw new RuntimeException ("Error while creating Report folder.");
        }
    }

    private static void deleteFile (final File file) {
        if (!file.delete ()) {
            throw new RuntimeException (
                format ("Error while deleting Report {0}.", file.isDirectory () ? "folder" : "file"));
        }
    }

    private FileUtil () {
        // Util class
    }
}