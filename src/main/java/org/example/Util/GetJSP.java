package org.example.Util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GetJSP {
    private static final String JSP_PATH = "/WEB-INF/jsp/";
    public static String getJSPPath(String path) {
        return JSP_PATH + path + ".jsp";
    }
}
