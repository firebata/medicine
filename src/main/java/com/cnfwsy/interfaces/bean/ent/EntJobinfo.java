package com.cnfwsy.interfaces.bean.ent;

import com.cnfwsy.core.bean.BaseForm;

import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-7-20 15:21:09
 */
public class EntJobinfo extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 职位id
     */
    private String jobId;
    /**
     * 职位名
     */
    private String jobName;
    /**
     * 上班地址
     */
    private String address;
    /**
     * 公司id
     */
    private String companyId;
    /**
     * 公司名
     */
    private String companyName;
    /**
     *
     */
    private int provinceId;
    /**
     *
     */
    private String provinceName;
    /**
     * 城市id
     */
    private int cityId;
    /**
     * 城市名
     */
    private String cityName;
    /**
     * 区县id
     */
    private int areaId;
    /**
     * 区县名
     */
    private String areaName;
    /**
     * 职位发布日期
     */
    private String publishDate;
    /**
     * 发布截止日期：请根据实际需求选择截止时间。如不选择，默认60天后下线
     */
    private String endDate;
    /**
     * 职位性质id，值参考字典表，默认全职
     */
    private String jobNatureId;
    /**
     * 职位性质：全职/兼职/实习。默认全职
     */
    private String jobNatureName;
    /**
     * 职位类别，值参考字典表
     */
    private int jobTypeId;
    /**
     * 职位类别
     */
    private String jobTypeName;
    /**
     * 职位子类别id，值参考字典表
     */
    private int jobTypeSubId;
    /**
     * 职位子类别名称
     */
    private String jobTypeSubName;
    /**
     * 删除标志：0正常，1已删除
     */
    private String delFlag;
    /**
     * 记录创建时间
     */
    private Date createTime;
    /**
     * 记录更新时间
     */
    private Date updateTime;
    /**
     * 招聘人数,为0时，页面展示为：招聘若干人，其他数字为：招聘N人
     */
    private int quantity;
    /**
     * 学历要求id，值参考字典表
     */
    private String educationId;
    /**
     * 学历要求
     */
    private String educationName;
    /**
     * 工作经验id，值参考字典表
     */
    private String experienceId;
    /**
     * 工作经验
     */
    private String experienceName;
    /**
     *
     */
    private String titleRequrId;
    /**
     * 职称要求
     */
    private String titleRequr;
    /**
     *
     */
    private String ageRequrId;
    /**
     * 年龄要求
     */
    private String ageRequr;
    /**
     *
     */
    private String proRequrId;
    /**
     * 专业要求
     */
    private String proRequr;
    /**
     * 薪资:年薪或月薪直接表示
     */
    private String payroll;
    /**
     * 月薪id，值参考字典表
     */
    private String monthlyPayId;
    /**
     * 最低月薪(元)
     */
    private int salaryStart;
    /**
     * 最高月薪(元)
     */
    private int salaryEnd;
    /**
     * 职位描述
     */
    private String jobDesc;
    /**
     * 职位福利，职位标签：多个标签已都好分割
     */
    private String jobWelfare;
    /**
     * 职位链接
     */
    private String jobUrl;
    /**
     * 公司链接
     */
    private String comUrl;
    /**
     * 爬虫阶段使用:第三方检索出来的公司id
     */
    private BigInteger thirdId;
    /**
     * 爬虫阶段使用:数据来源51job/liepin/dxy
     */
    private String thirdKind;
    /**
     * 0:爬虫阶段；1:注册绑定（注册账号和公司绑定，允许一个公司多个该状态数据,审核时取最新的数据）；2：审核通过（账号绑定+营业执照审核通过）
     */
    private int status;
    /**
     * 爬虫阶段:0,概要阶段(职位列表)；1，详细阶段
     */
    private int step;

    private String jobMail;

    private String hrMail;

    private EntCompany entCompany;

    private String searchType;

    private int online;

    private String companySizeName;

    private String companyTypeName;

    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    public String getCompanySizeName() {
        return companySizeName;
    }

    public void setCompanySizeName(String companySizeName) {
        this.companySizeName = companySizeName;
    }

    public String getHrMail() {
        return hrMail;
    }

    public String getJobMail() {
        return jobMail;
    }

    public void setJobMail(String jobMail) {
        this.jobMail = jobMail;
    }

    public void setHrMail(String hrMail) {
        this.hrMail = hrMail;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getJobNatureId() {
        return jobNatureId;
    }

    public void setJobNatureId(String jobNatureId) {
        this.jobNatureId = jobNatureId;
    }

    public String getJobNatureName() {
        return jobNatureName;
    }

    public void setJobNatureName(String jobNatureName) {
        this.jobNatureName = jobNatureName;
    }

    public int getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(int jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public String getJobTypeName() {
        return jobTypeName;
    }

    public void setJobTypeName(String jobTypeName) {
        this.jobTypeName = jobTypeName;
    }

    public int getJobTypeSubId() {
        return jobTypeSubId;
    }

    public void setJobTypeSubId(int jobTypeSubId) {
        this.jobTypeSubId = jobTypeSubId;
    }

    public String getJobTypeSubName() {
        return jobTypeSubName;
    }

    public void setJobTypeSubName(String jobTypeSubName) {
        this.jobTypeSubName = jobTypeSubName;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public String getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(String experienceId) {
        this.experienceId = experienceId;
    }

    public String getExperienceName() {
        return experienceName;
    }

    public void setExperienceName(String experienceName) {
        this.experienceName = experienceName;
    }

    public String getTitleRequrId() {
        return titleRequrId;
    }

    public void setTitleRequrId(String titleRequrId) {
        this.titleRequrId = titleRequrId;
    }

    public String getTitleRequr() {
        return titleRequr;
    }

    public void setTitleRequr(String titleRequr) {
        this.titleRequr = titleRequr;
    }

    public String getAgeRequrId() {
        return ageRequrId;
    }

    public void setAgeRequrId(String ageRequrId) {
        this.ageRequrId = ageRequrId;
    }

    public String getAgeRequr() {
        return ageRequr;
    }

    public void setAgeRequr(String ageRequr) {
        this.ageRequr = ageRequr;
    }

    public String getProRequrId() {
        return proRequrId;
    }

    public void setProRequrId(String proRequrId) {
        this.proRequrId = proRequrId;
    }

    public String getProRequr() {
        return proRequr;
    }

    public void setProRequr(String proRequr) {
        this.proRequr = proRequr;
    }

    public String getPayroll() {
        return payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

    public String getMonthlyPayId() {
        return monthlyPayId;
    }

    public void setMonthlyPayId(String monthlyPayId) {
        this.monthlyPayId = monthlyPayId;
    }

    public int getSalaryStart() {
        return salaryStart;
    }

    public void setSalaryStart(int salaryStart) {
        this.salaryStart = salaryStart;
    }

    public int getSalaryEnd() {
        return salaryEnd;
    }

    public void setSalaryEnd(int salaryEnd) {
        this.salaryEnd = salaryEnd;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobWelfare() {
        return jobWelfare;
    }

    public void setJobWelfare(String jobWelfare) {
        this.jobWelfare = jobWelfare;
    }

    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }

    public String getComUrl() {
        return comUrl;
    }

    public void setComUrl(String comUrl) {
        this.comUrl = comUrl;
    }

    public BigInteger getThirdId() {
        return thirdId;
    }

    public void setThirdId(BigInteger thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdKind() {
        return thirdKind;
    }

    public void setThirdKind(String thirdKind) {
        this.thirdKind = thirdKind;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public EntCompany getEntCompany() {
        return entCompany;
    }

    public void setEntCompany(EntCompany entCompany) {
        this.entCompany = entCompany;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}
