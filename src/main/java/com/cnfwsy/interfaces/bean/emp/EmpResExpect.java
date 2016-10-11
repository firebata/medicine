package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-28 16:46:35
 */
public class EmpResExpect extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private int employeeId;
    /**
     * 期望工作ID
     */
    private String expectId;
    /**
     * 简历ID
     */
    private String resumeId;
    /**
     * 职位ID
     */
    private int positionId;
    /**
     * 职位描述
     */
    private String positionName;
    /**
     * 补充内容
     */
    private String description;
    /**
     * 城市
     */
    private int areaId;
    /**
     * 城市描述
     */
    private String areaName;
    /**
     * 工作性质
     */
    private int typeId;
    /**
     * 工作性质描述
     */
    private String typeName;
    /**
     * 薪酬
     */
    private int salaryId;
    /**
     * 薪酬 描述
     */
    private String salaryName;
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
    public String getTypeName() {
        return this.typeName;
    }

    /**
     *
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     *
     */
    public String getSalaryName() {
        return this.salaryName;
    }

    /**
     *
     */
    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
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
    public int getEmployeeId() {
        return this.employeeId;
    }

    /**
     *
     */
    public void setEmployeeId(int employeeId) {
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
    public String getExpectId() {
        return this.expectId;
    }

    /**
     *
     */
    public void setExpectId(String expectId) {
        this.expectId = expectId;
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
    public String getPositionName() {
        return this.positionName;
    }

    /**
     *
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     *
     */
    public int getAreaId() {
        return this.areaId;
    }

    /**
     *
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

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
    public int getPositionId() {
        return this.positionId;
    }

    /**
     *
     */
    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    /**
     *
     */
    public String getAreaName() {
        return this.areaName;
    }

    /**
     *
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
    public int getTypeId() {
        return this.typeId;
    }

    /**
     *
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
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
    public int getSalaryId() {
        return this.salaryId;
    }

    /**
     *
     */
    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

}
