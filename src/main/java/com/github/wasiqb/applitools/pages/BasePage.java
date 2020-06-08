package com.github.wasiqb.applitools.pages;

import com.github.wasiqb.applitools.utils.DriverUtil;

class BasePage {
    protected final DriverUtil driverUtil;

    BasePage (final DriverUtil driverUtil) {
        this.driverUtil = driverUtil;
    }
}