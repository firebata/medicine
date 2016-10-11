package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class EmpResume extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private String resumeId;
    /**
     *
     */
    private String employeeId;
    /**
     * 简历状态
     */
    private int statusId;
    /**
     * 删除标记:默认0,1:删除
     */
    private String delFlag;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    public String getResumeId() {
        return this.resumeId;
    }

    /**
     *
     */
    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    /**
     *
     */
    public int getStatusId() {
        return this.statusId;
    }

    /**
     *
     */
    public void setStatusId(int statusId) {
        this.statusId = statusId;
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
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     *
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
    public String getDelFlag() {
        return this.delFlag;
    }

    /**
     *
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}
