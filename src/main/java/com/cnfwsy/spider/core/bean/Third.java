package com.cnfwsy.spider.core.bean;

import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2016-08-15.
 */
public class Third {

    private String websites;
    private List<String> websiteList;

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites;
    }

    public List<String> getWebsiteList() {
        return websiteList;
    }

    public void setWebsiteList(List<String> websiteList) {
        this.websiteList = websiteList;
    }

    public Third() {
    }

    public Third(String websites, List<String> websiteList) {
        this.websites = websites;
        this.websiteList = websiteList;
    }
}
