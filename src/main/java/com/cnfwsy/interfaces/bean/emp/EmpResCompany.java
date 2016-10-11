package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-29 17:00:53
 */
public class EmpResCompany extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private int employeeId;
    /**
     * 公司ID
     */
    private String companyId;
    /**
     * 简历ID
     */
    private String resumeId;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 公司logo
     */
    private String logoPath;
    /**
     * 职位
     */
    private int positionId;
    /**
     * 职位描述
     */
    private String positionName;
    /**
     * 开始年份
     */
    private String companyStartYear;
    /**
     * 开始月份
     */
    private String companyStartMonth;
    /**
     * 结束年份
     */
    private String companyEndYear;
    /**
     * 结束月份
     */
    private String companyEndMonth;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 工作内容
     */
    private String text;
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
    public String getCompanyStartYear() {
        return this.companyStartYear;
    }

    /**
     *
     */
    public void setCompanyStartYear(String companyStartYear) {
        this.companyStartYear = companyStartYear;
    }

    /**
     *
     */
    public String getCompanyEndYear() {
        return this.companyEndYear;
    }

    /**
     *
     */
    public void setCompanyEndYear(String companyEndYear) {
        this.companyEndYear = companyEndYear;
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
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     *
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     *
     */
    public String getLogoPath() {
        return this.logoPath;
    }

    /**
     *
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
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
    public String getCompanyEndMonth() {
        return this.companyEndMonth;
    }

    /**
     *
     */
    public void setCompanyEndMonth(String companyEndMonth) {
        this.companyEndMonth = companyEndMonth;
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
    public String getCompanyId() {
        return this.companyId;
    }

    /**
     *
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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
    public String getText() {
        return this.text;
    }

    /**
     *
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     */
    public String getCompanyStartMonth() {
        return this.companyStartMonth;
    }

    /**
     *
     */
    public void setCompanyStartMonth(String companyStartMonth) {
        this.companyStartMonth = companyStartMonth;
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
