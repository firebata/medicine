package com.cnfwsy.interfaces.bean.sys;

import com.cnfwsy.core.bean.BaseForm;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class SysCity extends BaseForm {
    /**
     *
     */
    private int cityId;
    /**
     *
     */
    private String cityName;
    /**
     *
     */
    private int provinceId;
    /**
     * 0 - 禁用
     * 1 - 启用
     */
    private String state;
    /**
     *
     */
    private int id;

    /**
     *
     */
    public String getCityName() {
        return this.cityName;
    }

    /**
     *
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     *
     */
    public int getCityId() {
        return this.cityId;
    }

    /**
     *
     */
    public void setCityId(int cityId) {
        this.cityId = cityId;
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
    public int getId() {
        return this.id;
    }

    /**
     *
     */
    public void setId(int id) {
        this.id = id;
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
