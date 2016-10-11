package com.cnfwsy.interfaces.bean.ent;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.interfaces.bean.emp.EmpEmployee;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-7-28 0:36:59
 */
public class EntResume extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 简历ID
     */
    private String resumeId;
    /**
     * 职位ID
     */
    private String jobId;
    /**
     * 状态:0下线,1上线
     */
    private int statusId;
    /**
     * 刷新时间
     */
    private Date refreshTime;
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
     * 公司ID
     */
    private String companyId;
    /**
     *
     */
    private String employeeId;
    /**
     *
     */
    private String accountId;

//    private EntJobinfo entJobinfo;
//
//    private EmpEmployee empEmployee;

    private String name;
    private String oneWord;
    private int curPositionId;
    private String sexName;
    private int sexId;
    private int academicId;
    private String academicName;
    private int areaId;
    private int seniorityId;
    private String seniorityName;
    private String stateName;
    private String iconPath;
    private String website;
    private String phone;
    private String mailBox;
    private int stateId;
    private String jobName;

    private String codeJobId;
    private String codeCompanyId;

    public String getCodeJobId() {
        return codeJobId;
    }

    public void setCodeJobId(String codeJobId) {
        this.codeJobId = Base64Utils.encode(codeJobId);
    }

    public String getCodeCompanyId() {
        return codeCompanyId;
    }

    public void setCodeCompanyId(String codeCompanyId) {
        this.codeCompanyId = Base64Utils.encode(codeCompanyId);
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOneWord() {
        return oneWord;
    }

    public void setOneWord(String oneWord) {
        this.oneWord = oneWord;
    }

    public int getCurPositionId() {
        return curPositionId;
    }

    public void setCurPositionId(int curPositionId) {
        this.curPositionId = curPositionId;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public int getSexId() {
        return sexId;
    }

    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    public int getAcademicId() {
        return academicId;
    }

    public void setAcademicId(int academicId) {
        this.academicId = academicId;
    }

    public String getAcademicName() {
        return academicName;
    }

    public void setAcademicName(String academicName) {
        this.academicName = academicName;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getSeniorityId() {
        return seniorityId;
    }

    public void setSeniorityId(int seniorityId) {
        this.seniorityId = seniorityId;
    }

    public String getSeniorityName() {
        return seniorityName;
    }

    public void setSeniorityName(String seniorityName) {
        this.seniorityName = seniorityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }

    /**
     *
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     *
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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
    public Date getRefreshTime() {
        return this.refreshTime;
    }

    /**
     *
     */
    public void setRefreshTime(Date refreshTime) {
        this.refreshTime = refreshTime;
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
