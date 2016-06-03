package com.qcloud.project.macaovehicle.util;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

    public static String emptyToData(String str) {

        return !StringUtils.isEmpty(str) ? str.toUpperCase().trim() : "无";
    }
}
