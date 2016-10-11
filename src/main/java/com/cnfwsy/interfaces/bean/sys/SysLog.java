package com.cnfwsy.interfaces.bean.sys;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class SysLog extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private String logId;
    /**
     *
     */
    private String method;
    /**
     *
     */
    private String description;
    /**
     * 0：系统操作；1：异常信息
     */
    private String type;
    /**
     *
     */
    private String reqIp;
    /**
     *
     */
    private String expCode;
    /**
     *
     */
    private String expDetail;
    /**
     *
     */
    private String params;
    /**
     *
     */
    private String userName;
    /**
     *
     */
    private Date updateTime;
    /**
     *
     */
    private int delFlag;
    /**
     *
     */
    private String remark;

    /**
     *
     */
    public String getMethod() {
        return this.method;
    }

    /**
     *
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     *
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     */
    public void setDescription(String description) {
        this.description = description;
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
    public String getRemark() {
        return this.remark;
    }

    /**
     *
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
    public String getParams() {
        return this.params;
    }

    /**
     *
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     *
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     *
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     */
    public int getDelFlag() {
        return this.delFlag;
    }

    /**
     *
     */
    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    /**
     *
     */
    public String getExpCode() {
        return this.expCode;
    }

    /**
     *
     */
    public void setExpCode(String expCode) {
        this.expCode = expCode;
    }

    /**
     *
     */
    public String getReqIp() {
        return this.reqIp;
    }

    /**
     *
     */
    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    /**
     *
     */
    public String getLogId() {
        return this.logId;
    }

    /**
     *
     */
    public void setLogId(String logId) {
        this.logId = logId;
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
    public String getExpDetail() {
        return this.expDetail;
    }

    /**
     *
     */
    public void setExpDetail(String expDetail) {
        this.expDetail = expDetail;
    }

}
