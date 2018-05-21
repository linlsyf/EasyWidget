package com.easysoft.widget.utils;

/**
 * Created by lindanghong on 2018/5/21.
 */

public class StringUtils {

    public static boolean isEmpty(String msg) {
        boolean isempty = true;
        if(msg != null && !msg.equals("")) {
            isempty = false;
        }

        return isempty;
    }

    public static boolean isNotEmpty(String msg) {
        boolean isempty = false;
        if(msg != null && !msg.equals("")) {
            isempty = true;
        }

        return isempty;
    }
}
