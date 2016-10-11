package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class EmpResProject extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 项目ID
     */
    private BigInteger projectId;
    /**
     * 简历ID
     */
    private BigInteger resumeId;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 职责ID
     */
    private int dutyId;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 描述
     */
    private String description;
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
    public BigInteger getResumeId() {
        return this.resumeId;
    }

    /**
     *
     */
    public void setResumeId(BigInteger resumeId) {
        this.resumeId = resumeId;
    }

    /**
     *
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     *
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    public String getName() {
        return this.name;
    }

    /**
     *
     */
    public void setName(String name) {
        this.name = name;
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
    public int getDutyId() {
        return this.dutyId;
    }

    /**
     *
     */
    public void setDutyId(int dutyId) {
        this.dutyId = dutyId;
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

    /**
     *
     */
    public BigInteger getProjectId() {
        return this.projectId;
    }

    /**
     *
     */
    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    /**
     *
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     *
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
