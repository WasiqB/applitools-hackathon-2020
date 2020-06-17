package com.github.wasiqb.applitools.utils;

import java.io.File;
import java.io.IOException;

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
        } else {
            if (report.delete ()) {
                return createFile (path);
            }
        }
        return report;
    }

    public static void createFolder (final String path) {
        final File reportDir = new File (path);
        if (!reportDir.exists ()) {
            if (!reportDir.mkdir ()) {
                throw new RuntimeException ("Error while creating Report folder.");
            }
        }
    }

    private FileUtil () {
        // Util class
    }
}