package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-27 10:05:24
 */
public class EmpEmployee extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 求职者ID
     */
    private String employeeId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 地区
     */
    private int areaId;
    /**
     * 账号ID
     */
    private String accountId;
    /**
     * 一句话介绍
     */
    private String oneWord;
    /**
     * 当前职位
     */
    private int curPositionId;
    /**
     *
     */
    private String sexName;
    /**
     * 性别
     */
    private int sexId;
    /**
     * 学历
     */
    private int academicId;
    /**
     *
     */
    private String academicName;
    /**
     * 工作年龄
     */
    private int seniorityId;
    /**
     *
     */
    private String seniorityName;
    /**
     * 个人主页
     */
    private String website;
    /**
     * 头像路径
     */
    private String iconPath;
    /**
     * 邮箱
     */
    private String mailBox;
    /**
     * 用户状态
     */
    private int stateId;
    /**
     *
     */
    private String stateName;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 删除标记:默认0,1:删除
     */
    private String delFlag;
    /**
     * 注册时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    private String fileId;


    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     *
     */
    public String getAcademicName() {
        return this.academicName;
    }

    /**
     *
     */
    public void setAcademicName(String academicName) {
        this.academicName = academicName;
    }

    /**
     *
     */
    public String getWebsite() {
        return this.website;
    }

    /**
     *
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     */
    public int getSexId() {
        return this.sexId;
    }

    /**
     *
     */
    public void setSexId(int sexId) {
        this.sexId = sexId;
    }

    /**
     *
     */
    public int getStateId() {
        return this.stateId;
    }

    /**
     *
     */
    public void setStateId(int stateId) {
        this.stateId = stateId;
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
    public int getSeniorityId() {
        return this.seniorityId;
    }

    /**
     *
     */
    public void setSeniorityId(int seniorityId) {
        this.seniorityId = seniorityId;
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
    public String getOneWord() {
        return this.oneWord;
    }

    /**
     *
     */
    public void setOneWord(String oneWord) {
        this.oneWord = oneWord;
    }

    /**
     *
     */
    public int getCurPositionId() {
        return this.curPositionId;
    }

    /**
     *
     */
    public void setCurPositionId(int curPositionId) {
        this.curPositionId = curPositionId;
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
    public String getMailBox() {
        return this.mailBox;
    }

    /**
     *
     */
    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }

    /**
     *
     */
    public int getAcademicId() {
        return this.academicId;
    }

    /**
     *
     */
    public void setAcademicId(int academicId) {
        this.academicId = academicId;
    }

    /**
     *
     */
    public String getStateName() {
        return this.stateName;
    }

    /**
     *
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     *
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     *
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
    public String getSexName() {
        return this.sexName;
    }

    /**
     *
     */
    public void setSexName(String sexName) {
        this.sexName = sexName;
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
    public String getIconPath() {
        return this.iconPath;
    }

    /**
     *
     */
    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    /**
     *
     */
    public String getSeniorityName() {
        return this.seniorityName;
    }

    /**
     *
     */
    public void setSeniorityName(String seniorityName) {
        this.seniorityName = seniorityName;
    }

}
