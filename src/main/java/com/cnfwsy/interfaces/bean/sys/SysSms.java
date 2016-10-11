package com.cnfwsy.interfaces.bean.sys;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-8-8 14:23:31
 */
public class SysSms extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 系统短信id
     */
    private String smsId;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 短信验证码
     */
    private String vcode;
    /**
     * 短信类容
     */
    private String smsName;
    /**
     *
     */
    private String platformKind;
    /**
     * 0：已下发；1：已使用
     */
    private int status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     *
     */
    public String getSmsName() {
        return this.smsName;
    }

    /**
     *
     */
    public void setSmsName(String smsName) {
        this.smsName = smsName;
    }

    /**
     *
     */
    public String getSmsId() {
        return this.smsId;
    }

    /**
     *
     */
    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    /**
     *
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     */
    public String getPlatformKind() {
        return this.platformKind;
    }

    /**
     *
     */
    public void setPlatformKind(String platformKind) {
        this.platformKind = platformKind;
    }

    /**
     *
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     *
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     *
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     *
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
    public String getVcode() {
        return this.vcode;
    }

    /**
     *
     */
    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    /**
     *
     */
    public int getStatus() {
        return this.status;
    }

    /**
     *
     */
    public void setStatus(int status) {
        this.status = status;
    }

}
