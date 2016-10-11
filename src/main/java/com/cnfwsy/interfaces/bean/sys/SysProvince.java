package com.cnfwsy.interfaces.bean.sys;

import com.cnfwsy.core.bean.BaseForm;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class SysProvince extends BaseForm {
    /**
     *
     */
    private int provinceId;
    /**
     *
     */
    private String provinceName;
    /**
     * 1 - 直辖市
     * 2 - 行政省
     * 3 - 自治区
     * 4 - 特别行政区
     * 5 - 其他国家
     * 见全局数据字典[省份类型]
     */
    private String type;
    /**
     * 0 - 禁用
     * 1 - 启用
     */
    private String state;

    /**
     *
     */
    public String getProvinceName() {
        return this.provinceName;
    }

    /**
     *
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     *
     */
    public String getState() {
        return this.state;
    }

    /**
     *
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     */
    public String getType() {
        return this.type;
    }

    /**
     *
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     */
    public int getProvinceId() {
        return this.provinceId;
    }

    /**
     *
     */
    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

}
