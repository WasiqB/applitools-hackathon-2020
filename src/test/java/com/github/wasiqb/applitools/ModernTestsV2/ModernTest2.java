package com.github.wasiqb.applitools.ModernTestsV2;

import static com.github.wasiqb.applitools.utils.ConfigUtil.getConfigString;
import static com.github.wasiqb.applitools.utils.Constants.APP_V2;

import com.github.wasiqb.applitools.ModernTestsV1.ModernTest1;

public class ModernTest2 extends ModernTest1 {
    @Override
    public String getUrl () {
        return getConfigString (APP_V2);
    }
}