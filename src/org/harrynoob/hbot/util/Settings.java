package org.harrynoob.hbot.util;

import java.util.HashMap;

/**
 * Do not use this without permission.
 * User: harrynoob
 * Date: 23-2-13
 * Time: 22:28
 */
public interface Settings {

    public static final String PAGE_URL = "http://oldschool1.runescape.com/";
    public static final String REGEX1 = "document\\.write\\(\'";
    public static final String REGEX2 = "\'\\);";
    public static final String PARAMREGEX = "\" value=\"";
    public static final String PARAMREGEX2 = "\\<param name=\"";
    public static final String PARAMREGEX3 = "\"\\>";
    public static final double version = 0.01;
    public static final String SAVEDIR = System.getProperty("java.io.tmpdir") + "/hbot/v2/";

}
