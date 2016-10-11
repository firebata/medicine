package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-7-1 10:50:07
 */
public class EmpResEdu extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 学校ID
     */
    private String universityId;
    /**
     * 简历ID
     */
    private String resumeId;
    /**
     * 学校名称
     */
    private String universityName;
    /**
     * 专业ID
     */
    private int specialityId;
    /**
     *
     */
    private String specialityName;
    /**
     *
     */
    private String startYear;
    /**
     *
     */
    private String endYear;
    /**
     * 毕业时间
     */
    private Date graduateDate;
    /**
     * 学历ID
     */
    private int academicId;
    /**
     *
     */
    private String academicName;
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
    public String getUniversityName() {
        return this.universityName;
    }

    /**
     *
     */
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
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
    public String getStartYear() {
        return this.startYear;
    }

    /**
     *
     */
    public void setStartYear(String startYear) {
        this.startYear = startYear;
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
    public String getEndYear() {
        return this.endYear;
    }

    /**
     *
     */
    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    /**
     *
     */
    public String getUniversityId() {
        return this.universityId;
    }

    /**
     *
     */
    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    /**
     *
     */
    public Date getGraduateDate() {
        return this.graduateDate;
    }

    /**
     *
     */
    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
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
    public String getSpecialityName() {
        return this.specialityName;
    }

    /**
     *
     */
    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
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
    public int getSpecialityId() {
        return this.specialityId;
    }

    /**
     *
     */
    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

}
