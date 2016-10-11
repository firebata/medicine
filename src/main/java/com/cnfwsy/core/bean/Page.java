package com.cnfwsy.core.bean;

import java.util.List;

/**
 * 分页数据
 *
 * @author: zhangjh
 * @version:2015年5月5日 下午3:06:01
 */
public class Page<T> {
    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 每页大小
     */
    private int pageSize;
    /**
     * 当前页码
     */
    private int pageNo;
    /**
     * 数据集合
     */
    private List<T> items;
    /**
     * 总记录条数
     */
    private int allRecordCount;

    public int getAllRecordCount() {
        return allRecordCount;
    }

    public void setAllRecordCount(int allRecordCount) {
        this.allRecordCount = allRecordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
