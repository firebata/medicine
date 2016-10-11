package com.cnfwsy.spider.core.util;


import com.cnfwsy.spider.core.bean.Third;

import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2016-08-15.
 */
public class ThirdUtils {
    public static Third third = new Third();

    /**
     * 网站是否需要爬虫
     *
     * @param website
     * @return
     */
    public static boolean isNeed(String website) {
        List<String> list = third.getWebsiteList();
        for (String web : list) {
            if (web.equals(website)) {
                return true;
            }
        }
        return false;
    }
}
