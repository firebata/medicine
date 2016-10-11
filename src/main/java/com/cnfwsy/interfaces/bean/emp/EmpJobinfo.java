package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-7-28 0:36:59
 */
public class EmpJobinfo extends BaseForm {
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
     * 公司id
     */
    private String companyId;
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
     * 0:爬虫阶段；1:注册绑定（注册账号和公司绑定，允许一个公司多个该状态数据,审核时取最新的数据）；2：审核通过（账号绑定+营业执照审核通过）
     */
    private int status;
    /**
     *
     */
    private String employeeId;
    /**
     *
     */
    private String accountId;
    /**
     *
     */
    private String resumeId;

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    /**
     *
     */
    public String getJobName() {
        return this.jobName;
    }

    /**
     *
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     *
     */
    public String getJobId() {
        return this.jobId;
    }

    /**
     *
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
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
    public String getaccountId() {
        return this.accountId;
    }

    /**
     *
     */
    public void setaccountId(String accountId) {
        this.accountId = accountId;
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
