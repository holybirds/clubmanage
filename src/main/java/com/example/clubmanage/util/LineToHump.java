package com.example.clubmanage.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineToHump {
    public static String lineToHump(String str) {
        Matcher matcher = Pattern.compile("_(\\w)").matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }

        matcher.appendTail(sb);
        return sb.toString();
    }
}
