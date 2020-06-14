package com.github.wasiqb.applitools.utils;

import static java.lang.System.getProperty;

public interface Constants {
    String APP_V1            = "app_v1_url";
    String APP_V2            = "app_v2_url";
    String CONFIG_PATH       = "hackathon.properties";
    String DEBUG             = "eyes_debug";
    String EYE_API           = "eyes_api";
    String FILE_PATH_PATTERN = "{0}{1}/Traditional-V{2}-TestResults.txt";
    String MESSAGE_PATTERN   = "Task: {0}, Test Name: {1} field is displayed, DOM Id: {2}, Browser: {3}, Viewport: {4}, Device: {5}, Status: {6}";
    String REPORT_PATH       = "report_path";
    String ROOT_DIR          = getProperty ("user.dir");
    String TO_PAGE           = "timeout_pageload";
    String TO_SCRIPT         = "timeout_scriptload";
    String WAIT_IMPLICIT     = "wait_implicit";
}
