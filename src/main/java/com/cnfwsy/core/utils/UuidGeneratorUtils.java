package com.cnfwsy.core.utils;

import java.util.UUID;

/**
 * 说明:
 * Created by zhangjh on 2015/8/18.
 */
public class UuidGeneratorUtils {
//    private static TimeBasedGenerator gen = Generators.timeBasedGenerator(EthernetAddress.fromInterface());

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }


    public static String getRandomUUID() {
        return getUUID();
    }

}
