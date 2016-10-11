package com.cnfwsy.core.bean;

import java.io.Serializable;

/**
 * 说明:
 * Created by zhangjh on 2016-05-25.
 */
public class BaseForm implements Serializable {
//    private PageInfo pageInfo;
    /**
     * 每页的记录数
     */
    private Integer pageSize;
    /**
     * 当前页码
     */
    private Integer pageNo;


    /**
     * 开始记录
     */
    private Integer start;

    /**
     * 查询关键字
     */
    private String searchValue;
    /**
     * limit SQL语句：limit begin,length
     */
    private String limitAfter;

    private Integer orderbyId;
    /**
     * 回调地址
     */
    private String redirectUri;

    public Integer getOrderbyId() {
        return orderbyId;
    }

    public void setOrderbyId(Integer orderbyId) {
        this.orderbyId = orderbyId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getLimitAfter() {
        return limitAfter;
    }

    public void setLimitAfter(String limitAfter) {
        this.limitAfter = limitAfter;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}
