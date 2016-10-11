package com.cnfwsy.core.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类说明:系统基础信息缓存
 * Created by zhangjh on 2016/6/10.
 */
public enum SystemBaseInfoCachedMap {

    SINGLETONE;
    private Map<String, List<String>> systemBaseInfo = new HashMap<>();

    private Map<String, String> cityMap;

    private Map<String, String> provinceMap;

    public void pushSystemBaseInfo(String key, List<String> values) {
        systemBaseInfo.put(key, values);
    }


    public List<String> popSystemBaseInfo(String key) {
        return systemBaseInfo.get(key);
    }

    public Map<String, List<String>> rtnSystemBaseInfo() {
        return systemBaseInfo;
    }

    public Map<String, List<String>> getSystemBaseInfo() {
        return systemBaseInfo;
    }

    public void setSystemBaseInfo(Map<String, List<String>> systemBaseInfo) {
        this.systemBaseInfo = systemBaseInfo;
    }

    public Map<String, String> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<String, String> cityMap) {
        this.cityMap = cityMap;
    }

    public Map<String, String> getProvinceMap() {
        return provinceMap;
    }

    public void setProvinceMap(Map<String, String> provinceMap) {
        this.provinceMap = provinceMap;
    }
}
