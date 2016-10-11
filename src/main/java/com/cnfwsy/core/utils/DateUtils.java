package com.cnfwsy.core.utils;

import java.time.LocalDate;

/**
 * Created by zhangjh on 16/6/13.
 */
public enum DateUtils {
    SINGLETONE;

    public String getYYMMDD() {
        LocalDate today = java.time.LocalDate.now();
        String time = today.toString();
        time = time.substring(2).replace("-", "");
        return time;
    }
    public String getYY_MM_DD() {
        LocalDate today = java.time.LocalDate.now();
        String time = today.toString();
//        time = time.substring(2).replace("-", "");
        return time;
    }
}
